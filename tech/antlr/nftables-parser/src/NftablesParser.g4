// Based on the http://git.netfilter.org/nftables/tree/src/parser_bison.y

parser grammar NftablesParser;

options { tokenVocab = NftablesLexer; }

@members {
    private void closeScopeArp() {}
    private void closeScopeCt() {}
    private void closeScopeCounter() {}
    private void closeScopeEth() {}
    private void closeScopeFib() {}
    private void closeScopeHash() {}
    private void closeScopeIp() {}
    private void closeScopeIp6() {}
    private void closeScopeVlan() {}
    private void closeScopeIpsec() {}
    private void closeScopeList() {}
    private void closeScopeLimit() {}
    private void closeScopeNumgen() {}
    private void closeScopeQuota() {}
    private void closeScopeQueue() {}
    private void closeScopeRt() {}
    private void closeScopeSctp() {}
    private void closeScopeSctpChunk() {}
    private void closeScopeSecmark() {}
    private void closeScopeSocket() {}
    private void closeScopeLog() {}
}

program: line* EOF;

stmtSeparator: NEWLINE
    | SEMICOLON;

optNewline: NEWLINE?;

commonBlock: INCLUDE QUOTED_STRING stmtSeparator
    | DEFINE identifier '=' initializerExpr stmtSeparator
    | REDEFINE identifier '=' initializerExpr stmtSeparator
    | UNDEFINE identifier stmtSeparator;
    //| error stmtSeparator; <-- this is error recovery for missing stmtSepartor?

line: commonBlock
    | stmtSeparator
    | baseCmd stmtSeparator?;

baseCmd: addCmd
    | ADD addCmd
    | REPLACE replaceCmd
    | CREATE createCmd
    | INSERT insertCmd
    | DELETE deleteCmd
    | GET getCmd
    | LIST listCmd { closeScopeList(); }
    | RESET resetCmd
    | FLUSH flushCmd
    | RENAME renameCmd
    | IMPORT importCmd
    | EXPORT exportCmd
    | MONITOR monitorCmd
    | DESCRIBE describeCmd;

addCmd: TABLE tableSpec
    | TABLE tableSpec /*tableBlockAlloc*/ '{' tableBlock* '}'
    | CHAIN chainSpec
    | CHAIN chainSpec /*chainBlockAlloc*/ '{' chainBlock* '}'
    | RULE rulePosition ruleSpec
    | /* empty */ rulePosition ruleSpec
    | SET setSpec /*setBlockAlloc*/ '{' setBlock* '}'
    | MAP setSpec /*mapBlockAlloc*/ '{' mapBlock* '}'
    | ELEMENT setSpec setBlockExpr
    | FLOWTABLE flowtableSpec /*flowtableBlockAlloc*/ '{' flowtableBlock* '}'
    | COUNTER objSpec { closeScopeCounter(); }
    | COUNTER objSpec /*counterObj*/ counterConfig { closeScopeCounter(); }
    | COUNTER objSpec /*counterObj*/ '{' counterBlock* '}' { closeScopeCounter(); }
    | QUOTA objSpec /*quotaObj*/ quotaConfig { closeScopeQuota(); }
    | QUOTA objSpec /*quotaObj*/ '{' quotaBlock* '}' { closeScopeQuota(); }
    | CT HELPER objSpec /*ctObjAlloc*/ '{' ctHelperBlock* '}' { closeScopeCt(); }
    | CT TIMEOUT objSpec /*ctObjAlloc*/ '{' ctTimeoutBlock* '}' { closeScopeCt(); }
    | CT EXPECTATION objSpec /*ctObjAlloc*/ '{' ctExpectBlock* '}' { closeScopeCt(); }
    | LIMIT objSpec /*limitObj*/ limitConfig { closeScopeLimit(); }
    | LIMIT objSpec /*limitObj*/ '{' limitBlock* '}' { closeScopeLimit(); }
    | SECMARK objSpec /*secmarkObj*/ secmarkConfig { closeScopeSecmark(); }
    | SECMARK objSpec /*secmarkObj*/ '{' secmarkBlock* '}' { closeScopeSecmark(); }
    | SYNPROXY objSpec /*synproxyObj*/ synproxyConfig
    | SYNPROXY objSpec /*synproxyObj*/ '{' synproxyBlock* '}';

replaceCmd: RULE ruleidSpec ruleSpec;

createCmd: TABLE tableSpec
    | TABLE tableSpec /*tableBlockAlloc*/ '{' tableBlock* '}'
    | CHAIN chainSpec
    | CHAIN chainSpec /*chainBlockAlloc*/ '{' chainBlock* '}'
    | SET setSpec /*setBlockAlloc*/ '{' setBlock* '}'
    | MAP setSpec /*mapBlockAlloc*/ '{' mapBlock* '}'
    | ELEMENT setSpec setBlockExpr
    | FLOWTABLE flowtableSpec /*flowtableBlockAlloc*/ '{' flowtableBlock* '}'
    | COUNTER objSpec { closeScopeCounter(); }
    | COUNTER objSpec /*counterObj*/ counterConfig { closeScopeCounter(); }
    | QUOTA objSpec /*quotaObj*/ quotaConfig { closeScopeQuota(); }
    | CT HELPER objSpec /*ctObjAlloc*/ '{' ctHelperBlock* '}' { closeScopeCt(); }
    | CT TIMEOUT objSpec /*ctObjAlloc*/ '{' ctTimeoutBlock* '}' { closeScopeCt(); }
    | CT EXPECTATION objSpec /*ctObjAlloc*/ '{' ctExpectBlock* '}' { closeScopeCt(); }
    | LIMIT objSpec /*limitObj*/ limitConfig { closeScopeLimit(); }
    | SECMARK objSpec /*secmarkObj*/ secmarkConfig { closeScopeSecmark(); }
    | SYNPROXY objSpec /*synproxyObj*/ synproxyConfig;

insertCmd: RULE rulePosition ruleSpec;

tableOrIdSpec: tableSpec
    | tableidSpec;

chainOrIdSpec: chainSpec
    | chainidSpec;

setOrIdSpec: setSpec
    | setidSpec;

