<?php declare(strict_types=1);
/**
 * This file is part of njcom/framework
 * It is distributed under the 'Apache License Version 2.0' license.
 * See the https://github.com/njcom/framework/blob/main/LICENSE for the full license text.
 */
namespace Morpho\Compiler\Frontend\Peg;

use Iterator;
use Morpho\Base\NotImplementedException;
use Traversable;

/**
 * Based on https://github.com/python/cpython/blob/3.12/Tools/peg_generator/pegen/tokenizer.py
 */
class Tokenizer implements ITokenizer {
    /**
     * mark() in Python
     */
    public int $index = 0;

    /**
     * @var array Token[]
     */
    private array $tokens = [];

    private Iterator $tokenIt;

    public function __construct(Iterator $tokenIt) {
        $this->tokenIt = $tokenIt;
    }

    public function getIterator(): Traversable {
        while ($token = $this->nextToken()) {
            yield $token;
        }
    }

    public function nextToken(): ?Token {
        $token = $this->peekToken();
        $this->index++;
        return $token;
    }

    public function peekToken(): ?Token {
        while ($this->index === count($this->tokens)) {
            $token = $this->tokenIt->current();
            $this->tokenIt->next();
            if (!$token) {
                return null;
            }
            if (in_array($token->type, [TokenType::SoftNewLine, TokenType::Comment])) {
                continue;
            }
            if ($token->type === TokenType::ErrorToken && ctype_space($token->value)) {
                continue;
            }
            $this->tokens[] = $token;
        }
        return $this->tokens[$this->index];
    }

    public function lastReadToken(): Token {
        if (!$this->tokens) {
            $this->nextToken();
        }
        return $this->tokens[count($this->tokens) - 1];
    }

    public function lastNonWhitespaceToken(): Token {
        throw new NotImplementedException();
        /*
        for tok in reversed(self._tokens[: self._index]):
            if tok.type != tokenize.ENDMARKER and (
                tok.type < tokenize.NEWLINE or tok.type > tokenize.DEDENT
            ):
                break
        return tok
        */
    }
}