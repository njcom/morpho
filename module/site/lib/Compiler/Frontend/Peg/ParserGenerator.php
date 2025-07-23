<?php declare(strict_types=1);
/**
 * This file is part of njcom/framework
 * It is distributed under the 'Apache License Version 2.0' license.
 * See the https://github.com/njcom/framework/blob/main/LICENSE for the full license text.
 */
namespace Morpho\Compiler\Frontend\Peg;

use Closure;
use Morpho\Base\Must;
use Stringable;
use UnexpectedValueException;

use function Morpho\Base\camelize;
use function Morpho\Base\mkStream;
use function Morpho\Base\last;
use function Morpho\Base\init;
use function Morpho\Base\prepend;

use const Morpho\Base\INDENT;

/**
 * Based on https://github.com/python/cpython/blob/3.12/Tools/peg_generator/pegen/parser_generator.py
 * [class PythonParserGenerator(ParserGenerator, GrammarVisitor)](https://github.com/python/cpython/blob/3.12/Tools/peg_generator/pegen/python_generator.py#L192)
 * @todo: refactor this class:
 * 1. Split checking (analysis) phase into separate classes.
 * 2. Allow to use PythonParserGenerator generate(self, filename: str) -> None:
 */
class ParserGenerator implements IGrammarVisitor {
    private Grammar $grammar;

    /**
     * For name_rule()/name_loop()
     */
    private int $counter = 0;

    private GrammarVisitor $callMakerVisitor;

    /**
     * @var resource IO[Text]
     */
    private $stream;

    private int $level = 0;

    /**
     * @var array List[List[str]]
     */
    private array $localVarStack = [];

    /**
     * @var array Dict[str, int]
     */
    private array $keywords = [];

    /**
     * @var array Set[str]
     */
    private array $softKeywords = [];


    private int $keywordCounter = 499;

    /**
     * @var array Dict[str, Rule]
     */
    private array $rules;

    /**
     * @var mixed Dict[str, Rule]
     */
    private array $allRules;

    private readonly array $firstGraph;

    private readonly iterable $firstSccs;

    private InvalidNodeVisitor $invalidVisitor;
    private ?string $unreachableFormatting;
    private ?string $locationFormatting;


    /**
     * __init__(self, grammar: grammar.Grammar, file: Optional[IO[Text]], tokens: Set[str] = set(token.tok_name.values()), location_formatting: Optional[str] = None,unreachable_formatting: Optional[str] = None)
     * @todo: refactor arguments
     */
    public function __construct(Grammar $grammar, $targetStream, callable $ruleChecker, string|null $locationFormatting = null, string|null $unreachableFormatting = null) {
        $this->grammar = $grammar;

        $this->validateRuleNames($grammar->rules);

        $this->rules = $grammar->rules;
        if (!isset($this->grammar->metas['trailer']) && !isset($this->rules['start'])) {
            throw new GrammarException("Grammar without a trailer must have a 'start' rule");
        }

        $ruleChecker($this->rules);

        $this->stream = $targetStream; // self.file in Python
        [$this->firstGraph, $this->firstSccs] = $this->computeLeftRecursives($this->rules);
        // self.all_rules:  = self.rules.copy()
        $this->allRules = $this->rules; # Rules + temporal rules

        $this->callMakerVisitor = new CallMakerVisitor($this);
        $this->invalidVisitor = new InvalidNodeVisitor();
        $this->unreachableFormatting = $unreachableFormatting ?? "null  // pragma: no cover";
        $this->locationFormatting = ($locationFormatting ?? "lineno=start_lineno, col_offset=start_col_offset, ") . "end_lineno=end_lineno, end_col_offset=end_col_offset";
    }

