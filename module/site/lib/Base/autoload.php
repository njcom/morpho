<?php declare(strict_types=1);
/**
 * This file is part of njcom/framework
 * It is distributed under the 'Apache License Version 2.0' license.
 * See the https://github.com/njcom/framework/blob/main/LICENSE for the full license text.
 */
/**
 * Some functions are based on functions found at [nikic/iter](https://github.com/nikic/iter) package, Copyright (c) 2013 by Nikita Popov
 */
namespace Morpho\Base;

use BackedEnum;
use Closure;
use Generator;
use InvalidArgumentException;
use OutOfBoundsException;
use Stringable;
use Symfony\Component\Yaml\Yaml;
use Throwable;
use UnexpectedValueException;

use function array_fill_keys;
use function array_key_exists;
use function array_merge;
use function array_pop;
use function array_shift;
use function array_slice;
use function array_values;
use function count;
use function extract;
use function floatval;
use function func_num_args;
use function get_object_vars;
use function htmlspecialchars;
use function htmlspecialchars_decode;
use function in_array;
use function is_array;
use function is_iterable;
use function is_string;
use function json_decode;
use function json_encode;
use function lcfirst;
use function md5;
use function number_format;
use function ob_end_clean;
use function ob_get_clean;
use function ob_start;
use function ord;
use function pow;
use function preg_match;
use function preg_quote;
use function preg_replace;
use function preg_replace_callback;
use function preg_split;
use function round;
use function sprintf;
use function str_replace;
use function strlen;
use function strpos;
use function strrpos;
use function strtolower;
use function strtoupper;
use function substr;
use function trim;
use function ucwords;
use function usleep;

use const PREG_SPLIT_NO_EMPTY;

const TRIM_CHARS = " \t\n\r\x00\x0B";

// Matches EOL character:
const EOL_RE = '(?>\r\n|\n|\r)';
const EOL_FULL_RE = '~' . EOL_RE . '~s';

const INDENT_SIZE = 4; // size in spaces
define(__NAMESPACE__ . '\\INDENT', str_repeat(' ', INDENT_SIZE));

const SHORTEN_TAIL = '...';
const SHORTEN_LENGTH = 30;

const CODE_WIDTH_1 = 80;
const CODE_WIDTH_2 = 120;

const TPL_FILE_EXT = '.php.tpl';

const PHP_FILE_FULL_RE = '~\.php$~si';

// https://stackoverflow.com/questions/23837286/why-does-php-not-provide-an-epsilon-constant-for-floating-point-comparisons
// Can be used in comparison operations with real numbers.
const EPS = 0.00001;

const WAIT_INTERVAL_MICRO_SEC = 200000;

/**
 * @psalm-type List = iterable|string|Stringable
 */

/**
 * @param mixed $value
 * @return bool Returns true if the $value is one of `enum` `case` values.
 */
function isEnumCase(mixed $value): bool {
    return is_object($value) && enum_exists($value::class);
}

function caseVal(mixed $value): mixed {
    return isEnumCase($value) ? $value->value : $value;
}

function enumVals(string $enumClass, bool $preserveNames = true): array {
    $vals = [];
    foreach ($enumClass::cases() as $case) {
        $vals[$case->name] = $case->value;
    }
    if (!$preserveNames) {
        return array_values($vals);
    }
    return $vals;
}

// todo: review functions below #12

/**
 * @param iterable|Stringable|string|resource $source
 * @param bool                                $asArr
 * @param bool                                $filterEmpty
 * @param bool                                $trim
 * @return iterable
 */
function lines($source, bool $asArr = true, bool $filterEmpty = true, bool $trim = true): iterable {
    if (is_resource($source)) {
        $source = (function () use ($source) {
            while (false !== ($line = fgets($source))) {
                yield $line;
            }
        })();
    } elseif (!is_iterable($source)) {
        $text = (string)$source;
        if ($text === '') {
            $source = [];
        } else {
            $source = preg_split(EOL_FULL_RE, $text, -1, $filterEmpty ? PREG_SPLIT_NO_EMPTY : 0);
        }
    }
    if ($asArr) {
        if (!$trim && !$filterEmpty) {
            return $source;
        }
        $lines = [];
        foreach ($source as $line) {
            if ($trim) {
                $line = trim($line);
            }
            if ($filterEmpty && $line === '') {
                continue;
            }
            $lines[] = $line;
        }
        return $lines;
    }
    return (function () use ($source, $trim, $filterEmpty) {
        foreach ($source as $line) {
            if ($trim) {
                $line = trim($line);
            }
            if ($filterEmpty && $line === '') {
                continue;
            }
            yield $line;
        }
    })();
}

function partial(callable $fn, ...$args1): Closure {
    return function (...$args2) use ($fn, $args1) {
        return $fn(...array_merge($args1, $args2));
    };
}

/**
 * @psalm-param callable(mixed, mixed): bool $predicate
 * @psalm-param List $list
 * @return bool
 */
function all(callable $predicate, iterable|string|Stringable $list): bool {
    foreach (toIt($list) as $key => $value) {
        if (!$predicate($value, $key)) {
            return false;
        }
    }
    return true;
}

/**
 * Converts to iterable so that it can be used in foreach loop.
 * @psalm-param List $list
 * @return iterable
 * @psalm-pure
 */
function toIt(iterable|string|Stringable $list): iterable {
    if (is_iterable($list)) {
        return $list;
    }
    if ($list instanceof Stringable) {
        $list = (string)$list;
    }
    return mb_str_split($list);
}

function e(string|Stringable|int|float $s): string {
    return htmlspecialchars((string)$s, ENT_QUOTES);
}

