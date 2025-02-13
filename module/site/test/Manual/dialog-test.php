<?php declare(strict_types=1);
/**
 * This file is part of njcom/framework
 * It is distributed under the 'Apache License Version 2.0' license.
 * See the https://github.com/njcom/framework/blob/main/LICENSE for the full license text.
 */
namespace Morpho\Test\Manual;

use Morpho\App\Cli\Dialog;
use Morpho\Fs\Dir;

require __DIR__ . '/init.php';

//Dialog::fselect(__DIR__);
Dialog::radiolist(['foo', 'bar']);