    /**
     * @param array|null $conf
     *      namespace: string
     *      parentClass: Optional[string]
     *      class: string
     *      header: string
     *      subheader: string
     * @return string
     */
    public function generate(array|null $conf = null): string {
        $conf = (array)$conf;
        // @todo: $conf vs $this->grammar->metas
        if (!isset($conf['namespace'])) {
            $conf['namespace'] = __NAMESPACE__ . '\\Generated' . str_replace([' ', '.'], '', microtime());
        }
        if (!isset($conf['parentClass'])) {
            $conf['parentClass'] = init(get_class($this), '\\') . "\\Parser";
        }
        // @todo: Use PhpParser's generator?
        $this->collectRules();
        $header = $this->grammar->metas['header'] ?? "<?php\nnamespace {$conf['namespace']};\nuse " . $conf['parentClass'] . ';';
        if (null !== $header) {
            $this->write($header);
        }
        $subheader = $this->grammar->metas['subheader'] ?? '';
        if ($subheader) {
            $this->write($subheader);
        }
        $class = $this->grammar->metas['class'] ?? 'GeneratedParser';
        $conf['class'] = $class;
        $this->write("// Keywords and soft keywords are listed at the end of the parser definition.");
        $this->write("class $class extends " . last($conf['parentClass'], '\\') . ' {');
        foreach ($this->allRules as $rule) {
            $this->write();
            $this->visit($rule);
        }
        $this->write("}");
        //self.print(f"KEYWORDS = {tuple(self.keywords)}")
        //$this->write('const KEYWORDS = [' . implode(', ', array_keys($this->keywords)) . '];');
        //$this->write('const SOFT_KEYWORDS = [' . implode(', ', array_keys($this->softKeywords)) . '];');
        //self.print(f"SOFT_KEYWORDS = {tuple(self.soft_keywords)}")
        $footer = $this->grammar->metas['trailer'] ?? $this->fileFooter($conf);
        if (null !== $footer) {
            $this->write(rtrim($footer));
        }
        return $conf['namespace'] . '\\' . $class;
    }

    /**
     * Visit a node
     * def visit(self, node: Any, *args: Any, **kwargs: Any) -> Any:
     * @todo: make $args array
     */
    public function visit(mixed $node, ...$args): mixed {
        $method = 'visit' . camelize(last(get_class($node), '\\'), true);
        if (method_exists($this, $method)) {
            return $this->$method($node, ...$args);
        }
        return $this->genericVisit($node, ...$args);
    }

    /**
     * Called if no explicit visitor function exists for a node.
     * def generic_visit(self, node: Iterable[Any], *args: Any, **kwargs: Any) -> Any:
     * @noinspection PhpMixedReturnTypeCanBeReducedInspection
     */
    protected function genericVisit($node, ...$args): mixed {
        foreach ($node as $value) {
            if (is_array($value)) { // @todo: replace is_array() with is_iterable()?
                foreach ($value as $item) {
                    $this->visit($item, ...$args);
                }
            } else {
                $this->visit($value, ...$args);
            }
        }
        return null;
    }

    /**
     * @noinspection PhpUnused
     */
    protected function visitRule(Rule $node): void {
        $codeGen = function () use ($node) {
            $isLoop = $node->isLoop();
            $isGather = $node->isGather();
            $rhs = $node->flatten();
            $returnType = $node->type ?? 'mixed';
            if ($returnType !== 'mixed') { // `mixed` already contains `null` type.
                $returnType = $returnType . ' | null';
            }

            $this->write('function ' . $node->name . '(): ' . $returnType . ' {');
            $this->write('// ' . $node->name . ': ' . $rhs);
            $this->write('$index = $this->tokenizer->index;');
            if ($this->altsUseLocations($node->rhs->alts)) {
                $this->write('$tok = $this->tokenizer->peek();');
                $this->write('[$startLineNo, $startColOffset] = $tok->start;');
            }
            if ($isLoop) {
                $this->write('$children = [];');
            }
            $this->visit($rhs, isLoop: $isLoop, isGather: $isGather);

            if ($isLoop) {
                $this->write('return $children;');
            } else {
                $this->write('return null;');
            }

            $this->write('}');
        };

        if ($node->leftRecursive) {
            if ($node->leader) {
                $this->wrap($codeGen, 'return $this->memoizeLeftRec(', ');');
            } else {
                // Non-leader rules in a cycle are not memoized, but they must still be logged.
                // see `def logger()` in Tools/peg_generator/pegen/parser.py
                $this->wrap($codeGen, 'return $this->logger(', ');');
            }
        } else {
            $this->wrap($codeGen, 'return $this->memoize(__METHOD__, ', ');');
        }
    }

