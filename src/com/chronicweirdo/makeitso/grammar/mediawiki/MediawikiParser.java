// Generated from src/com/chronicweirdo/makeitso/grammar/mediawiki/Mediawiki.g4 by ANTLR 4.1

package com.chronicweirdo.makeitso.grammar.mediawiki;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MediawikiParser extends Parser {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__3=1, T__2=2, T__1=3, T__0=4, TEXT=5, WS=6;
	public static final String[] tokenNames = {
		"<INVALID>", "'}}'", "'='", "'{{'", "'|'", "TEXT", "WS"
	};
	public static final int
		RULE_page = 0, RULE_section = 1, RULE_template = 2, RULE_templateName = 3, 
		RULE_templateProperty = 4, RULE_templatePropertyName = 5, RULE_templatePropertyValue = 6;
	public static final String[] ruleNames = {
		"page", "section", "template", "templateName", "templateProperty", "templatePropertyName", 
		"templatePropertyValue"
	};

	@Override
	public String getGrammarFileName() { return "Mediawiki.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public MediawikiParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class PageContext extends ParserRuleContext {
		public List<SectionContext> section() {
			return getRuleContexts(SectionContext.class);
		}
		public SectionContext section(int i) {
			return getRuleContext(SectionContext.class,i);
		}
		public PageContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_page; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MediawikiListener ) ((MediawikiListener)listener).enterPage(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MediawikiListener ) ((MediawikiListener)listener).exitPage(this);
		}
	}

	public final PageContext page() throws RecognitionException {
		PageContext _localctx = new PageContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_page);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(15); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(14); section();
				}
				}
				setState(17); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==3 );
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

	public static class SectionContext extends ParserRuleContext {
		public TemplateContext template() {
			return getRuleContext(TemplateContext.class,0);
		}
		public SectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_section; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MediawikiListener ) ((MediawikiListener)listener).enterSection(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MediawikiListener ) ((MediawikiListener)listener).exitSection(this);
		}
	}

	public final SectionContext section() throws RecognitionException {
		SectionContext _localctx = new SectionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_section);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(19); template();
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

	public static class TemplateContext extends ParserRuleContext {
		public TemplatePropertyContext templateProperty(int i) {
			return getRuleContext(TemplatePropertyContext.class,i);
		}
		public TemplateNameContext templateName() {
			return getRuleContext(TemplateNameContext.class,0);
		}
		public List<TemplatePropertyContext> templateProperty() {
			return getRuleContexts(TemplatePropertyContext.class);
		}
		public TemplateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_template; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MediawikiListener ) ((MediawikiListener)listener).enterTemplate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MediawikiListener ) ((MediawikiListener)listener).exitTemplate(this);
		}
	}

	public final TemplateContext template() throws RecognitionException {
		TemplateContext _localctx = new TemplateContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_template);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(21); match(3);
			setState(22); templateName();
			setState(24); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(23); templateProperty();
				}
				}
				setState(26); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==4 );
			setState(28); match(1);
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

	public static class TemplateNameContext extends ParserRuleContext {
		public TerminalNode TEXT() { return getToken(MediawikiParser.TEXT, 0); }
		public TemplateNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_templateName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MediawikiListener ) ((MediawikiListener)listener).enterTemplateName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MediawikiListener ) ((MediawikiListener)listener).exitTemplateName(this);
		}
	}

	public final TemplateNameContext templateName() throws RecognitionException {
		TemplateNameContext _localctx = new TemplateNameContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_templateName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(30); match(TEXT);
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

	public static class TemplatePropertyContext extends ParserRuleContext {
		public TemplatePropertyNameContext templatePropertyName() {
			return getRuleContext(TemplatePropertyNameContext.class,0);
		}
		public TemplatePropertyValueContext templatePropertyValue() {
			return getRuleContext(TemplatePropertyValueContext.class,0);
		}
		public TemplatePropertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_templateProperty; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MediawikiListener ) ((MediawikiListener)listener).enterTemplateProperty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MediawikiListener ) ((MediawikiListener)listener).exitTemplateProperty(this);
		}
	}

	public final TemplatePropertyContext templateProperty() throws RecognitionException {
		TemplatePropertyContext _localctx = new TemplatePropertyContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_templateProperty);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(32); match(4);
			setState(33); templatePropertyName();
			setState(34); match(2);
			setState(35); templatePropertyValue();
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

	public static class TemplatePropertyNameContext extends ParserRuleContext {
		public TerminalNode TEXT() { return getToken(MediawikiParser.TEXT, 0); }
		public TemplatePropertyNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_templatePropertyName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MediawikiListener ) ((MediawikiListener)listener).enterTemplatePropertyName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MediawikiListener ) ((MediawikiListener)listener).exitTemplatePropertyName(this);
		}
	}

	public final TemplatePropertyNameContext templatePropertyName() throws RecognitionException {
		TemplatePropertyNameContext _localctx = new TemplatePropertyNameContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_templatePropertyName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(37); match(TEXT);
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

	public static class TemplatePropertyValueContext extends ParserRuleContext {
		public TerminalNode TEXT() { return getToken(MediawikiParser.TEXT, 0); }
		public TemplatePropertyValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_templatePropertyValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MediawikiListener ) ((MediawikiListener)listener).enterTemplatePropertyValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MediawikiListener ) ((MediawikiListener)listener).exitTemplatePropertyValue(this);
		}
	}

	public final TemplatePropertyValueContext templatePropertyValue() throws RecognitionException {
		TemplatePropertyValueContext _localctx = new TemplatePropertyValueContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_templatePropertyValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(39); match(TEXT);
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
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\3\b,\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\3\2\6\2\22\n\2\r\2\16\2\23"+
		"\3\3\3\3\3\4\3\4\3\4\6\4\33\n\4\r\4\16\4\34\3\4\3\4\3\5\3\5\3\6\3\6\3"+
		"\6\3\6\3\6\3\7\3\7\3\b\3\b\3\b\2\t\2\4\6\b\n\f\16\2\2&\2\21\3\2\2\2\4"+
		"\25\3\2\2\2\6\27\3\2\2\2\b \3\2\2\2\n\"\3\2\2\2\f\'\3\2\2\2\16)\3\2\2"+
		"\2\20\22\5\4\3\2\21\20\3\2\2\2\22\23\3\2\2\2\23\21\3\2\2\2\23\24\3\2\2"+
		"\2\24\3\3\2\2\2\25\26\5\6\4\2\26\5\3\2\2\2\27\30\7\5\2\2\30\32\5\b\5\2"+
		"\31\33\5\n\6\2\32\31\3\2\2\2\33\34\3\2\2\2\34\32\3\2\2\2\34\35\3\2\2\2"+
		"\35\36\3\2\2\2\36\37\7\3\2\2\37\7\3\2\2\2 !\7\7\2\2!\t\3\2\2\2\"#\7\6"+
		"\2\2#$\5\f\7\2$%\7\4\2\2%&\5\16\b\2&\13\3\2\2\2\'(\7\7\2\2(\r\3\2\2\2"+
		")*\7\7\2\2*\17\3\2\2\2\4\23\34";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}