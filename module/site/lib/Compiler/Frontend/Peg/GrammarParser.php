<?php declare(strict_types=1);
/**
 * This file is part of njcom/framework
 * It is distributed under the 'Apache License Version 2.0' license.
 * See the https://github.com/njcom/framework/blob/main/LICENSE for the full license text.
 */
namespace Morpho\Compiler\Frontend\Peg;

require_once __DIR__ . '/Grammar.php';

/**
 * https://github.com/python/cpython/blob/3.12/Tools/peg_generator/pegen/grammar_parser.py
 */
class GrammarParser extends Parser {
    /**
     * start: grammar $
     */
    public function start(): ?Grammar {
        return $this->memoize(
            __METHOD__,
            function (): ?Grammar {
                $index = $this->tokenizer->index;
                if (($grammar = $this->grammar()) && $this->expect('ENDMARKER')) {
                    return $grammar;
                }
                $this->tokenizer->index = $index;
                return null;
            }
        );
    }

    /**
     * ast.literal_eval() in Python
     * @todo: move somewhere, find better place that this class.
     */
    public static function _literalEval(string $literal): string {
        // Handle ''' and """ Python strings
        if (preg_match('~^(\'\'\'|""")(?P<value>.*)(\\1)$~s', $literal, $match)) {
            $literal = '"' . $match['value'] . '"';
        }
        if ($literal === "''" || $literal === '""') {
            return '';
        }
        /*        try {
                    return eval('return ' . $literal . ';');
                } catch (\ParseError $e) {
                    d($literal);
                }*/
        return eval('return ' . $literal . ';');
    }

    /**
     * grammar: metas rules | rules
     */
    private function grammar(): ?Grammar {
        return $this->memoize(
            __METHOD__,
            function (): ?Grammar {
                $index = $this->tokenizer->index;
                if (($metas = $this->metas()) && ($rules = $this->rules())) {
                    return new Grammar($rules, $metas);
                }
                $this->tokenizer->index = $index;
                if ($rules = $this->rules()) {
                    return new Grammar($rules, []);
                }
                $this->tokenizer->index = $index;
                return null;
            }
        );
    }

    /**
     * metas: meta metas | meta
     */
    private function metas(): ?array {
        return $this->memoize(
            __METHOD__,
            function (): ?array {
                $index = $this->tokenizer->index;
                if (($meta = $this->meta()) && ($metas = $this->metas())) {
                    return array_merge([$meta], $metas);
                }
                $this->tokenizer->index = $index;
                if ($meta = $this->meta()) {
                    return [$meta];
                }
                $this->tokenizer->index = $index;
                return null;
            }
        );
    }

    /**
     * meta: "@" NAME NEWLINE | "@" NAME NAME NEWLINE | "@" NAME STRING NEWLINE
     */
    private function meta(): ?array {
        return $this->memoize(
            __METHOD__,
            function (): ?array {
                $index = $this->tokenizer->index;
                if ($this->expect('@') && ($name = $this->name()) && $this->expect('NEWLINE')) {
                    return [$name->value, null];
                }
                $this->tokenizer->index = $index;
                if ($this->expect('@') && ($a = $this->name()) && ($b = $this->name()) && $this->expect('NEWLINE')) {
                    return [$a->value, $b->value];
                }
                $this->tokenizer->index = $index;
                if ($this->expect('@') && ($name = $this->name()) && ($string = $this->string()) && $this->expect('NEWLINE')) {
                    return [$name->value, self::_literalEval($string->value)];
                }
                $this->tokenizer->index = $index;
                return null;
            }
        );
    }

    /**
     * rules: rule rules | rule
     */
    private function rules(): ?RuleList {
        return $this->memoize(
            __METHOD__,
            function (): ?RuleList {
                $index = $this->tokenizer->index;
                if (($rule = $this->rule()) && ($rules = $this->rules())) {
                    return new RuleList(array_merge([$rule], $rules->getArrayCopy()));
                }
                $this->tokenizer->index = $index;
                if ($rule = $this->rule()) {
                    return new RuleList([$rule]);
                }
                $this->tokenizer->index = $index;
                return null;
            }
        );
    }