objOrIdSpec: objSpec
    | objidSpec;

deleteCmd: TABLE tableOrIdSpec
    | CHAIN chainOrIdSpec
    | RULE ruleidSpec
    | SET setOrIdSpec
    | MAP setSpec
    | ELEMENT setSpec setBlockExpr
    | FLOWTABLE flowtableSpec
    | FLOWTABLE flowtableidSpec
    | FLOWTABLE flowtableSpec /*flowtableBlockAlloc*/ '{' flowtableBlock* '}'
    | COUNTER objOrIdSpec { closeScopeCounter(); }
    | QUOTA objOrIdSpec { closeScopeQuota(); }
    | CT ctObjType objSpec /*ctObjAlloc*/ { closeScopeCt(); }
    | LIMIT objOrIdSpec { closeScopeLimit(); }
    | SECMARK objOrIdSpec { closeScopeSecmark(); }
    | SYNPROXY objOrIdSpec;

getCmd: ELEMENT setSpec setBlockExpr;

listCmd: TABLE tableSpec
    | TABLES rulesetSpec
    | CHAIN chainSpec
    | CHAINS rulesetSpec
    | SETS rulesetSpec
    | SETS TABLE tableSpec
    | SET setSpec
    | COUNTERS rulesetSpec
    | COUNTERS TABLE tableSpec
    | COUNTER objSpec { closeScopeCounter(); }
    | QUOTAS rulesetSpec
    | QUOTAS TABLE tableSpec
    | QUOTA objSpec { closeScopeQuota(); }
    | LIMITS rulesetSpec
    | LIMITS TABLE tableSpec
    | LIMIT objSpec { closeScopeLimit(); }
    | SECMARKS rulesetSpec
    | SECMARKS TABLE tableSpec
    | SECMARK objSpec { closeScopeSecmark(); }
    | SYNPROXYS rulesetSpec
    | SYNPROXYS TABLE tableSpec
    | SYNPROXY objSpec
    | RULESET rulesetSpec
    | FLOW TABLES rulesetSpec
    | FLOW TABLE setSpec
    | METERS rulesetSpec
    | METER setSpec
    | FLOWTABLES rulesetSpec
    | FLOWTABLE flowtableSpec
    | MAPS rulesetSpec
    | MAP setSpec
    | CT ctObjType objSpec { closeScopeCt(); }
    | CT ctCmdType TABLE tableSpec { closeScopeCt(); }
    | HOOKS basehookSpec;

basehookDeviceName: DEVICE STRING;

basehookSpec: rulesetSpec basehookDeviceName?;

resetCmd: COUNTERS rulesetSpec
    | COUNTERS TABLE tableSpec
    | COUNTER objSpec { closeScopeCounter(); }
    | QUOTAS rulesetSpec
    | QUOTAS TABLE tableSpec
    | QUOTA objSpec { closeScopeQuota(); };

flushCmd: TABLE tableSpec
    | CHAIN chainSpec
    | SET setSpec
    | MAP setSpec
    | FLOW TABLE setSpec
    | METER setSpec
    | RULESET rulesetSpec;

renameCmd: CHAIN chainSpec identifier;

importCmd: RULESET markupFormat
    | markupFormat;

exportCmd: RULESET markupFormat
    | markupFormat;

monitorCmd: monitorEvent monitorObject monitorFormat;

monitorEvent: STRING?;

monitorObject: (TABLES
    | CHAINS
    | SETS
    | RULES
    | ELEMENTS
    | RULESET
    | TRACE)?;

monitorFormat: markupFormat?;

markupFormat: XML
    | JSON
    | VM JSON;

describeCmd: primaryExpr;

//tableBlockAlloc: /* empty */;

tableOptions: FLAGS STRING
    | commentSpec;

tableBlock: commonBlock
    | stmtSeparator
    | tableOptions stmtSeparator
    | CHAIN chainIdentifier /*chainBlockAlloc*/ '{' chainBlock* '}' stmtSeparator
    | SET setIdentifier /*setBlockAlloc*/ '{' setBlock* '}' stmtSeparator
    | MAP setIdentifier /*mapBlockAlloc*/ '{' mapBlock* '}' stmtSeparator
    | FLOWTABLE flowtableIdentifier /*flowtableBlockAlloc*/ '{' flowtableBlock* '}' stmtSeparator
    | COUNTER objIdentifier /*objBlockAlloc*/ '{' counterBlock* '}' stmtSeparator { closeScopeCounter(); }
    | QUOTA objIdentifier /*objBlockAlloc*/ '{' quotaBlock* '}' stmtSeparator { closeScopeQuota(); }
    | CT HELPER objIdentifier /*objBlockAlloc*/ '{' ctHelperBlock* '}' { closeScopeCt(); } stmtSeparator
    | CT TIMEOUT objIdentifier /*objBlockAlloc */'{' ctTimeoutBlock* '}' { closeScopeCt(); } stmtSeparator
    | CT EXPECTATION objIdentifier /*objBlockAlloc*/ '{' ctExpectBlock* '}' { closeScopeCt(); } stmtSeparator
    | LIMIT objIdentifier /*objBlockAlloc*/ '{' limitBlock* '}' stmtSeparator { closeScopeLimit(); }
    | SECMARK objIdentifier /*objBlockAlloc*/ '{' secmarkBlock* '}' stmtSeparator { closeScopeSecmark(); }
    | SYNPROXY objIdentifier /*objBlockAlloc*/ '{' synproxyBlock* '}' stmtSeparator;

//chainBlockAlloc: /* empty */;

chainBlock: commonBlock
    | stmtSeparator
    | hookSpec stmtSeparator
    | policySpec stmtSeparator
    | flagsSpec stmtSeparator
    | ruleSpec stmtSeparator
    | commentSpec stmtSeparator;

subchainBlock: ruleSpec? stmtSeparator;

typeofDataExpr: primaryExpr
    | typeofExpr DOT primaryExpr;

typeofExpr: primaryExpr
    | typeofExpr DOT primaryExpr;

//setBlockAlloc: /* empty */;

