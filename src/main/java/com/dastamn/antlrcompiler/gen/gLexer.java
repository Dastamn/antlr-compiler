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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, CLASS_NAME=9, 
		MODIFIER=10, VAR_TYPE=11, ID=12, LIBRARY=13, NUMBER=14, FORMAT=15, STR=16, 
		QUOT=17, POINT=18, SEMI_COLON=19, COMA=20, UNDERSCORE=21, L_PAREN=22, 
		R_PAREN=23, TIMES=24, DIV=25, PLUS=26, MINUS=27, ASSIGN=28, GT=29, GTE=30, 
		LT=31, LTE=32, EQ=33, NOT_EQ=34, AND=35, OR=36, NOT=37, L_BR=38, R_BR=39, 
		COMMENT=40, WHITESPACE=41;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "DIGIT", 
			"LOWERCASE", "UPPERCASE", "ANYCASE", "INT", "FLOAT", "STRING", "INT_FORMAT", 
			"FLOAT_FORMAT", "STRING_FORMAT", "LINE_COMMENT", "MULTI_LINE_COMMENT", 
			"CLASS_NAME", "MODIFIER", "VAR_TYPE", "ID", "LIBRARY", "NUMBER", "FORMAT", 
			"STR", "QUOT", "POINT", "SEMI_COLON", "COMA", "UNDERSCORE", "L_PAREN", 
			"R_PAREN", "TIMES", "DIV", "PLUS", "MINUS", "ASSIGN", "GT", "GTE", "LT", 
			"LTE", "EQ", "NOT_EQ", "AND", "OR", "NOT", "L_BR", "R_BR", "COMMENT", 
			"WHITESPACE"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'class_SJ'", "'import'", "'main_SJ'", "'Si'", "'Alors'", "'Sinon'", 
			"'In_SJ'", "'Out_SJ'", null, null, null, null, null, null, null, null, 
			"'\"'", "'.'", "';'", "','", "'_'", "'('", "')'", "'*'", "'/'", "'+'", 
			"'-'", "':='", "'>'", "'>='", "'<'", "'<='", "'='", "'!='", "'&'", "'|'", 
			"'!'", "'{'", "'}'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, "CLASS_NAME", "MODIFIER", 
			"VAR_TYPE", "ID", "LIBRARY", "NUMBER", "FORMAT", "STR", "QUOT", "POINT", 
			"SEMI_COLON", "COMA", "UNDERSCORE", "L_PAREN", "R_PAREN", "TIMES", "DIV", 
			"PLUS", "MINUS", "ASSIGN", "GT", "GTE", "LT", "LTE", "EQ", "NOT_EQ", 
			"AND", "OR", "NOT", "L_BR", "R_BR", "COMMENT", "WHITESPACE"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2+\u017d\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\5\r\u00aa\n\r"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21"+
		"\3\21\3\22\3\22\3\22\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\7\24\u00d4"+
		"\n\24\f\24\16\24\u00d7\13\24\3\25\3\25\3\25\3\25\3\25\7\25\u00de\n\25"+
		"\f\25\16\25\u00e1\13\25\3\25\3\25\3\25\3\26\3\26\3\26\7\26\u00e9\n\26"+
		"\f\26\16\26\u00ec\13\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3"+
		"\27\3\27\3\27\3\27\3\27\3\27\5\27\u00fd\n\27\3\30\3\30\3\30\5\30\u0102"+
		"\n\30\3\31\3\31\3\31\7\31\u0107\n\31\f\31\16\31\u010a\13\31\3\32\3\32"+
		"\3\32\3\32\3\32\7\32\u0111\n\32\f\32\16\32\u0114\13\32\3\33\6\33\u0117"+
		"\n\33\r\33\16\33\u0118\3\33\7\33\u011c\n\33\f\33\16\33\u011f\13\33\3\33"+
		"\3\33\6\33\u0123\n\33\r\33\16\33\u0124\5\33\u0127\n\33\3\34\3\34\3\34"+
		"\3\34\3\34\6\34\u012e\n\34\r\34\16\34\u012f\3\34\3\34\3\35\3\35\3\35\3"+
		"\35\7\35\u0138\n\35\f\35\16\35\u013b\13\35\3\35\3\35\3\36\3\36\3\37\3"+
		"\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3$\3$\3%\3%\3&\3&\3\'\3\'\3(\3(\3)\3)\3"+
		")\3*\3*\3+\3+\3+\3,\3,\3-\3-\3-\3.\3.\3/\3/\3/\3\60\3\60\3\61\3\61\3\62"+
		"\3\62\3\63\3\63\3\64\3\64\3\65\3\65\5\65\u0173\n\65\3\65\3\65\3\66\6\66"+
		"\u0178\n\66\r\66\16\66\u0179\3\66\3\66\3\u00df\2\67\3\3\5\4\7\5\t\6\13"+
		"\7\r\b\17\t\21\n\23\2\25\2\27\2\31\2\33\2\35\2\37\2!\2#\2%\2\'\2)\2+\13"+
		"-\f/\r\61\16\63\17\65\20\67\219\22;\23=\24?\25A\26C\27E\30G\31I\32K\33"+
		"M\34O\35Q\36S\37U W!Y\"[#]$_%a&c\'e(g)i*k+\3\2\t\3\2\62;\3\2c|\3\2C\\"+
		"\4\2\f\f\17\17\4\2..\60\60\5\2\f\f\17\17$$\5\2\13\f\17\17\"\"\2\u018c"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3"+
		"\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2"+
		"=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3"+
		"\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2"+
		"\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2"+
		"c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\3m\3\2\2\2\5v\3"+
		"\2\2\2\7}\3\2\2\2\t\u0085\3\2\2\2\13\u0088\3\2\2\2\r\u008e\3\2\2\2\17"+
		"\u0094\3\2\2\2\21\u009a\3\2\2\2\23\u00a1\3\2\2\2\25\u00a3\3\2\2\2\27\u00a5"+
		"\3\2\2\2\31\u00a9\3\2\2\2\33\u00ab\3\2\2\2\35\u00b2\3\2\2\2\37\u00bb\3"+
		"\2\2\2!\u00c5\3\2\2\2#\u00c8\3\2\2\2%\u00cb\3\2\2\2\'\u00ce\3\2\2\2)\u00d8"+
		"\3\2\2\2+\u00e5\3\2\2\2-\u00fc\3\2\2\2/\u0101\3\2\2\2\61\u0103\3\2\2\2"+
		"\63\u010b\3\2\2\2\65\u0126\3\2\2\2\67\u0128\3\2\2\29\u0133\3\2\2\2;\u013e"+
		"\3\2\2\2=\u0140\3\2\2\2?\u0142\3\2\2\2A\u0144\3\2\2\2C\u0146\3\2\2\2E"+
		"\u0148\3\2\2\2G\u014a\3\2\2\2I\u014c\3\2\2\2K\u014e\3\2\2\2M\u0150\3\2"+
		"\2\2O\u0152\3\2\2\2Q\u0154\3\2\2\2S\u0157\3\2\2\2U\u0159\3\2\2\2W\u015c"+
		"\3\2\2\2Y\u015e\3\2\2\2[\u0161\3\2\2\2]\u0163\3\2\2\2_\u0166\3\2\2\2a"+
		"\u0168\3\2\2\2c\u016a\3\2\2\2e\u016c\3\2\2\2g\u016e\3\2\2\2i\u0172\3\2"+
		"\2\2k\u0177\3\2\2\2mn\7e\2\2no\7n\2\2op\7c\2\2pq\7u\2\2qr\7u\2\2rs\7a"+
		"\2\2st\7U\2\2tu\7L\2\2u\4\3\2\2\2vw\7k\2\2wx\7o\2\2xy\7r\2\2yz\7q\2\2"+
		"z{\7t\2\2{|\7v\2\2|\6\3\2\2\2}~\7o\2\2~\177\7c\2\2\177\u0080\7k\2\2\u0080"+
		"\u0081\7p\2\2\u0081\u0082\7a\2\2\u0082\u0083\7U\2\2\u0083\u0084\7L\2\2"+
		"\u0084\b\3\2\2\2\u0085\u0086\7U\2\2\u0086\u0087\7k\2\2\u0087\n\3\2\2\2"+
		"\u0088\u0089\7C\2\2\u0089\u008a\7n\2\2\u008a\u008b\7q\2\2\u008b\u008c"+
		"\7t\2\2\u008c\u008d\7u\2\2\u008d\f\3\2\2\2\u008e\u008f\7U\2\2\u008f\u0090"+
		"\7k\2\2\u0090\u0091\7p\2\2\u0091\u0092\7q\2\2\u0092\u0093\7p\2\2\u0093"+
		"\16\3\2\2\2\u0094\u0095\7K\2\2\u0095\u0096\7p\2\2\u0096\u0097\7a\2\2\u0097"+
		"\u0098\7U\2\2\u0098\u0099\7L\2\2\u0099\20\3\2\2\2\u009a\u009b\7Q\2\2\u009b"+
		"\u009c\7w\2\2\u009c\u009d\7v\2\2\u009d\u009e\7a\2\2\u009e\u009f\7U\2\2"+
		"\u009f\u00a0\7L\2\2\u00a0\22\3\2\2\2\u00a1\u00a2\t\2\2\2\u00a2\24\3\2"+
		"\2\2\u00a3\u00a4\t\3\2\2\u00a4\26\3\2\2\2\u00a5\u00a6\t\4\2\2\u00a6\30"+
		"\3\2\2\2\u00a7\u00aa\5\25\13\2\u00a8\u00aa\5\27\f\2\u00a9\u00a7\3\2\2"+
		"\2\u00a9\u00a8\3\2\2\2\u00aa\32\3\2\2\2\u00ab\u00ac\7k\2\2\u00ac\u00ad"+
		"\7p\2\2\u00ad\u00ae\7v\2\2\u00ae\u00af\7a\2\2\u00af\u00b0\7U\2\2\u00b0"+
		"\u00b1\7L\2\2\u00b1\34\3\2\2\2\u00b2\u00b3\7h\2\2\u00b3\u00b4\7n\2\2\u00b4"+
		"\u00b5\7q\2\2\u00b5\u00b6\7c\2\2\u00b6\u00b7\7v\2\2\u00b7\u00b8\7a\2\2"+
		"\u00b8\u00b9\7U\2\2\u00b9\u00ba\7L\2\2\u00ba\36\3\2\2\2\u00bb\u00bc\7"+
		"u\2\2\u00bc\u00bd\7v\2\2\u00bd\u00be\7t\2\2\u00be\u00bf\7k\2\2\u00bf\u00c0"+
		"\7p\2\2\u00c0\u00c1\7i\2\2\u00c1\u00c2\7a\2\2\u00c2\u00c3\7U\2\2\u00c3"+
		"\u00c4\7L\2\2\u00c4 \3\2\2\2\u00c5\u00c6\7\'\2\2\u00c6\u00c7\7f\2\2\u00c7"+
		"\"\3\2\2\2\u00c8\u00c9\7\'\2\2\u00c9\u00ca\7h\2\2\u00ca$\3\2\2\2\u00cb"+
		"\u00cc\7\'\2\2\u00cc\u00cd\7u\2\2\u00cd&\3\2\2\2\u00ce\u00cf\7\61\2\2"+
		"\u00cf\u00d0\7\61\2\2\u00d0\u00d5\3\2\2\2\u00d1\u00d4\5\'\24\2\u00d2\u00d4"+
		"\n\5\2\2\u00d3\u00d1\3\2\2\2\u00d3\u00d2\3\2\2\2\u00d4\u00d7\3\2\2\2\u00d5"+
		"\u00d3\3\2\2\2\u00d5\u00d6\3\2\2\2\u00d6(\3\2\2\2\u00d7\u00d5\3\2\2\2"+
		"\u00d8\u00d9\7\61\2\2\u00d9\u00da\7,\2\2\u00da\u00df\3\2\2\2\u00db\u00de"+
		"\5\'\24\2\u00dc\u00de\13\2\2\2\u00dd\u00db\3\2\2\2\u00dd\u00dc\3\2\2\2"+
		"\u00de\u00e1\3\2\2\2\u00df\u00e0\3\2\2\2\u00df\u00dd\3\2\2\2\u00e0\u00e2"+
		"\3\2\2\2\u00e1\u00df\3\2\2\2\u00e2\u00e3\7,\2\2\u00e3\u00e4\7\61\2\2\u00e4"+
		"*\3\2\2\2\u00e5\u00ea\5\27\f\2\u00e6\u00e9\5\23\n\2\u00e7\u00e9\5\31\r"+
		"\2\u00e8\u00e6\3\2\2\2\u00e8\u00e7\3\2\2\2\u00e9\u00ec\3\2\2\2\u00ea\u00e8"+
		"\3\2\2\2\u00ea\u00eb\3\2\2\2\u00eb,\3\2\2\2\u00ec\u00ea\3\2\2\2\u00ed"+
		"\u00ee\7r\2\2\u00ee\u00ef\7w\2\2\u00ef\u00f0\7d\2\2\u00f0\u00f1\7n\2\2"+
		"\u00f1\u00f2\7k\2\2\u00f2\u00fd\7e\2\2\u00f3\u00f4\7r\2\2\u00f4\u00f5"+
		"\7t\2\2\u00f5\u00f6\7q\2\2\u00f6\u00f7\7v\2\2\u00f7\u00f8\7g\2\2\u00f8"+
		"\u00f9\7e\2\2\u00f9\u00fa\7v\2\2\u00fa\u00fb\7g\2\2\u00fb\u00fd\7f\2\2"+
		"\u00fc\u00ed\3\2\2\2\u00fc\u00f3\3\2\2\2\u00fd.\3\2\2\2\u00fe\u0102\5"+
		"\33\16\2\u00ff\u0102\5\35\17\2\u0100\u0102\5\37\20\2\u0101\u00fe\3\2\2"+
		"\2\u0101\u00ff\3\2\2\2\u0101\u0100\3\2\2\2\u0102\60\3\2\2\2\u0103\u0108"+
		"\5\31\r\2\u0104\u0107\5\23\n\2\u0105\u0107\5\31\r\2\u0106\u0104\3\2\2"+
		"\2\u0106\u0105\3\2\2\2\u0107\u010a\3\2\2\2\u0108\u0106\3\2\2\2\u0108\u0109"+
		"\3\2\2\2\u0109\62\3\2\2\2\u010a\u0108\3\2\2\2\u010b\u0112\5\31\r\2\u010c"+
		"\u0111\5\31\r\2\u010d\u0111\5\23\n\2\u010e\u0111\5C\"\2\u010f\u0111\5"+
		"=\37\2\u0110\u010c\3\2\2\2\u0110\u010d\3\2\2\2\u0110\u010e\3\2\2\2\u0110"+
		"\u010f\3\2\2\2\u0111\u0114\3\2\2\2\u0112\u0110\3\2\2\2\u0112\u0113\3\2"+
		"\2\2\u0113\64\3\2\2\2\u0114\u0112\3\2\2\2\u0115\u0117\5\23\n\2\u0116\u0115"+
		"\3\2\2\2\u0117\u0118\3\2\2\2\u0118\u0116\3\2\2\2\u0118\u0119\3\2\2\2\u0119"+
		"\u0127\3\2\2\2\u011a\u011c\5\23\n\2\u011b\u011a\3\2\2\2\u011c\u011f\3"+
		"\2\2\2\u011d\u011b\3\2\2\2\u011d\u011e\3\2\2\2\u011e\u0120\3\2\2\2\u011f"+
		"\u011d\3\2\2\2\u0120\u0122\t\6\2\2\u0121\u0123\5\23\n\2\u0122\u0121\3"+
		"\2\2\2\u0123\u0124\3\2\2\2\u0124\u0122\3\2\2\2\u0124\u0125\3\2\2\2\u0125"+
		"\u0127\3\2\2\2\u0126\u0116\3\2\2\2\u0126\u011d\3\2\2\2\u0127\66\3\2\2"+
		"\2\u0128\u012d\5;\36\2\u0129\u012e\5!\21\2\u012a\u012e\5#\22\2\u012b\u012e"+
		"\5%\23\2\u012c\u012e\7\"\2\2\u012d\u0129\3\2\2\2\u012d\u012a\3\2\2\2\u012d"+
		"\u012b\3\2\2\2\u012d\u012c\3\2\2\2\u012e\u012f\3\2\2\2\u012f\u012d\3\2"+
		"\2\2\u012f\u0130\3\2\2\2\u0130\u0131\3\2\2\2\u0131\u0132\5;\36\2\u0132"+
		"8\3\2\2\2\u0133\u0139\5;\36\2\u0134\u0138\n\7\2\2\u0135\u0136\7^\2\2\u0136"+
		"\u0138\7$\2\2\u0137\u0134\3\2\2\2\u0137\u0135\3\2\2\2\u0138\u013b\3\2"+
		"\2\2\u0139\u0137\3\2\2\2\u0139\u013a\3\2\2\2\u013a\u013c\3\2\2\2\u013b"+
		"\u0139\3\2\2\2\u013c\u013d\5;\36\2\u013d:\3\2\2\2\u013e\u013f\7$\2\2\u013f"+
		"<\3\2\2\2\u0140\u0141\7\60\2\2\u0141>\3\2\2\2\u0142\u0143\7=\2\2\u0143"+
		"@\3\2\2\2\u0144\u0145\7.\2\2\u0145B\3\2\2\2\u0146\u0147\7a\2\2\u0147D"+
		"\3\2\2\2\u0148\u0149\7*\2\2\u0149F\3\2\2\2\u014a\u014b\7+\2\2\u014bH\3"+
		"\2\2\2\u014c\u014d\7,\2\2\u014dJ\3\2\2\2\u014e\u014f\7\61\2\2\u014fL\3"+
		"\2\2\2\u0150\u0151\7-\2\2\u0151N\3\2\2\2\u0152\u0153\7/\2\2\u0153P\3\2"+
		"\2\2\u0154\u0155\7<\2\2\u0155\u0156\7?\2\2\u0156R\3\2\2\2\u0157\u0158"+
		"\7@\2\2\u0158T\3\2\2\2\u0159\u015a\7@\2\2\u015a\u015b\7?\2\2\u015bV\3"+
		"\2\2\2\u015c\u015d\7>\2\2\u015dX\3\2\2\2\u015e\u015f\7>\2\2\u015f\u0160"+
		"\7?\2\2\u0160Z\3\2\2\2\u0161\u0162\7?\2\2\u0162\\\3\2\2\2\u0163\u0164"+
		"\7#\2\2\u0164\u0165\7?\2\2\u0165^\3\2\2\2\u0166\u0167\7(\2\2\u0167`\3"+
		"\2\2\2\u0168\u0169\7~\2\2\u0169b\3\2\2\2\u016a\u016b\7#\2\2\u016bd\3\2"+
		"\2\2\u016c\u016d\7}\2\2\u016df\3\2\2\2\u016e\u016f\7\177\2\2\u016fh\3"+
		"\2\2\2\u0170\u0173\5\'\24\2\u0171\u0173\5)\25\2\u0172\u0170\3\2\2\2\u0172"+
		"\u0171\3\2\2\2\u0173\u0174\3\2\2\2\u0174\u0175\b\65\2\2\u0175j\3\2\2\2"+
		"\u0176\u0178\t\b\2\2\u0177\u0176\3\2\2\2\u0178\u0179\3\2\2\2\u0179\u0177"+
		"\3\2\2\2\u0179\u017a\3\2\2\2\u017a\u017b\3\2\2\2\u017b\u017c\b\66\2\2"+
		"\u017cl\3\2\2\2\32\2\u00a9\u00d3\u00d5\u00dd\u00df\u00e8\u00ea\u00fc\u0101"+
		"\u0106\u0108\u0110\u0112\u0118\u011d\u0124\u0126\u012d\u012f\u0137\u0139"+
		"\u0172\u0179\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}