    /**
     * rule: rulename memoflag? ":" alts NEWLINE INDENT more_alts DEDENT | rulename memoflag? ":" NEWLINE INDENT more_alts DEDENT | rulename memoflag? ":" alts NEWLINE
     */
    private function rule(): ?Rule {
        return $this->memoize(
            __METHOD__,
            function (): ?Rule {
                $index = $this->tokenizer->index;
                /** @noinspection PhpBooleanCanBeSimplifiedInspection */
                if (
                    ($ruleName = $this->ruleName())
                    && ($opt = ($this->memoFlag() || true))
                    && ($this->expect(":"))
                    && ($alts = $this->alts())
                    && ($this->expect('NEWLINE'))
                    && ($this->expect('INDENT'))
                    && ($moreAlts = $this->moreAlts())
                    && ($this->expect('DEDENT'))
                ) {
                    return new Rule($ruleName[0], $ruleName[1], new Rhs(array_merge($alts->alts, $moreAlts->alts)), memo: $opt === true ? null : $opt);
                }
                $this->tokenizer->index = $index;
                /** @noinspection PhpBooleanCanBeSimplifiedInspection */
                if (
                    ($ruleName = $this->ruleName())
                    && ($opt = ($this->memoFlag() || true))
                    && ($this->expect(":"))
                    && ($this->expect('NEWLINE'))
                    && ($this->expect('INDENT'))
                    && ($moreAlts = $this->moreAlts())
                    && ($this->expect('DEDENT'))
                ) {
                    return new Rule($ruleName[0], $ruleName[1], $moreAlts, memo: $opt === true ? null : $opt);
                }
                $this->tokenizer->index = $index;
                /** @noinspection PhpBooleanCanBeSimplifiedInspection */
                if (
                    ($ruleName = $this->ruleName())
                    && ($opt = ($this->memoFlag() || true))
                    && ($this->expect(":"))
                    && ($alts = $this->alts())
                    && ($this->expect('NEWLINE'))
                ) {
                    return new Rule($ruleName[0], $ruleName[1], $alts, memo: $opt === true ? null : $opt);
                }
                $this->tokenizer->index = $index;
                return null;
            }
        );
    }

    /**
     * rulename: NAME annotation | NAME
     */
    private function ruleName(): ?RuleName {
        return $this->memoize(
            __METHOD__,
            function (): ?RuleName {
                $index = $this->tokenizer->index;
                if (($name = $this->name()) && ($annotation = $this->annotation())) {
                    return new RuleName($name->value, $annotation);
                }
                $this->tokenizer->index = $index;
                if ($name = $this->name()) {
                    return new RuleName($name->value, null);
                }
                $this->tokenizer->index = $index;
                return null;
            }
        );
    }

    /**
     * memoflag: '(' "memo" ')'
     */
    private function memoFlag(): ?string {
        return $this->memoize(
            __METHOD__,
            function (): ?string {
                $index = $this->tokenizer->index;
                if ($this->expect('(') && $this->expect('memo') && $this->expect(')')) {
                    return "memo";
                }
                $this->tokenizer->index = $index;
                return null;
            }
        );
    }

    /**
     * alts: alt "|" alts | alt
     */
    private function alts(): ?Rhs {
        return $this->memoize(
            __METHOD__,
            function (): ?Rhs {
                $index = $this->tokenizer->index;
                if (($alt = $this->alt()) && $this->expect("|") && ($alts = $this->alts())) {
                    return new Rhs(array_merge([$alt], $alts->alts));
                }
                $this->tokenizer->index = $index;
                if ($alt = $this->alt()) {
                    return new Rhs([$alt]);
                }
                $this->tokenizer->index = $index;
                return null;
            }
        );
    }

