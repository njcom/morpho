<?php declare(strict_types=1);
/**
 * This file is part of njcom/framework
 * It is distributed under the 'Apache License Version 2.0' license.
 * See the https://github.com/njcom/framework/blob/main/LICENSE for the full license text.
 */
namespace Morpho\Tool\Sql;

use Morpho\Tool\MySql\Client as MySqlClient;
use Morpho\Tool\Sqlite\Client as SqliteClient;
use UnexpectedValueException;

const SQL_TRUE = 1;
const SQL_FALSE = 0;

function mkDbClient(array $conf = null): IClient {
    $driverName = $conf['driver'] ?? 'mysql';
    unset($conf['driver']);
    switch ($driverName) {
        case 'mysql':
            return new MySqlClient($conf);
        case 'sqlite':
            return new SqliteClient($conf);
    }
    throw new UnexpectedValueException("Unknown DB driver");
}
