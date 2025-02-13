<?php declare(strict_types=1);
/**
 * This file is part of njcom/framework
 * It is distributed under the 'Apache License Version 2.0' license.
 * See the https://github.com/njcom/framework/blob/main/LICENSE for the full license text.
 */
namespace Morpho\App;

use Morpho\Base\ServiceManager as BaseServiceManager;
use Morpho\Caching\ICache;
use Morpho\Caching\VarExportFileCache;

abstract class ServiceManager extends BaseServiceManager {
    /**
     * @noinspection PhpUnused
     */
    protected function mkDispatcherService() {
        return new Dispatcher(new HandlerProvider($this), $this['resultRenderer'], $this['dispatchErrorHandler']);
    }

    abstract protected function mkResultRendererService();

    abstract protected function mkDispatchErrorHandlerService();

    /** @noinspection PhpUnused */
    protected function mkBackendModuleIndexService() {
        return new ModuleIndex($this['backendModuleIndexer']);
    }

    /** @noinspection PhpUnused */
    protected function mkBackendModuleIndexerService() {
        return new ModuleIndexer(
            $this['backendModuleIterator'],
            $this->mkCache($this['siteConf']['paths']['cacheDirPath'] . '/module-indexer')
        );
    }

    protected function mkCache($conf): ICache {
        return new VarExportFileCache($conf);
    }

    protected function mkBackendModuleIteratorService() {
        return new BackendModuleIterator($this['siteConf']);
    }
}
