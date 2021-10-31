// Generated from https://github.com/njcom/parser/make-parser/blob/main/src/MakeLexer.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MakeLexer extends BaseLexer {
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
		COMMENTS=2;
	public static final int
		VAR_REF_MODE=1, PREREQUISITE_MODE=2, RECEIPT_MODE=3;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN", "COMMENTS"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE", "VAR_REF_MODE", "PREREQUISITE_MODE", "RECEIPT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"COMMENT", "ASSIGN", "DOLLAR", "LPAREN", "RPAREN", "ESC", "SQUOTE", "DQUOTE", 
			"COMMA", "CONTINUATION", "EOL", "TARGET", "IFDEF", "IFNDEF", "IFEQ", 
			"IFNEQ", "ELSE", "ENDIF", "EXPORT", "UNEXPORT", "VPATH", "INCLUDE", "MINCLUDE", 
			"SINCLUDE", "LOAD", "MLOAD", "DEFINE", "UNDEFINE", "OVERRIDE", "PRIVATE", 
			"WORD", "WS", "VAR_REF_CONTINUATION", "VAR_REF_WS", "VAR_REF_LPAREN", 
			"VAR_REF_LBRACE", "VAR_REF_RPAREN", "VAR_REF_RBRACE", "VAR_REF_TEXT", 
			"VAR_REF_DOLLAR", "PREREQUISITE_CONTINUATION", "PREREQUISITE", "PREREQUISITE_WS", 
			"PREREQUISITE_COMMENT", "PREREQUISITE_EOL", "RECEIPT_COMMENT", "SHELL_CMD", 
			"RECEIPT_CONTINUATION", "RECEIPT_EOL", "OTHER", "Hws", "Vws", "LineComment", 
			"Continuation"
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


	public MakeLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "MakeLexer.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\62\u0195\b\1\b\1"+
		"\b\1\b\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t"+
		"\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21"+
		"\t\21\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30"+
		"\t\30\4\31\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37"+
		"\t\37\4 \t \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)"+
		"\4*\t*\4+\t+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63"+
		"\t\63\4\64\t\64\4\65\t\65\4\66\t\66\4\67\t\67\3\2\3\2\3\2\3\2\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3\u0083\n\3\3\4\3\4\3\4\3\4"+
		"\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\13\3"+
		"\13\3\f\6\f\u009b\n\f\r\f\16\f\u009c\3\f\3\f\3\r\6\r\u00a2\n\r\r\r\16"+
		"\r\u00a3\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31"+
		"\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33"+
		"\3\33\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\35"+
		"\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\37\3\37"+
		"\3\37\3\37\3\37\3\37\3\37\3\37\3 \6 \u012a\n \r \16 \u012b\3!\3!\3!\3"+
		"!\3\"\3\"\3\"\3\"\3#\6#\u0137\n#\r#\16#\u0138\3#\3#\3$\3$\3%\3%\3&\3&"+
		"\3&\3&\3\'\3\'\3\'\3\'\3(\6(\u014a\n(\r(\16(\u014b\3)\3)\3)\3)\3)\3*\3"+
		"*\3*\3*\3*\3+\6+\u0159\n+\r+\16+\u015a\3,\3,\3,\3,\3-\3-\3-\3-\3.\6.\u0166"+
		"\n.\r.\16.\u0167\3.\3.\3.\3/\3/\3/\3/\3\60\3\60\6\60\u0173\n\60\r\60\16"+
		"\60\u0174\3\61\3\61\3\61\3\61\3\61\3\62\6\62\u017d\n\62\r\62\16\62\u017e"+
		"\3\62\3\62\3\63\3\63\3\63\3\63\3\63\3\64\3\64\3\65\3\65\3\66\3\66\7\66"+
		"\u018e\n\66\f\66\16\66\u0191\13\66\3\67\3\67\3\67\2\28\6\6\b\7\n\b\f\t"+
		"\16\n\20\13\22\f\24\r\26\16\30\17\32\20\34\21\36\22 \23\"\24$\25&\26("+
		"\27*\30,\31.\32\60\33\62\34\64\35\66\368\37: <!>\"@#B$D%F&H\'J(L)N\4P"+
		"\5R*T+V,X-Z.\\\2^/`\2b\60d\61f\62h\2j\2l\2n\2p\2\6\2\3\4\5\n\4\2\f\f\16"+
		"\17\f\2\13\f\16\17\"\"$$&&)+..^^}}\177\177\5\2\13\13\16\16\"\"\t\2\13"+
		"\f\16\17&&*+^^}}\177\177\t\2\f\f\16\17\"\"&&*+}}\177\177\4\2\16\16\"\""+
		"\3\2\13\13\4\2\13\13\"\"\2\u019c\2\6\3\2\2\2\2\b\3\2\2\2\2\n\3\2\2\2\2"+
		"\f\3\2\2\2\2\16\3\2\2\2\2\20\3\2\2\2\2\22\3\2\2\2\2\24\3\2\2\2\2\26\3"+
		"\2\2\2\2\30\3\2\2\2\2\32\3\2\2\2\2\34\3\2\2\2\2\36\3\2\2\2\2 \3\2\2\2"+
		"\2\"\3\2\2\2\2$\3\2\2\2\2&\3\2\2\2\2(\3\2\2\2\2*\3\2\2\2\2,\3\2\2\2\2"+
		".\3\2\2\2\2\60\3\2\2\2\2\62\3\2\2\2\2\64\3\2\2\2\2\66\3\2\2\2\28\3\2\2"+
		"\2\2:\3\2\2\2\2<\3\2\2\2\2>\3\2\2\2\2@\3\2\2\2\2B\3\2\2\2\2D\3\2\2\2\3"+
		"F\3\2\2\2\3H\3\2\2\2\3J\3\2\2\2\3L\3\2\2\2\3N\3\2\2\2\3P\3\2\2\2\3R\3"+
		"\2\2\2\3T\3\2\2\2\4V\3\2\2\2\4X\3\2\2\2\4Z\3\2\2\2\4\\\3\2\2\2\4^\3\2"+
		"\2\2\5`\3\2\2\2\5b\3\2\2\2\5d\3\2\2\2\5f\3\2\2\2\5h\3\2\2\2\6r\3\2\2\2"+
		"\b\u0082\3\2\2\2\n\u0084\3\2\2\2\f\u0089\3\2\2\2\16\u008b\3\2\2\2\20\u008d"+
		"\3\2\2\2\22\u008f\3\2\2\2\24\u0091\3\2\2\2\26\u0093\3\2\2\2\30\u0095\3"+
		"\2\2\2\32\u009a\3\2\2\2\34\u00a1\3\2\2\2\36\u00a9\3\2\2\2 \u00af\3\2\2"+
		"\2\"\u00b6\3\2\2\2$\u00bb\3\2\2\2&\u00c1\3\2\2\2(\u00c6\3\2\2\2*\u00cc"+
		"\3\2\2\2,\u00d3\3\2\2\2.\u00dc\3\2\2\2\60\u00e2\3\2\2\2\62\u00ea\3\2\2"+
		"\2\64\u00f3\3\2\2\2\66\u00fc\3\2\2\28\u0101\3\2\2\2:\u0107\3\2\2\2<\u010e"+
		"\3\2\2\2>\u0117\3\2\2\2@\u0120\3\2\2\2B\u0129\3\2\2\2D\u012d\3\2\2\2F"+
		"\u0131\3\2\2\2H\u0136\3\2\2\2J\u013c\3\2\2\2L\u013e\3\2\2\2N\u0140\3\2"+
		"\2\2P\u0144\3\2\2\2R\u0149\3\2\2\2T\u014d\3\2\2\2V\u0152\3\2\2\2X\u0158"+
		"\3\2\2\2Z\u015c\3\2\2\2\\\u0160\3\2\2\2^\u0165\3\2\2\2`\u016c\3\2\2\2"+
		"b\u0170\3\2\2\2d\u0176\3\2\2\2f\u017c\3\2\2\2h\u0182\3\2\2\2j\u0187\3"+
		"\2\2\2l\u0189\3\2\2\2n\u018b\3\2\2\2p\u0192\3\2\2\2rs\5n\66\2st\3\2\2"+
		"\2tu\b\2\2\2u\7\3\2\2\2vw\7<\2\2w\u0083\7?\2\2x\u0083\7?\2\2yz\7A\2\2"+
		"z\u0083\7?\2\2{|\7<\2\2|}\7<\2\2}\u0083\7?\2\2~\177\7-\2\2\177\u0083\7"+
		"?\2\2\u0080\u0081\7#\2\2\u0081\u0083\7?\2\2\u0082v\3\2\2\2\u0082x\3\2"+
		"\2\2\u0082y\3\2\2\2\u0082{\3\2\2\2\u0082~\3\2\2\2\u0082\u0080\3\2\2\2"+
		"\u0083\t\3\2\2\2\u0084\u0085\7&\2\2\u0085\u0086\3\2\2\2\u0086\u0087\b"+
		"\4\3\2\u0087\u0088\b\4\4\2\u0088\13\3\2\2\2\u0089\u008a\7*\2\2\u008a\r"+
		"\3\2\2\2\u008b\u008c\7+\2\2\u008c\17\3\2\2\2\u008d\u008e\7^\2\2\u008e"+
		"\21\3\2\2\2\u008f\u0090\7)\2\2\u0090\23\3\2\2\2\u0091\u0092\7$\2\2\u0092"+
		"\25\3\2\2\2\u0093\u0094\7.\2\2\u0094\27\3\2\2\2\u0095\u0096\5p\67\2\u0096"+
		"\u0097\3\2\2\2\u0097\u0098\b\13\3\2\u0098\31\3\2\2\2\u0099\u009b\5l\65"+
		"\2\u009a\u0099\3\2\2\2\u009b\u009c\3\2\2\2\u009c\u009a\3\2\2\2\u009c\u009d"+
		"\3\2\2\2\u009d\u009e\3\2\2\2\u009e\u009f\b\f\3\2\u009f\33\3\2\2\2\u00a0"+
		"\u00a2\n\2\2\2\u00a1\u00a0\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3\u00a1\3\2"+
		"\2\2\u00a3\u00a4\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5\u00a6\7<\2\2\u00a6"+
		"\u00a7\3\2\2\2\u00a7\u00a8\b\r\5\2\u00a8\35\3\2\2\2\u00a9\u00aa\7k\2\2"+
		"\u00aa\u00ab\7h\2\2\u00ab\u00ac\7f\2\2\u00ac\u00ad\7g\2\2\u00ad\u00ae"+
		"\7h\2\2\u00ae\37\3\2\2\2\u00af\u00b0\7k\2\2\u00b0\u00b1\7h\2\2\u00b1\u00b2"+
		"\7p\2\2\u00b2\u00b3\7f\2\2\u00b3\u00b4\7g\2\2\u00b4\u00b5\7h\2\2\u00b5"+
		"!\3\2\2\2\u00b6\u00b7\7k\2\2\u00b7\u00b8\7h\2\2\u00b8\u00b9\7g\2\2\u00b9"+
		"\u00ba\7s\2\2\u00ba#\3\2\2\2\u00bb\u00bc\7k\2\2\u00bc\u00bd\7h\2\2\u00bd"+
		"\u00be\7p\2\2\u00be\u00bf\7g\2\2\u00bf\u00c0\7s\2\2\u00c0%\3\2\2\2\u00c1"+
		"\u00c2\7g\2\2\u00c2\u00c3\7n\2\2\u00c3\u00c4\7u\2\2\u00c4\u00c5\7g\2\2"+
		"\u00c5\'\3\2\2\2\u00c6\u00c7\7g\2\2\u00c7\u00c8\7p\2\2\u00c8\u00c9\7f"+
		"\2\2\u00c9\u00ca\7k\2\2\u00ca\u00cb\7h\2\2\u00cb)\3\2\2\2\u00cc\u00cd"+
		"\7g\2\2\u00cd\u00ce\7z\2\2\u00ce\u00cf\7r\2\2\u00cf\u00d0\7q\2\2\u00d0"+
		"\u00d1\7t\2\2\u00d1\u00d2\7v\2\2\u00d2+\3\2\2\2\u00d3\u00d4\7w\2\2\u00d4"+
		"\u00d5\7p\2\2\u00d5\u00d6\7g\2\2\u00d6\u00d7\7z\2\2\u00d7\u00d8\7r\2\2"+
		"\u00d8\u00d9\7q\2\2\u00d9\u00da\7t\2\2\u00da\u00db\7v\2\2\u00db-\3\2\2"+
		"\2\u00dc\u00dd\7x\2\2\u00dd\u00de\7r\2\2\u00de\u00df\7c\2\2\u00df\u00e0"+
		"\7v\2\2\u00e0\u00e1\7j\2\2\u00e1/\3\2\2\2\u00e2\u00e3\7k\2\2\u00e3\u00e4"+
		"\7p\2\2\u00e4\u00e5\7e\2\2\u00e5\u00e6\7n\2\2\u00e6\u00e7\7w\2\2\u00e7"+
		"\u00e8\7f\2\2\u00e8\u00e9\7g\2\2\u00e9\61\3\2\2\2\u00ea\u00eb\7/\2\2\u00eb"+
		"\u00ec\7k\2\2\u00ec\u00ed\7p\2\2\u00ed\u00ee\7e\2\2\u00ee\u00ef\7n\2\2"+
		"\u00ef\u00f0\7w\2\2\u00f0\u00f1\7f\2\2\u00f1\u00f2\7g\2\2\u00f2\63\3\2"+
		"\2\2\u00f3\u00f4\7u\2\2\u00f4\u00f5\7k\2\2\u00f5\u00f6\7p\2\2\u00f6\u00f7"+
		"\7e\2\2\u00f7\u00f8\7n\2\2\u00f8\u00f9\7w\2\2\u00f9\u00fa\7f\2\2\u00fa"+
		"\u00fb\7g\2\2\u00fb\65\3\2\2\2\u00fc\u00fd\7n\2\2\u00fd\u00fe\7q\2\2\u00fe"+
		"\u00ff\7c\2\2\u00ff\u0100\7f\2\2\u0100\67\3\2\2\2\u0101\u0102\7/\2\2\u0102"+
		"\u0103\7n\2\2\u0103\u0104\7q\2\2\u0104\u0105\7c\2\2\u0105\u0106\7f\2\2"+
		"\u01069\3\2\2\2\u0107\u0108\7f\2\2\u0108\u0109\7g\2\2\u0109\u010a\7h\2"+
		"\2\u010a\u010b\7k\2\2\u010b\u010c\7p\2\2\u010c\u010d\7g\2\2\u010d;\3\2"+
		"\2\2\u010e\u010f\7w\2\2\u010f\u0110\7p\2\2\u0110\u0111\7f\2\2\u0111\u0112"+
		"\7g\2\2\u0112\u0113\7h\2\2\u0113\u0114\7k\2\2\u0114\u0115\7p\2\2\u0115"+
		"\u0116\7g\2\2\u0116=\3\2\2\2\u0117\u0118\7q\2\2\u0118\u0119\7x\2\2\u0119"+
		"\u011a\7g\2\2\u011a\u011b\7t\2\2\u011b\u011c\7t\2\2\u011c\u011d\7k\2\2"+
		"\u011d\u011e\7f\2\2\u011e\u011f\7g\2\2\u011f?\3\2\2\2\u0120\u0121\7r\2"+
		"\2\u0121\u0122\7t\2\2\u0122\u0123\7k\2\2\u0123\u0124\7x\2\2\u0124\u0125"+
		"\7c\2\2\u0125\u0126\7v\2\2\u0126\u0127\7g\2\2\u0127A\3\2\2\2\u0128\u012a"+
		"\n\3\2\2\u0129\u0128\3\2\2\2\u012a\u012b\3\2\2\2\u012b\u0129\3\2\2\2\u012b"+
		"\u012c\3\2\2\2\u012cC\3\2\2\2\u012d\u012e\t\4\2\2\u012e\u012f\3\2\2\2"+
		"\u012f\u0130\b!\3\2\u0130E\3\2\2\2\u0131\u0132\5p\67\2\u0132\u0133\3\2"+
		"\2\2\u0133\u0134\b\"\3\2\u0134G\3\2\2\2\u0135\u0137\5j\64\2\u0136\u0135"+
		"\3\2\2\2\u0137\u0138\3\2\2\2\u0138\u0136\3\2\2\2\u0138\u0139\3\2\2\2\u0139"+
		"\u013a\3\2\2\2\u013a\u013b\b#\3\2\u013bI\3\2\2\2\u013c\u013d\7*\2\2\u013d"+
		"K\3\2\2\2\u013e\u013f\7}\2\2\u013fM\3\2\2\2\u0140\u0141\7+\2\2\u0141\u0142"+
		"\3\2\2\2\u0142\u0143\b&\6\2\u0143O\3\2\2\2\u0144\u0145\7\177\2\2\u0145"+
		"\u0146\3\2\2\2\u0146\u0147\b\'\6\2\u0147Q\3\2\2\2\u0148\u014a\n\5\2\2"+
		"\u0149\u0148\3\2\2\2\u014a\u014b\3\2\2\2\u014b\u0149\3\2\2\2\u014b\u014c"+
		"\3\2\2\2\u014cS\3\2\2\2\u014d\u014e\7&\2\2\u014e\u014f\3\2\2\2\u014f\u0150"+
		"\b)\3\2\u0150\u0151\b)\4\2\u0151U\3\2\2\2\u0152\u0153\7^\2\2\u0153\u0154"+
		"\5l\65\2\u0154\u0155\3\2\2\2\u0155\u0156\b*\3\2\u0156W\3\2\2\2\u0157\u0159"+
		"\n\6\2\2\u0158\u0157\3\2\2\2\u0159\u015a\3\2\2\2\u015a\u0158\3\2\2\2\u015a"+
		"\u015b\3\2\2\2\u015bY\3\2\2\2\u015c\u015d\t\7\2\2\u015d\u015e\3\2\2\2"+
		"\u015e\u015f\b,\3\2\u015f[\3\2\2\2\u0160\u0161\5n\66\2\u0161\u0162\3\2"+
		"\2\2\u0162\u0163\b-\7\2\u0163]\3\2\2\2\u0164\u0166\5l\65\2\u0165\u0164"+
		"\3\2\2\2\u0166\u0167\3\2\2\2\u0167\u0165\3\2\2\2\u0167\u0168\3\2\2\2\u0168"+
		"\u0169\3\2\2\2\u0169\u016a\b.\3\2\u016a\u016b\b.\b\2\u016b_\3\2\2\2\u016c"+
		"\u016d\5n\66\2\u016d\u016e\3\2\2\2\u016e\u016f\b/\7\2\u016fa\3\2\2\2\u0170"+
		"\u0172\7\13\2\2\u0171\u0173\n\2\2\2\u0172\u0171\3\2\2\2\u0173\u0174\3"+
		"\2\2\2\u0174\u0172\3\2\2\2\u0174\u0175\3\2\2\2\u0175c\3\2\2\2\u0176\u0177"+
		"\7^\2\2\u0177\u0178\5l\65\2\u0178\u0179\3\2\2\2\u0179\u017a\b\61\3\2\u017a"+
		"e\3\2\2\2\u017b\u017d\5l\65\2\u017c\u017b\3\2\2\2\u017d\u017e\3\2\2\2"+
		"\u017e\u017c\3\2\2\2\u017e\u017f\3\2\2\2\u017f\u0180\3\2\2\2\u0180\u0181"+
		"\b\62\3\2\u0181g\3\2\2\2\u0182\u0183\n\b\2\2\u0183\u0184\3\2\2\2\u0184"+
		"\u0185\b\63\t\2\u0185\u0186\b\63\n\2\u0186i\3\2\2\2\u0187\u0188\t\t\2"+
		"\2\u0188k\3\2\2\2\u0189\u018a\t\2\2\2\u018am\3\2\2\2\u018b\u018f\7%\2"+
		"\2\u018c\u018e\n\2\2\2\u018d\u018c\3\2\2\2\u018e\u0191\3\2\2\2\u018f\u018d"+
		"\3\2\2\2\u018f\u0190\3\2\2\2\u0190o\3\2\2\2\u0191\u018f\3\2\2\2\u0192"+
		"\u0193\7^\2\2\u0193\u0194\5l\65\2\u0194q\3\2\2\2\21\2\3\4\5\u0082\u009c"+
		"\u00a3\u012b\u0138\u014b\u015a\u0167\u0174\u017e\u018f\13\2\4\2\b\2\2"+
		"\7\3\2\7\4\2\6\2\2\t\6\2\7\5\2\5\2\2\4\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}