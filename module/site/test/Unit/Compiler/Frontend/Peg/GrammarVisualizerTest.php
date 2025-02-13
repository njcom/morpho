<?php declare(strict_types=1);
/**
 * This file is part of njcom/framework
 * It is distributed under the 'Apache License Version 2.0' license.
 * See the https://github.com/njcom/framework/blob/main/LICENSE for the full license text.
 */
namespace Morpho\Test\Unit\Compiler\Frontend\Peg;

use Morpho\Compiler\Frontend\Peg\GrammarVisualizer;
use Morpho\Compiler\Frontend\Peg\Peg;
use Morpho\Testing\TestCase;

/**
 * Based on https://github.com/python/cpython/blob/3.12/Lib/test/test_peg_generator/test_pegen.py#L997
 */
class GrammarVisualizerTest extends TestCase {
    public function testOneRule(): void {
        $grammarSource = "start: 'a' 'b'";
        $expected = <<<OUT
        └──Rule
           └──Rhs
              └──Alt
                 ├──NamedItem
                 │  └──StringLeaf("'a'")
                 └──NamedItem
                    └──StringLeaf("'b'")
        OUT;

        $this->checkWrite($grammarSource, $expected);
    }

    public function testMultipleRules(): void {
        $grammarSource = <<<OUT
        start: a b
        a: 'a'
        b: 'b'
        OUT;
        $expected = <<<OUT
        └──Rule
           └──Rhs
              └──Alt
                 ├──NamedItem
                 │  └──NameLeaf('a')
                 └──NamedItem
                    └──NameLeaf('b')

        └──Rule
           └──Rhs
              └──Alt
                 └──NamedItem
                    └──StringLeaf("'a'")

        └──Rule
           └──Rhs
              └──Alt
                 └──NamedItem
                    └──StringLeaf("'b'")
        OUT;
        $this->checkWrite($grammarSource, $expected);
    }

    public function testDeepNestedRule(): void {
        $grammarSource = "start: 'a' ['b'['c'['d']]]";
        $expected = <<<OUT
        └──Rule
           └──Rhs
              └──Alt
                 ├──NamedItem
                 │  └──StringLeaf("'a'")
                 └──NamedItem
                    └──Opt
                       └──Rhs
                          └──Alt
                             ├──NamedItem
                             │  └──StringLeaf("'b'")
                             └──NamedItem
                                └──Opt
                                   └──Rhs
                                      └──Alt
                                         ├──NamedItem
                                         │  └──StringLeaf("'c'")
                                         └──NamedItem
                                            └──Opt
                                               └──Rhs
                                                  └──Alt
                                                     └──NamedItem
                                                        └──StringLeaf("'d'")
        OUT;
        $this->checkWrite($grammarSource, $expected);
    }

    private function checkWrite(string $grammarSource, string $expected): array {
        $grammar = Peg::parseGrammar($grammarSource);
        $grammarVisualizer = new GrammarVisualizer();
        $lines = [];
        $grammarVisualizer->__invoke($grammar, function ($line) use (&$lines) {
            $lines[] = $line;
        });
        $output = implode("\n", $lines);
        $this->assertSame(rtrim($expected) . "\n", $output);
        return $lines;
    }
}