function de(string|Stringable|int|float $s): string {
    return htmlspecialchars_decode((string)$s, ENT_QUOTES);
}

function unpackArgs(array $args): array {
    return count($args) === 1 && is_array($args[0])
        ? $args[0]
        : $args;
}

/**
 * @param string                                                $prefix
 * @param string|null                                           $suffix
 * @param string|\Stringable|iterable|int|float|null|BackedEnum $list
 * @return string|array|\Closure
 * @todo: preserve structure, use fmap (map)
 * @todo: support short form wrap($prefix, $it)
 */
function wrap(string $prefix, ?string $suffix, string|Stringable|iterable|int|float|BackedEnum $list = null): string|array|Closure {
    if (null === $suffix) {
        $suffix = $prefix;
    }
    if (null === $list) {
        return function (string|Stringable|iterable|int|float|BackedEnum $list) use ($prefix, $suffix) {
            return wrap($prefix, $suffix, $list);
        };
    }
    if (is_iterable($list)) {
        $r = [];
        foreach ($list as $k => $v) {
            if ($v instanceof BackedEnum) {
                $r[$k] = $prefix . $v->value . $suffix;
            } else {
                $r[$k] = $prefix . $v . $suffix;
            }
        }
        return $r;
    }
    if (is_object($list)) {
        if (!$list instanceof Stringable) {
            if (!$list instanceof BackedEnum) { // enums extending `string` or `int` types
                throw new UnexpectedValueException();
            }
            return $prefix . $list->value . $suffix;
        }
    }
    // string or Stringable
    return $prefix . (string)$list . $suffix;
}

/**
 * @param string                                                 $prefix
 * @param string|\Stringable|iterable|int|float|\BackedEnum|null $list
 * @return string|array|\Closure
 * @todo: preserve structure, use fmap (map)
 */
function prepend(string $prefix, string|Stringable|iterable|int|float|BackedEnum $list = null): string|array|Closure {
    if (null === $list) {
        return function (string|Stringable|int|float|BackedEnum $list) use ($prefix) {
            return prepend($prefix, $list);
        };
    }
    if (is_iterable($list)) {
        $r = [];
        foreach ($list as $k => $v) {
            $r[$k] = $prefix . (string)$v;
        }
        return $r;
    }
    return $prefix . (string)$list;
}

/**
 * @param string                                                $suffix
 * @param string|\Stringable|iterable|int|float|null|BackedEnum $list
 * @return string|array|\Closure
 * @todo: preserve structure, use fmap (map)
 */
function append(string $suffix, string|Stringable|iterable|int|float|BackedEnum $list = null): string|array|Closure {
    if (null === $list) {
        return function (string|Stringable|int|float $list) use ($suffix) {
            return append($suffix, $list);
        };
    }
    if (is_iterable($list)) {
        $r = [];
        foreach ($list as $k => $v) {
            $r[$k] = (string)$v . $suffix;
        }
        return $r;
    }
    return (string)$list . $suffix;
}

/**
 * Opposite to unindent()
 * @param string|Stringable|int|float $text
 * @param int                         $indentSize Number of spaces
 * @param string                      $indent
 * @return string
 */
function indent(string|Stringable|int|float $text, int $indentSize = INDENT_SIZE, string $indent = ' '): string {
    return preg_replace('~^~m', str_repeat($indent, $indentSize), (string)$text);
}

/**
 * Opposite to indent()
 * @param string|Stringable|int|float $text
 * @param int                         $indentSize Number of spaces
 * @param string                      $indent
 * @return string
 */
function unindent(string|Stringable|int|float $text, int $indentSize = INDENT_SIZE, string $indent = ' '): string {
    return preg_replace('~^' . str_repeat($indent, $indentSize) . '~m', '', (string)$text);
}

function q(string|iterable|int|float|object $list): string|array {
    return wrap("'", null, $list);
}

function qq(string|iterable|int|float|object $list): string|array {
    return wrap('"', null, $list);
}

/**
 * Generates unique name within single HTTP request.
 */
function uniqueName(): string {
    static $uniqueInt = 0;
    return 'unique' . $uniqueInt++;
}

function words(string|Stringable|int $list, int $limit = -1): array {
    $list = (string)$list;
    return preg_split('~\\s+~s', trim($list), $limit, PREG_SPLIT_NO_EMPTY);
}

/**
 * Replaces first capsed letter or underscore with dash and small later.
 * @param mixed  $list Allowed string are: /[a-zA-Z0-9_- ]/s. All other characters will be removed.
 * @param string $additionalChars
 * @param bool   $trim Either trailing '-' characters should be removed or not.
 * @return string
 */
function dasherize(string|Stringable|int $list, string $additionalChars = '', bool $trim = true) {
    $string = sanitize($list, '-_ ' . $additionalChars, false);
    $string = deleteDups($string, '_ ');
    $search = ['/([A-Z]+)([A-Z][a-z])/', '/([a-z\d])([A-Z])/'];
    $replace = ['\\1-\\2', '\\1-\\2'];
    $result = mb_strtolower(
        preg_replace(
            $search,
            $replace,
            str_replace(
                ['_', ' '],
                '-',
                $string
            )
        )
    );
    if ($trim) {
        return etrim($result, '-');
    }

    return $result;
}

/**
 * Replaces first capsed letter or dash with underscore and small later.
 *
 * @param Stringable|string $s
 * @param bool              $trim Either trailing '_' characters should be removed or not.
 *
 * @return string
 */
