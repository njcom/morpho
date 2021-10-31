// Generated from https://github.com/njcom/parser/nftables-parser/blob/main/src/NftablesParser.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link NftablesParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface NftablesParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link NftablesParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(NftablesParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#stmtSeparator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmtSeparator(NftablesParser.StmtSeparatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#optNewline}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOptNewline(NftablesParser.OptNewlineContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#commonBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommonBlock(NftablesParser.CommonBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#line}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLine(NftablesParser.LineContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#baseCmd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBaseCmd(NftablesParser.BaseCmdContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#addCmd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddCmd(NftablesParser.AddCmdContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#replaceCmd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReplaceCmd(NftablesParser.ReplaceCmdContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#createCmd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateCmd(NftablesParser.CreateCmdContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#insertCmd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInsertCmd(NftablesParser.InsertCmdContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#tableOrIdSpec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTableOrIdSpec(NftablesParser.TableOrIdSpecContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#chainOrIdSpec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChainOrIdSpec(NftablesParser.ChainOrIdSpecContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#setOrIdSpec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetOrIdSpec(NftablesParser.SetOrIdSpecContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#objOrIdSpec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjOrIdSpec(NftablesParser.ObjOrIdSpecContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#deleteCmd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeleteCmd(NftablesParser.DeleteCmdContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#getCmd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGetCmd(NftablesParser.GetCmdContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#listCmd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListCmd(NftablesParser.ListCmdContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#basehookDeviceName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBasehookDeviceName(NftablesParser.BasehookDeviceNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#basehookSpec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBasehookSpec(NftablesParser.BasehookSpecContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#resetCmd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitResetCmd(NftablesParser.ResetCmdContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#flushCmd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFlushCmd(NftablesParser.FlushCmdContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#renameCmd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRenameCmd(NftablesParser.RenameCmdContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#importCmd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportCmd(NftablesParser.ImportCmdContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#exportCmd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExportCmd(NftablesParser.ExportCmdContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#monitorCmd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMonitorCmd(NftablesParser.MonitorCmdContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#monitorEvent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMonitorEvent(NftablesParser.MonitorEventContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#monitorObject}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMonitorObject(NftablesParser.MonitorObjectContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#monitorFormat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMonitorFormat(NftablesParser.MonitorFormatContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#markupFormat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMarkupFormat(NftablesParser.MarkupFormatContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#describeCmd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDescribeCmd(NftablesParser.DescribeCmdContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#tableOptions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTableOptions(NftablesParser.TableOptionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#tableBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTableBlock(NftablesParser.TableBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#chainBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChainBlock(NftablesParser.ChainBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#subchainBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubchainBlock(NftablesParser.SubchainBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#typeofDataExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeofDataExpr(NftablesParser.TypeofDataExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#typeofExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeofExpr(NftablesParser.TypeofExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#setBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetBlock(NftablesParser.SetBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#setBlockExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetBlockExpr(NftablesParser.SetBlockExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#setFlagList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetFlagList(NftablesParser.SetFlagListContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#setFlag}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetFlag(NftablesParser.SetFlagContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#mapBlockObjType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMapBlockObjType(NftablesParser.MapBlockObjTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#mapBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMapBlock(NftablesParser.MapBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#setMechanism}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetMechanism(NftablesParser.SetMechanismContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#setPolicySpec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetPolicySpec(NftablesParser.SetPolicySpecContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#flowtableBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFlowtableBlock(NftablesParser.FlowtableBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#flowtableExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFlowtableExpr(NftablesParser.FlowtableExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#flowtableListExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFlowtableListExpr(NftablesParser.FlowtableListExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#flowtableExprMember}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFlowtableExprMember(NftablesParser.FlowtableExprMemberContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#dataTypeAtomExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataTypeAtomExpr(NftablesParser.DataTypeAtomExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#dataTypeExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataTypeExpr(NftablesParser.DataTypeExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#counterBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCounterBlock(NftablesParser.CounterBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#quotaBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuotaBlock(NftablesParser.QuotaBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#ctHelperBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCtHelperBlock(NftablesParser.CtHelperBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#ctTimeoutBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCtTimeoutBlock(NftablesParser.CtTimeoutBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#ctExpectBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCtExpectBlock(NftablesParser.CtExpectBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#limitBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLimitBlock(NftablesParser.LimitBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#secmarkBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSecmarkBlock(NftablesParser.SecmarkBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#synproxyBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSynproxyBlock(NftablesParser.SynproxyBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#typeIdentifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeIdentifier(NftablesParser.TypeIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#hookSpec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHookSpec(NftablesParser.HookSpecContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#prioSpec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrioSpec(NftablesParser.PrioSpecContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#extendedPrioName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExtendedPrioName(NftablesParser.ExtendedPrioNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#extendedPrioSpec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExtendedPrioSpec(NftablesParser.ExtendedPrioSpecContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#intNum}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntNum(NftablesParser.IntNumContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#devSpec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDevSpec(NftablesParser.DevSpecContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#flagsSpec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFlagsSpec(NftablesParser.FlagsSpecContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#policySpec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPolicySpec(NftablesParser.PolicySpecContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#policyExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPolicyExpr(NftablesParser.PolicyExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#chainPolicy}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChainPolicy(NftablesParser.ChainPolicyContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#identifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifier(NftablesParser.IdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#string}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitString(NftablesParser.StringContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#timeSpec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTimeSpec(NftablesParser.TimeSpecContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#familySpec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFamilySpec(NftablesParser.FamilySpecContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#familySpecExplicit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFamilySpecExplicit(NftablesParser.FamilySpecExplicitContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#tableSpec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTableSpec(NftablesParser.TableSpecContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#tableidSpec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTableidSpec(NftablesParser.TableidSpecContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#chainSpec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChainSpec(NftablesParser.ChainSpecContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#chainidSpec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChainidSpec(NftablesParser.ChainidSpecContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#chainIdentifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChainIdentifier(NftablesParser.ChainIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#setSpec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetSpec(NftablesParser.SetSpecContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#setidSpec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetidSpec(NftablesParser.SetidSpecContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#setIdentifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetIdentifier(NftablesParser.SetIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#flowtableSpec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFlowtableSpec(NftablesParser.FlowtableSpecContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#flowtableidSpec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFlowtableidSpec(NftablesParser.FlowtableidSpecContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#flowtableIdentifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFlowtableIdentifier(NftablesParser.FlowtableIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#objSpec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjSpec(NftablesParser.ObjSpecContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#objidSpec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjidSpec(NftablesParser.ObjidSpecContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#objIdentifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjIdentifier(NftablesParser.ObjIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#handleSpec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHandleSpec(NftablesParser.HandleSpecContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#positionSpec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPositionSpec(NftablesParser.PositionSpecContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#indexSpec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexSpec(NftablesParser.IndexSpecContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#rulePosition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRulePosition(NftablesParser.RulePositionContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#ruleidSpec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRuleidSpec(NftablesParser.RuleidSpecContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#commentSpec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommentSpec(NftablesParser.CommentSpecContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#rulesetSpec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRulesetSpec(NftablesParser.RulesetSpecContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#ruleSpec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRuleSpec(NftablesParser.RuleSpecContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#ruleAlloc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRuleAlloc(NftablesParser.RuleAllocContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#stmtList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmtList(NftablesParser.StmtListContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#statefulStmtList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatefulStmtList(NftablesParser.StatefulStmtListContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#statefulStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatefulStmt(NftablesParser.StatefulStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmt(NftablesParser.StmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#chainStmtType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChainStmtType(NftablesParser.ChainStmtTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#chainStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChainStmt(NftablesParser.ChainStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#verdictStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVerdictStmt(NftablesParser.VerdictStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#verdictMapStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVerdictMapStmt(NftablesParser.VerdictMapStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#verdictMapExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVerdictMapExpr(NftablesParser.VerdictMapExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#verdictMapListExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVerdictMapListExpr(NftablesParser.VerdictMapListExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#verdictMapListMemberExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVerdictMapListMemberExpr(NftablesParser.VerdictMapListMemberExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#connlimitStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConnlimitStmt(NftablesParser.ConnlimitStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#counterStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCounterStmt(NftablesParser.CounterStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#counterStmtAlloc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCounterStmtAlloc(NftablesParser.CounterStmtAllocContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#counterArgs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCounterArgs(NftablesParser.CounterArgsContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#counterArg}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCounterArg(NftablesParser.CounterArgContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#logStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogStmt(NftablesParser.LogStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#logStmtAlloc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogStmtAlloc(NftablesParser.LogStmtAllocContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#logArgs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogArgs(NftablesParser.LogArgsContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#logArg}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogArg(NftablesParser.LogArgContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#levelType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLevelType(NftablesParser.LevelTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#logFlags}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogFlags(NftablesParser.LogFlagsContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#logFlagsTcp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogFlagsTcp(NftablesParser.LogFlagsTcpContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#logFlagTcp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogFlagTcp(NftablesParser.LogFlagTcpContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#limitStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLimitStmt(NftablesParser.LimitStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#quotaMode}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuotaMode(NftablesParser.QuotaModeContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#quotaUnit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuotaUnit(NftablesParser.QuotaUnitContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#quotaUsed}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuotaUsed(NftablesParser.QuotaUsedContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#quotaStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuotaStmt(NftablesParser.QuotaStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#limitMode}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLimitMode(NftablesParser.LimitModeContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#limitBurstPkts}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLimitBurstPkts(NftablesParser.LimitBurstPktsContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#limitBurstBytes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLimitBurstBytes(NftablesParser.LimitBurstBytesContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#timeUnit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTimeUnit(NftablesParser.TimeUnitContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#rejectStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRejectStmt(NftablesParser.RejectStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#rejectStmtAlloc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRejectStmtAlloc(NftablesParser.RejectStmtAllocContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#rejectWithExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRejectWithExpr(NftablesParser.RejectWithExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#rejectOpts}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRejectOpts(NftablesParser.RejectOptsContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#natStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNatStmt(NftablesParser.NatStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#natStmtAlloc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNatStmtAlloc(NftablesParser.NatStmtAllocContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#tproxyStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTproxyStmt(NftablesParser.TproxyStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#synproxyStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSynproxyStmt(NftablesParser.SynproxyStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#synproxyStmtAlloc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSynproxyStmtAlloc(NftablesParser.SynproxyStmtAllocContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#synproxyArgs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSynproxyArgs(NftablesParser.SynproxyArgsContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#synproxyArg}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSynproxyArg(NftablesParser.SynproxyArgContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#synproxyConfig}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSynproxyConfig(NftablesParser.SynproxyConfigContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#synproxyTs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSynproxyTs(NftablesParser.SynproxyTsContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#synproxySack}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSynproxySack(NftablesParser.SynproxySackContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#primaryStmtExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryStmtExpr(NftablesParser.PrimaryStmtExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#shiftStmtExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShiftStmtExpr(NftablesParser.ShiftStmtExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#andStmtExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndStmtExpr(NftablesParser.AndStmtExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#exclusiveOrStmtExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExclusiveOrStmtExpr(NftablesParser.ExclusiveOrStmtExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#inclusiveOrStmtExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInclusiveOrStmtExpr(NftablesParser.InclusiveOrStmtExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#basicStmtExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBasicStmtExpr(NftablesParser.BasicStmtExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#concatStmtExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConcatStmtExpr(NftablesParser.ConcatStmtExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#mapStmtExprSet}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMapStmtExprSet(NftablesParser.MapStmtExprSetContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#mapStmtExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMapStmtExpr(NftablesParser.MapStmtExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#prefixStmtExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrefixStmtExpr(NftablesParser.PrefixStmtExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#rangeStmtExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRangeStmtExpr(NftablesParser.RangeStmtExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#multitonStmtExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultitonStmtExpr(NftablesParser.MultitonStmtExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#stmtExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmtExpr(NftablesParser.StmtExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#natStmtArgs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNatStmtArgs(NftablesParser.NatStmtArgsContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#masqStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMasqStmt(NftablesParser.MasqStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#masqStmtAlloc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMasqStmtAlloc(NftablesParser.MasqStmtAllocContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#masqStmtArgs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMasqStmtArgs(NftablesParser.MasqStmtArgsContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#redirStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRedirStmt(NftablesParser.RedirStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#redirStmtAlloc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRedirStmtAlloc(NftablesParser.RedirStmtAllocContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#redirStmtArg}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRedirStmtArg(NftablesParser.RedirStmtArgContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#dupStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDupStmt(NftablesParser.DupStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#fwdStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFwdStmt(NftablesParser.FwdStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#nfNatFlags}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNfNatFlags(NftablesParser.NfNatFlagsContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#nfNatFlag}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNfNatFlag(NftablesParser.NfNatFlagContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#queueStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQueueStmt(NftablesParser.QueueStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#queueStmtCompat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQueueStmtCompat(NftablesParser.QueueStmtCompatContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#queueStmtAlloc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQueueStmtAlloc(NftablesParser.QueueStmtAllocContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#queueStmtArgs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQueueStmtArgs(NftablesParser.QueueStmtArgsContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#queueStmtArg}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQueueStmtArg(NftablesParser.QueueStmtArgContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#queueExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQueueExpr(NftablesParser.QueueExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#queueStmtExprSimple}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQueueStmtExprSimple(NftablesParser.QueueStmtExprSimpleContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#queueStmtExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQueueStmtExpr(NftablesParser.QueueStmtExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#queueStmtFlags}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQueueStmtFlags(NftablesParser.QueueStmtFlagsContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#queueStmtFlag}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQueueStmtFlag(NftablesParser.QueueStmtFlagContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#setElemExprStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetElemExprStmt(NftablesParser.SetElemExprStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#setElemExprStmtAlloc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetElemExprStmtAlloc(NftablesParser.SetElemExprStmtAllocContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#setStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetStmt(NftablesParser.SetStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#setStmtOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetStmtOp(NftablesParser.SetStmtOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#mapStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMapStmt(NftablesParser.MapStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#meterStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMeterStmt(NftablesParser.MeterStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#flowStmtLegacyAlloc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFlowStmtLegacyAlloc(NftablesParser.FlowStmtLegacyAllocContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#flowStmtOpts}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFlowStmtOpts(NftablesParser.FlowStmtOptsContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#flowStmtOpt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFlowStmtOpt(NftablesParser.FlowStmtOptContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#meterStmtAlloc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMeterStmtAlloc(NftablesParser.MeterStmtAllocContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#matchStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMatchStmt(NftablesParser.MatchStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#variableExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableExpr(NftablesParser.VariableExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#symbolExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSymbolExpr(NftablesParser.SymbolExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#setRefExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetRefExpr(NftablesParser.SetRefExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#setRefSymbolExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetRefSymbolExpr(NftablesParser.SetRefSymbolExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#integerExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntegerExpr(NftablesParser.IntegerExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#primaryExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryExpr(NftablesParser.PrimaryExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#fibExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFibExpr(NftablesParser.FibExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#fibResult}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFibResult(NftablesParser.FibResultContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#fibFlag}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFibFlag(NftablesParser.FibFlagContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#fibTuple}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFibTuple(NftablesParser.FibTupleContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#osfExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOsfExpr(NftablesParser.OsfExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#osfTtl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOsfTtl(NftablesParser.OsfTtlContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#shiftExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShiftExpr(NftablesParser.ShiftExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#andExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndExpr(NftablesParser.AndExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#exclusiveOrExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExclusiveOrExpr(NftablesParser.ExclusiveOrExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#inclusiveOrExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInclusiveOrExpr(NftablesParser.InclusiveOrExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#basicExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBasicExpr(NftablesParser.BasicExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#concatExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConcatExpr(NftablesParser.ConcatExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#prefixRhsExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrefixRhsExpr(NftablesParser.PrefixRhsExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#rangeRhsExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRangeRhsExpr(NftablesParser.RangeRhsExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#multitonRhsExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultitonRhsExpr(NftablesParser.MultitonRhsExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#mapExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMapExpr(NftablesParser.MapExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(NftablesParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#setExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetExpr(NftablesParser.SetExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#setListExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetListExpr(NftablesParser.SetListExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#setListMemberExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetListMemberExpr(NftablesParser.SetListMemberExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#meterKeyExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMeterKeyExpr(NftablesParser.MeterKeyExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#meterKeyExprAlloc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMeterKeyExprAlloc(NftablesParser.MeterKeyExprAllocContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#setElemExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetElemExpr(NftablesParser.SetElemExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#setElemKeyExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetElemKeyExpr(NftablesParser.SetElemKeyExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#setElemExprAlloc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetElemExprAlloc(NftablesParser.SetElemExprAllocContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#setElemOptions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetElemOptions(NftablesParser.SetElemOptionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#setElemOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetElemOption(NftablesParser.SetElemOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#setElemExprOptions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetElemExprOptions(NftablesParser.SetElemExprOptionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#setElemStmtList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetElemStmtList(NftablesParser.SetElemStmtListContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#setElemStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetElemStmt(NftablesParser.SetElemStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#setElemExprOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetElemExprOption(NftablesParser.SetElemExprOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#setLhsExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetLhsExpr(NftablesParser.SetLhsExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#setRhsExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetRhsExpr(NftablesParser.SetRhsExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#initializerExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitializerExpr(NftablesParser.InitializerExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#counterConfig}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCounterConfig(NftablesParser.CounterConfigContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#quotaConfig}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuotaConfig(NftablesParser.QuotaConfigContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#secmarkConfig}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSecmarkConfig(NftablesParser.SecmarkConfigContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#ctObjType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCtObjType(NftablesParser.CtObjTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#ctCmdType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCtCmdType(NftablesParser.CtCmdTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#ctL4protoname}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCtL4protoname(NftablesParser.CtL4protonameContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#ctHelperConfig}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCtHelperConfig(NftablesParser.CtHelperConfigContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#timeoutStates}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTimeoutStates(NftablesParser.TimeoutStatesContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#timeoutState}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTimeoutState(NftablesParser.TimeoutStateContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#ctTimeoutConfig}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCtTimeoutConfig(NftablesParser.CtTimeoutConfigContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#ctExpectConfig}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCtExpectConfig(NftablesParser.CtExpectConfigContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#limitConfig}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLimitConfig(NftablesParser.LimitConfigContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#relationalExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelationalExpr(NftablesParser.RelationalExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#listRhsExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListRhsExpr(NftablesParser.ListRhsExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#rhsExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRhsExpr(NftablesParser.RhsExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#shiftRhsExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShiftRhsExpr(NftablesParser.ShiftRhsExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#andRhsExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndRhsExpr(NftablesParser.AndRhsExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#exclusiveOrRhsExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExclusiveOrRhsExpr(NftablesParser.ExclusiveOrRhsExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#inclusiveOrRhsExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInclusiveOrRhsExpr(NftablesParser.InclusiveOrRhsExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#basicRhsExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBasicRhsExpr(NftablesParser.BasicRhsExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#concatRhsExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConcatRhsExpr(NftablesParser.ConcatRhsExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#booleanKeys}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanKeys(NftablesParser.BooleanKeysContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#booleanExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanExpr(NftablesParser.BooleanExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#keywordExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKeywordExpr(NftablesParser.KeywordExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#primaryRhsExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryRhsExpr(NftablesParser.PrimaryRhsExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#relationalOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelationalOp(NftablesParser.RelationalOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#verdictExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVerdictExpr(NftablesParser.VerdictExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#chainExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChainExpr(NftablesParser.ChainExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#metaExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMetaExpr(NftablesParser.MetaExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#metaKey}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMetaKey(NftablesParser.MetaKeyContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#metaKeyQualified}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMetaKeyQualified(NftablesParser.MetaKeyQualifiedContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#metaKeyUnqualified}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMetaKeyUnqualified(NftablesParser.MetaKeyUnqualifiedContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#metaStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMetaStmt(NftablesParser.MetaStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#socketExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSocketExpr(NftablesParser.SocketExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#socketKey}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSocketKey(NftablesParser.SocketKeyContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#offsetOpt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOffsetOpt(NftablesParser.OffsetOptContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#numgenType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumgenType(NftablesParser.NumgenTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#numgenExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumgenExpr(NftablesParser.NumgenExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#xfrmSpnum}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXfrmSpnum(NftablesParser.XfrmSpnumContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#xfrmDir}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXfrmDir(NftablesParser.XfrmDirContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#xfrmStateKey}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXfrmStateKey(NftablesParser.XfrmStateKeyContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#xfrmStateProtoKey}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXfrmStateProtoKey(NftablesParser.XfrmStateProtoKeyContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#xfrmExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXfrmExpr(NftablesParser.XfrmExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#hashExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHashExpr(NftablesParser.HashExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#nfKeyProto}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNfKeyProto(NftablesParser.NfKeyProtoContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#rtExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRtExpr(NftablesParser.RtExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#rtKey}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRtKey(NftablesParser.RtKeyContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#ctExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCtExpr(NftablesParser.CtExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#ctDir}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCtDir(NftablesParser.CtDirContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#ctKey}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCtKey(NftablesParser.CtKeyContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#ctKeyDir}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCtKeyDir(NftablesParser.CtKeyDirContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#ctKeyProtoField}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCtKeyProtoField(NftablesParser.CtKeyProtoFieldContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#ctKeyDirOptional}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCtKeyDirOptional(NftablesParser.CtKeyDirOptionalContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#symbolStmtExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSymbolStmtExpr(NftablesParser.SymbolStmtExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#listStmtExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListStmtExpr(NftablesParser.ListStmtExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#ctStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCtStmt(NftablesParser.CtStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#payloadStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPayloadStmt(NftablesParser.PayloadStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#payloadExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPayloadExpr(NftablesParser.PayloadExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#payloadRawExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPayloadRawExpr(NftablesParser.PayloadRawExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#payloadBaseSpec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPayloadBaseSpec(NftablesParser.PayloadBaseSpecContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#ethHdrExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEthHdrExpr(NftablesParser.EthHdrExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#ethHdrField}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEthHdrField(NftablesParser.EthHdrFieldContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#vlanHdrExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVlanHdrExpr(NftablesParser.VlanHdrExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#vlanHdrField}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVlanHdrField(NftablesParser.VlanHdrFieldContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#arpHdrExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArpHdrExpr(NftablesParser.ArpHdrExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#arpHdrField}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArpHdrField(NftablesParser.ArpHdrFieldContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#ipHdrExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIpHdrExpr(NftablesParser.IpHdrExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#ipHdrField}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIpHdrField(NftablesParser.IpHdrFieldContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#ipOptionType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIpOptionType(NftablesParser.IpOptionTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#ipOptionField}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIpOptionField(NftablesParser.IpOptionFieldContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#icmpHdrExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIcmpHdrExpr(NftablesParser.IcmpHdrExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#icmpHdrField}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIcmpHdrField(NftablesParser.IcmpHdrFieldContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#igmpHdrExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIgmpHdrExpr(NftablesParser.IgmpHdrExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#igmpHdrField}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIgmpHdrField(NftablesParser.IgmpHdrFieldContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#ip6HdrExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIp6HdrExpr(NftablesParser.Ip6HdrExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#ip6HdrField}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIp6HdrField(NftablesParser.Ip6HdrFieldContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#icmp6HdrExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIcmp6HdrExpr(NftablesParser.Icmp6HdrExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#icmp6HdrField}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIcmp6HdrField(NftablesParser.Icmp6HdrFieldContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#authHdrExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAuthHdrExpr(NftablesParser.AuthHdrExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#authHdrField}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAuthHdrField(NftablesParser.AuthHdrFieldContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#espHdrExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEspHdrExpr(NftablesParser.EspHdrExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#espHdrField}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEspHdrField(NftablesParser.EspHdrFieldContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#compHdrExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompHdrExpr(NftablesParser.CompHdrExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#compHdrField}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompHdrField(NftablesParser.CompHdrFieldContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#udpHdrExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUdpHdrExpr(NftablesParser.UdpHdrExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#udpHdrField}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUdpHdrField(NftablesParser.UdpHdrFieldContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#udpliteHdrExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUdpliteHdrExpr(NftablesParser.UdpliteHdrExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#udpliteHdrField}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUdpliteHdrField(NftablesParser.UdpliteHdrFieldContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#tcpHdrExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTcpHdrExpr(NftablesParser.TcpHdrExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#tcpHdrField}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTcpHdrField(NftablesParser.TcpHdrFieldContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#tcpHdrOptionType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTcpHdrOptionType(NftablesParser.TcpHdrOptionTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#tcpHdrOptionField}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTcpHdrOptionField(NftablesParser.TcpHdrOptionFieldContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#dccpHdrExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDccpHdrExpr(NftablesParser.DccpHdrExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#dccpHdrField}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDccpHdrField(NftablesParser.DccpHdrFieldContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#sctpChunkType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSctpChunkType(NftablesParser.SctpChunkTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#sctpChunkCommonField}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSctpChunkCommonField(NftablesParser.SctpChunkCommonFieldContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#sctpChunkDataField}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSctpChunkDataField(NftablesParser.SctpChunkDataFieldContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#sctpChunkInitField}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSctpChunkInitField(NftablesParser.SctpChunkInitFieldContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#sctpChunkSackField}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSctpChunkSackField(NftablesParser.SctpChunkSackFieldContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#sctpChunkAlloc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSctpChunkAlloc(NftablesParser.SctpChunkAllocContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#sctpHdrExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSctpHdrExpr(NftablesParser.SctpHdrExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#sctpHdrField}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSctpHdrField(NftablesParser.SctpHdrFieldContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#thHdrExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitThHdrExpr(NftablesParser.ThHdrExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#thHdrField}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitThHdrField(NftablesParser.ThHdrFieldContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#exthdrExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExthdrExpr(NftablesParser.ExthdrExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#hbhHdrExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHbhHdrExpr(NftablesParser.HbhHdrExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#hbhHdrField}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHbhHdrField(NftablesParser.HbhHdrFieldContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#rtHdrExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRtHdrExpr(NftablesParser.RtHdrExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#rtHdrField}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRtHdrField(NftablesParser.RtHdrFieldContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#rt0HdrExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRt0HdrExpr(NftablesParser.Rt0HdrExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#rt0HdrField}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRt0HdrField(NftablesParser.Rt0HdrFieldContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#rt2HdrExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRt2HdrExpr(NftablesParser.Rt2HdrExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#rt2HdrField}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRt2HdrField(NftablesParser.Rt2HdrFieldContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#rt4HdrExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRt4HdrExpr(NftablesParser.Rt4HdrExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#rt4HdrField}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRt4HdrField(NftablesParser.Rt4HdrFieldContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#fragHdrExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFragHdrExpr(NftablesParser.FragHdrExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#fragHdrField}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFragHdrField(NftablesParser.FragHdrFieldContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#dstHdrExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDstHdrExpr(NftablesParser.DstHdrExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#dstHdrField}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDstHdrField(NftablesParser.DstHdrFieldContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#mhHdrExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMhHdrExpr(NftablesParser.MhHdrExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#mhHdrField}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMhHdrField(NftablesParser.MhHdrFieldContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#exthdrExistsExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExthdrExistsExpr(NftablesParser.ExthdrExistsExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link NftablesParser#exthdrKey}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExthdrKey(NftablesParser.ExthdrKeyContext ctx);
}