setBlock: commonBlock
    | stmtSeparator
    | TYPE dataTypeExpr stmtSeparator
    | TYPEOF typeofExpr stmtSeparator
    | FLAGS setFlagList stmtSeparator
    | TIMEOUT timeSpec stmtSeparator
    | GC_INTERVAL timeSpec stmtSeparator
    | statefulStmtList stmtSeparator
    | ELEMENTS '=' setBlockExpr
    | AUTOMERGE
    | setMechanism stmtSeparator
    | commentSpec stmtSeparator;

setBlockExpr: setExpr
    | variableExpr;

setFlagList: setFlagList COMMA setFlag
    | setFlag;

setFlag: CONSTANT
    | INTERVAL
    | TIMEOUT
    | DYNAMIC;

//mapBlockAlloc: /* empty */;

mapBlockObjType: COUNTER { closeScopeCounter(); }
    | QUOTA { closeScopeQuota(); }
    | LIMIT { closeScopeLimit(); }
    | SECMARK { closeScopeSecmark(); };

mapBlock: commonBlock
    | stmtSeparator
    | TIMEOUT timeSpec stmtSeparator
    | TYPE dataTypeExpr COLON dataTypeExpr stmtSeparator
    | TYPE dataTypeExpr COLON INTERVAL dataTypeExpr stmtSeparator
    | TYPEOF typeofExpr COLON typeofDataExpr stmtSeparator
    | TYPEOF typeofExpr COLON INTERVAL typeofExpr stmtSeparator
    | TYPE dataTypeExpr COLON mapBlockObjType stmtSeparator
    | FLAGS setFlagList stmtSeparator
    | statefulStmtList stmtSeparator
    | ELEMENTS '=' setBlockExpr
    | commentSpec stmtSeparator
    | setMechanism stmtSeparator;

setMechanism: POLICY setPolicySpec
    | SIZE NUM;

setPolicySpec: PERFORMANCE
    | MEMORY;

//flowtableBlockAlloc: /* empty */;

flowtableBlock: commonBlock
    | stmtSeparator
    | HOOK STRING prioSpec stmtSeparator
    | DEVICES '=' flowtableExpr stmtSeparator
    | COUNTER { closeScopeCounter(); }
    | FLAGS OFFLOAD stmtSeparator;

flowtableExpr: '{' flowtableListExpr '}'
    | variableExpr;

flowtableListExpr: flowtableExprMember
    | flowtableListExpr COMMA flowtableExprMember
    | flowtableListExpr COMMA optNewline;

flowtableExprMember: STRING
    | variableExpr;

dataTypeAtomExpr: typeIdentifier
    | TIME;

dataTypeExpr: dataTypeAtomExpr
    | dataTypeExpr DOT dataTypeAtomExpr;

//objBlockAlloc: /* empty */;

counterBlock: commonBlock
    | stmtSeparator
    | counterConfig
    | commentSpec;

quotaBlock: commonBlock
    | stmtSeparator
    | quotaConfig
    | commentSpec;

ctHelperBlock: commonBlock
    | stmtSeparator
    | ctHelperConfig
    | commentSpec;

ctTimeoutBlock: commonBlock
    | stmtSeparator
    | ctTimeoutConfig
    | commentSpec;

ctExpectBlock: commonBlock
    | stmtSeparator
    | ctExpectConfig
    | commentSpec;

limitBlock: commonBlock
    | stmtSeparator
    | limitConfig
    | commentSpec;

secmarkBlock: commonBlock
    | stmtSeparator
    | secmarkConfig
    | commentSpec;

synproxyBlock: commonBlock
    | stmtSeparator
    | synproxyConfig
    | commentSpec;

typeIdentifier: STRING
    | MARK
    | DSCP
    | ECN
    | CLASSID;

hookSpec: TYPE STRING HOOK STRING devSpec? prioSpec;

prioSpec: PRIORITY extendedPrioSpec;

extendedPrioName: OUT
    | STRING;

extendedPrioSpec: intNum
    | variableExpr
    | extendedPrioName
    | extendedPrioName PLUS NUM
    | extendedPrioName DASH NUM;

intNum: NUM
    | DASH NUM;

devSpec: DEVICE string
    | DEVICE variableExpr
    | DEVICES '=' flowtableExpr;

flagsSpec: FLAGS OFFLOAD;

policySpec: POLICY policyExpr;

policyExpr: variableExpr
    | chainPolicy;

chainPolicy: ACCEPT
    | DROP;

identifier: STRING;

string: STRING
    | QUOTED_STRING
    | ASTERISK_STRING;

timeSpec: STRING;

familySpec: familySpecExplicit?;

familySpecExplicit: IP { closeScopeIp(); }
    | IP6 { closeScopeIp6(); }
    | INET
    | ARP { closeScopeArp(); }
    | BRIDGE
    | NETDEV;

tableSpec: familySpec identifier;

tableidSpec: familySpec HANDLE NUM;

chainSpec: tableSpec identifier;

chainidSpec: tableSpec HANDLE NUM;

chainIdentifier: identifier;

setSpec: tableSpec identifier;

setidSpec: tableSpec HANDLE NUM;

setIdentifier: identifier;

flowtableSpec: tableSpec identifier;

flowtableidSpec: tableSpec HANDLE NUM;

flowtableIdentifier: identifier;

objSpec: tableSpec identifier;

objidSpec: tableSpec HANDLE NUM;

objIdentifier: identifier;

handleSpec: HANDLE NUM;

positionSpec: POSITION NUM;

indexSpec: INDEX NUM;

rulePosition: chainSpec (positionSpec | handleSpec | indexSpec)?;

ruleidSpec: chainSpec handleSpec;

commentSpec: COMMENT string;

rulesetSpec: familySpecExplicit?;

// rule
ruleSpec: ruleAlloc commentSpec?;

ruleAlloc: stmtList;

stmtList: stmt+;

statefulStmtList: statefulStmt
    | statefulStmtList statefulStmt;

statefulStmt: counterStmt { closeScopeCounter(); }
    | limitStmt
    | quotaStmt
    | connlimitStmt;

