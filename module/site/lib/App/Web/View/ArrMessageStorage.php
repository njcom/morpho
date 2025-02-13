<?php declare(strict_types=1);
/**
 * This file is part of njcom/framework
 * It is distributed under the 'Apache License Version 2.0' license.
 * See the https://github.com/njcom/framework/blob/main/LICENSE for the full license text.
 */
namespace Morpho\App\Web\View;

use ArrayObject;
use Morpho\Base\NotImplementedException;

class ArrMessageStorage extends ArrayObject implements IMessageStorage {
    public function clear(): void {
        throw new NotImplementedException();
    }
}
