<?php declare(strict_types=1);
/**
 * This file is part of njcom/framework
 * It is distributed under the 'Apache License Version 2.0' license.
 * See the https://github.com/njcom/framework/blob/main/LICENSE for the full license text.
 */
namespace Morpho\Compiler\Frontend;

// Matches single-line and multi-line C-style comments:
// https://stackoverflow.com/a/59094308
const C_COMMENTS_RE = '\\/\\*[\\s\\S]*?\\*\\/|\\/\\/.*';
// https://stackoverflow.com/a/59094308
const C_COMMENTS_FULL_RE = '~\\/\\*[\\s\\S]*?\\*\\/|\\/\\/.*~m';

function findByteOffsetOfPair(string $text, string $startSymbol, int $startOffset): int {
    $bracePairs = [
        '{' => '}',
        '(' => ')',
        '[' => ']',
        '<' => '>',
    ];
    $openSymbol = $text[$startOffset];
    $closeSymbol = isset($bracePairs[$openSymbol]) ? $bracePairs[$openSymbol] : $openSymbol;
    $level = 1;
    $length = strlen($text);
    for ($i = $startOffset + 1; $i < $length; $i++) {
        $char = $text[$i];
        if ($char === $openSymbol) {
            $level++;
        } elseif ($char === $closeSymbol) {
            $level--;
        }
        if ($level === 0) {
            return $i; // Return the index of the matching brace
        }
    }
    return -1;
}

function findMultiByteOffsetOfPair(string $text, string $startSymbol, int $startOffset): int {
    if (strlen($startSymbol) > 1) {
        throw new NotImplementedException();
    }
    $bracePairs = [
        '{' => '}',
        '(' => ')',
        '[' => ']',
        '<' => '>',
    ];
    $openSymbol = mb_substr($text, $startOffset, 1);
    $closeSymbol = isset($bracePairs[$openSymbol]) ? $bracePairs[$openSymbol] : $openSymbol;
    $chars = preg_split('//u', mb_substr($text, $startOffset + 1), -1, PREG_SPLIT_NO_EMPTY);
    $level = 1;
    $i = $startOffset + 1;
    foreach ($chars as $char) {
        if ($char === $openSymbol) {
            $level++;
        } elseif ($char === $closeSymbol) {
            $level--;
        }
        if ($level === 0) {
            return $i; // Return the index of the matching brace
        }
        $i++;
    }
    return -1;
}