# L Language Definition

Human - AI interop language.

## Core Concepts

L Language: a polyglotic language blending formal and natural modes for AI-human collaboration.

Purpose: unified communication, knowledge organization, task management.
Foundation: AI, mathematics, physics, biology, game development.
Paradigm: task-based with `problem -> context -> method -> tool` flow.

## Type System

type-categories:
  primitive-types:
    boolean: true | false
    number: ℕ (natural) | ℤ (integer) | ℚ (rational) | ℝ (real) | ℂ (complex)
    string: text sequences
    symbol: identifiers in lowercase-with-dashes
    unit: () for computations with side effects only

  composite-types:
    list: ordered sequence [a, b, c]
    set: unordered collection {a, b, c}
    tuple: fixed-size product (a, b, c)
    record: named fields {field-1: value, field-2: value}
    function: input -> output
    pipeline: stage-1 -> stage-2 -> stage-3
    sum-type: a | b | c (disjoint union)

  type-constructors:
    maybe: some value | none
    either: left error | right value
    list: [a] for list of a
    pair: (a, b) for product type

  special-types:
    task: unit of work with state and metadata
    problem: issue with severity level
    project: collection of related tasks

## Syntax Forms

### Formal L Syntax

Use formal L when clear semantics for structure or behavior exist. All identifiers in lowercase-with-dashes. Indentation-based scoping with 2 spaces in .l files.

Basic constructs:

  term-binding:
    identifier: value-expression
    multi-line-term:
      Continuation with deeper indentation.
      Can span multiple lines.

  function-call:
    function-name arg1 arg2 arg3

Operators and special forms:

  pipeline:
    input -> transform-1 -> transform-2 -> output
    Note: `a -> b` ~ `a then b`

  evolution:
    a >> b
    Indicates progression or transformation from a to b.

  hierarchy:
    a/b/c or /a/b/c
    Represents nested structure or path.

  equivalence:
    a ~ b
    States that a is equivalent to b.

  composition:
    f after g x  ~ f (g x)   (left composition, apply g first)
    f before g x ~ g (f x)   (right composition, apply f first)

  function-definition:
    f: a to b to c
    Function f takes a, returns function that takes b, returns c.

  currying:
    add: int to int to int
    add x y = x + y
    add-five = add 5
    Partial application creates new functions by supplying fewer arguments.

  sections:
    left-section: (x +) ~ (\y -> x + y)
    right-section: (+ y) ~ (\x -> x + y)
    Operator sections create partially applied functions.

  lambdas:
    \x -> x + 1
    \x y -> x + y
    (\x -> x * 2) 5  ~ 10
    Anonymous functions using Haskell notation.

  point-free-style:
    sum-and-double = (* 2) after sum
    process-users = filter active -> map normalize -> sort-by name
    Functions defined by composition without explicit parameters.

  record-literal:
    field-1: value-1
    field-2: value-2
    nested:
      inner-field: inner-value

  list-literal:
    [element-1, element-2, element-3]

  set-literal:
    {element-1, element-2, element-3}
    Note: context determines if braces are set or record.
    Set: unordered, no duplicates, e.g. {1, 2, 3} ~ {3, 2, 1}
    Record: named fields, e.g. {x: 1, y: 2}

  mathematical-operators:
    Arithmetic:
      + - * / (basic operations)
      ^ or ** (exponentiation)
      mod (modulo)
      div (integer division)
      sqrt, log, exp (functions)

    Comparison:
      = or == (equality)
      ≠ or /= (inequality)
      < > ≤ ≥ (ordering)

    Logical:
      ∧ or && (and)
      ∨ or || (or)
      ¬ or not (negation)
      ⊕ or xor (exclusive or)
      ⇒ or => (implication)
      ⇔ or <=> (equivalence)

    Set operations:
      ∈ (element of)
      ∉ (not element of)
      ⊆ ⊇ (subset, superset)
      ∪ ∩ (union, intersection)
      ∖ or \ (set difference)
      ∅ (empty set)

    Quantifiers:
      ∀ (for all)
      ∃ (exists)
      ∃! (exists unique)

    List operations:
      ++ (concatenation)
      : or :: (cons, prepend)
      !! (index access)
      .. (range)

  mathematical-notation:
    Summation: Σ_{i=1}^{n} f(i)
    Product: Π_{i=1}^{n} f(i)
    Limit: lim_{x→a} f(x)
    Integral: ∫_{a}^{b} f(x) dx
    Derivative: df/dx or f'(x)

### Natural L Syntax

Use natural L for human-readable descriptions and explanations. Start sentences with uppercase letters. Can contain formal L terms in backticks for inline references like `function-name` or `variable-identifier`.

Text flows naturally in paragraphs. Multiple sentences can appear on single long lines. Use paragraph breaks when shifting topics or for readability.

Primary item types in natural L are notes (no prefix) and tasks (prefixed with `-, +, -?, -!, -!!, -!!!`).

## Mixing Modes

### Pattern 1: Term with Description

