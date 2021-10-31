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
		COMMENT=1, ASSIGN=2, DOLLAR=3, LPAREN=4, RPAREN=5, LBRACE=6, RBRACE=7, 
		PERCENT=8, COMMA=9, ESC=10, SQUOTE=11, DQUOTE=12, CONTINUATION=13, EOL=14, 
		TARGET=15, IFDEF=16, IFNDEF=17, IFEQ=18, IFNEQ=19, ELSE=20, ENDIF=21, 
		EXPORT=22, UNEXPORT=23, VPATH=24, INCLUDE=25, MINCLUDE=26, SINCLUDE=27, 
		LOAD=28, MLOAD=29, DEFINE=30, UNDEFINE=31, OVERRIDE=32, PRIVATE=33, WORD=34, 
		WS=35, RULE_CONTINUATION=36, PREREQUISITE=37, RULE_WS=38, RULE_EOL=39, 
		SHELL_CMD=40, RECEIPT_CONTINUATION=41;
	public static final int
		RULE_program = 0, RULE_stmts = 1, RULE_stmt = 2, RULE_var = 3, RULE_varDef = 4, 
		RULE_varRef = 5, RULE_directive = 6, RULE_conditionalDirective = 7, RULE_otherDirective = 8, 
		RULE_ifDefCondition = 9, RULE_ifNdefCondition = 10, RULE_ifEqCondition = 11, 
		RULE_quotedVarRef = 12, RULE_squotedVarRef = 13, RULE_dquotedVarRef = 14, 
		RULE_ifNeqCondition = 15, RULE_elseClause = 16, RULE_varName = 17, RULE_exportDirective = 18, 
		RULE_unexportDirective = 19, RULE_vpathDirective = 20, RULE_includeDirective = 21, 
		RULE_mincludeDirective = 22, RULE_sincludeDirective = 23, RULE_loadDirective = 24, 
		RULE_mloadDirective = 25, RULE_defineDirective = 26, RULE_undefineDirective = 27, 
		RULE_overrideDirective = 28, RULE_privateDirective = 29, RULE_ruleDef = 30, 
		RULE_prerequisite = 31, RULE_targetRef = 32, RULE_shellCmd = 33;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "stmts", "stmt", "var", "varDef", "varRef", "directive", "conditionalDirective", 
			"otherDirective", "ifDefCondition", "ifNdefCondition", "ifEqCondition", 
			"quotedVarRef", "squotedVarRef", "dquotedVarRef", "ifNeqCondition", "elseClause", 
			"varName", "exportDirective", "unexportDirective", "vpathDirective", 
			"includeDirective", "mincludeDirective", "sincludeDirective", "loadDirective", 
			"mloadDirective", "defineDirective", "undefineDirective", "overrideDirective", 
			"privateDirective", "ruleDef", "prerequisite", "targetRef", "shellCmd"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, "'$'", "'('", "')'", "'{'", "'}'", "'%'", "','", "'\\'", 
			"'''", "'\"'", null, null, null, "'ifdef'", "'ifndef'", "'ifeq'", "'ifneq'", 
			"'else'", "'endif'", "'export'", "'unexport'", "'vpath'", "'include'", 
			"'-include'", "'sinclude'", "'load'", "'-load'", "'define'", "'undefined'", 
			"'override'", "'private'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "COMMENT", "ASSIGN", "DOLLAR", "LPAREN", "RPAREN", "LBRACE", "RBRACE", 
			"PERCENT", "COMMA", "ESC", "SQUOTE", "DQUOTE", "CONTINUATION", "EOL", 
			"TARGET", "IFDEF", "IFNDEF", "IFEQ", "IFNEQ", "ELSE", "ENDIF", "EXPORT", 
			"UNEXPORT", "VPATH", "INCLUDE", "MINCLUDE", "SINCLUDE", "LOAD", "MLOAD", 
			"DEFINE", "UNDEFINE", "OVERRIDE", "PRIVATE", "WORD", "WS", "RULE_CONTINUATION", 
			"PREREQUISITE", "RULE_WS", "RULE_EOL", "SHELL_CMD", "RECEIPT_CONTINUATION"
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
			setState(71);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOLLAR) | (1L << EOL) | (1L << TARGET) | (1L << IFDEF) | (1L << IFNDEF) | (1L << IFEQ) | (1L << IFNEQ) | (1L << EXPORT) | (1L << UNEXPORT) | (1L << VPATH) | (1L << INCLUDE) | (1L << MINCLUDE) | (1L << SINCLUDE) | (1L << LOAD) | (1L << MLOAD) | (1L << DEFINE) | (1L << UNDEFINE) | (1L << OVERRIDE) | (1L << PRIVATE) | (1L << WORD))) != 0)) {
				{
				{
				setState(68);
				stmts();
				}
				}
				setState(73);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(74);
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
			setState(79);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==EOL) {
				{
				{
				setState(76);
				match(EOL);
				}
				}
				setState(81);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(82);
			stmt();
			setState(91);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(84); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(83);
						match(EOL);
						}
						}
						setState(86); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==EOL );
					setState(88);
					stmt();
					}
					} 
				}
				setState(93);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			}
			setState(97);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(94);
					match(EOL);
					}
					} 
				}
				setState(99);
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
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public DirectiveContext directive() {
			return getRuleContext(DirectiveContext.class,0);
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
			setState(103);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DOLLAR:
			case WORD:
				{
				setState(100);
				var();
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
				setState(101);
				directive();
				}
				break;
			case TARGET:
				{
				setState(102);
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

	public static class VarContext extends ParserRuleContext {
		public VarDefContext varDef() {
			return getRuleContext(VarDefContext.class,0);
		}
		public VarRefContext varRef() {
			return getRuleContext(VarRefContext.class,0);
		}
		public VarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MakeParserListener ) ((MakeParserListener)listener).enterVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MakeParserListener ) ((MakeParserListener)listener).exitVar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MakeParserVisitor ) return ((MakeParserVisitor<? extends T>)visitor).visitVar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarContext var() throws RecognitionException {
		VarContext _localctx = new VarContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_var);
		try {
			setState(107);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case WORD:
				enterOuterAlt(_localctx, 1);
				{
				setState(105);
				varDef();
				}
				break;
			case DOLLAR:
				enterOuterAlt(_localctx, 2);
				{
				setState(106);
				varRef();
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
		enterRule(_localctx, 8, RULE_varDef);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(109);
			match(WORD);
			setState(110);
			match(ASSIGN);
			setState(112); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(111);
					match(WORD);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(114); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
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
		public TerminalNode DOLLAR() { return getToken(MakeParser.DOLLAR, 0); }
		public TerminalNode LPAREN() { return getToken(MakeParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(MakeParser.RPAREN, 0); }
		public TerminalNode LBRACE() { return getToken(MakeParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(MakeParser.RBRACE, 0); }
		public List<TerminalNode> WORD() { return getTokens(MakeParser.WORD); }
		public TerminalNode WORD(int i) {
			return getToken(MakeParser.WORD, i);
		}
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
		enterRule(_localctx, 10, RULE_varRef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(116);
			match(DOLLAR);
			setState(131);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPAREN:
				{
				{
				setState(117);
				match(LPAREN);
				setState(119); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(118);
					match(WORD);
					}
					}
					setState(121); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==WORD );
				setState(123);
				match(RPAREN);
				}
				}
				break;
			case LBRACE:
				{
				{
				setState(124);
				match(LBRACE);
				setState(126); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(125);
					match(WORD);
					}
					}
					setState(128); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==WORD );
				setState(130);
				match(RBRACE);
				}
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

	public static class DirectiveContext extends ParserRuleContext {
		public ConditionalDirectiveContext conditionalDirective() {
			return getRuleContext(ConditionalDirectiveContext.class,0);
		}
		public OtherDirectiveContext otherDirective() {
			return getRuleContext(OtherDirectiveContext.class,0);
		}
		public DirectiveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_directive; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MakeParserListener ) ((MakeParserListener)listener).enterDirective(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MakeParserListener ) ((MakeParserListener)listener).exitDirective(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MakeParserVisitor ) return ((MakeParserVisitor<? extends T>)visitor).visitDirective(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DirectiveContext directive() throws RecognitionException {
		DirectiveContext _localctx = new DirectiveContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_directive);
		try {
			setState(135);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IFDEF:
			case IFNDEF:
			case IFEQ:
			case IFNEQ:
				enterOuterAlt(_localctx, 1);
				{
				setState(133);
				conditionalDirective();
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
				setState(134);
				otherDirective();
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

	public static class ConditionalDirectiveContext extends ParserRuleContext {
		public StmtsContext stmts() {
			return getRuleContext(StmtsContext.class,0);
		}
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
		public ElseClauseContext elseClause() {
			return getRuleContext(ElseClauseContext.class,0);
		}
		public TerminalNode ENDIF() { return getToken(MakeParser.ENDIF, 0); }
		public ConditionalDirectiveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conditionalDirective; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MakeParserListener ) ((MakeParserListener)listener).enterConditionalDirective(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MakeParserListener ) ((MakeParserListener)listener).exitConditionalDirective(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MakeParserVisitor ) return ((MakeParserVisitor<? extends T>)visitor).visitConditionalDirective(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionalDirectiveContext conditionalDirective() throws RecognitionException {
		ConditionalDirectiveContext _localctx = new ConditionalDirectiveContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_conditionalDirective);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(141);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IFDEF:
				{
				setState(137);
				ifDefCondition();
				}
				break;
			case IFNDEF:
				{
				setState(138);
				ifNdefCondition();
				}
				break;
			case IFEQ:
				{
				setState(139);
				ifEqCondition();
				}
				break;
			case IFNEQ:
				{
				setState(140);
				ifNeqCondition();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(143);
			stmts();
			setState(146);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ELSE:
				{
				setState(144);
				elseClause();
				}
				break;
			case ENDIF:
				{
				setState(145);
				match(ENDIF);
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

	public static class OtherDirectiveContext extends ParserRuleContext {
		public ExportDirectiveContext exportDirective() {
			return getRuleContext(ExportDirectiveContext.class,0);
		}
		public UnexportDirectiveContext unexportDirective() {
			return getRuleContext(UnexportDirectiveContext.class,0);
		}
		public VpathDirectiveContext vpathDirective() {
			return getRuleContext(VpathDirectiveContext.class,0);
		}
		public IncludeDirectiveContext includeDirective() {
			return getRuleContext(IncludeDirectiveContext.class,0);
		}
		public MincludeDirectiveContext mincludeDirective() {
			return getRuleContext(MincludeDirectiveContext.class,0);
		}
		public SincludeDirectiveContext sincludeDirective() {
			return getRuleContext(SincludeDirectiveContext.class,0);
		}
		public LoadDirectiveContext loadDirective() {
			return getRuleContext(LoadDirectiveContext.class,0);
		}
		public MloadDirectiveContext mloadDirective() {
			return getRuleContext(MloadDirectiveContext.class,0);
		}
		public DefineDirectiveContext defineDirective() {
			return getRuleContext(DefineDirectiveContext.class,0);
		}
		public UndefineDirectiveContext undefineDirective() {
			return getRuleContext(UndefineDirectiveContext.class,0);
		}
		public OverrideDirectiveContext overrideDirective() {
			return getRuleContext(OverrideDirectiveContext.class,0);
		}
		public PrivateDirectiveContext privateDirective() {
			return getRuleContext(PrivateDirectiveContext.class,0);
		}
		public OtherDirectiveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_otherDirective; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MakeParserListener ) ((MakeParserListener)listener).enterOtherDirective(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MakeParserListener ) ((MakeParserListener)listener).exitOtherDirective(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MakeParserVisitor ) return ((MakeParserVisitor<? extends T>)visitor).visitOtherDirective(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OtherDirectiveContext otherDirective() throws RecognitionException {
		OtherDirectiveContext _localctx = new OtherDirectiveContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_otherDirective);
		try {
			setState(160);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case EXPORT:
				enterOuterAlt(_localctx, 1);
				{
				setState(148);
				exportDirective();
				}
				break;
			case UNEXPORT:
				enterOuterAlt(_localctx, 2);
				{
				setState(149);
				unexportDirective();
				}
				break;
			case VPATH:
				enterOuterAlt(_localctx, 3);
				{
				setState(150);
				vpathDirective();
				}
				break;
			case INCLUDE:
				enterOuterAlt(_localctx, 4);
				{
				setState(151);
				includeDirective();
				}
				break;
			case MINCLUDE:
				enterOuterAlt(_localctx, 5);
				{
				setState(152);
				mincludeDirective();
				}
				break;
			case SINCLUDE:
				enterOuterAlt(_localctx, 6);
				{
				setState(153);
				sincludeDirective();
				}
				break;
			case LOAD:
				enterOuterAlt(_localctx, 7);
				{
				setState(154);
				loadDirective();
				}
				break;
			case MLOAD:
				enterOuterAlt(_localctx, 8);
				{
				setState(155);
				mloadDirective();
				}
				break;
			case DEFINE:
				enterOuterAlt(_localctx, 9);
				{
				setState(156);
				defineDirective();
				}
				break;
			case UNDEFINE:
				enterOuterAlt(_localctx, 10);
				{
				setState(157);
				undefineDirective();
				}
				break;
			case OVERRIDE:
				enterOuterAlt(_localctx, 11);
				{
				setState(158);
				overrideDirective();
				}
				break;
			case PRIVATE:
				enterOuterAlt(_localctx, 12);
				{
				setState(159);
				privateDirective();
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
		enterRule(_localctx, 18, RULE_ifDefCondition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(162);
			match(IFDEF);
			setState(165);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DOLLAR:
				{
				setState(163);
				varRef();
				}
				break;
			case WORD:
				{
				setState(164);
				varName();
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

	public static class IfNdefConditionContext extends ParserRuleContext {
		public TerminalNode IFNDEF() { return getToken(MakeParser.IFNDEF, 0); }
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
		enterRule(_localctx, 20, RULE_ifNdefCondition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(167);
			match(IFNDEF);
			setState(170);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DOLLAR:
				{
				setState(168);
				varRef();
				}
				break;
			case WORD:
				{
				setState(169);
				varName();
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

	public static class IfEqConditionContext extends ParserRuleContext {
		public TerminalNode IFEQ() { return getToken(MakeParser.IFEQ, 0); }
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
		enterRule(_localctx, 22, RULE_ifEqCondition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(172);
			match(IFEQ);
			setState(182);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPAREN:
				{
				setState(173);
				match(LPAREN);
				setState(174);
				varRef();
				setState(175);
				match(COMMA);
				setState(176);
				varRef();
				setState(177);
				match(RPAREN);
				}
				break;
			case ESC:
			case DQUOTE:
				{
				setState(179);
				quotedVarRef();
				setState(180);
				quotedVarRef();
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
		enterRule(_localctx, 24, RULE_quotedVarRef);
		try {
			setState(186);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ESC:
				enterOuterAlt(_localctx, 1);
				{
				setState(184);
				squotedVarRef();
				}
				break;
			case DQUOTE:
				enterOuterAlt(_localctx, 2);
				{
				setState(185);
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
		enterRule(_localctx, 26, RULE_squotedVarRef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(188);
			match(ESC);
			setState(189);
			match(SQUOTE);
			setState(190);
			varRef();
			setState(191);
			match(ESC);
			setState(192);
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
		enterRule(_localctx, 28, RULE_dquotedVarRef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(194);
			match(DQUOTE);
			setState(195);
			varRef();
			setState(196);
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
		enterRule(_localctx, 30, RULE_ifNeqCondition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(198);
			match(IFNEQ);
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
		public ConditionalDirectiveContext conditionalDirective() {
			return getRuleContext(ConditionalDirectiveContext.class,0);
		}
		public StmtsContext stmts() {
			return getRuleContext(StmtsContext.class,0);
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
		enterRule(_localctx, 32, RULE_elseClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(200);
			match(ELSE);
			setState(203);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				{
				setState(201);
				conditionalDirective();
				}
				break;
			case 2:
				{
				setState(202);
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
		enterRule(_localctx, 34, RULE_varName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(205);
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

	public static class ExportDirectiveContext extends ParserRuleContext {
		public TerminalNode EXPORT() { return getToken(MakeParser.EXPORT, 0); }
		public ExportDirectiveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exportDirective; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MakeParserListener ) ((MakeParserListener)listener).enterExportDirective(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MakeParserListener ) ((MakeParserListener)listener).exitExportDirective(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MakeParserVisitor ) return ((MakeParserVisitor<? extends T>)visitor).visitExportDirective(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExportDirectiveContext exportDirective() throws RecognitionException {
		ExportDirectiveContext _localctx = new ExportDirectiveContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_exportDirective);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(207);
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

	public static class UnexportDirectiveContext extends ParserRuleContext {
		public TerminalNode UNEXPORT() { return getToken(MakeParser.UNEXPORT, 0); }
		public UnexportDirectiveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unexportDirective; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MakeParserListener ) ((MakeParserListener)listener).enterUnexportDirective(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MakeParserListener ) ((MakeParserListener)listener).exitUnexportDirective(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MakeParserVisitor ) return ((MakeParserVisitor<? extends T>)visitor).visitUnexportDirective(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnexportDirectiveContext unexportDirective() throws RecognitionException {
		UnexportDirectiveContext _localctx = new UnexportDirectiveContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_unexportDirective);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(209);
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

	public static class VpathDirectiveContext extends ParserRuleContext {
		public TerminalNode VPATH() { return getToken(MakeParser.VPATH, 0); }
		public VpathDirectiveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vpathDirective; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MakeParserListener ) ((MakeParserListener)listener).enterVpathDirective(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MakeParserListener ) ((MakeParserListener)listener).exitVpathDirective(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MakeParserVisitor ) return ((MakeParserVisitor<? extends T>)visitor).visitVpathDirective(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VpathDirectiveContext vpathDirective() throws RecognitionException {
		VpathDirectiveContext _localctx = new VpathDirectiveContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_vpathDirective);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(211);
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

	public static class IncludeDirectiveContext extends ParserRuleContext {
		public TerminalNode INCLUDE() { return getToken(MakeParser.INCLUDE, 0); }
		public IncludeDirectiveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_includeDirective; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MakeParserListener ) ((MakeParserListener)listener).enterIncludeDirective(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MakeParserListener ) ((MakeParserListener)listener).exitIncludeDirective(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MakeParserVisitor ) return ((MakeParserVisitor<? extends T>)visitor).visitIncludeDirective(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IncludeDirectiveContext includeDirective() throws RecognitionException {
		IncludeDirectiveContext _localctx = new IncludeDirectiveContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_includeDirective);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(213);
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

	public static class MincludeDirectiveContext extends ParserRuleContext {
		public TerminalNode MINCLUDE() { return getToken(MakeParser.MINCLUDE, 0); }
		public MincludeDirectiveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mincludeDirective; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MakeParserListener ) ((MakeParserListener)listener).enterMincludeDirective(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MakeParserListener ) ((MakeParserListener)listener).exitMincludeDirective(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MakeParserVisitor ) return ((MakeParserVisitor<? extends T>)visitor).visitMincludeDirective(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MincludeDirectiveContext mincludeDirective() throws RecognitionException {
		MincludeDirectiveContext _localctx = new MincludeDirectiveContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_mincludeDirective);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(215);
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

	public static class SincludeDirectiveContext extends ParserRuleContext {
		public TerminalNode SINCLUDE() { return getToken(MakeParser.SINCLUDE, 0); }
		public SincludeDirectiveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sincludeDirective; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MakeParserListener ) ((MakeParserListener)listener).enterSincludeDirective(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MakeParserListener ) ((MakeParserListener)listener).exitSincludeDirective(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MakeParserVisitor ) return ((MakeParserVisitor<? extends T>)visitor).visitSincludeDirective(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SincludeDirectiveContext sincludeDirective() throws RecognitionException {
		SincludeDirectiveContext _localctx = new SincludeDirectiveContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_sincludeDirective);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(217);
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

	public static class LoadDirectiveContext extends ParserRuleContext {
		public TerminalNode LOAD() { return getToken(MakeParser.LOAD, 0); }
		public LoadDirectiveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loadDirective; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MakeParserListener ) ((MakeParserListener)listener).enterLoadDirective(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MakeParserListener ) ((MakeParserListener)listener).exitLoadDirective(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MakeParserVisitor ) return ((MakeParserVisitor<? extends T>)visitor).visitLoadDirective(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LoadDirectiveContext loadDirective() throws RecognitionException {
		LoadDirectiveContext _localctx = new LoadDirectiveContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_loadDirective);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(219);
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

	public static class MloadDirectiveContext extends ParserRuleContext {
		public TerminalNode MLOAD() { return getToken(MakeParser.MLOAD, 0); }
		public MloadDirectiveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mloadDirective; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MakeParserListener ) ((MakeParserListener)listener).enterMloadDirective(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MakeParserListener ) ((MakeParserListener)listener).exitMloadDirective(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MakeParserVisitor ) return ((MakeParserVisitor<? extends T>)visitor).visitMloadDirective(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MloadDirectiveContext mloadDirective() throws RecognitionException {
		MloadDirectiveContext _localctx = new MloadDirectiveContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_mloadDirective);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(221);
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

	public static class DefineDirectiveContext extends ParserRuleContext {
		public TerminalNode DEFINE() { return getToken(MakeParser.DEFINE, 0); }
		public DefineDirectiveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_defineDirective; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MakeParserListener ) ((MakeParserListener)listener).enterDefineDirective(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MakeParserListener ) ((MakeParserListener)listener).exitDefineDirective(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MakeParserVisitor ) return ((MakeParserVisitor<? extends T>)visitor).visitDefineDirective(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DefineDirectiveContext defineDirective() throws RecognitionException {
		DefineDirectiveContext _localctx = new DefineDirectiveContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_defineDirective);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(223);
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

	public static class UndefineDirectiveContext extends ParserRuleContext {
		public TerminalNode UNDEFINE() { return getToken(MakeParser.UNDEFINE, 0); }
		public UndefineDirectiveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_undefineDirective; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MakeParserListener ) ((MakeParserListener)listener).enterUndefineDirective(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MakeParserListener ) ((MakeParserListener)listener).exitUndefineDirective(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MakeParserVisitor ) return ((MakeParserVisitor<? extends T>)visitor).visitUndefineDirective(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UndefineDirectiveContext undefineDirective() throws RecognitionException {
		UndefineDirectiveContext _localctx = new UndefineDirectiveContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_undefineDirective);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(225);
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

	public static class OverrideDirectiveContext extends ParserRuleContext {
		public TerminalNode OVERRIDE() { return getToken(MakeParser.OVERRIDE, 0); }
		public OverrideDirectiveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_overrideDirective; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MakeParserListener ) ((MakeParserListener)listener).enterOverrideDirective(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MakeParserListener ) ((MakeParserListener)listener).exitOverrideDirective(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MakeParserVisitor ) return ((MakeParserVisitor<? extends T>)visitor).visitOverrideDirective(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OverrideDirectiveContext overrideDirective() throws RecognitionException {
		OverrideDirectiveContext _localctx = new OverrideDirectiveContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_overrideDirective);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(227);
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

	public static class PrivateDirectiveContext extends ParserRuleContext {
		public TerminalNode PRIVATE() { return getToken(MakeParser.PRIVATE, 0); }
		public PrivateDirectiveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_privateDirective; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MakeParserListener ) ((MakeParserListener)listener).enterPrivateDirective(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MakeParserListener ) ((MakeParserListener)listener).exitPrivateDirective(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MakeParserVisitor ) return ((MakeParserVisitor<? extends T>)visitor).visitPrivateDirective(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrivateDirectiveContext privateDirective() throws RecognitionException {
		PrivateDirectiveContext _localctx = new PrivateDirectiveContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_privateDirective);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(229);
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
		enterRule(_localctx, 60, RULE_ruleDef);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(231);
			match(TARGET);
			setState(235);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(232);
					prerequisite();
					}
					} 
				}
				setState(237);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			}
			setState(241);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SHELL_CMD) {
				{
				{
				setState(238);
				shellCmd();
				}
				}
				setState(243);
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
		enterRule(_localctx, 62, RULE_prerequisite);
		try {
			setState(246);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DOLLAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(244);
				varRef();
				}
				break;
			case WORD:
				enterOuterAlt(_localctx, 2);
				{
				setState(245);
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
		enterRule(_localctx, 64, RULE_targetRef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(248);
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
		enterRule(_localctx, 66, RULE_shellCmd);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(250);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3+\u00ff\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\3\2\7\2H\n\2\f\2\16\2K\13\2\3\2\3\2\3\3\7\3P\n\3\f\3"+
		"\16\3S\13\3\3\3\3\3\6\3W\n\3\r\3\16\3X\3\3\7\3\\\n\3\f\3\16\3_\13\3\3"+
		"\3\7\3b\n\3\f\3\16\3e\13\3\3\4\3\4\3\4\5\4j\n\4\3\5\3\5\5\5n\n\5\3\6\3"+
		"\6\3\6\6\6s\n\6\r\6\16\6t\3\7\3\7\3\7\6\7z\n\7\r\7\16\7{\3\7\3\7\3\7\6"+
		"\7\u0081\n\7\r\7\16\7\u0082\3\7\5\7\u0086\n\7\3\b\3\b\5\b\u008a\n\b\3"+
		"\t\3\t\3\t\3\t\5\t\u0090\n\t\3\t\3\t\3\t\5\t\u0095\n\t\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u00a3\n\n\3\13\3\13\3\13\5\13\u00a8"+
		"\n\13\3\f\3\f\3\f\5\f\u00ad\n\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\5\r\u00b9\n\r\3\16\3\16\5\16\u00bd\n\16\3\17\3\17\3\17\3\17\3\17\3"+
		"\17\3\20\3\20\3\20\3\20\3\21\3\21\3\22\3\22\3\22\5\22\u00ce\n\22\3\23"+
		"\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32"+
		"\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \7 \u00ec"+
		"\n \f \16 \u00ef\13 \3 \7 \u00f2\n \f \16 \u00f5\13 \3!\3!\5!\u00f9\n"+
		"!\3\"\3\"\3#\3#\3#\2\2$\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*"+
		",.\60\62\64\668:<>@BD\2\2\2\u0100\2I\3\2\2\2\4Q\3\2\2\2\6i\3\2\2\2\bm"+
		"\3\2\2\2\no\3\2\2\2\fv\3\2\2\2\16\u0089\3\2\2\2\20\u008f\3\2\2\2\22\u00a2"+
		"\3\2\2\2\24\u00a4\3\2\2\2\26\u00a9\3\2\2\2\30\u00ae\3\2\2\2\32\u00bc\3"+
		"\2\2\2\34\u00be\3\2\2\2\36\u00c4\3\2\2\2 \u00c8\3\2\2\2\"\u00ca\3\2\2"+
		"\2$\u00cf\3\2\2\2&\u00d1\3\2\2\2(\u00d3\3\2\2\2*\u00d5\3\2\2\2,\u00d7"+
		"\3\2\2\2.\u00d9\3\2\2\2\60\u00db\3\2\2\2\62\u00dd\3\2\2\2\64\u00df\3\2"+
		"\2\2\66\u00e1\3\2\2\28\u00e3\3\2\2\2:\u00e5\3\2\2\2<\u00e7\3\2\2\2>\u00e9"+
		"\3\2\2\2@\u00f8\3\2\2\2B\u00fa\3\2\2\2D\u00fc\3\2\2\2FH\5\4\3\2GF\3\2"+
		"\2\2HK\3\2\2\2IG\3\2\2\2IJ\3\2\2\2JL\3\2\2\2KI\3\2\2\2LM\7\2\2\3M\3\3"+
		"\2\2\2NP\7\20\2\2ON\3\2\2\2PS\3\2\2\2QO\3\2\2\2QR\3\2\2\2RT\3\2\2\2SQ"+
		"\3\2\2\2T]\5\6\4\2UW\7\20\2\2VU\3\2\2\2WX\3\2\2\2XV\3\2\2\2XY\3\2\2\2"+
		"YZ\3\2\2\2Z\\\5\6\4\2[V\3\2\2\2\\_\3\2\2\2][\3\2\2\2]^\3\2\2\2^c\3\2\2"+
		"\2_]\3\2\2\2`b\7\20\2\2a`\3\2\2\2be\3\2\2\2ca\3\2\2\2cd\3\2\2\2d\5\3\2"+
		"\2\2ec\3\2\2\2fj\5\b\5\2gj\5\16\b\2hj\5> \2if\3\2\2\2ig\3\2\2\2ih\3\2"+
		"\2\2j\7\3\2\2\2kn\5\n\6\2ln\5\f\7\2mk\3\2\2\2ml\3\2\2\2n\t\3\2\2\2op\7"+
		"$\2\2pr\7\4\2\2qs\7$\2\2rq\3\2\2\2st\3\2\2\2tr\3\2\2\2tu\3\2\2\2u\13\3"+
		"\2\2\2v\u0085\7\5\2\2wy\7\6\2\2xz\7$\2\2yx\3\2\2\2z{\3\2\2\2{y\3\2\2\2"+
		"{|\3\2\2\2|}\3\2\2\2}\u0086\7\7\2\2~\u0080\7\b\2\2\177\u0081\7$\2\2\u0080"+
		"\177\3\2\2\2\u0081\u0082\3\2\2\2\u0082\u0080\3\2\2\2\u0082\u0083\3\2\2"+
		"\2\u0083\u0084\3\2\2\2\u0084\u0086\7\t\2\2\u0085w\3\2\2\2\u0085~\3\2\2"+
		"\2\u0086\r\3\2\2\2\u0087\u008a\5\20\t\2\u0088\u008a\5\22\n\2\u0089\u0087"+
		"\3\2\2\2\u0089\u0088\3\2\2\2\u008a\17\3\2\2\2\u008b\u0090\5\24\13\2\u008c"+
		"\u0090\5\26\f\2\u008d\u0090\5\30\r\2\u008e\u0090\5 \21\2\u008f\u008b\3"+
		"\2\2\2\u008f\u008c\3\2\2\2\u008f\u008d\3\2\2\2\u008f\u008e\3\2\2\2\u0090"+
		"\u0091\3\2\2\2\u0091\u0094\5\4\3\2\u0092\u0095\5\"\22\2\u0093\u0095\7"+
		"\27\2\2\u0094\u0092\3\2\2\2\u0094\u0093\3\2\2\2\u0095\21\3\2\2\2\u0096"+
		"\u00a3\5&\24\2\u0097\u00a3\5(\25\2\u0098\u00a3\5*\26\2\u0099\u00a3\5,"+
		"\27\2\u009a\u00a3\5.\30\2\u009b\u00a3\5\60\31\2\u009c\u00a3\5\62\32\2"+
		"\u009d\u00a3\5\64\33\2\u009e\u00a3\5\66\34\2\u009f\u00a3\58\35\2\u00a0"+
		"\u00a3\5:\36\2\u00a1\u00a3\5<\37\2\u00a2\u0096\3\2\2\2\u00a2\u0097\3\2"+
		"\2\2\u00a2\u0098\3\2\2\2\u00a2\u0099\3\2\2\2\u00a2\u009a\3\2\2\2\u00a2"+
		"\u009b\3\2\2\2\u00a2\u009c\3\2\2\2\u00a2\u009d\3\2\2\2\u00a2\u009e\3\2"+
		"\2\2\u00a2\u009f\3\2\2\2\u00a2\u00a0\3\2\2\2\u00a2\u00a1\3\2\2\2\u00a3"+
		"\23\3\2\2\2\u00a4\u00a7\7\22\2\2\u00a5\u00a8\5\f\7\2\u00a6\u00a8\5$\23"+
		"\2\u00a7\u00a5\3\2\2\2\u00a7\u00a6\3\2\2\2\u00a8\25\3\2\2\2\u00a9\u00ac"+
		"\7\23\2\2\u00aa\u00ad\5\f\7\2\u00ab\u00ad\5$\23\2\u00ac\u00aa\3\2\2\2"+
		"\u00ac\u00ab\3\2\2\2\u00ad\27\3\2\2\2\u00ae\u00b8\7\24\2\2\u00af\u00b0"+
		"\7\6\2\2\u00b0\u00b1\5\f\7\2\u00b1\u00b2\7\13\2\2\u00b2\u00b3\5\f\7\2"+
		"\u00b3\u00b4\7\7\2\2\u00b4\u00b9\3\2\2\2\u00b5\u00b6\5\32\16\2\u00b6\u00b7"+
		"\5\32\16\2\u00b7\u00b9\3\2\2\2\u00b8\u00af\3\2\2\2\u00b8\u00b5\3\2\2\2"+
		"\u00b9\31\3\2\2\2\u00ba\u00bd\5\34\17\2\u00bb\u00bd\5\36\20\2\u00bc\u00ba"+
		"\3\2\2\2\u00bc\u00bb\3\2\2\2\u00bd\33\3\2\2\2\u00be\u00bf\7\f\2\2\u00bf"+
		"\u00c0\7\r\2\2\u00c0\u00c1\5\f\7\2\u00c1\u00c2\7\f\2\2\u00c2\u00c3\7\r"+
		"\2\2\u00c3\35\3\2\2\2\u00c4\u00c5\7\16\2\2\u00c5\u00c6\5\f\7\2\u00c6\u00c7"+
		"\7\16\2\2\u00c7\37\3\2\2\2\u00c8\u00c9\7\25\2\2\u00c9!\3\2\2\2\u00ca\u00cd"+
		"\7\26\2\2\u00cb\u00ce\5\20\t\2\u00cc\u00ce\5\4\3\2\u00cd\u00cb\3\2\2\2"+
		"\u00cd\u00cc\3\2\2\2\u00ce#\3\2\2\2\u00cf\u00d0\7$\2\2\u00d0%\3\2\2\2"+
		"\u00d1\u00d2\7\30\2\2\u00d2\'\3\2\2\2\u00d3\u00d4\7\31\2\2\u00d4)\3\2"+
		"\2\2\u00d5\u00d6\7\32\2\2\u00d6+\3\2\2\2\u00d7\u00d8\7\33\2\2\u00d8-\3"+
		"\2\2\2\u00d9\u00da\7\34\2\2\u00da/\3\2\2\2\u00db\u00dc\7\35\2\2\u00dc"+
		"\61\3\2\2\2\u00dd\u00de\7\36\2\2\u00de\63\3\2\2\2\u00df\u00e0\7\37\2\2"+
		"\u00e0\65\3\2\2\2\u00e1\u00e2\7 \2\2\u00e2\67\3\2\2\2\u00e3\u00e4\7!\2"+
		"\2\u00e49\3\2\2\2\u00e5\u00e6\7\"\2\2\u00e6;\3\2\2\2\u00e7\u00e8\7#\2"+
		"\2\u00e8=\3\2\2\2\u00e9\u00ed\7\21\2\2\u00ea\u00ec\5@!\2\u00eb\u00ea\3"+
		"\2\2\2\u00ec\u00ef\3\2\2\2\u00ed\u00eb\3\2\2\2\u00ed\u00ee\3\2\2\2\u00ee"+
		"\u00f3\3\2\2\2\u00ef\u00ed\3\2\2\2\u00f0\u00f2\5D#\2\u00f1\u00f0\3\2\2"+
		"\2\u00f2\u00f5\3\2\2\2\u00f3\u00f1\3\2\2\2\u00f3\u00f4\3\2\2\2\u00f4?"+
		"\3\2\2\2\u00f5\u00f3\3\2\2\2\u00f6\u00f9\5\f\7\2\u00f7\u00f9\5B\"\2\u00f8"+
		"\u00f6\3\2\2\2\u00f8\u00f7\3\2\2\2\u00f9A\3\2\2\2\u00fa\u00fb\7$\2\2\u00fb"+
		"C\3\2\2\2\u00fc\u00fd\7*\2\2\u00fdE\3\2\2\2\31IQX]cimt{\u0082\u0085\u0089"+
		"\u008f\u0094\u00a2\u00a7\u00ac\u00b8\u00bc\u00cd\u00ed\u00f3\u00f8";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}