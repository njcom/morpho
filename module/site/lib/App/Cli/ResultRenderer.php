<?php declare(strict_types=1);
/**
 * This file is part of njcom/framework
 * It is distributed under the 'Apache License Version 2.0' license.
 * See the https://github.com/njcom/framework/blob/main/LICENSE for the full license text.
 */
namespace Morpho\App\Cli;

use Morpho\Base\IFn;

class ResultRenderer implements IFn {
    public function __invoke(mixed $context): mixed {
        $result = $context->response['result'];
        $context->response->body = is_iterable($result) ? Terminal::renderList($result) : (string) $result;
        return $context;
    }
}