stmt: verdictStmt
    | matchStmt
    | meterStmt
    | payloadStmt
    | statefulStmt
    | metaStmt
    | logStmt { closeScopeLog(); }
    | rejectStmt
    | natStmt
    | tproxyStmt
    | queueStmt
    | ctStmt
    | masqStmt
    | redirStmt
    | dupStmt
    | fwdStmt
    | setStmt
    | mapStmt
    | synproxyStmt
    | chainStmt;

chainStmtType: JUMP
    | GOTO;

chainStmt: chainStmtType /*chainBlockAlloc*/ '{' subchainBlock* '}';

verdictStmt: verdictExpr
    | verdictMapStmt;

verdictMapStmt: concatExpr VMAP verdictMapExpr;

verdictMapExpr: '{' verdictMapListExpr '}'
    | setRefExpr;

verdictMapListExpr: verdictMapListMemberExpr
    | verdictMapListExpr COMMA verdictMapListMemberExpr
    | verdictMapListExpr COMMA optNewline;

verdictMapListMemberExpr: optNewline setElemExpr COLON verdictExpr optNewline;

connlimitStmt: CT COUNT NUM { closeScopeCt(); }
    | CT COUNT OVER NUM { closeScopeCt(); };

counterStmt: counterStmtAlloc
    | counterStmtAlloc counterArgs;

counterStmtAlloc: COUNTER
    | COUNTER NAME stmtExpr;

counterArgs: counterArg
    | counterArgs counterArg;

counterArg: PACKETS NUM
    | BYTES NUM;

logStmt: logStmtAlloc logArgs?;

logStmtAlloc: LOG;

logArgs: logArg
    | logArgs logArg;

logArg: PREFIX string
    | GROUP NUM
    | SNAPLEN NUM
    | QUEUE_THRESHOLD NUM
    | LEVEL levelType
    | FLAGS logFlags;

levelType: string;

logFlags: TCP logFlagsTcp
    | IP OPTIONS { closeScopeIp(); }
    | SKUID
    | ETHER { closeScopeEth(); }
    | ALL;

logFlagsTcp: logFlagsTcp COMMA logFlagTcp
    | logFlagTcp;

logFlagTcp: SEQUENCE
    | OPTIONS;

limitStmt: LIMIT RATE limitMode NUM SLASH timeUnit limitBurstPkts { closeScopeLimit(); }
    | LIMIT RATE limitMode NUM STRING limitBurstBytes { closeScopeLimit(); }
    | LIMIT NAME stmtExpr { closeScopeLimit(); };

quotaMode: (OVER | UNTIL)?;

quotaUnit: BYTES
    | STRING;

quotaUsed: (USED NUM quotaUnit)?;

quotaStmt: QUOTA quotaMode NUM quotaUnit quotaUsed { closeScopeQuota(); }
    | QUOTA NAME stmtExpr { closeScopeQuota(); };

limitMode: (OVER | UNTIL)?;

limitBurstPkts: BURST NUM PACKETS?;

limitBurstBytes: (BURST NUM BYTES | BURST NUM STRING)?;

timeUnit: SECOND
    | MINUTE
    | HOUR
    | DAY
    | WEEK;

rejectStmt: rejectStmtAlloc rejectOpts;

rejectStmtAlloc: REJECT;

rejectWithExpr: STRING | integerExpr;

rejectOpts: (
    WITH ICMP TYPE rejectWithExpr
    | WITH ICMP6 TYPE rejectWithExpr
    | WITH ICMPX TYPE rejectWithExpr
    | WITH TCP RESET
    )?;

natStmt: natStmtAlloc natStmtArgs;

natStmtAlloc: SNAT
    | DNAT;

tproxyStmt: TPROXY TO stmtExpr
    | TPROXY nfKeyProto TO stmtExpr
    | TPROXY TO COLON stmtExpr
    | TPROXY TO stmtExpr COLON stmtExpr
    | TPROXY nfKeyProto TO stmtExpr COLON stmtExpr
    | TPROXY nfKeyProto TO COLON stmtExpr;

synproxyStmt: synproxyStmtAlloc synproxyArgs?;

synproxyStmtAlloc: SYNPROXY
    | SYNPROXY NAME stmtExpr;

synproxyArgs: synproxyArg
    | synproxyArgs synproxyArg;

synproxyArg: MSS NUM
    | WSCALE NUM
    | TIMESTAMP
    | SACK_PERM;

synproxyConfig: MSS NUM WSCALE NUM synproxyTs synproxySack
    | MSS NUM stmtSeparator WSCALE NUM stmtSeparator synproxyTs synproxySack;

//synproxyObj: /* empty */;

synproxyTs: TIMESTAMP?;

synproxySack: SACK_PERM?;

primaryStmtExpr: symbolExpr
    | integerExpr
    | booleanExpr
    | metaExpr
    | rtExpr
    | ctExpr
    | numgenExpr
    | hashExpr
    | payloadExpr
    | keywordExpr
    | socketExpr
    | osfExpr
    | '(' basicStmtExpr ')';

shiftStmtExpr: primaryStmtExpr
    | shiftStmtExpr LSHIFT primaryStmtExpr
    | shiftStmtExpr RSHIFT primaryStmtExpr;

andStmtExpr: shiftStmtExpr
    | andStmtExpr AMPERSAND shiftStmtExpr;

exclusiveOrStmtExpr: andStmtExpr
    | exclusiveOrStmtExpr CARET andStmtExpr;

inclusiveOrStmtExpr: exclusiveOrStmtExpr
    | inclusiveOrStmtExpr OR exclusiveOrStmtExpr;

basicStmtExpr: inclusiveOrStmtExpr;

concatStmtExpr: basicStmtExpr
    | concatStmtExpr DOT primaryStmtExpr;

mapStmtExprSet: setExpr
    | setRefExpr;

mapStmtExpr: concatStmtExpr (MAP mapStmtExprSet)?;

prefixStmtExpr: basicStmtExpr SLASH NUM;

rangeStmtExpr: basicStmtExpr DASH basicStmtExpr;

multitonStmtExpr: prefixStmtExpr
    | rangeStmtExpr;

stmtExpr: mapStmtExpr
    | multitonStmtExpr
    | listStmtExpr;

