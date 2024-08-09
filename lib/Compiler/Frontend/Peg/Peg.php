<?php declare(strict_types=1);
/**
 * This file is part of njcom/framework
 * It is distributed under the 'Apache License Version 2.0' license.
 * See the https://github.com/njcom/framework/blob/main/LICENSE for the full license text.
 */
namespace Morpho\Compiler\Frontend\Peg;

use Morpho\Base\NotImplementedException;
use UnexpectedValueException;

use function Morpho\Base\mkStream;

/**
 * PEG/Parsing Expression Grammar: parser generator, generating recursive descent parser by a grammar.
 * Based on https://peps.python.org/pep-0617/ and other related Python's PEG resources.
 * @param string|resource $grammarSource
 * @param string $text
 */
class Peg {
    public static function parse($grammarText, string $text, array $context = null): array {
        $grammar = static::parseGrammar($grammarText);
        $parserFactory = static::generateAndEvalParser($grammar, $context)['parserFactory'];
        $tokenizerFactory = $context['tokenizerFactory'] ?? self::mkTokenizer(...);
        $tokenizer = $tokenizerFactory($text);
        $parser = $parserFactory($tokenizer);
        $grammar = static::runParser($parser);
        return [$grammar, $parser, $tokenizer];
    }

    /**
     * @param string|resource $grammarSource
     * @param string $targetParserFilePath
     * @return void
     */
    public static function generateParserFile($grammarSource, string $targetParserFilePath) {
        $stream = fopen('php://memory', 'r+');

        $grammar = Peg::parseGrammar($grammarSource);

        /*
        $parserGen = new PhpParserGenerator($grammar, $stream, $tokens);


        $context = $parserGen->generate(['namespace' => __NAMESPACE__]);
        */
        d(self::generateParser($grammar));

        $php = stream_get_contents($stream, offset: 0);
        file_put_contents(__DIR__ . '/_unformatted.php', $php);
        $descriptors = [
            0 => ["pipe", "r"],  // stdin is a pipe that the child will read from
            1 => ["pipe", "w"],  // stdout is a pipe that the child will write to
            2 => ["pipe", "w"], // stderr
        ];
        $process = proc_open(__DIR__ . '/format-php', $descriptors, $pipes, __DIR__);
        if (!$process) {
            throw new RuntimeException();
        }
        fwrite($pipes[0], $php);
        fclose($pipes[0]);

        $formatted = stream_get_contents($pipes[1]);
        echo $formatted;
        file_put_contents(__DIR__ . '/_formatted.php', $formatted);
        fclose($pipes[1]);
        $exitCode = proc_close($process);
        if ($exitCode) {
            throw new RuntimeException();
        }
    }

    /**
     * Generate parser by the grammar
     * [generate_parser(grammar: Grammar) -> Type[Parser]](https://github.com/python/cpython/blob/3.12/Tools/peg_generator/pegen/testutil.py#L26)
     */
    public static function generateParser(Grammar $grammar/*, array $context = null*/): array {
        $programStream = mkStream('');
        $gen = new PhpParserGenerator($grammar, $programStream);
        $parserClass = $gen->generate([]);
        $programText = stream_get_contents($programStream, offset: 0);
        if ($programText === '') {
            throw new UnexpectedValueException();
        }
        return [
            'program' => $programText,
            'parserClass' => $parserClass,
        ];
    }

    /**
     * @todo: specify $context array shape
     */
    public static function generateAndEvalParser(Grammar $grammar, array $context = null): array {
        $newContext = static::generateParser($grammar, $context);
        /*        try {
                    eval('?>' . $newContext['program']);
                } catch (\ParseError $e) {
                    d($newContext['program']);
                }*/
        eval('?>' . $newContext['program']);
        $class = $newContext['parserClass'];
        $newContext['parserFactory'] = function (...$args) use ($class) {
            return new $class(...$args);
        };
        return $newContext;
    }

    public static function mkGrammarParser(ITokenizer $tokenizer): GrammarParser {
        return new GrammarParser($tokenizer);
    }

    /**
     * @param string|resource $source
     * @return \Morpho\Compiler\Frontend\Peg\ITokenizer
     * @noinspection PhpMissingParamTypeInspection
     */
    public static function mkTokenizer($source): ITokenizer {
        return new Tokenizer(PythonTokenizer::tokenize($source));
    }

    public static function runParser(Parser $parser): mixed {
        $ast = $parser->start();
        if (!$ast) {
            throw $parser->mkSyntaxError('Invalid syntax');
        }
        return $ast;
    }

    /**
     * @param string|resource $grammarText
     * @noinspection PhpMissingParamTypeInspection
     */
    public static function parseGrammar($grammarText): mixed {
        $tokenizer = static::mkTokenizer($grammarText);
        $parser = static::mkGrammarParser($tokenizer);
        return static::runParser($parser);
    }

    /**
     * ast.literal_eval() in Python
     */
    public static function _literalEval(string $literal): string {
        // Handle ''' and """ Python strings
        if (preg_match('~^(\'\'\'|""")(?P<val>.*)(\\1)$~s', $literal, $match)) {
            $literal = '"' . $match['val'] . '"';
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
