// Generated from src/com/chronicweirdo/makeitso/grammar/maps/Maps.g4 by ANTLR 4.1

package com.chronicweirdo.makeitso.grammar.maps;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MapsParser extends Parser {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__5=1, T__4=2, T__3=3, T__2=4, T__1=5, T__0=6, STRING=7, ID=8, NUMBER=9, 
		BLOCK_COMMENT=10, LINE_COMMENT=11, WS=12;
	public static final String[] tokenNames = {
		"<INVALID>", "']'", "','", "'['", "':'", "';'", "'|'", "STRING", "ID", 
		"NUMBER", "BLOCK_COMMENT", "LINE_COMMENT", "WS"
	};
	public static final int
		RULE_program = 0, RULE_statement = 1, RULE_function = 2, RULE_map = 3, 
		RULE_list = 4, RULE_entry = 5, RULE_key = 6, RULE_value = 7;
	public static final String[] ruleNames = {
		"program", "statement", "function", "map", "list", "entry", "key", "value"
	};

	@Override
	public String getGrammarFileName() { return "Maps.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public MapsParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MapsListener ) ((MapsListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MapsListener ) ((MapsListener)listener).exitProgram(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(19); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(16); statement();
				setState(17); match(5);
				}
				}
				setState(21); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==6 );
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

	public static class StatementContext extends ParserRuleContext {
		public FunctionContext function() {
			return getRuleContext(FunctionContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MapsListener ) ((MapsListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MapsListener ) ((MapsListener)listener).exitStatement(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(23); function();
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

	public static class FunctionContext extends ParserRuleContext {
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public FunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MapsListener ) ((MapsListener)listener).enterFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MapsListener ) ((MapsListener)listener).exitFunction(this);
		}
	}

	public final FunctionContext function() throws RecognitionException {
		FunctionContext _localctx = new FunctionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_function);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(25); match(6);
			setState(26); value(0);
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

	public static class MapContext extends ParserRuleContext {
		public EntryContext entry(int i) {
			return getRuleContext(EntryContext.class,i);
		}
		public List<EntryContext> entry() {
			return getRuleContexts(EntryContext.class);
		}
		public MapContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_map; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MapsListener ) ((MapsListener)listener).enterMap(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MapsListener ) ((MapsListener)listener).exitMap(this);
		}
	}

	public final MapContext map() throws RecognitionException {
		MapContext _localctx = new MapContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_map);
		int _la;
		try {
			setState(42);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(28); match(3);
				setState(29); entry();
				setState(34);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==2) {
					{
					{
					setState(30); match(2);
					setState(31); entry();
					}
					}
					setState(36);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(37); match(1);
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(39); match(3);
				setState(40); match(4);
				setState(41); match(1);
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

	public static class ListContext extends ParserRuleContext {
		public ValueContext value(int i) {
			return getRuleContext(ValueContext.class,i);
		}
		public List<ValueContext> value() {
			return getRuleContexts(ValueContext.class);
		}
		public ListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MapsListener ) ((MapsListener)listener).enterList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MapsListener ) ((MapsListener)listener).exitList(this);
		}
	}

	public final ListContext list() throws RecognitionException {
		ListContext _localctx = new ListContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_list);
		int _la;
		try {
			setState(57);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(44); match(3);
				setState(45); value(0);
				setState(50);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==2) {
					{
					{
					setState(46); match(2);
					setState(47); value(0);
					}
					}
					setState(52);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(53); match(1);
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(55); match(3);
				setState(56); match(1);
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

	public static class EntryContext extends ParserRuleContext {
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public KeyContext key() {
			return getRuleContext(KeyContext.class,0);
		}
		public EntryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_entry; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MapsListener ) ((MapsListener)listener).enterEntry(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MapsListener ) ((MapsListener)listener).exitEntry(this);
		}
	}

	public final EntryContext entry() throws RecognitionException {
		EntryContext _localctx = new EntryContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_entry);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(59); key();
			setState(60); match(4);
			setState(61); value(0);
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

	public static class KeyContext extends ParserRuleContext {
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public KeyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_key; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MapsListener ) ((MapsListener)listener).enterKey(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MapsListener ) ((MapsListener)listener).exitKey(this);
		}
	}

	public final KeyContext key() throws RecognitionException {
		KeyContext _localctx = new KeyContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_key);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(63); value(0);
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

	public static class ValueContext extends ParserRuleContext {
		public int _p;
		public FunctionContext function() {
			return getRuleContext(FunctionContext.class,0);
		}
		public KeyContext key() {
			return getRuleContext(KeyContext.class,0);
		}
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public ListContext list() {
			return getRuleContext(ListContext.class,0);
		}
		public TerminalNode ID() { return getToken(MapsParser.ID, 0); }
		public MapContext map() {
			return getRuleContext(MapContext.class,0);
		}
		public TerminalNode NUMBER() { return getToken(MapsParser.NUMBER, 0); }
		public TerminalNode STRING() { return getToken(MapsParser.STRING, 0); }
		public ValueContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public ValueContext(ParserRuleContext parent, int invokingState, int _p) {
			super(parent, invokingState);
			this._p = _p;
		}
		@Override public int getRuleIndex() { return RULE_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MapsListener ) ((MapsListener)listener).enterValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MapsListener ) ((MapsListener)listener).exitValue(this);
		}
	}

	public final ValueContext value(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ValueContext _localctx = new ValueContext(_ctx, _parentState, _p);
		ValueContext _prevctx = _localctx;
		int _startState = 14;
		enterRecursionRule(_localctx, RULE_value);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(72);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				{
				setState(66); match(STRING);
				}
				break;

			case 2:
				{
				setState(67); match(ID);
				}
				break;

			case 3:
				{
				setState(68); match(NUMBER);
				}
				break;

			case 4:
				{
				setState(69); map();
				}
				break;

			case 5:
				{
				setState(70); list();
				}
				break;

			case 6:
				{
				setState(71); function();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(81);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ValueContext(_parentctx, _parentState, _p);
					pushNewRecursionContext(_localctx, _startState, RULE_value);
					setState(74);
					if (!(2 >= _localctx._p)) throw new FailedPredicateException(this, "2 >= $_p");
					setState(75); match(3);
					setState(76); key();
					setState(77); match(1);
					}
					} 
				}
				setState(83);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 7: return value_sempred((ValueContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean value_sempred(ValueContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return 2 >= _localctx._p;
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\3\16W\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\3\2\3\2\3\2\6\2\26"+
		"\n\2\r\2\16\2\27\3\3\3\3\3\4\3\4\3\4\3\5\3\5\3\5\3\5\7\5#\n\5\f\5\16\5"+
		"&\13\5\3\5\3\5\3\5\3\5\3\5\5\5-\n\5\3\6\3\6\3\6\3\6\7\6\63\n\6\f\6\16"+
		"\6\66\13\6\3\6\3\6\3\6\3\6\5\6<\n\6\3\7\3\7\3\7\3\7\3\b\3\b\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\5\tK\n\t\3\t\3\t\3\t\3\t\3\t\7\tR\n\t\f\t\16\tU\13"+
		"\t\3\t\2\n\2\4\6\b\n\f\16\20\2\2Y\2\25\3\2\2\2\4\31\3\2\2\2\6\33\3\2\2"+
		"\2\b,\3\2\2\2\n;\3\2\2\2\f=\3\2\2\2\16A\3\2\2\2\20J\3\2\2\2\22\23\5\4"+
		"\3\2\23\24\7\7\2\2\24\26\3\2\2\2\25\22\3\2\2\2\26\27\3\2\2\2\27\25\3\2"+
		"\2\2\27\30\3\2\2\2\30\3\3\2\2\2\31\32\5\6\4\2\32\5\3\2\2\2\33\34\7\b\2"+
		"\2\34\35\5\20\t\2\35\7\3\2\2\2\36\37\7\5\2\2\37$\5\f\7\2 !\7\4\2\2!#\5"+
		"\f\7\2\" \3\2\2\2#&\3\2\2\2$\"\3\2\2\2$%\3\2\2\2%\'\3\2\2\2&$\3\2\2\2"+
		"\'(\7\3\2\2(-\3\2\2\2)*\7\5\2\2*+\7\6\2\2+-\7\3\2\2,\36\3\2\2\2,)\3\2"+
		"\2\2-\t\3\2\2\2./\7\5\2\2/\64\5\20\t\2\60\61\7\4\2\2\61\63\5\20\t\2\62"+
		"\60\3\2\2\2\63\66\3\2\2\2\64\62\3\2\2\2\64\65\3\2\2\2\65\67\3\2\2\2\66"+
		"\64\3\2\2\2\678\7\3\2\28<\3\2\2\29:\7\5\2\2:<\7\3\2\2;.\3\2\2\2;9\3\2"+
		"\2\2<\13\3\2\2\2=>\5\16\b\2>?\7\6\2\2?@\5\20\t\2@\r\3\2\2\2AB\5\20\t\2"+
		"B\17\3\2\2\2CD\b\t\1\2DK\7\t\2\2EK\7\n\2\2FK\7\13\2\2GK\5\b\5\2HK\5\n"+
		"\6\2IK\5\6\4\2JC\3\2\2\2JE\3\2\2\2JF\3\2\2\2JG\3\2\2\2JH\3\2\2\2JI\3\2"+
		"\2\2KS\3\2\2\2LM\6\t\2\3MN\7\5\2\2NO\5\16\b\2OP\7\3\2\2PR\3\2\2\2QL\3"+
		"\2\2\2RU\3\2\2\2SQ\3\2\2\2ST\3\2\2\2T\21\3\2\2\2US\3\2\2\2\t\27$,\64;"+
		"JS";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}