authentication-service:
  Handles user login and session management. Uses JWT tokens with HS256 signing.

  token-expiry: 3600
  refresh-expiry: 86400
  algorithm: hs256

The formal terms capture precise configuration while natural text explains intent and context.

### Pattern 2: Formal Block with Natural Comments

validation-pipeline:
  Validates incoming requests before processing.

  steps:
    parse-request -> validate-schema -> check-auth -> process

  Each step can fail and return error response. Failures are logged to monitoring system.

### Pattern 3: Tasks with Mixed Context

- Implement token validation middleware #backend, #security
  Use the `hs256` algorithm for signing.

  config:
    secret-key-source: environment-variable
    expiry-seconds: 3600
    issuer: auth-service

  - Create validation function
  - Add error handling for expired tokens
  - Write unit tests

  -! Need to verify token refresh mechanism

## Task Management Sublanguage

Task items represent work units with states and metadata.

Task state prefixes:

1. `-` : todo, not yet started
2. `+` : completed, done
3. `-?` : unknown, undecided
4. `-!` : minor problem
5. `-!!` : major problem
6. `-!!!` : critical problem

Task structure example:

- Task title goes here #tag1, #tag2
  Related text indented below without prefix. Can include formal blocks:

  config:
    setting-1: value
    setting-2: value

  - Subtask one
  - Subtask two

Task hierarchy for factoring common context:

Create endpoints for:
  User registration
  User login
  Password reset

This factors out the common "Create endpoints for" prefix. Not a parent-child relationship but context scoping.

## Practical Examples

### Example 1: Module System Description

module-system:
  Knowledge organization mechanism in L.

  location: ~/m/module/{module-name}/
  purpose: accumulate technology and domain knowledge

  structure:
    module-root/
      README or main .l file
      examples/
      dev/
        {task-name}/
          plan.l
          context.l
          tasks.l

Naming convention uses lowercase-with-dashes for directory names following formal L naming rules.

Examples: `kubernetes` (not Kubernetes), `claude-code` (not ClaudeCode), `go-backend` (not go_backend or goBackend).

### Example 2: Workflow Definition

development-workflow:
  Standard workflow for implementing new features.

  phases:
    planning -> implementation -> review -> deployment

planning-phase:
  - Research existing code #exploration
  - Create strategic plan #documentation
  - Review with team #collaboration

  Outputs plan.l, context.l, tasks.l files.

implementation-phase:
  - Work through tasks sequentially #development
  - Update context as decisions made #documentation
  - Mark tasks complete immediately #tracking

  Follow task management conventions from 004-flow.l.

review-phase:
  code-review -> architecture-review -> security-review

  Each review type has specific checklist. All reviews must pass before deployment.

deployment-phase:
  - Run tests #validation
  - Build artifacts #build
  - Deploy to staging #deployment
  - Verify in staging #verification
  - Deploy to production #deployment

### Example 3: Type Definition with Semantics

user-entity:
  Domain model for authenticated users.

  fields:
    user-id: unique-identifier
    username: string
    email: email-address
    role: admin | user | guest
    created-at: timestamp
    updated-at: timestamp

  invariants:
    Email must be valid format.
    Username must be unique across system.
    Role determines permission set.

  operations:
    create-user: user-data to user-entity
    update-profile: user-id to profile-data to user-entity
    delete-user: user-id to unit
    authenticate: credentials to (user-entity | error)

state-transitions:
  guest >> user: after registration
  user >> admin: manual promotion only
  any >> deleted: soft delete, mark inactive

### Example 4: Composition Examples

Composition operators demonstrate function chaining in different orders.

authentication-flow:
  validate-token after extract-token request
  This means: first extract token from request, then validate it.
  Equivalent to: validate-token (extract-token request)

  Alternatively written as pipeline:
  request -> extract-token -> validate-token

logging-wrapper:
  log-result before process-request data
  This means: first process request, then log the result.
  Equivalent to: log-result (process-request data)

Function composition creates new functions from existing ones. The `after` operator applies right function first (left composition). The `before` operator applies left function first (right composition).

### Example 5: Mathematical Definitions

fibonacci-sequence:
  Classic recursive sequence defined mathematically.

  definition:
    fib: ℕ -> ℕ
    fib 0 = 0
    fib 1 = 1
    fib n = fib (n-1) + fib (n-2)  where n ≥ 2

  closed-form:
    fib n = (φ^n - ψ^n) / √5
    where φ = (1 + √5) / 2  (golden ratio)
          ψ = (1 - √5) / 2

factorial-definition:
  factorial: ℕ -> ℕ
  factorial n = Π_{i=1}^{n} i = n!
  factorial 0 = 1

vector-operations:
  Vector space over ℝ.

  dot-product:
    ⟨u, v⟩ = Σ_{i=1}^{n} u_i * v_i

  norm:
    ‖v‖ = √(⟨v, v⟩)

  distance:
    d(u, v) = ‖u - v‖

calculus-example:
  Derivative of composition using chain rule.

  theorem:
    ∀ f: ℝ -> ℝ, g: ℝ -> ℝ.
    d/dx (f ∘ g)(x) = f'(g(x)) * g'(x)

  example:
    Let f(x) = x² and g(x) = sin(x)
    h(x) = (f ∘ g)(x) = sin²(x)
    h'(x) = 2*sin(x)*cos(x) = sin(2x)

