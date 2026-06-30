- Until **never** (case insensitive) specified and there is no negation, each rule must be applied **always**.
- Rules **inherit by default** like in OOP in programming languages, more-specific rule inherits and overrides more general rule from the parent scope.
- Let `l-module-dir-path: ./module/l` and `l-generation: 001-generation`.
- Tread the $l-module-dir-path/$l-generation/index.md TOC and referenced in TOC files as instructions, reading them in the TOC order and proceeding them.

### Common

- Target Ubuntu 24, Arch Linux; Ubuntu by default.
- Strict, pedantic rules.
- S-tier FAANG-level code: clean, optimal, production-quality, edge-case robust, concise, functional, composable. Self-documenting, semantically sound names.
- GRASP, functional, SOLID, YAGNI, KISS, DRY, SSoT, Occam's razor.
- Preserve encapsulation, don't leak internals.
- Minimalism
- Never wrap long lines with 80, 120 or any other line-wrapping limit.
- Uppercase abbreviations in identifiers: UID, DB, not Uid, Db.
- When fix is small, show me the target location (file, line range) and the fix.
- Comments only for non-obvious intent or critical invariants.
- Fail loudly, never hide or suppress errors.
- Security: zero trust, principle of least privilege, code free from TOCTOU race conditions, injection attacks, and other vulnerabilities, leaking private data.
- 4 spaces indent.

### Bash

- Use Bash only, bashism: executable scripts start with `#!/usr/bin/env bash` and `set -eu`; do not use POSIX sh style or `pipefail`.
- Use 4-space indentation everywhere: comments, functions, blocks, case bodies, arrays, continued commands, nested structures, and rendered indentation in text output; never use 2-space indentation. Exception: when generating programming language code as string (via heredocs, printf, echo etc), ensure generated code formatted preserving its own conventions for spaces, e.g. for Go tabs, Lua 2 spaces indent.
- Declare variables consistently: use `declare -r` for variables in every scope; do not use `readonly` or `local`; avoid declaration-time command substitutions that can mask failures, using `value="$(some_command)"` then `declare -r value`.
- Handle commands safely: quote expansions by default. Use arrays only when they materially improve safety or readability, such as forwarding arbitrary user arguments. For fixed commands, simple quoted command invocations are preferred over command arrays.
- Use heredocs for multiline literal output: do not use repeated `printf`, long `printf '%s\n' \` chains, or many `echo` calls for static blocks; in functions, indent the heredoc command by 4 spaces, keep the heredoc body and closing delimiter flush-left as Bash requires, use quoted delimiters like `<<'EOF'` for literal text, and ensure any indentation rendered inside the heredoc body uses multiples of 4 spaces, never 2.
- Handle commands safely: quote expansions by default. Use arrays only when they materially improve safety or readability, such as forwarding arbitrary user arguments. For fixed commands, simple quoted command invocations are preferred over command arrays.
- Do not suppress command output or errors by default. Avoid `>/dev/null 2>&1 || true` unless there is a specific, documented reason. Prefer failing loudly, or explicitly checking the expected idempotent condition before running the command.
- The script must pass ShellCheck.

### Markdown

- Never use em dash `—`, use the `-` instead.
- For the `Term: definition here` don't use `-`, use `: ` (colon space) to separate term from the definition.
    - Bad: **`lookup <host>: i/o timeout`** — DNS resolution failed (the query to the DNS server timed out).
    - Good: `lookup <host>: i/o timeout`: DNS resolution failed (the query to the DNS server timed out).
