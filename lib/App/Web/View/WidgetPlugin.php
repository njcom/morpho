<?php declare(strict_types=1);
/**
 * This file is part of njcom/framework
 * It is distributed under the 'Apache License Version 2.0' license.
 * See the https://github.com/njcom/framework/blob/main/LICENSE for the full license text.
 */
namespace Morpho\App\Web\View;

use Morpho\Base\IHasServiceManager;
use Morpho\Base\ServiceManager;
use Stringable;

abstract class WidgetPlugin extends Plugin implements IHasServiceManager, Stringable {
    protected ServiceManager $serviceManager;
    protected TemplateEngine $templateEngine;

    public function setServiceManager(ServiceManager $serviceManager): void {
        $this->serviceManager = $serviceManager;
        $this->templateEngine = $this->serviceManager['templateEngine'];
    }

    protected function e($text): string {
        return $this->templateEngine->e($text);
    }
}