natStmtArgs: stmtExpr
    | TO stmtExpr
    | nfKeyProto TO stmtExpr
    | stmtExpr COLON stmtExpr
    | TO stmtExpr COLON stmtExpr
    | nfKeyProto TO stmtExpr COLON stmtExpr
    | COLON stmtExpr
    | TO COLON stmtExpr
    | natStmtArgs nfNatFlags
    | nfKeyProto ADDR DOT PORT TO stmtExpr
    | nfKeyProto INTERVAL TO stmtExpr
    | INTERVAL TO stmtExpr
    | nfKeyProto PREFIX TO stmtExpr
    | PREFIX TO stmtExpr;

masqStmt: masqStmtAlloc masqStmtArgs
    | masqStmtAlloc;

masqStmtAlloc: MASQUERADE;

masqStmtArgs: TO COLON stmtExpr
    | TO COLON stmtExpr nfNatFlags
    | nfNatFlags;

redirStmt: redirStmtAlloc redirStmtArg
    | redirStmtAlloc;

redirStmtAlloc: REDIRECT;

redirStmtArg: TO stmtExpr
    | TO COLON stmtExpr
    | nfNatFlags
    | TO stmtExpr nfNatFlags
    | TO COLON stmtExpr nfNatFlags;

dupStmt: DUP TO stmtExpr
    | DUP TO stmtExpr DEVICE stmtExpr;

fwdStmt: FWD TO stmtExpr
    | FWD nfKeyProto TO stmtExpr DEVICE stmtExpr;

nfNatFlags: nfNatFlag
    | nfNatFlags COMMA nfNatFlag;

nfNatFlag: RANDOM
    | FULLY_RANDOM
    | PERSISTENT;

queueStmt: queueStmtCompat { closeScopeQueue(); }
    | QUEUE TO queueStmtExpr { closeScopeQueue(); }
    | QUEUE FLAGS queueStmtFlags TO queueStmtExpr { closeScopeQueue(); }
    | QUEUE FLAGS queueStmtFlags QUEUENUM queueStmtExprSimple { closeScopeQueue(); };

queueStmtCompat: queueStmtAlloc
    | queueStmtAlloc queueStmtArgs;

queueStmtAlloc: QUEUE;

queueStmtArgs: queueStmtArg
    | queueStmtArgs queueStmtArg;

queueStmtArg: QUEUENUM queueStmtExprSimple
    | queueStmtFlags;

queueExpr: variableExpr
    | integerExpr;

queueStmtExprSimple: integerExpr
    | variableExpr
    | queueExpr DASH queueExpr;

queueStmtExpr: numgenExpr
    | hashExpr
    | mapExpr
    | queueStmtExprSimple;

queueStmtFlags: queueStmtFlag
    | queueStmtFlags COMMA queueStmtFlag;

queueStmtFlag: BYPASS
    | FANOUT;

setElemExprStmt: setElemExprStmtAlloc
    | setElemExprStmtAlloc setElemOptions;

setElemExprStmtAlloc: concatExpr;

setStmt: SET setStmtOp setElemExprStmt setRefExpr
    | setStmtOp setRefExpr '{' setElemExprStmt '}'
    | setStmtOp setRefExpr '{' setElemExprStmt statefulStmtList '}';

setStmtOp: ADD
    | UPDATE
    | DELETE;

mapStmt: setStmtOp setRefExpr '{' setElemExprStmt COLON setElemExprStmt '}'
    | setStmtOp setRefExpr '{' setElemExprStmt statefulStmtList COLON setElemExprStmt '}';

meterStmt: flowStmtLegacyAlloc flowStmtOpts '{' meterKeyExpr stmt '}'
    | meterStmtAlloc;

flowStmtLegacyAlloc: FLOW;

flowStmtOpts: flowStmtOpt
    | flowStmtOpts flowStmtOpt;

flowStmtOpt: TABLE identifier;

meterStmtAlloc: METER identifier '{' meterKeyExpr stmt '}'
    | METER identifier SIZE NUM '{' meterKeyExpr stmt '}';

matchStmt: relationalExpr;

variableExpr: '$' identifier;

symbolExpr: variableExpr
    | string;

setRefExpr: setRefSymbolExpr
    | variableExpr;

setRefSymbolExpr: AT identifier;

integerExpr: NUM;

primaryExpr: symbolExpr
    | integerExpr
    | payloadExpr
    | exthdrExpr
    | exthdrExistsExpr
    | metaExpr
    | socketExpr
    | rtExpr
    | ctExpr
    | numgenExpr
    | hashExpr
    | fibExpr
    | osfExpr
    | xfrmExpr
    | '(' basicExpr ')';

fibExpr: FIB fibTuple fibResult { closeScopeFib(); };

fibResult: OIF
    | OIFNAME
    | TYPE;

fibFlag: SADDR
    | DADDR
    | MARK
    | IIF
    | OIF;

fibTuple: fibFlag DOT fibTuple
    | fibFlag;

osfExpr: OSF osfTtl? HDRVERSION
    | OSF osfTtl? NAME;

osfTtl: TTL STRING;

shiftExpr: primaryExpr
    | shiftExpr LSHIFT primaryRhsExpr
    | shiftExpr RSHIFT primaryRhsExpr;

andExpr: shiftExpr
    | andExpr AMPERSAND shiftRhsExpr;

exclusiveOrExpr: andExpr
    | exclusiveOrExpr CARET andRhsExpr;

inclusiveOrExpr: exclusiveOrExpr
    | inclusiveOrExpr OR exclusiveOrRhsExpr;

basicExpr: inclusiveOrExpr;

concatExpr: basicExpr
    | concatExpr DOT basicExpr;

prefixRhsExpr: basicRhsExpr SLASH NUM;

rangeRhsExpr: basicRhsExpr DASH basicRhsExpr;

multitonRhsExpr: prefixRhsExpr
    | rangeRhsExpr;

mapExpr: concatExpr MAP rhsExpr;

expr: concatExpr
    | setExpr
    | mapExpr;

setExpr: '{' setListExpr '}';

setListExpr: setListMemberExpr
    | setListExpr COMMA setListMemberExpr
    | setListExpr COMMA optNewline;

