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
		RULE_key = 5, RULE_value = 6, RULE_list = 7, RULE_primitive = 8, RULE_pNull = 9, 
		RULE_pInt = 10, RULE_pLong = 11, RULE_pFloat = 12, RULE_pDouble = 13, 
		RULE_pChar = 14, RULE_pString = 15, RULE_pBoolean = 16;
	public static final String[] ruleNames = {
		"file", "object", "type", "map", "entry", "key", "value", "list", "primitive", 
		"pNull", "pInt", "pLong", "pFloat", "pDouble", "pChar", "pString", "pBoolean"
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
			setState(34); object();
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
			setState(45);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(36); type();
				setState(37); map();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(39); map();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(40); type();
				setState(41); list();
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(43); list();
				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(44); primitive();
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
			setState(65);
			switch (_input.LA(1)) {
			case 8:
				enterOuterAlt(_localctx, 1);
				{
				setState(47); match(8);
				setState(48); match(ID);
				setState(53);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==3) {
					{
					{
					setState(49); match(3);
					setState(50); match(ID);
					}
					}
					setState(55);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(56); match(2);
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(57); match(ID);
				setState(62);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==3) {
					{
					{
					setState(58); match(3);
					setState(59); match(ID);
					}
					}
					setState(64);
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
			setState(67); match(12);
			setState(69);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 6) | (1L << 8) | (1L << 12) | (1L << NULL) | (1L << TRUE) | (1L << FALSE) | (1L << STRING) | (1L << CHAR) | (1L << ID) | (1L << FLOAT) | (1L << INTEGER) | (1L << HEXADECIMAL) | (1L << BINARY))) != 0)) {
				{
				setState(68); entry();
				}
			}

			setState(75);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==4) {
				{
				{
				setState(71); match(4);
				setState(72); entry();
				}
				}
				setState(77);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(78); match(14);
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
			setState(80); key();
			setState(81); match(7);
			setState(82); value();
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
			setState(86);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(84); object();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(85); match(ID);
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
			setState(88); object();
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
			setState(90); match(6);
			setState(92);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 6) | (1L << 8) | (1L << 12) | (1L << NULL) | (1L << TRUE) | (1L << FALSE) | (1L << STRING) | (1L << CHAR) | (1L << ID) | (1L << FLOAT) | (1L << INTEGER) | (1L << HEXADECIMAL) | (1L << BINARY))) != 0)) {
				{
				setState(91); object();
				}
			}

			setState(98);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==4) {
				{
				{
				setState(94); match(4);
				setState(95); object();
				}
				}
				setState(100);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(101); match(1);
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
		public PStringContext pString() {
			return getRuleContext(PStringContext.class,0);
		}
		public PBooleanContext pBoolean() {
			return getRuleContext(PBooleanContext.class,0);
		}
		public PIntContext pInt() {
			return getRuleContext(PIntContext.class,0);
		}
		public PNullContext pNull() {
			return getRuleContext(PNullContext.class,0);
		}
		public PDoubleContext pDouble() {
			return getRuleContext(PDoubleContext.class,0);
		}
		public PCharContext pChar() {
			return getRuleContext(PCharContext.class,0);
		}
		public PLongContext pLong() {
			return getRuleContext(PLongContext.class,0);
		}
		public PFloatContext pFloat() {
			return getRuleContext(PFloatContext.class,0);
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
			setState(111);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(103); pInt();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(104); pLong();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(105); pFloat();
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(106); pDouble();
				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(107); pString();
				}
				break;

			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(108); pChar();
				}
				break;

			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(109); pBoolean();
				}
				break;

			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(110); pNull();
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

	public static class PNullContext extends ParserRuleContext {
		public TerminalNode NULL() { return getToken(JBONParser.NULL, 0); }
		public PNullContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pNull; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JBONListener ) ((JBONListener)listener).enterPNull(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JBONListener ) ((JBONListener)listener).exitPNull(this);
		}
	}

	public final PNullContext pNull() throws RecognitionException {
		PNullContext _localctx = new PNullContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_pNull);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(113); match(NULL);
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

	public static class PIntContext extends ParserRuleContext {
		public TerminalNode HEXADECIMAL() { return getToken(JBONParser.HEXADECIMAL, 0); }
		public TerminalNode BINARY() { return getToken(JBONParser.BINARY, 0); }
		public TerminalNode INTEGER() { return getToken(JBONParser.INTEGER, 0); }
		public PIntContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pInt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JBONListener ) ((JBONListener)listener).enterPInt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JBONListener ) ((JBONListener)listener).exitPInt(this);
		}
	}

	public final PIntContext pInt() throws RecognitionException {
		PIntContext _localctx = new PIntContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_pInt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(115);
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

	public static class PLongContext extends ParserRuleContext {
		public TerminalNode INTEGER() { return getToken(JBONParser.INTEGER, 0); }
		public PLongContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pLong; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JBONListener ) ((JBONListener)listener).enterPLong(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JBONListener ) ((JBONListener)listener).exitPLong(this);
		}
	}

	public final PLongContext pLong() throws RecognitionException {
		PLongContext _localctx = new PLongContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_pLong);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(117); match(INTEGER);
			setState(118);
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

	public static class PFloatContext extends ParserRuleContext {
		public TerminalNode FLOAT() { return getToken(JBONParser.FLOAT, 0); }
		public PFloatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pFloat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JBONListener ) ((JBONListener)listener).enterPFloat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JBONListener ) ((JBONListener)listener).exitPFloat(this);
		}
	}

	public final PFloatContext pFloat() throws RecognitionException {
		PFloatContext _localctx = new PFloatContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_pFloat);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(120); match(FLOAT);
			setState(121);
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

	public static class PDoubleContext extends ParserRuleContext {
		public TerminalNode FLOAT() { return getToken(JBONParser.FLOAT, 0); }
		public PDoubleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pDouble; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JBONListener ) ((JBONListener)listener).enterPDouble(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JBONListener ) ((JBONListener)listener).exitPDouble(this);
		}
	}

	public final PDoubleContext pDouble() throws RecognitionException {
		PDoubleContext _localctx = new PDoubleContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_pDouble);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(123); match(FLOAT);
			setState(125);
			_la = _input.LA(1);
			if (_la==5 || _la==9) {
				{
				setState(124);
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

	public static class PCharContext extends ParserRuleContext {
		public TerminalNode CHAR() { return getToken(JBONParser.CHAR, 0); }
		public PCharContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pChar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JBONListener ) ((JBONListener)listener).enterPChar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JBONListener ) ((JBONListener)listener).exitPChar(this);
		}
	}

	public final PCharContext pChar() throws RecognitionException {
		PCharContext _localctx = new PCharContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_pChar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(127); match(CHAR);
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

	public static class PStringContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(JBONParser.STRING, 0); }
		public PStringContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pString; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JBONListener ) ((JBONListener)listener).enterPString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JBONListener ) ((JBONListener)listener).exitPString(this);
		}
	}

	public final PStringContext pString() throws RecognitionException {
		PStringContext _localctx = new PStringContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_pString);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(129); match(STRING);
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

	public static class PBooleanContext extends ParserRuleContext {
		public TerminalNode TRUE() { return getToken(JBONParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(JBONParser.FALSE, 0); }
		public PBooleanContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pBoolean; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JBONListener ) ((JBONListener)listener).enterPBoolean(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JBONListener ) ((JBONListener)listener).exitPBoolean(this);
		}
	}

	public final PBooleanContext pBoolean() throws RecognitionException {
		PBooleanContext _localctx = new PBooleanContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_pBoolean);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(131);
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
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\3\34\u0088\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3\60\n\3\3\4\3\4\3\4\3"+
		"\4\7\4\66\n\4\f\4\16\49\13\4\3\4\3\4\3\4\3\4\7\4?\n\4\f\4\16\4B\13\4\5"+
		"\4D\n\4\3\5\3\5\5\5H\n\5\3\5\3\5\7\5L\n\5\f\5\16\5O\13\5\3\5\3\5\3\6\3"+
		"\6\3\6\3\6\3\7\3\7\5\7Y\n\7\3\b\3\b\3\t\3\t\5\t_\n\t\3\t\3\t\7\tc\n\t"+
		"\f\t\16\tf\13\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\nr\n\n\3\13"+
		"\3\13\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\16\3\17\3\17\5\17\u0080\n\17\3\20"+
		"\3\20\3\21\3\21\3\22\3\22\3\22\2\23\2\4\6\b\n\f\16\20\22\24\26\30\32\34"+
		"\36 \"\2\7\3\2\31\33\4\2\r\r\21\21\4\2\f\f\17\17\4\2\7\7\13\13\3\2\23"+
		"\24\u008a\2$\3\2\2\2\4/\3\2\2\2\6C\3\2\2\2\bE\3\2\2\2\nR\3\2\2\2\fX\3"+
		"\2\2\2\16Z\3\2\2\2\20\\\3\2\2\2\22q\3\2\2\2\24s\3\2\2\2\26u\3\2\2\2\30"+
		"w\3\2\2\2\32z\3\2\2\2\34}\3\2\2\2\36\u0081\3\2\2\2 \u0083\3\2\2\2\"\u0085"+
		"\3\2\2\2$%\5\4\3\2%\3\3\2\2\2&\'\5\6\4\2\'(\5\b\5\2(\60\3\2\2\2)\60\5"+
		"\b\5\2*+\5\6\4\2+,\5\20\t\2,\60\3\2\2\2-\60\5\20\t\2.\60\5\22\n\2/&\3"+
		"\2\2\2/)\3\2\2\2/*\3\2\2\2/-\3\2\2\2/.\3\2\2\2\60\5\3\2\2\2\61\62\7\n"+
		"\2\2\62\67\7\27\2\2\63\64\7\5\2\2\64\66\7\27\2\2\65\63\3\2\2\2\669\3\2"+
		"\2\2\67\65\3\2\2\2\678\3\2\2\28:\3\2\2\29\67\3\2\2\2:D\7\4\2\2;@\7\27"+
		"\2\2<=\7\5\2\2=?\7\27\2\2><\3\2\2\2?B\3\2\2\2@>\3\2\2\2@A\3\2\2\2AD\3"+
		"\2\2\2B@\3\2\2\2C\61\3\2\2\2C;\3\2\2\2D\7\3\2\2\2EG\7\16\2\2FH\5\n\6\2"+
		"GF\3\2\2\2GH\3\2\2\2HM\3\2\2\2IJ\7\6\2\2JL\5\n\6\2KI\3\2\2\2LO\3\2\2\2"+
		"MK\3\2\2\2MN\3\2\2\2NP\3\2\2\2OM\3\2\2\2PQ\7\20\2\2Q\t\3\2\2\2RS\5\f\7"+
		"\2ST\7\t\2\2TU\5\16\b\2U\13\3\2\2\2VY\5\4\3\2WY\7\27\2\2XV\3\2\2\2XW\3"+
		"\2\2\2Y\r\3\2\2\2Z[\5\4\3\2[\17\3\2\2\2\\^\7\b\2\2]_\5\4\3\2^]\3\2\2\2"+
		"^_\3\2\2\2_d\3\2\2\2`a\7\6\2\2ac\5\4\3\2b`\3\2\2\2cf\3\2\2\2db\3\2\2\2"+
		"de\3\2\2\2eg\3\2\2\2fd\3\2\2\2gh\7\3\2\2h\21\3\2\2\2ir\5\26\f\2jr\5\30"+
		"\r\2kr\5\32\16\2lr\5\34\17\2mr\5 \21\2nr\5\36\20\2or\5\"\22\2pr\5\24\13"+
		"\2qi\3\2\2\2qj\3\2\2\2qk\3\2\2\2ql\3\2\2\2qm\3\2\2\2qn\3\2\2\2qo\3\2\2"+
		"\2qp\3\2\2\2r\23\3\2\2\2st\7\22\2\2t\25\3\2\2\2uv\t\2\2\2v\27\3\2\2\2"+
		"wx\7\31\2\2xy\t\3\2\2y\31\3\2\2\2z{\7\30\2\2{|\t\4\2\2|\33\3\2\2\2}\177"+
		"\7\30\2\2~\u0080\t\5\2\2\177~\3\2\2\2\177\u0080\3\2\2\2\u0080\35\3\2\2"+
		"\2\u0081\u0082\7\26\2\2\u0082\37\3\2\2\2\u0083\u0084\7\25\2\2\u0084!\3"+
		"\2\2\2\u0085\u0086\t\6\2\2\u0086#\3\2\2\2\r/\67@CGMX^dq\177";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}