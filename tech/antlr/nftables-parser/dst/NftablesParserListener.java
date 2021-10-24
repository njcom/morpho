// Generated from https://github.com/njcom/parser/nftables-parser/blob/main/src/NftablesParser.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link NftablesParser}.
 */
public interface NftablesParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link NftablesParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(NftablesParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(NftablesParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#stmtSeparator}.
	 * @param ctx the parse tree
	 */
	void enterStmtSeparator(NftablesParser.StmtSeparatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#stmtSeparator}.
	 * @param ctx the parse tree
	 */
	void exitStmtSeparator(NftablesParser.StmtSeparatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#optNewline}.
	 * @param ctx the parse tree
	 */
	void enterOptNewline(NftablesParser.OptNewlineContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#optNewline}.
	 * @param ctx the parse tree
	 */
	void exitOptNewline(NftablesParser.OptNewlineContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#commonBlock}.
	 * @param ctx the parse tree
	 */
	void enterCommonBlock(NftablesParser.CommonBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#commonBlock}.
	 * @param ctx the parse tree
	 */
	void exitCommonBlock(NftablesParser.CommonBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#line}.
	 * @param ctx the parse tree
	 */
	void enterLine(NftablesParser.LineContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#line}.
	 * @param ctx the parse tree
	 */
	void exitLine(NftablesParser.LineContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#baseCmd}.
	 * @param ctx the parse tree
	 */
	void enterBaseCmd(NftablesParser.BaseCmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#baseCmd}.
	 * @param ctx the parse tree
	 */
	void exitBaseCmd(NftablesParser.BaseCmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#addCmd}.
	 * @param ctx the parse tree
	 */
	void enterAddCmd(NftablesParser.AddCmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#addCmd}.
	 * @param ctx the parse tree
	 */
	void exitAddCmd(NftablesParser.AddCmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#replaceCmd}.
	 * @param ctx the parse tree
	 */
	void enterReplaceCmd(NftablesParser.ReplaceCmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#replaceCmd}.
	 * @param ctx the parse tree
	 */
	void exitReplaceCmd(NftablesParser.ReplaceCmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#createCmd}.
	 * @param ctx the parse tree
	 */
	void enterCreateCmd(NftablesParser.CreateCmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#createCmd}.
	 * @param ctx the parse tree
	 */
	void exitCreateCmd(NftablesParser.CreateCmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#insertCmd}.
	 * @param ctx the parse tree
	 */
	void enterInsertCmd(NftablesParser.InsertCmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#insertCmd}.
	 * @param ctx the parse tree
	 */
	void exitInsertCmd(NftablesParser.InsertCmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#tableOrIdSpec}.
	 * @param ctx the parse tree
	 */
	void enterTableOrIdSpec(NftablesParser.TableOrIdSpecContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#tableOrIdSpec}.
	 * @param ctx the parse tree
	 */
	void exitTableOrIdSpec(NftablesParser.TableOrIdSpecContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#chainOrIdSpec}.
	 * @param ctx the parse tree
	 */
	void enterChainOrIdSpec(NftablesParser.ChainOrIdSpecContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#chainOrIdSpec}.
	 * @param ctx the parse tree
	 */
	void exitChainOrIdSpec(NftablesParser.ChainOrIdSpecContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#setOrIdSpec}.
	 * @param ctx the parse tree
	 */
	void enterSetOrIdSpec(NftablesParser.SetOrIdSpecContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#setOrIdSpec}.
	 * @param ctx the parse tree
	 */
	void exitSetOrIdSpec(NftablesParser.SetOrIdSpecContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#objOrIdSpec}.
	 * @param ctx the parse tree
	 */
	void enterObjOrIdSpec(NftablesParser.ObjOrIdSpecContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#objOrIdSpec}.
	 * @param ctx the parse tree
	 */
	void exitObjOrIdSpec(NftablesParser.ObjOrIdSpecContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#deleteCmd}.
	 * @param ctx the parse tree
	 */
	void enterDeleteCmd(NftablesParser.DeleteCmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#deleteCmd}.
	 * @param ctx the parse tree
	 */
	void exitDeleteCmd(NftablesParser.DeleteCmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#getCmd}.
	 * @param ctx the parse tree
	 */
	void enterGetCmd(NftablesParser.GetCmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#getCmd}.
	 * @param ctx the parse tree
	 */
	void exitGetCmd(NftablesParser.GetCmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#listCmd}.
	 * @param ctx the parse tree
	 */
	void enterListCmd(NftablesParser.ListCmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#listCmd}.
	 * @param ctx the parse tree
	 */
	void exitListCmd(NftablesParser.ListCmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#basehookDeviceName}.
	 * @param ctx the parse tree
	 */
	void enterBasehookDeviceName(NftablesParser.BasehookDeviceNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#basehookDeviceName}.
	 * @param ctx the parse tree
	 */
	void exitBasehookDeviceName(NftablesParser.BasehookDeviceNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#basehookSpec}.
	 * @param ctx the parse tree
	 */
	void enterBasehookSpec(NftablesParser.BasehookSpecContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#basehookSpec}.
	 * @param ctx the parse tree
	 */
	void exitBasehookSpec(NftablesParser.BasehookSpecContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#resetCmd}.
	 * @param ctx the parse tree
	 */
	void enterResetCmd(NftablesParser.ResetCmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#resetCmd}.
	 * @param ctx the parse tree
	 */
	void exitResetCmd(NftablesParser.ResetCmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#flushCmd}.
	 * @param ctx the parse tree
	 */
	void enterFlushCmd(NftablesParser.FlushCmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#flushCmd}.
	 * @param ctx the parse tree
	 */
	void exitFlushCmd(NftablesParser.FlushCmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#renameCmd}.
	 * @param ctx the parse tree
	 */
	void enterRenameCmd(NftablesParser.RenameCmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#renameCmd}.
	 * @param ctx the parse tree
	 */
	void exitRenameCmd(NftablesParser.RenameCmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#importCmd}.
	 * @param ctx the parse tree
	 */
	void enterImportCmd(NftablesParser.ImportCmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#importCmd}.
	 * @param ctx the parse tree
	 */
	void exitImportCmd(NftablesParser.ImportCmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#exportCmd}.
	 * @param ctx the parse tree
	 */
	void enterExportCmd(NftablesParser.ExportCmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#exportCmd}.
	 * @param ctx the parse tree
	 */
	void exitExportCmd(NftablesParser.ExportCmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#monitorCmd}.
	 * @param ctx the parse tree
	 */
	void enterMonitorCmd(NftablesParser.MonitorCmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#monitorCmd}.
	 * @param ctx the parse tree
	 */
	void exitMonitorCmd(NftablesParser.MonitorCmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#monitorEvent}.
	 * @param ctx the parse tree
	 */
	void enterMonitorEvent(NftablesParser.MonitorEventContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#monitorEvent}.
	 * @param ctx the parse tree
	 */
	void exitMonitorEvent(NftablesParser.MonitorEventContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#monitorObject}.
	 * @param ctx the parse tree
	 */
	void enterMonitorObject(NftablesParser.MonitorObjectContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#monitorObject}.
	 * @param ctx the parse tree
	 */
	void exitMonitorObject(NftablesParser.MonitorObjectContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#monitorFormat}.
	 * @param ctx the parse tree
	 */
	void enterMonitorFormat(NftablesParser.MonitorFormatContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#monitorFormat}.
	 * @param ctx the parse tree
	 */
	void exitMonitorFormat(NftablesParser.MonitorFormatContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#markupFormat}.
	 * @param ctx the parse tree
	 */
	void enterMarkupFormat(NftablesParser.MarkupFormatContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#markupFormat}.
	 * @param ctx the parse tree
	 */
	void exitMarkupFormat(NftablesParser.MarkupFormatContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#describeCmd}.
	 * @param ctx the parse tree
	 */
	void enterDescribeCmd(NftablesParser.DescribeCmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#describeCmd}.
	 * @param ctx the parse tree
	 */
	void exitDescribeCmd(NftablesParser.DescribeCmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#tableOptions}.
	 * @param ctx the parse tree
	 */
	void enterTableOptions(NftablesParser.TableOptionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#tableOptions}.
	 * @param ctx the parse tree
	 */
	void exitTableOptions(NftablesParser.TableOptionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#tableBlock}.
	 * @param ctx the parse tree
	 */
	void enterTableBlock(NftablesParser.TableBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#tableBlock}.
	 * @param ctx the parse tree
	 */
	void exitTableBlock(NftablesParser.TableBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#chainBlock}.
	 * @param ctx the parse tree
	 */
	void enterChainBlock(NftablesParser.ChainBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#chainBlock}.
	 * @param ctx the parse tree
	 */
	void exitChainBlock(NftablesParser.ChainBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#subchainBlock}.
	 * @param ctx the parse tree
	 */
	void enterSubchainBlock(NftablesParser.SubchainBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#subchainBlock}.
	 * @param ctx the parse tree
	 */
	void exitSubchainBlock(NftablesParser.SubchainBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#typeofDataExpr}.
	 * @param ctx the parse tree
	 */
	void enterTypeofDataExpr(NftablesParser.TypeofDataExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#typeofDataExpr}.
	 * @param ctx the parse tree
	 */
	void exitTypeofDataExpr(NftablesParser.TypeofDataExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#typeofExpr}.
	 * @param ctx the parse tree
	 */
	void enterTypeofExpr(NftablesParser.TypeofExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#typeofExpr}.
	 * @param ctx the parse tree
	 */
	void exitTypeofExpr(NftablesParser.TypeofExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#setBlock}.
	 * @param ctx the parse tree
	 */
	void enterSetBlock(NftablesParser.SetBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#setBlock}.
	 * @param ctx the parse tree
	 */
	void exitSetBlock(NftablesParser.SetBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#setBlockExpr}.
	 * @param ctx the parse tree
	 */
	void enterSetBlockExpr(NftablesParser.SetBlockExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#setBlockExpr}.
	 * @param ctx the parse tree
	 */
	void exitSetBlockExpr(NftablesParser.SetBlockExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#setFlagList}.
	 * @param ctx the parse tree
	 */
	void enterSetFlagList(NftablesParser.SetFlagListContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#setFlagList}.
	 * @param ctx the parse tree
	 */
	void exitSetFlagList(NftablesParser.SetFlagListContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#setFlag}.
	 * @param ctx the parse tree
	 */
	void enterSetFlag(NftablesParser.SetFlagContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#setFlag}.
	 * @param ctx the parse tree
	 */
	void exitSetFlag(NftablesParser.SetFlagContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#mapBlockObjType}.
	 * @param ctx the parse tree
	 */
	void enterMapBlockObjType(NftablesParser.MapBlockObjTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#mapBlockObjType}.
	 * @param ctx the parse tree
	 */
	void exitMapBlockObjType(NftablesParser.MapBlockObjTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#mapBlock}.
	 * @param ctx the parse tree
	 */
	void enterMapBlock(NftablesParser.MapBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#mapBlock}.
	 * @param ctx the parse tree
	 */
	void exitMapBlock(NftablesParser.MapBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#setMechanism}.
	 * @param ctx the parse tree
	 */
	void enterSetMechanism(NftablesParser.SetMechanismContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#setMechanism}.
	 * @param ctx the parse tree
	 */
	void exitSetMechanism(NftablesParser.SetMechanismContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#setPolicySpec}.
	 * @param ctx the parse tree
	 */
	void enterSetPolicySpec(NftablesParser.SetPolicySpecContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#setPolicySpec}.
	 * @param ctx the parse tree
	 */
	void exitSetPolicySpec(NftablesParser.SetPolicySpecContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#flowtableBlock}.
	 * @param ctx the parse tree
	 */
	void enterFlowtableBlock(NftablesParser.FlowtableBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#flowtableBlock}.
	 * @param ctx the parse tree
	 */
	void exitFlowtableBlock(NftablesParser.FlowtableBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#flowtableExpr}.
	 * @param ctx the parse tree
	 */
	void enterFlowtableExpr(NftablesParser.FlowtableExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#flowtableExpr}.
	 * @param ctx the parse tree
	 */
	void exitFlowtableExpr(NftablesParser.FlowtableExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#flowtableListExpr}.
	 * @param ctx the parse tree
	 */
	void enterFlowtableListExpr(NftablesParser.FlowtableListExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#flowtableListExpr}.
	 * @param ctx the parse tree
	 */
	void exitFlowtableListExpr(NftablesParser.FlowtableListExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#flowtableExprMember}.
	 * @param ctx the parse tree
	 */
	void enterFlowtableExprMember(NftablesParser.FlowtableExprMemberContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#flowtableExprMember}.
	 * @param ctx the parse tree
	 */
	void exitFlowtableExprMember(NftablesParser.FlowtableExprMemberContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#dataTypeAtomExpr}.
	 * @param ctx the parse tree
	 */
	void enterDataTypeAtomExpr(NftablesParser.DataTypeAtomExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#dataTypeAtomExpr}.
	 * @param ctx the parse tree
	 */
	void exitDataTypeAtomExpr(NftablesParser.DataTypeAtomExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#dataTypeExpr}.
	 * @param ctx the parse tree
	 */
	void enterDataTypeExpr(NftablesParser.DataTypeExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#dataTypeExpr}.
	 * @param ctx the parse tree
	 */
	void exitDataTypeExpr(NftablesParser.DataTypeExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#counterBlock}.
	 * @param ctx the parse tree
	 */
	void enterCounterBlock(NftablesParser.CounterBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#counterBlock}.
	 * @param ctx the parse tree
	 */
	void exitCounterBlock(NftablesParser.CounterBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#quotaBlock}.
	 * @param ctx the parse tree
	 */
	void enterQuotaBlock(NftablesParser.QuotaBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#quotaBlock}.
	 * @param ctx the parse tree
	 */
	void exitQuotaBlock(NftablesParser.QuotaBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#ctHelperBlock}.
	 * @param ctx the parse tree
	 */
	void enterCtHelperBlock(NftablesParser.CtHelperBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#ctHelperBlock}.
	 * @param ctx the parse tree
	 */
	void exitCtHelperBlock(NftablesParser.CtHelperBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#ctTimeoutBlock}.
	 * @param ctx the parse tree
	 */
	void enterCtTimeoutBlock(NftablesParser.CtTimeoutBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#ctTimeoutBlock}.
	 * @param ctx the parse tree
	 */
	void exitCtTimeoutBlock(NftablesParser.CtTimeoutBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#ctExpectBlock}.
	 * @param ctx the parse tree
	 */
	void enterCtExpectBlock(NftablesParser.CtExpectBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#ctExpectBlock}.
	 * @param ctx the parse tree
	 */
	void exitCtExpectBlock(NftablesParser.CtExpectBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#limitBlock}.
	 * @param ctx the parse tree
	 */
	void enterLimitBlock(NftablesParser.LimitBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#limitBlock}.
	 * @param ctx the parse tree
	 */
	void exitLimitBlock(NftablesParser.LimitBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#secmarkBlock}.
	 * @param ctx the parse tree
	 */
	void enterSecmarkBlock(NftablesParser.SecmarkBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#secmarkBlock}.
	 * @param ctx the parse tree
	 */
	void exitSecmarkBlock(NftablesParser.SecmarkBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#synproxyBlock}.
	 * @param ctx the parse tree
	 */
	void enterSynproxyBlock(NftablesParser.SynproxyBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#synproxyBlock}.
	 * @param ctx the parse tree
	 */
	void exitSynproxyBlock(NftablesParser.SynproxyBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#typeIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterTypeIdentifier(NftablesParser.TypeIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#typeIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitTypeIdentifier(NftablesParser.TypeIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#hookSpec}.
	 * @param ctx the parse tree
	 */
	void enterHookSpec(NftablesParser.HookSpecContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#hookSpec}.
	 * @param ctx the parse tree
	 */
	void exitHookSpec(NftablesParser.HookSpecContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#prioSpec}.
	 * @param ctx the parse tree
	 */
	void enterPrioSpec(NftablesParser.PrioSpecContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#prioSpec}.
	 * @param ctx the parse tree
	 */
	void exitPrioSpec(NftablesParser.PrioSpecContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#extendedPrioName}.
	 * @param ctx the parse tree
	 */
	void enterExtendedPrioName(NftablesParser.ExtendedPrioNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#extendedPrioName}.
	 * @param ctx the parse tree
	 */
	void exitExtendedPrioName(NftablesParser.ExtendedPrioNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#extendedPrioSpec}.
	 * @param ctx the parse tree
	 */
	void enterExtendedPrioSpec(NftablesParser.ExtendedPrioSpecContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#extendedPrioSpec}.
	 * @param ctx the parse tree
	 */
	void exitExtendedPrioSpec(NftablesParser.ExtendedPrioSpecContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#intNum}.
	 * @param ctx the parse tree
	 */
	void enterIntNum(NftablesParser.IntNumContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#intNum}.
	 * @param ctx the parse tree
	 */
	void exitIntNum(NftablesParser.IntNumContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#devSpec}.
	 * @param ctx the parse tree
	 */
	void enterDevSpec(NftablesParser.DevSpecContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#devSpec}.
	 * @param ctx the parse tree
	 */
	void exitDevSpec(NftablesParser.DevSpecContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#flagsSpec}.
	 * @param ctx the parse tree
	 */
	void enterFlagsSpec(NftablesParser.FlagsSpecContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#flagsSpec}.
	 * @param ctx the parse tree
	 */
	void exitFlagsSpec(NftablesParser.FlagsSpecContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#policySpec}.
	 * @param ctx the parse tree
	 */
	void enterPolicySpec(NftablesParser.PolicySpecContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#policySpec}.
	 * @param ctx the parse tree
	 */
	void exitPolicySpec(NftablesParser.PolicySpecContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#policyExpr}.
	 * @param ctx the parse tree
	 */
	void enterPolicyExpr(NftablesParser.PolicyExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#policyExpr}.
	 * @param ctx the parse tree
	 */
	void exitPolicyExpr(NftablesParser.PolicyExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#chainPolicy}.
	 * @param ctx the parse tree
	 */
	void enterChainPolicy(NftablesParser.ChainPolicyContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#chainPolicy}.
	 * @param ctx the parse tree
	 */
	void exitChainPolicy(NftablesParser.ChainPolicyContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#identifier}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(NftablesParser.IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#identifier}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(NftablesParser.IdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#string}.
	 * @param ctx the parse tree
	 */
	void enterString(NftablesParser.StringContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#string}.
	 * @param ctx the parse tree
	 */
	void exitString(NftablesParser.StringContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#timeSpec}.
	 * @param ctx the parse tree
	 */
	void enterTimeSpec(NftablesParser.TimeSpecContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#timeSpec}.
	 * @param ctx the parse tree
	 */
	void exitTimeSpec(NftablesParser.TimeSpecContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#familySpec}.
	 * @param ctx the parse tree
	 */
	void enterFamilySpec(NftablesParser.FamilySpecContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#familySpec}.
	 * @param ctx the parse tree
	 */
	void exitFamilySpec(NftablesParser.FamilySpecContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#familySpecExplicit}.
	 * @param ctx the parse tree
	 */
	void enterFamilySpecExplicit(NftablesParser.FamilySpecExplicitContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#familySpecExplicit}.
	 * @param ctx the parse tree
	 */
	void exitFamilySpecExplicit(NftablesParser.FamilySpecExplicitContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#tableSpec}.
	 * @param ctx the parse tree
	 */
	void enterTableSpec(NftablesParser.TableSpecContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#tableSpec}.
	 * @param ctx the parse tree
	 */
	void exitTableSpec(NftablesParser.TableSpecContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#tableidSpec}.
	 * @param ctx the parse tree
	 */
	void enterTableidSpec(NftablesParser.TableidSpecContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#tableidSpec}.
	 * @param ctx the parse tree
	 */
	void exitTableidSpec(NftablesParser.TableidSpecContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#chainSpec}.
	 * @param ctx the parse tree
	 */
	void enterChainSpec(NftablesParser.ChainSpecContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#chainSpec}.
	 * @param ctx the parse tree
	 */
	void exitChainSpec(NftablesParser.ChainSpecContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#chainidSpec}.
	 * @param ctx the parse tree
	 */
	void enterChainidSpec(NftablesParser.ChainidSpecContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#chainidSpec}.
	 * @param ctx the parse tree
	 */
	void exitChainidSpec(NftablesParser.ChainidSpecContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#chainIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterChainIdentifier(NftablesParser.ChainIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#chainIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitChainIdentifier(NftablesParser.ChainIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#setSpec}.
	 * @param ctx the parse tree
	 */
	void enterSetSpec(NftablesParser.SetSpecContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#setSpec}.
	 * @param ctx the parse tree
	 */
	void exitSetSpec(NftablesParser.SetSpecContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#setidSpec}.
	 * @param ctx the parse tree
	 */
	void enterSetidSpec(NftablesParser.SetidSpecContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#setidSpec}.
	 * @param ctx the parse tree
	 */
	void exitSetidSpec(NftablesParser.SetidSpecContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#setIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterSetIdentifier(NftablesParser.SetIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#setIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitSetIdentifier(NftablesParser.SetIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#flowtableSpec}.
	 * @param ctx the parse tree
	 */
	void enterFlowtableSpec(NftablesParser.FlowtableSpecContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#flowtableSpec}.
	 * @param ctx the parse tree
	 */
	void exitFlowtableSpec(NftablesParser.FlowtableSpecContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#flowtableidSpec}.
	 * @param ctx the parse tree
	 */
	void enterFlowtableidSpec(NftablesParser.FlowtableidSpecContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#flowtableidSpec}.
	 * @param ctx the parse tree
	 */
	void exitFlowtableidSpec(NftablesParser.FlowtableidSpecContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#flowtableIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterFlowtableIdentifier(NftablesParser.FlowtableIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#flowtableIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitFlowtableIdentifier(NftablesParser.FlowtableIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#objSpec}.
	 * @param ctx the parse tree
	 */
	void enterObjSpec(NftablesParser.ObjSpecContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#objSpec}.
	 * @param ctx the parse tree
	 */
	void exitObjSpec(NftablesParser.ObjSpecContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#objidSpec}.
	 * @param ctx the parse tree
	 */
	void enterObjidSpec(NftablesParser.ObjidSpecContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#objidSpec}.
	 * @param ctx the parse tree
	 */
	void exitObjidSpec(NftablesParser.ObjidSpecContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#objIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterObjIdentifier(NftablesParser.ObjIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#objIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitObjIdentifier(NftablesParser.ObjIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#handleSpec}.
	 * @param ctx the parse tree
	 */
	void enterHandleSpec(NftablesParser.HandleSpecContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#handleSpec}.
	 * @param ctx the parse tree
	 */
	void exitHandleSpec(NftablesParser.HandleSpecContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#positionSpec}.
	 * @param ctx the parse tree
	 */
	void enterPositionSpec(NftablesParser.PositionSpecContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#positionSpec}.
	 * @param ctx the parse tree
	 */
	void exitPositionSpec(NftablesParser.PositionSpecContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#indexSpec}.
	 * @param ctx the parse tree
	 */
	void enterIndexSpec(NftablesParser.IndexSpecContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#indexSpec}.
	 * @param ctx the parse tree
	 */
	void exitIndexSpec(NftablesParser.IndexSpecContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#rulePosition}.
	 * @param ctx the parse tree
	 */
	void enterRulePosition(NftablesParser.RulePositionContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#rulePosition}.
	 * @param ctx the parse tree
	 */
	void exitRulePosition(NftablesParser.RulePositionContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#ruleidSpec}.
	 * @param ctx the parse tree
	 */
	void enterRuleidSpec(NftablesParser.RuleidSpecContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#ruleidSpec}.
	 * @param ctx the parse tree
	 */
	void exitRuleidSpec(NftablesParser.RuleidSpecContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#commentSpec}.
	 * @param ctx the parse tree
	 */
	void enterCommentSpec(NftablesParser.CommentSpecContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#commentSpec}.
	 * @param ctx the parse tree
	 */
	void exitCommentSpec(NftablesParser.CommentSpecContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#rulesetSpec}.
	 * @param ctx the parse tree
	 */
	void enterRulesetSpec(NftablesParser.RulesetSpecContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#rulesetSpec}.
	 * @param ctx the parse tree
	 */
	void exitRulesetSpec(NftablesParser.RulesetSpecContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#ruleSpec}.
	 * @param ctx the parse tree
	 */
	void enterRuleSpec(NftablesParser.RuleSpecContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#ruleSpec}.
	 * @param ctx the parse tree
	 */
	void exitRuleSpec(NftablesParser.RuleSpecContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#ruleAlloc}.
	 * @param ctx the parse tree
	 */
	void enterRuleAlloc(NftablesParser.RuleAllocContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#ruleAlloc}.
	 * @param ctx the parse tree
	 */
	void exitRuleAlloc(NftablesParser.RuleAllocContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#stmtList}.
	 * @param ctx the parse tree
	 */
	void enterStmtList(NftablesParser.StmtListContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#stmtList}.
	 * @param ctx the parse tree
	 */
	void exitStmtList(NftablesParser.StmtListContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#statefulStmtList}.
	 * @param ctx the parse tree
	 */
	void enterStatefulStmtList(NftablesParser.StatefulStmtListContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#statefulStmtList}.
	 * @param ctx the parse tree
	 */
	void exitStatefulStmtList(NftablesParser.StatefulStmtListContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#statefulStmt}.
	 * @param ctx the parse tree
	 */
	void enterStatefulStmt(NftablesParser.StatefulStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#statefulStmt}.
	 * @param ctx the parse tree
	 */
	void exitStatefulStmt(NftablesParser.StatefulStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterStmt(NftablesParser.StmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitStmt(NftablesParser.StmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#chainStmtType}.
	 * @param ctx the parse tree
	 */
	void enterChainStmtType(NftablesParser.ChainStmtTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#chainStmtType}.
	 * @param ctx the parse tree
	 */
	void exitChainStmtType(NftablesParser.ChainStmtTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#chainStmt}.
	 * @param ctx the parse tree
	 */
	void enterChainStmt(NftablesParser.ChainStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#chainStmt}.
	 * @param ctx the parse tree
	 */
	void exitChainStmt(NftablesParser.ChainStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#verdictStmt}.
	 * @param ctx the parse tree
	 */
	void enterVerdictStmt(NftablesParser.VerdictStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#verdictStmt}.
	 * @param ctx the parse tree
	 */
	void exitVerdictStmt(NftablesParser.VerdictStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#verdictMapStmt}.
	 * @param ctx the parse tree
	 */
	void enterVerdictMapStmt(NftablesParser.VerdictMapStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#verdictMapStmt}.
	 * @param ctx the parse tree
	 */
	void exitVerdictMapStmt(NftablesParser.VerdictMapStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#verdictMapExpr}.
	 * @param ctx the parse tree
	 */
	void enterVerdictMapExpr(NftablesParser.VerdictMapExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#verdictMapExpr}.
	 * @param ctx the parse tree
	 */
	void exitVerdictMapExpr(NftablesParser.VerdictMapExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#verdictMapListExpr}.
	 * @param ctx the parse tree
	 */
	void enterVerdictMapListExpr(NftablesParser.VerdictMapListExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#verdictMapListExpr}.
	 * @param ctx the parse tree
	 */
	void exitVerdictMapListExpr(NftablesParser.VerdictMapListExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#verdictMapListMemberExpr}.
	 * @param ctx the parse tree
	 */
	void enterVerdictMapListMemberExpr(NftablesParser.VerdictMapListMemberExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#verdictMapListMemberExpr}.
	 * @param ctx the parse tree
	 */
	void exitVerdictMapListMemberExpr(NftablesParser.VerdictMapListMemberExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#connlimitStmt}.
	 * @param ctx the parse tree
	 */
	void enterConnlimitStmt(NftablesParser.ConnlimitStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#connlimitStmt}.
	 * @param ctx the parse tree
	 */
	void exitConnlimitStmt(NftablesParser.ConnlimitStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#counterStmt}.
	 * @param ctx the parse tree
	 */
	void enterCounterStmt(NftablesParser.CounterStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#counterStmt}.
	 * @param ctx the parse tree
	 */
	void exitCounterStmt(NftablesParser.CounterStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#counterStmtAlloc}.
	 * @param ctx the parse tree
	 */
	void enterCounterStmtAlloc(NftablesParser.CounterStmtAllocContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#counterStmtAlloc}.
	 * @param ctx the parse tree
	 */
	void exitCounterStmtAlloc(NftablesParser.CounterStmtAllocContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#counterArgs}.
	 * @param ctx the parse tree
	 */
	void enterCounterArgs(NftablesParser.CounterArgsContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#counterArgs}.
	 * @param ctx the parse tree
	 */
	void exitCounterArgs(NftablesParser.CounterArgsContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#counterArg}.
	 * @param ctx the parse tree
	 */
	void enterCounterArg(NftablesParser.CounterArgContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#counterArg}.
	 * @param ctx the parse tree
	 */
	void exitCounterArg(NftablesParser.CounterArgContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#logStmt}.
	 * @param ctx the parse tree
	 */
	void enterLogStmt(NftablesParser.LogStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#logStmt}.
	 * @param ctx the parse tree
	 */
	void exitLogStmt(NftablesParser.LogStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#logStmtAlloc}.
	 * @param ctx the parse tree
	 */
	void enterLogStmtAlloc(NftablesParser.LogStmtAllocContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#logStmtAlloc}.
	 * @param ctx the parse tree
	 */
	void exitLogStmtAlloc(NftablesParser.LogStmtAllocContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#logArgs}.
	 * @param ctx the parse tree
	 */
	void enterLogArgs(NftablesParser.LogArgsContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#logArgs}.
	 * @param ctx the parse tree
	 */
	void exitLogArgs(NftablesParser.LogArgsContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#logArg}.
	 * @param ctx the parse tree
	 */
	void enterLogArg(NftablesParser.LogArgContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#logArg}.
	 * @param ctx the parse tree
	 */
	void exitLogArg(NftablesParser.LogArgContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#levelType}.
	 * @param ctx the parse tree
	 */
	void enterLevelType(NftablesParser.LevelTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#levelType}.
	 * @param ctx the parse tree
	 */
	void exitLevelType(NftablesParser.LevelTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#logFlags}.
	 * @param ctx the parse tree
	 */
	void enterLogFlags(NftablesParser.LogFlagsContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#logFlags}.
	 * @param ctx the parse tree
	 */
	void exitLogFlags(NftablesParser.LogFlagsContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#logFlagsTcp}.
	 * @param ctx the parse tree
	 */
	void enterLogFlagsTcp(NftablesParser.LogFlagsTcpContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#logFlagsTcp}.
	 * @param ctx the parse tree
	 */
	void exitLogFlagsTcp(NftablesParser.LogFlagsTcpContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#logFlagTcp}.
	 * @param ctx the parse tree
	 */
	void enterLogFlagTcp(NftablesParser.LogFlagTcpContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#logFlagTcp}.
	 * @param ctx the parse tree
	 */
	void exitLogFlagTcp(NftablesParser.LogFlagTcpContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#limitStmt}.
	 * @param ctx the parse tree
	 */
	void enterLimitStmt(NftablesParser.LimitStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#limitStmt}.
	 * @param ctx the parse tree
	 */
	void exitLimitStmt(NftablesParser.LimitStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#quotaMode}.
	 * @param ctx the parse tree
	 */
	void enterQuotaMode(NftablesParser.QuotaModeContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#quotaMode}.
	 * @param ctx the parse tree
	 */
	void exitQuotaMode(NftablesParser.QuotaModeContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#quotaUnit}.
	 * @param ctx the parse tree
	 */
	void enterQuotaUnit(NftablesParser.QuotaUnitContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#quotaUnit}.
	 * @param ctx the parse tree
	 */
	void exitQuotaUnit(NftablesParser.QuotaUnitContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#quotaUsed}.
	 * @param ctx the parse tree
	 */
	void enterQuotaUsed(NftablesParser.QuotaUsedContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#quotaUsed}.
	 * @param ctx the parse tree
	 */
	void exitQuotaUsed(NftablesParser.QuotaUsedContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#quotaStmt}.
	 * @param ctx the parse tree
	 */
	void enterQuotaStmt(NftablesParser.QuotaStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#quotaStmt}.
	 * @param ctx the parse tree
	 */
	void exitQuotaStmt(NftablesParser.QuotaStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#limitMode}.
	 * @param ctx the parse tree
	 */
	void enterLimitMode(NftablesParser.LimitModeContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#limitMode}.
	 * @param ctx the parse tree
	 */
	void exitLimitMode(NftablesParser.LimitModeContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#limitBurstPkts}.
	 * @param ctx the parse tree
	 */
	void enterLimitBurstPkts(NftablesParser.LimitBurstPktsContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#limitBurstPkts}.
	 * @param ctx the parse tree
	 */
	void exitLimitBurstPkts(NftablesParser.LimitBurstPktsContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#limitBurstBytes}.
	 * @param ctx the parse tree
	 */
	void enterLimitBurstBytes(NftablesParser.LimitBurstBytesContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#limitBurstBytes}.
	 * @param ctx the parse tree
	 */
	void exitLimitBurstBytes(NftablesParser.LimitBurstBytesContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#timeUnit}.
	 * @param ctx the parse tree
	 */
	void enterTimeUnit(NftablesParser.TimeUnitContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#timeUnit}.
	 * @param ctx the parse tree
	 */
	void exitTimeUnit(NftablesParser.TimeUnitContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#rejectStmt}.
	 * @param ctx the parse tree
	 */
	void enterRejectStmt(NftablesParser.RejectStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#rejectStmt}.
	 * @param ctx the parse tree
	 */
	void exitRejectStmt(NftablesParser.RejectStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#rejectStmtAlloc}.
	 * @param ctx the parse tree
	 */
	void enterRejectStmtAlloc(NftablesParser.RejectStmtAllocContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#rejectStmtAlloc}.
	 * @param ctx the parse tree
	 */
	void exitRejectStmtAlloc(NftablesParser.RejectStmtAllocContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#rejectWithExpr}.
	 * @param ctx the parse tree
	 */
	void enterRejectWithExpr(NftablesParser.RejectWithExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#rejectWithExpr}.
	 * @param ctx the parse tree
	 */
	void exitRejectWithExpr(NftablesParser.RejectWithExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#rejectOpts}.
	 * @param ctx the parse tree
	 */
	void enterRejectOpts(NftablesParser.RejectOptsContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#rejectOpts}.
	 * @param ctx the parse tree
	 */
	void exitRejectOpts(NftablesParser.RejectOptsContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#natStmt}.
	 * @param ctx the parse tree
	 */
	void enterNatStmt(NftablesParser.NatStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#natStmt}.
	 * @param ctx the parse tree
	 */
	void exitNatStmt(NftablesParser.NatStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#natStmtAlloc}.
	 * @param ctx the parse tree
	 */
	void enterNatStmtAlloc(NftablesParser.NatStmtAllocContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#natStmtAlloc}.
	 * @param ctx the parse tree
	 */
	void exitNatStmtAlloc(NftablesParser.NatStmtAllocContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#tproxyStmt}.
	 * @param ctx the parse tree
	 */
	void enterTproxyStmt(NftablesParser.TproxyStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#tproxyStmt}.
	 * @param ctx the parse tree
	 */
	void exitTproxyStmt(NftablesParser.TproxyStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#synproxyStmt}.
	 * @param ctx the parse tree
	 */
	void enterSynproxyStmt(NftablesParser.SynproxyStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#synproxyStmt}.
	 * @param ctx the parse tree
	 */
	void exitSynproxyStmt(NftablesParser.SynproxyStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#synproxyStmtAlloc}.
	 * @param ctx the parse tree
	 */
	void enterSynproxyStmtAlloc(NftablesParser.SynproxyStmtAllocContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#synproxyStmtAlloc}.
	 * @param ctx the parse tree
	 */
	void exitSynproxyStmtAlloc(NftablesParser.SynproxyStmtAllocContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#synproxyArgs}.
	 * @param ctx the parse tree
	 */
	void enterSynproxyArgs(NftablesParser.SynproxyArgsContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#synproxyArgs}.
	 * @param ctx the parse tree
	 */
	void exitSynproxyArgs(NftablesParser.SynproxyArgsContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#synproxyArg}.
	 * @param ctx the parse tree
	 */
	void enterSynproxyArg(NftablesParser.SynproxyArgContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#synproxyArg}.
	 * @param ctx the parse tree
	 */
	void exitSynproxyArg(NftablesParser.SynproxyArgContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#synproxyConfig}.
	 * @param ctx the parse tree
	 */
	void enterSynproxyConfig(NftablesParser.SynproxyConfigContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#synproxyConfig}.
	 * @param ctx the parse tree
	 */
	void exitSynproxyConfig(NftablesParser.SynproxyConfigContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#synproxyTs}.
	 * @param ctx the parse tree
	 */
	void enterSynproxyTs(NftablesParser.SynproxyTsContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#synproxyTs}.
	 * @param ctx the parse tree
	 */
	void exitSynproxyTs(NftablesParser.SynproxyTsContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#synproxySack}.
	 * @param ctx the parse tree
	 */
	void enterSynproxySack(NftablesParser.SynproxySackContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#synproxySack}.
	 * @param ctx the parse tree
	 */
	void exitSynproxySack(NftablesParser.SynproxySackContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#primaryStmtExpr}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryStmtExpr(NftablesParser.PrimaryStmtExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#primaryStmtExpr}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryStmtExpr(NftablesParser.PrimaryStmtExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#shiftStmtExpr}.
	 * @param ctx the parse tree
	 */
	void enterShiftStmtExpr(NftablesParser.ShiftStmtExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#shiftStmtExpr}.
	 * @param ctx the parse tree
	 */
	void exitShiftStmtExpr(NftablesParser.ShiftStmtExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#andStmtExpr}.
	 * @param ctx the parse tree
	 */
	void enterAndStmtExpr(NftablesParser.AndStmtExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#andStmtExpr}.
	 * @param ctx the parse tree
	 */
	void exitAndStmtExpr(NftablesParser.AndStmtExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#exclusiveOrStmtExpr}.
	 * @param ctx the parse tree
	 */
	void enterExclusiveOrStmtExpr(NftablesParser.ExclusiveOrStmtExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#exclusiveOrStmtExpr}.
	 * @param ctx the parse tree
	 */
	void exitExclusiveOrStmtExpr(NftablesParser.ExclusiveOrStmtExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#inclusiveOrStmtExpr}.
	 * @param ctx the parse tree
	 */
	void enterInclusiveOrStmtExpr(NftablesParser.InclusiveOrStmtExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#inclusiveOrStmtExpr}.
	 * @param ctx the parse tree
	 */
	void exitInclusiveOrStmtExpr(NftablesParser.InclusiveOrStmtExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#basicStmtExpr}.
	 * @param ctx the parse tree
	 */
	void enterBasicStmtExpr(NftablesParser.BasicStmtExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#basicStmtExpr}.
	 * @param ctx the parse tree
	 */
	void exitBasicStmtExpr(NftablesParser.BasicStmtExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#concatStmtExpr}.
	 * @param ctx the parse tree
	 */
	void enterConcatStmtExpr(NftablesParser.ConcatStmtExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#concatStmtExpr}.
	 * @param ctx the parse tree
	 */
	void exitConcatStmtExpr(NftablesParser.ConcatStmtExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#mapStmtExprSet}.
	 * @param ctx the parse tree
	 */
	void enterMapStmtExprSet(NftablesParser.MapStmtExprSetContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#mapStmtExprSet}.
	 * @param ctx the parse tree
	 */
	void exitMapStmtExprSet(NftablesParser.MapStmtExprSetContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#mapStmtExpr}.
	 * @param ctx the parse tree
	 */
	void enterMapStmtExpr(NftablesParser.MapStmtExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#mapStmtExpr}.
	 * @param ctx the parse tree
	 */
	void exitMapStmtExpr(NftablesParser.MapStmtExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#prefixStmtExpr}.
	 * @param ctx the parse tree
	 */
	void enterPrefixStmtExpr(NftablesParser.PrefixStmtExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#prefixStmtExpr}.
	 * @param ctx the parse tree
	 */
	void exitPrefixStmtExpr(NftablesParser.PrefixStmtExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#rangeStmtExpr}.
	 * @param ctx the parse tree
	 */
	void enterRangeStmtExpr(NftablesParser.RangeStmtExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#rangeStmtExpr}.
	 * @param ctx the parse tree
	 */
	void exitRangeStmtExpr(NftablesParser.RangeStmtExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#multitonStmtExpr}.
	 * @param ctx the parse tree
	 */
	void enterMultitonStmtExpr(NftablesParser.MultitonStmtExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#multitonStmtExpr}.
	 * @param ctx the parse tree
	 */
	void exitMultitonStmtExpr(NftablesParser.MultitonStmtExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#stmtExpr}.
	 * @param ctx the parse tree
	 */
	void enterStmtExpr(NftablesParser.StmtExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#stmtExpr}.
	 * @param ctx the parse tree
	 */
	void exitStmtExpr(NftablesParser.StmtExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#natStmtArgs}.
	 * @param ctx the parse tree
	 */
	void enterNatStmtArgs(NftablesParser.NatStmtArgsContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#natStmtArgs}.
	 * @param ctx the parse tree
	 */
	void exitNatStmtArgs(NftablesParser.NatStmtArgsContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#masqStmt}.
	 * @param ctx the parse tree
	 */
	void enterMasqStmt(NftablesParser.MasqStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#masqStmt}.
	 * @param ctx the parse tree
	 */
	void exitMasqStmt(NftablesParser.MasqStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#masqStmtAlloc}.
	 * @param ctx the parse tree
	 */
	void enterMasqStmtAlloc(NftablesParser.MasqStmtAllocContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#masqStmtAlloc}.
	 * @param ctx the parse tree
	 */
	void exitMasqStmtAlloc(NftablesParser.MasqStmtAllocContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#masqStmtArgs}.
	 * @param ctx the parse tree
	 */
	void enterMasqStmtArgs(NftablesParser.MasqStmtArgsContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#masqStmtArgs}.
	 * @param ctx the parse tree
	 */
	void exitMasqStmtArgs(NftablesParser.MasqStmtArgsContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#redirStmt}.
	 * @param ctx the parse tree
	 */
	void enterRedirStmt(NftablesParser.RedirStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#redirStmt}.
	 * @param ctx the parse tree
	 */
	void exitRedirStmt(NftablesParser.RedirStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#redirStmtAlloc}.
	 * @param ctx the parse tree
	 */
	void enterRedirStmtAlloc(NftablesParser.RedirStmtAllocContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#redirStmtAlloc}.
	 * @param ctx the parse tree
	 */
	void exitRedirStmtAlloc(NftablesParser.RedirStmtAllocContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#redirStmtArg}.
	 * @param ctx the parse tree
	 */
	void enterRedirStmtArg(NftablesParser.RedirStmtArgContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#redirStmtArg}.
	 * @param ctx the parse tree
	 */
	void exitRedirStmtArg(NftablesParser.RedirStmtArgContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#dupStmt}.
	 * @param ctx the parse tree
	 */
	void enterDupStmt(NftablesParser.DupStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#dupStmt}.
	 * @param ctx the parse tree
	 */
	void exitDupStmt(NftablesParser.DupStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#fwdStmt}.
	 * @param ctx the parse tree
	 */
	void enterFwdStmt(NftablesParser.FwdStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#fwdStmt}.
	 * @param ctx the parse tree
	 */
	void exitFwdStmt(NftablesParser.FwdStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#nfNatFlags}.
	 * @param ctx the parse tree
	 */
	void enterNfNatFlags(NftablesParser.NfNatFlagsContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#nfNatFlags}.
	 * @param ctx the parse tree
	 */
	void exitNfNatFlags(NftablesParser.NfNatFlagsContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#nfNatFlag}.
	 * @param ctx the parse tree
	 */
	void enterNfNatFlag(NftablesParser.NfNatFlagContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#nfNatFlag}.
	 * @param ctx the parse tree
	 */
	void exitNfNatFlag(NftablesParser.NfNatFlagContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#queueStmt}.
	 * @param ctx the parse tree
	 */
	void enterQueueStmt(NftablesParser.QueueStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#queueStmt}.
	 * @param ctx the parse tree
	 */
	void exitQueueStmt(NftablesParser.QueueStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#queueStmtCompat}.
	 * @param ctx the parse tree
	 */
	void enterQueueStmtCompat(NftablesParser.QueueStmtCompatContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#queueStmtCompat}.
	 * @param ctx the parse tree
	 */
	void exitQueueStmtCompat(NftablesParser.QueueStmtCompatContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#queueStmtAlloc}.
	 * @param ctx the parse tree
	 */
	void enterQueueStmtAlloc(NftablesParser.QueueStmtAllocContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#queueStmtAlloc}.
	 * @param ctx the parse tree
	 */
	void exitQueueStmtAlloc(NftablesParser.QueueStmtAllocContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#queueStmtArgs}.
	 * @param ctx the parse tree
	 */
	void enterQueueStmtArgs(NftablesParser.QueueStmtArgsContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#queueStmtArgs}.
	 * @param ctx the parse tree
	 */
	void exitQueueStmtArgs(NftablesParser.QueueStmtArgsContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#queueStmtArg}.
	 * @param ctx the parse tree
	 */
	void enterQueueStmtArg(NftablesParser.QueueStmtArgContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#queueStmtArg}.
	 * @param ctx the parse tree
	 */
	void exitQueueStmtArg(NftablesParser.QueueStmtArgContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#queueExpr}.
	 * @param ctx the parse tree
	 */
	void enterQueueExpr(NftablesParser.QueueExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#queueExpr}.
	 * @param ctx the parse tree
	 */
	void exitQueueExpr(NftablesParser.QueueExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#queueStmtExprSimple}.
	 * @param ctx the parse tree
	 */
	void enterQueueStmtExprSimple(NftablesParser.QueueStmtExprSimpleContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#queueStmtExprSimple}.
	 * @param ctx the parse tree
	 */
	void exitQueueStmtExprSimple(NftablesParser.QueueStmtExprSimpleContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#queueStmtExpr}.
	 * @param ctx the parse tree
	 */
	void enterQueueStmtExpr(NftablesParser.QueueStmtExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#queueStmtExpr}.
	 * @param ctx the parse tree
	 */
	void exitQueueStmtExpr(NftablesParser.QueueStmtExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#queueStmtFlags}.
	 * @param ctx the parse tree
	 */
	void enterQueueStmtFlags(NftablesParser.QueueStmtFlagsContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#queueStmtFlags}.
	 * @param ctx the parse tree
	 */
	void exitQueueStmtFlags(NftablesParser.QueueStmtFlagsContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#queueStmtFlag}.
	 * @param ctx the parse tree
	 */
	void enterQueueStmtFlag(NftablesParser.QueueStmtFlagContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#queueStmtFlag}.
	 * @param ctx the parse tree
	 */
	void exitQueueStmtFlag(NftablesParser.QueueStmtFlagContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#setElemExprStmt}.
	 * @param ctx the parse tree
	 */
	void enterSetElemExprStmt(NftablesParser.SetElemExprStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#setElemExprStmt}.
	 * @param ctx the parse tree
	 */
	void exitSetElemExprStmt(NftablesParser.SetElemExprStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#setElemExprStmtAlloc}.
	 * @param ctx the parse tree
	 */
	void enterSetElemExprStmtAlloc(NftablesParser.SetElemExprStmtAllocContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#setElemExprStmtAlloc}.
	 * @param ctx the parse tree
	 */
	void exitSetElemExprStmtAlloc(NftablesParser.SetElemExprStmtAllocContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#setStmt}.
	 * @param ctx the parse tree
	 */
	void enterSetStmt(NftablesParser.SetStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#setStmt}.
	 * @param ctx the parse tree
	 */
	void exitSetStmt(NftablesParser.SetStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#setStmtOp}.
	 * @param ctx the parse tree
	 */
	void enterSetStmtOp(NftablesParser.SetStmtOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#setStmtOp}.
	 * @param ctx the parse tree
	 */
	void exitSetStmtOp(NftablesParser.SetStmtOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#mapStmt}.
	 * @param ctx the parse tree
	 */
	void enterMapStmt(NftablesParser.MapStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#mapStmt}.
	 * @param ctx the parse tree
	 */
	void exitMapStmt(NftablesParser.MapStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#meterStmt}.
	 * @param ctx the parse tree
	 */
	void enterMeterStmt(NftablesParser.MeterStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#meterStmt}.
	 * @param ctx the parse tree
	 */
	void exitMeterStmt(NftablesParser.MeterStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#flowStmtLegacyAlloc}.
	 * @param ctx the parse tree
	 */
	void enterFlowStmtLegacyAlloc(NftablesParser.FlowStmtLegacyAllocContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#flowStmtLegacyAlloc}.
	 * @param ctx the parse tree
	 */
	void exitFlowStmtLegacyAlloc(NftablesParser.FlowStmtLegacyAllocContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#flowStmtOpts}.
	 * @param ctx the parse tree
	 */
	void enterFlowStmtOpts(NftablesParser.FlowStmtOptsContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#flowStmtOpts}.
	 * @param ctx the parse tree
	 */
	void exitFlowStmtOpts(NftablesParser.FlowStmtOptsContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#flowStmtOpt}.
	 * @param ctx the parse tree
	 */
	void enterFlowStmtOpt(NftablesParser.FlowStmtOptContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#flowStmtOpt}.
	 * @param ctx the parse tree
	 */
	void exitFlowStmtOpt(NftablesParser.FlowStmtOptContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#meterStmtAlloc}.
	 * @param ctx the parse tree
	 */
	void enterMeterStmtAlloc(NftablesParser.MeterStmtAllocContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#meterStmtAlloc}.
	 * @param ctx the parse tree
	 */
	void exitMeterStmtAlloc(NftablesParser.MeterStmtAllocContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#matchStmt}.
	 * @param ctx the parse tree
	 */
	void enterMatchStmt(NftablesParser.MatchStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#matchStmt}.
	 * @param ctx the parse tree
	 */
	void exitMatchStmt(NftablesParser.MatchStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#variableExpr}.
	 * @param ctx the parse tree
	 */
	void enterVariableExpr(NftablesParser.VariableExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#variableExpr}.
	 * @param ctx the parse tree
	 */
	void exitVariableExpr(NftablesParser.VariableExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#symbolExpr}.
	 * @param ctx the parse tree
	 */
	void enterSymbolExpr(NftablesParser.SymbolExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#symbolExpr}.
	 * @param ctx the parse tree
	 */
	void exitSymbolExpr(NftablesParser.SymbolExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#setRefExpr}.
	 * @param ctx the parse tree
	 */
	void enterSetRefExpr(NftablesParser.SetRefExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#setRefExpr}.
	 * @param ctx the parse tree
	 */
	void exitSetRefExpr(NftablesParser.SetRefExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#setRefSymbolExpr}.
	 * @param ctx the parse tree
	 */
	void enterSetRefSymbolExpr(NftablesParser.SetRefSymbolExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#setRefSymbolExpr}.
	 * @param ctx the parse tree
	 */
	void exitSetRefSymbolExpr(NftablesParser.SetRefSymbolExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#integerExpr}.
	 * @param ctx the parse tree
	 */
	void enterIntegerExpr(NftablesParser.IntegerExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#integerExpr}.
	 * @param ctx the parse tree
	 */
	void exitIntegerExpr(NftablesParser.IntegerExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#primaryExpr}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryExpr(NftablesParser.PrimaryExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#primaryExpr}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryExpr(NftablesParser.PrimaryExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#fibExpr}.
	 * @param ctx the parse tree
	 */
	void enterFibExpr(NftablesParser.FibExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#fibExpr}.
	 * @param ctx the parse tree
	 */
	void exitFibExpr(NftablesParser.FibExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#fibResult}.
	 * @param ctx the parse tree
	 */
	void enterFibResult(NftablesParser.FibResultContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#fibResult}.
	 * @param ctx the parse tree
	 */
	void exitFibResult(NftablesParser.FibResultContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#fibFlag}.
	 * @param ctx the parse tree
	 */
	void enterFibFlag(NftablesParser.FibFlagContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#fibFlag}.
	 * @param ctx the parse tree
	 */
	void exitFibFlag(NftablesParser.FibFlagContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#fibTuple}.
	 * @param ctx the parse tree
	 */
	void enterFibTuple(NftablesParser.FibTupleContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#fibTuple}.
	 * @param ctx the parse tree
	 */
	void exitFibTuple(NftablesParser.FibTupleContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#osfExpr}.
	 * @param ctx the parse tree
	 */
	void enterOsfExpr(NftablesParser.OsfExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#osfExpr}.
	 * @param ctx the parse tree
	 */
	void exitOsfExpr(NftablesParser.OsfExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#osfTtl}.
	 * @param ctx the parse tree
	 */
	void enterOsfTtl(NftablesParser.OsfTtlContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#osfTtl}.
	 * @param ctx the parse tree
	 */
	void exitOsfTtl(NftablesParser.OsfTtlContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#shiftExpr}.
	 * @param ctx the parse tree
	 */
	void enterShiftExpr(NftablesParser.ShiftExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#shiftExpr}.
	 * @param ctx the parse tree
	 */
	void exitShiftExpr(NftablesParser.ShiftExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#andExpr}.
	 * @param ctx the parse tree
	 */
	void enterAndExpr(NftablesParser.AndExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#andExpr}.
	 * @param ctx the parse tree
	 */
	void exitAndExpr(NftablesParser.AndExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#exclusiveOrExpr}.
	 * @param ctx the parse tree
	 */
	void enterExclusiveOrExpr(NftablesParser.ExclusiveOrExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#exclusiveOrExpr}.
	 * @param ctx the parse tree
	 */
	void exitExclusiveOrExpr(NftablesParser.ExclusiveOrExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#inclusiveOrExpr}.
	 * @param ctx the parse tree
	 */
	void enterInclusiveOrExpr(NftablesParser.InclusiveOrExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#inclusiveOrExpr}.
	 * @param ctx the parse tree
	 */
	void exitInclusiveOrExpr(NftablesParser.InclusiveOrExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#basicExpr}.
	 * @param ctx the parse tree
	 */
	void enterBasicExpr(NftablesParser.BasicExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#basicExpr}.
	 * @param ctx the parse tree
	 */
	void exitBasicExpr(NftablesParser.BasicExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#concatExpr}.
	 * @param ctx the parse tree
	 */
	void enterConcatExpr(NftablesParser.ConcatExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#concatExpr}.
	 * @param ctx the parse tree
	 */
	void exitConcatExpr(NftablesParser.ConcatExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#prefixRhsExpr}.
	 * @param ctx the parse tree
	 */
	void enterPrefixRhsExpr(NftablesParser.PrefixRhsExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#prefixRhsExpr}.
	 * @param ctx the parse tree
	 */
	void exitPrefixRhsExpr(NftablesParser.PrefixRhsExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#rangeRhsExpr}.
	 * @param ctx the parse tree
	 */
	void enterRangeRhsExpr(NftablesParser.RangeRhsExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#rangeRhsExpr}.
	 * @param ctx the parse tree
	 */
	void exitRangeRhsExpr(NftablesParser.RangeRhsExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#multitonRhsExpr}.
	 * @param ctx the parse tree
	 */
	void enterMultitonRhsExpr(NftablesParser.MultitonRhsExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#multitonRhsExpr}.
	 * @param ctx the parse tree
	 */
	void exitMultitonRhsExpr(NftablesParser.MultitonRhsExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#mapExpr}.
	 * @param ctx the parse tree
	 */
	void enterMapExpr(NftablesParser.MapExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#mapExpr}.
	 * @param ctx the parse tree
	 */
	void exitMapExpr(NftablesParser.MapExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(NftablesParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(NftablesParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#setExpr}.
	 * @param ctx the parse tree
	 */
	void enterSetExpr(NftablesParser.SetExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#setExpr}.
	 * @param ctx the parse tree
	 */
	void exitSetExpr(NftablesParser.SetExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#setListExpr}.
	 * @param ctx the parse tree
	 */
	void enterSetListExpr(NftablesParser.SetListExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#setListExpr}.
	 * @param ctx the parse tree
	 */
	void exitSetListExpr(NftablesParser.SetListExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#setListMemberExpr}.
	 * @param ctx the parse tree
	 */
	void enterSetListMemberExpr(NftablesParser.SetListMemberExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#setListMemberExpr}.
	 * @param ctx the parse tree
	 */
	void exitSetListMemberExpr(NftablesParser.SetListMemberExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#meterKeyExpr}.
	 * @param ctx the parse tree
	 */
	void enterMeterKeyExpr(NftablesParser.MeterKeyExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#meterKeyExpr}.
	 * @param ctx the parse tree
	 */
	void exitMeterKeyExpr(NftablesParser.MeterKeyExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#meterKeyExprAlloc}.
	 * @param ctx the parse tree
	 */
	void enterMeterKeyExprAlloc(NftablesParser.MeterKeyExprAllocContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#meterKeyExprAlloc}.
	 * @param ctx the parse tree
	 */
	void exitMeterKeyExprAlloc(NftablesParser.MeterKeyExprAllocContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#setElemExpr}.
	 * @param ctx the parse tree
	 */
	void enterSetElemExpr(NftablesParser.SetElemExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#setElemExpr}.
	 * @param ctx the parse tree
	 */
	void exitSetElemExpr(NftablesParser.SetElemExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#setElemKeyExpr}.
	 * @param ctx the parse tree
	 */
	void enterSetElemKeyExpr(NftablesParser.SetElemKeyExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#setElemKeyExpr}.
	 * @param ctx the parse tree
	 */
	void exitSetElemKeyExpr(NftablesParser.SetElemKeyExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#setElemExprAlloc}.
	 * @param ctx the parse tree
	 */
	void enterSetElemExprAlloc(NftablesParser.SetElemExprAllocContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#setElemExprAlloc}.
	 * @param ctx the parse tree
	 */
	void exitSetElemExprAlloc(NftablesParser.SetElemExprAllocContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#setElemOptions}.
	 * @param ctx the parse tree
	 */
	void enterSetElemOptions(NftablesParser.SetElemOptionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#setElemOptions}.
	 * @param ctx the parse tree
	 */
	void exitSetElemOptions(NftablesParser.SetElemOptionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#setElemOption}.
	 * @param ctx the parse tree
	 */
	void enterSetElemOption(NftablesParser.SetElemOptionContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#setElemOption}.
	 * @param ctx the parse tree
	 */
	void exitSetElemOption(NftablesParser.SetElemOptionContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#setElemExprOptions}.
	 * @param ctx the parse tree
	 */
	void enterSetElemExprOptions(NftablesParser.SetElemExprOptionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#setElemExprOptions}.
	 * @param ctx the parse tree
	 */
	void exitSetElemExprOptions(NftablesParser.SetElemExprOptionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#setElemStmtList}.
	 * @param ctx the parse tree
	 */
	void enterSetElemStmtList(NftablesParser.SetElemStmtListContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#setElemStmtList}.
	 * @param ctx the parse tree
	 */
	void exitSetElemStmtList(NftablesParser.SetElemStmtListContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#setElemStmt}.
	 * @param ctx the parse tree
	 */
	void enterSetElemStmt(NftablesParser.SetElemStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#setElemStmt}.
	 * @param ctx the parse tree
	 */
	void exitSetElemStmt(NftablesParser.SetElemStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#setElemExprOption}.
	 * @param ctx the parse tree
	 */
	void enterSetElemExprOption(NftablesParser.SetElemExprOptionContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#setElemExprOption}.
	 * @param ctx the parse tree
	 */
	void exitSetElemExprOption(NftablesParser.SetElemExprOptionContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#setLhsExpr}.
	 * @param ctx the parse tree
	 */
	void enterSetLhsExpr(NftablesParser.SetLhsExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#setLhsExpr}.
	 * @param ctx the parse tree
	 */
	void exitSetLhsExpr(NftablesParser.SetLhsExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#setRhsExpr}.
	 * @param ctx the parse tree
	 */
	void enterSetRhsExpr(NftablesParser.SetRhsExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#setRhsExpr}.
	 * @param ctx the parse tree
	 */
	void exitSetRhsExpr(NftablesParser.SetRhsExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#initializerExpr}.
	 * @param ctx the parse tree
	 */
	void enterInitializerExpr(NftablesParser.InitializerExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#initializerExpr}.
	 * @param ctx the parse tree
	 */
	void exitInitializerExpr(NftablesParser.InitializerExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#counterConfig}.
	 * @param ctx the parse tree
	 */
	void enterCounterConfig(NftablesParser.CounterConfigContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#counterConfig}.
	 * @param ctx the parse tree
	 */
	void exitCounterConfig(NftablesParser.CounterConfigContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#quotaConfig}.
	 * @param ctx the parse tree
	 */
	void enterQuotaConfig(NftablesParser.QuotaConfigContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#quotaConfig}.
	 * @param ctx the parse tree
	 */
	void exitQuotaConfig(NftablesParser.QuotaConfigContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#secmarkConfig}.
	 * @param ctx the parse tree
	 */
	void enterSecmarkConfig(NftablesParser.SecmarkConfigContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#secmarkConfig}.
	 * @param ctx the parse tree
	 */
	void exitSecmarkConfig(NftablesParser.SecmarkConfigContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#ctObjType}.
	 * @param ctx the parse tree
	 */
	void enterCtObjType(NftablesParser.CtObjTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#ctObjType}.
	 * @param ctx the parse tree
	 */
	void exitCtObjType(NftablesParser.CtObjTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#ctCmdType}.
	 * @param ctx the parse tree
	 */
	void enterCtCmdType(NftablesParser.CtCmdTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#ctCmdType}.
	 * @param ctx the parse tree
	 */
	void exitCtCmdType(NftablesParser.CtCmdTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#ctL4protoname}.
	 * @param ctx the parse tree
	 */
	void enterCtL4protoname(NftablesParser.CtL4protonameContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#ctL4protoname}.
	 * @param ctx the parse tree
	 */
	void exitCtL4protoname(NftablesParser.CtL4protonameContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#ctHelperConfig}.
	 * @param ctx the parse tree
	 */
	void enterCtHelperConfig(NftablesParser.CtHelperConfigContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#ctHelperConfig}.
	 * @param ctx the parse tree
	 */
	void exitCtHelperConfig(NftablesParser.CtHelperConfigContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#timeoutStates}.
	 * @param ctx the parse tree
	 */
	void enterTimeoutStates(NftablesParser.TimeoutStatesContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#timeoutStates}.
	 * @param ctx the parse tree
	 */
	void exitTimeoutStates(NftablesParser.TimeoutStatesContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#timeoutState}.
	 * @param ctx the parse tree
	 */
	void enterTimeoutState(NftablesParser.TimeoutStateContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#timeoutState}.
	 * @param ctx the parse tree
	 */
	void exitTimeoutState(NftablesParser.TimeoutStateContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#ctTimeoutConfig}.
	 * @param ctx the parse tree
	 */
	void enterCtTimeoutConfig(NftablesParser.CtTimeoutConfigContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#ctTimeoutConfig}.
	 * @param ctx the parse tree
	 */
	void exitCtTimeoutConfig(NftablesParser.CtTimeoutConfigContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#ctExpectConfig}.
	 * @param ctx the parse tree
	 */
	void enterCtExpectConfig(NftablesParser.CtExpectConfigContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#ctExpectConfig}.
	 * @param ctx the parse tree
	 */
	void exitCtExpectConfig(NftablesParser.CtExpectConfigContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#limitConfig}.
	 * @param ctx the parse tree
	 */
	void enterLimitConfig(NftablesParser.LimitConfigContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#limitConfig}.
	 * @param ctx the parse tree
	 */
	void exitLimitConfig(NftablesParser.LimitConfigContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#relationalExpr}.
	 * @param ctx the parse tree
	 */
	void enterRelationalExpr(NftablesParser.RelationalExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#relationalExpr}.
	 * @param ctx the parse tree
	 */
	void exitRelationalExpr(NftablesParser.RelationalExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#listRhsExpr}.
	 * @param ctx the parse tree
	 */
	void enterListRhsExpr(NftablesParser.ListRhsExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#listRhsExpr}.
	 * @param ctx the parse tree
	 */
	void exitListRhsExpr(NftablesParser.ListRhsExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#rhsExpr}.
	 * @param ctx the parse tree
	 */
	void enterRhsExpr(NftablesParser.RhsExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#rhsExpr}.
	 * @param ctx the parse tree
	 */
	void exitRhsExpr(NftablesParser.RhsExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#shiftRhsExpr}.
	 * @param ctx the parse tree
	 */
	void enterShiftRhsExpr(NftablesParser.ShiftRhsExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#shiftRhsExpr}.
	 * @param ctx the parse tree
	 */
	void exitShiftRhsExpr(NftablesParser.ShiftRhsExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#andRhsExpr}.
	 * @param ctx the parse tree
	 */
	void enterAndRhsExpr(NftablesParser.AndRhsExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#andRhsExpr}.
	 * @param ctx the parse tree
	 */
	void exitAndRhsExpr(NftablesParser.AndRhsExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#exclusiveOrRhsExpr}.
	 * @param ctx the parse tree
	 */
	void enterExclusiveOrRhsExpr(NftablesParser.ExclusiveOrRhsExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#exclusiveOrRhsExpr}.
	 * @param ctx the parse tree
	 */
	void exitExclusiveOrRhsExpr(NftablesParser.ExclusiveOrRhsExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#inclusiveOrRhsExpr}.
	 * @param ctx the parse tree
	 */
	void enterInclusiveOrRhsExpr(NftablesParser.InclusiveOrRhsExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#inclusiveOrRhsExpr}.
	 * @param ctx the parse tree
	 */
	void exitInclusiveOrRhsExpr(NftablesParser.InclusiveOrRhsExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#basicRhsExpr}.
	 * @param ctx the parse tree
	 */
	void enterBasicRhsExpr(NftablesParser.BasicRhsExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#basicRhsExpr}.
	 * @param ctx the parse tree
	 */
	void exitBasicRhsExpr(NftablesParser.BasicRhsExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#concatRhsExpr}.
	 * @param ctx the parse tree
	 */
	void enterConcatRhsExpr(NftablesParser.ConcatRhsExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#concatRhsExpr}.
	 * @param ctx the parse tree
	 */
	void exitConcatRhsExpr(NftablesParser.ConcatRhsExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#booleanKeys}.
	 * @param ctx the parse tree
	 */
	void enterBooleanKeys(NftablesParser.BooleanKeysContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#booleanKeys}.
	 * @param ctx the parse tree
	 */
	void exitBooleanKeys(NftablesParser.BooleanKeysContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#booleanExpr}.
	 * @param ctx the parse tree
	 */
	void enterBooleanExpr(NftablesParser.BooleanExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#booleanExpr}.
	 * @param ctx the parse tree
	 */
	void exitBooleanExpr(NftablesParser.BooleanExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#keywordExpr}.
	 * @param ctx the parse tree
	 */
	void enterKeywordExpr(NftablesParser.KeywordExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#keywordExpr}.
	 * @param ctx the parse tree
	 */
	void exitKeywordExpr(NftablesParser.KeywordExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#primaryRhsExpr}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryRhsExpr(NftablesParser.PrimaryRhsExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#primaryRhsExpr}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryRhsExpr(NftablesParser.PrimaryRhsExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#relationalOp}.
	 * @param ctx the parse tree
	 */
	void enterRelationalOp(NftablesParser.RelationalOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#relationalOp}.
	 * @param ctx the parse tree
	 */
	void exitRelationalOp(NftablesParser.RelationalOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#verdictExpr}.
	 * @param ctx the parse tree
	 */
	void enterVerdictExpr(NftablesParser.VerdictExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#verdictExpr}.
	 * @param ctx the parse tree
	 */
	void exitVerdictExpr(NftablesParser.VerdictExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#chainExpr}.
	 * @param ctx the parse tree
	 */
	void enterChainExpr(NftablesParser.ChainExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#chainExpr}.
	 * @param ctx the parse tree
	 */
	void exitChainExpr(NftablesParser.ChainExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#metaExpr}.
	 * @param ctx the parse tree
	 */
	void enterMetaExpr(NftablesParser.MetaExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#metaExpr}.
	 * @param ctx the parse tree
	 */
	void exitMetaExpr(NftablesParser.MetaExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#metaKey}.
	 * @param ctx the parse tree
	 */
	void enterMetaKey(NftablesParser.MetaKeyContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#metaKey}.
	 * @param ctx the parse tree
	 */
	void exitMetaKey(NftablesParser.MetaKeyContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#metaKeyQualified}.
	 * @param ctx the parse tree
	 */
	void enterMetaKeyQualified(NftablesParser.MetaKeyQualifiedContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#metaKeyQualified}.
	 * @param ctx the parse tree
	 */
	void exitMetaKeyQualified(NftablesParser.MetaKeyQualifiedContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#metaKeyUnqualified}.
	 * @param ctx the parse tree
	 */
	void enterMetaKeyUnqualified(NftablesParser.MetaKeyUnqualifiedContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#metaKeyUnqualified}.
	 * @param ctx the parse tree
	 */
	void exitMetaKeyUnqualified(NftablesParser.MetaKeyUnqualifiedContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#metaStmt}.
	 * @param ctx the parse tree
	 */
	void enterMetaStmt(NftablesParser.MetaStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#metaStmt}.
	 * @param ctx the parse tree
	 */
	void exitMetaStmt(NftablesParser.MetaStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#socketExpr}.
	 * @param ctx the parse tree
	 */
	void enterSocketExpr(NftablesParser.SocketExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#socketExpr}.
	 * @param ctx the parse tree
	 */
	void exitSocketExpr(NftablesParser.SocketExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#socketKey}.
	 * @param ctx the parse tree
	 */
	void enterSocketKey(NftablesParser.SocketKeyContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#socketKey}.
	 * @param ctx the parse tree
	 */
	void exitSocketKey(NftablesParser.SocketKeyContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#offsetOpt}.
	 * @param ctx the parse tree
	 */
	void enterOffsetOpt(NftablesParser.OffsetOptContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#offsetOpt}.
	 * @param ctx the parse tree
	 */
	void exitOffsetOpt(NftablesParser.OffsetOptContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#numgenType}.
	 * @param ctx the parse tree
	 */
	void enterNumgenType(NftablesParser.NumgenTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#numgenType}.
	 * @param ctx the parse tree
	 */
	void exitNumgenType(NftablesParser.NumgenTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#numgenExpr}.
	 * @param ctx the parse tree
	 */
	void enterNumgenExpr(NftablesParser.NumgenExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#numgenExpr}.
	 * @param ctx the parse tree
	 */
	void exitNumgenExpr(NftablesParser.NumgenExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#xfrmSpnum}.
	 * @param ctx the parse tree
	 */
	void enterXfrmSpnum(NftablesParser.XfrmSpnumContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#xfrmSpnum}.
	 * @param ctx the parse tree
	 */
	void exitXfrmSpnum(NftablesParser.XfrmSpnumContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#xfrmDir}.
	 * @param ctx the parse tree
	 */
	void enterXfrmDir(NftablesParser.XfrmDirContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#xfrmDir}.
	 * @param ctx the parse tree
	 */
	void exitXfrmDir(NftablesParser.XfrmDirContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#xfrmStateKey}.
	 * @param ctx the parse tree
	 */
	void enterXfrmStateKey(NftablesParser.XfrmStateKeyContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#xfrmStateKey}.
	 * @param ctx the parse tree
	 */
	void exitXfrmStateKey(NftablesParser.XfrmStateKeyContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#xfrmStateProtoKey}.
	 * @param ctx the parse tree
	 */
	void enterXfrmStateProtoKey(NftablesParser.XfrmStateProtoKeyContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#xfrmStateProtoKey}.
	 * @param ctx the parse tree
	 */
	void exitXfrmStateProtoKey(NftablesParser.XfrmStateProtoKeyContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#xfrmExpr}.
	 * @param ctx the parse tree
	 */
	void enterXfrmExpr(NftablesParser.XfrmExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#xfrmExpr}.
	 * @param ctx the parse tree
	 */
	void exitXfrmExpr(NftablesParser.XfrmExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#hashExpr}.
	 * @param ctx the parse tree
	 */
	void enterHashExpr(NftablesParser.HashExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#hashExpr}.
	 * @param ctx the parse tree
	 */
	void exitHashExpr(NftablesParser.HashExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#nfKeyProto}.
	 * @param ctx the parse tree
	 */
	void enterNfKeyProto(NftablesParser.NfKeyProtoContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#nfKeyProto}.
	 * @param ctx the parse tree
	 */
	void exitNfKeyProto(NftablesParser.NfKeyProtoContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#rtExpr}.
	 * @param ctx the parse tree
	 */
	void enterRtExpr(NftablesParser.RtExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#rtExpr}.
	 * @param ctx the parse tree
	 */
	void exitRtExpr(NftablesParser.RtExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#rtKey}.
	 * @param ctx the parse tree
	 */
	void enterRtKey(NftablesParser.RtKeyContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#rtKey}.
	 * @param ctx the parse tree
	 */
	void exitRtKey(NftablesParser.RtKeyContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#ctExpr}.
	 * @param ctx the parse tree
	 */
	void enterCtExpr(NftablesParser.CtExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#ctExpr}.
	 * @param ctx the parse tree
	 */
	void exitCtExpr(NftablesParser.CtExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#ctDir}.
	 * @param ctx the parse tree
	 */
	void enterCtDir(NftablesParser.CtDirContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#ctDir}.
	 * @param ctx the parse tree
	 */
	void exitCtDir(NftablesParser.CtDirContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#ctKey}.
	 * @param ctx the parse tree
	 */
	void enterCtKey(NftablesParser.CtKeyContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#ctKey}.
	 * @param ctx the parse tree
	 */
	void exitCtKey(NftablesParser.CtKeyContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#ctKeyDir}.
	 * @param ctx the parse tree
	 */
	void enterCtKeyDir(NftablesParser.CtKeyDirContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#ctKeyDir}.
	 * @param ctx the parse tree
	 */
	void exitCtKeyDir(NftablesParser.CtKeyDirContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#ctKeyProtoField}.
	 * @param ctx the parse tree
	 */
	void enterCtKeyProtoField(NftablesParser.CtKeyProtoFieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#ctKeyProtoField}.
	 * @param ctx the parse tree
	 */
	void exitCtKeyProtoField(NftablesParser.CtKeyProtoFieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#ctKeyDirOptional}.
	 * @param ctx the parse tree
	 */
	void enterCtKeyDirOptional(NftablesParser.CtKeyDirOptionalContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#ctKeyDirOptional}.
	 * @param ctx the parse tree
	 */
	void exitCtKeyDirOptional(NftablesParser.CtKeyDirOptionalContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#symbolStmtExpr}.
	 * @param ctx the parse tree
	 */
	void enterSymbolStmtExpr(NftablesParser.SymbolStmtExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#symbolStmtExpr}.
	 * @param ctx the parse tree
	 */
	void exitSymbolStmtExpr(NftablesParser.SymbolStmtExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#listStmtExpr}.
	 * @param ctx the parse tree
	 */
	void enterListStmtExpr(NftablesParser.ListStmtExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#listStmtExpr}.
	 * @param ctx the parse tree
	 */
	void exitListStmtExpr(NftablesParser.ListStmtExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#ctStmt}.
	 * @param ctx the parse tree
	 */
	void enterCtStmt(NftablesParser.CtStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#ctStmt}.
	 * @param ctx the parse tree
	 */
	void exitCtStmt(NftablesParser.CtStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#payloadStmt}.
	 * @param ctx the parse tree
	 */
	void enterPayloadStmt(NftablesParser.PayloadStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#payloadStmt}.
	 * @param ctx the parse tree
	 */
	void exitPayloadStmt(NftablesParser.PayloadStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#payloadExpr}.
	 * @param ctx the parse tree
	 */
	void enterPayloadExpr(NftablesParser.PayloadExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#payloadExpr}.
	 * @param ctx the parse tree
	 */
	void exitPayloadExpr(NftablesParser.PayloadExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#payloadRawExpr}.
	 * @param ctx the parse tree
	 */
	void enterPayloadRawExpr(NftablesParser.PayloadRawExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#payloadRawExpr}.
	 * @param ctx the parse tree
	 */
	void exitPayloadRawExpr(NftablesParser.PayloadRawExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#payloadBaseSpec}.
	 * @param ctx the parse tree
	 */
	void enterPayloadBaseSpec(NftablesParser.PayloadBaseSpecContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#payloadBaseSpec}.
	 * @param ctx the parse tree
	 */
	void exitPayloadBaseSpec(NftablesParser.PayloadBaseSpecContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#ethHdrExpr}.
	 * @param ctx the parse tree
	 */
	void enterEthHdrExpr(NftablesParser.EthHdrExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#ethHdrExpr}.
	 * @param ctx the parse tree
	 */
	void exitEthHdrExpr(NftablesParser.EthHdrExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#ethHdrField}.
	 * @param ctx the parse tree
	 */
	void enterEthHdrField(NftablesParser.EthHdrFieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#ethHdrField}.
	 * @param ctx the parse tree
	 */
	void exitEthHdrField(NftablesParser.EthHdrFieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#vlanHdrExpr}.
	 * @param ctx the parse tree
	 */
	void enterVlanHdrExpr(NftablesParser.VlanHdrExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#vlanHdrExpr}.
	 * @param ctx the parse tree
	 */
	void exitVlanHdrExpr(NftablesParser.VlanHdrExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#vlanHdrField}.
	 * @param ctx the parse tree
	 */
	void enterVlanHdrField(NftablesParser.VlanHdrFieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#vlanHdrField}.
	 * @param ctx the parse tree
	 */
	void exitVlanHdrField(NftablesParser.VlanHdrFieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#arpHdrExpr}.
	 * @param ctx the parse tree
	 */
	void enterArpHdrExpr(NftablesParser.ArpHdrExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#arpHdrExpr}.
	 * @param ctx the parse tree
	 */
	void exitArpHdrExpr(NftablesParser.ArpHdrExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#arpHdrField}.
	 * @param ctx the parse tree
	 */
	void enterArpHdrField(NftablesParser.ArpHdrFieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#arpHdrField}.
	 * @param ctx the parse tree
	 */
	void exitArpHdrField(NftablesParser.ArpHdrFieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#ipHdrExpr}.
	 * @param ctx the parse tree
	 */
	void enterIpHdrExpr(NftablesParser.IpHdrExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#ipHdrExpr}.
	 * @param ctx the parse tree
	 */
	void exitIpHdrExpr(NftablesParser.IpHdrExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#ipHdrField}.
	 * @param ctx the parse tree
	 */
	void enterIpHdrField(NftablesParser.IpHdrFieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#ipHdrField}.
	 * @param ctx the parse tree
	 */
	void exitIpHdrField(NftablesParser.IpHdrFieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#ipOptionType}.
	 * @param ctx the parse tree
	 */
	void enterIpOptionType(NftablesParser.IpOptionTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#ipOptionType}.
	 * @param ctx the parse tree
	 */
	void exitIpOptionType(NftablesParser.IpOptionTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#ipOptionField}.
	 * @param ctx the parse tree
	 */
	void enterIpOptionField(NftablesParser.IpOptionFieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#ipOptionField}.
	 * @param ctx the parse tree
	 */
	void exitIpOptionField(NftablesParser.IpOptionFieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#icmpHdrExpr}.
	 * @param ctx the parse tree
	 */
	void enterIcmpHdrExpr(NftablesParser.IcmpHdrExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#icmpHdrExpr}.
	 * @param ctx the parse tree
	 */
	void exitIcmpHdrExpr(NftablesParser.IcmpHdrExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#icmpHdrField}.
	 * @param ctx the parse tree
	 */
	void enterIcmpHdrField(NftablesParser.IcmpHdrFieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#icmpHdrField}.
	 * @param ctx the parse tree
	 */
	void exitIcmpHdrField(NftablesParser.IcmpHdrFieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#igmpHdrExpr}.
	 * @param ctx the parse tree
	 */
	void enterIgmpHdrExpr(NftablesParser.IgmpHdrExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#igmpHdrExpr}.
	 * @param ctx the parse tree
	 */
	void exitIgmpHdrExpr(NftablesParser.IgmpHdrExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#igmpHdrField}.
	 * @param ctx the parse tree
	 */
	void enterIgmpHdrField(NftablesParser.IgmpHdrFieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#igmpHdrField}.
	 * @param ctx the parse tree
	 */
	void exitIgmpHdrField(NftablesParser.IgmpHdrFieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#ip6HdrExpr}.
	 * @param ctx the parse tree
	 */
	void enterIp6HdrExpr(NftablesParser.Ip6HdrExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#ip6HdrExpr}.
	 * @param ctx the parse tree
	 */
	void exitIp6HdrExpr(NftablesParser.Ip6HdrExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#ip6HdrField}.
	 * @param ctx the parse tree
	 */
	void enterIp6HdrField(NftablesParser.Ip6HdrFieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#ip6HdrField}.
	 * @param ctx the parse tree
	 */
	void exitIp6HdrField(NftablesParser.Ip6HdrFieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#icmp6HdrExpr}.
	 * @param ctx the parse tree
	 */
	void enterIcmp6HdrExpr(NftablesParser.Icmp6HdrExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#icmp6HdrExpr}.
	 * @param ctx the parse tree
	 */
	void exitIcmp6HdrExpr(NftablesParser.Icmp6HdrExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#icmp6HdrField}.
	 * @param ctx the parse tree
	 */
	void enterIcmp6HdrField(NftablesParser.Icmp6HdrFieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#icmp6HdrField}.
	 * @param ctx the parse tree
	 */
	void exitIcmp6HdrField(NftablesParser.Icmp6HdrFieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#authHdrExpr}.
	 * @param ctx the parse tree
	 */
	void enterAuthHdrExpr(NftablesParser.AuthHdrExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#authHdrExpr}.
	 * @param ctx the parse tree
	 */
	void exitAuthHdrExpr(NftablesParser.AuthHdrExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#authHdrField}.
	 * @param ctx the parse tree
	 */
	void enterAuthHdrField(NftablesParser.AuthHdrFieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#authHdrField}.
	 * @param ctx the parse tree
	 */
	void exitAuthHdrField(NftablesParser.AuthHdrFieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#espHdrExpr}.
	 * @param ctx the parse tree
	 */
	void enterEspHdrExpr(NftablesParser.EspHdrExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#espHdrExpr}.
	 * @param ctx the parse tree
	 */
	void exitEspHdrExpr(NftablesParser.EspHdrExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#espHdrField}.
	 * @param ctx the parse tree
	 */
	void enterEspHdrField(NftablesParser.EspHdrFieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#espHdrField}.
	 * @param ctx the parse tree
	 */
	void exitEspHdrField(NftablesParser.EspHdrFieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#compHdrExpr}.
	 * @param ctx the parse tree
	 */
	void enterCompHdrExpr(NftablesParser.CompHdrExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#compHdrExpr}.
	 * @param ctx the parse tree
	 */
	void exitCompHdrExpr(NftablesParser.CompHdrExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#compHdrField}.
	 * @param ctx the parse tree
	 */
	void enterCompHdrField(NftablesParser.CompHdrFieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#compHdrField}.
	 * @param ctx the parse tree
	 */
	void exitCompHdrField(NftablesParser.CompHdrFieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#udpHdrExpr}.
	 * @param ctx the parse tree
	 */
	void enterUdpHdrExpr(NftablesParser.UdpHdrExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#udpHdrExpr}.
	 * @param ctx the parse tree
	 */
	void exitUdpHdrExpr(NftablesParser.UdpHdrExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#udpHdrField}.
	 * @param ctx the parse tree
	 */
	void enterUdpHdrField(NftablesParser.UdpHdrFieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#udpHdrField}.
	 * @param ctx the parse tree
	 */
	void exitUdpHdrField(NftablesParser.UdpHdrFieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#udpliteHdrExpr}.
	 * @param ctx the parse tree
	 */
	void enterUdpliteHdrExpr(NftablesParser.UdpliteHdrExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#udpliteHdrExpr}.
	 * @param ctx the parse tree
	 */
	void exitUdpliteHdrExpr(NftablesParser.UdpliteHdrExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#udpliteHdrField}.
	 * @param ctx the parse tree
	 */
	void enterUdpliteHdrField(NftablesParser.UdpliteHdrFieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#udpliteHdrField}.
	 * @param ctx the parse tree
	 */
	void exitUdpliteHdrField(NftablesParser.UdpliteHdrFieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#tcpHdrExpr}.
	 * @param ctx the parse tree
	 */
	void enterTcpHdrExpr(NftablesParser.TcpHdrExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#tcpHdrExpr}.
	 * @param ctx the parse tree
	 */
	void exitTcpHdrExpr(NftablesParser.TcpHdrExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#tcpHdrField}.
	 * @param ctx the parse tree
	 */
	void enterTcpHdrField(NftablesParser.TcpHdrFieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#tcpHdrField}.
	 * @param ctx the parse tree
	 */
	void exitTcpHdrField(NftablesParser.TcpHdrFieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#tcpHdrOptionType}.
	 * @param ctx the parse tree
	 */
	void enterTcpHdrOptionType(NftablesParser.TcpHdrOptionTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#tcpHdrOptionType}.
	 * @param ctx the parse tree
	 */
	void exitTcpHdrOptionType(NftablesParser.TcpHdrOptionTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#tcpHdrOptionField}.
	 * @param ctx the parse tree
	 */
	void enterTcpHdrOptionField(NftablesParser.TcpHdrOptionFieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#tcpHdrOptionField}.
	 * @param ctx the parse tree
	 */
	void exitTcpHdrOptionField(NftablesParser.TcpHdrOptionFieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#dccpHdrExpr}.
	 * @param ctx the parse tree
	 */
	void enterDccpHdrExpr(NftablesParser.DccpHdrExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#dccpHdrExpr}.
	 * @param ctx the parse tree
	 */
	void exitDccpHdrExpr(NftablesParser.DccpHdrExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#dccpHdrField}.
	 * @param ctx the parse tree
	 */
	void enterDccpHdrField(NftablesParser.DccpHdrFieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#dccpHdrField}.
	 * @param ctx the parse tree
	 */
	void exitDccpHdrField(NftablesParser.DccpHdrFieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#sctpChunkType}.
	 * @param ctx the parse tree
	 */
	void enterSctpChunkType(NftablesParser.SctpChunkTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#sctpChunkType}.
	 * @param ctx the parse tree
	 */
	void exitSctpChunkType(NftablesParser.SctpChunkTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#sctpChunkCommonField}.
	 * @param ctx the parse tree
	 */
	void enterSctpChunkCommonField(NftablesParser.SctpChunkCommonFieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#sctpChunkCommonField}.
	 * @param ctx the parse tree
	 */
	void exitSctpChunkCommonField(NftablesParser.SctpChunkCommonFieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#sctpChunkDataField}.
	 * @param ctx the parse tree
	 */
	void enterSctpChunkDataField(NftablesParser.SctpChunkDataFieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#sctpChunkDataField}.
	 * @param ctx the parse tree
	 */
	void exitSctpChunkDataField(NftablesParser.SctpChunkDataFieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#sctpChunkInitField}.
	 * @param ctx the parse tree
	 */
	void enterSctpChunkInitField(NftablesParser.SctpChunkInitFieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#sctpChunkInitField}.
	 * @param ctx the parse tree
	 */
	void exitSctpChunkInitField(NftablesParser.SctpChunkInitFieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#sctpChunkSackField}.
	 * @param ctx the parse tree
	 */
	void enterSctpChunkSackField(NftablesParser.SctpChunkSackFieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#sctpChunkSackField}.
	 * @param ctx the parse tree
	 */
	void exitSctpChunkSackField(NftablesParser.SctpChunkSackFieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#sctpChunkAlloc}.
	 * @param ctx the parse tree
	 */
	void enterSctpChunkAlloc(NftablesParser.SctpChunkAllocContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#sctpChunkAlloc}.
	 * @param ctx the parse tree
	 */
	void exitSctpChunkAlloc(NftablesParser.SctpChunkAllocContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#sctpHdrExpr}.
	 * @param ctx the parse tree
	 */
	void enterSctpHdrExpr(NftablesParser.SctpHdrExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#sctpHdrExpr}.
	 * @param ctx the parse tree
	 */
	void exitSctpHdrExpr(NftablesParser.SctpHdrExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#sctpHdrField}.
	 * @param ctx the parse tree
	 */
	void enterSctpHdrField(NftablesParser.SctpHdrFieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#sctpHdrField}.
	 * @param ctx the parse tree
	 */
	void exitSctpHdrField(NftablesParser.SctpHdrFieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#thHdrExpr}.
	 * @param ctx the parse tree
	 */
	void enterThHdrExpr(NftablesParser.ThHdrExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#thHdrExpr}.
	 * @param ctx the parse tree
	 */
	void exitThHdrExpr(NftablesParser.ThHdrExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#thHdrField}.
	 * @param ctx the parse tree
	 */
	void enterThHdrField(NftablesParser.ThHdrFieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#thHdrField}.
	 * @param ctx the parse tree
	 */
	void exitThHdrField(NftablesParser.ThHdrFieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#exthdrExpr}.
	 * @param ctx the parse tree
	 */
	void enterExthdrExpr(NftablesParser.ExthdrExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#exthdrExpr}.
	 * @param ctx the parse tree
	 */
	void exitExthdrExpr(NftablesParser.ExthdrExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#hbhHdrExpr}.
	 * @param ctx the parse tree
	 */
	void enterHbhHdrExpr(NftablesParser.HbhHdrExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#hbhHdrExpr}.
	 * @param ctx the parse tree
	 */
	void exitHbhHdrExpr(NftablesParser.HbhHdrExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#hbhHdrField}.
	 * @param ctx the parse tree
	 */
	void enterHbhHdrField(NftablesParser.HbhHdrFieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#hbhHdrField}.
	 * @param ctx the parse tree
	 */
	void exitHbhHdrField(NftablesParser.HbhHdrFieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#rtHdrExpr}.
	 * @param ctx the parse tree
	 */
	void enterRtHdrExpr(NftablesParser.RtHdrExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#rtHdrExpr}.
	 * @param ctx the parse tree
	 */
	void exitRtHdrExpr(NftablesParser.RtHdrExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#rtHdrField}.
	 * @param ctx the parse tree
	 */
	void enterRtHdrField(NftablesParser.RtHdrFieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#rtHdrField}.
	 * @param ctx the parse tree
	 */
	void exitRtHdrField(NftablesParser.RtHdrFieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#rt0HdrExpr}.
	 * @param ctx the parse tree
	 */
	void enterRt0HdrExpr(NftablesParser.Rt0HdrExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#rt0HdrExpr}.
	 * @param ctx the parse tree
	 */
	void exitRt0HdrExpr(NftablesParser.Rt0HdrExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#rt0HdrField}.
	 * @param ctx the parse tree
	 */
	void enterRt0HdrField(NftablesParser.Rt0HdrFieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#rt0HdrField}.
	 * @param ctx the parse tree
	 */
	void exitRt0HdrField(NftablesParser.Rt0HdrFieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#rt2HdrExpr}.
	 * @param ctx the parse tree
	 */
	void enterRt2HdrExpr(NftablesParser.Rt2HdrExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#rt2HdrExpr}.
	 * @param ctx the parse tree
	 */
	void exitRt2HdrExpr(NftablesParser.Rt2HdrExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#rt2HdrField}.
	 * @param ctx the parse tree
	 */
	void enterRt2HdrField(NftablesParser.Rt2HdrFieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#rt2HdrField}.
	 * @param ctx the parse tree
	 */
	void exitRt2HdrField(NftablesParser.Rt2HdrFieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#rt4HdrExpr}.
	 * @param ctx the parse tree
	 */
	void enterRt4HdrExpr(NftablesParser.Rt4HdrExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#rt4HdrExpr}.
	 * @param ctx the parse tree
	 */
	void exitRt4HdrExpr(NftablesParser.Rt4HdrExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#rt4HdrField}.
	 * @param ctx the parse tree
	 */
	void enterRt4HdrField(NftablesParser.Rt4HdrFieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#rt4HdrField}.
	 * @param ctx the parse tree
	 */
	void exitRt4HdrField(NftablesParser.Rt4HdrFieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#fragHdrExpr}.
	 * @param ctx the parse tree
	 */
	void enterFragHdrExpr(NftablesParser.FragHdrExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#fragHdrExpr}.
	 * @param ctx the parse tree
	 */
	void exitFragHdrExpr(NftablesParser.FragHdrExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#fragHdrField}.
	 * @param ctx the parse tree
	 */
	void enterFragHdrField(NftablesParser.FragHdrFieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#fragHdrField}.
	 * @param ctx the parse tree
	 */
	void exitFragHdrField(NftablesParser.FragHdrFieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#dstHdrExpr}.
	 * @param ctx the parse tree
	 */
	void enterDstHdrExpr(NftablesParser.DstHdrExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#dstHdrExpr}.
	 * @param ctx the parse tree
	 */
	void exitDstHdrExpr(NftablesParser.DstHdrExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#dstHdrField}.
	 * @param ctx the parse tree
	 */
	void enterDstHdrField(NftablesParser.DstHdrFieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#dstHdrField}.
	 * @param ctx the parse tree
	 */
	void exitDstHdrField(NftablesParser.DstHdrFieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#mhHdrExpr}.
	 * @param ctx the parse tree
	 */
	void enterMhHdrExpr(NftablesParser.MhHdrExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#mhHdrExpr}.
	 * @param ctx the parse tree
	 */
	void exitMhHdrExpr(NftablesParser.MhHdrExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#mhHdrField}.
	 * @param ctx the parse tree
	 */
	void enterMhHdrField(NftablesParser.MhHdrFieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#mhHdrField}.
	 * @param ctx the parse tree
	 */
	void exitMhHdrField(NftablesParser.MhHdrFieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#exthdrExistsExpr}.
	 * @param ctx the parse tree
	 */
	void enterExthdrExistsExpr(NftablesParser.ExthdrExistsExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#exthdrExistsExpr}.
	 * @param ctx the parse tree
	 */
	void exitExthdrExistsExpr(NftablesParser.ExthdrExistsExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link NftablesParser#exthdrKey}.
	 * @param ctx the parse tree
	 */
	void enterExthdrKey(NftablesParser.ExthdrKeyContext ctx);
	/**
	 * Exit a parse tree produced by {@link NftablesParser#exthdrKey}.
	 * @param ctx the parse tree
	 */
	void exitExthdrKey(NftablesParser.ExthdrKeyContext ctx);
}