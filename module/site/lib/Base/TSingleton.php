<?php declare(strict_types=1);
/**
 * This file is part of njcom/framework
 * It is distributed under the 'Apache License Version 2.0' license.
 * See the https://github.com/njcom/framework/blob/main/LICENSE for the full license text.
 */
namespace Morpho\Base;

trait TSingleton {
    private static $instance;

    public static function instance(): static {
        if (!self::$instance) {
            self::$instance = new static();
        }
        return self::$instance;
    }

    public static function resetState(): void {
        self::$instance = null;
    }
}
