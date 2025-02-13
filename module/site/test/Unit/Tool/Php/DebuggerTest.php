<?php declare(strict_types=1);
/**
 * This file is part of njcom/framework
 * It is distributed under the 'Apache License Version 2.0' license.
 * See the https://github.com/njcom/framework/blob/main/LICENSE for the full license text.
 */
namespace Morpho\Test\Unit\Tool\Php\Debug;

use Morpho\Base\Env;
use Morpho\Tool\Php\Debugger;
use Morpho\Testing\TestCase;

class DebuggerTest extends TestCase {
    private Debugger $debugger;

    protected function setUp(): void {
        $this->debugger = Debugger::instance();
    }

    public function testVarToStr_FixOutput() {
        $this->checkXdebug();
        $this->assertEquals("\nstring(3) \"<=>\"\n", $this->debugger->varToStr('<=>'));
    }

    public function testVarToStr() {
        $this->checkXdebug();
        $expected = <<<'OUT'
        array(1) {
        ["foo"] => string(3) "bar"
        }
        OUT;
        $this->assertEquals($expected, $this->debugger->varToStr(['foo' => 'bar']));
    }

    public function testIsHtmlMode() {
        $this->checkBoolAccessor([$this->debugger, 'isHtmlMode'], false);
    }

    public function testCalledAt() {
        $expected = "\nDebugger called at [" . __FILE__ . ':' . __LINE__ + 1 . "]\n";
        $this->assertEquals($expected, $this->debugger->calledAt());
    }

    protected function tearDown(): void {
        Debugger::resetState();
    }

    private function checkXdebug(): void {
        if (Env::isXdebugEnabled() && Env::boolIniVal('xdebug.overload_var_dump')) {
            $this->markTestSkipped();
        }
    }
}