    /**
     * more_alts: "|" alts NEWLINE more_alts | "|" alts NEWLINE
     */
    private function moreAlts(): ?Rhs {
        return $this->memoize(
            __METHOD__,
            function (): ?Rhs {
                $index = $this->tokenizer->index;
                if (
                    ($this->expect("|"))
                    && ($alts = $this->alts())
                    && $this->expect('NEWLINE')
                    && ($moreAlts = $this->moreAlts())
                ) {
                    return new Rhs(array_merge($alts->alts, $moreAlts->alts));
                }
                $this->tokenizer->index = $index;
                if ($this->expect("|") && ($alts = $this->alts()) && ($this->expect('NEWLINE'))) {
                    return new Rhs($alts->alts);
                }
                $this->tokenizer->index = $index;
                return null;
            }
        );
    }

    /**
     * alt: items '$' action | items '$' | items action | items
     */
    private function alt(): ?Alt {
        return $this->memoize(
            __METHOD__,
            function (): ?Alt {
                $index = $this->tokenizer->index;
                if (($items = $this->items()) && ($this->expect('$')) && ($action = $this->action())) {
                    return new Alt(
                        array_merge(
                            $items,
                            [new NamedItem(null, new NameLeaf('ENDMARKER'))]
                        ), action: $action
                    );
                }
                $this->tokenizer->index = $index;
                if (($items = $this->items()) && ($this->expect('$'))) {
                    return new Alt(
                        array_merge($items, [new NamedItem(null, new NameLeaf('ENDMARKER'))])
                        , action: null
                    );
                }
                $this->tokenizer->index = $index;
                if (($items = $this->items()) && ($action = $this->action())) {
                    return new Alt($items, action: $action);
                }
                $this->tokenizer->index = $index;
                if ($items = $this->items()) {
                    return new Alt($items, action: null);
                }
                $this->tokenizer->index = $index;
                return null;
            }
        );
    }

    /**
     * items: named_item items | named_item
     */
    private function items(): ?array {
        return $this->memoize(
            __METHOD__,
            function (): ?array {
                $index = $this->tokenizer->index;
                if (($namedItem = $this->namedItem()) && ($items = $this->items())) {
                    return array_merge([$namedItem], $items);
                }
                $this->tokenizer->index = $index;
                if ($namedItem = $this->namedItem()) {
                    return [$namedItem];
                }
                $this->tokenizer->index = $index;
                return null;
            }
        );
    }

    /**
     * named_item: NAME annotation '=' ~ item | NAME '=' ~ item | item | forced_atom | lookahead
     */
    private function namedItem(): ?NamedItem {
        return $this->memoize(
            __METHOD__,
            function (): ?NamedItem {
                $index = $this->tokenizer->index;
                $cut = false;
                if (
                    ($name = $this->name())
                    && ($annotation = $this->annotation())
                    && ($this->expect('='))
                    && ($cut = true)
                    && ($item = $this->item())
                ) {
                    return new NamedItem($name->value, $item, $annotation);
                }
                $this->tokenizer->index = $index;
                if ($cut) {
                    return null;
                }
                //$cut = false;
                if (($name = $this->name())
                    && $this->expect('=')
                    && ($cut = true)
                    && ($item = $this->item())) {
                    return new NamedItem($name->value, $item);
                }
                $this->tokenizer->index = $index;
                if ($cut) {
                    return null;
                }
                if ($item = $this->item()) {
                    return new NamedItem(null, $item);
                }
                $this->tokenizer->index = $index;
                if ($it = $this->forcedAtom()) {
                    return new NamedItem(null, $it);
                }
                $this->tokenizer->index = $index;
                if ($it = $this->lookahead()) {
                    return new NamedItem(null, $it);
                }
                $this->tokenizer->index = $index;
                return null;
            }
        );
    }

