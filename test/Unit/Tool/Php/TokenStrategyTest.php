<?php declare(strict_types=1);
/**
 * This file is part of njcom/framework
 * It is distributed under the 'Apache License Version 2.0' license.
 * See the https://github.com/njcom/framework/blob/main/LICENSE for the full license text.
 */
namespace Morpho\Test\Unit\Tool\Php;

use Morpho\Tool\Php\TokenStrategy;

class TokenStrategyTest extends DiscoverStrategyTest {
    protected function mkDiscoverStrategy() {
        return new TokenStrategy();
    }
}
