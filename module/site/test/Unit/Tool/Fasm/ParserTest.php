<?php declare(strict_types=1);
/**
 * This file is part of njcom/framework
 * It is distributed under the 'Apache License Version 2.0' license.
 * See the https://github.com/njcom/framework/blob/main/LICENSE for the full license text.
 */
namespace Morpho\Test\Unit\Tool\Fasm;

use Morpho\Testing\TestCase;
use Morpho\Compiler\Frontend\Peg\Peg;

class ParserTest extends TestCase {
    public function testParse() {
        $this->markTestIncomplete();
        $grammarText = <<<'OUT'
        start: instructions
        # @todo: parse PHP inside {}
        instructions: a=instruction+ { var_dump($a); }
        instruction: INCLUDE
        INCLUDE: 'include'
        OUT;

        $programText = <<<OUT
        include '8086.inc'

            org	100h

        display_text = 9

            mov	ah,display_text
            mov	dx,hello
            int	21h

            int	20h

        hello db 'Hello world!',24h
        OUT;

        $grammar = Peg::parseGrammar($grammarText);
        $context = [
            'tokenNames' => [
                'INCLUDE',
            ],
        ];
        $tokenizer = new TokenizerWrapper(new FasmTokenizer($programText));
        [$parser, $parserCode] = Peg::generateEvaluatedParser($grammar, Peg::mkTokenizer($programText), $context);
        d($parserCode);
        $ast = Peg::runParser($parser);
        d($ast);
    }
}