function underscore(Stringable|string $s, bool $trim = true) {
    $string = sanitize($s, '-_ ', false);
    $string = deleteDups($string, '- ');
    $result = strtolower(
        preg_replace(
            '~([a-z])([A-Z])~s',
            '$1_$2',
            str_replace(
                ['-', ' '],
                '_',
                $string
            )
        )
    );
    if ($trim) {
        return etrim($result, '_');
    }

    return $result;
}

/**
 * Replaces next letter after the allowed character with capital letter.
 * First latter will be always in upper case.
 *
 * @param Stringable|string $s Allowed string are: /[a-zA-Z0-9_- /\\\\]/s.
 *                       All other characters will be removed.
 *                       The '/' will be transformed to '\'.
 *
 * @return string
 */
function classify(string|Stringable $s): string {
    $string = sanitize(str_replace('/', '\\', (string)$s), '-_\\ ');
    if (str_contains($string, '\\')) {
        $string = preg_replace_callback(
            '{\\\\(\w)}si',
            function ($match) {
                return '\\' . strtoupper($match[1]);
            },
            $string
        );
    }
    $string = str_replace(['-', '_'], ' ', $string);
    $string = ucwords($string);
    return str_replace(' ', '', $string);
}

/**
 * Replaces next letter after the allowed character with capital letter.
 * First latter will be in upper case if $lcfirst == true or in lower case if $lcfirst == false.
 *
 * @param Stringable|string $s
 * @param bool              $toUpperFirstChar
 * @return string
 */
function camelize(string|Stringable $s, bool $toUpperFirstChar = false): string {
    $string = sanitize($s, '-_ ');
    $string = str_replace(['-', '_'], ' ', $string);
    $string = ucwords($string);
    $string = str_replace(' ', '', $string);
    if (!$toUpperFirstChar) {
        return lcfirst($string);
    }
    return $string;
}

/**
 * Replaces the '_' character with space, works for camelCased strings also:
 * 'camelCased' -> 'camel cased'. Leaves other characters as is.
 * By default applies e() to escape of HTML special characters.
 */
function humanize(string|Stringable|int $list, bool $escape = true) {
    $result = preg_replace_callback(
        '/([a-z])([A-Z])/s',
        function ($m) {
            return $m[1] . ' ' . strtolower($m[2]);
        },
        str_replace('_', ' ', (string )$list)
    );
    if ($escape) {
        $result = e($result);
    }
    return $result;
}

/**
 * Works like humanize() except makes all words titleized:
 * 'foo bar_baz' -> 'Foo Bar Baz'
 * or only first word:
 * 'foo bar_baz' -> 'Foo bar baz'
 *
 * @param string|Stringable|int|float $list
 * @param bool                        $ucwords If == true -> all words will be titleized, else only first word will
 *                        titleized.
 * @param bool                        $escape Either need to apply escaping of HTML special chars?
 *
 * @return string.
 */
function titleize(string|Stringable|int|float $list, bool $ucwords = true, bool $escape = true): string {
    $result = humanize($list, $escape);
    if ($ucwords) {
        return ucwords($result);
    }

    return \ucfirst($result);
}

function sanitize(string|Stringable|int $list, string $allowedCharacters, bool $deleteDups = true) {
    $regexp = '/[^a-zA-Z0-9' . preg_quote($allowedCharacters, '/') . ']/s';
    $result = preg_replace($regexp, '', (string)$list);
    if ($deleteDups) {
        $result = deleteDups($result, $allowedCharacters);
    }

    return $result;
}

/**
 * extended trim/etrim: modified version of \trim() that removes all characters from the $chars and whitespaces until non of them will be present in the ends of the source string.
 */
function etrim(string|Stringable|iterable|int|float $list, string $chars = null): string|array {
    if (is_array($list)) {
        $r = [];
        foreach ($list as $k => $v) {
            $r[$k] = $v === null ? '' : etrim($v, $chars);
        }
        return $r;
    }
    return trim((string)$list, $chars . TRIM_CHARS);
}

/**
 * Removes duplicated characters from the string.
 *
 * @param Stringable|int|string|float $list Source string with duplicated characters.
 * @param Stringable|int|string|float $chars Either a set of characters to use in character class or a reg-exp pattern that must match
 *                               all duplicated characters that must be removed.
 * @param bool                        $isCharClass
 * @return string                String with removed duplicates.
 */
function deleteDups(string|Stringable|int|float $list, Stringable|int|string|float $chars, bool $isCharClass = true) {
    $regExp = $isCharClass
        ? '/([' . preg_quote((string)$chars, '/') . '])+/si'
        : "/($chars)+/si";
    return preg_replace($regExp, '\1', (string)$list);
}

function format(string $s, array $args, callable $format): string {
    $from = $to = [];
    foreach ($args as $key => $value) {
        $from[] = '{' . $key . '}';
        $to[] = $format($value);
    }
    return str_replace($from, $to, $s);
}

function shorten(string $text, int $length = SHORTEN_LENGTH, $tail = null): string {
    if (strlen($text) <= $length) {
        return $text;
    }
    if (null === $tail) {
        $tail = SHORTEN_TAIL;
    }
    return substr($text, 0, $length - strlen($tail)) . $tail;
}

function normalizeEols(string $list): string {
    return str_replace(["\r\n", "\n", "\r"], "\n", $list);
    /*$res = \preg_replace(EOL_FULL_RE, "\n", $list);
    if (null === $res) {
        throw new Exception("Unable to replace EOLs");
    }
    return $res;*/
}

function toStr(iterable $it, string $eol = "\n"): string {
    $result = '';
    foreach ($it as $v) {
        $result .= (string)$v . $eol;
    }
    return $result;
}

