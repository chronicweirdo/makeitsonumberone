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
		T__14=1, T__13=2, T__12=3, T__11=4, T__10=5, T__9=6, T__8=7, T__7=8, T__6=9, 
		T__5=10, T__4=11, T__3=12, T__2=13, T__1=14, T__0=15, NULL=16, TRUE=17, 
		FALSE=18, STRING=19, CHAR=20, ID=21, FLOAT=22, INTEGER=23, HEXADECIMAL=24, 
		BINARY=25, WS=26;
	public static final String[] tokenNames = {
		"<INVALID>", "']'", "')'", "'.'", "','", "'D'", "'['", "':'", "'('", "'d'", 
		"'f'", "'l'", "'{'", "'F'", "'}'", "'L'", "'null'", "'true'", "'false'", 
		"STRING", "CHAR", "ID", "FLOAT", "INTEGER", "HEXADECIMAL", "BINARY", "WS"
	};
	public static final int
		RULE_object = 0, RULE_type = 1, RULE_map = 2, RULE_entry = 3, RULE_key = 4, 
		RULE_value = 5, RULE_list = 6, RULE_primitive = 7, RULE_p_int = 8, RULE_p_long = 9, 
		RULE_p_float = 10, RULE_p_double = 11, RULE_p_char = 12, RULE_p_string = 13, 
		RULE_p_boolean = 14;
	public static final String[] ruleNames = {
		"object", "type", "map", "entry", "key", "value", "list", "primitive", 
		"p_int", "p_long", "p_float", "p_double", "p_char", "p_string", "p_boolean"
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
		public ListContext list() {
			return getRuleContext(ListContext.class,0);
		}
		public MapContext map() {
			return getRuleContext(MapContext.class,0);
		}
		public PrimitiveContext primitive() {
			return getRuleContext(PrimitiveContext.class,0);
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
			setState(39);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(30); type();
				setState(31); map();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(33); map();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(34); type();
				setState(35); list();
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(37); list();
				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(38); primitive();
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
			setState(59);
			switch (_input.LA(1)) {
			case 8:
				enterOuterAlt(_localctx, 1);
				{
				setState(41); match(8);
				setState(42); match(ID);
				setState(47);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==3) {
					{
					{
					setState(43); match(3);
					setState(44); match(ID);
					}
					}
					setState(49);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(50); match(2);
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(51); match(ID);
				setState(56);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==3) {
					{
					{
					setState(52); match(3);
					setState(53); match(ID);
					}
					}
					setState(58);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
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
			setState(61); match(12);
			setState(63);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 6) | (1L << 8) | (1L << 12) | (1L << TRUE) | (1L << FALSE) | (1L << STRING) | (1L << CHAR) | (1L << ID) | (1L << FLOAT) | (1L << INTEGER) | (1L << HEXADECIMAL) | (1L << BINARY))) != 0)) {
				{
				setState(62); entry();
				}
			}

			setState(69);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==4) {
				{
				{
				setState(65); match(4);
				setState(66); entry();
				}
				}
				setState(71);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(72); match(14);
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
			setState(74); key();
			setState(75); match(7);
			setState(76); value();
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
		public ObjectContext object() {
			return getRuleContext(ObjectContext.class,0);
		}
		public TerminalNode ID() { return getToken(JonParser.ID, 0); }
		public KeyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_key; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JonListener ) ((JonListener)listener).enterKey(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JonListener ) ((JonListener)listener).exitKey(this);
		}
	}

	public final KeyContext key() throws RecognitionException {
		KeyContext _localctx = new KeyContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_key);
		try {
			setState(80);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(78); object();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(79); match(ID);
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

	public static class ValueContext extends ParserRuleContext {
		public ObjectContext object() {
			return getRuleContext(ObjectContext.class,0);
		}
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
			enterOuterAlt(_localctx, 1);
			{
			setState(82); object();
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
		enterRule(_localctx, 12, RULE_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(84); match(6);
			setState(86);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 6) | (1L << 8) | (1L << 12) | (1L << TRUE) | (1L << FALSE) | (1L << STRING) | (1L << CHAR) | (1L << ID) | (1L << FLOAT) | (1L << INTEGER) | (1L << HEXADECIMAL) | (1L << BINARY))) != 0)) {
				{
				setState(85); object();
				}
			}

			setState(92);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==4) {
				{
				{
				setState(88); match(4);
				setState(89); object();
				}
				}
				setState(94);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(95); match(1);
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

	public static class PrimitiveContext extends ParserRuleContext {
		public P_stringContext p_string() {
			return getRuleContext(P_stringContext.class,0);
		}
		public P_intContext p_int() {
			return getRuleContext(P_intContext.class,0);
		}
		public P_floatContext p_float() {
			return getRuleContext(P_floatContext.class,0);
		}
		public P_doubleContext p_double() {
			return getRuleContext(P_doubleContext.class,0);
		}
		public P_booleanContext p_boolean() {
			return getRuleContext(P_booleanContext.class,0);
		}
		public P_charContext p_char() {
			return getRuleContext(P_charContext.class,0);
		}
		public P_longContext p_long() {
			return getRuleContext(P_longContext.class,0);
		}
		public PrimitiveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primitive; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JonListener ) ((JonListener)listener).enterPrimitive(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JonListener ) ((JonListener)listener).exitPrimitive(this);
		}
	}

	public final PrimitiveContext primitive() throws RecognitionException {
		PrimitiveContext _localctx = new PrimitiveContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_primitive);
		try {
			setState(104);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(97); p_int();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(98); p_long();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(99); p_float();
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(100); p_double();
				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(101); p_string();
				}
				break;

			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(102); p_char();
				}
				break;

			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(103); p_boolean();
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

	public static class P_intContext extends ParserRuleContext {
		public TerminalNode HEXADECIMAL() { return getToken(JonParser.HEXADECIMAL, 0); }
		public TerminalNode BINARY() { return getToken(JonParser.BINARY, 0); }
		public TerminalNode INTEGER() { return getToken(JonParser.INTEGER, 0); }
		public P_intContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_p_int; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JonListener ) ((JonListener)listener).enterP_int(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JonListener ) ((JonListener)listener).exitP_int(this);
		}
	}

	public final P_intContext p_int() throws RecognitionException {
		P_intContext _localctx = new P_intContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_p_int);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(106);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INTEGER) | (1L << HEXADECIMAL) | (1L << BINARY))) != 0)) ) {
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

	public static class P_longContext extends ParserRuleContext {
		public TerminalNode INTEGER() { return getToken(JonParser.INTEGER, 0); }
		public P_longContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_p_long; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JonListener ) ((JonListener)listener).enterP_long(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JonListener ) ((JonListener)listener).exitP_long(this);
		}
	}

	public final P_longContext p_long() throws RecognitionException {
		P_longContext _localctx = new P_longContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_p_long);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(108); match(INTEGER);
			setState(109);
			_la = _input.LA(1);
			if ( !(_la==11 || _la==15) ) {
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

	public static class P_floatContext extends ParserRuleContext {
		public TerminalNode FLOAT() { return getToken(JonParser.FLOAT, 0); }
		public P_floatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_p_float; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JonListener ) ((JonListener)listener).enterP_float(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JonListener ) ((JonListener)listener).exitP_float(this);
		}
	}

	public final P_floatContext p_float() throws RecognitionException {
		P_floatContext _localctx = new P_floatContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_p_float);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(111); match(FLOAT);
			setState(112);
			_la = _input.LA(1);
			if ( !(_la==10 || _la==13) ) {
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

	public static class P_doubleContext extends ParserRuleContext {
		public TerminalNode FLOAT() { return getToken(JonParser.FLOAT, 0); }
		public P_doubleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_p_double; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JonListener ) ((JonListener)listener).enterP_double(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JonListener ) ((JonListener)listener).exitP_double(this);
		}
	}

	public final P_doubleContext p_double() throws RecognitionException {
		P_doubleContext _localctx = new P_doubleContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_p_double);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(114); match(FLOAT);
			setState(116);
			_la = _input.LA(1);
			if (_la==5 || _la==9) {
				{
				setState(115);
				_la = _input.LA(1);
				if ( !(_la==5 || _la==9) ) {
				_errHandler.recoverInline(this);
				}
				consume();
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

	public static class P_charContext extends ParserRuleContext {
		public TerminalNode CHAR() { return getToken(JonParser.CHAR, 0); }
		public P_charContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_p_char; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JonListener ) ((JonListener)listener).enterP_char(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JonListener ) ((JonListener)listener).exitP_char(this);
		}
	}

	public final P_charContext p_char() throws RecognitionException {
		P_charContext _localctx = new P_charContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_p_char);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(118); match(CHAR);
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

	public static class P_stringContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(JonParser.STRING, 0); }
		public P_stringContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_p_string; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JonListener ) ((JonListener)listener).enterP_string(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JonListener ) ((JonListener)listener).exitP_string(this);
		}
	}

	public final P_stringContext p_string() throws RecognitionException {
		P_stringContext _localctx = new P_stringContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_p_string);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(120); match(STRING);
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

	public static class P_booleanContext extends ParserRuleContext {
		public TerminalNode TRUE() { return getToken(JonParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(JonParser.FALSE, 0); }
		public P_booleanContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_p_boolean; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JonListener ) ((JonListener)listener).enterP_boolean(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JonListener ) ((JonListener)listener).exitP_boolean(this);
		}
	}

	public final P_booleanContext p_boolean() throws RecognitionException {
		P_booleanContext _localctx = new P_booleanContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_p_boolean);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(122);
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
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\3\34\177\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\5\2*\n\2\3\3\3\3\3\3\3\3\7\3\60\n\3\f\3\16\3\63\13\3"+
		"\3\3\3\3\3\3\3\3\7\39\n\3\f\3\16\3<\13\3\5\3>\n\3\3\4\3\4\5\4B\n\4\3\4"+
		"\3\4\7\4F\n\4\f\4\16\4I\13\4\3\4\3\4\3\5\3\5\3\5\3\5\3\6\3\6\5\6S\n\6"+
		"\3\7\3\7\3\b\3\b\5\bY\n\b\3\b\3\b\7\b]\n\b\f\b\16\b`\13\b\3\b\3\b\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\5\tk\n\t\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\f\3"+
		"\r\3\r\5\rw\n\r\3\16\3\16\3\17\3\17\3\20\3\20\3\20\2\21\2\4\6\b\n\f\16"+
		"\20\22\24\26\30\32\34\36\2\7\3\2\31\33\4\2\r\r\21\21\4\2\f\f\17\17\4\2"+
		"\7\7\13\13\3\2\23\24\u0082\2)\3\2\2\2\4=\3\2\2\2\6?\3\2\2\2\bL\3\2\2\2"+
		"\nR\3\2\2\2\fT\3\2\2\2\16V\3\2\2\2\20j\3\2\2\2\22l\3\2\2\2\24n\3\2\2\2"+
		"\26q\3\2\2\2\30t\3\2\2\2\32x\3\2\2\2\34z\3\2\2\2\36|\3\2\2\2 !\5\4\3\2"+
		"!\"\5\6\4\2\"*\3\2\2\2#*\5\6\4\2$%\5\4\3\2%&\5\16\b\2&*\3\2\2\2\'*\5\16"+
		"\b\2(*\5\20\t\2) \3\2\2\2)#\3\2\2\2)$\3\2\2\2)\'\3\2\2\2)(\3\2\2\2*\3"+
		"\3\2\2\2+,\7\n\2\2,\61\7\27\2\2-.\7\5\2\2.\60\7\27\2\2/-\3\2\2\2\60\63"+
		"\3\2\2\2\61/\3\2\2\2\61\62\3\2\2\2\62\64\3\2\2\2\63\61\3\2\2\2\64>\7\4"+
		"\2\2\65:\7\27\2\2\66\67\7\5\2\2\679\7\27\2\28\66\3\2\2\29<\3\2\2\2:8\3"+
		"\2\2\2:;\3\2\2\2;>\3\2\2\2<:\3\2\2\2=+\3\2\2\2=\65\3\2\2\2>\5\3\2\2\2"+
		"?A\7\16\2\2@B\5\b\5\2A@\3\2\2\2AB\3\2\2\2BG\3\2\2\2CD\7\6\2\2DF\5\b\5"+
		"\2EC\3\2\2\2FI\3\2\2\2GE\3\2\2\2GH\3\2\2\2HJ\3\2\2\2IG\3\2\2\2JK\7\20"+
		"\2\2K\7\3\2\2\2LM\5\n\6\2MN\7\t\2\2NO\5\f\7\2O\t\3\2\2\2PS\5\2\2\2QS\7"+
		"\27\2\2RP\3\2\2\2RQ\3\2\2\2S\13\3\2\2\2TU\5\2\2\2U\r\3\2\2\2VX\7\b\2\2"+
		"WY\5\2\2\2XW\3\2\2\2XY\3\2\2\2Y^\3\2\2\2Z[\7\6\2\2[]\5\2\2\2\\Z\3\2\2"+
		"\2]`\3\2\2\2^\\\3\2\2\2^_\3\2\2\2_a\3\2\2\2`^\3\2\2\2ab\7\3\2\2b\17\3"+
		"\2\2\2ck\5\22\n\2dk\5\24\13\2ek\5\26\f\2fk\5\30\r\2gk\5\34\17\2hk\5\32"+
		"\16\2ik\5\36\20\2jc\3\2\2\2jd\3\2\2\2je\3\2\2\2jf\3\2\2\2jg\3\2\2\2jh"+
		"\3\2\2\2ji\3\2\2\2k\21\3\2\2\2lm\t\2\2\2m\23\3\2\2\2no\7\31\2\2op\t\3"+
		"\2\2p\25\3\2\2\2qr\7\30\2\2rs\t\4\2\2s\27\3\2\2\2tv\7\30\2\2uw\t\5\2\2"+
		"vu\3\2\2\2vw\3\2\2\2w\31\3\2\2\2xy\7\26\2\2y\33\3\2\2\2z{\7\25\2\2{\35"+
		"\3\2\2\2|}\t\6\2\2}\37\3\2\2\2\r)\61:=AGRX^jv";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}