<?php declare(strict_types=1);
/**
 * This file is part of njcom/framework
 * It is distributed under the 'Apache License Version 2.0' license.
 * See the https://github.com/njcom/framework/blob/main/LICENSE for the full license text.
 */
namespace Morpho\Test\Unit\Tool\Fasm;

use Morpho\Testing\TestCase;
use function Morpho\Base\mkStream;
use Morpho\Compiler\Frontend\Peg\Peg;
use Morpho\Compiler\Frontend\Peg\Tokenizer;
use Morpho\Compiler\Frontend\MbStringReader;
use Morpho\Tool\Fasm\Tokenizer as FasmTokenizer;
use Morpho\Tool\Fasm\TokenType as FasmTokenType;

class ParserTest extends TestCase {
    public function testParse() {
        $grammarCode = <<<'OUT'
        start: instructions NEWLINE? ENDMARKER
        instructions: a=instruction+ { $a; }
        instruction: include_instruction
        include_instruction: INCLUDE str
        str: SINGLE_QUOTED_STRING | DOUBLE_QUOTED_STRING
        INCLUDE: 'include'
        OUT;

        $programCode = <<<OUT
        include '8086.inc'

            org	100h

        display_text = 9

            mov	ah,display_text
            mov	dx,hello
            int	21h

            int	20h ; Comment at the end of the line

        ; Comment at the beginning of the line

        hello db 'Hello world!',24h
        OUT;

        $programTokenizer = new Tokenizer(new FasmTokenizer(mkStream($programCode))->getIterator());
        //d(Peg::prettyPrintTokens($programTokenizer));

        $grammar = Peg::parseGrammar($grammarCode);
        [$parserClass, $parserCode] = Peg::generateParserCode($grammar, ['ruleChecker' => function ($rules) {}]);
        d($parserCode);
        $programParser = Peg::evalParserCode($parserClass, $parserCode, $programTokenizer);
        $ast = Peg::runParser($programParser);


        d($ast);
        //d($ast);
    }
}