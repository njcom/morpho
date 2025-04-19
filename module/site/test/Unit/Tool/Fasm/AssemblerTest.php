<?php declare(strict_types=1);
/**
 * This file is part of njcom/framework
 * It is distributed under the 'Apache License Version 2.0' license.
 * See the https://github.com/njcom/framework/blob/main/LICENSE for the full license text.
 */
namespace Morpho\Test\Unit\Tool\Fasm;

use Morpho\Testing\TestCase;
use Morpho\Tool\Fasm\Assembler;

class AssemblerTest extends TestCase {
    public function testShouldCompileEmptyProgram() {
        $result = new Assembler()();
        $this->assertTrue($result->isOk());
        $this->assertSame('', $result->value());
    }
}