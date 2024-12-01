<?php declare(strict_types=1);
/**
 * This file is part of njcom/framework
 * It is distributed under the 'Apache License Version 2.0' license.
 * See the https://github.com/njcom/framework/blob/main/LICENSE for the full license text.
 */
namespace Morpho\Compiler\Frontend\Peg;

use function Morpho\Base\init;
use function Morpho\Base\last;

/**
 * Based on https://github.com/python/cpython/blob/3.12/Tools/peg_generator/pegen/grammar_visualizer.py
 */
class GrammarVisualizer {
    /**
     * def print_grammar_ast(self, grammar: Grammar, printer: Callable[..., None] = print) -> None:
     */
    public function __invoke(Grammar $grammar, callable $writer = null): void {
        if (null === $writer) {
            $writer = static function (string $output): void {
                echo $output . "\n";
            };
        }
        foreach ($grammar->rules as $rule) {
            $writer($this->nodeToStr($rule));
        }
    }

    /**
     * def print_nodes_recursively(self, node: Rule, prefix: str = "", istail: bool = True) -> str:
     * @param \Morpho\Compiler\Frontend\Peg\Rule $node
     * @param string                             $prefix
     * @param bool                               $isLast
     * @return string
     */
    protected function nodeToStr($node, string $prefix = '', bool $isLast = true): string {
        $children = iterator_to_array($this->children($node));
        $value = $this->name($node);
        $line = $prefix . ($isLast ? '└──' : '├──') . $value . "\n";
        $suffix = $isLast ? '   ' : '│  ';
        if (!$children) {
            return $line;
        }
        $last = last($children);
        $children = init($children);
        foreach ($children as $child) {
            $line .= $this->nodeToStr($child, $prefix . $suffix, false);
        }
        $line .= $this->nodeToStr($last, $prefix . $suffix, true);
        return $line;
    }

    protected function children(iterable $node): iterable {
        foreach ($node as $value) {
            if (is_array($value)) {
                yield from $value;
            } else {
                yield $value;
            }
        }
    }

    protected function name(IGrammarNode $node): string {
        if (!iterator_count($this->children($node))) {
            return $node->repr();
        }
        return last(get_class($node), '\\');
    }
}