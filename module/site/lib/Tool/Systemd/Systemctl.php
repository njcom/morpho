<?php declare(strict_types=1);
/**
 * This file is part of njcom/framework
 * It is distributed under the 'Apache License Version 2.0' license.
 * See the https://github.com/njcom/framework/blob/main/LICENSE for the full license text.
 */
namespace Morpho\Tool\Systemd;

use function Morpho\App\Cli\sh;

class Systemctl {
    public function reloadDaemon(): void {
        sh('systemctl daemon-reload');
    }

    public function service(string $unitName, string $unitFilePath): UnitManager {
        return new UnitManager(UnitType::SERVICE, $unitName, $unitFilePath);
    }

    public function timer(string $unitName, string $unitFilePath): UnitManager {
        return new TimerUnitManager($unitName, $unitFilePath);
    }
}
