<?php declare(strict_types=1);
/**
 * This file is part of njcom/framework
 * It is distributed under the 'Apache License Version 2.0' license.
 * See the https://github.com/njcom/framework/blob/main/LICENSE for the full license text.
 */
namespace Morpho\App\Web\View;

use Countable;
use IteratorAggregate;
use Traversable;
use UnexpectedValueException;

use function count;
use function in_array;

class Messenger implements Countable, IteratorAggregate {
    public IMessageStorage $storage;

    public function __construct(IMessageStorage|null $storage = null) {
        if (null === $storage) {
            $this->storage = new SessionMessageStorage(__CLASS__);
        }
    }

    public function clearMessages(): void {
        $this->storage->clear();
    }

    public function addMessage(string $text, array|null $args = null, MessageType|null $type = null): void {
        if (null === $type) {
            $type = MessageType::Success;
        }
        $key = $type->value;
        if (!isset($this->storage[$key])) {
            $this->storage[$key] = [];
        }
        $this->storage[$key][] = [
            'text' => $text,
            'args' => (array) $args,
        ];
    }

    public function addSuccessMessage(string $text, array|null $args = null): void {
        $this->addMessage($text, $args, MessageType::Success);
    }

    public function hasSuccessMessages(): bool {
        return $this->hasMessages(MessageType::Success);
    }

    public function addInfoMessage(string $text, array|null $args = null): void {
        $this->addMessage($text, $args, MessageType::Info);
    }

    public function hasInfoMessages(): bool {
        return $this->hasMessages(MessageType::Info);
    }

    public function addWarningMessage(string $text, array|null $args = null): void {
        $this->addMessage($text, $args, MessageType::Warning);
    }

    public function hasWarningMessages(): bool {
        return $this->hasMessages(MessageType::Warning);
    }

    public function addErrorMessage(string $text, array|null $args = null): void {
        $this->addMessage($text, $args, MessageType::Error);
    }

    public function hasErrorMessages(): bool {
        return $this->hasMessages(MessageType::Error);
    }

    public function hasMessages(MessageType $type): bool {
        return !empty($this->storage[$type->value]);
    }

    public function getIterator(): Traversable {
        return $this->storage;
    }

    public function count(): int {
        return count($this->storage);
    }
}
