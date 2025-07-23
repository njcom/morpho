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

    public static function parseProgram(string|Grammar $grammar, ITokenizer $tokenizer, array|null $parserGeneratorConf = null, $format = self::FORMAT_AS_FRAGMENT): array {
        if (!is_object($grammar)) {
            $grammar = self::parseGrammar($grammar);
        }
        [$parserClass, $parserCode] = self::generateParserCode($grammar, $parserGeneratorConf, format: $format);
        $parser = self::evalParserCode($parserClass, $parserCode, $tokenizer, $format);
        return [$parser, $parserCode];
    }

    public static function runParser(Parser $parser): mixed {
        $tree = $parser->start();
        if (!$tree) {
            throw $parser->mkSyntaxError('Invalid syntax');
        }
        return $tree;
    }

    public static function generateParserCode(Grammar $grammar, $parserGenerator, array|null $parserGeneratorConf = null, int $format = self::FORMAT_AS_FRAGMENT): array {
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
            return [$parserClass, ppFile(parse($parserCode), false)];
        }
        if ($format & self::FORMAT_AS_FRAGMENT) {
            return [$parserClass, pp(parse($parserCode))];
        }
        return [$parserClass, $parserCode];
    }

    public static function mkParserGenerator(Grammar $grammar, $stream, $ruleChecker = null) {
        return new ParserGenerator($grammar, $stream, $ruleChecker ?? new RuleCheckingVisitor(array_keys(enumVals(TokenType::class))));
    }

    public static function generateParserFile(Grammar $grammar, string $targetFilePath, array|null $parserGeneratorConf = null): string {
        throw new NotImplementedException();
        /*
        [$parserClass, $parserCode] = self::generateParserCode($grammar, parserGeneratorConf: $parserGeneratorConf, format: self::FORMAT_AS_FILE);
        file_put_contents($targetFilePath, $parserCode);
        return $parserClass;
        */
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

    private static function evalParserCode(string $parserClass, string $parserCode, ITokenizer $programTokenizer, $format): Parser {
        if ($format & self::FORMAT_AS_FILE) {
            eval('?>' . $parserCode);
        } elseif ($format & self::FORMAT_AS_FRAGMENT) {
            eval($parserCode);
        } else {
            throw new UnexpectedValueException();
        }
        return new $parserClass($programTokenizer);
    }
}