function toJson(mixed $value, int $flags = null): string {
    if (null === $flags) {
        $flags = -1;
    }
    return json_encode($value, $flags & JSON_PRETTY_PRINT | JSON_UNESCAPED_SLASHES | JSON_UNESCAPED_UNICODE);
}

function fromJson(string $json, bool $objectsToArrays = true): mixed {
    $res = json_decode($json, $objectsToArrays);
    if (null === $res) {
        throw new Exception("Invalid JSON or too deep data");
    }
    return $res;
}

function toYaml(mixed $value): string {
    return Yaml::dump($value, 9999, 2);
}

function fromYaml(string $yaml): mixed {
    return Yaml::parse($yaml);
}

/**
 * Sets properties of the object $instance using values from $props
 * @param object   $instance
 * @param iterable $props E.g.: ['myProp1' => 'myVal1', 'myProp2' => 'myVal2'];
 * @return object
 */
function setProps(object $instance, iterable $props): object {
    $assignProps = function ($props) {
        $knownProps = array_fill_keys(array_keys(get_object_vars($this)), true);
        foreach ($props as $name => $value) {
            if (!isset($knownProps[$name])) {
                throw new UnexpectedValueException("Unknown property '$name'");
            }
            $this->$name = $value;
        }
    };
    $assignProps->call($instance, $props);
    return $instance;
}

/**
 * @param string $haystack
 * @param string $needle
 * @param int    $offset
 * @return int|false
 */
function lastPos(string $haystack, string $needle, int $offset = 0) {
    if ($needle === '') {
        return $offset >= 0 ? $offset : 0;
    }
    if ($haystack === '') {
        return false;
    }
    return mb_strrpos($haystack, $needle, $offset);
}


function capture(callable $fn): string {
    ob_start();
    try {
        $fn();
    } catch (Throwable $e) {
        // Don't output any result in case of Error
        ob_end_clean();
        throw $e;
    }
    return ob_get_clean();
}

function tpl(string $__filePath, array $__vars = null): string {
    extract((array)$__vars, EXTR_SKIP);
    unset($__vars);
    ob_start();
    try {
        require $__filePath;
    } catch (Throwable $e) {
        // Don't output any result in case of Error
        ob_end_clean();
        throw $e;
    }
    return ob_get_clean();
}

/**
 * Modified version of the operator() from the https://github.com/nikic/iter
 * @Copyright (c) 2013 by Nikita Popov.
 */
function op(string $operator, $arg = null): Closure {
    $functions = [
        'instanceof' => function ($a, $b) {
            return $a instanceof $b;
        },
        '*'          => function ($a, $b) {
            return $a * $b;
        },
        '/'          => function ($a, $b) {
            return $a / $b;
        },
        '%'          => function ($a, $b) {
            return $a % $b;
        },
        '+'          => function ($a, $b) {
            return $a + $b;
        },
        '-'          => function ($a, $b) {
            return $a - $b;
        },
        '.'          => function ($a, $b) {
            return $a . $b;
        },
        '<<'         => function ($a, $b) {
            return $a << $b;
        },
        '>>'         => function ($a, $b) {
            return $a >> $b;
        },
        '<'          => function ($a, $b) {
            return $a < $b;
        },
        '<='         => function ($a, $b) {
            return $a <= $b;
        },
        '>'          => function ($a, $b) {
            return $a > $b;
        },
        '>='         => function ($a, $b) {
            return $a >= $b;
        },
        '=='         => function ($a, $b) {
            return $a == $b;
        },
        '!='         => function ($a, $b) {
            return $a != $b;
        },
        '==='        => function ($a, $b) {
            return $a === $b;
        },
        '!=='        => function ($a, $b) {
            return $a !== $b;
        },
        '&'          => function ($a, $b) {
            return $a & $b;
        },
        '^'          => function ($a, $b) {
            return $a ^ $b;
        },
        '|'          => function ($a, $b) {
            return $a | $b;
        },
        '&&'         => function ($a, $b) {
            return $a && $b;
        },
        '||'         => function ($a, $b) {
            return $a || $b;
        },
        '**'         => function ($a, $b) {
            return pow($a, $b);
        },
        '<=>'        => function ($a, $b) {
            return $a == $b ? 0 : ($a < $b ? -1 : 1);
        },
    ];

    if (!isset($functions[$operator])) {
        throw new InvalidArgumentException("Unknown operator \"$operator\"");
    }

    $fn = $functions[$operator];
    if (func_num_args() === 1) {
        // Return a function which expects 2 arguments.
        return $fn;
    } else {
        // Capture the first argument of the binary operator, return a function which expect the second one (partial application and currying).
        return function ($a) use ($fn, $arg) {
            return $fn($a, $arg);
        };
    }
}

function not(callable $predicate): Closure {
    return function (...$args) use ($predicate) {
        return !$predicate(...$args);
    };
}

/**
 * @todo: support up to 10 functions.
 * Left composition.
 * Returns a new function which will call $f after $g with some value $value: $f($g($value)).
 */
function compose(callable $a, callable $b, callable $c = null): Closure {
    $n = func_num_args();
    if ($n == 2) {
        return function ($v) use ($a, $b) {
            return $a($b($v));
        };
    } elseif ($n == 3) {
        return function ($v) use ($a, $b, $c) {
            return $a($b($c($v)));
        };
    } else {
        throw new NotImplementedException();
    }
}

/**
 * Right composition.
 */
function rcompose(callable $a, callable $b, callable $c = null): Closure {
    $n = func_num_args();
    if ($n == 2) {
        return function ($v) use ($a, $b) {
            return $b($a($v));
        };
    } elseif ($n == 3) {
        return function ($v) use ($a, $b, $c) {
            return $c($b($a($v)));
        };
    } else {
        throw new NotImplementedException();
    }
}

