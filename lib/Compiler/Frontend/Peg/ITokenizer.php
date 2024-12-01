<?php declare(strict_types=1);
/**
 * This file is part of njcom/framework
 * It is distributed under the 'Apache License Version 2.0' license.
 * See the https://github.com/njcom/framework/blob/main/LICENSE for the full license text.
 */
namespace Morpho\Compiler\Frontend\Peg;

use IteratorAggregate;

interface ITokenizer extends IteratorAggregate {
    /**
     * Returns the next token and updates the index.
     * getnext() in Python
     */
    public function nextToken(): ?Token;

    /**
     * Returns the next token *without* updating the index.
     * peek() in Python
     */
    public function peekToken(): ?Token;

    public function index(): int;

    public function reset(int $index): void;

    //public function lines(array $lineNumbers): array;

    /**
     * diagnose() in Python
     */
    public function lastReadToken(): Token;

    /**
     * get_last_non_whitespace_token() in Python
     */
    public function lastNonWhitespaceToken(): Token;

    #public function report(bool $cached, bool $back): void;
}