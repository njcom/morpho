<?php declare(strict_types=1);
/**
 * This file is part of njcom/framework
 * It is distributed under the 'Apache License Version 2.0' license.
 * See the https://github.com/njcom/framework/blob/main/LICENSE for the full license text.
 */
namespace Morpho\Compiler\Frontend\Peg;

use Stringable;

use function Morpho\Base\q;
use function Morpho\Base\qq;

/**
 * https://github.com/python/cpython/blob/3.12/Lib/tokenize.py#L47
 * @todo: Unify with Compiler\Token
 */
readonly class Token implements Stringable {
    public TokenType $type;
    public string $value;
    public array $start;
    public array $end;
    public string $line;

    public function __construct(TokenType $type, string $value, array $start, array $end, string $line) {
        $this->type = $type;
        $this->value = $value;
        $this->start = $start;
        $this->end = $end;
        $this->line = $line;
    }

    public function __toString(): string {
        $q = function (string $s): string {
            $s = strtr($s, ["\n" => "\\n", "\\" => "\\\\"]);
            if ($s === '') {
                return "''";
            }
            $singleQuotePos = strpos($s, "'");
            $doubleQuotePos = strpos($s, '"');
            if (false !== $doubleQuotePos && false !== $singleQuotePos) {
                /*
                if ($singleQuotePos < $doubleQuotePos) {
                    return qq(strtr($s, '"', '\\"'));
                }
                */
                return q(str_replace("'", "\\'", $s));
            }
            /*
            if (false !== $singleQuotePos) {
                return qq(strtr($s, '"', '\\"'));
            }
            */
            if (false !== $singleQuotePos) {
                return qq(str_replace('"', '\\"', $s));
            }
            return q($s);
        };
        return 'Token(type=' . $this->type->value . ' (' . (strtoupper($this->type->name)) . '), string=' . $q($this->value) . ', start=(' . $this->start[0] . ', ' . $this->start[1] . '), end=(' . $this->end[0] . ', ' . $this->end[1] . '), line=' . $q($this->line) . ")";
    }
}