// Generated from D:/IdeaProjects/antlrcompiler/src/main/resources\g.g4 by ANTLR 4.7.2
package com.dastamn.antlrcompiler.gen;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class gLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, PROG_NAME=9, 
		VAR_TYPE=10, NUMBER=11, ID=12, STR=13, SEMI_COLON=14, COMA=15, UNDERSCORE=16, 
		L_PAREN=17, R_PAREN=18, TIMES=19, DIV=20, PLUS=21, MINUS=22, EQ=23, GT=24, 
		LT=25, L_BR=26, R_BR=27, COMMENT=28, WHITESPACE=29;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "DIGIT", 
			"LOWERCASE", "UPPERCASE", "ANYCASE", "INT", "FLOAT", "LINE_COMMENT", 
			"MULTI_LINE_COMMENT", "PROG_NAME", "VAR_TYPE", "NUMBER", "ID", "STR", 
			"SEMI_COLON", "COMA", "UNDERSCORE", "L_PAREN", "R_PAREN", "TIMES", "DIV", 
			"PLUS", "MINUS", "EQ", "GT", "LT", "L_BR", "R_BR", "COMMENT", "WHITESPACE"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'compil'", "'start'", "'endif'", "'if'", "'then'", "'else'", "'scancompil'", 
			"'printcompil'", null, null, null, null, null, "';'", "','", "'_'", "'('", 
			"')'", "'*'", "'/'", "'+'", "'-'", "'='", "'>'", "'<'", "'{'", "'}'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, "PROG_NAME", "VAR_TYPE", 
			"NUMBER", "ID", "STR", "SEMI_COLON", "COMA", "UNDERSCORE", "L_PAREN", 
			"R_PAREN", "TIMES", "DIV", "PLUS", "MINUS", "EQ", "GT", "LT", "L_BR", 
			"R_BR", "COMMENT", "WHITESPACE"
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


	public gLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "g.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\37\u0117\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\6\3\6\3\6"+
		"\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\13\3\13\3"+
		"\f\3\f\3\r\3\r\5\r\u008d\n\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3"+
		"\20\3\20\3\20\3\20\3\20\7\20\u00aa\n\20\f\20\16\20\u00ad\13\20\3\21\3"+
		"\21\3\21\3\21\3\21\7\21\u00b4\n\21\f\21\16\21\u00b7\13\21\3\21\3\21\3"+
		"\21\3\22\3\22\3\22\3\22\7\22\u00c0\n\22\f\22\16\22\u00c3\13\22\3\23\3"+
		"\23\5\23\u00c7\n\23\3\24\6\24\u00ca\n\24\r\24\16\24\u00cb\3\24\7\24\u00cf"+
		"\n\24\f\24\16\24\u00d2\13\24\3\24\3\24\6\24\u00d6\n\24\r\24\16\24\u00d7"+
		"\5\24\u00da\n\24\3\25\3\25\3\25\7\25\u00df\n\25\f\25\16\25\u00e2\13\25"+
		"\3\26\3\26\3\26\3\26\7\26\u00e8\n\26\f\26\16\26\u00eb\13\26\3\26\3\26"+
		"\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35"+
		"\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3$\3$\3%\3%\5%\u010d\n"+
		"%\3%\3%\3&\6&\u0112\n&\r&\16&\u0113\3&\3&\3\u00b5\2\'\3\3\5\4\7\5\t\6"+
		"\13\7\r\b\17\t\21\n\23\2\25\2\27\2\31\2\33\2\35\2\37\2!\2#\13%\f\'\r)"+
		"\16+\17-\20/\21\61\22\63\23\65\24\67\259\26;\27=\30?\31A\32C\33E\34G\35"+
		"I\36K\37\3\2\t\3\2\62;\3\2c|\3\2C\\\4\2\f\f\17\17\4\2..\60\60\5\2\f\f"+
		"\17\17$$\5\2\13\f\17\17\"\"\2\u0121\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2"+
		"\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2#\3"+
		"\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2"+
		"\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2"+
		";\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3"+
		"\2\2\2\2I\3\2\2\2\2K\3\2\2\2\3M\3\2\2\2\5T\3\2\2\2\7Z\3\2\2\2\t`\3\2\2"+
		"\2\13c\3\2\2\2\rh\3\2\2\2\17m\3\2\2\2\21x\3\2\2\2\23\u0084\3\2\2\2\25"+
		"\u0086\3\2\2\2\27\u0088\3\2\2\2\31\u008c\3\2\2\2\33\u008e\3\2\2\2\35\u0098"+
		"\3\2\2\2\37\u00a4\3\2\2\2!\u00ae\3\2\2\2#\u00bb\3\2\2\2%\u00c6\3\2\2\2"+
		"\'\u00d9\3\2\2\2)\u00db\3\2\2\2+\u00e3\3\2\2\2-\u00ee\3\2\2\2/\u00f0\3"+
		"\2\2\2\61\u00f2\3\2\2\2\63\u00f4\3\2\2\2\65\u00f6\3\2\2\2\67\u00f8\3\2"+
		"\2\29\u00fa\3\2\2\2;\u00fc\3\2\2\2=\u00fe\3\2\2\2?\u0100\3\2\2\2A\u0102"+
		"\3\2\2\2C\u0104\3\2\2\2E\u0106\3\2\2\2G\u0108\3\2\2\2I\u010c\3\2\2\2K"+
		"\u0111\3\2\2\2MN\7e\2\2NO\7q\2\2OP\7o\2\2PQ\7r\2\2QR\7k\2\2RS\7n\2\2S"+
		"\4\3\2\2\2TU\7u\2\2UV\7v\2\2VW\7c\2\2WX\7t\2\2XY\7v\2\2Y\6\3\2\2\2Z[\7"+
		"g\2\2[\\\7p\2\2\\]\7f\2\2]^\7k\2\2^_\7h\2\2_\b\3\2\2\2`a\7k\2\2ab\7h\2"+
		"\2b\n\3\2\2\2cd\7v\2\2de\7j\2\2ef\7g\2\2fg\7p\2\2g\f\3\2\2\2hi\7g\2\2"+
		"ij\7n\2\2jk\7u\2\2kl\7g\2\2l\16\3\2\2\2mn\7u\2\2no\7e\2\2op\7c\2\2pq\7"+
		"p\2\2qr\7e\2\2rs\7q\2\2st\7o\2\2tu\7r\2\2uv\7k\2\2vw\7n\2\2w\20\3\2\2"+
		"\2xy\7r\2\2yz\7t\2\2z{\7k\2\2{|\7p\2\2|}\7v\2\2}~\7e\2\2~\177\7q\2\2\177"+
		"\u0080\7o\2\2\u0080\u0081\7r\2\2\u0081\u0082\7k\2\2\u0082\u0083\7n\2\2"+
		"\u0083\22\3\2\2\2\u0084\u0085\t\2\2\2\u0085\24\3\2\2\2\u0086\u0087\t\3"+
		"\2\2\u0087\26\3\2\2\2\u0088\u0089\t\4\2\2\u0089\30\3\2\2\2\u008a\u008d"+
		"\5\25\13\2\u008b\u008d\5\27\f\2\u008c\u008a\3\2\2\2\u008c\u008b\3\2\2"+
		"\2\u008d\32\3\2\2\2\u008e\u008f\7k\2\2\u008f\u0090\7p\2\2\u0090\u0091"+
		"\7v\2\2\u0091\u0092\7e\2\2\u0092\u0093\7q\2\2\u0093\u0094\7o\2\2\u0094"+
		"\u0095\7r\2\2\u0095\u0096\7k\2\2\u0096\u0097\7n\2\2\u0097\34\3\2\2\2\u0098"+
		"\u0099\7h\2\2\u0099\u009a\7n\2\2\u009a\u009b\7q\2\2\u009b\u009c\7c\2\2"+
		"\u009c\u009d\7v\2\2\u009d\u009e\7e\2\2\u009e\u009f\7q\2\2\u009f\u00a0"+
		"\7o\2\2\u00a0\u00a1\7r\2\2\u00a1\u00a2\7k\2\2\u00a2\u00a3\7n\2\2\u00a3"+
		"\36\3\2\2\2\u00a4\u00a5\7\61\2\2\u00a5\u00a6\7\61\2\2\u00a6\u00ab\3\2"+
		"\2\2\u00a7\u00aa\5\37\20\2\u00a8\u00aa\n\5\2\2\u00a9\u00a7\3\2\2\2\u00a9"+
		"\u00a8\3\2\2\2\u00aa\u00ad\3\2\2\2\u00ab\u00a9\3\2\2\2\u00ab\u00ac\3\2"+
		"\2\2\u00ac \3\2\2\2\u00ad\u00ab\3\2\2\2\u00ae\u00af\7\61\2\2\u00af\u00b0"+
		"\7,\2\2\u00b0\u00b5\3\2\2\2\u00b1\u00b4\5\37\20\2\u00b2\u00b4\13\2\2\2"+
		"\u00b3\u00b1\3\2\2\2\u00b3\u00b2\3\2\2\2\u00b4\u00b7\3\2\2\2\u00b5\u00b6"+
		"\3\2\2\2\u00b5\u00b3\3\2\2\2\u00b6\u00b8\3\2\2\2\u00b7\u00b5\3\2\2\2\u00b8"+
		"\u00b9\7,\2\2\u00b9\u00ba\7\61\2\2\u00ba\"\3\2\2\2\u00bb\u00c1\5\27\f"+
		"\2\u00bc\u00c0\5\31\r\2\u00bd\u00c0\5\23\n\2\u00be\u00c0\5\61\31\2\u00bf"+
		"\u00bc\3\2\2\2\u00bf\u00bd\3\2\2\2\u00bf\u00be\3\2\2\2\u00c0\u00c3\3\2"+
		"\2\2\u00c1\u00bf\3\2\2\2\u00c1\u00c2\3\2\2\2\u00c2$\3\2\2\2\u00c3\u00c1"+
		"\3\2\2\2\u00c4\u00c7\5\33\16\2\u00c5\u00c7\5\35\17\2\u00c6\u00c4\3\2\2"+
		"\2\u00c6\u00c5\3\2\2\2\u00c7&\3\2\2\2\u00c8\u00ca\5\23\n\2\u00c9\u00c8"+
		"\3\2\2\2\u00ca\u00cb\3\2\2\2\u00cb\u00c9\3\2\2\2\u00cb\u00cc\3\2\2\2\u00cc"+
		"\u00da\3\2\2\2\u00cd\u00cf\5\23\n\2\u00ce\u00cd\3\2\2\2\u00cf\u00d2\3"+
		"\2\2\2\u00d0\u00ce\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d1\u00d3\3\2\2\2\u00d2"+
		"\u00d0\3\2\2\2\u00d3\u00d5\t\6\2\2\u00d4\u00d6\5\23\n\2\u00d5\u00d4\3"+
		"\2\2\2\u00d6\u00d7\3\2\2\2\u00d7\u00d5\3\2\2\2\u00d7\u00d8\3\2\2\2\u00d8"+
		"\u00da\3\2\2\2\u00d9\u00c9\3\2\2\2\u00d9\u00d0\3\2\2\2\u00da(\3\2\2\2"+
		"\u00db\u00e0\5\31\r\2\u00dc\u00df\5\23\n\2\u00dd\u00df\5\31\r\2\u00de"+
		"\u00dc\3\2\2\2\u00de\u00dd\3\2\2\2\u00df\u00e2\3\2\2\2\u00e0\u00de\3\2"+
		"\2\2\u00e0\u00e1\3\2\2\2\u00e1*\3\2\2\2\u00e2\u00e0\3\2\2\2\u00e3\u00e9"+
		"\7$\2\2\u00e4\u00e8\n\7\2\2\u00e5\u00e6\7^\2\2\u00e6\u00e8\7$\2\2\u00e7"+
		"\u00e4\3\2\2\2\u00e7\u00e5\3\2\2\2\u00e8\u00eb\3\2\2\2\u00e9\u00e7\3\2"+
		"\2\2\u00e9\u00ea\3\2\2\2\u00ea\u00ec\3\2\2\2\u00eb\u00e9\3\2\2\2\u00ec"+
		"\u00ed\7$\2\2\u00ed,\3\2\2\2\u00ee\u00ef\7=\2\2\u00ef.\3\2\2\2\u00f0\u00f1"+
		"\7.\2\2\u00f1\60\3\2\2\2\u00f2\u00f3\7a\2\2\u00f3\62\3\2\2\2\u00f4\u00f5"+
		"\7*\2\2\u00f5\64\3\2\2\2\u00f6\u00f7\7+\2\2\u00f7\66\3\2\2\2\u00f8\u00f9"+
		"\7,\2\2\u00f98\3\2\2\2\u00fa\u00fb\7\61\2\2\u00fb:\3\2\2\2\u00fc\u00fd"+
		"\7-\2\2\u00fd<\3\2\2\2\u00fe\u00ff\7/\2\2\u00ff>\3\2\2\2\u0100\u0101\7"+
		"?\2\2\u0101@\3\2\2\2\u0102\u0103\7@\2\2\u0103B\3\2\2\2\u0104\u0105\7>"+
		"\2\2\u0105D\3\2\2\2\u0106\u0107\7}\2\2\u0107F\3\2\2\2\u0108\u0109\7\177"+
		"\2\2\u0109H\3\2\2\2\u010a\u010d\5\37\20\2\u010b\u010d\5!\21\2\u010c\u010a"+
		"\3\2\2\2\u010c\u010b\3\2\2\2\u010d\u010e\3\2\2\2\u010e\u010f\b%\2\2\u010f"+
		"J\3\2\2\2\u0110\u0112\t\b\2\2\u0111\u0110\3\2\2\2\u0112\u0113\3\2\2\2"+
		"\u0113\u0111\3\2\2\2\u0113\u0114\3\2\2\2\u0114\u0115\3\2\2\2\u0115\u0116"+
		"\b&\2\2\u0116L\3\2\2\2\25\2\u008c\u00a9\u00ab\u00b3\u00b5\u00bf\u00c1"+
		"\u00c6\u00cb\u00d0\u00d7\u00d9\u00de\u00e0\u00e7\u00e9\u010c\u0113\3\b"+
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