/**
 * @return mixed
 */
function requireFile(string $__filePath, bool $__once = false) {
    if ($__once) {
        return require_once $__filePath;
    }
    return require $__filePath;
}

// @TODO: Move to Byte??, merge with Converter, parseQuantity()

function formatBytes(string $bytes, string $format = null): string {
    $n = strlen($bytes);
    $s = '';
    $format = $format ?: '\x%02x';
    for ($i = 0; $i < $n; $i++) {
        $s .= sprintf($format, ord($bytes[$i]));
    }
    return $s;
}

function formatFloat($value): string {
    if (empty($value)) {
        $value = 0;
    }
    $value = str_replace(',', '.', (string)$value);
    return number_format(round(floatval($value), 2), 2, '.', ' ');
}

function hash(mixed $var): string {
    // @TODO: Use it in memoize, check all available types.
    throw new NotImplementedException();
    //return md5(json_encode($arr));
}

function equals($a, $b) {
    throw new NotImplementedException();
}

/**
 * @TODO: This method can't reliable say when a function is called with different arguments.
 */
function memoize(callable $fn): Closure {
    return function (...$args) use ($fn) {
        static $memo = [];
        /*
                $hash = \array_reduce($args, function ($acc, $var) {
                    $hash = '';
                    if (\is_object($var)) {
                        $hash .= spl_object_hash($var);
                    } elseif (\is_scalar($var)) { //  int, float, string and bool
                    return $hash;
                });
        */
        // @TODO: avoid overwritting different functions called with the same arguments.
        $hash = md5(json_encode($args)); // NB: \md5() can cause collisions
        if (array_key_exists($hash, $memo)) {
            return $memo[$hash];
        }
        return $memo[$hash] = $fn(...$args);
    };
}

function any(callable $predicate, iterable $list): bool {
    foreach ($list as $key => $value) {
        if ($predicate($value, $key)) {
            return true;
        }
    }
    return false;
}

function apply(callable $fn, $iter): void {
    if (is_string($iter)) {
        // todo: use mb_*
        if ($iter !== '') {
            throw new NotImplementedException();
        }
    } else {
        foreach ($iter as $k => $v) {
            $fn($v, $k);
        }
    }
}

function pipe($iter, mixed $value): mixed {
    if (is_string($iter)) {
        // todo: use mb_*
        if ($iter !== '') {
            throw new NotImplementedException();
        }
    } else {
        foreach ($iter as $v) {
            $value = $v($value);
        }
    }
    return $value;
}

/**
 * Modified version from the https://github.com/nikic/iter
 * @Copyright (c) 2013 by Nikita Popov.
 *
 * Chains the iterables that were passed as arguments.
 *
 * The resulting iterator will contain the values of the first iterable, then the second, and so on.
 *
 * Example:
 *     chain(range(0, 5), range(6, 10), range(11, 15))
 *     => iterable(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15)
 * function chain(...$iterables): iterable {
 * // @TODO: Handle strings
 * //_assertAllIterable($iterables);
 * foreach ($iterables as $iterable) {
 * foreach ($iterable as $key => $value) {
 * yield $key => $value;
 * }
 * }
 * }
 */
function contains(iterable|string $haystack, mixed $needle): bool {
    if (is_string($haystack)) {
        if ($needle === '') {
            return true;
        }
        //mb_strpos() ??
        return false !== strpos($haystack, $needle);
    } elseif (is_array($haystack)) {
        return in_array($needle, $haystack, true);
    } else {
        // @TODO: iterable
        throw new NotImplementedException();
    }
}

/**
 * @param string|iterable $iter
 * @return string|Generator|array
 *     string if $list : string
 *     array if $list : array
 *     Generator otherwise
 */
function filter(callable $predicate, $iter) {
    if (is_string($iter)) {
        if ($iter !== '') {
            throw new NotImplementedException();
        }
        return '';
    }
    if (is_array($iter)) {
        $res = [];
        foreach ($iter as $k => $v) {
            if ($predicate($v, $k)) {
                $res[$k] = $v;
            }
        }
        return array_is_list($iter) ? array_values($res) : $res;
    } else {
        return (function () use ($predicate, $iter) {
            foreach ($iter as $k => $v) {
                if ($predicate($v, $k)) {
                    yield $k => $v;
                }
            }
        })();
    }
}

/**
 * Modified version from the https://github.com/nikic/iter
 * @Copyright (c) 2013 by Nikita Popov.
 *
 * Applies a function to each value in an iterator and flattens the result.
 *
 * The function is passed the current iterator value and should return an
 * iterator of new values. The result will be a concatenation of the iterators
 * returned by the mapping function.
 *
 * Examples
 *     flatMap(function($v) { return [-$v, $v]; }, [1, 2, 3, 4, 5]);
 *     => iterable(-1, 1, -2, 2, -3, 3, -4, 4, -5, 5)
 *
 * @param callable        $fn Mapping function: iterable function(mixed $value)
 * @param iterable|string $iter Iterable to be mapped over
 *
 * @return string|Generator|array
 */
function flatMap(callable $fn, $iter) {
    if (is_string($iter)) {
        if ($iter !== '') {
            throw new NotImplementedException();
        }
        return '';
    }
    if (is_array($iter)) {
        $newArr = [];
        foreach ($iter as $value) {
            foreach ($fn($value) as $k => $v) {
                $newArr[$k] = $v;
            }
        }
        return $newArr;
    }
    // @TODO: Handle strings
    return (function () use ($fn, $iter) {
        foreach ($iter as $value) {
            foreach ($fn($value) as $k => $v) {
                yield $k => $v;
            }
        }
    })();
}

