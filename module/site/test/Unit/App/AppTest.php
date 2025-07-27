<?php declare(strict_types=1);
/**
 * This file is part of njcom/framework
 * It is distributed under the 'Apache License Version 2.0' license.
 * See the https://github.com/njcom/framework/blob/main/LICENSE for the full license text.
 */
namespace Morpho\Test\Unit\App;

use Morpho\App\App;
use Morpho\Base\ServiceManager;
use Morpho\Testing\TestCase;

class AppTest extends TestCase {
    public function testConf_InitialVal() {
        $app = new App();
        $this->assertEquals([], $app->conf);
    }

    public function testConf_CanBePassedAsConstructorArg() {
        $newConf = ['foo' => 'bar'];
        $app = new App($newConf);
        $this->assertSame($newConf, $app->conf);
    }

    public function testServiceManagerAccessor_ReturnsTheSameServiceManagerInstance() {
        $serviceManager = new ServiceManager();
        $app = new SimpleApp($serviceManager);
        $this->assertSame($serviceManager, $app->serviceManager);
        $this->assertSame($serviceManager, $app->serviceManager);
    }
}

class SimpleApp extends App {
    public function __construct(ServiceManager $serviceManager) {
        parent::__construct();
        $this->serviceManager = $serviceManager;
    }
}