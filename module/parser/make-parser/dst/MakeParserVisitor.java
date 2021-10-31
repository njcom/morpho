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
	 * Visit a parse tree produced by {@link MakeParser#varRefText}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarRefText(MakeParser.VarRefTextContext ctx);
	/**
	 * Visit a parse tree produced by {@link MakeParser#directiveCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDirectiveCall(MakeParser.DirectiveCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link MakeParser#conditionalDirectiveCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionalDirectiveCall(MakeParser.ConditionalDirectiveCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link MakeParser#ifCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfCondition(MakeParser.IfConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MakeParser#otherDirectiveCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOtherDirectiveCall(MakeParser.OtherDirectiveCallContext ctx);
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
	 * Visit a parse tree produced by {@link MakeParser#exportDirectiveCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExportDirectiveCall(MakeParser.ExportDirectiveCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link MakeParser#unexportDirectiveCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnexportDirectiveCall(MakeParser.UnexportDirectiveCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link MakeParser#vpathDirectiveCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVpathDirectiveCall(MakeParser.VpathDirectiveCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link MakeParser#includeDirectiveCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIncludeDirectiveCall(MakeParser.IncludeDirectiveCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link MakeParser#mincludeDirectiveCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMincludeDirectiveCall(MakeParser.MincludeDirectiveCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link MakeParser#sincludeDirectiveCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSincludeDirectiveCall(MakeParser.SincludeDirectiveCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link MakeParser#loadDirectiveCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoadDirectiveCall(MakeParser.LoadDirectiveCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link MakeParser#mloadDirectiveCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMloadDirectiveCall(MakeParser.MloadDirectiveCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link MakeParser#defineDirectiveCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefineDirectiveCall(MakeParser.DefineDirectiveCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link MakeParser#undefineDirectiveCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUndefineDirectiveCall(MakeParser.UndefineDirectiveCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link MakeParser#overrideDirectiveCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOverrideDirectiveCall(MakeParser.OverrideDirectiveCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link MakeParser#privateDirectiveCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrivateDirectiveCall(MakeParser.PrivateDirectiveCallContext ctx);
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