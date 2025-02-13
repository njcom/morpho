<?php declare(strict_types=1);
/**
 * This file is part of njcom/framework
 * It is distributed under the 'Apache License Version 2.0' license.
 * See the https://github.com/njcom/framework/blob/main/LICENSE for the full license text.
 */
namespace Morpho\Tool\Php;

use PhpToken;

use function count;
use function file_get_contents;
use function in_array;
use function preg_match;

class TokenStrategy implements IDiscoverStrategy {
    public function classTypesDefinedInFile(string $filePath): array {
        $contents = file_get_contents($filePath);
        if (!preg_match('{\b(?:class|interface|trait|enum)\b}i', $contents)) {
            return [];
        }

        $tokens = array_values(
            array_filter(PhpToken::tokenize($contents), fn ($token) => !$token->isIgnorable())
        );

        $classTypes = [];
        $namespace = '';
        for ($i = 0, $max = count($tokens); $i < $max; $i++) {
            $token = $tokens[$i];
            if ($token->isIgnorable()) { // ignore whitespaces and comments
                continue;
            }
            if ($token->id == T_NAMESPACE && isset($tokens[$i + 1]) && ($tokens[$i + 1]->id == T_NAME_QUALIFIED || $tokens[$i + 1]->id == T_STRING)) {
                $namespace = $tokens[$i + 1]->text;
                continue;
            }

            if (in_array(
                    $token->id,
                    [T_CLASS, T_INTERFACE, T_TRAIT, T_ENUM]
                ) && isset($tokens[$i + 1]) && $tokens[$i + 1]->id == T_STRING) {
                $classTypes[] = (strlen($namespace) ? $namespace . '\\' : '') . $tokens[$i + 1]->text;
            }
        }
        return $classTypes;
    }
}
