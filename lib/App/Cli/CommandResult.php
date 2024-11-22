<?php declare(strict_types=1);
/**
 * This file is part of njcom/framework
 * It is distributed under the 'Apache License Version 2.0' license.
 * See the https://github.com/njcom/framework/blob/main/LICENSE for the full license text.
 */
namespace Morpho\App\Cli;

use Traversable;

use function Morpho\Base\lines;

abstract class CommandResult implements ICommandResult {
    protected int $exitCode;

    public function __construct(int $exitCode) {
        $this->exitCode = $exitCode;
    }

    public function isError(): bool {
        return $this->exitCode() !== StatusCode::Success->value;
    }

    public function exitCode(): int {
        return $this->exitCode;
    }

    public function getIterator(): Traversable {
        /** @var Traversable */
        return $this->lines(false);
    }

    public function lines(bool $asArr = true, bool $filterEmpty = true, bool $trim = true): iterable {
        return lines($this->stdOut(), $asArr, $filterEmpty, $trim);
    }

    public function __toString(): string {
        return $this->stdOut();
    }
}
