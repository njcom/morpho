<?php declare(strict_types=1);
/**
 * This file is part of njcom/framework
 * It is distributed under the 'Apache License Version 2.0' license.
 * See the https://github.com/njcom/framework/blob/main/LICENSE for the full license text.
 */
namespace Morpho\Base;

abstract class Container implements IContainer {
    protected readonly mixed $value;

    public function __construct(mixed $value) {
        $this->value = $value;
    }

    public function value(): mixed {
        return $this->value;
    }
}
