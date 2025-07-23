<?php declare(strict_types=1);
/**
 * This file is part of njcom/framework
 * It is distributed under the 'Apache License Version 2.0' license.
 * See the https://github.com/njcom/framework/blob/main/LICENSE for the full license text.
 */
namespace Morpho\Tool\Php;

use PhpParser\Node;
use PhpParser\PrettyPrinter\Standard as BasePrettyPrinter;
use PhpParser\Node\Stmt;

/**
 * Mostly fixes output of braces indentation.
 */
class PrettyPrinter extends BasePrettyPrinter {
    protected function pClassCommon(Stmt\Class_ $node, string $afterClassToken): string {
        return $this->pAttrGroups($node->attrGroups, $node->name === null)
            . $this->pModifiers($node->flags)
            . 'class' . $afterClassToken
            . (null !== $node->extends ? ' extends ' . $this->p($node->extends) : '')
            . (!empty($node->implements) ? ' implements ' . $this->pCommaSeparated($node->implements) : '')
            . ' {' . $this->pStmts($node->stmts, true) . $this->nl . '}';
    }

    protected function pStmt_Trait(Stmt\Trait_ $node): string {
        return $this->pAttrGroups($node->attrGroups)
            . 'trait ' . $node->name
            . ' {' . $this->pStmts($node->stmts) . $this->nl . '}';
    }

    protected function pStmt_Interface(Stmt\Interface_ $node): string {
        return $this->pAttrGroups($node->attrGroups)
            . 'interface ' . $node->name
            . (!empty($node->extends) ? ' extends ' . $this->pCommaSeparated($node->extends) : '')
            . ' {' . $this->pStmts($node->stmts) . $this->nl . '}';
    }

    protected function pStmt_Enum(Stmt\Enum_ $node): string {
        return $this->pAttrGroups($node->attrGroups)
            . 'enum ' . $node->name
            . ($node->scalarType ? ' : ' . $this->p($node->scalarType) : '')
            . (!empty($node->implements) ? ' implements ' . $this->pCommaSeparated($node->implements) : '')
            . ' {' . $this->pStmts($node->stmts) . $this->nl . '}';
    }

    protected function pStmt_ClassMethod(Stmt\ClassMethod $node): string {
        return $this->pAttrGroups($node->attrGroups)
            . $this->pModifiers($node->flags)
            . 'function ' . ($node->byRef ? '&' : '') . $node->name
            . '(' . $this->pMaybeMultiline($node->params, $this->phpVersion->supportsTrailingCommaInParamList()) . ')'
            . (null !== $node->returnType ? ': ' . $this->p($node->returnType) : '')
            . (null !== $node->stmts
                ? ' {' . $this->pStmts($node->stmts) . $this->nl . '}'
                : ';');
    }

    protected function pStmt_Function(Stmt\Function_ $node): string {
        return $this->pAttrGroups($node->attrGroups)
            . 'function ' . ($node->byRef ? '&' : '') . $node->name
            . '(' . $this->pMaybeMultiline($node->params, $this->phpVersion->supportsTrailingCommaInParamList()) . ')'
            . (null !== $node->returnType ? ': ' . $this->p($node->returnType) : '')
            . ' {' . $this->pStmts($node->stmts) . $this->nl . '}';
    }

    /**
     * Pretty prints a file of statements (includes the opening <?php tag if it is required).
     *
     * @param Node[] $stmts Array of statements
     *
     * @return string Pretty printed statements
     */
    public function prettyPrintFile(array $stmts, bool $strictTypes = true): string {
        $strictSmtp = $strictTypes ? ' declare(strict_types=1);' : '';
        if (!$stmts) {
            return "<?php$strictSmtp" . $this->newline;
        }

        $p = "<?php$strictSmtp" . $this->newline . $this->prettyPrint($stmts);

        if ($stmts[0] instanceof Stmt\InlineHTML) {
            $p = preg_replace('/^<\?php\s+\?>\r?\n?/', '', $p);
        }
        if ($stmts[count($stmts) - 1] instanceof Stmt\InlineHTML) {
            $p = preg_replace('/<\?php$/', '', rtrim($p));
        }

        return $p;
    }
}