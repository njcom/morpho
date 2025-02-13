<?php declare(strict_types=1);
/**
 * This file is part of njcom/framework
 * It is distributed under the 'Apache License Version 2.0' license.
 * See the https://github.com/njcom/framework/blob/main/LICENSE for the full license text.
 */
namespace Morpho\Tool\Sqlite;

use Morpho\Base\NotImplementedException;
use Morpho\Tool\Sql\Client as BaseClient;
use Morpho\Tool\Sql\IDeleteQuery;
use Morpho\Tool\Sql\IInsertQuery;
use Morpho\Tool\Sql\IReplaceQuery;
use Morpho\Tool\Sql\ISchema;
use Morpho\Tool\Sql\ISelectQuery;
use Morpho\Tool\Sql\IUpdateQuery;

class Client extends BaseClient {
    protected function checkConf(array $conf): array {
        throw new NotImplementedException();
    }

    public function connect(): void {
        throw new NotImplementedException();
    }

    public function insert(array $spec = null): IInsertQuery {
        throw new NotImplementedException();
    }

    public function select(array $spec = null): ISelectQuery {
        throw new NotImplementedException();
    }

    public function update(array $spec = null): IUpdateQuery {
        throw new NotImplementedException();
    }

    public function delete(array $spec = null): IDeleteQuery {
        throw new NotImplementedException();
    }

    public function replace(array $spec = null): IReplaceQuery {
        throw new NotImplementedException();
    }

    public function schema(): ISchema {
        throw new NotImplementedException();
    }

    public function dbName(): ?string {
        throw new NotImplementedException();
    }

    public function useDb(string $dbName): static {
        throw new NotImplementedException();
    }
}
