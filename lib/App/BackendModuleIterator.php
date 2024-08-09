<?php declare(strict_types=1);
/**
 * This file is part of njcom/framework
 * It is distributed under the 'Apache License Version 2.0' license.
 * See the https://github.com/njcom/framework/blob/main/LICENSE for the full license text.
 */
namespace Morpho\App;

use IteratorAggregate;
use Traversable;
use Morpho\Fs\File;

use function is_file;
use function trim;

class BackendModuleIterator implements IteratorAggregate {
    private readonly array $siteConf;

    public function __construct(array $siteConf) {
        $this->siteConf = $siteConf;
    }

    public function getIterator(): Traversable {
        foreach ($this->siteConf['paths']['moduleDirPaths'] as $moduleDirPath) {
            $metaFilePath = $moduleDirPath . '/' . META_FILE_NAME;
            if (!is_file($metaFilePath)) {
                continue;
            }
            $metaFileModuleConf = File::readJson($metaFilePath);
            if (!$this->filter($metaFileModuleConf)) {
                continue;
            }
            $metaFileModuleConf['paths'] = ['dirPath' => $moduleDirPath];
            #$moduleConf = $this->site->moduleConf($metaFileModuleConf['name']);
            yield $this->map($metaFileModuleConf);
        }
    }

    protected function filter(array $module): bool {
        return isset($module['name']);
    }

    protected function map(array $module): array {
        $namespaces = [];
        foreach ($module['autoload']['psr-4'] ?? [] as $key => $value) {
            $namespaces[trim($key, '\\/')] = trim($value, '\\/');
        }
        $moduleName = $module['name'];
        return [
            'name'      => $moduleName,
            'paths'     => $module['paths'],
            'namespace' => $namespaces,
            'weight'    => 0,
        ];
    }
}
