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

    public static function run(string $grammarCode, ITokenizer|null $programTokenizer = null, array|null $generateParserConf = null) {
        $grammar = self::parseGrammar($grammarCode);
        [$parserClass, $parserCode] = self::generateParserCode($grammar, $generateParserConf);
        $programParser = self::evalParserCode($parserClass, $parserCode, $programTokenizer);
        return self::runParser($programParser);
    }

    public static function prettyPrintTokens(iterable $tokenizer): string {
        $output = '';
        foreach ($tokenizer as $token) {
            $output .= (string) $token . "\n";
        }
        return $output;
    }

   /**
     * @param string|resource $source
     * @return \Morpho\Compiler\Frontend\Peg\ITokenizer
     */
    public static function mkTokenizer($source): ITokenizer {
        return new Tokenizer(PythonTokenizer::tokenize($source));
    }

    /**
     * @param resource|string $grammarCode
     */
    public static function parseGrammar($grammarCode): Grammar {
        $tokenizer = self::mkTokenizer($grammarCode);
        return self::runParser(new GrammarParser($tokenizer));
    }

    /**
     * @param array $conf
     *     ruleChecker: callable: custom rule checker. If not specified the default RuleCheckingVisitor will be used
     *     tokenNames: set[str]: required only when ruleChecker is not specified and need to use the default RuleCheckingVisitor with custom token names.
     */
    public static function generateParserCode(Grammar $grammar, array|null $conf = null, int $format = self::FORMAT_AS_FRAGMENT): array {
        $targetProgramStream = mkStream('');
        $diff = array_diff_key($conf, ['tokenNames' => true, 'ruleChecker' => true]);
        if ($diff) {
            throw new \InvalidArgumentException('Invalid $conf argument');
        }
        $ruleChecker = $conf['ruleChecker'] ?? new RuleCheckingVisitor($conf['tokenNames'] ?? array_keys(enumVals(TokenType::class)));
        $gen = new PhpParserGenerator($grammar, $targetProgramStream, $ruleChecker);
        $parserClass = $gen->generate($conf);
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

    public static function generateParserFile(Grammar $grammar, string $targetFilePath, array|null $conf = null): string {
        [$parserClass, $parserCode] = self::generateParserCode($grammar, $conf, self::FORMAT_AS_FILE);
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
}