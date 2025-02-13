<?php declare(strict_types=1);
/**
 * This file is part of njcom/framework
 * It is distributed under the 'Apache License Version 2.0' license.
 * See the https://github.com/njcom/framework/blob/main/LICENSE for the full license text.
 */
namespace Morpho\App;

use function Morpho\Base\merge;

abstract class SiteFactory {
    protected array $appConf;

    public function __construct(array $appConf) {
        $this->appConf = $appConf;
    }

    /**
     * @throws \RuntimeException
     * @return array
     */
    public function __invoke(): array {
        $hostName = $this->currentHostName();
        if (!$hostName) {
            $this->throwInvalidSiteError();
        }
        foreach ($this->appConf['sites'] as $siteConf) {
            // @todo: support callback $siteConf['hosts']
            if (in_array($hostName, $siteConf['hosts'], true)) {
                return $this->loadExtendedSiteConf($siteConf, $hostName);
            }
        }
        $this->throwInvalidSiteError();
    }

    abstract protected function currentHostName(): string|false;

    abstract protected function throwInvalidSiteError(): never;

    protected function loadExtendedSiteConf(array $siteConf, string $hostName): array {
        // Enable the autoloading via require as the site's config file can use classes.
        require $siteConf['paths']['dirPath'] . '/' . VENDOR_DIR_NAME . '/autoload.php';
        $extendedSiteConf = merge($siteConf, require $siteConf['paths']['confFilePath']);
        $extendedSiteConf['hostName'] = $hostName;
        return $extendedSiteConf;
    }
}
