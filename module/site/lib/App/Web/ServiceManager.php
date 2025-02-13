<?php declare(strict_types=1);
/**
 * This file is part of njcom/framework
 * It is distributed under the 'Apache License Version 2.0' license.
 * See the https://github.com/njcom/framework/blob/main/LICENSE for the full license text.
 */
namespace Morpho\App\Web;

use Monolog\Formatter\LineFormatter;
use Monolog\Handler\ErrorLogHandler as PhpErrorLogWriter;
use Monolog\Handler\NativeMailerHandler as NativeMailerLogWriter;
use Monolog\Handler\StreamHandler;
use Monolog\Level as LogLevel;
use Monolog\Logger;
use Monolog\Processor\IntrospectionProcessor;
use Monolog\Processor\MemoryPeakUsageProcessor;
use Monolog\Processor\MemoryUsageProcessor;
use Morpho\App\ServiceManager as BaseServiceManager;
use Morpho\App\Web\View\HtmlResponseRenderer;
use Morpho\App\Web\View\JsonResponseRenderer;
use Morpho\App\Web\View\Messenger;
use Morpho\App\Web\View\PhpProcessor;
use Morpho\App\Web\View\TemplateEngine;
use Morpho\App\Web\View\RcProcessor;
use Morpho\Base\IHasServiceManager;
use Morpho\Tool\Php\DumpListener;
use Morpho\Tool\Php\LogListener;
use Morpho\Tool\Php\NoDupsListener;
use RuntimeException;
use UnexpectedValueException;

use function Morpho\Base\classify;

class ServiceManager extends BaseServiceManager {
    protected function mkRouterService() {
        //return new Router($this['db']);
        return new FastRouter();
    }

    protected function mkRouteMetaProviderService() {
        return new RouteMetaProvider();
    }

    protected function mkAppInitializerService() {
        return new AppInitializer($this);
    }

    protected function mkSessionService() {
        return new Session(__CLASS__);
    }

    protected function mkRequestService() {
        return new Request();
    }

    protected function mkDebugLoggerService() {
        $logger = new Logger('debug');
        $this->appendLogFileWriter($logger, LogLevel::Debug);
        return $logger;
    }

    private function appendLogFileWriter(Logger $logger, LogLevel $logLevel): void {
        $moduleIndex = $this['backendModuleIndex'];
        $filePath = $moduleIndex->module($this['siteConf']['name'])->logDirPath() . '/' . $logger->getName() . '.log';
        $handler = new StreamHandler($filePath, $logLevel);
        $handler->setFormatter(
            new LineFormatter(
                LineFormatter::SIMPLE_FORMAT . "-------------------------------------------------------------------------------\n",
                null,
                true
            )
        );
        $logger->pushHandler($handler);
    }

    protected function mkTemplateEngineService() {
        $conf = $this->conf['templateEngine'];
        //$conf['request'] = $this['request'];
        //$conf['site'] = $this['site'];
        $steps = [
            'phpProcessor'  => new PhpProcessor(),
            /*
            'uriProcessor'  => new UriProcessor($conf['request']),
            'formProcessor' => new FormProcessor($conf['request']),
            'rcProcessor'   => new RcProcessor($conf['tsCompilerFilePath']),
            */
        ];
        return new TemplateEngine($this['templateEnginePluginFactory'], $steps, $conf['forceCompile']);
    }

    protected function mkTemplateEnginePluginFactoryService() {
        if (isset($this->conf['templateEngine']['pluginFactory'])) {
            $factory = $this->conf['templateEngine']['pluginFactory'];
        } else {
            $pluginNss = $this->conf['templateEngine']['pluginNss'];
            $factory = function ($pluginName) use ($pluginNss) {
                foreach ($pluginNss as $pluginNs) {
                    $class = $pluginNs . '\\' . classify($pluginName) . 'Plugin';
                    if (class_exists($class)) {
                        $plugin = new $class();
                        if ($plugin instanceof IHasServiceManager) {
                            $plugin->setServiceManager($this);
                        }
                        return $plugin;
                    }
                }
                throw new RuntimeException("Unable to find the class of the plugin '$pluginName'");
            };
        }
        return $factory;
    }

    /*    protected function mkAutoloaderService() {
            return composerAutoloader();
        }*/

    protected function mkResultRendererService() {
        return new ResultRenderer(
            function ($format) {
                if ($format === ContentFormat::HTML) {
                    return new HtmlResponseRenderer($this['templateEngine'], $this['backendModuleIndex'], $this->conf['view']['pageRenderingModule']);
                } elseif ($format === ContentFormat::JSON) {
                    return new JsonResponseRenderer();
                }
                // todo: add XML
                throw new UnexpectedValueException();
            }
        );
    }

    protected function mkMessengerService() {
        return new Messenger();
    }

    protected function mkRouterCacheService() {
        return $this->mkCache($this['siteConf']['paths']['cacheDirPath'] . '/router');
    }

    protected function mkErrorLoggerService() {
        $logger = (new Logger('error'))
            ->pushProcessor(new LogRecordProcessor())
            ->pushProcessor(new MemoryUsageProcessor())
            ->pushProcessor(new MemoryPeakUsageProcessor())
            ->pushProcessor(new IntrospectionProcessor());

        $conf = $this->conf['errorLogger'];

        if ($conf['errorLogWriter'] && ErrorHandler::isErrorLogEnabled()) {
            $logger->pushHandler(new PhpErrorLogWriter());
        }

        if (!empty($conf['mailWriter']['enabled'])) {
            $logger->pushHandler(
                new NativeMailerLogWriter($conf['mailTo'], 'An error has occurred', $conf['mailFrom'], LogLevel::Notice)
            );
        }

        if ($conf['logFileWriter']) {
            $this->appendLogFileWriter($logger, LogLevel::Debug);
        }

        /*       if ($conf['debugWriter']) {
                   $logger->pushHandler(new class extends \Monolog\Handler\AbstractProcessingHandler {
                       protected function write(array $record): void {
                           d($record['message']);
                       }
                   });
               }*/

        return $logger;
    }

    protected function mkDispatchErrorHandlerService() {
        $dispatchErrorHandler = new DispatchErrorHandler();
        $conf = $this->conf['dispatchErrorHandler'];
        $dispatchErrorHandler->throwErrors = $conf['throwErrors'];
        $dispatchErrorHandler->exceptionHandler = $conf['exceptionHandler'];
        return $dispatchErrorHandler;
    }

    protected function mkErrorHandlerService() {
        $listeners = [];
        $logListener = new LogListener($this['errorLogger']);
        $listeners[] = $this->conf['errorHandler']['noDupsListener']
            ? new NoDupsListener($logListener)
            : $logListener;
        if ($this->conf['errorHandler']['dumpListener']) {
            $listeners[] = new DumpListener();
        }
        return new ErrorHandler($listeners);
    }
}
