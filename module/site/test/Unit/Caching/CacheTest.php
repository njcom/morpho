<?php declare(strict_types=1);
/**
 * This file is part of njcom/framework
 * It is distributed under the 'Apache License Version 2.0' license.
 * See the https://github.com/njcom/framework/blob/main/LICENSE for the full license text.
 */
namespace Morpho\Test\Unit\Caching;

use ArrayIterator;
use Morpho\Caching\ICache;
use Morpho\Testing\TestCase;
use PHPUnit\Framework\Attributes\DataProvider;
use stdClass;

use function is_object;

abstract class CacheTest extends TestCase {
    public static function dataCaching() {
        yield [['foo' => 'bar']];
        yield [false];
        yield [true];
        yield [null];
        yield ['Hello World'];
        yield [3.14];
        yield [new ArrayIterator([])];
    }

    #[DataProvider('dataCaching')]
    public function testCaching($data) {
        // @TODO: get, set, delete, clear, getMultiple, setMultiple, deleteMultiple, has
        $cache = $this->mkCache();
        $key = 'my-value';
        $this->assertFalse($cache->has($key));
        $this->assertNull($cache->get($key));
        $this->assertSame('abc', $cache->get($key, 'abc'));
        $this->assertTrue($cache->set('my-value', $data));
        if (is_object($data)) {
            $this->assertEquals($data, $cache->get($key));
        } else {
            $this->assertSame($data, $cache->get($key));
        }
        $this->assertTrue($cache->delete($key));
        $this->assertFalse($cache->has($key));
        $this->assertNull($cache->get($key));
        $def = new stdClass();
        $this->assertSame($def, $cache->get($key, $def));
    }

    abstract protected function mkCache(): ICache;
}
