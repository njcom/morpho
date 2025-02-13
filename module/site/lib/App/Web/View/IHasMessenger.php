<?php declare(strict_types=1);
/**
 * This file is part of njcom/framework
 * It is distributed under the 'Apache License Version 2.0' license.
 * See the https://github.com/njcom/framework/blob/main/LICENSE for the full license text.
 */
namespace Morpho\App\Web\View;

interface IHasMessenger {
    public function setMessenger(Messenger $messenger): static;

    public function addSuccessMessage(string $message, array $args = null): static;

    public function addInfoMessage(string $text, array $args = null): static;

    public function addWarningMessage(string $text, array $args = null): static;

    public function addErrorMessage(string $text, array $args = null): static;
}
