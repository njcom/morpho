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
    public const int FORMAT_NONE = 1;
    public const int FORMAT_AS_FRAGMENT = 1;
    public const int FORMAT_AS_FILE = 2;

    /**
     * @param resource|string $source
     * @return Traversable
     * @throws \Exception
     */
    public static function tokenize($text): Traversable {
        return self::mkTokenizer($text)->getIterator();
    }

    /**
     * @param resource|string $grammarText
     */
    public static function parseGrammar($grammarText): Grammar {
        return self::runParser(new GrammarParser(self::mkTokenizer($grammarText)));
    }

    /**
     * @param array $context See $context in PhpParserGenerator::generate() +:
     *     tokenNames: set[str]
     */
    public static function generateParserCode(Grammar $grammar, array|null $context = null, int $format = self::FORMAT_NONE): array {
        $programStream = mkStream('');
        $tokenNames = isset($context['tokenNames']) ? $context['tokenNames'] : array_keys(enumVals(TokenType::class));
        $ruleCheckingVisitor = new RuleCheckingVisitor($tokenNames);
        $gen = new PhpParserGenerator($grammar, $programStream, $ruleCheckingVisitor);
        $parserClass = $gen->generate($context);
        $parserCode = stream_get_contents($programStream, offset: 0);
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

    public static function generateParserFile(Grammar $grammar, string $targetFilePath, array|null $context = null): string {
        [$parserClass, $parserCode] = self::generateParserCode($grammar, $context, self::FORMAT_AS_FILE);
        file_put_contents($targetFilePath, $parserCode);
        return $parserClass;
    }

    public static function parseProgram(Grammar $grammar, $programTokenizer, array|null $context = null) {
        [$parserClass, $parserCode] = self::generateParserCode($grammar, $context);
        eval($parserCode);
        $programParser = new $parserClass($programTokenizer);
        return self::runParser($programParser);
    }

   /**
     * @param string|resource $source
     * @return \Morpho\Compiler\Frontend\Peg\ITokenizer
     */
    public static function mkTokenizer($source): ITokenizer {
        return new Tokenizer(PythonTokenizer::tokenize($source));
    }

    public static function runParser(Parser $parser): mixed {
        $tree = $parser->start();
        if (!$tree) {
            throw $parser->mkSyntaxError('Invalid syntax');
        }
        return $tree;
    }
}