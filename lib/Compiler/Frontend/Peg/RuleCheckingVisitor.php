<?php declare(strict_types=1);
/**
 * This file is part of njcom/framework
 * It is distributed under the 'Apache License Version 2.0' license.
 * See the https://github.com/njcom/framework/blob/main/LICENSE for the full license text.
 */
namespace Morpho\Compiler\Frontend\Peg;

use function Morpho\Base\q;

/**
 * https://github.com/python/cpython/blob/3.12/Tools/peg_generator/pegen/parser_generator.py#L74
 */
class RuleCheckingVisitor extends GrammarVisitor {
    /**
     * @var array Dict[str, Rule]
     */
    public array $rules;

    /**
     * @var array Set[str]
     */
    private array $tokens;

    public function __construct(array $tokens) {
        $this->tokens = $tokens;
    }

    protected function visitNameLeaf(NameLeaf $node): void {
        $value = match ($node->value) {
            'NEWLINE' => TokenType::NewLine->name,
            'NUMBER' => TokenType::Number->name,
            default => $node->value,
        };
        if (!isset($this->rules[$value]) && !in_array($value, $this->tokens, true)) {
            throw new GrammarException('Dangling reference to rule ' . q($value));
        }
    }

    protected function visitNamedItem(NamedItem $node): void {
        if ($node->name && str_starts_with($node->name, '_')) {
            throw new GrammarException('Variable names cannot start with underscore: ' . $node->name);
        }
        $this->visit($node->item);
    }
}