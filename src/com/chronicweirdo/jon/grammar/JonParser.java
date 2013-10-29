// Generated from src/com/chronicweirdo/jon/grammar/Jon.g4 by ANTLR 4.1

package com.chronicweirdo.jon.grammar;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class JonParser extends Parser {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__8=1, T__7=2, T__6=3, T__5=4, T__4=5, T__3=6, T__2=7, T__1=8, T__0=9, 
		TRUE=10, FALSE=11, STRING=12, ID=13, NUMBER=14, WS=15;
	public static final String[] tokenNames = {
		"<INVALID>", "']'", "'{'", "'.'", "')'", "','", "'['", "'('", "':'", "'}'", 
		"'true'", "'false'", "STRING", "ID", "NUMBER", "WS"
	};
	public static final int
		RULE_object = 0, RULE_type = 1, RULE_map = 2, RULE_entry = 3, RULE_list = 4, 
		RULE_value = 5, RULE_bool = 6;
	public static final String[] ruleNames = {
		"object", "type", "map", "entry", "list", "value", "bool"
	};

	@Override
	public String getGrammarFileName() { return "Jon.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public JonParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ObjectContext extends ParserRuleContext {
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public ListContext list() {
			return getRuleContext(ListContext.class,0);
		}
		public MapContext map() {
			return getRuleContext(MapContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ObjectContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_object; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JonListener ) ((JonListener)listener).enterObject(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JonListener ) ((JonListener)listener).exitObject(this);
		}
	}

	public final ObjectContext object() throws RecognitionException {
		ObjectContext _localctx = new ObjectContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_object);
		try {
			setState(23);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(14); type();
				setState(15); map();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(17); map();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(18); type();
				setState(19); list();
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(21); list();
				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(22); value();
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

	public static class TypeContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(JonParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(JonParser.ID, i);
		}
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JonListener ) ((JonListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JonListener ) ((JonListener)listener).exitType(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(25); match(7);
			setState(26); match(ID);
			setState(31);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==3) {
				{
				{
				setState(27); match(3);
				setState(28); match(ID);
				}
				}
				setState(33);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(34); match(4);
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
			if ( listener instanceof JonListener ) ((JonListener)listener).enterMap(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JonListener ) ((JonListener)listener).exitMap(this);
		}
	}

	public final MapContext map() throws RecognitionException {
		MapContext _localctx = new MapContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_map);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(36); match(2);
			setState(38);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 2) | (1L << 6) | (1L << 7) | (1L << TRUE) | (1L << FALSE) | (1L << STRING) | (1L << NUMBER))) != 0)) {
				{
				setState(37); entry();
				}
			}

			setState(44);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==5) {
				{
				{
				setState(40); match(5);
				setState(41); entry();
				}
				}
				setState(46);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(47); match(9);
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
		public ObjectContext object(int i) {
			return getRuleContext(ObjectContext.class,i);
		}
		public List<ObjectContext> object() {
			return getRuleContexts(ObjectContext.class);
		}
		public EntryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_entry; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JonListener ) ((JonListener)listener).enterEntry(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JonListener ) ((JonListener)listener).exitEntry(this);
		}
	}

	public final EntryContext entry() throws RecognitionException {
		EntryContext _localctx = new EntryContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_entry);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(49); object();
			setState(50); match(8);
			setState(51); object();
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
		public ObjectContext object(int i) {
			return getRuleContext(ObjectContext.class,i);
		}
		public List<ObjectContext> object() {
			return getRuleContexts(ObjectContext.class);
		}
		public ListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JonListener ) ((JonListener)listener).enterList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JonListener ) ((JonListener)listener).exitList(this);
		}
	}

	public final ListContext list() throws RecognitionException {
		ListContext _localctx = new ListContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(53); match(6);
			setState(55);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 2) | (1L << 6) | (1L << 7) | (1L << TRUE) | (1L << FALSE) | (1L << STRING) | (1L << NUMBER))) != 0)) {
				{
				setState(54); object();
				}
			}

			setState(61);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==5) {
				{
				{
				setState(57); match(5);
				setState(58); object();
				}
				}
				setState(63);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(64); match(1);
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
		public BoolContext bool() {
			return getRuleContext(BoolContext.class,0);
		}
		public TerminalNode NUMBER() { return getToken(JonParser.NUMBER, 0); }
		public TerminalNode STRING() { return getToken(JonParser.STRING, 0); }
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JonListener ) ((JonListener)listener).enterValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JonListener ) ((JonListener)listener).exitValue(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_value);
		try {
			setState(69);
			switch (_input.LA(1)) {
			case TRUE:
			case FALSE:
				enterOuterAlt(_localctx, 1);
				{
				setState(66); bool();
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 2);
				{
				setState(67); match(STRING);
				}
				break;
			case NUMBER:
				enterOuterAlt(_localctx, 3);
				{
				setState(68); match(NUMBER);
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

	public static class BoolContext extends ParserRuleContext {
		public TerminalNode TRUE() { return getToken(JonParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(JonParser.FALSE, 0); }
		public BoolContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bool; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JonListener ) ((JonListener)listener).enterBool(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JonListener ) ((JonListener)listener).exitBool(this);
		}
	}

	public final BoolContext bool() throws RecognitionException {
		BoolContext _localctx = new BoolContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_bool);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(71);
			_la = _input.LA(1);
			if ( !(_la==TRUE || _la==FALSE) ) {
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

	public static final String _serializedATN =
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\3\21L\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\5\2\32\n\2\3\3\3\3\3\3\3\3\7\3 \n\3\f\3\16\3#\13\3\3\3\3\3\3"+
		"\4\3\4\5\4)\n\4\3\4\3\4\7\4-\n\4\f\4\16\4\60\13\4\3\4\3\4\3\5\3\5\3\5"+
		"\3\5\3\6\3\6\5\6:\n\6\3\6\3\6\7\6>\n\6\f\6\16\6A\13\6\3\6\3\6\3\7\3\7"+
		"\3\7\5\7H\n\7\3\b\3\b\3\b\2\t\2\4\6\b\n\f\16\2\3\3\2\f\rO\2\31\3\2\2\2"+
		"\4\33\3\2\2\2\6&\3\2\2\2\b\63\3\2\2\2\n\67\3\2\2\2\fG\3\2\2\2\16I\3\2"+
		"\2\2\20\21\5\4\3\2\21\22\5\6\4\2\22\32\3\2\2\2\23\32\5\6\4\2\24\25\5\4"+
		"\3\2\25\26\5\n\6\2\26\32\3\2\2\2\27\32\5\n\6\2\30\32\5\f\7\2\31\20\3\2"+
		"\2\2\31\23\3\2\2\2\31\24\3\2\2\2\31\27\3\2\2\2\31\30\3\2\2\2\32\3\3\2"+
		"\2\2\33\34\7\t\2\2\34!\7\17\2\2\35\36\7\5\2\2\36 \7\17\2\2\37\35\3\2\2"+
		"\2 #\3\2\2\2!\37\3\2\2\2!\"\3\2\2\2\"$\3\2\2\2#!\3\2\2\2$%\7\6\2\2%\5"+
		"\3\2\2\2&(\7\4\2\2\')\5\b\5\2(\'\3\2\2\2()\3\2\2\2).\3\2\2\2*+\7\7\2\2"+
		"+-\5\b\5\2,*\3\2\2\2-\60\3\2\2\2.,\3\2\2\2./\3\2\2\2/\61\3\2\2\2\60.\3"+
		"\2\2\2\61\62\7\13\2\2\62\7\3\2\2\2\63\64\5\2\2\2\64\65\7\n\2\2\65\66\5"+
		"\2\2\2\66\t\3\2\2\2\679\7\b\2\28:\5\2\2\298\3\2\2\29:\3\2\2\2:?\3\2\2"+
		"\2;<\7\7\2\2<>\5\2\2\2=;\3\2\2\2>A\3\2\2\2?=\3\2\2\2?@\3\2\2\2@B\3\2\2"+
		"\2A?\3\2\2\2BC\7\3\2\2C\13\3\2\2\2DH\5\16\b\2EH\7\16\2\2FH\7\20\2\2GD"+
		"\3\2\2\2GE\3\2\2\2GF\3\2\2\2H\r\3\2\2\2IJ\t\2\2\2J\17\3\2\2\2\t\31!(."+
		"9?G";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}