// Generated from C:\enginfo\BitBucket repo\lapr4-2017-2dl\src\main\antlr4\lapr4\green\s3\lang\n1970581\formula\compiler\Formula4.g4 by ANTLR 4.4

    package lapr4.green.s3.lang.n1970581.formula.compiler;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class Formula4Parser extends Parser {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		TEMPORARY=1, GLOBAL=2, GLOBALINDEX=3, FUNCTION=4, CELL_REF=5, STRING=6, 
		QUOT=7, NUMBER=8, INTEIRO=9, DIGIT_NON_ZERO=10, EQ=11, NEQ=12, LTEQ=13, 
		GTEQ=14, GT=15, LT=16, AMP=17, PLUS=18, MINUS=19, MULTI=20, DIV=21, POWER=22, 
		PERCENT=23, COLON=24, UNDSCR=25, ARROBA=26, COMMA=27, SEMI=28, LPAR=29, 
		RPAR=30, L_CURLY_BRACKET=31, R_CURLY_BRACKET=32, L_SQR_BRACKET=33, R_SQR_BRACKET=34, 
		ASSIGN=35, WS=36;
	public static final String[] tokenNames = {
		"<INVALID>", "TEMPORARY", "GLOBAL", "GLOBALINDEX", "FUNCTION", "CELL_REF", 
		"STRING", "'\"'", "NUMBER", "INTEIRO", "DIGIT_NON_ZERO", "'='", "'<>'", 
		"'<='", "'>='", "'>'", "'<'", "'&'", "'+'", "'-'", "'*'", "'/'", "'^'", 
		"'%'", "':'", "'_'", "'@'", "','", "';'", "'('", "')'", "'{'", "'}'", 
		"'['", "']'", "':='", "WS"
	};
	public static final int
		RULE_expression = 0, RULE_block = 1, RULE_for_loop = 2, RULE_comparison = 3, 
		RULE_concatenation = 4, RULE_atom = 5, RULE_assignment = 6, RULE_function_call = 7, 
		RULE_reference = 8, RULE_variable = 9, RULE_literal = 10;
	public static final String[] ruleNames = {
		"expression", "block", "for_loop", "comparison", "concatenation", "atom", 
		"assignment", "function_call", "reference", "variable", "literal"
	};

	@Override
	public String getGrammarFileName() { return "Formula4.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public Formula4Parser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ExpressionContext extends ParserRuleContext {
		public ComparisonContext comparison() {
			return getRuleContext(ComparisonContext.class,0);
		}
		public TerminalNode EOF() { return getToken(Formula4Parser.EOF, 0); }
		public For_loopContext for_loop() {
			return getRuleContext(For_loopContext.class,0);
		}
		public TerminalNode EQ() { return getToken(Formula4Parser.EQ, 0); }
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Formula4Visitor ) return ((Formula4Visitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_expression);
		try {
			setState(30);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(22); match(EQ);
				setState(23); comparison();
				setState(24); match(EOF);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(26); match(EQ);
				setState(27); for_loop();
				setState(28); match(EOF);
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

	public static class BlockContext extends ParserRuleContext {
		public List<ComparisonContext> comparison() {
			return getRuleContexts(ComparisonContext.class);
		}
		public TerminalNode L_CURLY_BRACKET() { return getToken(Formula4Parser.L_CURLY_BRACKET, 0); }
		public List<TerminalNode> SEMI() { return getTokens(Formula4Parser.SEMI); }
		public TerminalNode SEMI(int i) {
			return getToken(Formula4Parser.SEMI, i);
		}
		public TerminalNode R_CURLY_BRACKET() { return getToken(Formula4Parser.R_CURLY_BRACKET, 0); }
		public ComparisonContext comparison(int i) {
			return getRuleContext(ComparisonContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Formula4Visitor ) return ((Formula4Visitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(32); match(L_CURLY_BRACKET);
			setState(33); comparison();
			setState(38);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEMI) {
				{
				{
				setState(34); match(SEMI);
				setState(35); comparison();
				}
				}
				setState(40);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(41); match(R_CURLY_BRACKET);
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

	public static class For_loopContext extends ParserRuleContext {
		public TerminalNode FUNCTION() { return getToken(Formula4Parser.FUNCTION, 0); }
		public List<ComparisonContext> comparison() {
			return getRuleContexts(ComparisonContext.class);
		}
		public TerminalNode L_CURLY_BRACKET() { return getToken(Formula4Parser.L_CURLY_BRACKET, 0); }
		public List<TerminalNode> SEMI() { return getTokens(Formula4Parser.SEMI); }
		public TerminalNode SEMI(int i) {
			return getToken(Formula4Parser.SEMI, i);
		}
		public TerminalNode R_CURLY_BRACKET() { return getToken(Formula4Parser.R_CURLY_BRACKET, 0); }
		public ComparisonContext comparison(int i) {
			return getRuleContext(ComparisonContext.class,i);
		}
		public For_loopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_for_loop; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Formula4Visitor ) return ((Formula4Visitor<? extends T>)visitor).visitFor_loop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final For_loopContext for_loop() throws RecognitionException {
		For_loopContext _localctx = new For_loopContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_for_loop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(43); match(FUNCTION);
			setState(44); match(L_CURLY_BRACKET);
			setState(45); comparison();
			setState(46); match(SEMI);
			setState(47); comparison();
			setState(48); match(SEMI);
			setState(49); comparison();
			setState(54);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEMI) {
				{
				{
				setState(50); match(SEMI);
				setState(51); comparison();
				}
				}
				setState(56);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(57); match(R_CURLY_BRACKET);
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

	public static class ComparisonContext extends ParserRuleContext {
		public ConcatenationContext concatenation(int i) {
			return getRuleContext(ConcatenationContext.class,i);
		}
		public TerminalNode NEQ() { return getToken(Formula4Parser.NEQ, 0); }
		public TerminalNode LTEQ() { return getToken(Formula4Parser.LTEQ, 0); }
		public List<ConcatenationContext> concatenation() {
			return getRuleContexts(ConcatenationContext.class);
		}
		public TerminalNode LT() { return getToken(Formula4Parser.LT, 0); }
		public TerminalNode GT() { return getToken(Formula4Parser.GT, 0); }
		public TerminalNode EQ() { return getToken(Formula4Parser.EQ, 0); }
		public TerminalNode GTEQ() { return getToken(Formula4Parser.GTEQ, 0); }
		public ComparisonContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparison; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Formula4Visitor ) return ((Formula4Visitor<? extends T>)visitor).visitComparison(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComparisonContext comparison() throws RecognitionException {
		ComparisonContext _localctx = new ComparisonContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_comparison);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(59); concatenation(0);
			setState(62);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EQ) | (1L << NEQ) | (1L << LTEQ) | (1L << GTEQ) | (1L << GT) | (1L << LT))) != 0)) {
				{
				setState(60);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EQ) | (1L << NEQ) | (1L << LTEQ) | (1L << GTEQ) | (1L << GT) | (1L << LT))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(61); concatenation(0);
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

	public static class ConcatenationContext extends ParserRuleContext {
		public TerminalNode MULTI() { return getToken(Formula4Parser.MULTI, 0); }
		public ConcatenationContext concatenation(int i) {
			return getRuleContext(ConcatenationContext.class,i);
		}
		public TerminalNode AMP() { return getToken(Formula4Parser.AMP, 0); }
		public TerminalNode POWER() { return getToken(Formula4Parser.POWER, 0); }
		public List<ConcatenationContext> concatenation() {
			return getRuleContexts(ConcatenationContext.class);
		}
		public TerminalNode MINUS() { return getToken(Formula4Parser.MINUS, 0); }
		public TerminalNode PLUS() { return getToken(Formula4Parser.PLUS, 0); }
		public TerminalNode PERCENT() { return getToken(Formula4Parser.PERCENT, 0); }
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public TerminalNode DIV() { return getToken(Formula4Parser.DIV, 0); }
		public ConcatenationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_concatenation; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Formula4Visitor ) return ((Formula4Visitor<? extends T>)visitor).visitConcatenation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConcatenationContext concatenation() throws RecognitionException {
		return concatenation(0);
	}

	private ConcatenationContext concatenation(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ConcatenationContext _localctx = new ConcatenationContext(_ctx, _parentState);
		ConcatenationContext _prevctx = _localctx;
		int _startState = 8;
		enterRecursionRule(_localctx, 8, RULE_concatenation, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(66);
			_la = _input.LA(1);
			if (_la==MINUS) {
				{
				setState(65); match(MINUS);
				}
			}

			setState(68); atom();
			}
			_ctx.stop = _input.LT(-1);
			setState(86);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(84);
					switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
					case 1:
						{
						_localctx = new ConcatenationContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_concatenation);
						setState(70);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(71); match(POWER);
						setState(72); concatenation(4);
						}
						break;
					case 2:
						{
						_localctx = new ConcatenationContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_concatenation);
						setState(73);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(74);
						_la = _input.LA(1);
						if ( !(_la==MULTI || _la==DIV) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(75); concatenation(4);
						}
						break;
					case 3:
						{
						_localctx = new ConcatenationContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_concatenation);
						setState(76);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(77);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(78); concatenation(3);
						}
						break;
					case 4:
						{
						_localctx = new ConcatenationContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_concatenation);
						setState(79);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(80); match(AMP);
						setState(81); concatenation(2);
						}
						break;
					case 5:
						{
						_localctx = new ConcatenationContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_concatenation);
						setState(82);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(83); match(PERCENT);
						}
						break;
					}
					} 
				}
				setState(88);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
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

	public static class AtomContext extends ParserRuleContext {
		public Function_callContext function_call() {
			return getRuleContext(Function_callContext.class,0);
		}
		public ComparisonContext comparison() {
			return getRuleContext(ComparisonContext.class,0);
		}
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public ReferenceContext reference() {
			return getRuleContext(ReferenceContext.class,0);
		}
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public TerminalNode LPAR() { return getToken(Formula4Parser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(Formula4Parser.RPAR, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public AtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atom; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Formula4Visitor ) return ((Formula4Visitor<? extends T>)visitor).visitAtom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtomContext atom() throws RecognitionException {
		AtomContext _localctx = new AtomContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_atom);
		try {
			setState(99);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(89); function_call();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(90); reference();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(91); literal();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(92); match(LPAR);
				setState(93); comparison();
				setState(94); match(RPAR);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(96); block();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(97); assignment();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(98); variable();
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

	public static class AssignmentContext extends ParserRuleContext {
		public TerminalNode ASSIGN() { return getToken(Formula4Parser.ASSIGN, 0); }
		public ComparisonContext comparison() {
			return getRuleContext(ComparisonContext.class,0);
		}
		public ReferenceContext reference() {
			return getRuleContext(ReferenceContext.class,0);
		}
		public TerminalNode LPAR() { return getToken(Formula4Parser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(Formula4Parser.RPAR, 0); }
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Formula4Visitor ) return ((Formula4Visitor<? extends T>)visitor).visitAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_assignment);
		try {
			setState(113);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(101); match(LPAR);
				setState(102); reference();
				setState(103); match(ASSIGN);
				setState(104); comparison();
				setState(105); match(RPAR);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(107); match(LPAR);
				setState(108); variable();
				setState(109); match(ASSIGN);
				setState(110); comparison();
				setState(111); match(RPAR);
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

	public static class Function_callContext extends ParserRuleContext {
		public TerminalNode FUNCTION() { return getToken(Formula4Parser.FUNCTION, 0); }
		public List<ComparisonContext> comparison() {
			return getRuleContexts(ComparisonContext.class);
		}
		public List<TerminalNode> SEMI() { return getTokens(Formula4Parser.SEMI); }
		public TerminalNode SEMI(int i) {
			return getToken(Formula4Parser.SEMI, i);
		}
		public TerminalNode LPAR() { return getToken(Formula4Parser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(Formula4Parser.RPAR, 0); }
		public ComparisonContext comparison(int i) {
			return getRuleContext(ComparisonContext.class,i);
		}
		public Function_callContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_call; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Formula4Visitor ) return ((Formula4Visitor<? extends T>)visitor).visitFunction_call(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Function_callContext function_call() throws RecognitionException {
		Function_callContext _localctx = new Function_callContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_function_call);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(115); match(FUNCTION);
			setState(116); match(LPAR);
			setState(125);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TEMPORARY) | (1L << GLOBAL) | (1L << GLOBALINDEX) | (1L << FUNCTION) | (1L << CELL_REF) | (1L << STRING) | (1L << NUMBER) | (1L << MINUS) | (1L << LPAR) | (1L << L_CURLY_BRACKET))) != 0)) {
				{
				setState(117); comparison();
				setState(122);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==SEMI) {
					{
					{
					setState(118); match(SEMI);
					setState(119); comparison();
					}
					}
					setState(124);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(127); match(RPAR);
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

	public static class ReferenceContext extends ParserRuleContext {
		public List<TerminalNode> CELL_REF() { return getTokens(Formula4Parser.CELL_REF); }
		public TerminalNode CELL_REF(int i) {
			return getToken(Formula4Parser.CELL_REF, i);
		}
		public TerminalNode COLON() { return getToken(Formula4Parser.COLON, 0); }
		public ReferenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_reference; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Formula4Visitor ) return ((Formula4Visitor<? extends T>)visitor).visitReference(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReferenceContext reference() throws RecognitionException {
		ReferenceContext _localctx = new ReferenceContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_reference);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(129); match(CELL_REF);
			setState(132);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				{
				setState(130); match(COLON);
				}
				setState(131); match(CELL_REF);
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

	public static class VariableContext extends ParserRuleContext {
		public TerminalNode TEMPORARY() { return getToken(Formula4Parser.TEMPORARY, 0); }
		public TerminalNode GLOBAL() { return getToken(Formula4Parser.GLOBAL, 0); }
		public TerminalNode GLOBALINDEX() { return getToken(Formula4Parser.GLOBALINDEX, 0); }
		public VariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Formula4Visitor ) return ((Formula4Visitor<? extends T>)visitor).visitVariable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableContext variable() throws RecognitionException {
		VariableContext _localctx = new VariableContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_variable);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(134);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TEMPORARY) | (1L << GLOBAL) | (1L << GLOBALINDEX))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
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

	public static class LiteralContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(Formula4Parser.STRING, 0); }
		public TerminalNode NUMBER() { return getToken(Formula4Parser.NUMBER, 0); }
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Formula4Visitor ) return ((Formula4Visitor<? extends T>)visitor).visitLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(136);
			_la = _input.LA(1);
			if ( !(_la==STRING || _la==NUMBER) ) {
			_errHandler.recoverInline(this);
			}
			consume();
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
		case 4: return concatenation_sempred((ConcatenationContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean concatenation_sempred(ConcatenationContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return precpred(_ctx, 4);
		case 1: return precpred(_ctx, 3);
		case 2: return precpred(_ctx, 2);
		case 3: return precpred(_ctx, 1);
		case 4: return precpred(_ctx, 5);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3&\u008d\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\5\2!\n\2\3\3\3\3\3\3\3\3\7"+
		"\3\'\n\3\f\3\16\3*\13\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\7"+
		"\4\67\n\4\f\4\16\4:\13\4\3\4\3\4\3\5\3\5\3\5\5\5A\n\5\3\6\3\6\5\6E\n\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6W"+
		"\n\6\f\6\16\6Z\13\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7f\n\7\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\bt\n\b\3\t\3\t\3\t\3"+
		"\t\3\t\7\t{\n\t\f\t\16\t~\13\t\5\t\u0080\n\t\3\t\3\t\3\n\3\n\3\n\5\n\u0087"+
		"\n\n\3\13\3\13\3\f\3\f\3\f\2\3\n\r\2\4\6\b\n\f\16\20\22\24\26\2\7\3\2"+
		"\r\22\3\2\26\27\3\2\24\25\3\2\3\5\4\2\b\b\n\n\u0095\2 \3\2\2\2\4\"\3\2"+
		"\2\2\6-\3\2\2\2\b=\3\2\2\2\nB\3\2\2\2\fe\3\2\2\2\16s\3\2\2\2\20u\3\2\2"+
		"\2\22\u0083\3\2\2\2\24\u0088\3\2\2\2\26\u008a\3\2\2\2\30\31\7\r\2\2\31"+
		"\32\5\b\5\2\32\33\7\2\2\3\33!\3\2\2\2\34\35\7\r\2\2\35\36\5\6\4\2\36\37"+
		"\7\2\2\3\37!\3\2\2\2 \30\3\2\2\2 \34\3\2\2\2!\3\3\2\2\2\"#\7!\2\2#(\5"+
		"\b\5\2$%\7\36\2\2%\'\5\b\5\2&$\3\2\2\2\'*\3\2\2\2(&\3\2\2\2()\3\2\2\2"+
		")+\3\2\2\2*(\3\2\2\2+,\7\"\2\2,\5\3\2\2\2-.\7\6\2\2./\7!\2\2/\60\5\b\5"+
		"\2\60\61\7\36\2\2\61\62\5\b\5\2\62\63\7\36\2\2\638\5\b\5\2\64\65\7\36"+
		"\2\2\65\67\5\b\5\2\66\64\3\2\2\2\67:\3\2\2\28\66\3\2\2\289\3\2\2\29;\3"+
		"\2\2\2:8\3\2\2\2;<\7\"\2\2<\7\3\2\2\2=@\5\n\6\2>?\t\2\2\2?A\5\n\6\2@>"+
		"\3\2\2\2@A\3\2\2\2A\t\3\2\2\2BD\b\6\1\2CE\7\25\2\2DC\3\2\2\2DE\3\2\2\2"+
		"EF\3\2\2\2FG\5\f\7\2GX\3\2\2\2HI\f\6\2\2IJ\7\30\2\2JW\5\n\6\6KL\f\5\2"+
		"\2LM\t\3\2\2MW\5\n\6\6NO\f\4\2\2OP\t\4\2\2PW\5\n\6\5QR\f\3\2\2RS\7\23"+
		"\2\2SW\5\n\6\4TU\f\7\2\2UW\7\31\2\2VH\3\2\2\2VK\3\2\2\2VN\3\2\2\2VQ\3"+
		"\2\2\2VT\3\2\2\2WZ\3\2\2\2XV\3\2\2\2XY\3\2\2\2Y\13\3\2\2\2ZX\3\2\2\2["+
		"f\5\20\t\2\\f\5\22\n\2]f\5\26\f\2^_\7\37\2\2_`\5\b\5\2`a\7 \2\2af\3\2"+
		"\2\2bf\5\4\3\2cf\5\16\b\2df\5\24\13\2e[\3\2\2\2e\\\3\2\2\2e]\3\2\2\2e"+
		"^\3\2\2\2eb\3\2\2\2ec\3\2\2\2ed\3\2\2\2f\r\3\2\2\2gh\7\37\2\2hi\5\22\n"+
		"\2ij\7%\2\2jk\5\b\5\2kl\7 \2\2lt\3\2\2\2mn\7\37\2\2no\5\24\13\2op\7%\2"+
		"\2pq\5\b\5\2qr\7 \2\2rt\3\2\2\2sg\3\2\2\2sm\3\2\2\2t\17\3\2\2\2uv\7\6"+
		"\2\2v\177\7\37\2\2w|\5\b\5\2xy\7\36\2\2y{\5\b\5\2zx\3\2\2\2{~\3\2\2\2"+
		"|z\3\2\2\2|}\3\2\2\2}\u0080\3\2\2\2~|\3\2\2\2\177w\3\2\2\2\177\u0080\3"+
		"\2\2\2\u0080\u0081\3\2\2\2\u0081\u0082\7 \2\2\u0082\21\3\2\2\2\u0083\u0086"+
		"\7\7\2\2\u0084\u0085\7\32\2\2\u0085\u0087\7\7\2\2\u0086\u0084\3\2\2\2"+
		"\u0086\u0087\3\2\2\2\u0087\23\3\2\2\2\u0088\u0089\t\5\2\2\u0089\25\3\2"+
		"\2\2\u008a\u008b\t\6\2\2\u008b\27\3\2\2\2\16 (8@DVXes|\177\u0086";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}