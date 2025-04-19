<?php declare(strict_types=1);
/**
 * This file is part of njcom/framework
 * It is distributed under the 'Apache License Version 2.0' license.
 * See the https://github.com/njcom/framework/blob/main/LICENSE for the full license text.
 */
namespace Morpho\Tool\Fasm;

//use Morpho\Base\Ok;
use Morpho\Base\Result;
use Morpho\Compiler\Frontend\MbStringReader;
use Morpho\Compiler\Frontend\IStringReader;
use Morpho\Compiler\Frontend\Re;
use IteratorAggregate;
use Traversable;
use Morpho\Compiler\Frontend\SyntaxError;

class Tokenizer implements IteratorAggregate {
    private IStringReader $reader;
    //private int $index = -1;
    private array $location = [1, 1]; // line number, column number

    public function __invoke(string $programText): iterable {
        $reader = new MbStringReader($programText);
        $this->reader = $reader;
        return $this->getIterator($reader);
    }

    public function getIterator(): Traversable {
        while ($token = $this->nextToken()) {
            yield $token;
        }
    }

    public function nextToken(): ?Token {
        $this->reader->read('~\s+~');
        $nextChar = $this->reader->peek(1);
        $specialChars = [
            '+' => TokenType::PlusSpecial,
            '-' => TokenType::MinusSpecial,
            '/' => TokenType::SlashSpecial,
            '*' => TokenType::AsteriskSpecial,
            '=' => TokenType::EqualsSpecial,
            '<' => TokenType::LessThanSpecial,
            '>' => TokenType::GreaterThanSpecial,
            '(' => TokenType::LeftParenSpecial,
            ')' => TokenType::RightParenSpecial,
            '[' => TokenType::LeftBracketSpecial,
            ']' => TokenType::RightBracketSpecial,
            '{' => TokenType::LeftBraceSpecial,
            '}' => TokenType::RightBraceSpecial,
            ':' => TokenType::ColonSpecial,
            '?' => TokenType::QuestionSpecial,
            '!' => TokenType::ExclamationSpecial,
            '.' => TokenType::DotSpecial,
            ',' => TokenType::CommaSpecial,
            '|' => TokenType::PipeSpecial,
            '&' => TokenType::AmpersandSpecial,
            '~' => TokenType::TildeSpecial,
            '#' => TokenType::HashSpecial,
            '`' => TokenType::BacktickSpecial,
            '\\' => TokenType::BackslashSpecial,
        ];
        if (isset($specialChars[$nextChar])) {
            $char = $this->reader->char();
            return new Token($specialChars[$nextChar], $char, $this->location);
        }
        $lexeme = $this->reader->read('~[^\s' . preg_quote(implode('', array_keys($specialChars)), '~') . ']+~');
        // todo: handle location
        $isFasmNumber = static function (string $text): bool {
            return (bool) preg_match('~^(\d[\d_]*d?|0[0-7_]+[oq]|[01_]+b|\$[0-9a-f_]+|0x[0-9a-f_]+|\d[\da-f_]*h)$~si', $text);
        };
        $isFasmIdentifier = static function (string $text): bool {
            return (bool) preg_match('~^[_.a-z0-9#?]+$~si', $text);
        };
        if (null !== $lexeme) {
            $firstChar = mb_substr($lexeme, 0, 1);
            $keywords = [
                'include' => TokenType::IncludeKeyword,
                'org' => TokenType::OrgKeyword,
            ];
            if ($firstChar === "'") {
                $this->reader->unread();
                return new Token(TokenType::SingleQuotedString, substr(substr($this->reader->read('~' . Re::SINGLE_QUOTED_STRING . '~'), 0, -1), 1), $this->location);
            } elseif ($firstChar === '"')  {
                $this->reader->unread();
                return new Token(TokenType::DoubleQuotedStrng, substr(substr($this->reader->read('~' . Re::DOUBLE_QUOTED_STRING . '~'), 0, -1), 1), $this->location);
            } elseif (isset($keywords[$lexeme])) {
                return new Token($keywords[$lexeme], $lexeme, $this->location);
            } elseif ($isFasmNumber($lexeme)) {
                return new Token(TokenType::Number, $lexeme, $this->location);
            } elseif ($isFasmIdentifier($lexeme)) {
                return new Token(TokenType::Identifier, $lexeme, $this->location);
            }
            throw new \UnexpectedValueException('Unknown token');
        }
        return null;
    }
}