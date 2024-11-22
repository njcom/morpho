<?php declare(strict_types=1);
/**
 * This file is part of njcom/framework
 * It is distributed under the 'Apache License Version 2.0' license.
 * See the https://github.com/njcom/framework/blob/main/LICENSE for the full license text.
 */
namespace Morpho\Test\Unit\App\Web;

use Morpho\App\Web\AppInitializer;
use Morpho\Base\ServiceManager;
use Morpho\Testing\TestCase;
use PHPUnit\Framework\Attributes\DataProvider;

use UnexpectedValueException;

use function ini_get;
use function ini_set;

class AppInitializerTest extends TestCase {
    private string $timezone;

    protected function setUp(): void {
        parent::setUp();
        $this->timezone = ini_get('date.timezone');
    }

    protected function tearDown(): void {
        parent::tearDown();
        ini_set('date.timezone', $this->timezone);
    }

    public static function dataTimezoneCanBeSetThroughSiteConf() {
        return [
            [
                'Europe/London',
            ],
            [
                'Asia/Bangkok',
            ],
        ];
    }

    #[DataProvider('dataTimezoneCanBeSetThroughSiteConf')]
    public function testTimezoneCanBeSetThroughSiteConf(string $timeZone) {
        $siteConf = [
            'iniConf' => [
                'date.timezone' => $timeZone,
            ],
        ];
        $serviceManager = $this->mkServiceManager($siteConf);

        $initializer = new AppInitializer($serviceManager);

        $initializer->init();

        $this->assertSame($timeZone, ini_get('date.timezone'));
    }

    private function mkServiceManager($siteConf): ServiceManager {
        $serviceManager = $this->createMock(ServiceManager::class);
        $errorHandler = new class {
            public function register(): void {
            }
        };
        $serviceManager->expects($this->any())
            ->method('offsetGet')
            ->willReturnCallback(
                function ($id) use ($siteConf, $errorHandler) {
                    if ($id === 'siteConf') {
                        return $siteConf;
                    }
                    if ($id === 'errorHandler') {
                        return $errorHandler;
                    }
                    throw new UnexpectedValueException($id);
                }
            );
        return $serviceManager;
    }
}
