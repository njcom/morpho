<?php declare(strict_types=1);
/**
 * This file is part of njcom/framework
 * It is distributed under the 'Apache License Version 2.0' license.
 * See the https://github.com/njcom/framework/blob/main/LICENSE for the full license text.
 */
namespace Morpho\App;

use ArrayObject;

class Module extends ArrayObject {
    protected string $name;

    public function __construct(string $name, $conf) {
        $this->name = $name;
        parent::__construct($conf);
    }

    public function name(): string {
        return $this->name;
    }

    public function dirPath(): string {
        return $this['paths']['dirPath'];
    }
}
