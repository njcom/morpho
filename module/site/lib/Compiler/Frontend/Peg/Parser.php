<?php declare(strict_types=1);
/**
 * This file is part of njcom/framework
 * It is distributed under the 'Apache License Version 2.0' license.
 * See the https://github.com/njcom/framework/blob/main/LICENSE for the full license text.
 */
namespace Morpho\Compiler\Frontend\Peg;

use Closure;
use Morpho\Compiler\Frontend\SyntaxError;

/**
 * Base class for the PEG parsers
 * Based on https://github.com/python/cpython/blob/3.11/Tools/peg_generator/pegen/parser.py
 */
abstract class Parser {
    protected ITokenizer $tokenizer;
    private int $level;
    private array $cache;
    private array $specialWords;
    
    public function __construct(ITokenizer $tokenizer, array|null $specialWords = null) {
        $this->tokenizer = $tokenizer;
        $this->level = 0;
        $this->cache = [];
        $this->specialWords = $specialWords ?? [
            TokenType::NewLine->name => true,
            TokenType::EndMarker->name => true,
            TokenType::Indent->name => true,
            TokenType::Dedent->name => true,
            // @todo: Async, Await, Name, Number, String, Op, TypeComment, SoftKeyword
        ];
    }

    abstract public function start(): mixed;

    /**
     * make_syntax_error() in Python.
     */
    public function mkSyntaxError(string $msg, string|null $filePath = null): SyntaxError {
        $token = $this->tokenizer->lastReadToken();
        return new SyntaxError($msg, $filePath, $token->start, $token->end, $token->line);
    }    
    
    protected function expect(mixed $expected): ?Token {
        return $this->memoize(
            __METHOD__,
            function ($expected) {
                $token = $this->tokenizer->peekToken();
                if ($token && is_string($expected)) {
                    if ($token->value === $expected) { // Compare by token value
                        return $this->tokenizer->nextToken();
                    }
                    if ($expected != '' && ord($expected[0]) >= 65 && ord($expected[0]) <= 90) { // Compare by special words (often TokenType) as string; First letter [A-Z]?
                        if (isset($this->specialWords[$expected]) && $expected === $token->type->name) {
                            return $this->tokenizer->nextToken();
                        }
                    }
                }
                return null;
            },
            $expected,
        );
    }

    protected function number(): ?Token {
        return $this->memoize(
            __METHOD__,
            function () {
                $token = $this->tokenizer->peekToken();
                if ($token->type == TokenType::Number) {
                    return $this->tokenizer->nextToken();
                }
                return null;
            },
        );
    }

    protected function memoize(string $fnId, Closure $fn, ...$args): mixed {
        $index = $this->tokenizer->index;
        $key = md5(serialize([$index, $fnId, $args]));
        if (isset($this->cache[$key ])) {
            [$result, $endIndex] = $this->cache[$key];
            $this->tokenizer->index = $endIndex;
            return $result;
        }
        $this->level++;
        $result = $fn(...$args);
        $this->level--;
        $this->cache[$key] = [$result, $this->tokenizer->index];
        return $result;
    }
}