    /**
     * forced_atom: '&' '&' ~ atom
     */
    private function forcedAtom(): null|Lookahead|Forced|Cut {
        return $this->memoize(
            __METHOD__,
            function (): null|Lookahead|Forced|Cut {
                $index = $this->tokenizer->index;
                //$cut = false;
                if ($this->expect('&') && $this->expect('&') && /*($cut = true) &&*/ ($atom = $this->atom())) {
                    return new Forced($atom);
                }
                $this->tokenizer->index = $index;
//                if ($cut) {
//                    return null
//                }
                return null;
            }
        );
    }

    /**
     * lookahead: '&' ~ atom | '!' ~ atom | '~'
     * def lookahead(self) -> Optional[LookaheadOrCut]:
     *   LookaheadOrCut = Union[Lookahead, Forced, Cut]
     */
    private function lookahead(): null|Lookahead|Forced|Cut {
        return $this->memoize(
            __METHOD__,
            function (): null|Lookahead|Forced|Cut {
                $index = $this->tokenizer->index;
                $cut = false;
                if ($this->expect('&') && ($cut = true) && ($atom = $this->atom())) {
                    return new PositiveLookahead($atom);
                }
                $this->tokenizer->index = $index;
                if ($cut) {
                    return null;
                }
                //$cut = false;
                if ($this->expect('!') && ($cut = true) && ($atom = $this->atom())) {
                    return new NegativeLookahead($atom);
                }
                $this->tokenizer->index = $index;
                if ($cut) {
                    return null;
                }
                if ($this->expect('~')) {
                    return new Cut();
                }
                $this->tokenizer->index = $index;
                return null;
            }
        );
    }

    /**
     * item: '[' ~ alts ']' | atom '?' | atom '*' | atom '+' | atom '.' atom '+' | atom
     * def item(self) -> Optional[Item]
     *   Item = Union[Plain, Opt, Repeat, Forced, Lookahead, Rhs, Cut]
     *   Plain = Union[Leaf, Group]
     */
    private function item(): null|Leaf|Group|Opt|Repeat|Forced|Lookahead|Rhs|Cut {
        return $this->memoize(
            __METHOD__,
            function (): null|Leaf|Group|Opt|Repeat|Forced|Lookahead|Rhs|Cut {
                $index = $this->tokenizer->index;
                $cut = false;
                if ($this->expect('[') && ($cut = true) && ($alts = $this->alts()) && $this->expect(']')) {
                    return new Opt($alts);
                }
                $this->tokenizer->index = $index;
                if ($cut) {
                    return null;
                }
                if (($atom = $this->atom()) && $this->expect('?')) {
                    return new Opt($atom);
                }
                $this->tokenizer->index = $index;
                if (($atom = $this->atom()) && $this->expect('*')) {
                    return new Repeat0($atom);
                }
                $this->tokenizer->index = $index;
                if (($atom = $this->atom()) && $this->expect('+')) {
                    return new Repeat1($atom);
                }
                $this->tokenizer->index = $index;
                if (
                    ($sep = $this->atom())
                    && $this->expect('.')
                    && ($node = $this->atom())
                    && $this->expect('+')) {
                    return new Gather($sep, $node);
                }
                $this->tokenizer->index = $index;
                if ($atom = $this->atom()) {
                    return $atom;
                }
                $this->tokenizer->index = $index;
                return null;
            }
        );
    }

    /**
     * atom: '(' ~ alts ')' | NAME | STRING
     * def atom(self) -> Optional[Plain]:
     *   Plain = Union[Leaf, Group]
     */
    private function atom(): null|Leaf|Group {
        return $this->memoize(
            __METHOD__,
            function (): null|Leaf|Group {
                $index = $this->tokenizer->index;
                $cut = false;
                if ($this->expect('(') && ($cut = true) && ($alts = $this->alts()) && $this->expect(')')) {
                    return new Group($alts);
                }
                $this->tokenizer->index = $index;
                if ($cut) {
                    return null;
                }
                if ($name = $this->name()) {
                    return new NameLeaf($name->value);
                }
                $this->tokenizer->index = $index;
                if ($string = $this->string()) {
                    return new StringLeaf($string->value);
                }
                $this->tokenizer->index = $index;
                return null;
            }
        );
    }