set-theory-example:
  Mathematical sets and operations.

  basic-sets:
    primes = {2, 3, 5, 7, 11, 13, ...}
    evens = {x | x ∈ ℤ ∧ x mod 2 = 0}
    empty = ∅ or {}

  set-operations:
    union: {1, 2} ∪ {2, 3} = {1, 2, 3}
    intersection: {1, 2, 3} ∩ {2, 3, 4} = {2, 3}
    difference: {1, 2, 3} ∖ {2} = {1, 3}
    subset: {1, 2} ⊆ {1, 2, 3} = true

  set-comprehension:
    squares = {x² | x ∈ ℕ ∧ x ≤ 10}
    = {0, 1, 4, 9, 16, 25, 36, 49, 64, 81, 100}

  cardinality:
    |{1, 2, 3}| = 3
    |∅| = 0
    |ℕ| = ℵ₀ (countably infinite)

  power-set:
    𝒫({1, 2}) = {∅, {1}, {2}, {1, 2}}
    |𝒫(A)| = 2^|A|

### Example 6: Type System Formal Specification

type-system-rules:
  Formal specification of L type checking.

  typing-judgment:
    Γ ⊢ e : τ

    Context Γ proves expression e has type τ.

  inference-rules:
    variable-rule:
      x : τ ∈ Γ
      -----------
      Γ ⊢ x : τ

    application-rule:
      Γ ⊢ f : τ₁ -> τ₂    Γ ⊢ a : τ₁
      ---------------------------------
      Γ ⊢ f a : τ₂

    lambda-rule:
      Γ, x : τ₁ ⊢ e : τ₂
      -------------------------
      Γ ⊢ (\x -> e) : τ₁ -> τ₂

    pipeline-rule:
      Γ ⊢ e₁ : τ₁    Γ ⊢ e₂ : τ₁ -> τ₂    Γ ⊢ e₃ : τ₂ -> τ₃
      -------------------------------------------------------
      Γ ⊢ e₁ -> e₂ -> e₃ : τ₃

    let-binding-rule:
      Γ ⊢ e₁ : τ₁    Γ, x : τ₁ ⊢ e₂ : τ₂
      -------------------------------------
      Γ ⊢ (let x = e₁ in e₂) : τ₂

Mathematical notation and formal logic embedded in L provide precise semantics when needed.

## Integration Patterns

L is polyglotic and embeds other languages naturally. Use standard markdown code blocks for non-L languages:

```python
def example_function(arg):
  return arg * 2
```

```lean
theorem example : ∀ n : ℕ, n + 0 = n := by
  intro n
  rfl
```

Reference external code in natural text: The `authenticate` function uses Python. The proof is verified in Lean 4.

### LaTeX Integration

L supports inline and display LaTeX math as in markdown:

Inline math: The quadratic formula is $x = \frac{-b \pm \sqrt{b^2 - 4ac}}{2a}$.

Display math:
$$
\int_{-\infty}^{\infty} e^{-x^2} dx = \sqrt{\pi}
$$

Complex equations:
$$
\begin{aligned}
\nabla \cdot \mathbf{E} &= \frac{\rho}{\epsilon_0} \\
\nabla \cdot \mathbf{B} &= 0 \\
\nabla \times \mathbf{E} &= -\frac{\partial \mathbf{B}}{\partial t} \\
\nabla \times \mathbf{B} &= \mu_0 \mathbf{J} + \mu_0 \epsilon_0 \frac{\partial \mathbf{E}}{\partial t}
\end{aligned}
$$

Matrix notation:
$$
A = \begin{bmatrix}
a_{11} & a_{12} & a_{13} \\
a_{21} & a_{22} & a_{23} \\
a_{31} & a_{32} & a_{33}
\end{bmatrix}
$$

Use LaTeX when:
1. Complex mathematical notation needed.
2. Rendering in PDF or web with MathJax/KaTeX.
3. Standard mathematical typesetting conventions required.

Use Unicode symbols when:
1. Simple mathematical expressions.
2. Plain text readability important.
3. No special rendering available.

File organization example:

project-root/
  README.l: natural language overview
  architecture.l: formal system description
  tasks.l: current work items
  dev/
    feature-x/
      plan.l
      context.l
      tasks.l

## Summary

l-language-essence:
  A pragmatic language balancing formalism and readability.

  key-principles:
    flexibility: choose formal or natural mode as appropriate
    task-orientation: built around work tracking
    polyglotic: embed any language when needed
    evolution: self-improving through use

When to use formal L: clear structure or behavior semantics, configuration or data definitions, function signatures and types, pipeline definitions.

When to use natural L: explanations and documentation, task descriptions and notes, context that benefits from prose, ambiguous or evolving concepts.

The art of L: know when to formalize and when to narrate, use the simplest form that communicates clearly, let semantics emerge from use, evolve conventions as patterns solidify.