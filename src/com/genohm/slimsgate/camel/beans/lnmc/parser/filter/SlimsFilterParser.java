// Generated from src/com/genohm/slimsgate/camel/beans/lnmc/parser/filter/SlimsFilter.g4 by ANTLR 4.1

package com.genohm.slimsgate.camel.beans.lnmc.parser.filter;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SlimsFilterParser extends Parser {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__11=1, T__10=2, T__9=3, T__8=4, T__7=5, T__6=6, T__5=7, T__4=8, T__3=9, 
		T__2=10, T__1=11, T__0=12, STRING=13, ID=14, INT=15, WS=16;
	public static final String[] tokenNames = {
		"<INVALID>", "' '", "' limit '", "'format '", "'.'", "' filter '", "','", 
		"' order '", "' from step'", "'='", "'desc'", "';'", "'asc'", "STRING", 
		"ID", "INT", "WS"
	};
	public static final int
		RULE_query = 0, RULE_fetchQuery = 1, RULE_datatypeSelection = 2, RULE_datatypeName = 3, 
		RULE_from = 4, RULE_filter = 5, RULE_filterTerm = 6, RULE_attribute = 7, 
		RULE_attributeValue = 8, RULE_source = 9, RULE_order = 10, RULE_orderTerm = 11, 
		RULE_direction = 12, RULE_limit = 13, RULE_formatQuery = 14, RULE_formatQueryTerm = 15, 
		RULE_formatName = 16, RULE_formatExpression = 17, RULE_formatAttribute = 18, 
		RULE_formatLink = 19;
	public static final String[] ruleNames = {
		"query", "fetchQuery", "datatypeSelection", "datatypeName", "from", "filter", 
		"filterTerm", "attribute", "attributeValue", "source", "order", "orderTerm", 
		"direction", "limit", "formatQuery", "formatQueryTerm", "formatName", 
		"formatExpression", "formatAttribute", "formatLink"
	};

	@Override
	public String getGrammarFileName() { return "SlimsFilter.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public SlimsFilterParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class QueryContext extends ParserRuleContext {
		public FormatQueryContext formatQuery() {
			return getRuleContext(FormatQueryContext.class,0);
		}
		public FetchQueryContext fetchQuery() {
			return getRuleContext(FetchQueryContext.class,0);
		}
		public QueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_query; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SlimsFilterListener ) ((SlimsFilterListener)listener).enterQuery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SlimsFilterListener ) ((SlimsFilterListener)listener).exitQuery(this);
		}
	}

	public final QueryContext query() throws RecognitionException {
		QueryContext _localctx = new QueryContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_query);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(40); fetchQuery();
			setState(41); match(4);
			setState(43);
			_la = _input.LA(1);
			if (_la==3) {
				{
				setState(42); formatQuery();
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

	public static class FetchQueryContext extends ParserRuleContext {
		public DatatypeSelectionContext datatypeSelection(int i) {
			return getRuleContext(DatatypeSelectionContext.class,i);
		}
		public List<DatatypeSelectionContext> datatypeSelection() {
			return getRuleContexts(DatatypeSelectionContext.class);
		}
		public FetchQueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fetchQuery; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SlimsFilterListener ) ((SlimsFilterListener)listener).enterFetchQuery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SlimsFilterListener ) ((SlimsFilterListener)listener).exitFetchQuery(this);
		}
	}

	public final FetchQueryContext fetchQuery() throws RecognitionException {
		FetchQueryContext _localctx = new FetchQueryContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_fetchQuery);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(45); datatypeSelection();
			setState(50);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==11) {
				{
				{
				setState(46); match(11);
				setState(47); datatypeSelection();
				}
				}
				setState(52);
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

	public static class DatatypeSelectionContext extends ParserRuleContext {
		public FromContext from() {
			return getRuleContext(FromContext.class,0);
		}
		public FilterContext filter() {
			return getRuleContext(FilterContext.class,0);
		}
		public OrderContext order() {
			return getRuleContext(OrderContext.class,0);
		}
		public LimitContext limit() {
			return getRuleContext(LimitContext.class,0);
		}
		public DatatypeNameContext datatypeName() {
			return getRuleContext(DatatypeNameContext.class,0);
		}
		public DatatypeSelectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_datatypeSelection; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SlimsFilterListener ) ((SlimsFilterListener)listener).enterDatatypeSelection(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SlimsFilterListener ) ((SlimsFilterListener)listener).exitDatatypeSelection(this);
		}
	}

	public final DatatypeSelectionContext datatypeSelection() throws RecognitionException {
		DatatypeSelectionContext _localctx = new DatatypeSelectionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_datatypeSelection);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(53); datatypeName();
			setState(55);
			_la = _input.LA(1);
			if (_la==8) {
				{
				setState(54); from();
				}
			}

			setState(58);
			_la = _input.LA(1);
			if (_la==5) {
				{
				setState(57); filter();
				}
			}

			setState(61);
			_la = _input.LA(1);
			if (_la==7) {
				{
				setState(60); order();
				}
			}

			setState(64);
			_la = _input.LA(1);
			if (_la==2) {
				{
				setState(63); limit();
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

	public static class DatatypeNameContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(SlimsFilterParser.ID, 0); }
		public DatatypeNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_datatypeName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SlimsFilterListener ) ((SlimsFilterListener)listener).enterDatatypeName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SlimsFilterListener ) ((SlimsFilterListener)listener).exitDatatypeName(this);
		}
	}

	public final DatatypeNameContext datatypeName() throws RecognitionException {
		DatatypeNameContext _localctx = new DatatypeNameContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_datatypeName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(66); match(ID);
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

	public static class FromContext extends ParserRuleContext {
		public FromContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_from; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SlimsFilterListener ) ((SlimsFilterListener)listener).enterFrom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SlimsFilterListener ) ((SlimsFilterListener)listener).exitFrom(this);
		}
	}

	public final FromContext from() throws RecognitionException {
		FromContext _localctx = new FromContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_from);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(68); match(8);
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

	public static class FilterContext extends ParserRuleContext {
		public List<FilterTermContext> filterTerm() {
			return getRuleContexts(FilterTermContext.class);
		}
		public FilterTermContext filterTerm(int i) {
			return getRuleContext(FilterTermContext.class,i);
		}
		public FilterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_filter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SlimsFilterListener ) ((SlimsFilterListener)listener).enterFilter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SlimsFilterListener ) ((SlimsFilterListener)listener).exitFilter(this);
		}
	}

	public final FilterContext filter() throws RecognitionException {
		FilterContext _localctx = new FilterContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_filter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(70); match(5);
			setState(71); filterTerm();
			setState(76);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==6) {
				{
				{
				setState(72); match(6);
				setState(73); filterTerm();
				}
				}
				setState(78);
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

	public static class FilterTermContext extends ParserRuleContext {
		public AttributeValueContext attributeValue() {
			return getRuleContext(AttributeValueContext.class,0);
		}
		public AttributeContext attribute() {
			return getRuleContext(AttributeContext.class,0);
		}
		public FilterTermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_filterTerm; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SlimsFilterListener ) ((SlimsFilterListener)listener).enterFilterTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SlimsFilterListener ) ((SlimsFilterListener)listener).exitFilterTerm(this);
		}
	}

	public final FilterTermContext filterTerm() throws RecognitionException {
		FilterTermContext _localctx = new FilterTermContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_filterTerm);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(79); attribute();
			setState(80); match(9);
			setState(81); attributeValue();
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

	public static class AttributeContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(SlimsFilterParser.ID, 0); }
		public AttributeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attribute; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SlimsFilterListener ) ((SlimsFilterListener)listener).enterAttribute(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SlimsFilterListener ) ((SlimsFilterListener)listener).exitAttribute(this);
		}
	}

	public final AttributeContext attribute() throws RecognitionException {
		AttributeContext _localctx = new AttributeContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_attribute);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(83); match(ID);
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

	public static class AttributeValueContext extends ParserRuleContext {
		public AttributeContext attribute() {
			return getRuleContext(AttributeContext.class,0);
		}
		public TerminalNode STRING() { return getToken(SlimsFilterParser.STRING, 0); }
		public SourceContext source() {
			return getRuleContext(SourceContext.class,0);
		}
		public AttributeValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attributeValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SlimsFilterListener ) ((SlimsFilterListener)listener).enterAttributeValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SlimsFilterListener ) ((SlimsFilterListener)listener).exitAttributeValue(this);
		}
	}

	public final AttributeValueContext attributeValue() throws RecognitionException {
		AttributeValueContext _localctx = new AttributeValueContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_attributeValue);
		try {
			setState(90);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(85); source();
				setState(86); match(4);
				setState(87); attribute();
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 2);
				{
				setState(89); match(STRING);
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

	public static class SourceContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(SlimsFilterParser.ID, 0); }
		public SourceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_source; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SlimsFilterListener ) ((SlimsFilterListener)listener).enterSource(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SlimsFilterListener ) ((SlimsFilterListener)listener).exitSource(this);
		}
	}

	public final SourceContext source() throws RecognitionException {
		SourceContext _localctx = new SourceContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_source);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92); match(ID);
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

	public static class OrderContext extends ParserRuleContext {
		public OrderTermContext orderTerm(int i) {
			return getRuleContext(OrderTermContext.class,i);
		}
		public List<OrderTermContext> orderTerm() {
			return getRuleContexts(OrderTermContext.class);
		}
		public OrderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_order; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SlimsFilterListener ) ((SlimsFilterListener)listener).enterOrder(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SlimsFilterListener ) ((SlimsFilterListener)listener).exitOrder(this);
		}
	}

	public final OrderContext order() throws RecognitionException {
		OrderContext _localctx = new OrderContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_order);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(94); match(7);
			setState(95); orderTerm();
			setState(100);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==6) {
				{
				{
				setState(96); match(6);
				setState(97); orderTerm();
				}
				}
				setState(102);
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

	public static class OrderTermContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(SlimsFilterParser.ID, 0); }
		public DirectionContext direction() {
			return getRuleContext(DirectionContext.class,0);
		}
		public OrderTermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_orderTerm; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SlimsFilterListener ) ((SlimsFilterListener)listener).enterOrderTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SlimsFilterListener ) ((SlimsFilterListener)listener).exitOrderTerm(this);
		}
	}

	public final OrderTermContext orderTerm() throws RecognitionException {
		OrderTermContext _localctx = new OrderTermContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_orderTerm);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(103); match(ID);
			setState(104); match(1);
			setState(105); direction();
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

	public static class DirectionContext extends ParserRuleContext {
		public DirectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_direction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SlimsFilterListener ) ((SlimsFilterListener)listener).enterDirection(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SlimsFilterListener ) ((SlimsFilterListener)listener).exitDirection(this);
		}
	}

	public final DirectionContext direction() throws RecognitionException {
		DirectionContext _localctx = new DirectionContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_direction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(107);
			_la = _input.LA(1);
			if ( !(_la==10 || _la==12) ) {
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

	public static class LimitContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(SlimsFilterParser.INT, 0); }
		public LimitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_limit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SlimsFilterListener ) ((SlimsFilterListener)listener).enterLimit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SlimsFilterListener ) ((SlimsFilterListener)listener).exitLimit(this);
		}
	}

	public final LimitContext limit() throws RecognitionException {
		LimitContext _localctx = new LimitContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_limit);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(109); match(2);
			setState(110); match(INT);
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

	public static class FormatQueryContext extends ParserRuleContext {
		public List<FormatQueryTermContext> formatQueryTerm() {
			return getRuleContexts(FormatQueryTermContext.class);
		}
		public FormatQueryTermContext formatQueryTerm(int i) {
			return getRuleContext(FormatQueryTermContext.class,i);
		}
		public FormatQueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formatQuery; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SlimsFilterListener ) ((SlimsFilterListener)listener).enterFormatQuery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SlimsFilterListener ) ((SlimsFilterListener)listener).exitFormatQuery(this);
		}
	}

	public final FormatQueryContext formatQuery() throws RecognitionException {
		FormatQueryContext _localctx = new FormatQueryContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_formatQuery);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(112); match(3);
			setState(113); formatQueryTerm();
			setState(118);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==6) {
				{
				{
				setState(114); match(6);
				setState(115); formatQueryTerm();
				}
				}
				setState(120);
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

	public static class FormatQueryTermContext extends ParserRuleContext {
		public FormatNameContext formatName() {
			return getRuleContext(FormatNameContext.class,0);
		}
		public FormatExpressionContext formatExpression() {
			return getRuleContext(FormatExpressionContext.class,0);
		}
		public FormatQueryTermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formatQueryTerm; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SlimsFilterListener ) ((SlimsFilterListener)listener).enterFormatQueryTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SlimsFilterListener ) ((SlimsFilterListener)listener).exitFormatQueryTerm(this);
		}
	}

	public final FormatQueryTermContext formatQueryTerm() throws RecognitionException {
		FormatQueryTermContext _localctx = new FormatQueryTermContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_formatQueryTerm);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(121); formatExpression();
			setState(122); match(9);
			setState(123); formatName();
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

	public static class FormatNameContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(SlimsFilterParser.STRING, 0); }
		public FormatNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formatName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SlimsFilterListener ) ((SlimsFilterListener)listener).enterFormatName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SlimsFilterListener ) ((SlimsFilterListener)listener).exitFormatName(this);
		}
	}

	public final FormatNameContext formatName() throws RecognitionException {
		FormatNameContext _localctx = new FormatNameContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_formatName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(125); match(STRING);
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

	public static class FormatExpressionContext extends ParserRuleContext {
		public FormatAttributeContext formatAttribute(int i) {
			return getRuleContext(FormatAttributeContext.class,i);
		}
		public List<FormatAttributeContext> formatAttribute() {
			return getRuleContexts(FormatAttributeContext.class);
		}
		public List<FormatLinkContext> formatLink() {
			return getRuleContexts(FormatLinkContext.class);
		}
		public FormatLinkContext formatLink(int i) {
			return getRuleContext(FormatLinkContext.class,i);
		}
		public FormatExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formatExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SlimsFilterListener ) ((SlimsFilterListener)listener).enterFormatExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SlimsFilterListener ) ((SlimsFilterListener)listener).exitFormatExpression(this);
		}
	}

	public final FormatExpressionContext formatExpression() throws RecognitionException {
		FormatExpressionContext _localctx = new FormatExpressionContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_formatExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(127); formatAttribute();
			setState(135);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==1) {
				{
				{
				setState(128); match(1);
				setState(129); formatLink();
				setState(130); match(1);
				setState(131); formatAttribute();
				}
				}
				setState(137);
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

	public static class FormatAttributeContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(SlimsFilterParser.ID, 0); }
		public FormatAttributeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formatAttribute; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SlimsFilterListener ) ((SlimsFilterListener)listener).enterFormatAttribute(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SlimsFilterListener ) ((SlimsFilterListener)listener).exitFormatAttribute(this);
		}
	}

	public final FormatAttributeContext formatAttribute() throws RecognitionException {
		FormatAttributeContext _localctx = new FormatAttributeContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_formatAttribute);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(138); match(ID);
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

	public static class FormatLinkContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(SlimsFilterParser.STRING, 0); }
		public FormatLinkContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formatLink; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SlimsFilterListener ) ((SlimsFilterListener)listener).enterFormatLink(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SlimsFilterListener ) ((SlimsFilterListener)listener).exitFormatLink(this);
		}
	}

	public final FormatLinkContext formatLink() throws RecognitionException {
		FormatLinkContext _localctx = new FormatLinkContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_formatLink);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(140); match(STRING);
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
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\3\22\u0091\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\3\2\3\2\3\2\5\2.\n\2\3\3\3\3\3\3\7\3\63"+
		"\n\3\f\3\16\3\66\13\3\3\4\3\4\5\4:\n\4\3\4\5\4=\n\4\3\4\5\4@\n\4\3\4\5"+
		"\4C\n\4\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3\7\7\7M\n\7\f\7\16\7P\13\7\3\b\3"+
		"\b\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3\n\3\n\5\n]\n\n\3\13\3\13\3\f\3\f\3\f"+
		"\3\f\7\fe\n\f\f\f\16\fh\13\f\3\r\3\r\3\r\3\r\3\16\3\16\3\17\3\17\3\17"+
		"\3\20\3\20\3\20\3\20\7\20w\n\20\f\20\16\20z\13\20\3\21\3\21\3\21\3\21"+
		"\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\7\23\u0088\n\23\f\23\16\23\u008b"+
		"\13\23\3\24\3\24\3\25\3\25\3\25\2\26\2\4\6\b\n\f\16\20\22\24\26\30\32"+
		"\34\36 \"$&(\2\3\4\2\f\f\16\16\u0087\2*\3\2\2\2\4/\3\2\2\2\6\67\3\2\2"+
		"\2\bD\3\2\2\2\nF\3\2\2\2\fH\3\2\2\2\16Q\3\2\2\2\20U\3\2\2\2\22\\\3\2\2"+
		"\2\24^\3\2\2\2\26`\3\2\2\2\30i\3\2\2\2\32m\3\2\2\2\34o\3\2\2\2\36r\3\2"+
		"\2\2 {\3\2\2\2\"\177\3\2\2\2$\u0081\3\2\2\2&\u008c\3\2\2\2(\u008e\3\2"+
		"\2\2*+\5\4\3\2+-\7\6\2\2,.\5\36\20\2-,\3\2\2\2-.\3\2\2\2.\3\3\2\2\2/\64"+
		"\5\6\4\2\60\61\7\r\2\2\61\63\5\6\4\2\62\60\3\2\2\2\63\66\3\2\2\2\64\62"+
		"\3\2\2\2\64\65\3\2\2\2\65\5\3\2\2\2\66\64\3\2\2\2\679\5\b\5\28:\5\n\6"+
		"\298\3\2\2\29:\3\2\2\2:<\3\2\2\2;=\5\f\7\2<;\3\2\2\2<=\3\2\2\2=?\3\2\2"+
		"\2>@\5\26\f\2?>\3\2\2\2?@\3\2\2\2@B\3\2\2\2AC\5\34\17\2BA\3\2\2\2BC\3"+
		"\2\2\2C\7\3\2\2\2DE\7\20\2\2E\t\3\2\2\2FG\7\n\2\2G\13\3\2\2\2HI\7\7\2"+
		"\2IN\5\16\b\2JK\7\b\2\2KM\5\16\b\2LJ\3\2\2\2MP\3\2\2\2NL\3\2\2\2NO\3\2"+
		"\2\2O\r\3\2\2\2PN\3\2\2\2QR\5\20\t\2RS\7\13\2\2ST\5\22\n\2T\17\3\2\2\2"+
		"UV\7\20\2\2V\21\3\2\2\2WX\5\24\13\2XY\7\6\2\2YZ\5\20\t\2Z]\3\2\2\2[]\7"+
		"\17\2\2\\W\3\2\2\2\\[\3\2\2\2]\23\3\2\2\2^_\7\20\2\2_\25\3\2\2\2`a\7\t"+
		"\2\2af\5\30\r\2bc\7\b\2\2ce\5\30\r\2db\3\2\2\2eh\3\2\2\2fd\3\2\2\2fg\3"+
		"\2\2\2g\27\3\2\2\2hf\3\2\2\2ij\7\20\2\2jk\7\3\2\2kl\5\32\16\2l\31\3\2"+
		"\2\2mn\t\2\2\2n\33\3\2\2\2op\7\4\2\2pq\7\21\2\2q\35\3\2\2\2rs\7\5\2\2"+
		"sx\5 \21\2tu\7\b\2\2uw\5 \21\2vt\3\2\2\2wz\3\2\2\2xv\3\2\2\2xy\3\2\2\2"+
		"y\37\3\2\2\2zx\3\2\2\2{|\5$\23\2|}\7\13\2\2}~\5\"\22\2~!\3\2\2\2\177\u0080"+
		"\7\17\2\2\u0080#\3\2\2\2\u0081\u0089\5&\24\2\u0082\u0083\7\3\2\2\u0083"+
		"\u0084\5(\25\2\u0084\u0085\7\3\2\2\u0085\u0086\5&\24\2\u0086\u0088\3\2"+
		"\2\2\u0087\u0082\3\2\2\2\u0088\u008b\3\2\2\2\u0089\u0087\3\2\2\2\u0089"+
		"\u008a\3\2\2\2\u008a%\3\2\2\2\u008b\u0089\3\2\2\2\u008c\u008d\7\20\2\2"+
		"\u008d\'\3\2\2\2\u008e\u008f\7\17\2\2\u008f)\3\2\2\2\r-\649<?BN\\fx\u0089";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}