    /**
     * @noinspection PhpUnused
     */
    protected function visitNamedItem(NamedItem $node): void {
        [$name, $call] = $this->callMakerVisitor->visit($node->item);
        if ($node->name) {
            $name = $node->name;
        }
        if (!$name) {
            $this->write($call);
        } else {
            if ($name != 'cut') {
                $name = $this->dedupe($name);
            }
            // self.print(f"({name} := {call})")
            $this->write('($' . $name . ' = ' . $call . ')');
        }
    }

    /**
     * @noinspection PhpUnused
     */
    protected function visitRhs(Rhs $node, bool $isLoop = false, bool $isGather = false): void {
        if ($isLoop) {
            Must::beTruthy(count($node->alts) == 1);
        }
        foreach ($node->alts as $alt) {
            $this->visit($alt, isLoop: $isLoop, isGather: $isGather);
        }
    }

    /**
     * @noinspection PhpUnused
     */
    protected function visitAlt(Alt $node, bool $isLoop, bool $isGather): void {
        $hasCut = false;
        foreach ($node->items as $item) {
            if ($item->item instanceof Cut) {
                $hasCut = true;
                break;
            }
        }
        $this->localVarStack[] = [];
        if ($hasCut) {
            $this->write('$cut = false;');
        }
        if ($isLoop) {
            $this->write('while (');
        } else {
            $this->write('if (');
        }
        $first = true;
        foreach ($node->items as $item) {
            if ($first) {
                $first = false;
            } else {
                $this->write('&&');
            }
            $this->visit($item);
            if ($isGather) {
                $this->write('!== null');
            }
        }
        $this->write(') {');
        $action = $node->action;
        if (!$action) {
            if ($isGather) {
                Must::beTruthy(count(last($this->localVarStack)) == 2);
                $last = last($this->localVarStack);
                $action = 'array_merge([$' . $last[0] . '], ' . '$' . $last[1] . ');';
                //$action = f"[{self.local_variable_names[0]}] + {self.local_variable_names[1]}"
            } else {
                if ($this->invalidVisitor->visit($node)) {
                    $action = 'UNREACHABLE';
                } elseif (count(last($this->localVarStack)) == 1) {
                    $action = '$' . last($this->localVarStack)[0];
                } else {
                    $action = '[' . implode(', ', prepend(prefix: '$', list: last($this->localVarStack))) . ']';
                }
            }
        } elseif (str_contains($action, 'LOCATIONS')) {
            $this->write('$tok = $this->tokenizer->lastNonWhitespaceToken();');
            $this->write('[$endLineNo, $endColOffset] = $tok->end');
            $action = str_replace('LOCATIONS', $this->locationFormatting, $action);
        }
        if ($isLoop) {
            $this->write('$children[] = ' . $action . ';');
            $this->write('$index = $this->tokenizer->index;');
        } else {
            if (str_contains($action, 'UNREACHABLE')) {
                $action = str_replace('UNREACHABLE', $this->unreachableFormatting, $action);
            }
            $this->write('return ' . $action . ';');
        }
        $this->write('}');
        $this->write('$this->tokenizer->index = $index;');
        // Skip remaining alternatives if a cut was reached.
        if ($hasCut) {
            $this->write('if ($cut) return null;');
        }
        array_pop($this->localVarStack);
    }

    /**
     * @noinspection PhpUnusedParameterInspection
     */
    private function fileFooter(array $context): ?string {
        return '';
    }

