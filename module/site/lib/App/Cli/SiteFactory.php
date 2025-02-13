<?php declare(strict_types=1);
/**
 * This file is part of njcom/framework
 * It is distributed under the 'Apache License Version 2.0' license.
 * See the https://github.com/njcom/framework/blob/main/LICENSE for the full license text.
 */
namespace Morpho\App\Cli;

use Morpho\App\SiteFactory as BaseSiteFactory;

class SiteFactory extends BaseSiteFactory {
    private string $currentHostName;

    public function __construct(array $appConf, string $currentHostName) {
        parent::__construct($appConf);
        $this->currentHostName = $currentHostName;
    }

    public function throwInvalidSiteError(): never {
        throw new Exception('Invalid site');
    }

    public function currentHostName(): string|false {
        return $this->currentHostName;
    }
}