setListMemberExpr: optNewline setExpr optNewline
    | optNewline setElemExpr optNewline
    | optNewline setElemExpr COLON setRhsExpr optNewline;

meterKeyExpr: meterKeyExprAlloc
    | meterKeyExprAlloc setElemOptions;

meterKeyExprAlloc: concatExpr;

setElemExpr: setElemExprAlloc setElemExprOptions?;

setElemKeyExpr: setLhsExpr
    | ASTERISK;

setElemExprAlloc: setElemKeyExpr setElemStmtList
    | setElemKeyExpr;

setElemOptions: setElemOption
    | setElemOptions setElemOption;

setElemOption: TIMEOUT timeSpec
    | EXPIRES timeSpec
    | commentSpec;

setElemExprOptions: setElemExprOption
    | setElemExprOptions setElemExprOption;

setElemStmtList: setElemStmt
    | setElemStmtList setElemStmt;

setElemStmt: COUNTER { closeScopeCounter(); }
    | COUNTER PACKETS NUM BYTES NUM { closeScopeCounter(); }
    | LIMIT RATE limitMode NUM SLASH timeUnit limitBurstPkts { closeScopeLimit(); }
    | LIMIT RATE limitMode NUM STRING limitBurstBytes { closeScopeLimit(); }
    | CT COUNT NUM { closeScopeCt(); }
    | CT COUNT OVER NUM { closeScopeCt(); };

setElemExprOption: TIMEOUT timeSpec
    | EXPIRES timeSpec
    | commentSpec;

setLhsExpr: concatRhsExpr;

setRhsExpr: concatRhsExpr
    | verdictExpr;

initializerExpr: rhsExpr
    | listRhsExpr
    | '{' '}'
    | DASH NUM;

counterConfig: PACKETS NUM BYTES NUM;

//counterObj: /* empty */;

quotaConfig: quotaMode NUM quotaUnit quotaUsed;

//quotaObj: /* empty */;

secmarkConfig: string;

//secmarkObj: /* empty */;

ctObjType: HELPER
    | TIMEOUT
    | EXPECTATION;

ctCmdType: HELPERS
    | TIMEOUT
    | EXPECTATION;

ctL4protoname: TCP
    | UDP;

ctHelperConfig: TYPE QUOTED_STRING PROTOCOL ctL4protoname stmtSeparator
    | L3PROTOCOL familySpecExplicit stmtSeparator;

timeoutStates: timeoutState
    | timeoutStates COMMA timeoutState;

timeoutState: STRING COLON NUM;

ctTimeoutConfig: PROTOCOL ctL4protoname stmtSeparator
    | POLICY '=' '{' timeoutStates '}' stmtSeparator
    | L3PROTOCOL familySpecExplicit stmtSeparator;

ctExpectConfig: PROTOCOL ctL4protoname stmtSeparator
    | DPORT NUM stmtSeparator
    | TIMEOUT timeSpec stmtSeparator
    | SIZE NUM stmtSeparator
    | L3PROTOCOL familySpecExplicit stmtSeparator;

//ctObjAlloc: /* empty */;

limitConfig: RATE limitMode NUM SLASH timeUnit limitBurstPkts
    | RATE limitMode NUM STRING limitBurstBytes;

//limitObj: /* empty */;

relationalExpr: expr rhsExpr
    | expr listRhsExpr
    | expr basicRhsExpr SLASH listRhsExpr
    | expr listRhsExpr SLASH listRhsExpr
    | expr relationalOp basicRhsExpr SLASH listRhsExpr
    | expr relationalOp listRhsExpr SLASH listRhsExpr
    | expr relationalOp rhsExpr
    | expr relationalOp listRhsExpr;

listRhsExpr: basicRhsExpr COMMA basicRhsExpr
    | listRhsExpr COMMA basicRhsExpr;

rhsExpr: concatRhsExpr
    | setExpr
    | setRefSymbolExpr;

shiftRhsExpr: primaryRhsExpr
    | shiftRhsExpr LSHIFT primaryRhsExpr
    | shiftRhsExpr RSHIFT primaryRhsExpr;

andRhsExpr: shiftRhsExpr
    | andRhsExpr AMPERSAND shiftRhsExpr;

exclusiveOrRhsExpr: andRhsExpr
    | exclusiveOrRhsExpr CARET andRhsExpr;

inclusiveOrRhsExpr: exclusiveOrRhsExpr
    | inclusiveOrRhsExpr OR exclusiveOrRhsExpr;

basicRhsExpr: inclusiveOrRhsExpr;

concatRhsExpr: basicRhsExpr
    | multitonRhsExpr
    | concatRhsExpr DOT multitonRhsExpr
    | concatRhsExpr DOT basicRhsExpr;

booleanKeys: EXISTS
    | MISSING;

booleanExpr: booleanKeys;

keywordExpr: ETHER { closeScopeEth(); }
    | IP { closeScopeIp(); }
    | IP6 { closeScopeIp6(); }
    | VLAN { closeScopeVlan(); }
    | ARP { closeScopeArp(); }
    | DNAT
    | SNAT
    | ECN
    | RESET
    | ORIGINAL
    | REPLY
    | LABEL;

primaryRhsExpr: symbolExpr
    | integerExpr
    | booleanExpr
    | keywordExpr
    | TCP
    | UDP
    | UDPLITE
    | ESP
    | AH
    | ICMP
    | IGMP
    | ICMP6
    | COMP
    | DCCP
    | SCTP { closeScopeSctp(); }
    | REDIRECT
    | '(' basicRhsExpr ')';

relationalOp: EQ
    | NEQ
    | LT
    | GT
    | GTE
    | LTE
    | NOT;

verdictExpr: ACCEPT
    | DROP
    | CONTINUE
    | JUMP chainExpr
    | GOTO chainExpr
    | RETURN;

chainExpr: variableExpr
    | identifier;

metaExpr: META metaKey
    | metaKeyUnqualified
    | META STRING;

metaKey: metaKeyQualified
    | metaKeyUnqualified;

metaKeyQualified: LENGTH
    | PROTOCOL
    | PRIORITY
    | RANDOM
    | SECMARK { closeScopeSecmark(); };

