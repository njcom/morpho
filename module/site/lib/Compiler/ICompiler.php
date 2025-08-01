<?php declare(strict_types=1);
/**
 * This file is part of njcom/framework
 * It is distributed under the 'Apache License Version 2.0' license.
 * See the https://github.com/njcom/framework/blob/main/LICENSE for the full license text.
 */
namespace Morpho\Compiler;

use Morpho\Base\IPipe;

interface ICompiler extends IPipe {
    public function frontend(): callable;

    public function midend(): callable;

    public function backend(): callable;
}