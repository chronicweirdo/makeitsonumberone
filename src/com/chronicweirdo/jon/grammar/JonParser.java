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
		STRING=10, ID=11, NUMBER=12, WS=13;
	public static final String[] tokenNames = {
		"<INVALID>", "']'", "'{'", "')'", "'.'", "','", "'['", "'('", "':'", "'}'", 
		"STRING", "ID", "NUMBER", "WS"
	};
	public static final int
		RULE_object = 0, RULE_type = 1, RULE_typeString = 2, RULE_map = 3, RULE_mapEntry = 4, 
		RULE_mapEntryKey = 5, RULE_mapEntryValue = 6, RULE_list = 7, RULE_listEntry = 8, 
		RULE_value = 9;
	public static final String[] ruleNames = {
		"object", "type", "typeString", "map", "mapEntry", "mapEntryKey", "mapEntryValue", 
		"list", "listEntry", "value"
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
			setState(29);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(20); type();
				setState(21); map();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(23); map();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(24); type();
				setState(25); list();
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(27); list();
				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(28); value();
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
		public TypeStringContext typeString() {
			return getRuleContext(TypeStringContext.class,0);
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
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(31); match(7);
			setState(32); typeString();
			setState(33); match(3);
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

	public static class TypeStringContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(JonParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(JonParser.ID, i);
		}
		public TypeStringContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeString; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JonListener ) ((JonListener)listener).enterTypeString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JonListener ) ((JonListener)listener).exitTypeString(this);
		}
	}

	public final TypeStringContext typeString() throws RecognitionException {
		TypeStringContext _localctx = new TypeStringContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_typeString);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(35); match(ID);
			setState(40);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==4) {
				{
				{
				setState(36); match(4);
				setState(37); match(ID);
				}
				}
				setState(42);
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

	public static class MapContext extends ParserRuleContext {
		public MapEntryContext mapEntry(int i) {
			return getRuleContext(MapEntryContext.class,i);
		}
		public List<MapEntryContext> mapEntry() {
			return getRuleContexts(MapEntryContext.class);
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
		enterRule(_localctx, 6, RULE_map);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(43); match(2);
			setState(45);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 2) | (1L << 6) | (1L << 7) | (1L << STRING) | (1L << NUMBER))) != 0)) {
				{
				setState(44); mapEntry();
				}
			}

			setState(51);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==5) {
				{
				{
				setState(47); match(5);
				setState(48); mapEntry();
				}
				}
				setState(53);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(54); match(9);
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

	public static class MapEntryContext extends ParserRuleContext {
		public MapEntryValueContext mapEntryValue() {
			return getRuleContext(MapEntryValueContext.class,0);
		}
		public MapEntryKeyContext mapEntryKey() {
			return getRuleContext(MapEntryKeyContext.class,0);
		}
		public MapEntryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mapEntry; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JonListener ) ((JonListener)listener).enterMapEntry(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JonListener ) ((JonListener)listener).exitMapEntry(this);
		}
	}

	public final MapEntryContext mapEntry() throws RecognitionException {
		MapEntryContext _localctx = new MapEntryContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_mapEntry);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(56); mapEntryKey();
			setState(57); match(8);
			setState(58); mapEntryValue();
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

	public static class MapEntryKeyContext extends ParserRuleContext {
		public ObjectContext object() {
			return getRuleContext(ObjectContext.class,0);
		}
		public MapEntryKeyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mapEntryKey; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JonListener ) ((JonListener)listener).enterMapEntryKey(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JonListener ) ((JonListener)listener).exitMapEntryKey(this);
		}
	}

	public final MapEntryKeyContext mapEntryKey() throws RecognitionException {
		MapEntryKeyContext _localctx = new MapEntryKeyContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_mapEntryKey);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(60); object();
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

	public static class MapEntryValueContext extends ParserRuleContext {
		public ObjectContext object() {
			return getRuleContext(ObjectContext.class,0);
		}
		public MapEntryValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mapEntryValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JonListener ) ((JonListener)listener).enterMapEntryValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JonListener ) ((JonListener)listener).exitMapEntryValue(this);
		}
	}

	public final MapEntryValueContext mapEntryValue() throws RecognitionException {
		MapEntryValueContext _localctx = new MapEntryValueContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_mapEntryValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62); object();
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
		public List<ListEntryContext> listEntry() {
			return getRuleContexts(ListEntryContext.class);
		}
		public ListEntryContext listEntry(int i) {
			return getRuleContext(ListEntryContext.class,i);
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
		enterRule(_localctx, 14, RULE_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(64); match(6);
			setState(66);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 2) | (1L << 6) | (1L << 7) | (1L << STRING) | (1L << NUMBER))) != 0)) {
				{
				setState(65); listEntry();
				}
			}

			setState(72);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==5) {
				{
				{
				setState(68); match(5);
				setState(69); listEntry();
				}
				}
				setState(74);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(75); match(1);
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

	public static class ListEntryContext extends ParserRuleContext {
		public ObjectContext object() {
			return getRuleContext(ObjectContext.class,0);
		}
		public ListEntryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listEntry; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JonListener ) ((JonListener)listener).enterListEntry(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JonListener ) ((JonListener)listener).exitListEntry(this);
		}
	}

	public final ListEntryContext listEntry() throws RecognitionException {
		ListEntryContext _localctx = new ListEntryContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_listEntry);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(77); object();
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
		enterRule(_localctx, 18, RULE_value);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(79);
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

	public static final String _serializedATN =
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\3\17T\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\5\2 \n\2\3\3\3\3\3\3\3\3\3\4\3\4\3"+
		"\4\7\4)\n\4\f\4\16\4,\13\4\3\5\3\5\5\5\60\n\5\3\5\3\5\7\5\64\n\5\f\5\16"+
		"\5\67\13\5\3\5\3\5\3\6\3\6\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\5\tE\n\t\3"+
		"\t\3\t\7\tI\n\t\f\t\16\tL\13\t\3\t\3\t\3\n\3\n\3\13\3\13\3\13\2\f\2\4"+
		"\6\b\n\f\16\20\22\24\2\3\4\2\f\f\16\16R\2\37\3\2\2\2\4!\3\2\2\2\6%\3\2"+
		"\2\2\b-\3\2\2\2\n:\3\2\2\2\f>\3\2\2\2\16@\3\2\2\2\20B\3\2\2\2\22O\3\2"+
		"\2\2\24Q\3\2\2\2\26\27\5\4\3\2\27\30\5\b\5\2\30 \3\2\2\2\31 \5\b\5\2\32"+
		"\33\5\4\3\2\33\34\5\20\t\2\34 \3\2\2\2\35 \5\20\t\2\36 \5\24\13\2\37\26"+
		"\3\2\2\2\37\31\3\2\2\2\37\32\3\2\2\2\37\35\3\2\2\2\37\36\3\2\2\2 \3\3"+
		"\2\2\2!\"\7\t\2\2\"#\5\6\4\2#$\7\5\2\2$\5\3\2\2\2%*\7\r\2\2&\'\7\6\2\2"+
		"\')\7\r\2\2(&\3\2\2\2),\3\2\2\2*(\3\2\2\2*+\3\2\2\2+\7\3\2\2\2,*\3\2\2"+
		"\2-/\7\4\2\2.\60\5\n\6\2/.\3\2\2\2/\60\3\2\2\2\60\65\3\2\2\2\61\62\7\7"+
		"\2\2\62\64\5\n\6\2\63\61\3\2\2\2\64\67\3\2\2\2\65\63\3\2\2\2\65\66\3\2"+
		"\2\2\668\3\2\2\2\67\65\3\2\2\289\7\13\2\29\t\3\2\2\2:;\5\f\7\2;<\7\n\2"+
		"\2<=\5\16\b\2=\13\3\2\2\2>?\5\2\2\2?\r\3\2\2\2@A\5\2\2\2A\17\3\2\2\2B"+
		"D\7\b\2\2CE\5\22\n\2DC\3\2\2\2DE\3\2\2\2EJ\3\2\2\2FG\7\7\2\2GI\5\22\n"+
		"\2HF\3\2\2\2IL\3\2\2\2JH\3\2\2\2JK\3\2\2\2KM\3\2\2\2LJ\3\2\2\2MN\7\3\2"+
		"\2N\21\3\2\2\2OP\5\2\2\2P\23\3\2\2\2QR\t\2\2\2R\25\3\2\2\2\b\37*/\65D"+
		"J";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}