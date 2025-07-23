<?php declare(strict_types=1);
/**
 * This file is part of njcom/framework
 * It is distributed under the 'Apache License Version 2.0' license.
 * See the https://github.com/njcom/framework/blob/main/LICENSE for the full license text.
 */
namespace Morpho\Compiler\Frontend\Peg;

use Morpho\Base\NotImplementedException;
use UnexpectedValueException;
use function Morpho\Base\enumVals;
use function Morpho\Base\mkStream;
use function Morpho\Tool\Php\parse;
use function Morpho\Tool\Php\ppFile;
use function Morpho\Tool\Php\pp;

/**
 * PEG (Parsing Expression Grammar): parser generator, generate recursive descent parser by a grammar.
 * https://peps.python.org/pep-0617/
 * https://github.com/python/cpython/blob/3.12/Tools/peg_generator/pegen/testutil.py
 */
class Peg {
    public const int FORMAT_NONE = 0;
    public const int FORMAT_AS_FRAGMENT = 1;
    public const int FORMAT_AS_FILE = 2;

    /**
     * Creates Grammar AST from grammar code.
     * @param resource|string $grammarCode
     */
    public static function parseGrammar($grammarCode): Grammar {
        return self::runParser(
            new GrammarParser(self::tokenizeGrammar($grammarCode))
        );
    }

    public static function tokenizeGrammar($grammarCode): ITokenizer {
        return new Tokenizer(new GrammarTokenizer()->__invoke($grammarCode));
    }

    /**
     * @param string|\Morpho\Compiler\Frontend\Peg\Grammar $programGrammar
     * @param \Morpho\Compiler\Frontend\Peg\ITokenizer $programTokenizer
     * @param array|null $programParserGeneratorConf
     *     generatedCodeFormat:
     *         0: none
     *         1: format as fragment
     *         2: format as file
     * @param mixed $generatedCodeFormat
     * @return array<mixed|Parser>
     */
    public static function parseProgram(string|Grammar $programGrammar, ITokenizer $programTokenizer, array|null $programParserGeneratorConf = null, int $format = self::FORMAT_AS_FRAGMENT): array {
        if (!is_object($programGrammar)) {
            $programGrammar = self::parseGrammar($programGrammar);
        }
        [$parserClass, $parserCode] = self::generateParserCode($programGrammar, $programParserGeneratorConf, $format);
        $parser = self::evalParserCode($parserClass, $parserCode, $programTokenizer, $format);
        return [$parser, $parserCode];
    }

    public static function runParser(Parser $parser): mixed {
        $tree = $parser->start();
        if (!$tree) {
            throw $parser->mkSyntaxError('Invalid syntax');
        }
        return $tree;
    }

    public static function generateParserCode(Grammar $grammar, array|null $parserGeneratorConf, int $format): array {
        $targetProgramStream = mkStream('');
        $parserGenerator = self::mkParserGenerator($grammar, $targetProgramStream);
        $parserClass = $parserGenerator->generate($parserGeneratorConf);
        $parserCode = stream_get_contents($targetProgramStream, offset: 0);
        if ($format) {
            $parserCode = self::prettyPrintCode($parserCode, $format);
        }
        return [$parserClass, $parserCode];
    }

    public static function generateParserFile(Grammar $grammar, string $targetFilePath, array|null $parserGeneratorConf = null): string {
        [$parserClass, $parserCode] = self::generateParserCode($grammar, $parserGeneratorConf, self::FORMAT_AS_FILE);
        file_put_contents($targetFilePath, $parserCode);
        return $parserClass;
    }

    public static function mkParserGenerator(Grammar $grammar, $stream, $ruleChecker = null) {
        return new ParserGenerator($grammar, $stream, $ruleChecker ?? new RuleCheckingVisitor(array_keys(enumVals(TokenType::class))));
    }

    /**
     * E.g. Peg::prettyPrintTokens(Peg::mkGrammarTokenizer($grammarCode))
     * 
     * @param iterable $tokens
     * @return string
     */
    public static function prettyPrintTokens(iterable $tokens): string {
        $output = '';
        foreach ($tokens as $token) {
            $output .= (string) $token . "\n";
        }
        return $output;
    }

    /**
     * ast.literal_eval() in Python
     */
    public static function literalEval(string $literal): string {
        // Handle ''' and """ Python strings
        if (preg_match('~^(\'\'\'|""")(?P<value>.*)(\\1)$~s', $literal, $match)) {
            $literal = '"' . $match['value'] . '"';
        }
        if ($literal === "''" || $literal === '""') {
            return '';
        }
        /*        try {
                    return eval('return ' . $literal . ';');
                } catch (\ParseError $e) {
                    d($literal);
                }*/
        return eval('return ' . $literal . ';');
    }
    
    private static function prettyPrintCode(string $code, int $format): string {
        if ($format & self::FORMAT_AS_FRAGMENT) {
            return pp(parse($code));
        }
        if ($format && self::FORMAT_AS_FILE) {
            return ppFile(parse($code), false);
        }
        throw new UnexpectedValueException();
    }
    
    private static function evalParserCode(string $parserClass, string $parserCode, ITokenizer $programTokenizer, int $format): Parser {
        if ($format & self::FORMAT_AS_FILE) {
            eval('?>' . $parserCode);
        } elseif (!$format || ($format & self::FORMAT_AS_FRAGMENT)) {
            eval($parserCode);
        } else {
            throw new UnexpectedValueException();
        }
        return new $parserClass($programTokenizer);
    }
}