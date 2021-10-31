// Generated from https://github.com/njcom/parser/make-parser/blob/main/src/MakeParser.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MakeParser}.
 */
public interface MakeParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MakeParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(MakeParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link MakeParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(MakeParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link MakeParser#stmts}.
	 * @param ctx the parse tree
	 */
	void enterStmts(MakeParser.StmtsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MakeParser#stmts}.
	 * @param ctx the parse tree
	 */
	void exitStmts(MakeParser.StmtsContext ctx);
	/**
	 * Enter a parse tree produced by {@link MakeParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterStmt(MakeParser.StmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MakeParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitStmt(MakeParser.StmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MakeParser#varDef}.
	 * @param ctx the parse tree
	 */
	void enterVarDef(MakeParser.VarDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link MakeParser#varDef}.
	 * @param ctx the parse tree
	 */
	void exitVarDef(MakeParser.VarDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link MakeParser#varRef}.
	 * @param ctx the parse tree
	 */
	void enterVarRef(MakeParser.VarRefContext ctx);
	/**
	 * Exit a parse tree produced by {@link MakeParser#varRef}.
	 * @param ctx the parse tree
	 */
	void exitVarRef(MakeParser.VarRefContext ctx);
	/**
	 * Enter a parse tree produced by {@link MakeParser#varRefText}.
	 * @param ctx the parse tree
	 */
	void enterVarRefText(MakeParser.VarRefTextContext ctx);
	/**
	 * Exit a parse tree produced by {@link MakeParser#varRefText}.
	 * @param ctx the parse tree
	 */
	void exitVarRefText(MakeParser.VarRefTextContext ctx);
	/**
	 * Enter a parse tree produced by {@link MakeParser#directiveCall}.
	 * @param ctx the parse tree
	 */
	void enterDirectiveCall(MakeParser.DirectiveCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link MakeParser#directiveCall}.
	 * @param ctx the parse tree
	 */
	void exitDirectiveCall(MakeParser.DirectiveCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link MakeParser#conditionalDirectiveCall}.
	 * @param ctx the parse tree
	 */
	void enterConditionalDirectiveCall(MakeParser.ConditionalDirectiveCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link MakeParser#conditionalDirectiveCall}.
	 * @param ctx the parse tree
	 */
	void exitConditionalDirectiveCall(MakeParser.ConditionalDirectiveCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link MakeParser#ifCondition}.
	 * @param ctx the parse tree
	 */
	void enterIfCondition(MakeParser.IfConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MakeParser#ifCondition}.
	 * @param ctx the parse tree
	 */
	void exitIfCondition(MakeParser.IfConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MakeParser#otherDirectiveCall}.
	 * @param ctx the parse tree
	 */
	void enterOtherDirectiveCall(MakeParser.OtherDirectiveCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link MakeParser#otherDirectiveCall}.
	 * @param ctx the parse tree
	 */
	void exitOtherDirectiveCall(MakeParser.OtherDirectiveCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link MakeParser#ifDefCondition}.
	 * @param ctx the parse tree
	 */
	void enterIfDefCondition(MakeParser.IfDefConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MakeParser#ifDefCondition}.
	 * @param ctx the parse tree
	 */
	void exitIfDefCondition(MakeParser.IfDefConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MakeParser#ifNdefCondition}.
	 * @param ctx the parse tree
	 */
	void enterIfNdefCondition(MakeParser.IfNdefConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MakeParser#ifNdefCondition}.
	 * @param ctx the parse tree
	 */
	void exitIfNdefCondition(MakeParser.IfNdefConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MakeParser#ifEqCondition}.
	 * @param ctx the parse tree
	 */
	void enterIfEqCondition(MakeParser.IfEqConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MakeParser#ifEqCondition}.
	 * @param ctx the parse tree
	 */
	void exitIfEqCondition(MakeParser.IfEqConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MakeParser#quotedVarRef}.
	 * @param ctx the parse tree
	 */
	void enterQuotedVarRef(MakeParser.QuotedVarRefContext ctx);
	/**
	 * Exit a parse tree produced by {@link MakeParser#quotedVarRef}.
	 * @param ctx the parse tree
	 */
	void exitQuotedVarRef(MakeParser.QuotedVarRefContext ctx);
	/**
	 * Enter a parse tree produced by {@link MakeParser#squotedVarRef}.
	 * @param ctx the parse tree
	 */
	void enterSquotedVarRef(MakeParser.SquotedVarRefContext ctx);
	/**
	 * Exit a parse tree produced by {@link MakeParser#squotedVarRef}.
	 * @param ctx the parse tree
	 */
	void exitSquotedVarRef(MakeParser.SquotedVarRefContext ctx);
	/**
	 * Enter a parse tree produced by {@link MakeParser#dquotedVarRef}.
	 * @param ctx the parse tree
	 */
	void enterDquotedVarRef(MakeParser.DquotedVarRefContext ctx);
	/**
	 * Exit a parse tree produced by {@link MakeParser#dquotedVarRef}.
	 * @param ctx the parse tree
	 */
	void exitDquotedVarRef(MakeParser.DquotedVarRefContext ctx);
	/**
	 * Enter a parse tree produced by {@link MakeParser#ifNeqCondition}.
	 * @param ctx the parse tree
	 */
	void enterIfNeqCondition(MakeParser.IfNeqConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MakeParser#ifNeqCondition}.
	 * @param ctx the parse tree
	 */
	void exitIfNeqCondition(MakeParser.IfNeqConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MakeParser#elseClause}.
	 * @param ctx the parse tree
	 */
	void enterElseClause(MakeParser.ElseClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link MakeParser#elseClause}.
	 * @param ctx the parse tree
	 */
	void exitElseClause(MakeParser.ElseClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link MakeParser#varName}.
	 * @param ctx the parse tree
	 */
	void enterVarName(MakeParser.VarNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link MakeParser#varName}.
	 * @param ctx the parse tree
	 */
	void exitVarName(MakeParser.VarNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link MakeParser#exportDirectiveCall}.
	 * @param ctx the parse tree
	 */
	void enterExportDirectiveCall(MakeParser.ExportDirectiveCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link MakeParser#exportDirectiveCall}.
	 * @param ctx the parse tree
	 */
	void exitExportDirectiveCall(MakeParser.ExportDirectiveCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link MakeParser#unexportDirectiveCall}.
	 * @param ctx the parse tree
	 */
	void enterUnexportDirectiveCall(MakeParser.UnexportDirectiveCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link MakeParser#unexportDirectiveCall}.
	 * @param ctx the parse tree
	 */
	void exitUnexportDirectiveCall(MakeParser.UnexportDirectiveCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link MakeParser#vpathDirectiveCall}.
	 * @param ctx the parse tree
	 */
	void enterVpathDirectiveCall(MakeParser.VpathDirectiveCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link MakeParser#vpathDirectiveCall}.
	 * @param ctx the parse tree
	 */
	void exitVpathDirectiveCall(MakeParser.VpathDirectiveCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link MakeParser#includeDirectiveCall}.
	 * @param ctx the parse tree
	 */
	void enterIncludeDirectiveCall(MakeParser.IncludeDirectiveCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link MakeParser#includeDirectiveCall}.
	 * @param ctx the parse tree
	 */
	void exitIncludeDirectiveCall(MakeParser.IncludeDirectiveCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link MakeParser#mincludeDirectiveCall}.
	 * @param ctx the parse tree
	 */
	void enterMincludeDirectiveCall(MakeParser.MincludeDirectiveCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link MakeParser#mincludeDirectiveCall}.
	 * @param ctx the parse tree
	 */
	void exitMincludeDirectiveCall(MakeParser.MincludeDirectiveCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link MakeParser#sincludeDirectiveCall}.
	 * @param ctx the parse tree
	 */
	void enterSincludeDirectiveCall(MakeParser.SincludeDirectiveCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link MakeParser#sincludeDirectiveCall}.
	 * @param ctx the parse tree
	 */
	void exitSincludeDirectiveCall(MakeParser.SincludeDirectiveCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link MakeParser#loadDirectiveCall}.
	 * @param ctx the parse tree
	 */
	void enterLoadDirectiveCall(MakeParser.LoadDirectiveCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link MakeParser#loadDirectiveCall}.
	 * @param ctx the parse tree
	 */
	void exitLoadDirectiveCall(MakeParser.LoadDirectiveCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link MakeParser#mloadDirectiveCall}.
	 * @param ctx the parse tree
	 */
	void enterMloadDirectiveCall(MakeParser.MloadDirectiveCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link MakeParser#mloadDirectiveCall}.
	 * @param ctx the parse tree
	 */
	void exitMloadDirectiveCall(MakeParser.MloadDirectiveCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link MakeParser#defineDirectiveCall}.
	 * @param ctx the parse tree
	 */
	void enterDefineDirectiveCall(MakeParser.DefineDirectiveCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link MakeParser#defineDirectiveCall}.
	 * @param ctx the parse tree
	 */
	void exitDefineDirectiveCall(MakeParser.DefineDirectiveCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link MakeParser#undefineDirectiveCall}.
	 * @param ctx the parse tree
	 */
	void enterUndefineDirectiveCall(MakeParser.UndefineDirectiveCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link MakeParser#undefineDirectiveCall}.
	 * @param ctx the parse tree
	 */
	void exitUndefineDirectiveCall(MakeParser.UndefineDirectiveCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link MakeParser#overrideDirectiveCall}.
	 * @param ctx the parse tree
	 */
	void enterOverrideDirectiveCall(MakeParser.OverrideDirectiveCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link MakeParser#overrideDirectiveCall}.
	 * @param ctx the parse tree
	 */
	void exitOverrideDirectiveCall(MakeParser.OverrideDirectiveCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link MakeParser#privateDirectiveCall}.
	 * @param ctx the parse tree
	 */
	void enterPrivateDirectiveCall(MakeParser.PrivateDirectiveCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link MakeParser#privateDirectiveCall}.
	 * @param ctx the parse tree
	 */
	void exitPrivateDirectiveCall(MakeParser.PrivateDirectiveCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link MakeParser#ruleDef}.
	 * @param ctx the parse tree
	 */
	void enterRuleDef(MakeParser.RuleDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link MakeParser#ruleDef}.
	 * @param ctx the parse tree
	 */
	void exitRuleDef(MakeParser.RuleDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link MakeParser#prerequisite}.
	 * @param ctx the parse tree
	 */
	void enterPrerequisite(MakeParser.PrerequisiteContext ctx);
	/**
	 * Exit a parse tree produced by {@link MakeParser#prerequisite}.
	 * @param ctx the parse tree
	 */
	void exitPrerequisite(MakeParser.PrerequisiteContext ctx);
	/**
	 * Enter a parse tree produced by {@link MakeParser#targetRef}.
	 * @param ctx the parse tree
	 */
	void enterTargetRef(MakeParser.TargetRefContext ctx);
	/**
	 * Exit a parse tree produced by {@link MakeParser#targetRef}.
	 * @param ctx the parse tree
	 */
	void exitTargetRef(MakeParser.TargetRefContext ctx);
	/**
	 * Enter a parse tree produced by {@link MakeParser#shellCmd}.
	 * @param ctx the parse tree
	 */
	void enterShellCmd(MakeParser.ShellCmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link MakeParser#shellCmd}.
	 * @param ctx the parse tree
	 */
	void exitShellCmd(MakeParser.ShellCmdContext ctx);
}