<?php declare(strict_types=1);
/**
 * This file is part of njcom/framework
 * It is distributed under the 'Apache License Version 2.0' license.
 * See the https://github.com/njcom/framework/blob/main/LICENSE for the full license text.
 */
namespace Morpho\App\Web;

use Morpho\App\IMessage;
use Morpho\Uri\Uri;

interface IRequest extends IMessage {
    public function redirect(string|null $uri = null, int|null $statusCode = null): IResponse;

    public function isAjax(bool|null $flag = null): bool;

    public function prependWithBasePath(string $path): Uri;
}
