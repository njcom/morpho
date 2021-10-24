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
	 * Enter a parse tree produced by {@link MakeParser#var}.
	 * @param ctx the parse tree
	 */
	void enterVar(MakeParser.VarContext ctx);
	/**
	 * Exit a parse tree produced by {@link MakeParser#var}.
	 * @param ctx the parse tree
	 */
	void exitVar(MakeParser.VarContext ctx);
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
	 * Enter a parse tree produced by {@link MakeParser#directive}.
	 * @param ctx the parse tree
	 */
	void enterDirective(MakeParser.DirectiveContext ctx);
	/**
	 * Exit a parse tree produced by {@link MakeParser#directive}.
	 * @param ctx the parse tree
	 */
	void exitDirective(MakeParser.DirectiveContext ctx);
	/**
	 * Enter a parse tree produced by {@link MakeParser#conditionalDirective}.
	 * @param ctx the parse tree
	 */
	void enterConditionalDirective(MakeParser.ConditionalDirectiveContext ctx);
	/**
	 * Exit a parse tree produced by {@link MakeParser#conditionalDirective}.
	 * @param ctx the parse tree
	 */
	void exitConditionalDirective(MakeParser.ConditionalDirectiveContext ctx);
	/**
	 * Enter a parse tree produced by {@link MakeParser#otherDirective}.
	 * @param ctx the parse tree
	 */
	void enterOtherDirective(MakeParser.OtherDirectiveContext ctx);
	/**
	 * Exit a parse tree produced by {@link MakeParser#otherDirective}.
	 * @param ctx the parse tree
	 */
	void exitOtherDirective(MakeParser.OtherDirectiveContext ctx);
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
	 * Enter a parse tree produced by {@link MakeParser#exportDirective}.
	 * @param ctx the parse tree
	 */
	void enterExportDirective(MakeParser.ExportDirectiveContext ctx);
	/**
	 * Exit a parse tree produced by {@link MakeParser#exportDirective}.
	 * @param ctx the parse tree
	 */
	void exitExportDirective(MakeParser.ExportDirectiveContext ctx);
	/**
	 * Enter a parse tree produced by {@link MakeParser#unexportDirective}.
	 * @param ctx the parse tree
	 */
	void enterUnexportDirective(MakeParser.UnexportDirectiveContext ctx);
	/**
	 * Exit a parse tree produced by {@link MakeParser#unexportDirective}.
	 * @param ctx the parse tree
	 */
	void exitUnexportDirective(MakeParser.UnexportDirectiveContext ctx);
	/**
	 * Enter a parse tree produced by {@link MakeParser#vpathDirective}.
	 * @param ctx the parse tree
	 */
	void enterVpathDirective(MakeParser.VpathDirectiveContext ctx);
	/**
	 * Exit a parse tree produced by {@link MakeParser#vpathDirective}.
	 * @param ctx the parse tree
	 */
	void exitVpathDirective(MakeParser.VpathDirectiveContext ctx);
	/**
	 * Enter a parse tree produced by {@link MakeParser#includeDirective}.
	 * @param ctx the parse tree
	 */
	void enterIncludeDirective(MakeParser.IncludeDirectiveContext ctx);
	/**
	 * Exit a parse tree produced by {@link MakeParser#includeDirective}.
	 * @param ctx the parse tree
	 */
	void exitIncludeDirective(MakeParser.IncludeDirectiveContext ctx);
	/**
	 * Enter a parse tree produced by {@link MakeParser#mincludeDirective}.
	 * @param ctx the parse tree
	 */
	void enterMincludeDirective(MakeParser.MincludeDirectiveContext ctx);
	/**
	 * Exit a parse tree produced by {@link MakeParser#mincludeDirective}.
	 * @param ctx the parse tree
	 */
	void exitMincludeDirective(MakeParser.MincludeDirectiveContext ctx);
	/**
	 * Enter a parse tree produced by {@link MakeParser#sincludeDirective}.
	 * @param ctx the parse tree
	 */
	void enterSincludeDirective(MakeParser.SincludeDirectiveContext ctx);
	/**
	 * Exit a parse tree produced by {@link MakeParser#sincludeDirective}.
	 * @param ctx the parse tree
	 */
	void exitSincludeDirective(MakeParser.SincludeDirectiveContext ctx);
	/**
	 * Enter a parse tree produced by {@link MakeParser#loadDirective}.
	 * @param ctx the parse tree
	 */
	void enterLoadDirective(MakeParser.LoadDirectiveContext ctx);
	/**
	 * Exit a parse tree produced by {@link MakeParser#loadDirective}.
	 * @param ctx the parse tree
	 */
	void exitLoadDirective(MakeParser.LoadDirectiveContext ctx);
	/**
	 * Enter a parse tree produced by {@link MakeParser#mloadDirective}.
	 * @param ctx the parse tree
	 */
	void enterMloadDirective(MakeParser.MloadDirectiveContext ctx);
	/**
	 * Exit a parse tree produced by {@link MakeParser#mloadDirective}.
	 * @param ctx the parse tree
	 */
	void exitMloadDirective(MakeParser.MloadDirectiveContext ctx);
	/**
	 * Enter a parse tree produced by {@link MakeParser#defineDirective}.
	 * @param ctx the parse tree
	 */
	void enterDefineDirective(MakeParser.DefineDirectiveContext ctx);
	/**
	 * Exit a parse tree produced by {@link MakeParser#defineDirective}.
	 * @param ctx the parse tree
	 */
	void exitDefineDirective(MakeParser.DefineDirectiveContext ctx);
	/**
	 * Enter a parse tree produced by {@link MakeParser#undefineDirective}.
	 * @param ctx the parse tree
	 */
	void enterUndefineDirective(MakeParser.UndefineDirectiveContext ctx);
	/**
	 * Exit a parse tree produced by {@link MakeParser#undefineDirective}.
	 * @param ctx the parse tree
	 */
	void exitUndefineDirective(MakeParser.UndefineDirectiveContext ctx);
	/**
	 * Enter a parse tree produced by {@link MakeParser#overrideDirective}.
	 * @param ctx the parse tree
	 */
	void enterOverrideDirective(MakeParser.OverrideDirectiveContext ctx);
	/**
	 * Exit a parse tree produced by {@link MakeParser#overrideDirective}.
	 * @param ctx the parse tree
	 */
	void exitOverrideDirective(MakeParser.OverrideDirectiveContext ctx);
	/**
	 * Enter a parse tree produced by {@link MakeParser#privateDirective}.
	 * @param ctx the parse tree
	 */
	void enterPrivateDirective(MakeParser.PrivateDirectiveContext ctx);
	/**
	 * Exit a parse tree produced by {@link MakeParser#privateDirective}.
	 * @param ctx the parse tree
	 */
	void exitPrivateDirective(MakeParser.PrivateDirectiveContext ctx);
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