// Generated from https://github.com/njcom/parser/make-parser/blob/main/src/MakeParser.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MakeParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		VAR_REF_WORD=1, VAR_REF_RPAREN=2, VAR_REF_RBRACE=3, COMMENT=4, ASSIGN=5, 
		DOLLAR=6, LPAREN=7, RPAREN=8, ESC=9, SQUOTE=10, DQUOTE=11, COMMA=12, CONTINUATION=13, 
		EOL=14, TARGET=15, IFDEF=16, IFNDEF=17, IFEQ=18, IFNEQ=19, ELSE=20, ENDIF=21, 
		EXPORT=22, UNEXPORT=23, VPATH=24, INCLUDE=25, MINCLUDE=26, SINCLUDE=27, 
		LOAD=28, MLOAD=29, DEFINE=30, UNDEFINE=31, OVERRIDE=32, PRIVATE=33, WORD=34, 
		WS=35, VAR_REF_CONTINUATION=36, VAR_REF_WS=37, VAR_REF_LPAREN=38, VAR_REF_LBRACE=39, 
		VAR_REF_TEXT=40, VAR_REF_DOLLAR=41, PREREQUISITE_CONTINUATION=42, PREREQUISITE=43, 
		PREREQUISITE_WS=44, PREREQUISITE_EOL=45, SHELL_CMD=46, RECEIPT_CONTINUATION=47, 
		RECEIPT_EOL=48;
	public static final int
		RULE_program = 0, RULE_stmts = 1, RULE_stmt = 2, RULE_varDef = 3, RULE_varRef = 4, 
		RULE_varRefText = 5, RULE_directiveCall = 6, RULE_conditionalDirectiveCall = 7, 
		RULE_ifCondition = 8, RULE_otherDirectiveCall = 9, RULE_ifDefCondition = 10, 
		RULE_ifNdefCondition = 11, RULE_ifEqCondition = 12, RULE_quotedVarRef = 13, 
		RULE_squotedVarRef = 14, RULE_dquotedVarRef = 15, RULE_ifNeqCondition = 16, 
		RULE_elseClause = 17, RULE_varName = 18, RULE_exportDirectiveCall = 19, 
		RULE_unexportDirectiveCall = 20, RULE_vpathDirectiveCall = 21, RULE_includeDirectiveCall = 22, 
		RULE_mincludeDirectiveCall = 23, RULE_sincludeDirectiveCall = 24, RULE_loadDirectiveCall = 25, 
		RULE_mloadDirectiveCall = 26, RULE_defineDirectiveCall = 27, RULE_undefineDirectiveCall = 28, 
		RULE_overrideDirectiveCall = 29, RULE_privateDirectiveCall = 30, RULE_ruleDef = 31, 
		RULE_prerequisite = 32, RULE_targetRef = 33, RULE_shellCmd = 34;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "stmts", "stmt", "varDef", "varRef", "varRefText", "directiveCall", 
			"conditionalDirectiveCall", "ifCondition", "otherDirectiveCall", "ifDefCondition", 
			"ifNdefCondition", "ifEqCondition", "quotedVarRef", "squotedVarRef", 
			"dquotedVarRef", "ifNeqCondition", "elseClause", "varName", "exportDirectiveCall", 
			"unexportDirectiveCall", "vpathDirectiveCall", "includeDirectiveCall", 
			"mincludeDirectiveCall", "sincludeDirectiveCall", "loadDirectiveCall", 
			"mloadDirectiveCall", "defineDirectiveCall", "undefineDirectiveCall", 
			"overrideDirectiveCall", "privateDirectiveCall", "ruleDef", "prerequisite", 
			"targetRef", "shellCmd"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, "'}'", null, null, null, null, null, "'\\'", "'''", 
			"'\"'", "','", null, null, null, "'ifdef'", "'ifndef'", "'ifeq'", "'ifneq'", 
			"'else'", "'endif'", "'export'", "'unexport'", "'vpath'", "'include'", 
			"'-include'", "'sinclude'", "'load'", "'-load'", "'define'", "'undefine'", 
			"'override'", "'private'", null, null, null, null, null, "'{'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "VAR_REF_WORD", "VAR_REF_RPAREN", "VAR_REF_RBRACE", "COMMENT", 
			"ASSIGN", "DOLLAR", "LPAREN", "RPAREN", "ESC", "SQUOTE", "DQUOTE", "COMMA", 
			"CONTINUATION", "EOL", "TARGET", "IFDEF", "IFNDEF", "IFEQ", "IFNEQ", 
			"ELSE", "ENDIF", "EXPORT", "UNEXPORT", "VPATH", "INCLUDE", "MINCLUDE", 
			"SINCLUDE", "LOAD", "MLOAD", "DEFINE", "UNDEFINE", "OVERRIDE", "PRIVATE", 
			"WORD", "WS", "VAR_REF_CONTINUATION", "VAR_REF_WS", "VAR_REF_LPAREN", 
			"VAR_REF_LBRACE", "VAR_REF_TEXT", "VAR_REF_DOLLAR", "PREREQUISITE_CONTINUATION", 
			"PREREQUISITE", "PREREQUISITE_WS", "PREREQUISITE_EOL", "SHELL_CMD", "RECEIPT_CONTINUATION", 
			"RECEIPT_EOL"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "MakeParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MakeParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(MakeParser.EOF, 0); }
		public List<StmtsContext> stmts() {
			return getRuleContexts(StmtsContext.class);
		}
		public StmtsContext stmts(int i) {
			return getRuleContext(StmtsContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MakeParserListener ) ((MakeParserListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MakeParserListener ) ((MakeParserListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MakeParserVisitor ) return ((MakeParserVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(73);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EOL) | (1L << TARGET) | (1L << IFDEF) | (1L << IFNDEF) | (1L << IFEQ) | (1L << IFNEQ) | (1L << EXPORT) | (1L << UNEXPORT) | (1L << VPATH) | (1L << INCLUDE) | (1L << MINCLUDE) | (1L << SINCLUDE) | (1L << LOAD) | (1L << MLOAD) | (1L << DEFINE) | (1L << UNDEFINE) | (1L << OVERRIDE) | (1L << PRIVATE) | (1L << WORD) | (1L << VAR_REF_LPAREN) | (1L << VAR_REF_LBRACE))) != 0)) {
				{
				{
				setState(70);
				stmts();
				}
				}
				setState(75);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(76);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StmtsContext extends ParserRuleContext {
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public List<TerminalNode> EOL() { return getTokens(MakeParser.EOL); }
		public TerminalNode EOL(int i) {
			return getToken(MakeParser.EOL, i);
		}
		public StmtsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmts; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MakeParserListener ) ((MakeParserListener)listener).enterStmts(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MakeParserListener ) ((MakeParserListener)listener).exitStmts(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MakeParserVisitor ) return ((MakeParserVisitor<? extends T>)visitor).visitStmts(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StmtsContext stmts() throws RecognitionException {
		StmtsContext _localctx = new StmtsContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_stmts);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(81);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==EOL) {
				{
				{
				setState(78);
				match(EOL);
				}
				}
				setState(83);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(84);
			stmt();
			setState(93);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(86); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(85);
						match(EOL);
						}
						}
						setState(88); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==EOL );
					setState(90);
					stmt();
					}
					} 
				}
				setState(95);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			}
			setState(99);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(96);
					match(EOL);
					}
					} 
				}
				setState(101);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StmtContext extends ParserRuleContext {
		public VarDefContext varDef() {
			return getRuleContext(VarDefContext.class,0);
		}
		public VarRefContext varRef() {
			return getRuleContext(VarRefContext.class,0);
		}
		public DirectiveCallContext directiveCall() {
			return getRuleContext(DirectiveCallContext.class,0);
		}
		public RuleDefContext ruleDef() {
			return getRuleContext(RuleDefContext.class,0);
		}
		public StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MakeParserListener ) ((MakeParserListener)listener).enterStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MakeParserListener ) ((MakeParserListener)listener).exitStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MakeParserVisitor ) return ((MakeParserVisitor<? extends T>)visitor).visitStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(106);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case WORD:
				{
				setState(102);
				varDef();
				}
				break;
			case VAR_REF_LPAREN:
			case VAR_REF_LBRACE:
				{
				setState(103);
				varRef();
				}
				break;
			case IFDEF:
			case IFNDEF:
			case IFEQ:
			case IFNEQ:
			case EXPORT:
			case UNEXPORT:
			case VPATH:
			case INCLUDE:
			case MINCLUDE:
			case SINCLUDE:
			case LOAD:
			case MLOAD:
			case DEFINE:
			case UNDEFINE:
			case OVERRIDE:
			case PRIVATE:
				{
				setState(104);
				directiveCall();
				}
				break;
			case TARGET:
				{
				setState(105);
				ruleDef();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarDefContext extends ParserRuleContext {
		public List<TerminalNode> WORD() { return getTokens(MakeParser.WORD); }
		public TerminalNode WORD(int i) {
			return getToken(MakeParser.WORD, i);
		}
		public TerminalNode ASSIGN() { return getToken(MakeParser.ASSIGN, 0); }
		public VarDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MakeParserListener ) ((MakeParserListener)listener).enterVarDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MakeParserListener ) ((MakeParserListener)listener).exitVarDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MakeParserVisitor ) return ((MakeParserVisitor<? extends T>)visitor).visitVarDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarDefContext varDef() throws RecognitionException {
		VarDefContext _localctx = new VarDefContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_varDef);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(108);
			match(WORD);
			setState(109);
			match(ASSIGN);
			setState(111); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(110);
					match(WORD);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(113); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarRefContext extends ParserRuleContext {
		public TerminalNode VAR_REF_LPAREN() { return getToken(MakeParser.VAR_REF_LPAREN, 0); }
		public VarRefTextContext varRefText() {
			return getRuleContext(VarRefTextContext.class,0);
		}
		public TerminalNode VAR_REF_RPAREN() { return getToken(MakeParser.VAR_REF_RPAREN, 0); }
		public TerminalNode VAR_REF_LBRACE() { return getToken(MakeParser.VAR_REF_LBRACE, 0); }
		public TerminalNode VAR_REF_RBRACE() { return getToken(MakeParser.VAR_REF_RBRACE, 0); }
		public VarRefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varRef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MakeParserListener ) ((MakeParserListener)listener).enterVarRef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MakeParserListener ) ((MakeParserListener)listener).exitVarRef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MakeParserVisitor ) return ((MakeParserVisitor<? extends T>)visitor).visitVarRef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarRefContext varRef() throws RecognitionException {
		VarRefContext _localctx = new VarRefContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_varRef);
		try {
			setState(123);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VAR_REF_LPAREN:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(115);
				match(VAR_REF_LPAREN);
				setState(116);
				varRefText();
				setState(117);
				match(VAR_REF_RPAREN);
				}
				}
				break;
			case VAR_REF_LBRACE:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(119);
				match(VAR_REF_LBRACE);
				setState(120);
				varRefText();
				setState(121);
				match(VAR_REF_RBRACE);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarRefTextContext extends ParserRuleContext {
		public List<TerminalNode> VAR_REF_TEXT() { return getTokens(MakeParser.VAR_REF_TEXT); }
		public TerminalNode VAR_REF_TEXT(int i) {
			return getToken(MakeParser.VAR_REF_TEXT, i);
		}
		public List<VarRefContext> varRef() {
			return getRuleContexts(VarRefContext.class);
		}
		public VarRefContext varRef(int i) {
			return getRuleContext(VarRefContext.class,i);
		}
		public VarRefTextContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varRefText; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MakeParserListener ) ((MakeParserListener)listener).enterVarRefText(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MakeParserListener ) ((MakeParserListener)listener).exitVarRefText(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MakeParserVisitor ) return ((MakeParserVisitor<? extends T>)visitor).visitVarRefText(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarRefTextContext varRefText() throws RecognitionException {
		VarRefTextContext _localctx = new VarRefTextContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_varRefText);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(129);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << VAR_REF_LPAREN) | (1L << VAR_REF_LBRACE) | (1L << VAR_REF_TEXT))) != 0)) {
				{
				setState(127);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case VAR_REF_TEXT:
					{
					setState(125);
					match(VAR_REF_TEXT);
					}
					break;
				case VAR_REF_LPAREN:
				case VAR_REF_LBRACE:
					{
					setState(126);
					varRef();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(131);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DirectiveCallContext extends ParserRuleContext {
		public ConditionalDirectiveCallContext conditionalDirectiveCall() {
			return getRuleContext(ConditionalDirectiveCallContext.class,0);
		}
		public OtherDirectiveCallContext otherDirectiveCall() {
			return getRuleContext(OtherDirectiveCallContext.class,0);
		}
		public DirectiveCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_directiveCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MakeParserListener ) ((MakeParserListener)listener).enterDirectiveCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MakeParserListener ) ((MakeParserListener)listener).exitDirectiveCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MakeParserVisitor ) return ((MakeParserVisitor<? extends T>)visitor).visitDirectiveCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DirectiveCallContext directiveCall() throws RecognitionException {
		DirectiveCallContext _localctx = new DirectiveCallContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_directiveCall);
		try {
			setState(134);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IFDEF:
			case IFNDEF:
			case IFEQ:
			case IFNEQ:
				enterOuterAlt(_localctx, 1);
				{
				setState(132);
				conditionalDirectiveCall();
				}
				break;
			case EXPORT:
			case UNEXPORT:
			case VPATH:
			case INCLUDE:
			case MINCLUDE:
			case SINCLUDE:
			case LOAD:
			case MLOAD:
			case DEFINE:
			case UNDEFINE:
			case OVERRIDE:
			case PRIVATE:
				enterOuterAlt(_localctx, 2);
				{
				setState(133);
				otherDirectiveCall();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConditionalDirectiveCallContext extends ParserRuleContext {
		public IfConditionContext ifCondition() {
			return getRuleContext(IfConditionContext.class,0);
		}
		public TerminalNode ENDIF() { return getToken(MakeParser.ENDIF, 0); }
		public List<ElseClauseContext> elseClause() {
			return getRuleContexts(ElseClauseContext.class);
		}
		public ElseClauseContext elseClause(int i) {
			return getRuleContext(ElseClauseContext.class,i);
		}
		public ConditionalDirectiveCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conditionalDirectiveCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MakeParserListener ) ((MakeParserListener)listener).enterConditionalDirectiveCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MakeParserListener ) ((MakeParserListener)listener).exitConditionalDirectiveCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MakeParserVisitor ) return ((MakeParserVisitor<? extends T>)visitor).visitConditionalDirectiveCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionalDirectiveCallContext conditionalDirectiveCall() throws RecognitionException {
		ConditionalDirectiveCallContext _localctx = new ConditionalDirectiveCallContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_conditionalDirectiveCall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(136);
			ifCondition();
			setState(140);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ELSE) {
				{
				{
				setState(137);
				elseClause();
				}
				}
				setState(142);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(143);
			match(ENDIF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IfConditionContext extends ParserRuleContext {
		public IfDefConditionContext ifDefCondition() {
			return getRuleContext(IfDefConditionContext.class,0);
		}
		public IfNdefConditionContext ifNdefCondition() {
			return getRuleContext(IfNdefConditionContext.class,0);
		}
		public IfEqConditionContext ifEqCondition() {
			return getRuleContext(IfEqConditionContext.class,0);
		}
		public IfNeqConditionContext ifNeqCondition() {
			return getRuleContext(IfNeqConditionContext.class,0);
		}
		public IfConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifCondition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MakeParserListener ) ((MakeParserListener)listener).enterIfCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MakeParserListener ) ((MakeParserListener)listener).exitIfCondition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MakeParserVisitor ) return ((MakeParserVisitor<? extends T>)visitor).visitIfCondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfConditionContext ifCondition() throws RecognitionException {
		IfConditionContext _localctx = new IfConditionContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_ifCondition);
		try {
			setState(149);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IFDEF:
				enterOuterAlt(_localctx, 1);
				{
				setState(145);
				ifDefCondition();
				}
				break;
			case IFNDEF:
				enterOuterAlt(_localctx, 2);
				{
				setState(146);
				ifNdefCondition();
				}
				break;
			case IFEQ:
				enterOuterAlt(_localctx, 3);
				{
				setState(147);
				ifEqCondition();
				}
				break;
			case IFNEQ:
				enterOuterAlt(_localctx, 4);
				{
				setState(148);
				ifNeqCondition();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OtherDirectiveCallContext extends ParserRuleContext {
		public ExportDirectiveCallContext exportDirectiveCall() {
			return getRuleContext(ExportDirectiveCallContext.class,0);
		}
		public UnexportDirectiveCallContext unexportDirectiveCall() {
			return getRuleContext(UnexportDirectiveCallContext.class,0);
		}
		public VpathDirectiveCallContext vpathDirectiveCall() {
			return getRuleContext(VpathDirectiveCallContext.class,0);
		}
		public IncludeDirectiveCallContext includeDirectiveCall() {
			return getRuleContext(IncludeDirectiveCallContext.class,0);
		}
		public MincludeDirectiveCallContext mincludeDirectiveCall() {
			return getRuleContext(MincludeDirectiveCallContext.class,0);
		}
		public SincludeDirectiveCallContext sincludeDirectiveCall() {
			return getRuleContext(SincludeDirectiveCallContext.class,0);
		}
		public LoadDirectiveCallContext loadDirectiveCall() {
			return getRuleContext(LoadDirectiveCallContext.class,0);
		}
		public MloadDirectiveCallContext mloadDirectiveCall() {
			return getRuleContext(MloadDirectiveCallContext.class,0);
		}
		public DefineDirectiveCallContext defineDirectiveCall() {
			return getRuleContext(DefineDirectiveCallContext.class,0);
		}
		public UndefineDirectiveCallContext undefineDirectiveCall() {
			return getRuleContext(UndefineDirectiveCallContext.class,0);
		}
		public OverrideDirectiveCallContext overrideDirectiveCall() {
			return getRuleContext(OverrideDirectiveCallContext.class,0);
		}
		public PrivateDirectiveCallContext privateDirectiveCall() {
			return getRuleContext(PrivateDirectiveCallContext.class,0);
		}
		public OtherDirectiveCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_otherDirectiveCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MakeParserListener ) ((MakeParserListener)listener).enterOtherDirectiveCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MakeParserListener ) ((MakeParserListener)listener).exitOtherDirectiveCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MakeParserVisitor ) return ((MakeParserVisitor<? extends T>)visitor).visitOtherDirectiveCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OtherDirectiveCallContext otherDirectiveCall() throws RecognitionException {
		OtherDirectiveCallContext _localctx = new OtherDirectiveCallContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_otherDirectiveCall);
		try {
			setState(163);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case EXPORT:
				enterOuterAlt(_localctx, 1);
				{
				setState(151);
				exportDirectiveCall();
				}
				break;
			case UNEXPORT:
				enterOuterAlt(_localctx, 2);
				{
				setState(152);
				unexportDirectiveCall();
				}
				break;
			case VPATH:
				enterOuterAlt(_localctx, 3);
				{
				setState(153);
				vpathDirectiveCall();
				}
				break;
			case INCLUDE:
				enterOuterAlt(_localctx, 4);
				{
				setState(154);
				includeDirectiveCall();
				}
				break;
			case MINCLUDE:
				enterOuterAlt(_localctx, 5);
				{
				setState(155);
				mincludeDirectiveCall();
				}
				break;
			case SINCLUDE:
				enterOuterAlt(_localctx, 6);
				{
				setState(156);
				sincludeDirectiveCall();
				}
				break;
			case LOAD:
				enterOuterAlt(_localctx, 7);
				{
				setState(157);
				loadDirectiveCall();
				}
				break;
			case MLOAD:
				enterOuterAlt(_localctx, 8);
				{
				setState(158);
				mloadDirectiveCall();
				}
				break;
			case DEFINE:
				enterOuterAlt(_localctx, 9);
				{
				setState(159);
				defineDirectiveCall();
				}
				break;
			case UNDEFINE:
				enterOuterAlt(_localctx, 10);
				{
				setState(160);
				undefineDirectiveCall();
				}
				break;
			case OVERRIDE:
				enterOuterAlt(_localctx, 11);
				{
				setState(161);
				overrideDirectiveCall();
				}
				break;
			case PRIVATE:
				enterOuterAlt(_localctx, 12);
				{
				setState(162);
				privateDirectiveCall();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IfDefConditionContext extends ParserRuleContext {
		public TerminalNode IFDEF() { return getToken(MakeParser.IFDEF, 0); }
		public StmtsContext stmts() {
			return getRuleContext(StmtsContext.class,0);
		}
		public VarRefContext varRef() {
			return getRuleContext(VarRefContext.class,0);
		}
		public VarNameContext varName() {
			return getRuleContext(VarNameContext.class,0);
		}
		public IfDefConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifDefCondition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MakeParserListener ) ((MakeParserListener)listener).enterIfDefCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MakeParserListener ) ((MakeParserListener)listener).exitIfDefCondition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MakeParserVisitor ) return ((MakeParserVisitor<? extends T>)visitor).visitIfDefCondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfDefConditionContext ifDefCondition() throws RecognitionException {
		IfDefConditionContext _localctx = new IfDefConditionContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_ifDefCondition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(165);
			match(IFDEF);
			setState(168);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VAR_REF_LPAREN:
			case VAR_REF_LBRACE:
				{
				setState(166);
				varRef();
				}
				break;
			case WORD:
				{
				setState(167);
				varName();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(170);
			stmts();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IfNdefConditionContext extends ParserRuleContext {
		public TerminalNode IFNDEF() { return getToken(MakeParser.IFNDEF, 0); }
		public StmtsContext stmts() {
			return getRuleContext(StmtsContext.class,0);
		}
		public VarRefContext varRef() {
			return getRuleContext(VarRefContext.class,0);
		}
		public VarNameContext varName() {
			return getRuleContext(VarNameContext.class,0);
		}
		public IfNdefConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifNdefCondition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MakeParserListener ) ((MakeParserListener)listener).enterIfNdefCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MakeParserListener ) ((MakeParserListener)listener).exitIfNdefCondition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MakeParserVisitor ) return ((MakeParserVisitor<? extends T>)visitor).visitIfNdefCondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfNdefConditionContext ifNdefCondition() throws RecognitionException {
		IfNdefConditionContext _localctx = new IfNdefConditionContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_ifNdefCondition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(172);
			match(IFNDEF);
			setState(175);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VAR_REF_LPAREN:
			case VAR_REF_LBRACE:
				{
				setState(173);
				varRef();
				}
				break;
			case WORD:
				{
				setState(174);
				varName();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(177);
			stmts();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IfEqConditionContext extends ParserRuleContext {
		public TerminalNode IFEQ() { return getToken(MakeParser.IFEQ, 0); }
		public StmtsContext stmts() {
			return getRuleContext(StmtsContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(MakeParser.LPAREN, 0); }
		public List<VarRefContext> varRef() {
			return getRuleContexts(VarRefContext.class);
		}
		public VarRefContext varRef(int i) {
			return getRuleContext(VarRefContext.class,i);
		}
		public TerminalNode COMMA() { return getToken(MakeParser.COMMA, 0); }
		public TerminalNode RPAREN() { return getToken(MakeParser.RPAREN, 0); }
		public List<QuotedVarRefContext> quotedVarRef() {
			return getRuleContexts(QuotedVarRefContext.class);
		}
		public QuotedVarRefContext quotedVarRef(int i) {
			return getRuleContext(QuotedVarRefContext.class,i);
		}
		public IfEqConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifEqCondition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MakeParserListener ) ((MakeParserListener)listener).enterIfEqCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MakeParserListener ) ((MakeParserListener)listener).exitIfEqCondition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MakeParserVisitor ) return ((MakeParserVisitor<? extends T>)visitor).visitIfEqCondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfEqConditionContext ifEqCondition() throws RecognitionException {
		IfEqConditionContext _localctx = new IfEqConditionContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_ifEqCondition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(179);
			match(IFEQ);
			setState(189);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPAREN:
				{
				setState(180);
				match(LPAREN);
				setState(181);
				varRef();
				setState(182);
				match(COMMA);
				setState(183);
				varRef();
				setState(184);
				match(RPAREN);
				}
				break;
			case ESC:
			case DQUOTE:
				{
				setState(186);
				quotedVarRef();
				setState(187);
				quotedVarRef();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(191);
			stmts();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QuotedVarRefContext extends ParserRuleContext {
		public SquotedVarRefContext squotedVarRef() {
			return getRuleContext(SquotedVarRefContext.class,0);
		}
		public DquotedVarRefContext dquotedVarRef() {
			return getRuleContext(DquotedVarRefContext.class,0);
		}
		public QuotedVarRefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_quotedVarRef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MakeParserListener ) ((MakeParserListener)listener).enterQuotedVarRef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MakeParserListener ) ((MakeParserListener)listener).exitQuotedVarRef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MakeParserVisitor ) return ((MakeParserVisitor<? extends T>)visitor).visitQuotedVarRef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuotedVarRefContext quotedVarRef() throws RecognitionException {
		QuotedVarRefContext _localctx = new QuotedVarRefContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_quotedVarRef);
		try {
			setState(195);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ESC:
				enterOuterAlt(_localctx, 1);
				{
				setState(193);
				squotedVarRef();
				}
				break;
			case DQUOTE:
				enterOuterAlt(_localctx, 2);
				{
				setState(194);
				dquotedVarRef();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SquotedVarRefContext extends ParserRuleContext {
		public List<TerminalNode> ESC() { return getTokens(MakeParser.ESC); }
		public TerminalNode ESC(int i) {
			return getToken(MakeParser.ESC, i);
		}
		public List<TerminalNode> SQUOTE() { return getTokens(MakeParser.SQUOTE); }
		public TerminalNode SQUOTE(int i) {
			return getToken(MakeParser.SQUOTE, i);
		}
		public VarRefContext varRef() {
			return getRuleContext(VarRefContext.class,0);
		}
		public SquotedVarRefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_squotedVarRef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MakeParserListener ) ((MakeParserListener)listener).enterSquotedVarRef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MakeParserListener ) ((MakeParserListener)listener).exitSquotedVarRef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MakeParserVisitor ) return ((MakeParserVisitor<? extends T>)visitor).visitSquotedVarRef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SquotedVarRefContext squotedVarRef() throws RecognitionException {
		SquotedVarRefContext _localctx = new SquotedVarRefContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_squotedVarRef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(197);
			match(ESC);
			setState(198);
			match(SQUOTE);
			setState(199);
			varRef();
			setState(200);
			match(ESC);
			setState(201);
			match(SQUOTE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DquotedVarRefContext extends ParserRuleContext {
		public List<TerminalNode> DQUOTE() { return getTokens(MakeParser.DQUOTE); }
		public TerminalNode DQUOTE(int i) {
			return getToken(MakeParser.DQUOTE, i);
		}
		public VarRefContext varRef() {
			return getRuleContext(VarRefContext.class,0);
		}
		public DquotedVarRefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dquotedVarRef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MakeParserListener ) ((MakeParserListener)listener).enterDquotedVarRef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MakeParserListener ) ((MakeParserListener)listener).exitDquotedVarRef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MakeParserVisitor ) return ((MakeParserVisitor<? extends T>)visitor).visitDquotedVarRef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DquotedVarRefContext dquotedVarRef() throws RecognitionException {
		DquotedVarRefContext _localctx = new DquotedVarRefContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_dquotedVarRef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(203);
			match(DQUOTE);
			setState(204);
			varRef();
			setState(205);
			match(DQUOTE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IfNeqConditionContext extends ParserRuleContext {
		public TerminalNode IFNEQ() { return getToken(MakeParser.IFNEQ, 0); }
		public StmtsContext stmts() {
			return getRuleContext(StmtsContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(MakeParser.LPAREN, 0); }
		public List<VarRefContext> varRef() {
			return getRuleContexts(VarRefContext.class);
		}
		public VarRefContext varRef(int i) {
			return getRuleContext(VarRefContext.class,i);
		}
		public TerminalNode COMMA() { return getToken(MakeParser.COMMA, 0); }
		public TerminalNode RPAREN() { return getToken(MakeParser.RPAREN, 0); }
		public List<QuotedVarRefContext> quotedVarRef() {
			return getRuleContexts(QuotedVarRefContext.class);
		}
		public QuotedVarRefContext quotedVarRef(int i) {
			return getRuleContext(QuotedVarRefContext.class,i);
		}
		public IfNeqConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifNeqCondition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MakeParserListener ) ((MakeParserListener)listener).enterIfNeqCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MakeParserListener ) ((MakeParserListener)listener).exitIfNeqCondition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MakeParserVisitor ) return ((MakeParserVisitor<? extends T>)visitor).visitIfNeqCondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfNeqConditionContext ifNeqCondition() throws RecognitionException {
		IfNeqConditionContext _localctx = new IfNeqConditionContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_ifNeqCondition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(207);
			match(IFNEQ);
			setState(217);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPAREN:
				{
				setState(208);
				match(LPAREN);
				setState(209);
				varRef();
				setState(210);
				match(COMMA);
				setState(211);
				varRef();
				setState(212);
				match(RPAREN);
				}
				break;
			case ESC:
			case DQUOTE:
				{
				setState(214);
				quotedVarRef();
				setState(215);
				quotedVarRef();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(219);
			stmts();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ElseClauseContext extends ParserRuleContext {
		public TerminalNode ELSE() { return getToken(MakeParser.ELSE, 0); }
		public StmtsContext stmts() {
			return getRuleContext(StmtsContext.class,0);
		}
		public IfConditionContext ifCondition() {
			return getRuleContext(IfConditionContext.class,0);
		}
		public ElseClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MakeParserListener ) ((MakeParserListener)listener).enterElseClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MakeParserListener ) ((MakeParserListener)listener).exitElseClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MakeParserVisitor ) return ((MakeParserVisitor<? extends T>)visitor).visitElseClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElseClauseContext elseClause() throws RecognitionException {
		ElseClauseContext _localctx = new ElseClauseContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_elseClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(221);
			match(ELSE);
			setState(226);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				{
				setState(223);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IFDEF) | (1L << IFNDEF) | (1L << IFEQ) | (1L << IFNEQ))) != 0)) {
					{
					setState(222);
					ifCondition();
					}
				}

				}
				break;
			case 2:
				{
				setState(225);
				stmts();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarNameContext extends ParserRuleContext {
		public TerminalNode WORD() { return getToken(MakeParser.WORD, 0); }
		public VarNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MakeParserListener ) ((MakeParserListener)listener).enterVarName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MakeParserListener ) ((MakeParserListener)listener).exitVarName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MakeParserVisitor ) return ((MakeParserVisitor<? extends T>)visitor).visitVarName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarNameContext varName() throws RecognitionException {
		VarNameContext _localctx = new VarNameContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_varName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(228);
			match(WORD);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExportDirectiveCallContext extends ParserRuleContext {
		public TerminalNode EXPORT() { return getToken(MakeParser.EXPORT, 0); }
		public ExportDirectiveCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exportDirectiveCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MakeParserListener ) ((MakeParserListener)listener).enterExportDirectiveCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MakeParserListener ) ((MakeParserListener)listener).exitExportDirectiveCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MakeParserVisitor ) return ((MakeParserVisitor<? extends T>)visitor).visitExportDirectiveCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExportDirectiveCallContext exportDirectiveCall() throws RecognitionException {
		ExportDirectiveCallContext _localctx = new ExportDirectiveCallContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_exportDirectiveCall);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(230);
			match(EXPORT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UnexportDirectiveCallContext extends ParserRuleContext {
		public TerminalNode UNEXPORT() { return getToken(MakeParser.UNEXPORT, 0); }
		public UnexportDirectiveCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unexportDirectiveCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MakeParserListener ) ((MakeParserListener)listener).enterUnexportDirectiveCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MakeParserListener ) ((MakeParserListener)listener).exitUnexportDirectiveCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MakeParserVisitor ) return ((MakeParserVisitor<? extends T>)visitor).visitUnexportDirectiveCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnexportDirectiveCallContext unexportDirectiveCall() throws RecognitionException {
		UnexportDirectiveCallContext _localctx = new UnexportDirectiveCallContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_unexportDirectiveCall);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(232);
			match(UNEXPORT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VpathDirectiveCallContext extends ParserRuleContext {
		public TerminalNode VPATH() { return getToken(MakeParser.VPATH, 0); }
		public VpathDirectiveCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vpathDirectiveCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MakeParserListener ) ((MakeParserListener)listener).enterVpathDirectiveCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MakeParserListener ) ((MakeParserListener)listener).exitVpathDirectiveCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MakeParserVisitor ) return ((MakeParserVisitor<? extends T>)visitor).visitVpathDirectiveCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VpathDirectiveCallContext vpathDirectiveCall() throws RecognitionException {
		VpathDirectiveCallContext _localctx = new VpathDirectiveCallContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_vpathDirectiveCall);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(234);
			match(VPATH);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IncludeDirectiveCallContext extends ParserRuleContext {
		public TerminalNode INCLUDE() { return getToken(MakeParser.INCLUDE, 0); }
		public IncludeDirectiveCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_includeDirectiveCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MakeParserListener ) ((MakeParserListener)listener).enterIncludeDirectiveCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MakeParserListener ) ((MakeParserListener)listener).exitIncludeDirectiveCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MakeParserVisitor ) return ((MakeParserVisitor<? extends T>)visitor).visitIncludeDirectiveCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IncludeDirectiveCallContext includeDirectiveCall() throws RecognitionException {
		IncludeDirectiveCallContext _localctx = new IncludeDirectiveCallContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_includeDirectiveCall);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(236);
			match(INCLUDE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MincludeDirectiveCallContext extends ParserRuleContext {
		public TerminalNode MINCLUDE() { return getToken(MakeParser.MINCLUDE, 0); }
		public MincludeDirectiveCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mincludeDirectiveCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MakeParserListener ) ((MakeParserListener)listener).enterMincludeDirectiveCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MakeParserListener ) ((MakeParserListener)listener).exitMincludeDirectiveCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MakeParserVisitor ) return ((MakeParserVisitor<? extends T>)visitor).visitMincludeDirectiveCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MincludeDirectiveCallContext mincludeDirectiveCall() throws RecognitionException {
		MincludeDirectiveCallContext _localctx = new MincludeDirectiveCallContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_mincludeDirectiveCall);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(238);
			match(MINCLUDE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SincludeDirectiveCallContext extends ParserRuleContext {
		public TerminalNode SINCLUDE() { return getToken(MakeParser.SINCLUDE, 0); }
		public SincludeDirectiveCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sincludeDirectiveCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MakeParserListener ) ((MakeParserListener)listener).enterSincludeDirectiveCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MakeParserListener ) ((MakeParserListener)listener).exitSincludeDirectiveCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MakeParserVisitor ) return ((MakeParserVisitor<? extends T>)visitor).visitSincludeDirectiveCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SincludeDirectiveCallContext sincludeDirectiveCall() throws RecognitionException {
		SincludeDirectiveCallContext _localctx = new SincludeDirectiveCallContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_sincludeDirectiveCall);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(240);
			match(SINCLUDE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LoadDirectiveCallContext extends ParserRuleContext {
		public TerminalNode LOAD() { return getToken(MakeParser.LOAD, 0); }
		public LoadDirectiveCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loadDirectiveCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MakeParserListener ) ((MakeParserListener)listener).enterLoadDirectiveCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MakeParserListener ) ((MakeParserListener)listener).exitLoadDirectiveCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MakeParserVisitor ) return ((MakeParserVisitor<? extends T>)visitor).visitLoadDirectiveCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LoadDirectiveCallContext loadDirectiveCall() throws RecognitionException {
		LoadDirectiveCallContext _localctx = new LoadDirectiveCallContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_loadDirectiveCall);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(242);
			match(LOAD);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MloadDirectiveCallContext extends ParserRuleContext {
		public TerminalNode MLOAD() { return getToken(MakeParser.MLOAD, 0); }
		public MloadDirectiveCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mloadDirectiveCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MakeParserListener ) ((MakeParserListener)listener).enterMloadDirectiveCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MakeParserListener ) ((MakeParserListener)listener).exitMloadDirectiveCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MakeParserVisitor ) return ((MakeParserVisitor<? extends T>)visitor).visitMloadDirectiveCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MloadDirectiveCallContext mloadDirectiveCall() throws RecognitionException {
		MloadDirectiveCallContext _localctx = new MloadDirectiveCallContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_mloadDirectiveCall);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(244);
			match(MLOAD);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DefineDirectiveCallContext extends ParserRuleContext {
		public TerminalNode DEFINE() { return getToken(MakeParser.DEFINE, 0); }
		public DefineDirectiveCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_defineDirectiveCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MakeParserListener ) ((MakeParserListener)listener).enterDefineDirectiveCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MakeParserListener ) ((MakeParserListener)listener).exitDefineDirectiveCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MakeParserVisitor ) return ((MakeParserVisitor<? extends T>)visitor).visitDefineDirectiveCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DefineDirectiveCallContext defineDirectiveCall() throws RecognitionException {
		DefineDirectiveCallContext _localctx = new DefineDirectiveCallContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_defineDirectiveCall);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(246);
			match(DEFINE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UndefineDirectiveCallContext extends ParserRuleContext {
		public TerminalNode UNDEFINE() { return getToken(MakeParser.UNDEFINE, 0); }
		public UndefineDirectiveCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_undefineDirectiveCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MakeParserListener ) ((MakeParserListener)listener).enterUndefineDirectiveCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MakeParserListener ) ((MakeParserListener)listener).exitUndefineDirectiveCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MakeParserVisitor ) return ((MakeParserVisitor<? extends T>)visitor).visitUndefineDirectiveCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UndefineDirectiveCallContext undefineDirectiveCall() throws RecognitionException {
		UndefineDirectiveCallContext _localctx = new UndefineDirectiveCallContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_undefineDirectiveCall);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(248);
			match(UNDEFINE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OverrideDirectiveCallContext extends ParserRuleContext {
		public TerminalNode OVERRIDE() { return getToken(MakeParser.OVERRIDE, 0); }
		public OverrideDirectiveCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_overrideDirectiveCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MakeParserListener ) ((MakeParserListener)listener).enterOverrideDirectiveCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MakeParserListener ) ((MakeParserListener)listener).exitOverrideDirectiveCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MakeParserVisitor ) return ((MakeParserVisitor<? extends T>)visitor).visitOverrideDirectiveCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OverrideDirectiveCallContext overrideDirectiveCall() throws RecognitionException {
		OverrideDirectiveCallContext _localctx = new OverrideDirectiveCallContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_overrideDirectiveCall);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(250);
			match(OVERRIDE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrivateDirectiveCallContext extends ParserRuleContext {
		public TerminalNode PRIVATE() { return getToken(MakeParser.PRIVATE, 0); }
		public PrivateDirectiveCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_privateDirectiveCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MakeParserListener ) ((MakeParserListener)listener).enterPrivateDirectiveCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MakeParserListener ) ((MakeParserListener)listener).exitPrivateDirectiveCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MakeParserVisitor ) return ((MakeParserVisitor<? extends T>)visitor).visitPrivateDirectiveCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrivateDirectiveCallContext privateDirectiveCall() throws RecognitionException {
		PrivateDirectiveCallContext _localctx = new PrivateDirectiveCallContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_privateDirectiveCall);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(252);
			match(PRIVATE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RuleDefContext extends ParserRuleContext {
		public TerminalNode TARGET() { return getToken(MakeParser.TARGET, 0); }
		public List<PrerequisiteContext> prerequisite() {
			return getRuleContexts(PrerequisiteContext.class);
		}
		public PrerequisiteContext prerequisite(int i) {
			return getRuleContext(PrerequisiteContext.class,i);
		}
		public List<ShellCmdContext> shellCmd() {
			return getRuleContexts(ShellCmdContext.class);
		}
		public ShellCmdContext shellCmd(int i) {
			return getRuleContext(ShellCmdContext.class,i);
		}
		public RuleDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ruleDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MakeParserListener ) ((MakeParserListener)listener).enterRuleDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MakeParserListener ) ((MakeParserListener)listener).exitRuleDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MakeParserVisitor ) return ((MakeParserVisitor<? extends T>)visitor).visitRuleDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RuleDefContext ruleDef() throws RecognitionException {
		RuleDefContext _localctx = new RuleDefContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_ruleDef);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(254);
			match(TARGET);
			setState(258);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(255);
					prerequisite();
					}
					} 
				}
				setState(260);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			}
			setState(264);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SHELL_CMD) {
				{
				{
				setState(261);
				shellCmd();
				}
				}
				setState(266);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrerequisiteContext extends ParserRuleContext {
		public VarRefContext varRef() {
			return getRuleContext(VarRefContext.class,0);
		}
		public TargetRefContext targetRef() {
			return getRuleContext(TargetRefContext.class,0);
		}
		public PrerequisiteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prerequisite; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MakeParserListener ) ((MakeParserListener)listener).enterPrerequisite(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MakeParserListener ) ((MakeParserListener)listener).exitPrerequisite(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MakeParserVisitor ) return ((MakeParserVisitor<? extends T>)visitor).visitPrerequisite(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrerequisiteContext prerequisite() throws RecognitionException {
		PrerequisiteContext _localctx = new PrerequisiteContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_prerequisite);
		try {
			setState(269);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VAR_REF_LPAREN:
			case VAR_REF_LBRACE:
				enterOuterAlt(_localctx, 1);
				{
				setState(267);
				varRef();
				}
				break;
			case WORD:
				enterOuterAlt(_localctx, 2);
				{
				setState(268);
				targetRef();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TargetRefContext extends ParserRuleContext {
		public TerminalNode WORD() { return getToken(MakeParser.WORD, 0); }
		public TargetRefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_targetRef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MakeParserListener ) ((MakeParserListener)listener).enterTargetRef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MakeParserListener ) ((MakeParserListener)listener).exitTargetRef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MakeParserVisitor ) return ((MakeParserVisitor<? extends T>)visitor).visitTargetRef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TargetRefContext targetRef() throws RecognitionException {
		TargetRefContext _localctx = new TargetRefContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_targetRef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(271);
			match(WORD);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ShellCmdContext extends ParserRuleContext {
		public TerminalNode SHELL_CMD() { return getToken(MakeParser.SHELL_CMD, 0); }
		public ShellCmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_shellCmd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MakeParserListener ) ((MakeParserListener)listener).enterShellCmd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MakeParserListener ) ((MakeParserListener)listener).exitShellCmd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MakeParserVisitor ) return ((MakeParserVisitor<? extends T>)visitor).visitShellCmd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ShellCmdContext shellCmd() throws RecognitionException {
		ShellCmdContext _localctx = new ShellCmdContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_shellCmd);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(273);
			match(SHELL_CMD);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\62\u0116\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\3\2\7\2J\n\2\f\2\16\2M\13\2\3\2\3\2\3\3\7\3R\n"+
		"\3\f\3\16\3U\13\3\3\3\3\3\6\3Y\n\3\r\3\16\3Z\3\3\7\3^\n\3\f\3\16\3a\13"+
		"\3\3\3\7\3d\n\3\f\3\16\3g\13\3\3\4\3\4\3\4\3\4\5\4m\n\4\3\5\3\5\3\5\6"+
		"\5r\n\5\r\5\16\5s\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6~\n\6\3\7\3\7\7\7"+
		"\u0082\n\7\f\7\16\7\u0085\13\7\3\b\3\b\5\b\u0089\n\b\3\t\3\t\7\t\u008d"+
		"\n\t\f\t\16\t\u0090\13\t\3\t\3\t\3\n\3\n\3\n\3\n\5\n\u0098\n\n\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u00a6\n\13"+
		"\3\f\3\f\3\f\5\f\u00ab\n\f\3\f\3\f\3\r\3\r\3\r\5\r\u00b2\n\r\3\r\3\r\3"+
		"\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u00c0\n\16\3\16"+
		"\3\16\3\17\3\17\5\17\u00c6\n\17\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21"+
		"\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u00dc"+
		"\n\22\3\22\3\22\3\23\3\23\5\23\u00e2\n\23\3\23\5\23\u00e5\n\23\3\24\3"+
		"\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3"+
		"\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3!\3!\7!\u0103\n!\f"+
		"!\16!\u0106\13!\3!\7!\u0109\n!\f!\16!\u010c\13!\3\"\3\"\5\"\u0110\n\""+
		"\3#\3#\3$\3$\3$\2\2%\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60"+
		"\62\64\668:<>@BDF\2\2\2\u0118\2K\3\2\2\2\4S\3\2\2\2\6l\3\2\2\2\bn\3\2"+
		"\2\2\n}\3\2\2\2\f\u0083\3\2\2\2\16\u0088\3\2\2\2\20\u008a\3\2\2\2\22\u0097"+
		"\3\2\2\2\24\u00a5\3\2\2\2\26\u00a7\3\2\2\2\30\u00ae\3\2\2\2\32\u00b5\3"+
		"\2\2\2\34\u00c5\3\2\2\2\36\u00c7\3\2\2\2 \u00cd\3\2\2\2\"\u00d1\3\2\2"+
		"\2$\u00df\3\2\2\2&\u00e6\3\2\2\2(\u00e8\3\2\2\2*\u00ea\3\2\2\2,\u00ec"+
		"\3\2\2\2.\u00ee\3\2\2\2\60\u00f0\3\2\2\2\62\u00f2\3\2\2\2\64\u00f4\3\2"+
		"\2\2\66\u00f6\3\2\2\28\u00f8\3\2\2\2:\u00fa\3\2\2\2<\u00fc\3\2\2\2>\u00fe"+
		"\3\2\2\2@\u0100\3\2\2\2B\u010f\3\2\2\2D\u0111\3\2\2\2F\u0113\3\2\2\2H"+
		"J\5\4\3\2IH\3\2\2\2JM\3\2\2\2KI\3\2\2\2KL\3\2\2\2LN\3\2\2\2MK\3\2\2\2"+
		"NO\7\2\2\3O\3\3\2\2\2PR\7\20\2\2QP\3\2\2\2RU\3\2\2\2SQ\3\2\2\2ST\3\2\2"+
		"\2TV\3\2\2\2US\3\2\2\2V_\5\6\4\2WY\7\20\2\2XW\3\2\2\2YZ\3\2\2\2ZX\3\2"+
		"\2\2Z[\3\2\2\2[\\\3\2\2\2\\^\5\6\4\2]X\3\2\2\2^a\3\2\2\2_]\3\2\2\2_`\3"+
		"\2\2\2`e\3\2\2\2a_\3\2\2\2bd\7\20\2\2cb\3\2\2\2dg\3\2\2\2ec\3\2\2\2ef"+
		"\3\2\2\2f\5\3\2\2\2ge\3\2\2\2hm\5\b\5\2im\5\n\6\2jm\5\16\b\2km\5@!\2l"+
		"h\3\2\2\2li\3\2\2\2lj\3\2\2\2lk\3\2\2\2m\7\3\2\2\2no\7$\2\2oq\7\7\2\2"+
		"pr\7$\2\2qp\3\2\2\2rs\3\2\2\2sq\3\2\2\2st\3\2\2\2t\t\3\2\2\2uv\7(\2\2"+
		"vw\5\f\7\2wx\7\4\2\2x~\3\2\2\2yz\7)\2\2z{\5\f\7\2{|\7\5\2\2|~\3\2\2\2"+
		"}u\3\2\2\2}y\3\2\2\2~\13\3\2\2\2\177\u0082\7*\2\2\u0080\u0082\5\n\6\2"+
		"\u0081\177\3\2\2\2\u0081\u0080\3\2\2\2\u0082\u0085\3\2\2\2\u0083\u0081"+
		"\3\2\2\2\u0083\u0084\3\2\2\2\u0084\r\3\2\2\2\u0085\u0083\3\2\2\2\u0086"+
		"\u0089\5\20\t\2\u0087\u0089\5\24\13\2\u0088\u0086\3\2\2\2\u0088\u0087"+
		"\3\2\2\2\u0089\17\3\2\2\2\u008a\u008e\5\22\n\2\u008b\u008d\5$\23\2\u008c"+
		"\u008b\3\2\2\2\u008d\u0090\3\2\2\2\u008e\u008c\3\2\2\2\u008e\u008f\3\2"+
		"\2\2\u008f\u0091\3\2\2\2\u0090\u008e\3\2\2\2\u0091\u0092\7\27\2\2\u0092"+
		"\21\3\2\2\2\u0093\u0098\5\26\f\2\u0094\u0098\5\30\r\2\u0095\u0098\5\32"+
		"\16\2\u0096\u0098\5\"\22\2\u0097\u0093\3\2\2\2\u0097\u0094\3\2\2\2\u0097"+
		"\u0095\3\2\2\2\u0097\u0096\3\2\2\2\u0098\23\3\2\2\2\u0099\u00a6\5(\25"+
		"\2\u009a\u00a6\5*\26\2\u009b\u00a6\5,\27\2\u009c\u00a6\5.\30\2\u009d\u00a6"+
		"\5\60\31\2\u009e\u00a6\5\62\32\2\u009f\u00a6\5\64\33\2\u00a0\u00a6\5\66"+
		"\34\2\u00a1\u00a6\58\35\2\u00a2\u00a6\5:\36\2\u00a3\u00a6\5<\37\2\u00a4"+
		"\u00a6\5> \2\u00a5\u0099\3\2\2\2\u00a5\u009a\3\2\2\2\u00a5\u009b\3\2\2"+
		"\2\u00a5\u009c\3\2\2\2\u00a5\u009d\3\2\2\2\u00a5\u009e\3\2\2\2\u00a5\u009f"+
		"\3\2\2\2\u00a5\u00a0\3\2\2\2\u00a5\u00a1\3\2\2\2\u00a5\u00a2\3\2\2\2\u00a5"+
		"\u00a3\3\2\2\2\u00a5\u00a4\3\2\2\2\u00a6\25\3\2\2\2\u00a7\u00aa\7\22\2"+
		"\2\u00a8\u00ab\5\n\6\2\u00a9\u00ab\5&\24\2\u00aa\u00a8\3\2\2\2\u00aa\u00a9"+
		"\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac\u00ad\5\4\3\2\u00ad\27\3\2\2\2\u00ae"+
		"\u00b1\7\23\2\2\u00af\u00b2\5\n\6\2\u00b0\u00b2\5&\24\2\u00b1\u00af\3"+
		"\2\2\2\u00b1\u00b0\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3\u00b4\5\4\3\2\u00b4"+
		"\31\3\2\2\2\u00b5\u00bf\7\24\2\2\u00b6\u00b7\7\t\2\2\u00b7\u00b8\5\n\6"+
		"\2\u00b8\u00b9\7\16\2\2\u00b9\u00ba\5\n\6\2\u00ba\u00bb\7\n\2\2\u00bb"+
		"\u00c0\3\2\2\2\u00bc\u00bd\5\34\17\2\u00bd\u00be\5\34\17\2\u00be\u00c0"+
		"\3\2\2\2\u00bf\u00b6\3\2\2\2\u00bf\u00bc\3\2\2\2\u00c0\u00c1\3\2\2\2\u00c1"+
		"\u00c2\5\4\3\2\u00c2\33\3\2\2\2\u00c3\u00c6\5\36\20\2\u00c4\u00c6\5 \21"+
		"\2\u00c5\u00c3\3\2\2\2\u00c5\u00c4\3\2\2\2\u00c6\35\3\2\2\2\u00c7\u00c8"+
		"\7\13\2\2\u00c8\u00c9\7\f\2\2\u00c9\u00ca\5\n\6\2\u00ca\u00cb\7\13\2\2"+
		"\u00cb\u00cc\7\f\2\2\u00cc\37\3\2\2\2\u00cd\u00ce\7\r\2\2\u00ce\u00cf"+
		"\5\n\6\2\u00cf\u00d0\7\r\2\2\u00d0!\3\2\2\2\u00d1\u00db\7\25\2\2\u00d2"+
		"\u00d3\7\t\2\2\u00d3\u00d4\5\n\6\2\u00d4\u00d5\7\16\2\2\u00d5\u00d6\5"+
		"\n\6\2\u00d6\u00d7\7\n\2\2\u00d7\u00dc\3\2\2\2\u00d8\u00d9\5\34\17\2\u00d9"+
		"\u00da\5\34\17\2\u00da\u00dc\3\2\2\2\u00db\u00d2\3\2\2\2\u00db\u00d8\3"+
		"\2\2\2\u00dc\u00dd\3\2\2\2\u00dd\u00de\5\4\3\2\u00de#\3\2\2\2\u00df\u00e4"+
		"\7\26\2\2\u00e0\u00e2\5\22\n\2\u00e1\u00e0\3\2\2\2\u00e1\u00e2\3\2\2\2"+
		"\u00e2\u00e5\3\2\2\2\u00e3\u00e5\5\4\3\2\u00e4\u00e1\3\2\2\2\u00e4\u00e3"+
		"\3\2\2\2\u00e5%\3\2\2\2\u00e6\u00e7\7$\2\2\u00e7\'\3\2\2\2\u00e8\u00e9"+
		"\7\30\2\2\u00e9)\3\2\2\2\u00ea\u00eb\7\31\2\2\u00eb+\3\2\2\2\u00ec\u00ed"+
		"\7\32\2\2\u00ed-\3\2\2\2\u00ee\u00ef\7\33\2\2\u00ef/\3\2\2\2\u00f0\u00f1"+
		"\7\34\2\2\u00f1\61\3\2\2\2\u00f2\u00f3\7\35\2\2\u00f3\63\3\2\2\2\u00f4"+
		"\u00f5\7\36\2\2\u00f5\65\3\2\2\2\u00f6\u00f7\7\37\2\2\u00f7\67\3\2\2\2"+
		"\u00f8\u00f9\7 \2\2\u00f99\3\2\2\2\u00fa\u00fb\7!\2\2\u00fb;\3\2\2\2\u00fc"+
		"\u00fd\7\"\2\2\u00fd=\3\2\2\2\u00fe\u00ff\7#\2\2\u00ff?\3\2\2\2\u0100"+
		"\u0104\7\21\2\2\u0101\u0103\5B\"\2\u0102\u0101\3\2\2\2\u0103\u0106\3\2"+
		"\2\2\u0104\u0102\3\2\2\2\u0104\u0105\3\2\2\2\u0105\u010a\3\2\2\2\u0106"+
		"\u0104\3\2\2\2\u0107\u0109\5F$\2\u0108\u0107\3\2\2\2\u0109\u010c\3\2\2"+
		"\2\u010a\u0108\3\2\2\2\u010a\u010b\3\2\2\2\u010bA\3\2\2\2\u010c\u010a"+
		"\3\2\2\2\u010d\u0110\5\n\6\2\u010e\u0110\5D#\2\u010f\u010d\3\2\2\2\u010f"+
		"\u010e\3\2\2\2\u0110C\3\2\2\2\u0111\u0112\7$\2\2\u0112E\3\2\2\2\u0113"+
		"\u0114\7\60\2\2\u0114G\3\2\2\2\32KSZ_els}\u0081\u0083\u0088\u008e\u0097"+
		"\u00a5\u00aa\u00b1\u00bf\u00c5\u00db\u00e1\u00e4\u0104\u010a\u010f";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}