<?php declare(strict_types=1);
/**
 * This file is part of njcom/framework
 * It is distributed under the 'Apache License Version 2.0' license.
 * See the https://github.com/njcom/framework/blob/main/LICENSE for the full license text.
 */
namespace Morpho\Tool\PostgreSql;

use Morpho\Base\Conf;
use Morpho\Tool\Sql\Client as BaseClient;
use Morpho\Tool\Sql\IDeleteQuery;
use Morpho\Tool\Sql\IInsertQuery;
use Morpho\Tool\Sql\IReplaceQuery;
use Morpho\Tool\Sql\ISchema;
use Morpho\Tool\Sql\ISelectQuery;
use Morpho\Tool\Sql\IUpdateQuery;
use PDO;

class Client extends BaseClient {
}