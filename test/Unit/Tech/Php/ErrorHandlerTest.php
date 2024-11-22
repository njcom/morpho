<?php declare(strict_types=1);
/**
 * This file is part of njcom/framework
 * It is distributed under the 'Apache License Version 2.0' license.
 * See the https://github.com/njcom/framework/blob/main/LICENSE for the full license text.
 */
namespace Morpho\Test\Unit\Tech\Php;

use ArrayObject;
use Closure;
use ErrorException;
use LogicException;
use Morpho\Tech\Php\ErrorHandler;
use Morpho\Tech\Php\UserDeprecatedException;
use Morpho\Tech\Php\UserErrorException;
use Morpho\Tech\Php\UserNoticeException;
use Morpho\Tech\Php\UserWarningException;
use Morpho\Testing\TestCase;
use PHPUnit\Framework\Attributes\DataProvider;
use ReflectionFunction;

use RuntimeException;

use function trigger_error;

class ErrorHandlerTest extends TestCase {
    protected function setUp(): void {
        parent::setUp();
    }

    /**
     * @throws \ReflectionException
     */
    protected function tearDown(): void {
        parent::tearDown();
        $isErrorHandlerClass = function ($handler) {
            return $handler instanceof Closure && (new ReflectionFunction($handler))->getClosureScopeClass()->name == ErrorHandler::class;
        };
        do {
            $errorHandler = set_error_handler(function () {
            });
            restore_error_handler();
            if ($isErrorHandlerClass($errorHandler)) {
                restore_error_handler();
                continue;
            }
            break;
        } while (true);
        do {
            $exceptionHandler = set_exception_handler(function () {
            });
            restore_exception_handler();
            if ($isErrorHandlerClass($exceptionHandler)) {
                restore_exception_handler();
                continue;
            }
            break;
        } while (true);
    }

    public function testRegisterTwiceThrowsException(): void {
        $errorHandler = $this->mkErrorHandler();

        $errorHandler->register();

        $this->expectException(LogicException::class, 'Error handler already registered');

        $errorHandler->register();
    }

    public function testUnregisterWithoutRegisterThrowsException(): void {
        $errorHandler = $this->mkErrorHandler();

        $this->expectException(LogicException::class, 'Error handler has not been registered');

        $errorHandler->unregister();
    }

    public function testRegisterAndUnregister(): void {
        $errorHandler = $this->mkErrorHandler();

        $this->assertFalse($errorHandler->registered);
        $this->assertFalse($this->closuresEqual($errorHandler->handleError(...), $this->lastErrorHandler()));
        $this->assertFalse($this->closuresEqual($errorHandler->handleException(...), $this->lastExceptionHandler()));

        /** @noinspection PhpVoidFunctionResultUsedInspection */
        $this->assertNull($errorHandler->register());

        $this->assertTrue($errorHandler->registered);
        $this->assertTrue($this->closuresEqual($errorHandler->handleError(...), $this->lastErrorHandler()));
        $this->assertTrue($this->closuresEqual($errorHandler->handleException(...), $this->lastExceptionHandler()));

        $errorHandler->unregister();

        $this->assertFalse($errorHandler->registered);
        $this->assertFalse($this->closuresEqual($errorHandler->handleError(...), $this->lastErrorHandler()));
        $this->assertFalse($this->closuresEqual($errorHandler->handleException(...), $this->lastExceptionHandler()));
    }

    public function testDefaultValuesOfProperties(): void {
        $errorHandler = new ErrorHandler([]);
        $this->assertTrue($errorHandler->registerAsFatalErrorHandler);
        $this->assertTrue($errorHandler->exitOnFatalError);
    }

    public static function dataTestHandleError_ConvertsErrorToException(): iterable {
        return [
            [E_USER_ERROR, UserErrorException::class],
            [E_USER_WARNING, UserWarningException::class],
            [E_USER_NOTICE, UserNoticeException::class],
            [E_USER_DEPRECATED, UserDeprecatedException::class],
        ];
    }

    #[DataProvider('dataTestHandleError_ConvertsErrorToException')]
    public function testHandleError_ConvertsErrorToException(int $severity, string $expectedErrorClass): void {
        $errorHandler = $this->mkErrorHandler();
        $errorHandler->register();
        $oldErrorReporting = error_reporting(E_ALL);
        try {
            try {
                trigger_error("My message", $severity);
                $this->fail();
            } catch (ErrorException $ex) {
                $this->assertInstanceOf($expectedErrorClass, $ex);
            }
        } finally {
            error_reporting($oldErrorReporting);
        }
        $this->assertEquals(__LINE__ - 8, $ex->getLine());
        $this->assertEquals("My message", $ex->getMessage());
        $this->assertEquals(__FILE__, $ex->getFile());
        $this->assertEquals($severity, $ex->getSeverity());
    }

    public function testListeners(): void {
        $exceptionHandler = $this->mkErrorHandler();

        $this->assertEquals(new ArrayObject(), $exceptionHandler->listeners);

        $exceptionHandler->listeners->append(
            function () use (&$called) {
                $called = true;
            }
        );
        $fnListener = new class {
            public $called;

            public function __invoke(mixed $value): mixed {
                $this->called = true;
                return null;
            }
        };
        $exceptionHandler->listeners->append($fnListener);

        $exceptionHandler->handleException(new RuntimeException());

        $this->assertTrue($called);
        $this->assertTrue($fnListener->called);
    }

    private function mkErrorHandler(): ErrorHandler {
        $errorHandler = new ErrorHandler([]);
        $errorHandler->exitOnFatalError = false;
        $errorHandler->registerAsFatalErrorHandler = false;
        return $errorHandler;
    }

    private static function lastErrorHandler(): callable|null {
        $prevErrorHandler = set_error_handler(function () {
        });
        restore_error_handler();
        return $prevErrorHandler;
    }

    private static function lastExceptionHandler(): callable|null {
        $prevExceptionHandler = set_exception_handler(function () {
        });
        restore_exception_handler();
        return $prevExceptionHandler;
    }

    /**
     * @throws \ReflectionException
     */
    private static function closuresEqual($a, $b): bool {
        if ($a instanceof Closure && $b instanceof Closure) {
            return (new ReflectionFunction($a))->__toString() === (new ReflectionFunction($b))->__toString();
        }
        return false;
    }
}
