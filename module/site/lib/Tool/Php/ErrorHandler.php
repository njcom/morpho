<?php declare(strict_types=1);
/**
 * This file is part of njcom/framework
 * It is distributed under the 'Apache License Version 2.0' license.
 * See the https://github.com/njcom/framework/blob/main/LICENSE for the full license text.
 */
namespace Morpho\Tool\Php;

use LogicException;
use Throwable;
use ArrayObject;

use function error_clear_last;
use function error_get_last;
use function error_reporting;
use function in_array;
use function register_shutdown_function;

/**
 * ErrorHandler is main error and exception handler. It transforms errors to exceptions and sends notification about exception to the attached subscribers. Based on code and ideas found at: https://github.com/DmitryKoterov/php_exceptionizer, https://github.com/DmitryKoterov/debug_errorhook
 */
class ErrorHandler {
    public bool $exitOnFatalError = true;

    public bool $registerAsFatalErrorHandler = true;

    public ArrayObject $listeners;

    private bool $fatalErrorHandlerActive = false;

    // @todo: make it public private(set) bool $registered, requires PHP 8.4
    public bool $registered = false;

    public function __construct(iterable $listeners) {
        $listeners1 = new ArrayObject();
        foreach ((array)$listeners as $listener) {
            $listeners1->append($listener);
        }
        $this->listeners = $listeners1;
    }

    public static function trackErrors(callable $fn): mixed {
        /**
         * @throws \ErrorException
         */
        $handler = function ($severity, $message, $filePath, $lineNo) {
            if (!(error_reporting() & $severity)) {
                return;
            }
            throw new \ErrorException($message, 0, $severity, $filePath, $lineNo);
        };
        set_error_handler($handler);
        $res = $fn();
        restore_error_handler();
        return $res;
    }

    public function register(): void {
        if ($this->registered) {
            throw new LogicException('Error handler already registered');
        }
        set_exception_handler($this->handleException(...));
        set_error_handler($this->handleError(...));
        if ($this->registerAsFatalErrorHandler) {
            register_shutdown_function($this->handleFatalError(...));
            $this->fatalErrorHandlerActive = true;
        }
        $this->registered = true;
    }

    public function unregister(): void {
        if (!$this->registered) {
            throw new LogicException('Error handler has not been registered');
        }
        restore_error_handler();
        restore_exception_handler();

        // There is no unregister_shutdown_function(), so we emulate it via flag.
        $this->fatalErrorHandlerActive = false;
        $this->registered = false;
    }

    public function handleError($severity, $message, $filePath, $lineNo): void {
        if ($severity & error_reporting()) {
            throw self::errorToException($severity, $message, $filePath, $lineNo);
        }
    }

    public function handleException(Throwable $e): void {
        foreach ($this->listeners as $listener) {
            $listener($e);
        }
    }

    public static function lastErrorHandler(): callable|null {
        $prevErrorHandler = set_error_handler(function () {});
        restore_error_handler();
        return $prevErrorHandler;
    }

    public static function lastExceptionHandler(): callable|null {
        $prevExceptionHandler = set_exception_handler(function () {});
        restore_exception_handler();
        return $prevExceptionHandler;
    }

    /**
     * @TODO: Check can we catch the E_ERROR, E_CORE_ERROR, E_PARSE errors, if yes, delete this method,
     * as they can will be handled by the handleError().
     */
    public function handleFatalError(): void {
        $error = error_get_last();
        error_clear_last();
        if ($this->fatalErrorHandlerActive
            && $error
            // [See for list of errors](https://wiki.php.net/rfc/engine_exceptions_for_php7#summary_of_current_error_model)
            && in_array(
                $error['type'],
                [E_ERROR, E_CORE_ERROR, E_COMPILE_ERROR, E_USER_ERROR, E_RECOVERABLE_ERROR, E_PARSE]
            )
        ) {
            $this->handleException(
                self::errorToException($error['type'], $error['message'], $error['file'], $error['line'])
            );
            if ($this->exitOnFatalError) {
                exit(1);
            }
        }
    }

    private static function errorToException($severity, $message, $filePath, $lineNo): \ErrorException {
        $levels = [
            E_ERROR             => 'ErrorException',
            E_WARNING           => 'WarningException',
            E_PARSE             => 'ParseException',
            E_NOTICE            => 'NoticeException',
            E_CORE_ERROR        => 'CoreErrorException',
            E_CORE_WARNING      => 'CoreWarningException',
            E_COMPILE_ERROR     => 'CompileErrorException',
            E_COMPILE_WARNING   => 'CompileWarningException',
            E_USER_ERROR        => 'UserErrorException',
            E_USER_WARNING      => 'UserWarningException',
            E_USER_NOTICE       => 'UserNoticeException',
            E_RECOVERABLE_ERROR => 'RecoverableErrorException',
            E_DEPRECATED        => 'DeprecatedException',
            E_USER_DEPRECATED   => 'UserDeprecatedException',
        ];
        $class = __NAMESPACE__ . '\\' . $levels[$severity];
        return new $class($message, 0, $severity, $filePath, $lineNo);
    }
}
