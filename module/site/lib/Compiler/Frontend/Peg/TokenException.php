<?php declare(strict_types=1);
/**
 * This file is part of njcom/framework
 * It is distributed under the 'Apache License Version 2.0' license.
 * See the https://github.com/njcom/framework/blob/main/LICENSE for the full license text.
 */
namespace Morpho\Compiler\Frontend\Peg;

// TokenError
class TokenException extends PegException {
    public function __construct(string $msg, $location) {
        // @todo: handle $args
        parent::__construct($msg . ', (' . $location[0] . ', ' . $location[1] . ')');
    }
}