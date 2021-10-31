// Generated from https://github.com/njcom/parser/make-parser/blob/main/src/MakeParser.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MakeParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MakeParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link MakeParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(MakeParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link MakeParser#stmts}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmts(MakeParser.StmtsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MakeParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmt(MakeParser.StmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link MakeParser#var}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar(MakeParser.VarContext ctx);
	/**
	 * Visit a parse tree produced by {@link MakeParser#varDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDef(MakeParser.VarDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link MakeParser#varRef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarRef(MakeParser.VarRefContext ctx);
	/**
	 * Visit a parse tree produced by {@link MakeParser#directive}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDirective(MakeParser.DirectiveContext ctx);
	/**
	 * Visit a parse tree produced by {@link MakeParser#conditionalDirective}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionalDirective(MakeParser.ConditionalDirectiveContext ctx);
	/**
	 * Visit a parse tree produced by {@link MakeParser#otherDirective}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOtherDirective(MakeParser.OtherDirectiveContext ctx);
	/**
	 * Visit a parse tree produced by {@link MakeParser#ifDefCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfDefCondition(MakeParser.IfDefConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MakeParser#ifNdefCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfNdefCondition(MakeParser.IfNdefConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MakeParser#ifEqCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfEqCondition(MakeParser.IfEqConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MakeParser#quotedVarRef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuotedVarRef(MakeParser.QuotedVarRefContext ctx);
	/**
	 * Visit a parse tree produced by {@link MakeParser#squotedVarRef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSquotedVarRef(MakeParser.SquotedVarRefContext ctx);
	/**
	 * Visit a parse tree produced by {@link MakeParser#dquotedVarRef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDquotedVarRef(MakeParser.DquotedVarRefContext ctx);
	/**
	 * Visit a parse tree produced by {@link MakeParser#ifNeqCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfNeqCondition(MakeParser.IfNeqConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MakeParser#elseClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseClause(MakeParser.ElseClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link MakeParser#varName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarName(MakeParser.VarNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link MakeParser#exportDirective}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExportDirective(MakeParser.ExportDirectiveContext ctx);
	/**
	 * Visit a parse tree produced by {@link MakeParser#unexportDirective}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnexportDirective(MakeParser.UnexportDirectiveContext ctx);
	/**
	 * Visit a parse tree produced by {@link MakeParser#vpathDirective}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVpathDirective(MakeParser.VpathDirectiveContext ctx);
	/**
	 * Visit a parse tree produced by {@link MakeParser#includeDirective}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIncludeDirective(MakeParser.IncludeDirectiveContext ctx);
	/**
	 * Visit a parse tree produced by {@link MakeParser#mincludeDirective}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMincludeDirective(MakeParser.MincludeDirectiveContext ctx);
	/**
	 * Visit a parse tree produced by {@link MakeParser#sincludeDirective}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSincludeDirective(MakeParser.SincludeDirectiveContext ctx);
	/**
	 * Visit a parse tree produced by {@link MakeParser#loadDirective}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoadDirective(MakeParser.LoadDirectiveContext ctx);
	/**
	 * Visit a parse tree produced by {@link MakeParser#mloadDirective}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMloadDirective(MakeParser.MloadDirectiveContext ctx);
	/**
	 * Visit a parse tree produced by {@link MakeParser#defineDirective}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefineDirective(MakeParser.DefineDirectiveContext ctx);
	/**
	 * Visit a parse tree produced by {@link MakeParser#undefineDirective}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUndefineDirective(MakeParser.UndefineDirectiveContext ctx);
	/**
	 * Visit a parse tree produced by {@link MakeParser#overrideDirective}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOverrideDirective(MakeParser.OverrideDirectiveContext ctx);
	/**
	 * Visit a parse tree produced by {@link MakeParser#privateDirective}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrivateDirective(MakeParser.PrivateDirectiveContext ctx);
	/**
	 * Visit a parse tree produced by {@link MakeParser#ruleDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRuleDef(MakeParser.RuleDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link MakeParser#prerequisite}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrerequisite(MakeParser.PrerequisiteContext ctx);
	/**
	 * Visit a parse tree produced by {@link MakeParser#targetRef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTargetRef(MakeParser.TargetRefContext ctx);
	/**
	 * Visit a parse tree produced by {@link MakeParser#shellCmd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShellCmd(MakeParser.ShellCmdContext ctx);
}