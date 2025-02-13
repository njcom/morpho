<?php declare(strict_types=1);
/**
 * This file is part of njcom/framework
 * It is distributed under the 'Apache License Version 2.0' license.
 * See the https://github.com/njcom/framework/blob/main/LICENSE for the full license text.
 */
namespace Morpho\Compiler;

use Morpho\Base\Pipe;
use UnexpectedValueException;

class Compiler extends Pipe implements ICompiler {
    /**
     * @var callable
     */
    public $frontend;
    /**
     * @var callable
     */
    public $midend;
    /**
     * @var callable
     */
    public $backend;

    public array $conf;

    public function __construct(array $conf = null) {
        $this->conf = $conf;
    }

    public function current(): callable {
        return match ($this->index) {
            0 => $this->frontend(),
            1 => $this->midend(),
            2 => $this->backend(),
            default => throw new UnexpectedValueException(),
        };
    }

    public function frontend(): callable {
        if (null === $this->frontend) {
            $this->frontend = $this->conf['frontend'] ?? function ($context) {
                return $context;
            };
        }
        return $this->frontend;
    }

    public function midend(): callable {
        if (null === $this->midend) {
            $this->midend = $this->conf['midend'] ?? function ($context) {
                return $context;
            };
        }
        return $this->midend;
    }

    public function backend(): callable {
        if (null === $this->backend) {
            $this->backend = $this->conf['backend'] ?? function ($context) {
                return $context;
            };
        }
        return $this->backend;
    }

    public function count(): int {
        // Valid pipe steps are `[$this->frontend(), $this->midend(), $this->backend()]`, so the count is 3.
        return 3;
    }
}
