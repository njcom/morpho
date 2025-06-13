<?php declare(strict_types=1);
/**
 * This file is part of njcom/framework
 * It is distributed under the 'Apache License Version 2.0' license.
 * See the https://github.com/njcom/framework/blob/main/LICENSE for the full license text.
 */
namespace Morpho\Tool\Fasm;

use Morpho\Base\Result;
use Morpho\Compiler\Frontend\MbStringReader;
use Morpho\Compiler\Frontend\IStringReader;
use Morpho\Compiler\Frontend\Re;
use IteratorAggregate;
use const Morpho\Base\EOL_RE;
use function Morpho\Base\q;
use Traversable;
use Morpho\Compiler\Frontend\SyntaxError;
use Morpho\Base\NotImplementedException;
use Morpho\Compiler\Frontend\Peg\Tokenizer as BaseTokenizer;
use Morpho\Compiler\Frontend\Peg\Token;

class Tokenizer implements IteratorAggregate {
    private $stream;

    public function __construct($stream) {
        $this->stream = $stream;
    }

    public function getIterator(): Traversable {
        $stream = $this->stream;
        if (stream_get_meta_data($stream)['seekable']) {
            rewind($stream);
        }
        $lineNum = 0;
        $keywordsLike = [
            'include' => TokenType::IncludeKeyword,
            'org' => TokenType::OrgKeyword,
            '$$' => TokenType::BaseAddress,
            '$' => TokenType::CurrentAddress,
            '%' => TokenType::SpecialParameter1,
            '%%' => TokenType::SpecialParameter2,
        ];
        $specialChars = [
            '!' => TokenType::ExclamationSpecial,
            '#' => TokenType::HashSpecial,
            '&' => TokenType::AmpersandSpecial,
            '(' => TokenType::LeftParenSpecial,
            ')' => TokenType::RightParenSpecial,
            '*' => TokenType::StarSpecial,
            '+' => TokenType::PlusSpecial,
            ',' => TokenType::CommaSpecial,
            '-' => TokenType::MinusSpecial,
            '.' => TokenType::DotSpecial,
            '/' => TokenType::SlashSpecial,
            ':' => TokenType::ColonSpecial,
            '<' => TokenType::LessThanSpecial,
            '=' => TokenType::EqualsSpecial,
            '>' => TokenType::GreaterThanSpecial,
            '?' => TokenType::QuestionSpecial,
            '[' => TokenType::LeftBracketSpecial,
            '\\' => TokenType::BackslashSpecial,
            ']' => TokenType::RightBracketSpecial,
            '`' => TokenType::BacktickSpecial,
            '{' => TokenType::LeftBraceSpecial,
            '|' => TokenType::PipeSpecial,
            '}' => TokenType::RightBraceSpecial,
            '~' => TokenType::TildeSpecial,
        ];
        while (true) {
            $line = fgets($stream);
            if (false === $line) {
                break;
            }
            if (trim($line) === '') {
                continue;
            }
            $lineNum++;

            $reader = new MbStringReader($line);
            while (!$reader->isEnd()) {
                $reader->read('~[ \f\t]+~'); // Skip whitespaces
                $pos = $reader->offset();
                $lexeme = $reader->read('~[^\s' . preg_quote(implode('', array_keys($specialChars)), '~') . ']+~');
                if (null !== $lexeme) {
                    $firstChar = mb_substr($lexeme, 0, 1);
                    if ($firstChar === ';') {
                        $reader->unread();
                        $lexeme = $reader->readUntil('~' . EOL_RE . '~');
                        yield new Token(TokenType::Comment, $lexeme, [$lineNum, $pos], [$lineNum, $reader->matchLen()], $line);
                        continue;
                    } elseif ($firstChar === "'") {
                        $reader->unread();
                        $value = $reader->read('~' . Re::SINGLE_QUOTED_STRING . '~');
                        yield new Token(TokenType::SingleQuotedString, mb_substr(mb_substr($value, 0, -1), 1), [$lineNum, $pos], [$lineNum, $reader->matchLen()], $line);
                        continue;
                    } elseif ($firstChar === '"')  {
                        $reader->unread();
                        throw new NotImplementedException();
                        $value = $reader->read('~' . Re::DOUBLE_QUOTED_STRING . '~');
                        yield new Token(TokenType::DoubleQuotedString, mb_substr(mb_substr($value, 0, -1), 1), [$lineNum, 1], [$lineNum, 1], $line);
                        continue;
                    } elseif (isset($keywordsLike[$lexeme])) {
                        yield new Token($keywordsLike[$lexeme], $lexeme, [$lineNum, $pos], [$lineNum, $reader->matchLen()], $line);
                        continue;
                    } elseif (preg_match('~^(\d[\d_]*d?|0[0-7_]+[oq]|[01_]+b|\$[0-9a-f_]+|0x[0-9a-f_]+|\d[\da-f_]*h)$~si', $lexeme)) {
                        yield new Token(TokenType::Number, $lexeme, [$lineNum, $pos], [$lineNum, $reader->matchLen()], $line);
                        continue;
                    } elseif (preg_match('~^[@%_.a-z0-9#?]+$~si', $lexeme)) {
                        yield new Token(TokenType::Identifier, $lexeme, [$lineNum, $pos], [$lineNum, $reader->matchLen()], $line);
                        continue;
                    }
                } elseif ($lexeme = $reader->read('~' . EOL_RE . '~')) {
                    yield new Token(TokenType::NewLine, $lexeme, [$lineNum, $pos], [$lineNum, $reader->matchLen()], $line);
                    continue;
                } else {
                    $nextChar = $reader->peek(1);
                    if (isset($specialChars[$nextChar])) {
                        $reader->char();
                        yield new Token($specialChars[$nextChar], $nextChar, [$lineNum, $pos], [$lineNum, $reader->matchLen()], $line);
                        continue;
                    }
                }
                throw new \UnexpectedValueException('Unable to tokenize. Line: ' . $lineNum . ', lexeme: ' . q($lexeme));
            }
        }
    }
}