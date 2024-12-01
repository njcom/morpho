<?php declare(strict_types=1);
/**
 * This file is part of njcom/framework
 * It is distributed under the 'Apache License Version 2.0' license.
 * See the https://github.com/njcom/framework/blob/main/LICENSE for the full license text.
 */
namespace Morpho\test\Unit\Compiler\Frontend\Peg;

use ArrayIterator;
use IteratorAggregate;
use Morpho\Compiler\Frontend\Peg\ITokenizer;
use Morpho\Compiler\Frontend\Peg\Tokenizer;
use Morpho\Compiler\Frontend\Peg\Token;
use Morpho\Compiler\Frontend\Peg\TokenType;
use Morpho\Testing\TestCase;

class TokenizerTest extends TestCase {
    private Tokenizer $tokenizer;

    protected function setUp(): void {
        parent::setUp();
        $this->tokenizer = new Tokenizer(new ArrayIterator([
            new Token(TokenType::Name, 'foo', [1, 0], [1, 3], "line\n"),
        ]));
    }

    public function testIterator() {
        $tokens = [
            new Token(TokenType::Op, '+', [1, 0], [1, 1], '+ 21 35'),
            new Token(TokenType::Number, '21', [1, 2], [1, 4], '+ 21 35'),
            new Token(TokenType::Number, '35', [1, 5], [1, 7], '+ 21 35'),
            new Token(TokenType::NewLine, '', [1, 7], [1, 8], '+ 21 35'),
            new Token(TokenType::EndMarker, '', [2, 0], [2, 0], ''),
        ];
        $tokenizer = new Tokenizer(new ArrayIterator($tokens));
        $itArr = iterator_to_array($tokenizer);
        $this->assertSame($tokens, $itArr);;
    }

    public function testInterface() {
        $this->assertInstanceOf(IteratorAggregate::class, $this->tokenizer);
        $this->assertInstanceOf(ITokenizer::class, $this->tokenizer);
    }

    public function testPeekToken() {
        $expectedTokens = [
            new Token(TokenType::Name, 'foo', [1, 0], [1, 3], "line\n")
        ];
        $i = 0;
        $tokenGen = function () use ($expectedTokens, &$i) {
            yield $expectedTokens[$i++];
        };
        $tokenizer = new Tokenizer($tokenGen());
        $this->assertSame(0, $tokenizer->index());
        $this->assertSame($expectedTokens[0], $tokenizer->peekToken());
        $this->assertSame(0, $tokenizer->index());
        $this->assertSame($expectedTokens[0], $tokenizer->peekToken());
        $this->assertSame(0, $tokenizer->index());
    }

    public function testIndex() {
        $this->assertSame(0, $this->tokenizer->index());
    }

    public function testNextToken() {
        $token = $this->tokenizer->nextToken();
        $this->assertInstanceOf(Token::class, $token);
    }
}