    /**
     * action: "{" ~ target_atoms "}"
     */
    private function action(): ?string {
        return $this->memoize(
            __METHOD__,
            function (): ?string {
                $index = $this->tokenizer->index;
                //$cut = false;
                if ($this->expect("{") /*&& ($cut = true)*/ && ($targetAtoms = $this->targetAtoms()) && $this->expect("}")) {
                    return $targetAtoms;
                }
                $this->tokenizer->index = $index;
                /*if ($cut) {
                    return null;
                }*/
                return null;
            }
        );
    }

    /**
     * annotation: "[" ~ target_atoms "]"
     */
    private function annotation(): ?string {
        return $this->memoize(
            __METHOD__,
            function (): ?string {
                $index = $this->tokenizer->index;
                if ($this->expect('[') && ($targetAtoms = $this->targetAtoms()) && $this->expect(']')) {
                    return $targetAtoms;
                }
                $this->tokenizer->index = $index;
                return null;
            }
        );
    }

    /**
     * target_atoms: target_atom target_atoms | target_atom
     */
    private function targetAtoms(): ?string {
        return $this->memoize(
            __METHOD__,
            function (): ?string {
                $index = $this->tokenizer->index;
                if (($targetAtom = $this->targetAtom()) && ($targetAtoms = $this->targetAtoms())) {
                    return $targetAtom . ' ' . $targetAtoms;
                }
                $this->tokenizer->index = $index;
                if ($targetAtom = $this->targetAtom()) {
                    return $targetAtom;
                }
                $this->tokenizer->index = $index;
                return null;
            }
        );
    }

    private function targetAtom(): ?string {
        return $this->memoize(
            __METHOD__,
            function (): ?string {
                $token = $this->tokenizer->nextToken();
                if ($token->type !== TokenType::PhpCode) {
                    return null;
                }
                return trim($token->value);
                /*
 
// target_atom: "{" ~ target_atoms? "}" | "[" ~ target_atoms? "]" | NAME "*" | NAME | NUMBER | STRING | "?" | ":" | !"}" !"]" OP

                //$index = $this->tokenizer->index;
2                $cut = false;
                /** @noinspection PhpBooleanCanBeSimplifiedInspection * /
                if ($this->expect("{") && ($cut = true) && ($atoms = ($this->targetAtoms() || true)) && $this->expect("}")) {
                    /** @noinspection PhpConditionAlreadyCheckedInspection * /
                    return "{" . ($atoms === true ? '' : $atoms) . "}";
                }
                $this->tokenizer->index = $index;
                if ($cut) {
                    return null;
                }
                $cut = false;
                /** @noinspection PhpBooleanCanBeSimplifiedInspection * /
                if ($this->expect('[') && ($cut = true) && ($atoms = ($this->targetAtoms() || true)) && $this->expect(']')) {
                    /** @noinspection PhpConditionAlreadyCheckedInspection * /
                    return '[' . ($atoms === true ? '' : $atoms) . ']';
                }
                $this->tokenizer->index = $index;
                if ($cut) {
                    return null;
                }
                if (($name = $this->name()) && $this->expect('*')) {
                    return $name->value . '*';
                }
                $this->tokenizer->index = $index;
                if ($name = $this->name()) {
                    return $name->value;
                }
                $this->tokenizer->index = $index;
                if ($number = $this->number()) {
                    return $number->value;
                }
                $this->tokenizer->index = $index;
                if ($string = $this->string()) {
                    return $string->value;
                }
                $this->tokenizer->index = $index;
                if ($this->expect('?"')) {
                    return '?';
                }
                $this->tokenizer->index = $index;
                if ($this->expect(':')) {
                    return ':';
                }
                $this->tokenizer->index = $index;
                if ($this->negativeLookahead($this->expect(...), '}') && $this->negativeLookahead($this->expect(...), ']') && ($op = $this->op())) {
                    return $op->value;
                }
                $this->tokenizer->index = $index;
                return null;
                */
            }
        );
    }
}