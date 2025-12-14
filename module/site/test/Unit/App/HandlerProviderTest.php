<?php declare(strict_types=1);
/**
 * This file is part of njcom/framework
 * It is distributed under the 'Apache License Version 2.0' license.
 * See the https://github.com/njcom/framework/blob/main/LICENSE for the full license text.
 */
namespace Morpho\Test\Unit\App;

use Morpho\App\BackendModule;
use Morpho\App\HandlerProvider;
use Morpho\App\ModuleIndex;
use Morpho\Base\IFn;
use Morpho\Base\ServiceManager;
use Morpho\Testing\TestCase;

class HandlerProviderTest extends TestCase {
    private string $moduleName;
    private string $testNs;

    protected function setUp(): void {
        parent::setUp();
        $this->moduleName = 'foo/bar';
        $this->testNs = __CLASS__; // ns name == test class name
    }

    public function testInvoke_Function(): void {
        $serviceManager = $this->mkServiceManagerMock($this->moduleName);
        $handlerProvider = new HandlerProvider($serviceManager);

        $fnName = $this->testNs . '\\handlerProviderTest';
        $handler = [
            'module' => $this->moduleName,
            'class'  => null,
            'method' => $fnName,
            //'filePath' => __FILE__,
        ];
        $context = new class {
            public array $handler;
        };
        $context->handler = $handler;

        $callback = $handlerProvider($context);

        $request = new \stdClass;

        $result = $callback($request);

        $this->assertSame([$fnName, $request, $serviceManager], $result);
    }

    public function testInvoke_Method(): void {
        $serviceManager = $this->mkServiceManagerMock($this->moduleName);
        $handlerProvider = new HandlerProvider($serviceManager);
        $controllerClass = $this->testNs . '\\HandlerProviderTest_TestController';
        $handler = [
            'module' => $this->moduleName,
            'class'  => $controllerClass,
            'method' => '__invoke',
        ];
        $context = new class {
            public array $handler;
        };
        $context->handler = $handler;

        $callback = $handlerProvider($context);

        $this->assertIsCallable($callback);
        $this->assertInstanceOf($handler['class'], $callback[0]);
        $this->assertSame($handler['method'], $callback[1]);
    }

    public function testInterface(): void {
        $serviceManager = $this->createMock(ServiceManager::class);
        $moduleIndex = $this->createStub(ModuleIndex::class);
        $serviceManager->expects($this->atLeastOnce())
            ->method('offsetGet')
            ->with('backendModuleIndex')
            ->willReturn($moduleIndex);
        $this->assertInstanceOf(IFn::class, new HandlerProvider($serviceManager));
    }

    private function mkServiceManagerMock(string $moduleName): ServiceManager {
        $serviceManager = $this->createMock(ServiceManager::class);

        $module = $this->createConfiguredStub(
            BackendModule::class,
            ['name' => $moduleName, 'autoloadFilePath' => __FILE__]
        );

        $moduleIndex = $this->createMock(ModuleIndex::class);
        $moduleIndex->expects($this->atLeastOnce())
            ->method('module')
            ->with($moduleName)
            ->willReturn($module);
        $services = [
            'backendModuleIndex' => $moduleIndex,
        ];

        $serviceManager->expects($this->atLeastOnce())
            ->method('offsetGet')
            ->willReturnCallback(
                function ($id) use ($services) {
                    return $services[$id];
                }
            );
        return $serviceManager;
    }
}

namespace Morpho\Test\Unit\App\HandlerProviderTest;

class HandlerProviderTest_TestController {
    public function __invoke(): void {
    }
}

function handlerProviderTest($request, $serviceManager): array {
    return [__FUNCTION__, $request, $serviceManager];
}