<?php declare(strict_types=1);
/**
 * This file is part of njcom/framework
 * It is distributed under the 'Apache License Version 2.0' license.
 * See the https://github.com/njcom/framework/blob/main/LICENSE for the full license text.
 */
namespace Morpho\App;

use Morpho\Base\IFn;
use Morpho\Base\IHasServiceManager;
use Morpho\Base\ServiceManager;

class HandlerProvider implements IFn {
    protected ModuleIndex $moduleIndex;

    private array $registeredModules = [];

    private ServiceManager $serviceManager;

    public function __construct(ServiceManager $serviceManager) {
        $this->moduleIndex = $serviceManager['backendModuleIndex'];
        $this->serviceManager = $serviceManager;
    }

    public function __invoke(mixed $context): callable {
        $handler = $context->handler;
        $module = $this->moduleIndex->module($handler['module']);
        $this->registerModuleClassLoader($module);
        if (null !== $handler['class']) {
            $instance = new $handler['class'];
            if ($instance instanceof IHasServiceManager) {
                $instance->setServiceManager($this->serviceManager);
            }
            return [$instance, $handler['method']];
        }
        $serviceManager = $this->serviceManager;
        return static function ($request) use ($handler, $serviceManager) {
            $fn = $handler['method'];
            if (!function_exists($fn)) {
                require_once $handler['filePath'];
            }
            return $fn($request, $serviceManager);
        };
    }

    protected function registerModuleClassLoader(Module $module): void {
        // @TODO: Register simple common autoloader, which must try to load the class using simple scheme, then call Composer's autoloader in case of failure.
        $moduleName = $module->name();
        if (!isset($this->registeredModules[$moduleName])) {
            require_once $module->autoloadFilePath();
            $this->registeredModules[$moduleName] = true;
        }
    }
}
