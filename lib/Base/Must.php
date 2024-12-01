<?php declare(strict_types=1);
/**
 * This file is part of njcom/framework
 * It is distributed under the 'Apache License Version 2.0' license.
 * See the https://github.com/njcom/framework/blob/main/LICENSE for the full license text.
 */

namespace Morpho\Base;

use function array_flip;
use function array_intersect_key;
use function array_keys;
use function count;

class Must {
    public static function beTruthy(mixed $value, string $message = null): mixed {
        if (!$value) {
            throw new MustException((string)$message, $value);
        }
        return $value;
    }

    /**
     * @param mixed $value
     * @return mixed @todo: change to null type
     */
    public static function beNull(mixed $value): mixed {
        // @todo: add $message argument
        self::beTruthy($value === null);
        return $value;
    }

    /**
     * @param mixed $value
     * @return mixed
     */
    public static function beNotNull(mixed $value): mixed {
        // @todo: add $message argument
        self::beTruthy($value !== null);
        return $value;
    }

    public static function beEmpty(mixed $value): mixed {
        // @todo: add $message argument
        self::beTruthy(empty($value), 'The value must be empty');
        return $value;
    }

    public static function beNotEmpty(mixed $value): mixed {
        // @todo: add $message
        self::beTruthy(!empty($value), 'The value must be non empty');
        return $value;
    }

    /**
     * @param             $haystack
     * @param             $needle
     * @param string|null $message
     * @return void
     */
    public static function contain($haystack, $needle, string $message = null): void {
        self::beTruthy(contains($haystack, $needle), $message ?? 'A haystack does not contain a needle');
    }

    public static function haveAtLeastKeys(array $arr, array $keys, string $message = null): array {
        $intersection = array_intersect_key(array_flip($keys), $arr);
        if (count($intersection) != count($keys)) {
            throw new MustException($message ?? 'The array must have the items with the specified keys', ['arr' => $arr, 'keys' => $keys]);
        }
        return $arr;
    }

    public static function haveExactKeys(array $arr, array $keys, string $message = null, bool $ordered = true): array {
        if (!$ordered) {
            $invalid = !empty(symDiff(array_keys($arr), $keys));
        } else {
            $invalid = array_keys($arr) !== $keys;
        }
        if ($invalid) {
            throw new MustException($message ?? 'The array must have the items with the specified keys and no other items', ['arr' => $arr, 'keys' => $keys]);
        }
        return $arr;
    }
}