/**
 * For abcd returns a
 */
function head($list, string $separator = null) {
    if (is_array($list)) {
        if (!count($list)) {
            throw new Exception('Empty list');
        }
        return array_shift($list);
    } elseif (is_string($list)) {
        if ($list === '') {
            throw new Exception('Empty list');
        }
        // @TODO, mb_substr()
        if (null === $separator) {
            return substr($list, 0, 1);
        }
        $pos = strpos($list, $separator);
        return false === $pos
            ? $list
            : substr($list, 0, $pos);
    } else {
        $empty = true;
        $head = null;
        foreach ($list as $v) {
            $empty = false;
            $head = $v;
            break;
        }
        if ($empty) {
            throw new Exception('Empty list');
        }
        return $head;
    }
}

/**
 * For abcd returns abc
 */
function init($list, string $separator = null) {
    if (is_array($list)) {
        if (!count($list)) {
            throw new Exception('Empty list');
        }
        return array_slice($list, 0, -1, true);
    } elseif (is_string($list)) {
        if ($list === '') {
            throw new Exception('Empty list');
        }
        /*
        $parts = explode($separator, $list);
        \array_pop($parts);
        return \implode('\\', $parts);
        */
        // @TODO, mb_substr()
        $pos = strrpos($list, $separator);
        return false === $pos
            ? ''
            : substr($list, 0, $pos);
    } else {
        $empty = true;
        foreach ($list as $_) {
            $empty = false;
        }
        if ($empty) {
            throw new Exception('Empty list');
        }
        throw new NotImplementedException();
    }
}

/**
 * For abcd returns d
 */
function last($list, string $separator = null) {
    if (is_array($list)) {
        if (!count($list)) {
            throw new Exception('Empty list');
        }
        return array_pop($list);
    } elseif (is_string($list)) {
        if ($list === '') {
            throw new Exception('Empty list');
        }
        // @TODO, mb_substr()
        if (null === $separator) {
            return substr($list, -1);
        }
        $pos = strrpos($list, $separator);
        return false === $pos
            ? $list
            : substr($list, $pos + 1);
    } else {
        $empty = true;
        $last = null;
        foreach ($list as $v) {
            $empty = false;
            $last = $v;
        }
        if ($empty) {
            throw new Exception('Empty list');
        }
        return $last;
    }
}

/**
 * For abcd returns bcd
 */
function tail($list, string $separator = null) {
    if (is_array($list)) {
        if (!count($list)) {
            throw new Exception('Empty list');
        }
        array_shift($list);
        return $list;
    } elseif (is_string($list)) {
        if ($list === '') {
            throw new Exception('Empty list');
        }
        // @TODO, mb_substr()
        $pos = strpos($list, $separator);
        return false === $pos
            ? ''
            : substr($list, $pos + 1);
    } else {
        $empty = true;
        $gen = function () use ($list, &$empty) {
            foreach ($list as $v) {
                if ($empty) {
                    $empty = false;
                } else {
                    yield $v;
                }
            }
            if ($empty) {
                throw new Exception('Empty list');
            }
        };
        return $gen();
    }
}

/**
 * @return string|Generator|array
 * @todo: Ensure it works like fmap for Functor, preserving structure
 */
function map(callable $fn, $it, bool $passKey = false) {
    if (is_string($it)) {
        // @TODO: Handle strings
        if ($it !== '') {
            throw new NotImplementedException();
        }
        return '';
    }
    if (is_array($it)) {
        $newArr = [];
        foreach ($it as $k => $v) {
            if ($passKey) {
                $newArr[$k] = $fn($v, $k);
            } else {
                $newArr[$k] = $fn($v);
            }
        }
        return $newArr;
    }
    return (function () use ($fn, $it, $passKey) {
        foreach ($it as $k => $v) {
            if ($passKey) {
                yield $k => $fn($v, $k);
            } else {
                yield $k => $fn($v);
            }
        }
    })();
}

/**
 * Modified reduce() from the https://github.com/nikic/iter
 * @Copyright (c) 2013 by Nikita Popov.
 *
 * Left fold: folds $list using a function $fn into a single value. The `reduce` function also known as the `fold`.
 *
 * Examples:
 *      lfold(op('+'), range(1, 5), 0)
 *      => 15
 *      lfold(op('*'), range(1, 5), 1)
 *      => 120
 *
 * @param callable(mixed, mixed, mixed): mixed $fn Reduction function: (mixed $acc, mixed $curValue, mixed $curKey)
 *     where $acc is the accumulator
 *           $curValue is the current element
 *           $curKey is a key of the current element
 *     The reduction function must return a new accumulator value.
 * @param iterable<mixed, mixed>|string        $list Iterable to reduce.
 * @param mixed                                $initial Start value for accumulator. Usually identity value of $function.
 *
 * @return mixed Result of the reduction.
 */
function lfold(callable $fn, iterable|string $list, mixed $initial = null): mixed {
    if (is_iterable($list)) {
        $acc = $initial;
        foreach ($list as $key => $cur) {
            $acc = $fn($acc, $cur, $key);
        }
        return $acc;
    }
    // @TODO:  array mb_split ( string $pattern , string $string [, int $limit = -1 ] )
    throw new NotImplementedException();
}

/**
 * ucfirst() working for UTF-8, https://www.php.net/manual/en/function.ucfirst.php#57298
 * @param string|Stringable $list
 * @return string
 */
function ucfirst(string|Stringable $list): string {
    $list = (string)$list;
    $fc = mb_strtoupper(mb_substr($list, 0, 1));
    return $fc . mb_substr($list, 1);
}

