<?php declare(strict_types=1);
/**
 * This file is part of njcom/framework
 * It is distributed under the 'Apache License Version 2.0' license.
 * See the https://github.com/njcom/framework/blob/main/LICENSE for the full license text.
 */
namespace Morpho\Test\Unit\Compiler\Frontend\Peg;

use Morpho\Compiler\Frontend\Peg\FirstSetCalculator;
use Morpho\Compiler\Frontend\Peg\GrammarVisitor;
use Morpho\Compiler\Frontend\Peg\Peg;
use Morpho\Testing\TestCase;

/**
 * Based on https://github.com/python/cpython/blob/3.11/Lib/test/test_peg_generator/test_first_sets.py
 */
class FirstSetCalculatorTest extends TestCase {
    private ParserTestHelper $testHelper;

    protected function setUp(): void {
        parent::setUp();
        $this->testHelper = new ParserTestHelper();
    }

    public function testInterface() {
        $this->assertInstanceOf(GrammarVisitor::class, new FirstSetCalculator([]));
    }

    public function testAlternatives(): void {
        $grammar = file_get_contents($this->getTestDirPath() . '/000-alternative.gram');
        $this->checkCalculator(
            [
                "A"     => ["'a'", "'-'"],
                "B"     => ["'+'", "'b'"],
                "expr"  => ["'+'", "'a'", "'b'", "'-'"],
                "start" => ["'+'", "'a'", "'b'", "'-'"],
            ],
            $grammar
        );
    }

    public function testOptionals(): void {
        $grammar = <<<OUT
        start: expr NewLine
        expr: ['a'] ['b'] 'c'
        OUT;
        $this->checkCalculator(
            [
                'expr'  => ["'c'", "'a'", "'b'"],
                'start' => ["'c'", "'a'", "'b'"],
            ],
            $grammar
        );
    }

    public function testRepeatWithSeparator(): void {
        $grammar = <<<OUT
        start: ','.thing+ NewLine
        thing: Number
        OUT;
        $this->checkCalculator(
            [
                'thing' => ['Number'],
                'start' => ['Number'],
            ],
            $grammar
        );
    }

    public function testOptionalOperator(): void {
        $grammar = <<<OUT
        start: sum NewLine
        sum: (term)? 'b'
        term: Number
        OUT;
        $this->checkCalculator(
            [
                "term"  => ["Number"],
                "sum"   => ["Number", "'b'"],
                "start" => ["'b'", "Number"],
            ],
            $grammar,
        );
    }

    public function testOptionalLiteral(): void {
        $grammar = <<<OUT
        start: sum NewLine
        sum: '+' ? term
        term: Number
        OUT;
        $this->checkCalculator(
            [
                'term'  => ['Number'],
                'sum'   => ["'+'", "Number"],
                "start" => ["'+'", "Number"],
            ],
            $grammar
        );
    }

    public function testOptionalBefore(): void {
        $grammar = <<<OUT
        start: term NewLine
        term: ['+'] Number
        OUT;
        $this->checkCalculator(
            [
                "term"  => ["Number", "'+'"],
                "start" => ["Number", "'+'"],
            ],
            $grammar,
        );
    }

    public function testRepeat0(): void {
        $grammar = <<<OUT
        start: thing* "+" NewLine
        thing: Number
        OUT;
        $this->checkCalculator(
            [
                "thing" => ["Number"],
                "start" => ['"+"', "Number"],
            ],
            $grammar,
        );
    }

    public function testRepeat0WithGroup(): void {
        $grammar = <<<OUT
        start: ('+' '-')* term NewLine
        term: Number
        OUT;
        $this->checkCalculator(
            [
                "term"  => ["Number"],
                "start" => ["'+'", "Number"],
            ],
            $grammar,
        );
    }

    public function testRepeat1(): void {
        $grammar = <<<OUT
        start: thing+ '-' NewLine
        thing: Number
        OUT;
        $this->checkCalculator(
            [
                "thing" => ["Number"],
                "start" => ["Number"],
            ],
            $grammar,
        );
    }

    public function testRepeat1WithGroup(): void {
        $grammar = <<<OUT
        start: ('+' term)+ term NewLine
        term: Number
        OUT;
        $this->checkCalculator(
            [
                "term"  => ["Number"],
                "start" => ["'+'"],
            ],
            $grammar,
        );
    }

    public function testGather(): void {
        $grammar = <<<OUT
        start: ','.thing+ NewLine
        thing: Number
        OUT;
        $this->checkCalculator(
            [
                "thing" => ["Number"],
                "start" => ["Number"],
            ],
            $grammar,
        );
    }

