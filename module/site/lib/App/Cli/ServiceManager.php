<?php declare(strict_types=1);
/**
 * This file is part of njcom/framework
 * It is distributed under the 'Apache License Version 2.0' license.
 * See the https://github.com/njcom/framework/blob/main/LICENSE for the full license text.
 */
namespace Morpho\App\Cli;

use Monolog\Handler\AbstractProcessingHandler;
use Monolog\Handler\ErrorLogHandler as PhpErrorLogWriter;
use Monolog\Logger;
use Monolog\LogRecord;
use Morpho\App\ServiceManager as BaseServiceManager;
use Morpho\Base\IFn;
use Morpho\Base\NotImplementedException;
use Morpho\Tool\Php\ErrorHandler;
use Morpho\Tool\Php\LogListener;
use Morpho\Tool\Php\NoDupsListener;

class ServiceManager extends BaseServiceManager {
    protected function mkAppInitializerService() {
        return new AppInitializer($this);
    }

    protected function mkErrorLoggerService() {
        $logger = new Logger('error');

        //if (ErrorHandler::isErrorLogEnabled()) {
        $logger->pushHandler(new PhpErrorLogWriter());
        //}

        $logger->pushHandler(
            new class extends AbstractProcessingHandler {
                protected function write(LogRecord $record): void {
                    errorLine($record['message']);
                }
            }
        );

        return $logger;
    }

    protected function mkErrorHandlerService() {
        $listeners = [];
        $logListener = new LogListener($this['errorLogger']);
        $listeners[] = $this->conf['errorHandler']['noDupsListener']
            ? new NoDupsListener($logListener)
            : $logListener;
        /*
        if ($this->conf['errorHandler']['dumpListener']) {
            $listeners[] = new DumpListener();
        }
        */
        return new ErrorHandler($listeners);
    }

    protected function mkRequestService() {
        return new Request();
    }

    protected function mkRouterService() {
        throw new NotImplementedException();
    }

    protected function mkDispatchErrorHandlerService() {
        return new class implements IFn {
            public function __invoke(mixed $context): mixed {
                throw $context['error'];
            }
        };
    }

    protected function mkResultRendererService() {
        return new ResultRenderer();
    }
}
