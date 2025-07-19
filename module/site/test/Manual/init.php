<?php declare(strict_types=1);
/**
 * This file is part of njcom/framework
 * It is distributed under the 'Apache License Version 2.0' license.
 * See the https://github.com/njcom/framework/blob/main/LICENSE for the full license text.
 */
namespace Morpho\Test\Manual;

use ErrorException;
use RuntimeException;

use function error_reporting;
use function ini_get;
use function ini_set;
use function set_error_handler;

error_reporting(E_ALL);
ini_set('display_errors', '1');
set_error_handler(
    function ($severity, $message, $filePath, $lineNo) {
        if (!(error_reporting() & $severity)) {
            return;
        }
        throw new ErrorException($message, 0, $severity, $filePath, $lineNo);
    }
);
if (ini_get('zend.assertions') !== '1') {
    throw new RuntimeException("The 'zend.assertions' ini parameter must be set to 1 for expectations");
}

require __DIR__ . '/../../vendor/autoload.php';