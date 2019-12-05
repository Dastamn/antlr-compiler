// Generated from D:/IdeaProjects/antlrcompiler/src/main/resources\g.g4 by ANTLR 4.7.2
package com.dastamn.antlrcompiler.gen;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class gParser extends Parser {
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
	public static final int
		RULE_axiom = 0, RULE_importLib = 1, RULE_declaration = 2, RULE_idList = 3, 
		RULE_mainBlock = 4, RULE_instBlock = 5, RULE_instruction = 6, RULE_affectation = 7, 
		RULE_expression = 8, RULE_condition = 9, RULE_thenBlock = 10, RULE_ifStatement = 11, 
		RULE_evaluation = 12, RULE_elseBlock = 13, RULE_input = 14, RULE_output = 15;
	private static String[] makeRuleNames() {
		return new String[] {
			"axiom", "importLib", "declaration", "idList", "mainBlock", "instBlock", 
			"instruction", "affectation", "expression", "condition", "thenBlock", 
			"ifStatement", "evaluation", "elseBlock", "input", "output"
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

	@Override
	public String getGrammarFileName() { return "g.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public gParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class AxiomContext extends ParserRuleContext {
		public TerminalNode CLASS_NAME() { return getToken(gParser.CLASS_NAME, 0); }
		public TerminalNode L_BR() { return getToken(gParser.L_BR, 0); }
		public TerminalNode R_BR() { return getToken(gParser.R_BR, 0); }
		public TerminalNode EOF() { return getToken(gParser.EOF, 0); }
		public List<ImportLibContext> importLib() {
			return getRuleContexts(ImportLibContext.class);
		}
		public ImportLibContext importLib(int i) {
			return getRuleContext(ImportLibContext.class,i);
		}
		public TerminalNode MODIFIER() { return getToken(gParser.MODIFIER, 0); }
		public List<DeclarationContext> declaration() {
			return getRuleContexts(DeclarationContext.class);
		}
		public DeclarationContext declaration(int i) {
			return getRuleContext(DeclarationContext.class,i);
		}
		public MainBlockContext mainBlock() {
			return getRuleContext(MainBlockContext.class,0);
		}
		public AxiomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_axiom; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gListener ) ((gListener)listener).enterAxiom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gListener ) ((gListener)listener).exitAxiom(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gVisitor ) return ((gVisitor<? extends T>)visitor).visitAxiom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AxiomContext axiom() throws RecognitionException {
		AxiomContext _localctx = new AxiomContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_axiom);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(33); 
			_errHandler.sync(this);
			_alt = 1+1;
			do {
				switch (_alt) {
				case 1+1:
					{
					{
					setState(32);
					importLib();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(35); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			} while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(38);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==MODIFIER) {
				{
				setState(37);
				match(MODIFIER);
				}
			}

			setState(40);
			match(T__0);
			setState(41);
			match(CLASS_NAME);
			setState(42);
			match(L_BR);
			setState(46);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VAR_TYPE) {
				{
				{
				setState(43);
				declaration();
				}
				}
				setState(48);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(50);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__2) {
				{
				setState(49);
				mainBlock();
				}
			}

			setState(52);
			match(R_BR);
			setState(53);
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

	public static class ImportLibContext extends ParserRuleContext {
		public TerminalNode LIBRARY() { return getToken(gParser.LIBRARY, 0); }
		public TerminalNode ID() { return getToken(gParser.ID, 0); }
		public List<TerminalNode> SEMI_COLON() { return getTokens(gParser.SEMI_COLON); }
		public TerminalNode SEMI_COLON(int i) {
			return getToken(gParser.SEMI_COLON, i);
		}
		public ImportLibContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_importLib; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gListener ) ((gListener)listener).enterImportLib(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gListener ) ((gListener)listener).exitImportLib(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gVisitor ) return ((gVisitor<? extends T>)visitor).visitImportLib(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ImportLibContext importLib() throws RecognitionException {
		ImportLibContext _localctx = new ImportLibContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_importLib);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(55);
			match(T__1);
			setState(56);
			_la = _input.LA(1);
			if ( !(_la==ID || _la==LIBRARY) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(58); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(57);
				match(SEMI_COLON);
				}
				}
				setState(60); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==SEMI_COLON );
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

	public static class DeclarationContext extends ParserRuleContext {
		public TerminalNode VAR_TYPE() { return getToken(gParser.VAR_TYPE, 0); }
		public IdListContext idList() {
			return getRuleContext(IdListContext.class,0);
		}
		public List<TerminalNode> SEMI_COLON() { return getTokens(gParser.SEMI_COLON); }
		public TerminalNode SEMI_COLON(int i) {
			return getToken(gParser.SEMI_COLON, i);
		}
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gListener ) ((gListener)listener).enterDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gListener ) ((gListener)listener).exitDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gVisitor ) return ((gVisitor<? extends T>)visitor).visitDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_declaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62);
			match(VAR_TYPE);
			setState(63);
			idList();
			setState(65); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(64);
				match(SEMI_COLON);
				}
				}
				setState(67); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==SEMI_COLON );
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

	public static class IdListContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(gParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(gParser.ID, i);
		}
		public List<TerminalNode> COMA() { return getTokens(gParser.COMA); }
		public TerminalNode COMA(int i) {
			return getToken(gParser.COMA, i);
		}
		public IdListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_idList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gListener ) ((gListener)listener).enterIdList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gListener ) ((gListener)listener).exitIdList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gVisitor ) return ((gVisitor<? extends T>)visitor).visitIdList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdListContext idList() throws RecognitionException {
		IdListContext _localctx = new IdListContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_idList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(69);
			match(ID);
			setState(74);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMA) {
				{
				{
				setState(70);
				match(COMA);
				setState(71);
				match(ID);
				}
				}
				setState(76);
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

	public static class MainBlockContext extends ParserRuleContext {
		public InstBlockContext instBlock() {
			return getRuleContext(InstBlockContext.class,0);
		}
		public MainBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mainBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gListener ) ((gListener)listener).enterMainBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gListener ) ((gListener)listener).exitMainBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gVisitor ) return ((gVisitor<? extends T>)visitor).visitMainBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MainBlockContext mainBlock() throws RecognitionException {
		MainBlockContext _localctx = new MainBlockContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_mainBlock);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(77);
			match(T__2);
			setState(78);
			instBlock();
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

	public static class InstBlockContext extends ParserRuleContext {
		public TerminalNode L_BR() { return getToken(gParser.L_BR, 0); }
		public TerminalNode R_BR() { return getToken(gParser.R_BR, 0); }
		public List<InstructionContext> instruction() {
			return getRuleContexts(InstructionContext.class);
		}
		public InstructionContext instruction(int i) {
			return getRuleContext(InstructionContext.class,i);
		}
		public InstBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gListener ) ((gListener)listener).enterInstBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gListener ) ((gListener)listener).exitInstBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gVisitor ) return ((gVisitor<? extends T>)visitor).visitInstBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InstBlockContext instBlock() throws RecognitionException {
		InstBlockContext _localctx = new InstBlockContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_instBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(80);
			match(L_BR);
			setState(84);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__6) | (1L << T__7) | (1L << ID) | (1L << NUMBER) | (1L << STR) | (1L << L_PAREN) | (1L << MINUS))) != 0)) {
				{
				{
				setState(81);
				instruction();
				}
				}
				setState(86);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(87);
			match(R_BR);
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

	public static class InstructionContext extends ParserRuleContext {
		public AffectationContext affectation() {
			return getRuleContext(AffectationContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public InputContext input() {
			return getRuleContext(InputContext.class,0);
		}
		public OutputContext output() {
			return getRuleContext(OutputContext.class,0);
		}
		public List<TerminalNode> SEMI_COLON() { return getTokens(gParser.SEMI_COLON); }
		public TerminalNode SEMI_COLON(int i) {
			return getToken(gParser.SEMI_COLON, i);
		}
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public InstructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instruction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gListener ) ((gListener)listener).enterInstruction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gListener ) ((gListener)listener).exitInstruction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gVisitor ) return ((gVisitor<? extends T>)visitor).visitInstruction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InstructionContext instruction() throws RecognitionException {
		InstructionContext _localctx = new InstructionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_instruction);
		int _la;
		try {
			setState(101);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__6:
			case T__7:
			case ID:
			case NUMBER:
			case STR:
			case L_PAREN:
			case MINUS:
				enterOuterAlt(_localctx, 1);
				{
				setState(93);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
				case 1:
					{
					setState(89);
					affectation();
					}
					break;
				case 2:
					{
					setState(90);
					expression(0);
					}
					break;
				case 3:
					{
					setState(91);
					input();
					}
					break;
				case 4:
					{
					setState(92);
					output();
					}
					break;
				}
				setState(96); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(95);
					match(SEMI_COLON);
					}
					}
					setState(98); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==SEMI_COLON );
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 2);
				{
				setState(100);
				condition();
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

	public static class AffectationContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(gParser.ID, 0); }
		public TerminalNode ASSIGN() { return getToken(gParser.ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AffectationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_affectation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gListener ) ((gListener)listener).enterAffectation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gListener ) ((gListener)listener).exitAffectation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gVisitor ) return ((gVisitor<? extends T>)visitor).visitAffectation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AffectationContext affectation() throws RecognitionException {
		AffectationContext _localctx = new AffectationContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_affectation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(103);
			match(ID);
			setState(104);
			match(ASSIGN);
			setState(105);
			expression(0);
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

	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class StrContext extends ExpressionContext {
		public TerminalNode STR() { return getToken(gParser.STR, 0); }
		public StrContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gListener ) ((gListener)listener).enterStr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gListener ) ((gListener)listener).exitStr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gVisitor ) return ((gVisitor<? extends T>)visitor).visitStr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DivContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode DIV() { return getToken(gParser.DIV, 0); }
		public DivContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gListener ) ((gListener)listener).enterDiv(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gListener ) ((gListener)listener).exitDiv(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gVisitor ) return ((gVisitor<? extends T>)visitor).visitDiv(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NumberContext extends ExpressionContext {
		public TerminalNode NUMBER() { return getToken(gParser.NUMBER, 0); }
		public NumberContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gListener ) ((gListener)listener).enterNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gListener ) ((gListener)listener).exitNumber(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gVisitor ) return ((gVisitor<? extends T>)visitor).visitNumber(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TimesContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode TIMES() { return getToken(gParser.TIMES, 0); }
		public TimesContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gListener ) ((gListener)listener).enterTimes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gListener ) ((gListener)listener).exitTimes(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gVisitor ) return ((gVisitor<? extends T>)visitor).visitTimes(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class UnaryMinusContext extends ExpressionContext {
		public TerminalNode MINUS() { return getToken(gParser.MINUS, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public UnaryMinusContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gListener ) ((gListener)listener).enterUnaryMinus(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gListener ) ((gListener)listener).exitUnaryMinus(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gVisitor ) return ((gVisitor<? extends T>)visitor).visitUnaryMinus(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IdContext extends ExpressionContext {
		public TerminalNode ID() { return getToken(gParser.ID, 0); }
		public IdContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gListener ) ((gListener)listener).enterId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gListener ) ((gListener)listener).exitId(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gVisitor ) return ((gVisitor<? extends T>)visitor).visitId(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PlusContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode PLUS() { return getToken(gParser.PLUS, 0); }
		public PlusContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gListener ) ((gListener)listener).enterPlus(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gListener ) ((gListener)listener).exitPlus(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gVisitor ) return ((gVisitor<? extends T>)visitor).visitPlus(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpParenContext extends ExpressionContext {
		public TerminalNode L_PAREN() { return getToken(gParser.L_PAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode R_PAREN() { return getToken(gParser.R_PAREN, 0); }
		public ExpParenContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gListener ) ((gListener)listener).enterExpParen(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gListener ) ((gListener)listener).exitExpParen(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gVisitor ) return ((gVisitor<? extends T>)visitor).visitExpParen(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MinusContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode MINUS() { return getToken(gParser.MINUS, 0); }
		public MinusContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gListener ) ((gListener)listener).enterMinus(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gListener ) ((gListener)listener).exitMinus(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gVisitor ) return ((gVisitor<? extends T>)visitor).visitMinus(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 16;
		enterRecursionRule(_localctx, 16, RULE_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(117);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case L_PAREN:
				{
				_localctx = new ExpParenContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(108);
				match(L_PAREN);
				setState(109);
				expression(0);
				setState(110);
				match(R_PAREN);
				}
				break;
			case MINUS:
				{
				_localctx = new UnaryMinusContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(112);
				match(MINUS);
				setState(113);
				expression(8);
				}
				break;
			case NUMBER:
				{
				_localctx = new NumberContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(114);
				match(NUMBER);
				}
				break;
			case STR:
				{
				_localctx = new StrContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(115);
				match(STR);
				}
				break;
			case ID:
				{
				_localctx = new IdContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(116);
				match(ID);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(133);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(131);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
					case 1:
						{
						_localctx = new TimesContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(119);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(120);
						match(TIMES);
						setState(121);
						expression(8);
						}
						break;
					case 2:
						{
						_localctx = new DivContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(122);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(123);
						match(DIV);
						setState(124);
						expression(7);
						}
						break;
					case 3:
						{
						_localctx = new PlusContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(125);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(126);
						match(PLUS);
						setState(127);
						expression(6);
						}
						break;
					case 4:
						{
						_localctx = new MinusContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(128);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(129);
						match(MINUS);
						setState(130);
						expression(5);
						}
						break;
					}
					} 
				}
				setState(135);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ConditionContext extends ParserRuleContext {
		public IfStatementContext ifStatement() {
			return getRuleContext(IfStatementContext.class,0);
		}
		public ThenBlockContext thenBlock() {
			return getRuleContext(ThenBlockContext.class,0);
		}
		public ElseBlockContext elseBlock() {
			return getRuleContext(ElseBlockContext.class,0);
		}
		public ConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gListener ) ((gListener)listener).enterCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gListener ) ((gListener)listener).exitCondition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gVisitor ) return ((gVisitor<? extends T>)visitor).visitCondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionContext condition() throws RecognitionException {
		ConditionContext _localctx = new ConditionContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_condition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(136);
			ifStatement();
			setState(137);
			thenBlock();
			setState(139);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				{
				setState(138);
				elseBlock();
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

	public static class ThenBlockContext extends ParserRuleContext {
		public InstBlockContext instBlock() {
			return getRuleContext(InstBlockContext.class,0);
		}
		public InstructionContext instruction() {
			return getRuleContext(InstructionContext.class,0);
		}
		public ThenBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_thenBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gListener ) ((gListener)listener).enterThenBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gListener ) ((gListener)listener).exitThenBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gVisitor ) return ((gVisitor<? extends T>)visitor).visitThenBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ThenBlockContext thenBlock() throws RecognitionException {
		ThenBlockContext _localctx = new ThenBlockContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_thenBlock);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(143);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case L_BR:
				{
				setState(141);
				instBlock();
				}
				break;
			case T__3:
			case T__6:
			case T__7:
			case ID:
			case NUMBER:
			case STR:
			case L_PAREN:
			case MINUS:
				{
				setState(142);
				instruction();
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

	public static class IfStatementContext extends ParserRuleContext {
		public TerminalNode L_PAREN() { return getToken(gParser.L_PAREN, 0); }
		public EvaluationContext evaluation() {
			return getRuleContext(EvaluationContext.class,0);
		}
		public TerminalNode R_PAREN() { return getToken(gParser.R_PAREN, 0); }
		public IfStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gListener ) ((gListener)listener).enterIfStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gListener ) ((gListener)listener).exitIfStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gVisitor ) return ((gVisitor<? extends T>)visitor).visitIfStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfStatementContext ifStatement() throws RecognitionException {
		IfStatementContext _localctx = new IfStatementContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_ifStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(145);
			match(T__3);
			setState(146);
			match(L_PAREN);
			setState(147);
			evaluation(0);
			setState(148);
			match(R_PAREN);
			setState(149);
			match(T__4);
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

	public static class EvaluationContext extends ParserRuleContext {
		public EvaluationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_evaluation; }
	 
		public EvaluationContext() { }
		public void copyFrom(EvaluationContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class NotContext extends EvaluationContext {
		public TerminalNode NOT() { return getToken(gParser.NOT, 0); }
		public EvaluationContext evaluation() {
			return getRuleContext(EvaluationContext.class,0);
		}
		public NotContext(EvaluationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gListener ) ((gListener)listener).enterNot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gListener ) ((gListener)listener).exitNot(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gVisitor ) return ((gVisitor<? extends T>)visitor).visitNot(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class OrContext extends EvaluationContext {
		public List<EvaluationContext> evaluation() {
			return getRuleContexts(EvaluationContext.class);
		}
		public EvaluationContext evaluation(int i) {
			return getRuleContext(EvaluationContext.class,i);
		}
		public TerminalNode OR() { return getToken(gParser.OR, 0); }
		public OrContext(EvaluationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gListener ) ((gListener)listener).enterOr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gListener ) ((gListener)listener).exitOr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gVisitor ) return ((gVisitor<? extends T>)visitor).visitOr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AndContext extends EvaluationContext {
		public List<EvaluationContext> evaluation() {
			return getRuleContexts(EvaluationContext.class);
		}
		public EvaluationContext evaluation(int i) {
			return getRuleContext(EvaluationContext.class,i);
		}
		public TerminalNode AND() { return getToken(gParser.AND, 0); }
		public AndContext(EvaluationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gListener ) ((gListener)listener).enterAnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gListener ) ((gListener)listener).exitAnd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gVisitor ) return ((gVisitor<? extends T>)visitor).visitAnd(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EvalParenContext extends EvaluationContext {
		public TerminalNode L_PAREN() { return getToken(gParser.L_PAREN, 0); }
		public EvaluationContext evaluation() {
			return getRuleContext(EvaluationContext.class,0);
		}
		public TerminalNode R_PAREN() { return getToken(gParser.R_PAREN, 0); }
		public EvalParenContext(EvaluationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gListener ) ((gListener)listener).enterEvalParen(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gListener ) ((gListener)listener).exitEvalParen(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gVisitor ) return ((gVisitor<? extends T>)visitor).visitEvalParen(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CompContext extends EvaluationContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode GT() { return getToken(gParser.GT, 0); }
		public TerminalNode GTE() { return getToken(gParser.GTE, 0); }
		public TerminalNode LT() { return getToken(gParser.LT, 0); }
		public TerminalNode LTE() { return getToken(gParser.LTE, 0); }
		public TerminalNode EQ() { return getToken(gParser.EQ, 0); }
		public TerminalNode NOT_EQ() { return getToken(gParser.NOT_EQ, 0); }
		public CompContext(EvaluationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gListener ) ((gListener)listener).enterComp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gListener ) ((gListener)listener).exitComp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gVisitor ) return ((gVisitor<? extends T>)visitor).visitComp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EvaluationContext evaluation() throws RecognitionException {
		return evaluation(0);
	}

	private EvaluationContext evaluation(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		EvaluationContext _localctx = new EvaluationContext(_ctx, _parentState);
		EvaluationContext _prevctx = _localctx;
		int _startState = 24;
		enterRecursionRule(_localctx, 24, RULE_evaluation, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(162);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				{
				_localctx = new EvalParenContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(152);
				match(L_PAREN);
				setState(153);
				evaluation(0);
				setState(154);
				match(R_PAREN);
				}
				break;
			case 2:
				{
				_localctx = new CompContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(156);
				expression(0);
				setState(157);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GT) | (1L << GTE) | (1L << LT) | (1L << LTE) | (1L << EQ) | (1L << NOT_EQ))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(158);
				expression(0);
				}
				break;
			case 3:
				{
				_localctx = new NotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(160);
				match(NOT);
				setState(161);
				evaluation(3);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(172);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(170);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
					case 1:
						{
						_localctx = new AndContext(new EvaluationContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_evaluation);
						setState(164);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(165);
						match(AND);
						setState(166);
						evaluation(3);
						}
						break;
					case 2:
						{
						_localctx = new OrContext(new EvaluationContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_evaluation);
						setState(167);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(168);
						match(OR);
						setState(169);
						evaluation(2);
						}
						break;
					}
					} 
				}
				setState(174);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ElseBlockContext extends ParserRuleContext {
		public ThenBlockContext thenBlock() {
			return getRuleContext(ThenBlockContext.class,0);
		}
		public IfStatementContext ifStatement() {
			return getRuleContext(IfStatementContext.class,0);
		}
		public ElseBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gListener ) ((gListener)listener).enterElseBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gListener ) ((gListener)listener).exitElseBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gVisitor ) return ((gVisitor<? extends T>)visitor).visitElseBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElseBlockContext elseBlock() throws RecognitionException {
		ElseBlockContext _localctx = new ElseBlockContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_elseBlock);
		try {
			setState(181);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(175);
				match(T__5);
				setState(176);
				thenBlock();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(177);
				match(T__5);
				setState(178);
				ifStatement();
				setState(179);
				thenBlock();
				}
				break;
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

	public static class InputContext extends ParserRuleContext {
		public TerminalNode L_PAREN() { return getToken(gParser.L_PAREN, 0); }
		public TerminalNode FORMAT() { return getToken(gParser.FORMAT, 0); }
		public TerminalNode COMA() { return getToken(gParser.COMA, 0); }
		public IdListContext idList() {
			return getRuleContext(IdListContext.class,0);
		}
		public TerminalNode R_PAREN() { return getToken(gParser.R_PAREN, 0); }
		public InputContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_input; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gListener ) ((gListener)listener).enterInput(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gListener ) ((gListener)listener).exitInput(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gVisitor ) return ((gVisitor<? extends T>)visitor).visitInput(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InputContext input() throws RecognitionException {
		InputContext _localctx = new InputContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_input);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(183);
			match(T__6);
			setState(184);
			match(L_PAREN);
			setState(185);
			match(FORMAT);
			setState(186);
			match(COMA);
			setState(187);
			idList();
			setState(188);
			match(R_PAREN);
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

	public static class OutputContext extends ParserRuleContext {
		public TerminalNode L_PAREN() { return getToken(gParser.L_PAREN, 0); }
		public TerminalNode STR() { return getToken(gParser.STR, 0); }
		public TerminalNode R_PAREN() { return getToken(gParser.R_PAREN, 0); }
		public TerminalNode COMA() { return getToken(gParser.COMA, 0); }
		public IdListContext idList() {
			return getRuleContext(IdListContext.class,0);
		}
		public OutputContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_output; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gListener ) ((gListener)listener).enterOutput(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gListener ) ((gListener)listener).exitOutput(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gVisitor ) return ((gVisitor<? extends T>)visitor).visitOutput(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OutputContext output() throws RecognitionException {
		OutputContext _localctx = new OutputContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_output);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(190);
			match(T__7);
			setState(191);
			match(L_PAREN);
			setState(192);
			match(STR);
			setState(195);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMA) {
				{
				setState(193);
				match(COMA);
				setState(194);
				idList();
				}
			}

			setState(197);
			match(R_PAREN);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 8:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		case 12:
			return evaluation_sempred((EvaluationContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 7);
		case 1:
			return precpred(_ctx, 6);
		case 2:
			return precpred(_ctx, 5);
		case 3:
			return precpred(_ctx, 4);
		}
		return true;
	}
	private boolean evaluation_sempred(EvaluationContext _localctx, int predIndex) {
		switch (predIndex) {
		case 4:
			return precpred(_ctx, 2);
		case 5:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3+\u00ca\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\3\2\6\2$\n"+
		"\2\r\2\16\2%\3\2\5\2)\n\2\3\2\3\2\3\2\3\2\7\2/\n\2\f\2\16\2\62\13\2\3"+
		"\2\5\2\65\n\2\3\2\3\2\3\2\3\3\3\3\3\3\6\3=\n\3\r\3\16\3>\3\4\3\4\3\4\6"+
		"\4D\n\4\r\4\16\4E\3\5\3\5\3\5\7\5K\n\5\f\5\16\5N\13\5\3\6\3\6\3\6\3\7"+
		"\3\7\7\7U\n\7\f\7\16\7X\13\7\3\7\3\7\3\b\3\b\3\b\3\b\5\b`\n\b\3\b\6\b"+
		"c\n\b\r\b\16\bd\3\b\5\bh\n\b\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\5\nx\n\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\7\n\u0086\n\n\f\n\16\n\u0089\13\n\3\13\3\13\3\13\5\13\u008e\n\13\3"+
		"\f\3\f\5\f\u0092\n\f\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u00a5\n\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\7\16\u00ad\n\16\f\16\16\16\u00b0\13\16\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\5\17\u00b8\n\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21"+
		"\3\21\3\21\5\21\u00c6\n\21\3\21\3\21\3\21\3%\4\22\32\22\2\4\6\b\n\f\16"+
		"\20\22\24\26\30\32\34\36 \2\4\3\2\16\17\3\2\37$\2\u00d6\2#\3\2\2\2\49"+
		"\3\2\2\2\6@\3\2\2\2\bG\3\2\2\2\nO\3\2\2\2\fR\3\2\2\2\16g\3\2\2\2\20i\3"+
		"\2\2\2\22w\3\2\2\2\24\u008a\3\2\2\2\26\u0091\3\2\2\2\30\u0093\3\2\2\2"+
		"\32\u00a4\3\2\2\2\34\u00b7\3\2\2\2\36\u00b9\3\2\2\2 \u00c0\3\2\2\2\"$"+
		"\5\4\3\2#\"\3\2\2\2$%\3\2\2\2%&\3\2\2\2%#\3\2\2\2&(\3\2\2\2\')\7\f\2\2"+
		"(\'\3\2\2\2()\3\2\2\2)*\3\2\2\2*+\7\3\2\2+,\7\13\2\2,\60\7(\2\2-/\5\6"+
		"\4\2.-\3\2\2\2/\62\3\2\2\2\60.\3\2\2\2\60\61\3\2\2\2\61\64\3\2\2\2\62"+
		"\60\3\2\2\2\63\65\5\n\6\2\64\63\3\2\2\2\64\65\3\2\2\2\65\66\3\2\2\2\66"+
		"\67\7)\2\2\678\7\2\2\38\3\3\2\2\29:\7\4\2\2:<\t\2\2\2;=\7\25\2\2<;\3\2"+
		"\2\2=>\3\2\2\2><\3\2\2\2>?\3\2\2\2?\5\3\2\2\2@A\7\r\2\2AC\5\b\5\2BD\7"+
		"\25\2\2CB\3\2\2\2DE\3\2\2\2EC\3\2\2\2EF\3\2\2\2F\7\3\2\2\2GL\7\16\2\2"+
		"HI\7\26\2\2IK\7\16\2\2JH\3\2\2\2KN\3\2\2\2LJ\3\2\2\2LM\3\2\2\2M\t\3\2"+
		"\2\2NL\3\2\2\2OP\7\5\2\2PQ\5\f\7\2Q\13\3\2\2\2RV\7(\2\2SU\5\16\b\2TS\3"+
		"\2\2\2UX\3\2\2\2VT\3\2\2\2VW\3\2\2\2WY\3\2\2\2XV\3\2\2\2YZ\7)\2\2Z\r\3"+
		"\2\2\2[`\5\20\t\2\\`\5\22\n\2]`\5\36\20\2^`\5 \21\2_[\3\2\2\2_\\\3\2\2"+
		"\2_]\3\2\2\2_^\3\2\2\2`b\3\2\2\2ac\7\25\2\2ba\3\2\2\2cd\3\2\2\2db\3\2"+
		"\2\2de\3\2\2\2eh\3\2\2\2fh\5\24\13\2g_\3\2\2\2gf\3\2\2\2h\17\3\2\2\2i"+
		"j\7\16\2\2jk\7\36\2\2kl\5\22\n\2l\21\3\2\2\2mn\b\n\1\2no\7\30\2\2op\5"+
		"\22\n\2pq\7\31\2\2qx\3\2\2\2rs\7\35\2\2sx\5\22\n\ntx\7\20\2\2ux\7\22\2"+
		"\2vx\7\16\2\2wm\3\2\2\2wr\3\2\2\2wt\3\2\2\2wu\3\2\2\2wv\3\2\2\2x\u0087"+
		"\3\2\2\2yz\f\t\2\2z{\7\32\2\2{\u0086\5\22\n\n|}\f\b\2\2}~\7\33\2\2~\u0086"+
		"\5\22\n\t\177\u0080\f\7\2\2\u0080\u0081\7\34\2\2\u0081\u0086\5\22\n\b"+
		"\u0082\u0083\f\6\2\2\u0083\u0084\7\35\2\2\u0084\u0086\5\22\n\7\u0085y"+
		"\3\2\2\2\u0085|\3\2\2\2\u0085\177\3\2\2\2\u0085\u0082\3\2\2\2\u0086\u0089"+
		"\3\2\2\2\u0087\u0085\3\2\2\2\u0087\u0088\3\2\2\2\u0088\23\3\2\2\2\u0089"+
		"\u0087\3\2\2\2\u008a\u008b\5\30\r\2\u008b\u008d\5\26\f\2\u008c\u008e\5"+
		"\34\17\2\u008d\u008c\3\2\2\2\u008d\u008e\3\2\2\2\u008e\25\3\2\2\2\u008f"+
		"\u0092\5\f\7\2\u0090\u0092\5\16\b\2\u0091\u008f\3\2\2\2\u0091\u0090\3"+
		"\2\2\2\u0092\27\3\2\2\2\u0093\u0094\7\6\2\2\u0094\u0095\7\30\2\2\u0095"+
		"\u0096\5\32\16\2\u0096\u0097\7\31\2\2\u0097\u0098\7\7\2\2\u0098\31\3\2"+
		"\2\2\u0099\u009a\b\16\1\2\u009a\u009b\7\30\2\2\u009b\u009c\5\32\16\2\u009c"+
		"\u009d\7\31\2\2\u009d\u00a5\3\2\2\2\u009e\u009f\5\22\n\2\u009f\u00a0\t"+
		"\3\2\2\u00a0\u00a1\5\22\n\2\u00a1\u00a5\3\2\2\2\u00a2\u00a3\7\'\2\2\u00a3"+
		"\u00a5\5\32\16\5\u00a4\u0099\3\2\2\2\u00a4\u009e\3\2\2\2\u00a4\u00a2\3"+
		"\2\2\2\u00a5\u00ae\3\2\2\2\u00a6\u00a7\f\4\2\2\u00a7\u00a8\7%\2\2\u00a8"+
		"\u00ad\5\32\16\5\u00a9\u00aa\f\3\2\2\u00aa\u00ab\7&\2\2\u00ab\u00ad\5"+
		"\32\16\4\u00ac\u00a6\3\2\2\2\u00ac\u00a9\3\2\2\2\u00ad\u00b0\3\2\2\2\u00ae"+
		"\u00ac\3\2\2\2\u00ae\u00af\3\2\2\2\u00af\33\3\2\2\2\u00b0\u00ae\3\2\2"+
		"\2\u00b1\u00b2\7\b\2\2\u00b2\u00b8\5\26\f\2\u00b3\u00b4\7\b\2\2\u00b4"+
		"\u00b5\5\30\r\2\u00b5\u00b6\5\26\f\2\u00b6\u00b8\3\2\2\2\u00b7\u00b1\3"+
		"\2\2\2\u00b7\u00b3\3\2\2\2\u00b8\35\3\2\2\2\u00b9\u00ba\7\t\2\2\u00ba"+
		"\u00bb\7\30\2\2\u00bb\u00bc\7\21\2\2\u00bc\u00bd\7\26\2\2\u00bd\u00be"+
		"\5\b\5\2\u00be\u00bf\7\31\2\2\u00bf\37\3\2\2\2\u00c0\u00c1\7\n\2\2\u00c1"+
		"\u00c2\7\30\2\2\u00c2\u00c5\7\22\2\2\u00c3\u00c4\7\26\2\2\u00c4\u00c6"+
		"\5\b\5\2\u00c5\u00c3\3\2\2\2\u00c5\u00c6\3\2\2\2\u00c6\u00c7\3\2\2\2\u00c7"+
		"\u00c8\7\31\2\2\u00c8!\3\2\2\2\27%(\60\64>ELV_dgw\u0085\u0087\u008d\u0091"+
		"\u00a4\u00ac\u00ae\u00b7\u00c5";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}