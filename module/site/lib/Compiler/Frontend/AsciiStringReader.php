<?php declare(strict_types=1);
/**
 * This file is part of njcom/framework
 * It is distributed under the 'Apache License Version 2.0' license.
 * See the https://github.com/njcom/framework/blob/main/LICENSE for the full license text.
 */
namespace Morpho\Compiler\Frontend;

/**
 * Based on [StringScanner in Ruby](https://docs.ruby-lang.org/en/3.0.0/StringScanner.html), see [license](https://github.com/ruby/ruby/blob/master/COPYING)
 */
class AsciiStringReader implements IStringReader {
    protected string $input;
    protected int $offset = 0;
    protected int $prevOffset = 0;
    protected ?string $match = null;
    protected readonly bool $anchored;
    protected ?array $groups = null;

    /**
     * @param string $input
     * @param bool $anchored Either use the `A` PCRE modifier (PCRE_ANCHORED) for all regular expressions or not.
     */
    public function __construct(string $input, bool $anchored = true) {
        $this->input = $input;
        $this->anchored = $anchored;
    }

    /**
     * @see IStringReader::setInput()
     */
    public function setInput(string $input): void {
        $this->input = $input;
        $this->reset();
    }

    /**
     * @see IStringReader::input()
     */
    public function input(): string {
        return $this->input;
    }

    /**
     * @see IStringReader::concat()
     */
    public function concat(string $input): void {
        $this->input .= $input;
    }

    /**
     * @see IStringReader::offset()
     */
    public function offset(): int {
        return $this->offset;
    }

    /**
     * @see IStringReader::offsetInBytes()
     */
    public function offsetInBytes(): int {
        return $this->offset;
    }

    /**
     * @see IStringReader::look()
     */
    public function look(string $re): ?string {
        return $this->scan($re, false, true);
    }

    /**
     * @see IStringReader::lookUntil()
     */
    public function lookUntil(string $re): ?string {
        return $this->scanUntil($re, false, true);
    }

    /**
     * @see IStringReader::lookLen()
     */
    public function lookLen(string $re): ?int {
        return $this->scan($re, false, false);
    }

    /**
     * @see IStringReader::lookLenUntil()
     */
    public function lookLenUntil(string $re): ?int {
        return $this->scanUntil($re, false, false);
    }

    /**
     * @see IStringReader::read()
     */
    public function read(string $re): string|null {
        return $this->scan($re, true, true);
    }

    /**
     * @see IStringReader::readUntil()
     */
    public function readUntil(string $re): null|string {
        return $this->scanUntil($re, true, true);
    }

    /**
     * @see IStringReader::readLen()
     */
    public function readLen(string $re): ?int {
        return $this->scan($re, true, false);
    }

    /**
     * @see IStringReader::readLenUntil()
     */
    public function readLenUntil(string $re): ?int {
        return $this->scanUntil($re, true, false);
    }

    /**
     * @see IStringReader::peek()
     */
    public function peek(int $n): string {
        $res = $this->substr($this->input, $this->offset, $n);
        if (false !== $res) {
            return $res;
        }
        return '';
    }

    /**
     * @see IStringReader::char()
     */
    public function char(): ?string {
        $this->groups = $this->match = null;
        if ($this->offset >= $this->strlen($this->input)) {
            return null;
        }
        $this->prevOffset = $this->offset;
        $match = $this->substr($this->input, $this->offset, 1);
        $this->offset += $this->strlen($match);
        $this->groups = [$match];
        return $this->match = $match;
    }

    /**
     * @see IStringReader::unread()
     */
    public function unread(): void {
        if (null === $this->match) {
            throw new StringReaderException("Previous match record doesn't exist");
        }
        $this->match = null;
        $this->groups = null;
        $this->offset = $this->prevOffset;
    }

    /**
     * @see IStringReader::terminate()
     */
    public function terminate(): void {
        $this->match = null;
        $this->groups = null;
        $this->offset = $this->strlen($this->input);
    }

    /**
     * @see IStringReader::reset()
     */
    public function reset(): void {
        $this->match = null;
        $this->offset = $this->prevOffset = 0;
        $this->groups = null;
    }

    /**
     * @see IStringReader::isLineStart()
     */
    public function isLineStart(): bool {
        if ($this->offset == 0) {
            return true;
        }
        $n = strlen($this->input);
        $offsetInBytes = $this->offsetInBytes();
        return $offsetInBytes < $n
            && ($this->input[$offsetInBytes - 1] == "\n" // *nix
                || $this->input[$offsetInBytes - 1] == "\r" // mac
                || ($n >= 2 && $this->input[$offsetInBytes - 2] == "\r" && $this->input[$offsetInBytes - 1] == "\n")); // win
    }

