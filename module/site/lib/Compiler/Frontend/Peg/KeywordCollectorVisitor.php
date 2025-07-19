<?php declare(strict_types=1);
/**
 * This file is part of njcom/framework
 * It is distributed under the 'Apache License Version 2.0' license.
 * See the https://github.com/njcom/framework/blob/main/LICENSE for the full license text.
 */
namespace Morpho\Compiler\Frontend\Peg;

/**
 * https://github.com/python/cpython/blob/3.12/Tools/peg_generator/pegen/parser_generator.py#L57
 * Visitor that collects all the keywods and soft keywords in the Grammar
 */
class KeywordCollectorVisitor extends GrammarVisitor {
    private ParserGenerator $parserGenerator;

    /**
     * @var array Dict[str, int]
     */
    private array $keywords;

    /**
     * @var array Set[str]
     */
    private array $softKeywords;

    public function __construct(ParserGenerator $parserGenerator, array $keywords, array $softKeywords) {
        $this->parserGenerator = $parserGenerator;
        $this->keywords = $keywords;
        $this->softKeywords = $softKeywords;
    }

    protected function visitStringLeaf(StringLeaf $node): void {
        $value = Peg::literalEval($node->value);
        if (preg_match('~[a-zA-Z_]\\w*\\Z~s', $value)) { # This is a keyword
            if (str_ends_with($node->value, "'") && !in_array($node->value, $this->keywords)) {
                $this->keywords[$value] = $this->parserGenerator->keywordType();
            } else {
                $this->softKeywords = array_unique(array_merge($this->softKeywords, [str_replace('"', '', $node->value)]));
            }
        }
    }
}