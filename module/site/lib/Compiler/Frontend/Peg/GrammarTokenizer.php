<?php declare(strict_types=1);
/**
 * This file is part of njcom/framework
 * It is distributed under the 'Apache License Version 2.0' license.
 * See the https://github.com/njcom/framework/blob/main/LICENSE for the full license text.
 */
namespace Morpho\Compiler\Frontend\Peg;

require_once __DIR__ . '/../index.php';

use Generator;
use Morpho\Base\Must;
use Morpho\Base\NotImplementedException;
use RuntimeException;
use UnexpectedValueException;
use Morpho\Base\Result;
use Morpho\Base\Err;
use Morpho\Base\Ok;

use function Morpho\Base\mkStream;

/**
 * Based on https://github.com/python/cpython/blob/fc94d55ff453a3101e4c00a394d4e38ae2fece13/Lib/tokenize.py
 */
class GrammarTokenizer {
    /**
     * @param string|resource $stream
     * @throws \Morpho\Compiler\Frontend\Peg\TokenException
     * @throws \Morpho\Compiler\Frontend\Peg\IndentationException
     * @throws \UnexpectedValueException
     * @throws \Morpho\Base\NotImplementedException
     * @throws \RuntimeException
     * @return \Generator<mixed, Token, mixed, void>
     */
    public function __invoke($stream): Generator {
        if (is_string($stream)) {
            $stream = mkStream($stream);
        }

        if (stream_get_meta_data($stream)['seekable']) {
            rewind($stream);
        }

        $pseudoTokenRe = GrammarTokenizerRe::pseudoTokenRe();
        $tripleQuoted = GrammarTokenizerRe::tripleQuotedPrefixes();
        $singleQuoted = GrammarTokenizerRe::singleQuotedPrefixes();
        $endPatterns = GrammarTokenizerRe::endPatterns();

        $lineNum = $parenLevel = 0;
        $numChars = '0123456789';
        $continuedStr = '';
        $needCont = false;
        $contLine = null;
        $indents = [0];
        $line = '';
        $endProgRe = null;
        $strStart = [0, 0];
        $tabSize = 4;

        // States as variables
        $continuedStatement = false;
        //$grammarActionState = GrammarActionState::Unknown;
        while (true) { // Loop over lines in stream
            $lastLine = $line;
            //$prevStreamOffset = ftell($stream);
            $line = fgets($stream);
            $lineNum++;
            $offsetInCurrentLine = $lineLen = 0;
            if (false !== $line) {
                $lineLen = mb_strlen($line);
            }

            if ($continuedStr !== '') { // 1. Continued string
                if (false === $line) {
                    throw new TokenException("EOF in multi-line string", $strStart);
                }
                if (preg_match('~' . $endProgRe . '~AsDu', $line, $match, 0, $offsetInCurrentLine)) {
                    $offsetInCurrentLine = $endOffset = mb_strlen($match[0]);
                    /** @var int $endOffset */
                    yield new Token(TokenType::String, $continuedStr . mb_substr($line, 0, $endOffset), $strStart, [$lineNum, $endOffset], $contLine . $line);
                    $continuedStr = '';
                    $needCont = false;
                    $contLine = null;
                } elseif ($needCont && !str_ends_with($line, "\\\n") && !str_ends_with($line, "\\\r\n")) {
                    yield new Token(TokenType::ErrorMarker, $continuedStr . $line, $strStart, [$lineNum, mb_strlen($line)], $contLine);
                    $continuedStr = '';
                    $contLine = null;
                    continue;
                } else {
                    $continuedStr .= $line;
                    $contLine = $contLine . $line;
                    continue;
                }
            } elseif ($parenLevel === 0 && !$continuedStatement) { // 2. New statement
                if ($line === '') {
                    break;
                }
                $column = 0;
                while ($offsetInCurrentLine < $lineLen) { // Measure leading whitespace
                    if ($line[$offsetInCurrentLine] === ' ') {
                        $column++;
                    } elseif ($line[$offsetInCurrentLine] === "\t") {
                        $column = (floor($column / $tabSize) + 1) * $tabSize;
                    } elseif ($line[$offsetInCurrentLine] === "\f") {
                        $column = 0;
                    } else {
                        break;
                    }
                    $offsetInCurrentLine++;
                }
                if ($offsetInCurrentLine === $lineLen) {
                    break;
                }
                if (str_contains("#\r\n", $line[$offsetInCurrentLine])) { // Skip comments or blank lines
                    if ($line[$offsetInCurrentLine] === '#') {
                        $commentToken = rtrim(mb_substr($line, $offsetInCurrentLine), "\r\n");
                        yield new Token(TokenType::Comment, $commentToken, [$lineNum, $offsetInCurrentLine], [$lineNum, $offsetInCurrentLine + mb_strlen($commentToken)], $line);
                        $offsetInCurrentLine += mb_strlen($commentToken);
                    }
                    yield new Token(TokenType::ContinuedNewLine, mb_substr($line, $offsetInCurrentLine), [$lineNum, $offsetInCurrentLine], [$lineNum, mb_strlen($line)], $line);
                    continue;
                }
                if ($column > $indents[count($indents) - 1]) { // Count indents or dedents
                    $indents[] = $column;
                    yield new Token(TokenType::Indent, mb_substr($line, 0, $offsetInCurrentLine), [$lineNum, 0], [$lineNum, $offsetInCurrentLine], $line);
                }
                while ($column < $indents[count($indents) - 1]) {
                    if (!in_array($column, $indents)) {
                        throw new IndentationException("Unindent does not match any outer indentation level", $lineNum, $offsetInCurrentLine, $line);//, $line);
                    }
                    $indents = array_slice($indents, 0, -1);
                    yield new Token(TokenType::Dedent, '', [$lineNum, $offsetInCurrentLine], [$lineNum, $offsetInCurrentLine], $line);
                }
            } else { // 3. Continued statement
                if ('' === $line) {
                    throw new TokenException("EOF in multi-line statement", [$lineNum, 0]);
                }
                $continuedStatement = false;
            }

            while ($offsetInCurrentLine < $lineLen) {
                if (preg_match('~' . $pseudoTokenRe . '~AsDu', $line, $match, PREG_OFFSET_CAPTURE, $offsetInCurrentLine)) {
                    /** @var int $startOffset */
                    $startOffset = $match[1][1];
                    $endOffset = $startOffset + mb_strlen($match[1][0]);
                    $startLocation = [$lineNum, $startOffset];
                    $endLocation = [$lineNum, $endOffset];
                    $offsetInCurrentLine = $endOffset;
                    if ($startOffset === $endOffset) {
                        continue;
                    }
                    $tokenValue = mb_substr($line, $startOffset, $endOffset - $startOffset);
                    $firstCharOfToken = mb_substr($line, $startOffset, 1);

                    if (str_contains($numChars, $firstCharOfToken) || ($firstCharOfToken === '.' && $tokenValue != '.' && $tokenValue != '...')) {
                        yield new Token(TokenType::Number, $tokenValue, $startLocation, $endLocation, $line);
                    } elseif (str_contains("\r\n", $firstCharOfToken)) {
                        if ($parenLevel > 0) {
                            yield new Token(TokenType::ContinuedNewLine, $tokenValue, $startLocation, $endLocation, $line);
                        } else {
                            yield new Token(TokenType::NewLine, $tokenValue, $startLocation, $endLocation, $line);
                        }
                    } elseif ($firstCharOfToken == '#') {
                        Must::beTruthy(!str_ends_with($tokenValue, "\n"));
                        yield new Token(TokenType::Comment, $tokenValue, $startLocation, $endLocation, $line);
                    } elseif (in_array($tokenValue, $tripleQuoted)) {
                        $endProgRe = $endPatterns[$tokenValue];
                        if (preg_match('~' . $endProgRe . '~AsDu', $line, $match, PREG_OFFSET_CAPTURE, $offsetInCurrentLine)) { // All on one line
                            if (count($match) !== 1) {
                                throw new UnexpectedValueException();
                            }
                            $offsetInCurrentLine = mb_strlen($match[0]);
                            $tokenValue = mb_substr($line, $startOffset, $endOffset - $startOffset);
                            yield new Token(TokenType::String, $tokenValue, $startLocation, [$lineNum, $offsetInCurrentLine], $line);
                        } else {
                            $strStart = [$lineNum, $startOffset]; // Multiple lines
                            $continuedStr = mb_substr($line, $startOffset);
                            $contLine = $line;
                            break;
                        }
                        // Check up to the first 3 chars of the token to see if they're in the single_quoted set. If so, they start a string. We're using the first 3, because we're looking for "rb'" (for example) at the start of the token. If we switch to longer prefixes, this needs to be adjusted. Note that firstCharOfToken == token[:1]. Also note that single quote checking must come after triple quote checking (above).
                    } elseif (in_array($firstCharOfToken, $singleQuoted) || in_array(mb_substr($tokenValue, 0, 2), $singleQuoted) || in_array(mb_substr($tokenValue, 0, 3), $singleQuoted)) {
                        if (str_ends_with($tokenValue, "\n")) { // continued string
                            $strStart = [$lineNum, $startOffset];
                            // Again, using the first 3 chars of the token. This is looking for the matching end regex for the correct type of quote character. So it's really looking for endpats["'"] or endpats['"'], by trying to skip string prefix characters, if any.
                            if (isset($endPatterns[$firstCharOfToken])) {
                                $endProgRe = $endPatterns[$firstCharOfToken];
                            } elseif (isset($endPatterns[$tokenValue[1]])) {
                                $endProgRe = $endPatterns[$tokenValue[1]];
                            } elseif (isset($endPatterns[$tokenValue[2]])) {
                                $endProgRe = $endPatterns[$tokenValue[2]];
                            } else {
                                throw new UnexpectedValueException();
                            }
                            $continuedStr = mb_substr($line, $startOffset);
                            $needCont = true;
                            $contLine = $line;
                            break;
                        } else {
                            yield new Token(TokenType::String, $tokenValue, $startLocation, $endLocation, $line); // Ordinary string
                        }
                    } elseif (preg_match('~^[a-z_][a-z_0-9]*$~AsDui', $firstCharOfToken)) { // Name (identifer). @todo: support non ASCII identifiers https://docs.python.org/3/reference/lexical_analysis.html#identifiers
                        yield new Token(TokenType::Name, $tokenValue, $startLocation, $endLocation, $line);
                    } elseif ($firstCharOfToken == '\\') { // Continued statement
                        $continuedStatement = true;
                    } else {
                        if (str_contains('([{', $firstCharOfToken)) {
                            $parenLevel++;
                        } elseif (str_contains(')]}', $firstCharOfToken)) {
                            $parenLevel--;
                        }
                        yield new Token(TokenType::Op, $tokenValue, $startLocation, $endLocation, $line);

                        if ($firstCharOfToken === '{') { // Handle PHP-code in the action
                            $startLocation = $endLocation;
                            $result = self::readGrammarAction($stream, $line, $endLocation);
                            if ($result->isOk()) {
                                [$stream, $tokenValue, $line, $endLocation] = $result->value();
                                $lineLen = mb_strlen($line);
                                [$lineNum, $offsetInCurrentLine] = $endLocation;
                                yield new Token(TokenType::GrammarAction, $tokenValue, $startLocation, $endLocation, $line);
                            } else {
                                throw new NotImplementedException('@todo: generate ErrorMarker');
                            }
                        }
                    }
                } else {
                    yield new Token(TokenType::ErrorMarker, $line[$offsetInCurrentLine], [$lineNum, $offsetInCurrentLine], [$lineNum, $offsetInCurrentLine + 1], $line);
                    $offsetInCurrentLine++;
                }
            }
        }
        // Add an implicit new line if the input doesn't end in one.
        if (false !== $lastLine && strlen($lastLine) && !(str_ends_with($lastLine, "\r") || str_ends_with($lastLine, "\n") || str_ends_with($lastLine, "\r\n")) && !str_starts_with(trim($lastLine), '#')) {
            yield new Token(TokenType::NewLine, '', [$lineNum - 1, mb_strlen($lastLine)], [$lineNum - 1, mb_strlen($lastLine) + 1], $lastLine);
        }
        foreach (array_slice($indents, 1) as $_) { // Pop remaining indent levels
            yield new Token(TokenType::Dedent, '', [$lineNum, 0], [$lineNum, 0], '');
        }
        yield new Token(TokenType::EndMarker, '', [$lineNum, 0], [$lineNum, 0], '');
        if (!feof($stream)) {
            throw new RuntimeException('Unexpected end of the stream');
        }
        fclose($stream);
    }

    private static function readGrammarAction($stream, string $line, array $startLocation): Result {
        $braceLevel = 1;
        $tokenValue = '';
        $readLine = false;
        [$lineNum, $offsetInCurrentLine] = $startLocation;
        $lineLen = mb_strlen($line);
        while (true) {
            if ($readLine) {
                $line = fgets($stream);
                if ($line === false) {
                    return new Err('todo');
                }
                $offsetInCurrentLine = 0;
                $lineNum++;
                $lineLen = mb_strlen($line);
                $readLine = false;
            }
            while ($offsetInCurrentLine < $lineLen) {
                $char = $line[$offsetInCurrentLine];
                if ($char === '{') {
                    $braceLevel++;
                } elseif ($char === '}') {
                    $braceLevel--;
                    if ($braceLevel === 0) {
                        return new Ok([$stream, $tokenValue, $line, [$lineNum, $offsetInCurrentLine]]);
                    }
                } elseif (str_contains("\r\n", $char)) {
                    $readLine = true;
                }
                $tokenValue .= $char;
                $offsetInCurrentLine++;
            }
            if (!$readLine) {
                return new Err('todo');
            }
        }
    }
}