/**
 * Returns all subsets (order is not important) of length $k.
 * @param array $set
 * @param int   $k The length of subsets, if < 0, then all subsets will be returned.
 * @return array
 */
function subsets(array $set, int $k = -1): array {
    if ($k == 0) {
        return [[]]; // 2^0
    }
    if (count($set) > (8 * PHP_INT_SIZE)) {
        throw new OutOfBoundsException(
            'Too large array/set, max number of elements of the input can be ' . (8 * PHP_INT_SIZE)
        );
    }
    // Original algo is written by Brahmananda (https://www.quora.com/How-do-I-generate-all-subsets-of-a-set-in-Java-iteratively)
    $subsets = [];
    $n = count($set);
    $numOfSubsets = 1 << $n; // 2^$n
    for ($i = 0; $i < $numOfSubsets; $i++) {
        $subsetBits = $i;
        $subset = [];
        for ($j = 0; $j < $n; $j++) { // $n is the width of the bit field, number of elements in the input set.
            if ($subsetBits & 1) {  // is the right bit is 1?
                $subset[] = $set[$j];
            }
            $subsetBits = $subsetBits >> 1; // process next bit
        }
        if ($k > 0) {
            if (count($subset) == $k) {
                $subsets[] = $subset;
            }
        } else {
            $subsets[] = $subset;
        }
    }
    return $subsets;
}

function isSubset(array $arrA, array $arrB): bool {
    return intersect($arrA, $arrB) == $arrB;
}

/**
 * Union for sets, for difference use \array_diff(), for intersection use \array_intersect().
 */
function union(...$arr): array {
    // @TODO: make it work for array of arrays and other cases.
    return array_unique(array_merge(...$arr));
}

function intersect(...$arr): array {
    return array_intersect_key(...$arr);
}

function cartesianProduct(array $arrA, array $arrB) {
    // @TODO: work for iterable
    $res = [];
    foreach ($arrA as $v1) {
        foreach ($arrB as $v2) {
            $res[] = [$v1, $v2];
        }
    }
    return $res;
}

/**
 * @psalm-param array<string, mixed> $set
 * @return array
 */
function permutations(array $set): array {
    // todo: https://en.wikipedia.org/wiki/Heap%27s_algorithm

    $perms = function (array $set): array {
        $n = count($set);

        $permutations = [];

        $permutations[] = $set;

        if ($n <= 1) {
            return $permutations;
        }
        if ($n == 2) {
            $permutations[] = [$set[1], $set[0]];
            return $permutations;
        }
        throw new UnexpectedValueException();
    };

    if (count($set) <= 2) {
        return $perms($set);
    }

    $permutations = [];
    $i = 0;
    $origSet = $set;
    $n = count($set);
    while (true) {
        $set = $origSet;
        $removed = array_splice($set, $i, 1);
        foreach (permutations($set) as $permutation) {
            $permutations[] = array_merge($removed, $permutation);
        }
        $i++;
        if ($i >= $n) {
            break;
        }
    }
    return $permutations;
}

/**
 * @psalm-param array<string, mixed> $arr
 */
function combinations(array $arr): array {
    throw new NotImplementedException();
}

/**
 * Modified \Zend\Stdlib\ArrayUtils::merge() from the http://github.com/zendframework/zf2
 *
 * Merge two arrays together.
 *
 * If an integer key exists in both arrays and preserveNumericKeys is false, the value
 * from the second array will be appended to the first array. If both values are arrays, they
 * are merged together, else the value of the second array overwrites the one of the first array.
 */
function merge(array $a, array $b, bool $resetIntKeys = true): array {
    foreach ($b as $key => $value) {
        if (isset($a[$key]) || array_key_exists($key, $a)) {
            if ($resetIntKeys && is_int($key)) {
                $a[] = $value;
            } elseif (is_array($value) && is_array($a[$key])) {
                $a[$key] = merge($a[$key], $value, $resetIntKeys);
            } else {
                $a[$key] = $value;
            }
        } else {
            $a[$key] = $value;
        }
    }
    return $a;
}

/**
 * Symmetrical difference of the two sets: ($a \ $b) U ($b \ $a).
 * If for $a[$k1] and $b[$k2] string keys are equal the value $b[$k2] will overwrite the value $a[$k1].
 */
function symDiff(array $a, array $b, bool $asUnion = true): array {
    $diffA = array_diff($a, $b);
    $diffB = array_diff($b, $a);
    if ($asUnion) {
        return union($diffA, $diffB);
    }
    if ($diffA || $diffB) {
        $aIsList = array_is_list($a);
        $bIsList = array_is_list($b);
        if ($aIsList) {
            if ($bIsList) {
                // Both $a and $b is list
                return [array_values($diffA), array_values($diffB)];
            }
            // Only $a is list;
            return [array_values($diffA), $diffB];
        } else {
            if ($bIsList) {
                // Only $b is list
                return [$diffA, array_values($diffB)];
            }
            // neither $a nor $b is list
            return [$diffA, $diffB];
        }
    }
    return [];
}

function unsetOne(array $arr, mixed $value, bool $resetIntKeys = true, bool $allOccur = false, bool $strict = true): array {
    while (true) {
        $key = array_search($value, $arr, $strict);
        if (false === $key) {
            break;
        }
        unset($arr[$key]);
        if (!$allOccur) {
            break;
        }
    }
    return $resetIntKeys && all(fn($key) => is_int($key), array_keys($arr))
        ? array_values($arr)
        : $arr;
}

