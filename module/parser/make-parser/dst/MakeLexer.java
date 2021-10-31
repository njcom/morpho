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
		VAR_REF1_CONTINUATION=40, VAR_REF1_DOLLAR=41, VAR_REF_WORD_COMMA=42, VAR_REF_COMMA=43, 
		PREREQUISITE_CONTINUATION=44, PREREQUISITE=45, PREREQUISITE_WS=46, PREREQUISITE_EOL=47, 
		SHELL_CMD=48, RECEIPT_CONTINUATION=49;
	public static final int
		COMMENTS=2;
	public static final int
		VAR_REF_MODE=1, VAR_REF1_MODE=2, PREREQUISITE_MODE=3, RECEIPT_MODE=4;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN", "COMMENTS"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE", "VAR_REF_MODE", "VAR_REF1_MODE", "PREREQUISITE_MODE", 
		"RECEIPT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"COMMENT", "ASSIGN", "DOLLAR", "LPAREN", "RPAREN", "ESC", "SQUOTE", "DQUOTE", 
			"COMMA", "CONTINUATION", "EOL", "TARGET", "IFDEF", "IFNDEF", "IFEQ", 
			"IFNEQ", "ELSE", "ENDIF", "EXPORT", "UNEXPORT", "VPATH", "INCLUDE", "MINCLUDE", 
			"SINCLUDE", "LOAD", "MLOAD", "DEFINE", "UNDEFINE", "OVERRIDE", "PRIVATE", 
			"WORD", "WS", "VAR_REF_CONTINUATION", "VAR_REF_WS", "VAR_REF_LPAREN", 
			"VAR_REF_LBRACE", "VAR_REF1_CONTINUATION", "VAR_REF_RPAREN", "VAR_REF_RBRACE", 
			"VAR_REF1_DOLLAR", "VAR_REF1_WORD", "VAR_REF_WORD_COMMA", "VAR_REF_COMMA", 
			"PREREQUISITE_CONTINUATION", "PREREQUISITE", "PREREQUISITE_WS", "PREREQUISITE_COMMENT", 
			"PREREQUISITE_EOL", "RECEIPT_COMMENT", "SHELL_CMD", "RECEIPT_CONTINUATION", 
			"RECEIPT_EOL", "OTHER", "Hws", "Vws", "LineComment", "Continuation"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, "')'", "'\\'", "'''", 
			"'\"'", null, null, null, null, "'ifdef'", "'ifndef'", "'ifeq'", "'ifneq'", 
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
			"VAR_REF_LBRACE", "VAR_REF1_CONTINUATION", "VAR_REF1_DOLLAR", "VAR_REF_WORD_COMMA", 
			"VAR_REF_COMMA", "PREREQUISITE_CONTINUATION", "PREREQUISITE", "PREREQUISITE_WS", 
			"PREREQUISITE_EOL", "SHELL_CMD", "RECEIPT_CONTINUATION"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\63\u01ae\b\1\b\1"+
		"\b\1\b\1\b\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4"+
		"\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20"+
		"\4\21\t\21\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27"+
		"\4\30\t\30\4\31\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36"+
		"\4\37\t\37\4 \t \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4"+
		")\t)\4*\t*\4+\t+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62"+
		"\4\63\t\63\4\64\t\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\3"+
		"\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3\u008a"+
		"\n\3\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3"+
		"\n\3\13\3\13\3\13\3\13\3\f\6\f\u00a2\n\f\r\f\16\f\u00a3\3\r\6\r\u00a7"+
		"\n\r\r\r\16\r\u00a8\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31"+
		"\3\31\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33"+
		"\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35"+
		"\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36"+
		"\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3 \6 \u012f\n \r \16 \u0130\3"+
		"!\3!\3!\3!\3\"\3\"\3\"\3\"\3#\6#\u013c\n#\r#\16#\u013d\3#\3#\3$\3$\3$"+
		"\3$\3%\3%\3%\3%\3&\3&\3&\3&\3\'\3\'\3\'\3\'\3\'\3\'\3(\3(\3(\3(\3(\3("+
		"\3)\3)\3)\3)\3)\3*\6*\u0160\n*\r*\16*\u0161\3*\3*\3+\6+\u0167\n+\r+\16"+
		"+\u0168\3,\3,\3-\3-\3-\3-\3-\3.\6.\u0173\n.\r.\16.\u0174\3/\3/\3/\3/\3"+
		"\60\3\60\3\60\3\60\3\61\6\61\u0180\n\61\r\61\16\61\u0181\3\61\3\61\3\62"+
		"\3\62\3\62\3\62\3\63\3\63\6\63\u018c\n\63\r\63\16\63\u018d\3\64\3\64\3"+
		"\64\3\64\3\64\3\65\6\65\u0196\n\65\r\65\16\65\u0197\3\65\3\65\3\66\3\66"+
		"\3\66\3\66\3\66\3\67\3\67\38\38\39\39\79\u01a7\n9\f9\169\u01aa\139\3:"+
		"\3:\3:\2\2;\7\6\t\7\13\b\r\t\17\n\21\13\23\f\25\r\27\16\31\17\33\20\35"+
		"\21\37\22!\23#\24%\25\'\26)\27+\30-\31/\32\61\33\63\34\65\35\67\369\37"+
		"; =!?\"A#C$E%G&I\'K(M)O*Q\4S\5U+W\2Y,[-]._/a\60c\2e\61g\2i\62k\63m\2o"+
		"\2q\2s\2u\2w\2\7\2\3\4\5\6\13\4\2\f\f\16\17\f\2\13\f\16\17\"\"$$&&)+."+
		".^^}}\177\177\5\2\13\13\16\16\"\"\t\2\f\f\16\17&&*+..}}\177\177\b\2\f"+
		"\f\16\17&&*+}}\177\177\t\2\f\f\16\17\"\"&&*+}}\177\177\4\2\16\16\"\"\3"+
		"\2\13\13\4\2\13\13\"\"\2\u01b5\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2"+
		"\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3"+
		"\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2"+
		"\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2"+
		"/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2"+
		"\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\3"+
		"G\3\2\2\2\3I\3\2\2\2\3K\3\2\2\2\3M\3\2\2\2\4O\3\2\2\2\4Q\3\2\2\2\4S\3"+
		"\2\2\2\4U\3\2\2\2\4W\3\2\2\2\4Y\3\2\2\2\4[\3\2\2\2\5]\3\2\2\2\5_\3\2\2"+
		"\2\5a\3\2\2\2\5c\3\2\2\2\5e\3\2\2\2\6g\3\2\2\2\6i\3\2\2\2\6k\3\2\2\2\6"+
		"m\3\2\2\2\6o\3\2\2\2\7y\3\2\2\2\t\u0089\3\2\2\2\13\u008b\3\2\2\2\r\u0090"+
		"\3\2\2\2\17\u0092\3\2\2\2\21\u0094\3\2\2\2\23\u0096\3\2\2\2\25\u0098\3"+
		"\2\2\2\27\u009a\3\2\2\2\31\u009c\3\2\2\2\33\u00a1\3\2\2\2\35\u00a6\3\2"+
		"\2\2\37\u00ae\3\2\2\2!\u00b4\3\2\2\2#\u00bb\3\2\2\2%\u00c0\3\2\2\2\'\u00c6"+
		"\3\2\2\2)\u00cb\3\2\2\2+\u00d1\3\2\2\2-\u00d8\3\2\2\2/\u00e1\3\2\2\2\61"+
		"\u00e7\3\2\2\2\63\u00ef\3\2\2\2\65\u00f8\3\2\2\2\67\u0101\3\2\2\29\u0106"+
		"\3\2\2\2;\u010c\3\2\2\2=\u0113\3\2\2\2?\u011c\3\2\2\2A\u0125\3\2\2\2C"+
		"\u012e\3\2\2\2E\u0132\3\2\2\2G\u0136\3\2\2\2I\u013b\3\2\2\2K\u0141\3\2"+
		"\2\2M\u0145\3\2\2\2O\u0149\3\2\2\2Q\u014d\3\2\2\2S\u0153\3\2\2\2U\u0159"+
		"\3\2\2\2W\u015f\3\2\2\2Y\u0166\3\2\2\2[\u016a\3\2\2\2]\u016c\3\2\2\2_"+
		"\u0172\3\2\2\2a\u0176\3\2\2\2c\u017a\3\2\2\2e\u017f\3\2\2\2g\u0185\3\2"+
		"\2\2i\u0189\3\2\2\2k\u018f\3\2\2\2m\u0195\3\2\2\2o\u019b\3\2\2\2q\u01a0"+
		"\3\2\2\2s\u01a2\3\2\2\2u\u01a4\3\2\2\2w\u01ab\3\2\2\2yz\5u9\2z{\3\2\2"+
		"\2{|\b\2\2\2|\b\3\2\2\2}~\7<\2\2~\u008a\7?\2\2\177\u008a\7?\2\2\u0080"+
		"\u0081\7A\2\2\u0081\u008a\7?\2\2\u0082\u0083\7<\2\2\u0083\u0084\7<\2\2"+
		"\u0084\u008a\7?\2\2\u0085\u0086\7-\2\2\u0086\u008a\7?\2\2\u0087\u0088"+
		"\7#\2\2\u0088\u008a\7?\2\2\u0089}\3\2\2\2\u0089\177\3\2\2\2\u0089\u0080"+
		"\3\2\2\2\u0089\u0082\3\2\2\2\u0089\u0085\3\2\2\2\u0089\u0087\3\2\2\2\u008a"+
		"\n\3\2\2\2\u008b\u008c\7&\2\2\u008c\u008d\3\2\2\2\u008d\u008e\b\4\3\2"+
		"\u008e\u008f\b\4\4\2\u008f\f\3\2\2\2\u0090\u0091\7*\2\2\u0091\16\3\2\2"+
		"\2\u0092\u0093\7+\2\2\u0093\20\3\2\2\2\u0094\u0095\7^\2\2\u0095\22\3\2"+
		"\2\2\u0096\u0097\7)\2\2\u0097\24\3\2\2\2\u0098\u0099\7$\2\2\u0099\26\3"+
		"\2\2\2\u009a\u009b\7.\2\2\u009b\30\3\2\2\2\u009c\u009d\5w:\2\u009d\u009e"+
		"\3\2\2\2\u009e\u009f\b\13\3\2\u009f\32\3\2\2\2\u00a0\u00a2\5s8\2\u00a1"+
		"\u00a0\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3\u00a1\3\2\2\2\u00a3\u00a4\3\2"+
		"\2\2\u00a4\34\3\2\2\2\u00a5\u00a7\n\2\2\2\u00a6\u00a5\3\2\2\2\u00a7\u00a8"+
		"\3\2\2\2\u00a8\u00a6\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9\u00aa\3\2\2\2\u00aa"+
		"\u00ab\7<\2\2\u00ab\u00ac\3\2\2\2\u00ac\u00ad\b\r\5\2\u00ad\36\3\2\2\2"+
		"\u00ae\u00af\7k\2\2\u00af\u00b0\7h\2\2\u00b0\u00b1\7f\2\2\u00b1\u00b2"+
		"\7g\2\2\u00b2\u00b3\7h\2\2\u00b3 \3\2\2\2\u00b4\u00b5\7k\2\2\u00b5\u00b6"+
		"\7h\2\2\u00b6\u00b7\7p\2\2\u00b7\u00b8\7f\2\2\u00b8\u00b9\7g\2\2\u00b9"+
		"\u00ba\7h\2\2\u00ba\"\3\2\2\2\u00bb\u00bc\7k\2\2\u00bc\u00bd\7h\2\2\u00bd"+
		"\u00be\7g\2\2\u00be\u00bf\7s\2\2\u00bf$\3\2\2\2\u00c0\u00c1\7k\2\2\u00c1"+
		"\u00c2\7h\2\2\u00c2\u00c3\7p\2\2\u00c3\u00c4\7g\2\2\u00c4\u00c5\7s\2\2"+
		"\u00c5&\3\2\2\2\u00c6\u00c7\7g\2\2\u00c7\u00c8\7n\2\2\u00c8\u00c9\7u\2"+
		"\2\u00c9\u00ca\7g\2\2\u00ca(\3\2\2\2\u00cb\u00cc\7g\2\2\u00cc\u00cd\7"+
		"p\2\2\u00cd\u00ce\7f\2\2\u00ce\u00cf\7k\2\2\u00cf\u00d0\7h\2\2\u00d0*"+
		"\3\2\2\2\u00d1\u00d2\7g\2\2\u00d2\u00d3\7z\2\2\u00d3\u00d4\7r\2\2\u00d4"+
		"\u00d5\7q\2\2\u00d5\u00d6\7t\2\2\u00d6\u00d7\7v\2\2\u00d7,\3\2\2\2\u00d8"+
		"\u00d9\7w\2\2\u00d9\u00da\7p\2\2\u00da\u00db\7g\2\2\u00db\u00dc\7z\2\2"+
		"\u00dc\u00dd\7r\2\2\u00dd\u00de\7q\2\2\u00de\u00df\7t\2\2\u00df\u00e0"+
		"\7v\2\2\u00e0.\3\2\2\2\u00e1\u00e2\7x\2\2\u00e2\u00e3\7r\2\2\u00e3\u00e4"+
		"\7c\2\2\u00e4\u00e5\7v\2\2\u00e5\u00e6\7j\2\2\u00e6\60\3\2\2\2\u00e7\u00e8"+
		"\7k\2\2\u00e8\u00e9\7p\2\2\u00e9\u00ea\7e\2\2\u00ea\u00eb\7n\2\2\u00eb"+
		"\u00ec\7w\2\2\u00ec\u00ed\7f\2\2\u00ed\u00ee\7g\2\2\u00ee\62\3\2\2\2\u00ef"+
		"\u00f0\7/\2\2\u00f0\u00f1\7k\2\2\u00f1\u00f2\7p\2\2\u00f2\u00f3\7e\2\2"+
		"\u00f3\u00f4\7n\2\2\u00f4\u00f5\7w\2\2\u00f5\u00f6\7f\2\2\u00f6\u00f7"+
		"\7g\2\2\u00f7\64\3\2\2\2\u00f8\u00f9\7u\2\2\u00f9\u00fa\7k\2\2\u00fa\u00fb"+
		"\7p\2\2\u00fb\u00fc\7e\2\2\u00fc\u00fd\7n\2\2\u00fd\u00fe\7w\2\2\u00fe"+
		"\u00ff\7f\2\2\u00ff\u0100\7g\2\2\u0100\66\3\2\2\2\u0101\u0102\7n\2\2\u0102"+
		"\u0103\7q\2\2\u0103\u0104\7c\2\2\u0104\u0105\7f\2\2\u01058\3\2\2\2\u0106"+
		"\u0107\7/\2\2\u0107\u0108\7n\2\2\u0108\u0109\7q\2\2\u0109\u010a\7c\2\2"+
		"\u010a\u010b\7f\2\2\u010b:\3\2\2\2\u010c\u010d\7f\2\2\u010d\u010e\7g\2"+
		"\2\u010e\u010f\7h\2\2\u010f\u0110\7k\2\2\u0110\u0111\7p\2\2\u0111\u0112"+
		"\7g\2\2\u0112<\3\2\2\2\u0113\u0114\7w\2\2\u0114\u0115\7p\2\2\u0115\u0116"+
		"\7f\2\2\u0116\u0117\7g\2\2\u0117\u0118\7h\2\2\u0118\u0119\7k\2\2\u0119"+
		"\u011a\7p\2\2\u011a\u011b\7g\2\2\u011b>\3\2\2\2\u011c\u011d\7q\2\2\u011d"+
		"\u011e\7x\2\2\u011e\u011f\7g\2\2\u011f\u0120\7t\2\2\u0120\u0121\7t\2\2"+
		"\u0121\u0122\7k\2\2\u0122\u0123\7f\2\2\u0123\u0124\7g\2\2\u0124@\3\2\2"+
		"\2\u0125\u0126\7r\2\2\u0126\u0127\7t\2\2\u0127\u0128\7k\2\2\u0128\u0129"+
		"\7x\2\2\u0129\u012a\7c\2\2\u012a\u012b\7v\2\2\u012b\u012c\7g\2\2\u012c"+
		"B\3\2\2\2\u012d\u012f\n\3\2\2\u012e\u012d\3\2\2\2\u012f\u0130\3\2\2\2"+
		"\u0130\u012e\3\2\2\2\u0130\u0131\3\2\2\2\u0131D\3\2\2\2\u0132\u0133\t"+
		"\4\2\2\u0133\u0134\3\2\2\2\u0134\u0135\b!\3\2\u0135F\3\2\2\2\u0136\u0137"+
		"\5w:\2\u0137\u0138\3\2\2\2\u0138\u0139\b\"\3\2\u0139H\3\2\2\2\u013a\u013c"+
		"\5q\67\2\u013b\u013a\3\2\2\2\u013c\u013d\3\2\2\2\u013d\u013b\3\2\2\2\u013d"+
		"\u013e\3\2\2\2\u013e\u013f\3\2\2\2\u013f\u0140\b#\3\2\u0140J\3\2\2\2\u0141"+
		"\u0142\7*\2\2\u0142\u0143\3\2\2\2\u0143\u0144\b$\6\2\u0144L\3\2\2\2\u0145"+
		"\u0146\7}\2\2\u0146\u0147\3\2\2\2\u0147\u0148\b%\6\2\u0148N\3\2\2\2\u0149"+
		"\u014a\5w:\2\u014a\u014b\3\2\2\2\u014b\u014c\b&\3\2\u014cP\3\2\2\2\u014d"+
		"\u014e\7+\2\2\u014e\u014f\3\2\2\2\u014f\u0150\b\'\7\2\u0150\u0151\b\'"+
		"\7\2\u0151\u0152\b\'\b\2\u0152R\3\2\2\2\u0153\u0154\7\177\2\2\u0154\u0155"+
		"\3\2\2\2\u0155\u0156\b(\7\2\u0156\u0157\b(\7\2\u0157\u0158\b(\t\2\u0158"+
		"T\3\2\2\2\u0159\u015a\7&\2\2\u015a\u015b\3\2\2\2\u015b\u015c\b)\3\2\u015c"+
		"\u015d\b)\4\2\u015dV\3\2\2\2\u015e\u0160\n\5\2\2\u015f\u015e\3\2\2\2\u0160"+
		"\u0161\3\2\2\2\u0161\u015f\3\2\2\2\u0161\u0162\3\2\2\2\u0162\u0163\3\2"+
		"\2\2\u0163\u0164\b*\n\2\u0164X\3\2\2\2\u0165\u0167\n\6\2\2\u0166\u0165"+
		"\3\2\2\2\u0167\u0168\3\2\2\2\u0168\u0166\3\2\2\2\u0168\u0169\3\2\2\2\u0169"+
		"Z\3\2\2\2\u016a\u016b\7.\2\2\u016b\\\3\2\2\2\u016c\u016d\7^\2\2\u016d"+
		"\u016e\5s8\2\u016e\u016f\3\2\2\2\u016f\u0170\b-\3\2\u0170^\3\2\2\2\u0171"+
		"\u0173\n\7\2\2\u0172\u0171\3\2\2\2\u0173\u0174\3\2\2\2\u0174\u0172\3\2"+
		"\2\2\u0174\u0175\3\2\2\2\u0175`\3\2\2\2\u0176\u0177\t\b\2\2\u0177\u0178"+
		"\3\2\2\2\u0178\u0179\b/\3\2\u0179b\3\2\2\2\u017a\u017b\5u9\2\u017b\u017c"+
		"\3\2\2\2\u017c\u017d\b\60\13\2\u017dd\3\2\2\2\u017e\u0180\5s8\2\u017f"+
		"\u017e\3\2\2\2\u0180\u0181\3\2\2\2\u0181\u017f\3\2\2\2\u0181\u0182\3\2"+
		"\2\2\u0182\u0183\3\2\2\2\u0183\u0184\b\61\f\2\u0184f\3\2\2\2\u0185\u0186"+
		"\5u9\2\u0186\u0187\3\2\2\2\u0187\u0188\b\62\13\2\u0188h\3\2\2\2\u0189"+
		"\u018b\7\13\2\2\u018a\u018c\n\2\2\2\u018b\u018a\3\2\2\2\u018c\u018d\3"+
		"\2\2\2\u018d\u018b\3\2\2\2\u018d\u018e\3\2\2\2\u018ej\3\2\2\2\u018f\u0190"+
		"\7^\2\2\u0190\u0191\5s8\2\u0191\u0192\3\2\2\2\u0192\u0193\b\64\3\2\u0193"+
		"l\3\2\2\2\u0194\u0196\5s8\2\u0195\u0194\3\2\2\2\u0196\u0197\3\2\2\2\u0197"+
		"\u0195\3\2\2\2\u0197\u0198\3\2\2\2\u0198\u0199\3\2\2\2\u0199\u019a\b\65"+
		"\r\2\u019an\3\2\2\2\u019b\u019c\n\t\2\2\u019c\u019d\3\2\2\2\u019d\u019e"+
		"\b\66\16\2\u019e\u019f\b\66\17\2\u019fp\3\2\2\2\u01a0\u01a1\t\n\2\2\u01a1"+
		"r\3\2\2\2\u01a2\u01a3\t\2\2\2\u01a3t\3\2\2\2\u01a4\u01a8\7%\2\2\u01a5"+
		"\u01a7\n\2\2\2\u01a6\u01a5\3\2\2\2\u01a7\u01aa\3\2\2\2\u01a8\u01a6\3\2"+
		"\2\2\u01a8\u01a9\3\2\2\2\u01a9v\3\2\2\2\u01aa\u01a8\3\2\2\2\u01ab\u01ac"+
		"\7^\2\2\u01ac\u01ad\5s8\2\u01adx\3\2\2\2\23\2\3\4\5\6\u0089\u00a3\u00a8"+
		"\u0130\u013d\u0161\u0168\u0174\u0181\u018d\u0197\u01a8\20\2\4\2\b\2\2"+
		"\7\3\2\7\5\2\7\4\2\6\2\2\t\4\2\t\5\2\t\3\2\t\6\2\7\6\2\t\20\2\5\2\2\4"+
		"\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}