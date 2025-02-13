<?php declare(strict_types=1);
/**
 * This file is part of njcom/framework
 * It is distributed under the 'Apache License Version 2.0' license.
 * See the https://github.com/njcom/framework/blob/main/LICENSE for the full license text.
 */
namespace Morpho\Base;

use ArrayAccess;
use ArrayObject;
use RuntimeException;
use Throwable;

use function array_keys;
use function implode;
use function method_exists;
use function sprintf;

/**
 * Implements IoC pattern and allows to use two approaches to manage dependencies:
 *     1) DI/Dependency Injection - inject/push dependent objects to the objects but not inject self
 *     2) Service Locator - inject/push self to the object and allow to pull from self
 */
class ServiceManager extends ArrayObject implements ArrayAccess {
    public array $aliases = [];
    protected const string FACTORY_METHOD_PREFIX = 'mk';
    protected const string FACTORY_METHOD_SUFFIX = 'Service';
    private array $loading = [];
    public mixed $conf;

    public function __construct(array $services = null) {
        parent::__construct();
        if (null !== $services) {
            foreach ($services as $id => $service) {
                $this->offsetSet($id, $service);
            }
        }
    }

    /**
     * This method uses logic found in the Symfony\Component\DependencyInjection\Container::get().
     * @throws \Morpho\Base\ServiceNotFoundException
     */
    public function offsetGet(mixed $id): mixed {
        // Resolve alias:
        while (isset($this->aliases[$id])) {
            $id = $this->aliases[$id];
        }
        if (parent::offsetExists($id)) {
            return parent::offsetGet($id);
        }
        if (isset($this->loading[$id])) {
            throw new RuntimeException(
                sprintf(
                    "Circular reference detected for the service '%s', path: '%s'",
                    $id,
                    implode(' -> ', array_keys($this->loading)) . ' -> ' . $id
                )
            );
        }
        $this->loading[$id] = true;
        try {
            $this[$id] = $service = $this->mkService($id);
        } catch (Throwable $e) {
            unset($this->loading[$id]);
            throw $e;
        }
        unset($this->loading[$id]);
        return $service;
    }

    public function offsetUnset($id): void {
        if ($this->offsetExists($id)) {
            while (isset($this->aliases[$id]) && $this->aliases[$id] !== $id) {
                $id = $this->aliases[$id];
            }
            if (parent::offsetExists($id)) {
                parent::offsetUnset($id);
                return;
            }
        }
    }

    public function offsetExists(mixed $id): bool {
        // Resolve alias:
        while (isset($this->aliases[$id]) && $this->aliases[$id] !== $id) {
            $id = $this->aliases[$id];
        }
        if (parent::offsetExists($id)) {
            return true;
        }
        $method = self::FACTORY_METHOD_PREFIX . $id . self::FACTORY_METHOD_SUFFIX;
        return method_exists($this, $method);
    }

    /**
     * @throws \Morpho\Base\ServiceNotFoundException
     */
    protected function mkService(string $id): mixed {
        $method = self::FACTORY_METHOD_PREFIX . $id . self::FACTORY_METHOD_SUFFIX;
        if (method_exists($this, $method)) {
            $this->beforeCreate($id);
            $service = $this->{$method}();
            $this->afterCreate($id, $service);
            return $service;
        }
        throw new ServiceNotFoundException($id);
    }

    protected function beforeCreate(string $id): void {
        // Do nothing by default.
    }

    protected function afterCreate(string $id, $service): void {
        if ($service instanceof IHasServiceManager) {
            $service->setServiceManager($this);
        }
    }
}
