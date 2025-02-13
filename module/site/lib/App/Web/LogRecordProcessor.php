<?php declare(strict_types=1);
/**
 * This file is part of njcom/framework
 * It is distributed under the 'Apache License Version 2.0' license.
 * See the https://github.com/njcom/framework/blob/main/LICENSE for the full license text.
 */
namespace Morpho\App\Web;

use Monolog\LogRecord;
use Monolog\Processor\WebProcessor;

use function array_merge;

class LogRecordProcessor extends WebProcessor {
    public function __invoke(LogRecord $record): LogRecord {
        $record = parent::__invoke($record);
        $record['extra'] = array_merge($record['extra'], Env::clientIp());
        $record['extra']['userAgent'] = $_SERVER['HTTP_USER_AGENT'] ?? null;
        return $record;
    }
}
