<?php declare(strict_types=1);
/**
 * This file is part of njcom/framework
 * It is distributed under the 'Apache License Version 2.0' license.
 * See the https://github.com/njcom/framework/blob/main/LICENSE for the full license text.
 */
namespace Morpho\Tool\Php;

interface IDiscoverStrategy {
    /**
     * @return array An array of classes, interfaces, traits, unions defined in the file $filePath.
     */
    public function classTypesDefinedInFile(string $filePath): array;
}
