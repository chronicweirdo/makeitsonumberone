// Generated from src/com/chronicweirdo/jbon/grammar/JBON.g4 by ANTLR 4.1

package com.chronicweirdo.jbon.grammar;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class JBONParser extends Parser {
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
		RULE_file = 0, RULE_object = 1, RULE_type = 2, RULE_map = 3, RULE_entry = 4, 
		RULE_key = 5, RULE_value = 6, RULE_list = 7, RULE_primitive = 8, RULE_p_int = 9, 
		RULE_p_long = 10, RULE_p_float = 11, RULE_p_double = 12, RULE_p_char = 13, 
		RULE_p_string = 14, RULE_p_boolean = 15;
	public static final String[] ruleNames = {
		"file", "object", "type", "map", "entry", "key", "value", "list", "primitive", 
		"p_int", "p_long", "p_float", "p_double", "p_char", "p_string", "p_boolean"
	};

	@Override
	public String getGrammarFileName() { return "JBON.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public JBONParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class FileContext extends ParserRuleContext {
		public ObjectContext object() {
			return getRuleContext(ObjectContext.class,0);
		}
		public FileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_file; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JBONListener ) ((JBONListener)listener).enterFile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JBONListener ) ((JBONListener)listener).exitFile(this);
		}
	}

	public final FileContext file() throws RecognitionException {
		FileContext _localctx = new FileContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_file);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(32); object();
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
			if ( listener instanceof JBONListener ) ((JBONListener)listener).enterObject(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JBONListener ) ((JBONListener)listener).exitObject(this);
		}
	}

	public final ObjectContext object() throws RecognitionException {
		ObjectContext _localctx = new ObjectContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_object);
		try {
			setState(43);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(34); type();
				setState(35); map();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(37); map();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(38); type();
				setState(39); list();
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(41); list();
				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(42); primitive();
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
		public List<TerminalNode> ID() { return getTokens(JBONParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(JBONParser.ID, i);
		}
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JBONListener ) ((JBONListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JBONListener ) ((JBONListener)listener).exitType(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_type);
		int _la;
		try {
			setState(63);
			switch (_input.LA(1)) {
			case 8:
				enterOuterAlt(_localctx, 1);
				{
				setState(45); match(8);
				setState(46); match(ID);
				setState(51);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==3) {
					{
					{
					setState(47); match(3);
					setState(48); match(ID);
					}
					}
					setState(53);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(54); match(2);
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(55); match(ID);
				setState(60);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==3) {
					{
					{
					setState(56); match(3);
					setState(57); match(ID);
					}
					}
					setState(62);
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
			if ( listener instanceof JBONListener ) ((JBONListener)listener).enterMap(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JBONListener ) ((JBONListener)listener).exitMap(this);
		}
	}

	public final MapContext map() throws RecognitionException {
		MapContext _localctx = new MapContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_map);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(65); match(12);
			setState(67);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 6) | (1L << 8) | (1L << 12) | (1L << TRUE) | (1L << FALSE) | (1L << STRING) | (1L << CHAR) | (1L << ID) | (1L << FLOAT) | (1L << INTEGER) | (1L << HEXADECIMAL) | (1L << BINARY))) != 0)) {
				{
				setState(66); entry();
				}
			}

			setState(73);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==4) {
				{
				{
				setState(69); match(4);
				setState(70); entry();
				}
				}
				setState(75);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(76); match(14);
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
			if ( listener instanceof JBONListener ) ((JBONListener)listener).enterEntry(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JBONListener ) ((JBONListener)listener).exitEntry(this);
		}
	}

	public final EntryContext entry() throws RecognitionException {
		EntryContext _localctx = new EntryContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_entry);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(78); key();
			setState(79); match(7);
			setState(80); value();
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
		public TerminalNode ID() { return getToken(JBONParser.ID, 0); }
		public KeyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_key; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JBONListener ) ((JBONListener)listener).enterKey(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JBONListener ) ((JBONListener)listener).exitKey(this);
		}
	}

	public final KeyContext key() throws RecognitionException {
		KeyContext _localctx = new KeyContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_key);
		try {
			setState(84);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(82); object();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(83); match(ID);
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
			if ( listener instanceof JBONListener ) ((JBONListener)listener).enterValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JBONListener ) ((JBONListener)listener).exitValue(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_value);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86); object();
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
			if ( listener instanceof JBONListener ) ((JBONListener)listener).enterList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JBONListener ) ((JBONListener)listener).exitList(this);
		}
	}

	public final ListContext list() throws RecognitionException {
		ListContext _localctx = new ListContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(88); match(6);
			setState(90);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 6) | (1L << 8) | (1L << 12) | (1L << TRUE) | (1L << FALSE) | (1L << STRING) | (1L << CHAR) | (1L << ID) | (1L << FLOAT) | (1L << INTEGER) | (1L << HEXADECIMAL) | (1L << BINARY))) != 0)) {
				{
				setState(89); object();
				}
			}

			setState(96);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==4) {
				{
				{
				setState(92); match(4);
				setState(93); object();
				}
				}
				setState(98);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(99); match(1);
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
			if ( listener instanceof JBONListener ) ((JBONListener)listener).enterPrimitive(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JBONListener ) ((JBONListener)listener).exitPrimitive(this);
		}
	}

	public final PrimitiveContext primitive() throws RecognitionException {
		PrimitiveContext _localctx = new PrimitiveContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_primitive);
		try {
			setState(108);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(101); p_int();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(102); p_long();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(103); p_float();
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(104); p_double();
				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(105); p_string();
				}
				break;

			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(106); p_char();
				}
				break;

			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(107); p_boolean();
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
		public TerminalNode HEXADECIMAL() { return getToken(JBONParser.HEXADECIMAL, 0); }
		public TerminalNode BINARY() { return getToken(JBONParser.BINARY, 0); }
		public TerminalNode INTEGER() { return getToken(JBONParser.INTEGER, 0); }
		public P_intContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_p_int; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JBONListener ) ((JBONListener)listener).enterP_int(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JBONListener ) ((JBONListener)listener).exitP_int(this);
		}
	}

	public final P_intContext p_int() throws RecognitionException {
		P_intContext _localctx = new P_intContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_p_int);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(110);
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
		public TerminalNode INTEGER() { return getToken(JBONParser.INTEGER, 0); }
		public P_longContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_p_long; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JBONListener ) ((JBONListener)listener).enterP_long(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JBONListener ) ((JBONListener)listener).exitP_long(this);
		}
	}

	public final P_longContext p_long() throws RecognitionException {
		P_longContext _localctx = new P_longContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_p_long);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(112); match(INTEGER);
			setState(113);
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
		public TerminalNode FLOAT() { return getToken(JBONParser.FLOAT, 0); }
		public P_floatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_p_float; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JBONListener ) ((JBONListener)listener).enterP_float(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JBONListener ) ((JBONListener)listener).exitP_float(this);
		}
	}

	public final P_floatContext p_float() throws RecognitionException {
		P_floatContext _localctx = new P_floatContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_p_float);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(115); match(FLOAT);
			setState(116);
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
		public TerminalNode FLOAT() { return getToken(JBONParser.FLOAT, 0); }
		public P_doubleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_p_double; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JBONListener ) ((JBONListener)listener).enterP_double(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JBONListener ) ((JBONListener)listener).exitP_double(this);
		}
	}

	public final P_doubleContext p_double() throws RecognitionException {
		P_doubleContext _localctx = new P_doubleContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_p_double);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(118); match(FLOAT);
			setState(120);
			_la = _input.LA(1);
			if (_la==5 || _la==9) {
				{
				setState(119);
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
		public TerminalNode CHAR() { return getToken(JBONParser.CHAR, 0); }
		public P_charContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_p_char; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JBONListener ) ((JBONListener)listener).enterP_char(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JBONListener ) ((JBONListener)listener).exitP_char(this);
		}
	}

	public final P_charContext p_char() throws RecognitionException {
		P_charContext _localctx = new P_charContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_p_char);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(122); match(CHAR);
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
		public TerminalNode STRING() { return getToken(JBONParser.STRING, 0); }
		public P_stringContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_p_string; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JBONListener ) ((JBONListener)listener).enterP_string(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JBONListener ) ((JBONListener)listener).exitP_string(this);
		}
	}

	public final P_stringContext p_string() throws RecognitionException {
		P_stringContext _localctx = new P_stringContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_p_string);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(124); match(STRING);
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
		public TerminalNode TRUE() { return getToken(JBONParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(JBONParser.FALSE, 0); }
		public P_booleanContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_p_boolean; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JBONListener ) ((JBONListener)listener).enterP_boolean(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JBONListener ) ((JBONListener)listener).exitP_boolean(this);
		}
	}

	public final P_booleanContext p_boolean() throws RecognitionException {
		P_booleanContext _localctx = new P_booleanContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_p_boolean);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(126);
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
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\3\34\u0083\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\3\2\3\2"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3.\n\3\3\4\3\4\3\4\3\4\7\4\64\n"+
		"\4\f\4\16\4\67\13\4\3\4\3\4\3\4\3\4\7\4=\n\4\f\4\16\4@\13\4\5\4B\n\4\3"+
		"\5\3\5\5\5F\n\5\3\5\3\5\7\5J\n\5\f\5\16\5M\13\5\3\5\3\5\3\6\3\6\3\6\3"+
		"\6\3\7\3\7\5\7W\n\7\3\b\3\b\3\t\3\t\5\t]\n\t\3\t\3\t\7\ta\n\t\f\t\16\t"+
		"d\13\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\no\n\n\3\13\3\13\3\f\3\f"+
		"\3\f\3\r\3\r\3\r\3\16\3\16\5\16{\n\16\3\17\3\17\3\20\3\20\3\21\3\21\3"+
		"\21\2\22\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \2\7\3\2\31\33\4\2\r\r"+
		"\21\21\4\2\f\f\17\17\4\2\7\7\13\13\3\2\23\24\u0085\2\"\3\2\2\2\4-\3\2"+
		"\2\2\6A\3\2\2\2\bC\3\2\2\2\nP\3\2\2\2\fV\3\2\2\2\16X\3\2\2\2\20Z\3\2\2"+
		"\2\22n\3\2\2\2\24p\3\2\2\2\26r\3\2\2\2\30u\3\2\2\2\32x\3\2\2\2\34|\3\2"+
		"\2\2\36~\3\2\2\2 \u0080\3\2\2\2\"#\5\4\3\2#\3\3\2\2\2$%\5\6\4\2%&\5\b"+
		"\5\2&.\3\2\2\2\'.\5\b\5\2()\5\6\4\2)*\5\20\t\2*.\3\2\2\2+.\5\20\t\2,."+
		"\5\22\n\2-$\3\2\2\2-\'\3\2\2\2-(\3\2\2\2-+\3\2\2\2-,\3\2\2\2.\5\3\2\2"+
		"\2/\60\7\n\2\2\60\65\7\27\2\2\61\62\7\5\2\2\62\64\7\27\2\2\63\61\3\2\2"+
		"\2\64\67\3\2\2\2\65\63\3\2\2\2\65\66\3\2\2\2\668\3\2\2\2\67\65\3\2\2\2"+
		"8B\7\4\2\29>\7\27\2\2:;\7\5\2\2;=\7\27\2\2<:\3\2\2\2=@\3\2\2\2><\3\2\2"+
		"\2>?\3\2\2\2?B\3\2\2\2@>\3\2\2\2A/\3\2\2\2A9\3\2\2\2B\7\3\2\2\2CE\7\16"+
		"\2\2DF\5\n\6\2ED\3\2\2\2EF\3\2\2\2FK\3\2\2\2GH\7\6\2\2HJ\5\n\6\2IG\3\2"+
		"\2\2JM\3\2\2\2KI\3\2\2\2KL\3\2\2\2LN\3\2\2\2MK\3\2\2\2NO\7\20\2\2O\t\3"+
		"\2\2\2PQ\5\f\7\2QR\7\t\2\2RS\5\16\b\2S\13\3\2\2\2TW\5\4\3\2UW\7\27\2\2"+
		"VT\3\2\2\2VU\3\2\2\2W\r\3\2\2\2XY\5\4\3\2Y\17\3\2\2\2Z\\\7\b\2\2[]\5\4"+
		"\3\2\\[\3\2\2\2\\]\3\2\2\2]b\3\2\2\2^_\7\6\2\2_a\5\4\3\2`^\3\2\2\2ad\3"+
		"\2\2\2b`\3\2\2\2bc\3\2\2\2ce\3\2\2\2db\3\2\2\2ef\7\3\2\2f\21\3\2\2\2g"+
		"o\5\24\13\2ho\5\26\f\2io\5\30\r\2jo\5\32\16\2ko\5\36\20\2lo\5\34\17\2"+
		"mo\5 \21\2ng\3\2\2\2nh\3\2\2\2ni\3\2\2\2nj\3\2\2\2nk\3\2\2\2nl\3\2\2\2"+
		"nm\3\2\2\2o\23\3\2\2\2pq\t\2\2\2q\25\3\2\2\2rs\7\31\2\2st\t\3\2\2t\27"+
		"\3\2\2\2uv\7\30\2\2vw\t\4\2\2w\31\3\2\2\2xz\7\30\2\2y{\t\5\2\2zy\3\2\2"+
		"\2z{\3\2\2\2{\33\3\2\2\2|}\7\26\2\2}\35\3\2\2\2~\177\7\25\2\2\177\37\3"+
		"\2\2\2\u0080\u0081\t\6\2\2\u0081!\3\2\2\2\r-\65>AEKV\\bnz";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}