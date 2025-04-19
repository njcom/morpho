<?php declare(strict_types=1);
/**
 * This file is part of njcom/framework
 * It is distributed under the 'Apache License Version 2.0' license.
 * See the https://github.com/njcom/framework/blob/main/LICENSE for the full license text.
 */
namespace Morpho\Compiler\Frontend\Peg;

use Closure;
use Morpho\Base\NotImplementedException;
use Morpho\Compiler\Frontend\SyntaxError;
use WeakMap;

use function Morpho\Base\last;

/**
 * Base class for the PEG parsers
 * Based on https://github.com/python/cpython/blob/main/Tools/peg_generator/pegen/parser.py
 */
abstract class Parser {
    protected ITokenizer $tokenizer;
    private int $level;
    private array $cache;
    private const array KEYWORDS = [];
    private const array SOFT_KEYWORDS = ['memo'];

    public function __construct(ITokenizer $tokenizer) {
        $this->tokenizer = $tokenizer;
        $this->level = 0;
        $this->cache = [];
    }

    /**
     * make_syntax_error() in Python.
     */
    public function mkSyntaxError(string $msg, string|null $filePath = null): SyntaxError {
        $tok = $this->tokenizer->lastReadToken();
        return new SyntaxError($msg, $filePath, $tok->start, $tok->end, $tok->line);
    }

    abstract public function start(): mixed;

/*    protected function reset(int $index): void {
        $this->tokenizer->reset($index);
    }

    protected function index(): int {
        return $this->tokenizer->index();
    }*/

    protected function name(): ?Token {
        return $this->memoize(
            __METHOD__,
            function () {
                $tok = $this->tokenizer->peekToken();
                if ($tok->type == TokenType::Name && !in_array($tok->value, self::KEYWORDS)) {
                    return $this->tokenizer->nextToken();
                }
                return null;
            },
        );
    }

    protected function number(): ?Token {
        return $this->memoize(
            __METHOD__,
            function () {
                $tok = $this->tokenizer->peekToken();
                if ($tok->type == TokenType::Number) {
                    return $this->tokenizer->nextToken();
                }
                return null;
            },
        );
    }

    protected function string(): ?Token {
        return $this->memoize(
            __METHOD__,
            function () {
                $tok = $this->tokenizer->peekToken();
                if ($tok->type == TokenType::String) {
                    return $this->tokenizer->nextToken();
                }
                return null;
            },
        );
    }

    protected function op(): ?Token {
        return $this->memoize(
            __METHOD__,
            function () {
                $tok = $this->tokenizer->peekToken();
                if ($tok->type == TokenType::Op) {
                    return $this->tokenizer->nextToken();
                }
                return null;
            },
        );
    }
    
    protected function typeComment(): ?Token {
        return $this->memoize(
            __METHOD__,
            function () {
                $tok = $this->tokenizer->peekToken();
                if ($tok->type == TokenType::Comment) {
                    return $this->tokenizer->nextToken();
                }
                return null;
            },
        );
    }

    protected function softKeyword(): ?Token {
        return $this->memoize(
            __METHOD__,
            function () {
                $tok = $this->tokenizer->peekToken();
                if ($tok->type == TokenType::Name && in_array($tok->value, self::SOFT_KEYWORDS)) {
                    return $this->tokenizer->nextToken();
                }
                return null;
            },
        );
    }

    protected function expect($expected): ?Token {
        return $this->memoize(
            __METHOD__,
            function ($expected) {
                // @todo: replace TokenType with SpecialWord enum
                $specialWords = [
                    'NEWLINE' => TokenType::NewLine,
                    'ENDMARKER' => TokenType::EndMarker,
                    'INDENT' => TokenType::Indent,
                    'DEDENT' => TokenType::Dedent,
                    // @todo: ASYNC, AWAIT
                    // @todo: NAME, NUMBER, STRING, OP, TYPE_COMMENT
                    // @todo: SOFT_KEYWORD
                ];
                if (isset($specialWords[$expected])) {
                    $expected = $specialWords[$expected];
                }

                $tok = $this->tokenizer->peekToken();
                if ($tok->value === $expected) { // Compare by token value
                    return $this->tokenizer->nextToken();
                }
                if ($expected instanceof TokenType) {
                    if ($tok->type == $expected) { // Compare by token type
                        return $this->tokenizer->nextToken();
                    }
                }
                return null;
            },
            $expected,
        );
    }

    protected function expectForced(mixed $res, string $expectation): ?Token {
        if (null === $res) {
            throw new $this->mkSyntaxError("expected $expectation");
        }
        return $res;
    }

    protected function positiveLookahead(callable $fn, ...$args): mixed {
        $index = $this->tokenizer->index();
        $ok = $fn(...$args);
        $this->tokenizer->reset($index);
        return $ok;
    }

    protected function negativeLookahead(callable $fn, ...$args): bool {
        $index = $this->tokenizer->index();
        $ok = $fn(...$args);
        $this->tokenizer->reset($index);
        return !$ok;
    }

    protected function memoize(string $fnId, Closure $fn, ...$args): mixed {
        // @todo: Replace with WeakMap
        $index = $this->tokenizer->index();
        $key = md5(serialize([$index, $fnId, $args]));
        if (isset($this->cache[$key])) {
            [$tree, $endIndex] = $this->cache[$key];
            $this->tokenizer->reset($endIndex);
            return $tree;
        }
        $this->level++;
        $tree = $fn(...$args);
        $this->level--;
        $endIndex = $this->tokenizer->index();
        $this->cache[$key] = [$tree, $endIndex];
        return $tree;
    }
}