metaKeyUnqualified: MARK
    | IIF
    | IIFNAME
    | IIFTYPE
    | OIF
    | OIFNAME
    | OIFTYPE
    | SKUID
    | SKGID
    | NFTRACE
    | RTCLASSID
    | IBRIPORT
    | OBRIPORT
    | IBRIDGENAME
    | OBRIDGENAME
    | PKTTYPE
    | CPU
    | IIFGROUP
    | OIFGROUP
    | CGROUP
    | IPSEC { closeScopeIpsec(); }
    | TIME
    | DAY
    | HOUR;

metaStmt: META metaKey SET stmtExpr
    | metaKeyUnqualified SET stmtExpr
    | META STRING SET stmtExpr
    | NOTRACK
    | FLOW OFFLOAD AT string
    | FLOW ADD AT string;

socketExpr: SOCKET socketKey { closeScopeSocket(); }
    | SOCKET CGROUPV2 LEVEL NUM { closeScopeSocket(); };

socketKey: TRANSPARENT
    | MARK
    | WILDCARD;

offsetOpt: (OFFSET NUM)?;

numgenType: INC
    | RANDOM;

numgenExpr: NUMGEN numgenType MOD NUM offsetOpt { closeScopeNumgen(); };

xfrmSpnum: (SPNUM NUM)?;

xfrmDir: IN
    | OUT;

xfrmStateKey: SPI
    | REQID;

xfrmStateProtoKey: DADDR
    | SADDR;

xfrmExpr: IPSEC xfrmDir xfrmSpnum xfrmStateKey { closeScopeIpsec(); }
    | IPSEC xfrmDir xfrmSpnum nfKeyProto xfrmStateProtoKey { closeScopeIpsec(); };

hashExpr: JHASH expr MOD NUM (SEED NUM)? offsetOpt { closeScopeHash(); }
        | SYMHASH MOD NUM offsetOpt { closeScopeHash(); };

nfKeyProto: IP { closeScopeIp(); }
    | IP6 { closeScopeIp6(); };

rtExpr: RT rtKey { closeScopeRt(); }
    | RT nfKeyProto rtKey { closeScopeRt(); };

rtKey: CLASSID
    | NEXTHOP
    | MTU
    | IPSEC { closeScopeIpsec(); };

ctExpr: CT ctKey { closeScopeCt(); }
    | CT ctDir ctKeyDir { closeScopeCt(); }
    | CT ctDir ctKeyProtoField { closeScopeCt(); };

ctDir: ORIGINAL
    | REPLY;

ctKey: L3PROTOCOL
    | PROTOCOL
    | MARK
    | STATE
    | DIRECTION
    | STATUS
    | EXPIRATION
    | HELPER
    | SADDR
    | DADDR
    | PROTO_SRC
    | PROTO_DST
    | LABEL
    | EVENT
    | SECMARK { closeScopeSecmark(); }
    | ID
    | ctKeyDirOptional;

ctKeyDir: SADDR
    | DADDR
    | L3PROTOCOL
    | PROTOCOL
    | PROTO_SRC
    | PROTO_DST
    | ctKeyDirOptional;

ctKeyProtoField: IP SADDR { closeScopeIp(); }
    | IP DADDR { closeScopeIp(); }
    | IP6 SADDR { closeScopeIp6(); }
    | IP6 DADDR { closeScopeIp6(); };

ctKeyDirOptional: BYTES
    | PACKETS
    | AVGPKT
    | ZONE;

symbolStmtExpr: symbolExpr
    | keywordExpr;

listStmtExpr: symbolStmtExpr COMMA symbolStmtExpr
    | listStmtExpr COMMA symbolStmtExpr;

ctStmt: CT ctKey SET stmtExpr { closeScopeCt(); }
    | CT TIMEOUT SET stmtExpr { closeScopeCt(); }
    | CT EXPECTATION SET stmtExpr { closeScopeCt(); }
    | CT ctDir ctKeyDirOptional SET stmtExpr { closeScopeCt(); };

payloadStmt: payloadExpr SET stmtExpr;

payloadExpr: payloadRawExpr
    | ethHdrExpr
    | vlanHdrExpr
    | arpHdrExpr
    | ipHdrExpr
    | icmpHdrExpr
    | igmpHdrExpr
    | ip6HdrExpr
    | icmp6HdrExpr
    | authHdrExpr
    | espHdrExpr
    | compHdrExpr
    | udpHdrExpr
    | udpliteHdrExpr
    | tcpHdrExpr
    | dccpHdrExpr
    | sctpHdrExpr
    | thHdrExpr;

payloadRawExpr: AT payloadBaseSpec COMMA NUM COMMA NUM;

payloadBaseSpec: LL_HDR
    | NETWORK_HDR
    | TRANSPORT_HDR;

ethHdrExpr: ETHER ethHdrField { closeScopeEth(); };

ethHdrField: SADDR
    | DADDR
    | TYPE;

vlanHdrExpr: VLAN vlanHdrField { closeScopeVlan(); };

vlanHdrField: ID
    | CFI
    | DEI
    | PCP
    | TYPE;

arpHdrExpr: ARP arpHdrField { closeScopeArp(); };

arpHdrField: HTYPE
    | PTYPE
    | HLEN
    | PLEN
    | OPERATION
    | SADDR ETHER { closeScopeEth(); }
    | DADDR ETHER { closeScopeEth(); }
    | SADDR IP { closeScopeIp(); }
    | DADDR IP { closeScopeIp(); };

ipHdrExpr: IP ipHdrField { closeScopeIp(); }
    | IP OPTION ipOptionType ipOptionField { closeScopeIp(); }
    | IP OPTION ipOptionType { closeScopeIp(); };

ipHdrField: HDRVERSION
    | HDRLENGTH
    | DSCP
    | ECN
    | LENGTH
    | ID
    | FRAG_OFF
    | TTL
    | PROTOCOL
    | CHECKSUM
    | SADDR
    | DADDR;

ipOptionType: LSRR
    | RR
    | SSRR
    | RA;

ipOptionField: TYPE
    | LENGTH
    | VALUE
    | PTR
    | ADDR;