function unsetMany(
    array $arr,
    iterable $value,
    bool $resetIntKeys = true,
    bool $allOccur = false,
    bool $strict = true
): array {
    // NB: unsetMany() can't merged with unsetOne() as $value in unsetOne() can be array (iterable), i.e. unsetOne() has to support unsetting arrays.
    foreach ($value as $v) {
        while (true) {
            $key = array_search($v, $arr, $strict);
            if (false === $key) {
                break;
            }
            unset($arr[$key]);
            if (!$allOccur) {
                break;
            }
        }
    }
    return $resetIntKeys && all(fn($key) => is_int($key), array_keys($arr))
        ? array_values($arr)
        : $arr;
}

/**
 * Unsets all items of array with $key recursively.
 * @todo: remove reference
 * todo: make it work similar to unsetOne() and unsetMulti(), rename
 */
function unsetRecursive(array &$arr, $key): array {
    unset($arr[$key]);
    foreach (array_keys($arr) as $k) {
        if (is_array($arr[$k])) {
            unsetRecursive($arr[$k], $key);
        }
    }
    return $arr;
}

function flatten(array $arr): array {
    /*
    @todo: compare with
    $a = array(1,2,array(3,4, array(5,6,7), 8), 9);
    $it = new RecursiveIteratorIterator(new RecursiveArrayIterator($a));
    foreach($it as $v) {
    echo $v, " ";
    }
    */
    $result = [];
    foreach ($arr as $value) {
        if (is_array($value)) {
            $result = array_merge($result, flatten($value));
        } else {
            // @todo: add $preserveKeys argument or $asList, normalize argument name across all base functions: $result[$key] = $value;
            $result[] = $value;
        }
    }
    return $result;
}

function only(array $arr, array $keys, $createMissingItems = true): array {
    if ($createMissingItems) {
        $newArr = [];
        foreach ($keys as $key) {
            $newArr[$key] = $arr[$key] ?? null;
        }
        return $newArr;
    }
    return array_intersect_key($arr, array_flip(array_values($keys)));
}

/**
 * Compares sets not strictly. Each element of each array must be scalar. NB: It is not the same as comparing arrays as order for sets is not important.
 * @return bool
 */
function setsEqual(array $arrA, array $arrB): bool {
    return count($arrA) === count($arrB) && count(array_diff($arrA, $arrB)) === 0;
}

function index(array $matrix, $keyForIndex, bool $drop = false): array {
    $result = [];
    foreach ($matrix as $row) {
        if (!isset($row[$keyForIndex])) {
            throw new Exception();
        }
        $k = $row[$keyForIndex];
        if ($drop) {
            unset($row[$keyForIndex]);
        }
        $result[$k] = $row;
    }
    return $result;
}

function camelizeKeys(array $arr): array {
    $result = [];
    foreach ($arr as $key => $value) {
        $result[camelize($key)] = $value;
    }
    return $result;
}

function underscoreKeys(array $arr): array {
    $result = [];
    foreach ($arr as $key => $value) {
        $result[underscore($key)] = $value;
    }
    return $result;
}

/**
 * @param array<string> $regexes
 * @return string
 */
function compileRe(array $regexes, string $subpatternOpts = null): string {
    return '(' . $subpatternOpts . str_replace('~', '\~', implode('|', $regexes)) . ')';
}

function isUtf8Text(string $text): bool {
    return (bool)preg_match('/.*/us', $text); // [u/PCRE_UTF8](https://www.php.net/manual/en/reference.pcre.pattern.modifiers.php)
}

function with(IDisposable $disposable, mixed $value = null): mixed {
    try {
        $result = $disposable($value);
    } finally {
        $disposable->dispose();
    }
    return $result;
}

function withStream(callable $fn, string $bytes, string $source = null): mixed {
    try {
        $stream = mkStream($bytes, $source);
        return $fn($stream);
    } finally {
        if (isset($stream) && is_resource($stream)) {
            fclose($stream);
        }
    }
}

/**
 * @param string      $bytes
 * @param string|null $fileName
 * @return resource
 */
function mkStream(string $bytes = null, string $fileName = null) {
    if (null === $fileName) {
        $fileName = 'php://memory';
    } else {
        Must::beTruthy(str_starts_with($fileName, 'php://'), 'The source must start with php://');
    }
    $stream = fopen($fileName, 'r+');
    if (!$stream) {
        throw new Exception('Unable to allocate memory');
    }
    if (null !== $bytes) {
        fwrite($stream, $bytes);
    }
    rewind($stream);
    return $stream;
}

function reorderKeys(array $arr, array $keys): array {
    $res = [];
    foreach ($keys as $k) {
        $res[$k] = $arr[$k];
    }
    return $res;
}

/**
 * @return mixed The truthy result from the predicate
 */
function waitUntilNumOfAttempts(callable $predicate, int $waitIntervalMicroSec = null, int $numOfAttempts = 30) {
    if (null === $waitIntervalMicroSec) {
        $waitIntervalMicroSec = WAIT_INTERVAL_MICRO_SEC;
    }
    for ($i = 0; $i < $numOfAttempts; $i++) {
        $res = $predicate();
        if ($res) {
            return $res;
        }
        usleep($waitIntervalMicroSec);
    }
    throw new Exception('The number of attempts has been reached');
}

/**
 * @return mixed The truthy result from the predicate
 */
function waitUntilTimeout(callable $predicate, int $timeoutMicroSec) {
    $now = microtime(true);
    $limitMicroSec = $now + $timeoutMicroSec;
    for ($timeMicroSec = $now; $timeMicroSec < $limitMicroSec; $timeMicroSec += microtime(true)) {
        $res = $predicate();
        if ($res) {
            return $res;
        }
        usleep($timeoutMicroSec);
    }
    throw new Exception('The timeout has been reached');
}