    public function testPositiveLookahead(): void {
        $grammar = <<<OUT
        start: expr NewLine
        expr: &'a' opt
        opt: 'a' | 'b' | 'c'
        OUT;
        $this->checkCalculator(
            [
                "expr"  => ["'a'"],
                "start" => ["'a'"],
                "opt"   => ["'b'", "'c'", "'a'"],
            ],
            $grammar,
        );
    }

    public function testNegativeLookahead(): void {
        $grammar = <<<OUT
        start: expr NewLine
        expr: !'a' opt
        opt: 'a' | 'b' | 'c'
        OUT;
        $this->checkCalculator(
            [
                "opt"   => ["'b'", "'a'", "'c'"],
                "expr"  => ["'b'", "'c'"],
                "start" => ["'b'", "'c'"],
            ],
            $grammar,
        );
    }

    public function testLeftRecursion(): void {
        $grammar = <<<OUT
        start: expr NewLine
        expr: ('-' term | expr '+' term | term)
        term: Number
        foo: 'foo'
        bar: 'bar'
        baz: 'baz'
        OUT;
        $this->checkCalculator(
            [
                "expr"  => ["Number", "'-'"],
                "term"  => ["Number"],
                "start" => ["Number", "'-'"],
                "foo"   => ["'foo'"],
                "bar"   => ["'bar'"],
                "baz"   => ["'baz'"],
            ],
            $grammar,
        );
    }

    public function testAdvanceLeftRecursion(): void {
        $grammar = <<<OUT
        start: Number | sign start
        sign: ['-']
        OUT;
        $this->checkCalculator(
            [
                "sign"  => ["'-'", ""],
                "start" => ["'-'", "Number"],
            ],
            $grammar,
        );
    }

    public function testMutualLeftRecursion(): void {
        $grammar = <<<OUT
        start: foo 'E'
        foo: bar 'A' | 'B'
        bar: foo 'C' | 'D'
        OUT;
        $this->checkCalculator(
            [
                "foo"   => ["'D'", "'B'"],
                "bar"   => ["'D'"],
                "start" => ["'D'", "'B'"],
            ],
            $grammar,
        );
    }

    public function testNastyLeftRecursion(): void {
        $grammar = <<<OUT
        start: target '='
        target: maybe '+' | Name
        maybe: maybe '-' | target
        OUT;
        $this->checkCalculator(
            [
                "maybe"  => [],
                "target" => ["Name"],
                "start"  => ["Name"],
            ],
            $grammar,
        );
    }

    public function testNullableRule(): void {
        $grammar = <<<OUT
        start: sign thing $
        sign: ['-']
        thing: Number
        OUT;
        $this->checkCalculator(
            [
                "sign"  => ["", "'-'"],
                "thing" => ["Number"],
                "start" => ["Number", "'-'"],
            ],
            $grammar,
        );
    }

    public function testEpsilonProductionInStartRule(): void {
        $grammar = <<<OUT
        start: ['-'] $
        OUT;
        $this->checkCalculator(
            [
                "start" => ['EndMarker', "'-'"],
            ],
            $grammar,
        );
    }

    public function testMultipleNullableRules(): void {
        $grammar = <<<OUT
        start: sign thing other another $
        sign: ['-']
        thing: ['+']
        other: '*'
        another: '/'
        OUT;
        $this->checkCalculator(
            [
                "sign"    => ["", "'-'"],
                "thing"   => ["'+'", ""],
                "start"   => ["'+'", "'-'", "'*'"],
                "other"   => ["'*'"],
                "another" => ["'/'"],
            ],
            $grammar,
        );
    }


    /**
     * @param string $sourceGrammar
     * @return array<string, string>
     */
    private function calculateFirstSets(string $sourceGrammar): array {
        $grammar = Peg::parseGrammar($sourceGrammar);
        return (new FirstSetCalculator($grammar->rules))->calculate();
    }

    private function checkCalculator(array $expected, string $grammar) {
        $this->assertSetsEquals($expected, $this->calculateFirstSets($grammar));
    }

    private function assertSetsEquals(array $expected, array $actual): void {
        $expectedLen = count($expected);
        $actualLen = count($actual);
        $expected = $this->testHelper->sortRecursive($expected);
        $actual = $this->testHelper->sortRecursive($actual);
        $this->assertCount($expectedLen, $expected);
        $this->assertCount($actualLen, $actual);
        $this->assertSame($expected, $actual);
    }
}