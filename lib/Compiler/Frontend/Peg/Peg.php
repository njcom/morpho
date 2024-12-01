<?php declare(strict_types=1);
/**
 * This file is part of njcom/framework
 * It is distributed under the 'Apache License Version 2.0' license.
 * See the https://github.com/njcom/framework/blob/main/LICENSE for the full license text.
 */
namespace Morpho\Compiler\Frontend\Peg;

use Traversable;

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
    public const int FORMAT_AS_FRAGMENT = 1;
    public const int FORMAT_AS_FILE = 2;
    /**
     * @param resource|string $source
     * @return Traversable
     * @throws \Exception
     */
    public static function tokenize($source): Traversable {
        return self::mkTokenizer($source)->getIterator();
    }

    public static function parseGrammar($source): Grammar {
        return self::runParser(new GrammarParser(self::mkTokenizer($source)));
    }

    public static function parseText(Grammar $grammar, $tokenizer, array $context = null) {
        [$parserClass, $parserCode] = self::generateParser($grammar, $context, Peg::FORMAT_AS_FRAGMENT);
        eval('?><?php ' . $parserCode);
        $parser = new $parserClass($tokenizer);
        return self::runParser($parser);
    }

    public static function generateParser(Grammar $grammar, array $context = null, int $format = self::FORMAT_AS_FILE): array {
        $programStream = mkStream('');
        $gen = new PhpParserGenerator($grammar, $programStream, new RuleCheckingVisitor(array_keys(enumVals(TokenType::class))));
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

    /**
     * @param string|resource $source
     * @return \Morpho\Compiler\Frontend\Peg\ITokenizer
     */
    public static function mkTokenizer($source): ITokenizer {
        return new Tokenizer(PythonTokenizer::tokenize($source));
    }

    public static function generateParserFile(Grammar $grammar, string $targetFilePath, array $context = null): string {
        [$parserClass, $parserCode] = self::generateParser($grammar, $context);
        file_put_contents($targetFilePath, $parserCode);
        return $parserClass;
    }

    public static function runParser(Parser $parser): mixed {
        $tree = $parser->start();
        if (!$tree) {
            throw $parser->mkSyntaxError('Invalid syntax');
        }
        return $tree;
    }
}
