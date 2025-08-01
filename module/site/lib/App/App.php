<?php declare(strict_types=1);
/**
 * This file is part of njcom/framework
 * It is distributed under the 'Apache License Version 2.0' license.
 * See the https://github.com/njcom/framework/blob/main/LICENSE for the full license text.
 */
namespace Morpho\App;

use Morpho\Base\Env;
use Morpho\Base\IFn;
use Morpho\Base\ServiceManager;
use Throwable;

use function addslashes;
use function error_log;

class App implements IFn {
    public readonly array $conf;
    private ?ServiceManager $_serviceManager = null;

    public function __construct(array|null $conf = null) {
        $this->conf = $conf ?? [];
    }

    public ?ServiceManager $serviceManager {
        set(ServiceManager|null $serviceManager) {
            $this->_serviceManager = $serviceManager;
        }
        get {
            if (!$this->_serviceManager) {
                $this->_serviceManager = $this->mkServiceManager();
            }
            return $this->_serviceManager;
        }
    }

    public function __invoke(mixed $context): mixed {
        try {
            $serviceManager = $this->serviceManager;
            try {
                $request = $serviceManager['request'];
                $request = $serviceManager['router']->__invoke($request);
                $request = $serviceManager['dispatcher']->__invoke($request);
                $response = $request->response;
                return $response->send();
            } catch (Throwable $e) {
                $errorHandler = $serviceManager['errorHandler'];
                $errorHandler->handleException($e);
            }
        } catch (Throwable $e) {
            $this->handleException($e);
        }
        return null;
    }

    protected function handleException(Throwable $e): void {
        if (Env::boolIniVal('display_errors')) {
            /** @noinspection PhpStatementHasEmptyBodyInspection */
            while (@ob_end_clean());
            echo $e;
        }
        if (Env::boolIniVal('log_errors') && !empty(ini_get('error_log'))) {
            // @TODO: check how error logging works on PHP core level, remove unnecessary calls and checks.
            error_log(addslashes((string)$e));
        }
    }

    protected function mkServiceManager(): ServiceManager {
        /** @var SiteFactory $siteFactory */
        $siteFactory = $this->conf['siteFactory']($this);
        $siteConf = $siteFactory->__invoke();

        $serviceManager = $siteConf['serviceManager'];
        $serviceManager['app'] = $this;
        $serviceManager['siteConf'] = $siteConf;
        $serviceManager->conf = $siteConf['services'];

        /** @var AppInitializer $appInitializer */
        $appInitializer = $serviceManager['appInitializer'];
        $appInitializer->init();

        return $serviceManager;
    }
}