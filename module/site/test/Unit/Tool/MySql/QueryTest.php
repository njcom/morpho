<?php declare(strict_types=1);
/**
 * This file is part of njcom/framework
 * It is distributed under the 'Apache License Version 2.0' license.
 * See the https://github.com/njcom/framework/blob/main/LICENSE for the full license text.
 */
namespace Morpho\Test\Unit\Tool\MySql;

use Morpho\Tool\Sql\IQuery;

abstract class QueryTest extends DbTestCase {
    protected IQuery $query;

    protected function setUp(): void {
        parent::setUp();
        $this->query = $this->mkQuery();
    }

    abstract protected function mkQuery(): IQuery;

    public function testInterface() {
        $this->assertInstanceOf(IQuery::class, $this->query);
    }

    protected function checkTableRef() {
        $sql = $this->query->table(['abc' => 'someAlias', 'interTable', 'def' => 'anotherAlias'])->__toString();
        $this->assertStringContainsString('`abc` AS `someAlias`, `interTable`, `def` AS `anotherAlias`', $sql);
    }
}
