<?php declare(strict_types=1);
/**
 * This file is part of njcom/framework
 * It is distributed under the 'Apache License Version 2.0' license.
 * See the https://github.com/njcom/framework/blob/main/LICENSE for the full license text.
 */
namespace Morpho\Test\Unit\Tool\Systemd;

use Morpho\Tool\Systemd\ActivationType;
use Morpho\Tool\Systemd\Meta;
use Morpho\Tool\Systemd\UnitType;
use Morpho\Testing\TestCase;

class MetaTest extends TestCase {
    public function testKnownBins() {
        $this->assertContains('systemctl', Meta::knownBins());
    }

    public function testKnownUnitTypes() {
        $this->assertContains(UnitType::SERVICE, Meta::knownUnitTypes());
    }

    public function testRefs() {
        $this->assertIsArray(meta::refs());
    }

    public function testKnownConfSections() {
        $this->assertContains('Service', Meta::knownConfSections());
    }

    public function testKnownConfDirectives() {
        $this->assertContains('ExecStart', Meta::knownConfDirectives()['Service']);
    }

    public function testKnownActivationType() {
        $this->assertContains(ActivationType::BOOT, Meta::knownActivationTypes());
    }
}
