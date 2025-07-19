<?php declare(strict_types=1);
/**
 * This file is part of njcom/framework
 * It is distributed under the 'Apache License Version 2.0' license.
 * See the https://github.com/njcom/framework/blob/main/LICENSE for the full license text.
 */
namespace Morpho\Compiler\Frontend\Peg;

use Traversable;

use UnexpectedValueException;

use Morpho\Base\NotImplementedException;
use function Morpho\Base\enumVals;
use function Morpho\Tool\Php\parse;
use function Morpho\Base\mkStream;
use function Morpho\Tool\Php\pp;
use function Morpho\Tool\Php\ppFile;

/**
 * PEG (Parsing Expression Grammar): parser generator, generate recursive descent parser by a grammar.
 * https://peps.python.org/pep-0617/
 * https://github.com/python/cpython/blob/3.12/Tools/peg_generator/pegen/testutil.py
 */
class Peg {
    public const int FORMAT_NONE = 0;
    public const int FORMAT_AS_FRAGMENT = 1;
    public const int FORMAT_AS_FILE = 2;

    public static function prettyPrintTokens(iterable $tokenizer): string {
        $output = '';
        foreach ($tokenizer as $token) {
            $output .= (string) $token . "\n";
        }
        return $output;
    }

    /**
     * @param string|resource $grammarCode
     */
    public static function prettyPrintGrammarTokens($grammarCode): string {
        return self::prettyPrintTokens(self::mkGrammarTokenizer($grammarCode));
    }

   /**
     * @param string|resource $grammarCode
     * @return \Morpho\Compiler\Frontend\Peg\ITokenizer
     */
    public static function mkGrammarTokenizer($grammarCode): ITokenizer {
        return new Tokenizer(GrammarTokenizer::tokenize($grammarCode));
    }

    /**
     * Creates Grammar AST from grammar code.
     * @param resource|string $grammarCode
     */
    public static function parseGrammar($grammarCode): Grammar {
        $grammarTokenizer = self::mkGrammarTokenizer($grammarCode);
        return self::runParser(new GrammarParser($grammarTokenizer));
    }

    public static function parseProgram(string|Grammar $grammar, ITokenizer $programTokenizer, array|null $parserGeneratorConf = null) {
        if (!is_object($grammar)) {
            $grammar = self::parseGrammar($grammar);
        }
        [$parserClass, $parserCode] = self::generateParserCode($grammar, $parserGeneratorConf);
        $programParser = self::evalParserCode($parserClass, $parserCode, $programTokenizer);
        return self::runParser($programParser);
    }

    public static function mkParserGenerator(Grammar $grammar, $stream, $ruleChecker = null) {
        return new ParserGenerator($grammar, $stream, $ruleChecker ?? new RuleCheckingVisitor(array_keys(enumVals(TokenType::class))));
    }

    public static function generateParserCode(Grammar $grammar, $parserGenerator = null, array|null $parserGeneratorConf = null, int $format = self::FORMAT_AS_FRAGMENT): array {
        $targetProgramStream = mkStream('');
        if (!$parserGenerator) {
            $parserGenerator = self::mkParserGenerator($grammar, $targetProgramStream);
        }
        $parserClass = $parserGenerator->generate($parserGeneratorConf);
        $parserCode = stream_get_contents($targetProgramStream, offset: 0);
        if ($parserCode === '') {
            throw new UnexpectedValueException();
        }
        if ($format & self::FORMAT_AS_FILE) {
            return [$parserClass, ppFile(parse($parserCode))];
        }
        if ($format & self::FORMAT_AS_FRAGMENT) {
            return [$parserClass, pp(parse($parserCode))];
        }
        return [$parserClass, $parserCode];
    }

    public static function generateParserFile(Grammar $grammar, string $targetFilePath, array|null $parserGeneratorConf = null): string {
        [$parserClass, $parserCode] = self::generateParserCode($grammar, parserGeneratorConf: $parserGeneratorConf, format: self::FORMAT_AS_FILE);
        file_put_contents($targetFilePath, $parserCode);
        return $parserClass;
    }

    public static function evalParserCode(string $parserClass, string $parserCode, ITokenizer $programTokenizer) {
        eval($parserCode);
        return new $parserClass($programTokenizer);
    }

    public static function runParser(Parser $parser): mixed {
        $tree = $parser->start();
        if (!$tree) {
            throw $parser->mkSyntaxError('Invalid syntax');
        }
        return $tree;
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
}