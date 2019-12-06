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
		RULE_evaluation = 12, RULE_elseBlock = 13, RULE_input = 14, RULE_output = 15, 
		RULE_outputArgs = 16, RULE_outputIdList = 17;
	private static String[] makeRuleNames() {
		return new String[] {
			"axiom", "importLib", "declaration", "idList", "mainBlock", "instBlock", 
			"instruction", "affectation", "expression", "condition", "thenBlock", 
			"ifStatement", "evaluation", "elseBlock", "input", "output", "outputArgs", 
			"outputIdList"
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
			setState(37); 
			_errHandler.sync(this);
			_alt = 1+1;
			do {
				switch (_alt) {
				case 1+1:
					{
					{
					setState(36);
					importLib();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(39); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			} while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(42);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==MODIFIER) {
				{
				setState(41);
				match(MODIFIER);
				}
			}

			setState(44);
			match(T__0);
			setState(45);
			match(CLASS_NAME);
			setState(46);
			match(L_BR);
			setState(50);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VAR_TYPE) {
				{
				{
				setState(47);
				declaration();
				}
				}
				setState(52);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(54);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__2) {
				{
				setState(53);
				mainBlock();
				}
			}

			setState(56);
			match(R_BR);
			setState(57);
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
			setState(59);
			match(T__1);
			setState(60);
			_la = _input.LA(1);
			if ( !(_la==ID || _la==LIBRARY) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(62); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(61);
				match(SEMI_COLON);
				}
				}
				setState(64); 
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
			setState(66);
			match(VAR_TYPE);
			setState(67);
			idList();
			setState(69); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(68);
				match(SEMI_COLON);
				}
				}
				setState(71); 
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
			setState(73);
			match(ID);
			setState(78);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMA) {
				{
				{
				setState(74);
				match(COMA);
				setState(75);
				match(ID);
				}
				}
				setState(80);
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
			setState(81);
			match(T__2);
			setState(82);
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
			setState(84);
			match(L_BR);
			setState(88);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__6) | (1L << T__7) | (1L << ID) | (1L << NUMBER) | (1L << STR) | (1L << L_PAREN) | (1L << MINUS))) != 0)) {
				{
				{
				setState(85);
				instruction();
				}
				}
				setState(90);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(91);
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
			setState(105);
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
				setState(97);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
				case 1:
					{
					setState(93);
					affectation();
					}
					break;
				case 2:
					{
					setState(94);
					expression(0);
					}
					break;
				case 3:
					{
					setState(95);
					input();
					}
					break;
				case 4:
					{
					setState(96);
					output();
					}
					break;
				}
				setState(100); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(99);
					match(SEMI_COLON);
					}
					}
					setState(102); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==SEMI_COLON );
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 2);
				{
				setState(104);
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
			setState(107);
			match(ID);
			setState(108);
			match(ASSIGN);
			setState(109);
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
			setState(121);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case L_PAREN:
				{
				_localctx = new ExpParenContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(112);
				match(L_PAREN);
				setState(113);
				expression(0);
				setState(114);
				match(R_PAREN);
				}
				break;
			case MINUS:
				{
				_localctx = new UnaryMinusContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(116);
				match(MINUS);
				setState(117);
				expression(8);
				}
				break;
			case NUMBER:
				{
				_localctx = new NumberContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(118);
				match(NUMBER);
				}
				break;
			case STR:
				{
				_localctx = new StrContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(119);
				match(STR);
				}
				break;
			case ID:
				{
				_localctx = new IdContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(120);
				match(ID);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(137);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(135);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
					case 1:
						{
						_localctx = new TimesContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(123);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(124);
						match(TIMES);
						setState(125);
						expression(8);
						}
						break;
					case 2:
						{
						_localctx = new DivContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(126);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(127);
						match(DIV);
						setState(128);
						expression(7);
						}
						break;
					case 3:
						{
						_localctx = new PlusContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(129);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(130);
						match(PLUS);
						setState(131);
						expression(6);
						}
						break;
					case 4:
						{
						_localctx = new MinusContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(132);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(133);
						match(MINUS);
						setState(134);
						expression(5);
						}
						break;
					}
					} 
				}
				setState(139);
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
			setState(140);
			ifStatement();
			setState(141);
			thenBlock();
			setState(143);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				{
				setState(142);
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
			setState(147);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case L_BR:
				{
				setState(145);
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
				setState(146);
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
			setState(149);
			match(T__3);
			setState(150);
			match(L_PAREN);
			setState(151);
			evaluation(0);
			setState(152);
			match(R_PAREN);
			setState(153);
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
			setState(166);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				{
				_localctx = new EvalParenContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(156);
				match(L_PAREN);
				setState(157);
				evaluation(0);
				setState(158);
				match(R_PAREN);
				}
				break;
			case 2:
				{
				_localctx = new CompContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(160);
				expression(0);
				setState(161);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GT) | (1L << GTE) | (1L << LT) | (1L << LTE) | (1L << EQ) | (1L << NOT_EQ))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(162);
				expression(0);
				}
				break;
			case 3:
				{
				_localctx = new NotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(164);
				match(NOT);
				setState(165);
				evaluation(3);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(176);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(174);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
					case 1:
						{
						_localctx = new AndContext(new EvaluationContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_evaluation);
						setState(168);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(169);
						match(AND);
						setState(170);
						evaluation(3);
						}
						break;
					case 2:
						{
						_localctx = new OrContext(new EvaluationContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_evaluation);
						setState(171);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(172);
						match(OR);
						setState(173);
						evaluation(2);
						}
						break;
					}
					} 
				}
				setState(178);
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
		public InstBlockContext instBlock() {
			return getRuleContext(InstBlockContext.class,0);
		}
		public InstructionContext instruction() {
			return getRuleContext(InstructionContext.class,0);
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
			setState(190);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(179);
				match(T__5);
				setState(182);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case L_BR:
					{
					setState(180);
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
					setState(181);
					instruction();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(184);
				match(T__5);
				setState(185);
				ifStatement();
				setState(188);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case L_BR:
					{
					setState(186);
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
					setState(187);
					instruction();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
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
			setState(192);
			match(T__6);
			setState(193);
			match(L_PAREN);
			setState(194);
			match(FORMAT);
			setState(195);
			match(COMA);
			setState(196);
			idList();
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

	public static class OutputContext extends ParserRuleContext {
		public TerminalNode L_PAREN() { return getToken(gParser.L_PAREN, 0); }
		public OutputArgsContext outputArgs() {
			return getRuleContext(OutputArgsContext.class,0);
		}
		public TerminalNode R_PAREN() { return getToken(gParser.R_PAREN, 0); }
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
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(199);
			match(T__7);
			setState(200);
			match(L_PAREN);
			setState(201);
			outputArgs();
			setState(202);
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

	public static class OutputArgsContext extends ParserRuleContext {
		public TerminalNode STR() { return getToken(gParser.STR, 0); }
		public OutputIdListContext outputIdList() {
			return getRuleContext(OutputIdListContext.class,0);
		}
		public OutputArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_outputArgs; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gListener ) ((gListener)listener).enterOutputArgs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gListener ) ((gListener)listener).exitOutputArgs(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gVisitor ) return ((gVisitor<? extends T>)visitor).visitOutputArgs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OutputArgsContext outputArgs() throws RecognitionException {
		OutputArgsContext _localctx = new OutputArgsContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_outputArgs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(204);
			match(STR);
			setState(206);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMA) {
				{
				setState(205);
				outputIdList();
				}
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

	public static class OutputIdListContext extends ParserRuleContext {
		public TerminalNode COMA() { return getToken(gParser.COMA, 0); }
		public IdListContext idList() {
			return getRuleContext(IdListContext.class,0);
		}
		public OutputIdListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_outputIdList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gListener ) ((gListener)listener).enterOutputIdList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gListener ) ((gListener)listener).exitOutputIdList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gVisitor ) return ((gVisitor<? extends T>)visitor).visitOutputIdList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OutputIdListContext outputIdList() throws RecognitionException {
		OutputIdListContext _localctx = new OutputIdListContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_outputIdList);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(208);
			match(COMA);
			setState(209);
			idList();
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3+\u00d6\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\3\2\6\2(\n\2\r\2\16\2)\3\2\5\2-\n\2\3\2\3\2\3\2\3\2\7\2\63"+
		"\n\2\f\2\16\2\66\13\2\3\2\5\29\n\2\3\2\3\2\3\2\3\3\3\3\3\3\6\3A\n\3\r"+
		"\3\16\3B\3\4\3\4\3\4\6\4H\n\4\r\4\16\4I\3\5\3\5\3\5\7\5O\n\5\f\5\16\5"+
		"R\13\5\3\6\3\6\3\6\3\7\3\7\7\7Y\n\7\f\7\16\7\\\13\7\3\7\3\7\3\b\3\b\3"+
		"\b\3\b\5\bd\n\b\3\b\6\bg\n\b\r\b\16\bh\3\b\5\bl\n\b\3\t\3\t\3\t\3\t\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n|\n\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\7\n\u008a\n\n\f\n\16\n\u008d\13\n\3\13\3\13"+
		"\3\13\5\13\u0092\n\13\3\f\3\f\5\f\u0096\n\f\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u00a9\n\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\7\16\u00b1\n\16\f\16\16\16\u00b4\13\16"+
		"\3\17\3\17\3\17\5\17\u00b9\n\17\3\17\3\17\3\17\3\17\5\17\u00bf\n\17\5"+
		"\17\u00c1\n\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21"+
		"\3\21\3\22\3\22\5\22\u00d1\n\22\3\23\3\23\3\23\3\23\3)\4\22\32\24\2\4"+
		"\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$\2\4\3\2\16\17\3\2\37$\2\u00e2"+
		"\2\'\3\2\2\2\4=\3\2\2\2\6D\3\2\2\2\bK\3\2\2\2\nS\3\2\2\2\fV\3\2\2\2\16"+
		"k\3\2\2\2\20m\3\2\2\2\22{\3\2\2\2\24\u008e\3\2\2\2\26\u0095\3\2\2\2\30"+
		"\u0097\3\2\2\2\32\u00a8\3\2\2\2\34\u00c0\3\2\2\2\36\u00c2\3\2\2\2 \u00c9"+
		"\3\2\2\2\"\u00ce\3\2\2\2$\u00d2\3\2\2\2&(\5\4\3\2\'&\3\2\2\2()\3\2\2\2"+
		")*\3\2\2\2)\'\3\2\2\2*,\3\2\2\2+-\7\f\2\2,+\3\2\2\2,-\3\2\2\2-.\3\2\2"+
		"\2./\7\3\2\2/\60\7\13\2\2\60\64\7(\2\2\61\63\5\6\4\2\62\61\3\2\2\2\63"+
		"\66\3\2\2\2\64\62\3\2\2\2\64\65\3\2\2\2\658\3\2\2\2\66\64\3\2\2\2\679"+
		"\5\n\6\28\67\3\2\2\289\3\2\2\29:\3\2\2\2:;\7)\2\2;<\7\2\2\3<\3\3\2\2\2"+
		"=>\7\4\2\2>@\t\2\2\2?A\7\25\2\2@?\3\2\2\2AB\3\2\2\2B@\3\2\2\2BC\3\2\2"+
		"\2C\5\3\2\2\2DE\7\r\2\2EG\5\b\5\2FH\7\25\2\2GF\3\2\2\2HI\3\2\2\2IG\3\2"+
		"\2\2IJ\3\2\2\2J\7\3\2\2\2KP\7\16\2\2LM\7\26\2\2MO\7\16\2\2NL\3\2\2\2O"+
		"R\3\2\2\2PN\3\2\2\2PQ\3\2\2\2Q\t\3\2\2\2RP\3\2\2\2ST\7\5\2\2TU\5\f\7\2"+
		"U\13\3\2\2\2VZ\7(\2\2WY\5\16\b\2XW\3\2\2\2Y\\\3\2\2\2ZX\3\2\2\2Z[\3\2"+
		"\2\2[]\3\2\2\2\\Z\3\2\2\2]^\7)\2\2^\r\3\2\2\2_d\5\20\t\2`d\5\22\n\2ad"+
		"\5\36\20\2bd\5 \21\2c_\3\2\2\2c`\3\2\2\2ca\3\2\2\2cb\3\2\2\2df\3\2\2\2"+
		"eg\7\25\2\2fe\3\2\2\2gh\3\2\2\2hf\3\2\2\2hi\3\2\2\2il\3\2\2\2jl\5\24\13"+
		"\2kc\3\2\2\2kj\3\2\2\2l\17\3\2\2\2mn\7\16\2\2no\7\36\2\2op\5\22\n\2p\21"+
		"\3\2\2\2qr\b\n\1\2rs\7\30\2\2st\5\22\n\2tu\7\31\2\2u|\3\2\2\2vw\7\35\2"+
		"\2w|\5\22\n\nx|\7\20\2\2y|\7\22\2\2z|\7\16\2\2{q\3\2\2\2{v\3\2\2\2{x\3"+
		"\2\2\2{y\3\2\2\2{z\3\2\2\2|\u008b\3\2\2\2}~\f\t\2\2~\177\7\32\2\2\177"+
		"\u008a\5\22\n\n\u0080\u0081\f\b\2\2\u0081\u0082\7\33\2\2\u0082\u008a\5"+
		"\22\n\t\u0083\u0084\f\7\2\2\u0084\u0085\7\34\2\2\u0085\u008a\5\22\n\b"+
		"\u0086\u0087\f\6\2\2\u0087\u0088\7\35\2\2\u0088\u008a\5\22\n\7\u0089}"+
		"\3\2\2\2\u0089\u0080\3\2\2\2\u0089\u0083\3\2\2\2\u0089\u0086\3\2\2\2\u008a"+
		"\u008d\3\2\2\2\u008b\u0089\3\2\2\2\u008b\u008c\3\2\2\2\u008c\23\3\2\2"+
		"\2\u008d\u008b\3\2\2\2\u008e\u008f\5\30\r\2\u008f\u0091\5\26\f\2\u0090"+
		"\u0092\5\34\17\2\u0091\u0090\3\2\2\2\u0091\u0092\3\2\2\2\u0092\25\3\2"+
		"\2\2\u0093\u0096\5\f\7\2\u0094\u0096\5\16\b\2\u0095\u0093\3\2\2\2\u0095"+
		"\u0094\3\2\2\2\u0096\27\3\2\2\2\u0097\u0098\7\6\2\2\u0098\u0099\7\30\2"+
		"\2\u0099\u009a\5\32\16\2\u009a\u009b\7\31\2\2\u009b\u009c\7\7\2\2\u009c"+
		"\31\3\2\2\2\u009d\u009e\b\16\1\2\u009e\u009f\7\30\2\2\u009f\u00a0\5\32"+
		"\16\2\u00a0\u00a1\7\31\2\2\u00a1\u00a9\3\2\2\2\u00a2\u00a3\5\22\n\2\u00a3"+
		"\u00a4\t\3\2\2\u00a4\u00a5\5\22\n\2\u00a5\u00a9\3\2\2\2\u00a6\u00a7\7"+
		"\'\2\2\u00a7\u00a9\5\32\16\5\u00a8\u009d\3\2\2\2\u00a8\u00a2\3\2\2\2\u00a8"+
		"\u00a6\3\2\2\2\u00a9\u00b2\3\2\2\2\u00aa\u00ab\f\4\2\2\u00ab\u00ac\7%"+
		"\2\2\u00ac\u00b1\5\32\16\5\u00ad\u00ae\f\3\2\2\u00ae\u00af\7&\2\2\u00af"+
		"\u00b1\5\32\16\4\u00b0\u00aa\3\2\2\2\u00b0\u00ad\3\2\2\2\u00b1\u00b4\3"+
		"\2\2\2\u00b2\u00b0\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3\33\3\2\2\2\u00b4"+
		"\u00b2\3\2\2\2\u00b5\u00b8\7\b\2\2\u00b6\u00b9\5\f\7\2\u00b7\u00b9\5\16"+
		"\b\2\u00b8\u00b6\3\2\2\2\u00b8\u00b7\3\2\2\2\u00b9\u00c1\3\2\2\2\u00ba"+
		"\u00bb\7\b\2\2\u00bb\u00be\5\30\r\2\u00bc\u00bf\5\f\7\2\u00bd\u00bf\5"+
		"\16\b\2\u00be\u00bc\3\2\2\2\u00be\u00bd\3\2\2\2\u00bf\u00c1\3\2\2\2\u00c0"+
		"\u00b5\3\2\2\2\u00c0\u00ba\3\2\2\2\u00c1\35\3\2\2\2\u00c2\u00c3\7\t\2"+
		"\2\u00c3\u00c4\7\30\2\2\u00c4\u00c5\7\21\2\2\u00c5\u00c6\7\26\2\2\u00c6"+
		"\u00c7\5\b\5\2\u00c7\u00c8\7\31\2\2\u00c8\37\3\2\2\2\u00c9\u00ca\7\n\2"+
		"\2\u00ca\u00cb\7\30\2\2\u00cb\u00cc\5\"\22\2\u00cc\u00cd\7\31\2\2\u00cd"+
		"!\3\2\2\2\u00ce\u00d0\7\22\2\2\u00cf\u00d1\5$\23\2\u00d0\u00cf\3\2\2\2"+
		"\u00d0\u00d1\3\2\2\2\u00d1#\3\2\2\2\u00d2\u00d3\7\26\2\2\u00d3\u00d4\5"+
		"\b\5\2\u00d4%\3\2\2\2\31),\648BIPZchk{\u0089\u008b\u0091\u0095\u00a8\u00b0"+
		"\u00b2\u00b8\u00be\u00c0\u00d0";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}