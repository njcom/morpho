<?php declare(strict_types=1);
/**
 * This file is part of njcom/framework
 * It is distributed under the 'Apache License Version 2.0' license.
 * See the https://github.com/njcom/framework/blob/main/LICENSE for the full license text.
 */
namespace Morpho\Test\Unit\Tool\Fasm;

use Morpho\Testing\TestCase;
use Morpho\Tool\Fasm\Tokenizer;
use Morpho\Tool\Fasm\Token;
use Morpho\Tool\Fasm\TokenType;
use PHPUnit\Framework\Attributes\WithoutErrorHandler;

class TokenizerTest extends TestCase {
    //#[WithoutErrorHandler]
    public function testTokenize() {
        $programText = <<<OUT
        include '8086.inc'

            org	100h

        display_text = 9

            mov	ah,display_text
            mov	dx,hello
            int	21h

            int	20h

        hello db 'Hello World!',24h
        OUT;

        $tokens = new Tokenizer()($programText);
        $empty = true;
        $expectedTokens = [
            new Token(TokenType::IncludeKeyword, 'include', [1, 1]),
            new Token(TokenType::SingleQuotedString, '8086.inc', [1, 1]),
            new Token(TokenType::OrgKeyword, 'org', [1, 1]),
            new Token(TokenType::Number, '100h', [1, 1]),
            new Token(TokenType::Identifier, 'display_text', [1, 1]),
            new Token(TokenType::EqualsSpecial, '=', [1, 1]),
            new Token(TokenType::Number, '9', [1, 1]),
            new Token(TokenType::Identifier, 'mov', [1, 1]),
            new Token(TokenType::Identifier, 'ah', [1, 1]),
            new Token(TokenType::CommaSpecial, ',', [1, 1]),
            new Token(TokenType::Identifier, 'display_text', [1, 1]),
            new Token(TokenType::Identifier, 'mov', [1, 1]),
            new Token(TokenType::Identifier, 'dx', [1, 1]),
            new Token(TokenType::CommaSpecial, ',', [1, 1]),
            new Token(TokenType::Identifier, 'hello', [1, 1]),
            new Token(TokenType::Identifier, 'int', [1, 1]),
            new Token(TokenType::Number, '21h', [1, 1]),
            new Token(TokenType::Identifier, 'int', [1, 1]),
            new Token(TokenType::Number, '20h', [1, 1]),
            new Token(TokenType::Identifier, 'hello', [1, 1]),
            new Token(TokenType::Identifier, 'db', [1, 1]),
            new Token(TokenType::SingleQuotedString, 'Hello World!', [1, 1]),
            new Token(TokenType::CommaSpecial, ',', [1, 1]),
            new Token(TokenType::Number, '24h', [1, 1]),
        ];
        foreach ($tokens as $key => $token) {
            $empty = false;
            $this->assertEquals($expectedTokens[$key], $token);
            /*
            if ($key > 18) {
                d($token);
            }
            */
        }
        $this->assertFalse($empty);
    }
}