    /**
     * @see IStringReader::isEnd()
     */
    public function isEnd(): bool {
        return $this->offset >= $this->strlen($this->input);
    }

    /**
     * @see IStringReader::match()
     */
    public function match(): ?string {
        return $this->match;
    }

    /**
     * @see IStringReader::matchLen()
     */
    public function matchLen(): ?int {
        return null === $this->match || $this->offset >= $this->strlen($this->input)
            ? null
            : $this->strlen($this->match);
    }

    /**
     * @see IStringReader::preMatch()
     */
    public function preMatch(): ?string {
        return null === $this->match
            ? null
            : $this->substr($this->input, 0, $this->prevOffset);
    }

    /**
     * @see IStringReader::postMatch()
     */
    public function postMatch(): ?string {
        return null === $this->match
            ? null
            : $this->substr($this->input, $this->offset, null);
    }

    /**
     * @see IStringReader::groups()
     */
    public function groups(): ?array {
        return $this->groups;
    }

    /**
     * @see IStringReader::rest()
     */
    public function rest(): string {
        $res = $this->substr($this->input, $this->offset, null);
        if (false === $res) {
            return '';
        }
        return $res;
    }

    /**
     * @see IStringReader::restLen()
     */
    public function restLen(): int {
        return $this->strlen($this->input) - $this->offset;
    }

    /**
     * @see IStringReader::isAnchored()
     */
    public function isAnchored(): bool {
        return $this->anchored;
    }

    protected function substr(string $s, int $offset, ?int $length): string|false {
        return substr($s, $offset, $length);
    }

    protected function strlen(mixed $s): int {
        return strlen($s);
    }

    protected function re(string $re, bool $anchored = null): string {
        if (null === $anchored) {
            return $this->anchored ? $re . 'A' : $re;
        }
        return $anchored ? $re . 'A' : $re;
    }

    /**
     * Can change or not the offset depending from the $advanceOffset
     * Changes the `match` register
     * @param string $re
     * @param bool $advanceOffset If true the offset will be advanced.
     * @param bool $returnStr
     *     If true then string will be returned if there is a match, if there is no match the null will be returned.
     *     If false then int will be returned if there is a match, if there is no match the null will be returned.
     * @return string|int|null Depending from the $advanceOffset and $returnStr arguments the different result will be returned.
     */
    protected function scan(string $re, bool $advanceOffset, bool $returnStr): string|int|null {
        $match = null;
        if (preg_match($this->re($re), $this->input, $m, 0, $this->offsetInBytes())) {
            $match = $m[0];
            if ($advanceOffset) {
                $this->prevOffset = $this->offset;
                $this->offset += $this->strlen($match);
            }
        }
        $this->match = $match;
        $this->groups = null === $match ? null : $m;
        if ($returnStr) {
            return $match;
        }
        return $match === null ? null : $this->strlen($match);
    }

    /**
     * Reads the text until the pattern is match. Can advance or not the offset. Modifies the `match` register.
     * Ruby methods:
     *     [scan_until()](https://docs.ruby-lang.org/en/3.0.0/StringScanner.html#method-i-scan_until).
     *     [search_full()](https://docs.ruby-lang.org/en/3.0.0/StringScanner.html#method-i-search_full).
     * @param string $re Pattern (PCRE) to match.
     * @param bool $advanceOffset If true the offset will be advanced.
     * @param bool $returnStr
     *     If true then string will be returned if there is a match, if there is no match the null will be returned.
     *     If false then int will be returned if there is a match, if there is no match the null will be returned.
     * @return string|int|null Depending from the $advanceOffset and $returnStr arguments the different result will be returned.
     */
    protected function scanUntil(string $re, bool $advanceOffset, bool $returnStr): string|int|null {
        if (preg_match($this->re($re, false), $this->input, $m, PREG_OFFSET_CAPTURE, $this->offsetInBytes())) {
            $res = $this->substr(
                $this->input,
                $this->offset,
                $m[0][1] - $this->offset + $this->strlen($m[0][0])
            );
            if ($advanceOffset) {
                $this->prevOffset = $m[0][1];
                $this->offset += $this->strlen($res);
            }
            $this->groups = array_column($m, 0);
            $this->match = $m[0][0];
            if ($returnStr) {
                return $res;
            }
            return $this->strlen($res);
        }
        $this->groups = null;
        $this->match = null;
        return null;
    }
}
