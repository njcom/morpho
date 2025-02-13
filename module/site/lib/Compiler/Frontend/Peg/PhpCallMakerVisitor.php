<?php declare(strict_types=1);
/**
 * This file is part of njcom/framework
 * It is distributed under the 'Apache License Version 2.0' license.
 * See the https://github.com/njcom/framework/blob/main/LICENSE for the full license text.
 */
namespace Morpho\Compiler\Frontend\Peg;

use Morpho\Base\NotImplementedException;
use WeakMap;

/**
 * [PythonCallMakerVisitor](https://github.com/python/cpython/blob/3.12/Tools/peg_generator/pegen/python_generator.py#L93)
 */
class PhpCallMakerVisitor extends GrammarVisitor {
    /**
     * @var WeakMap Dict[Any, Any] = {}
     */
    private WeakMap $cache;

    private PhpParserGenerator $gen;

    public function __construct(PhpParserGenerator $parserGenerator) {
        $this->gen = $parserGenerator;
        $this->cache = new WeakMap();
    }

    /**
     * @return array Tuple[Optional[str], str]
     * @noinspection PhpUnused
     */
    protected function visitNameLeaf(NameLeaf $node): array {
        $name = $node->value;
        switch (true) {
            case $name === 'SOFT_KEYWORD':
                return ["soft_keyword", $this->softKeyword()];
            case in_array($name, ["NAME", "NUMBER", "STRING", "OP", "TYPE_COMMENT"]):
                $name = strtolower($name);
                return [$name, '$this->' . $name . '()'];
            case in_array($name, ["NEWLINE", "DEDENT", "INDENT", "ENDMARKER", "ASYNC", "AWAIT"]):
                // @todo: difference in Python's keywords and PHP keywords
                // Avoid using names that can be PHP keywords
                return [strtolower($name), '$this->expect(\'' . $name . '\')'];
            default:
                return [$name, '$this->' . $name . '()'];
        }
    }

    /**
     * @return array Tuple[str, str]
     * @noinspection PhpUnused
     */
    protected function visitStringLeaf(StringLeaf $node): array {
        return ['literal', '$this->expect(' . $node->value . ')'];
    }

    /**
     * @return array Tuple[Optional[str], str]
     * @noinspection PhpUnused
     */
    protected function visitRhs(Rhs $node): array {
        if (isset($this->cache[$node])) {
            return $this->cache[$node];
        }
        if (count($node->alts) == 1 && count($node->alts[0]->items) == 1) {
            $this->cache[$node] = $this->visit($node->alts[0]->items[0]);
        } else {
            $name = $this->gen->artificialRuleFromRhs($node);
            $this->cache[$node] = [$name, '$this->' . $name . '()'];
        }
        return $this->cache[$node];
    }

    /**
     * @return array Tuple[Optional[str], str]
     * @noinspection PhpUnused
     */
    protected function visitNamedItem(NamedItem $node): array {
        [$name, $call] = $this->visit($node->item);
        if ($node->name) {
            $name = $node->name;
        }
        return [$name, $call];
    }

    /**
     * @return array Tuple[None, str]
     * @noinspection PhpUnused
     * @noinspection PhpUnusedParameterInspection
     */
    protected function visitPositiveLookahead(PositiveLookahead $node): array {
        [$head, $tail] = $this->lookaheadCallHelper($node);
        throw new NotImplementedException();
        //return None, f"self.positive_lookahead({head}, {tail})"
    }

    /**
     * @return array Tuple[None, str]
     * @noinspection PhpUnused
     * @noinspection PhpUnusedParameterInspection
     */
    protected function visitNegativeLookahead(NegativeLookahead $node): array {
        /*  head, tail = self.lookahead_call_helper(node)
          return None, f"self.negative_lookahead({head}, {tail})"*/
        throw new NotImplementedException();
    }

    /**
     * @return array Tuple[str, str]
     * @noinspection PhpUnused
     * @noinspection PhpUnusedParameterInspection
     */
    protected function visitOpt(Opt $node): array {
        $call = $this->visit($node->node)[1];
        // Note trailing comma (the call may already have one comma at the end, for example when rules have both repeat0 and optional markers, e.g: [rule*])
        /*
        if (str_ends_with($call, ',')) {
            return ['opt', $call];
        }
        return ['opt', "$call,"];
        */
        return ['opt', $call . ' or true'];
    }

    /**
     * @return array Tuple[str, str]
     * @noinspection PhpUnused
     * @noinspection PhpUnusedParameterInspection
     */
    protected function visitRepeat0(Repeat0 $node): array {
        throw new NotImplementedException();
        /*
            if node in self.cache:
                return self.cache[node]
            name = self.gen.artificial_rule_from_repeat(node.node, False)
            self.cache[node] = name, f"self.{name}(),"  # Also a trailing comma!
            return self.cache[node]
    */
    }

    /**
     * @return array Tuple[str, str]
     * @noinspection PhpUnused
     * @noinspection PhpUnusedParameterInspection
     */
    protected function visitRepeat1(Repeat1 $node): array {
        if (isset($this->cache[$node])) {
            return $this->cache[$node];
        }
        $name = $this->gen->artificialRuleFromRepeat($node->node, true);
        $this->cache[$node] = [$name, '$this->' . $name . '()']; // But no trailing comma here!
        return $this->cache[$node];
    }

    /**
     * @return array Tuple[str, str]
     * @noinspection PhpUnused
     */
    protected function visitGather(Gather $node): array {
        if (isset($this->cache[$node])) {
            return $this->cache[$node];
        }
        $name = $this->gen->artificialRuleFromGather($node);
        $this->cache[$node] = [$name, '$this->' . $name . '()']; // No trailing comma here either!
        return $this->cache[$node];
    }

    /**
     * @return array Tuple[Optional[str], str]
     * @noinspection PhpUnused
     */
    protected function visitGroup(Group $node): array {
        return $this->visit($node->rhs);
    }

    /**
     * @return array Tuple[str, str]
     * @noinspection PhpUnused
     * @noinspection PhpUnusedParameterInspection
     */
    protected function visitCut(Cut $node): array {
        return ['cut', 'true'];
    }

    /**
     * @return array Tuple[str, str]
     * @noinspection PhpUnused
     * @noinspection PhpUnusedParameterInspection
     */
    protected function visitForced(Forced $node): array {
        /*
            if isinstance(node.node, Group):
                _, value = self.visit(node.node.rhs)
                return "forced", f"self.expect_forced({value}, '''({node.node.rhs!s})''')"
            else:
                return (
                    "forced",
                    f"self.expect_forced(self.expect({node.node.value}), {node.node.value!r})",
                )
     */
        throw new NotImplementedException();
    }

    /**
     * @return array Tuple[str, str]
     */
    private function lookaheadCallHelper(Lookahead $node): array {
        /*
        name, call = self . visit(node . node)
        head, tail = call . split("(", 1)
        assert tail[-1] == ")"
        tail = tail[:-1]
        return head, tail
       */
        throw new NotImplementedException();
    }

    private function softKeyword(): string {
        throw new NotImplementedException();
    }
}
