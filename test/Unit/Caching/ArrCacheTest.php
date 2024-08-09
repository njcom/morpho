<?php declare(strict_types=1);
/**
 * This file is part of njcom/framework
 * It is distributed under the 'Apache License Version 2.0' license.
 * See the https://github.com/njcom/framework/blob/main/LICENSE for the full license text.
 */
namespace Morpho\Test\Unit\Caching;

use Morpho\Caching\ArrCache;
use Morpho\Caching\ICache;

class ArrCacheTest extends CacheTest {
    protected function mkCache(): ICache {
        return new ArrCache();
    }
}