    /**
     * @param iterable $alts Sequence[Alt]
     */
    private function altsUseLocations(iterable $alts): bool {
        foreach ($alts as $alt) {
            if ($alt->action && str_contains($alt->action, 'LOCATIONS')) {
                return true;
            }
            foreach ($alt->items as $node) {
                if ($node->item instanceof Group && $this->altsUseLocations($node->item->rhs->alts)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * @noinspection PhpSameParameterValueInspection
     */
    private function wrap(Closure $wrappedCodeGen, string $wrapperPreCode, string $wrapperPostCode): void {
        $stream = $this->stream;
        $this->stream = mkStream();

        $wrappedCodeGen();

        $code = stream_get_contents($this->stream, offset: 0);
        $this->stream = $stream;

        $lines = explode("\n", $code);
        $n = count($lines);
        $i = 0;
        $j = $n - 1;
        $leftOffset = $rightOffset = -1;
        // Find non empty start and end lines.
        while ($i < $j) {
            if ($leftOffset < 0) {
                if (trim($lines[$i]) != '') {
                    $leftOffset = $i;
                }
            }
            if ($rightOffset < 0) {
                if (trim($lines[$j]) != '') {
                    $rightOffset = $j;
                }
            }
            if ($leftOffset >= 0 && $rightOffset >= 0) {
                break;
            }
            $i++;
            $j--;
        }
        if ($leftOffset < 0 || $rightOffset < 0) {
            throw new UnexpectedValueException();
        }
        $this->write(
            $lines[$leftOffset] . "\n" // function start like 'public function foo() {'
            . $wrapperPreCode . "\n"   // decorator start like 'return $this->memoize('
            . "function () {\n" . implode("\n", array_slice($lines, $leftOffset + 1, $rightOffset - 1)) . "\n}\n" // function body
            . $wrapperPostCode . "\n" // decorator end like ');'
            . $lines[$rightOffset] // function end like '}'
        );
    }

    protected function validateRuleNames(iterable $rules): void {
        foreach ($rules as $name => $_) {
            if (str_starts_with($name, '_')) {
                throw new GrammarException("Rule names cannot start with underscore: '{$name}'");
            }
        }
    }

    public function artificialRuleFromRhs(Rhs $rhs): string {
        $this->counter++;
        $name = '_tmp_' . $this->counter; // TODO: Pick a nicer name.
        $this->allRules[$name] = new Rule($name, null, $rhs);
        return $name;
    }

    public function artificialRuleFromRepeat(Leaf|Group $node, bool $isRepeat1): string {
        $this->counter++;
        $prefix = $isRepeat1 ? '_loop1_' : '_loop0_';
        $name = $prefix . $this->counter;
        $this->allRules[$name] = new Rule($name, null, new Rhs([
            new Alt([
                new NamedItem(null, $node),
            ]),
        ]));
        return $name;
    }

    public function artificialRuleFromGather(Gather $node): string {
        $this->counter++;
        $name = '_gather_' . $this->counter;
        $this->counter++;
        //extra_function_name = f"_loop0_{self.counter}"
        $extraFunctionName = '_loop0_' . $this->counter;
        $extraFunctionAlt = new Alt(
            [
                new NamedItem(null, $node->separator),
                new NamedItem('elem', $node->node),
            ],
            action: 'elem',
        );
        $this->allRules[$extraFunctionName] = new Rule($extraFunctionName, null, new Rhs([$extraFunctionAlt]));
        $alt = new Alt([
            new NamedItem('elem', $node->node),
            new NamedItem('seq', new NameLeaf($extraFunctionName)),
        ]);
        $this->allRules[$name] = new Rule($name, null, new Rhs([$alt]));
        return $name;
    }

    public function keywordType(): int {
        $this->keywordCounter++;
        return $this->keywordCounter;
    }

    /*
        @contextlib.contextmanager
        def local_variable_context(self) -> Iterator[None]:
            self._local_variable_stack.append([])
            yield
            self._local_variable_stack.pop()

        @property
        def local_variable_names(self) -> List[str]:
            return self._local_variable_stack[-1]
    */

    /*
        @contextlib.contextmanager
        def indent(self) -> Iterator[None]:
            self.level += 1
            try:
                yield
            finally:
                self.level -= 1



        def printblock(self, lines: str) -> None:
            for line in lines.splitlines():
                self.print(line)
    */
    protected function write(Stringable|string|null $value = null): void {
        if (null === $value) {
            fwrite($this->stream, "\n");
        } else {
            fwrite($this->stream, str_repeat(INDENT, $this->level) . (string)$value . "\n");
        }
    }

    protected function dedupe(string $name): string {
        $origName = $name;
        $counter = 0;
        while (in_array($name, $this->localVarStack[count($this->localVarStack) - 1])) {
            $counter++;
            $name = $origName . '_' . $counter;
        }
        $this->localVarStack[count($this->localVarStack) - 1][] = $name;
        return $name;
    }

    protected function collectRules(): void {
        $keywordCollector = new KeywordCollectorVisitor($this, $this->keywords, $this->softKeywords);
        foreach ($this->allRules as $rule) {
            $keywordCollector->visit($rule);
        }

        $ruleCollector = new RuleCollectorVisitor($this->rules, $this->callMakerVisitor);
        $done = []; // Set[str] = set()
        while (true) {
            $computedRules = $this->allRules;
            $todo = [];
            foreach ($computedRules as $ruleName => $_) {
                if (!isset($done[$ruleName])) {
                    $todo[] = $ruleName;
                }
            }
            if (!$todo) {
                break;
            }
            $done = array_fill_keys(array_keys($this->allRules), true);
            foreach ($todo as $ruleName) {
                $ruleCollector->visit($this->allRules[$ruleName]);
            }
        }
    }

    /**
     * @param array $rules Dict[str, Rule]
     * @return array Tuple[Dict[str, AbstractSet[str]], List[AbstractSet[str]]]
     */
    private function computeLeftRecursives(array $rules): array {
        // Dict[str, AbstractSet[str]]
        $graph = $this->makeFirstGraph($rules);
        //sccs = list(sccutils.strongly_connected_components(graph.keys(), graph))
        $sccs = Scc::stronglyConnectedComponents(array_keys($graph), $graph);
        foreach ($sccs as $scc) {
            /** @var array $scc */
            if (count($scc) > 1) {
                foreach ($scc as $name) {
                    $rules[$name]->leftRecursive = true;
                }
                // Try to find a leader such that all cycles go through it.
                $leaders = array_unique($scc);
                foreach ($scc as $start) {
                    foreach (Scc::findCyclesInScc($graph, $scc, $start) as $cycle) {
                        $leaders = array_diff(
                            $leaders,
                            array_diff(
                                $scc,
                                array_unique($cycle)
                            )
                        );
                        if (!$leaders) {
                            throw new UnexpectedValueException("SCC {$scc} has no leadership candidate (no element is included in all cycles)");
                        }
                    }
                }
                $leader = min($leaders); // Pick an arbitrary leader from the candidates.
                $rules[$leader]->leader = true;
            } else {
                $name = min($scc);
                if (in_array($name, $graph[$name])) {
                    $rules[$name]->leftRecursive = true;
                    $rules[$name]->leader = true;
                }
            }
        }
        return [$graph, $sccs];
    }

    /**
     * Compute the graph of left-invocations.
     * def make_first_graph(rules: Dict[str, Rule]) -> Dict[str, AbstractSet[str]]:
     */
    private function makeFirstGraph(array $rules): array {
        // There's an edge from A to B if A may invoke B at its initial position.
        // Note that this requires the nullable flags to have been computed.
        $initialNameVisitor = new InitialNameVisitor($rules);
        $graph = [];
        $vertices = []; // Set[str] = set()
        foreach ($rules as $name => $rhs) {
            $graph[$name] = $names = $initialNameVisitor->visit($rhs);
            $vertices = array_unique(array_merge($vertices, $names));
        }
        foreach ($vertices as $vertex) {
            if (!isset($graph[$vertex])) {
                $graph[$vertex] = [];
            }
        }
        return $graph;
    }
}