icmpHdrExpr: ICMP icmpHdrField;

icmpHdrField: TYPE
    | CODE
    | CHECKSUM
    | ID
    | SEQUENCE
    | GATEWAY
    | MTU;

igmpHdrExpr: IGMP igmpHdrField;

igmpHdrField: TYPE
    | CHECKSUM
    | MRT
    | GROUP;

ip6HdrExpr: IP6 ip6HdrField { closeScopeIp6(); };

ip6HdrField: HDRVERSION
    | DSCP
    | ECN
    | FLOWLABEL
    | LENGTH
    | NEXTHDR
    | HOPLIMIT
    | SADDR
    | DADDR;

icmp6HdrExpr: ICMP6 icmp6HdrField;

icmp6HdrField: TYPE
    | CODE
    | CHECKSUM
    | PPTR
    | MTU
    | ID
    | SEQUENCE
    | MAXDELAY;

authHdrExpr: AH authHdrField;

authHdrField: NEXTHDR
    | HDRLENGTH
    | RESERVED
    | SPI
    | SEQUENCE;

espHdrExpr: ESP espHdrField;

espHdrField: SPI
    | SEQUENCE;

compHdrExpr: COMP compHdrField;

compHdrField: NEXTHDR
    | FLAGS
    | CPI;

udpHdrExpr: UDP udpHdrField;

udpHdrField: SPORT
    | DPORT
    | LENGTH
    | CHECKSUM;

udpliteHdrExpr: UDPLITE udpliteHdrField;

udpliteHdrField: SPORT
    | DPORT
    | CSUMCOV
    | CHECKSUM;

tcpHdrExpr: TCP tcpHdrField
    | TCP OPTION tcpHdrOptionType tcpHdrOptionField
    | TCP OPTION tcpHdrOptionType
    | TCP OPTION AT tcpHdrOptionType COMMA NUM COMMA NUM;

tcpHdrField: SPORT
    | DPORT
    | SEQUENCE
    | ACKSEQ
    | DOFF
    | RESERVED
    | FLAGS
    | WINDOW
    | CHECKSUM
    | URGPTR;

tcpHdrOptionType: EOL
    | NOP
    | MSS
    | WINDOW
    | SACK_PERM
    | SACK
    | SACK0
    | SACK1
    | SACK2
    | SACK3
    | ECHO
    | TIMESTAMP
    | NUM;

tcpHdrOptionField: KIND
    | LENGTH
    | SIZE
    | COUNT
    | LEFT
    | RIGHT
    | TSVAL
    | TSECR;

dccpHdrExpr: DCCP dccpHdrField;

dccpHdrField: SPORT
    | DPORT
    | TYPE;

sctpChunkType: DATA
    | INIT
    | INIT_ACK
    | SACK
    | HEARTBEAT
    | HEARTBEAT_ACK
    | ABORT
    | SHUTDOWN
    | SHUTDOWN_ACK
    | ERROR
    | COOKIE_ECHO
    | COOKIE_ACK
    | ECNE
    | CWR
    | SHUTDOWN_COMPLETE
    | ASCONF_ACK
    | FORWARD_TSN
    | ASCONF;

sctpChunkCommonField: TYPE
    | FLAGS
    | LENGTH;

sctpChunkDataField: TSN
    | STREAM
    | SSN
    | PPID;

sctpChunkInitField: INIT_TAG
    | A_RWND
    | NUM_OSTREAMS
    | NUM_ISTREAMS
    | INIT_TSN;

sctpChunkSackField: CUM_TSN_ACK
    | A_RWND
    | NUM_GACK_BLOCKS
    | NUM_DUP_TSNS;

sctpChunkAlloc: sctpChunkType
    | sctpChunkType sctpChunkCommonField
    | DATA sctpChunkDataField
    | INIT sctpChunkInitField
    | INIT_ACK sctpChunkInitField
    | SACK sctpChunkSackField
    | SHUTDOWN CUM_TSN_ACK
    | ECNE LOWEST_TSN
    | CWR LOWEST_TSN
    | ASCONF_ACK SEQNO
    | FORWARD_TSN NEW_CUM_TSN
    | ASCONF SEQNO;

sctpHdrExpr: SCTP sctpHdrField { closeScopeSctp(); }
    | SCTP CHUNK sctpChunkAlloc { closeScopeSctpChunk(); closeScopeSctp(); };

sctpHdrField: SPORT
    | DPORT
    | VTAG
    | CHECKSUM;

thHdrExpr: TRANSPORT_HDR thHdrField;

thHdrField: SPORT
    | DPORT;

exthdrExpr: hbhHdrExpr
    | rtHdrExpr
    | rt0HdrExpr
    | rt2HdrExpr
    | rt4HdrExpr
    | fragHdrExpr
    | dstHdrExpr
    | mhHdrExpr;

hbhHdrExpr: HBH hbhHdrField;

hbhHdrField: NEXTHDR
    | HDRLENGTH;

rtHdrExpr: RT rtHdrField { closeScopeRt(); };

rtHdrField: NEXTHDR
    | HDRLENGTH
    | TYPE
    | SEG_LEFT;

rt0HdrExpr: RT0 rt0HdrField;

rt0HdrField: ADDR '[' NUM ']';

rt2HdrExpr: RT2 rt2HdrField;

rt2HdrField: ADDR;

rt4HdrExpr: RT4 rt4HdrField;

rt4HdrField: LAST_ENT
    | FLAGS
    | TAG
    | SID '[' NUM ']';

fragHdrExpr: FRAG fragHdrField;

fragHdrField: NEXTHDR
    | RESERVED
    | FRAG_OFF
    | RESERVED2
    | MORE_FRAGMENTS
    | ID;

dstHdrExpr: DST dstHdrField;

dstHdrField: NEXTHDR
    | HDRLENGTH;

mhHdrExpr: MH mhHdrField;

mhHdrField: NEXTHDR
    | HDRLENGTH
    | TYPE
    | RESERVED
    | CHECKSUM;

exthdrExistsExpr: EXTHDR exthdrKey;

exthdrKey: HBH
    | RT { closeScopeRt(); }
    | FRAG
    | DST
    | MH;
