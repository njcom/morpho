<?php declare(strict_types=1);
/**
 * This file is part of njcom/framework
 * It is distributed under the 'Apache License Version 2.0' license.
 * See the https://github.com/njcom/framework/blob/main/LICENSE for the full license text.
 */
namespace Morpho\App\Cli;

use ArrayObject;
use Morpho\App\IMessage;

class Response extends ArrayObject implements IMessage {
    public string $body;

    public int $statusCode = StatusCode::Success->value;

    public function send(): mixed {
        echo $this->body;
        return $this->statusCode;
    }
}
