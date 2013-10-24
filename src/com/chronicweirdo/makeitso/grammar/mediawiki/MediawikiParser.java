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
		T__3=1, T__2=2, T__1=3, T__0=4, SPACE=5, WORD=6;
	public static final String[] tokenNames = {
		"<INVALID>", "'}}'", "'='", "'{{'", "'|'", "SPACE", "WORD"
	};
	public static final int
		RULE_template = 0, RULE_templateName = 1, RULE_templateProperty = 2, RULE_templatePropertyName = 3, 
		RULE_templatePropertyValue = 4, RULE_text = 5;
	public static final String[] ruleNames = {
		"template", "templateName", "templateProperty", "templatePropertyName", 
		"templatePropertyValue", "text"
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
		enterRule(_localctx, 0, RULE_template);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(12); match(3);
			setState(13); templateName();
			setState(15); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(14); templateProperty();
				}
				}
				setState(17); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==4 );
			setState(19); match(1);
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
		public TextContext text() {
			return getRuleContext(TextContext.class,0);
		}
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
		enterRule(_localctx, 2, RULE_templateName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(21); text();
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
		enterRule(_localctx, 4, RULE_templateProperty);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(23); match(4);
			setState(24); templatePropertyName();
			setState(25); match(2);
			setState(26); templatePropertyValue();
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
		public TextContext text() {
			return getRuleContext(TextContext.class,0);
		}
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
		enterRule(_localctx, 6, RULE_templatePropertyName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(28); text();
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
		public TextContext text() {
			return getRuleContext(TextContext.class,0);
		}
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
		enterRule(_localctx, 8, RULE_templatePropertyValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(30); text();
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

	public static class TextContext extends ParserRuleContext {
		public List<TerminalNode> WORD() { return getTokens(MediawikiParser.WORD); }
		public List<TerminalNode> SPACE() { return getTokens(MediawikiParser.SPACE); }
		public TerminalNode WORD(int i) {
			return getToken(MediawikiParser.WORD, i);
		}
		public TerminalNode SPACE(int i) {
			return getToken(MediawikiParser.SPACE, i);
		}
		public TextContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_text; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MediawikiListener ) ((MediawikiListener)listener).enterText(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MediawikiListener ) ((MediawikiListener)listener).exitText(this);
		}
	}

	public final TextContext text() throws RecognitionException {
		TextContext _localctx = new TextContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_text);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(33); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(32);
				_la = _input.LA(1);
				if ( !(_la==SPACE || _la==WORD) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
				}
				setState(35); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==SPACE || _la==WORD );
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
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\3\b(\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\3\2\3\2\3\2\6\2\22\n\2\r\2\16\2\23"+
		"\3\2\3\2\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\6\3\6\3\7\6\7$\n\7\r\7"+
		"\16\7%\3\7\2\b\2\4\6\b\n\f\2\3\3\2\7\b#\2\16\3\2\2\2\4\27\3\2\2\2\6\31"+
		"\3\2\2\2\b\36\3\2\2\2\n \3\2\2\2\f#\3\2\2\2\16\17\7\5\2\2\17\21\5\4\3"+
		"\2\20\22\5\6\4\2\21\20\3\2\2\2\22\23\3\2\2\2\23\21\3\2\2\2\23\24\3\2\2"+
		"\2\24\25\3\2\2\2\25\26\7\3\2\2\26\3\3\2\2\2\27\30\5\f\7\2\30\5\3\2\2\2"+
		"\31\32\7\6\2\2\32\33\5\b\5\2\33\34\7\4\2\2\34\35\5\n\6\2\35\7\3\2\2\2"+
		"\36\37\5\f\7\2\37\t\3\2\2\2 !\5\f\7\2!\13\3\2\2\2\"$\t\2\2\2#\"\3\2\2"+
		"\2$%\3\2\2\2%#\3\2\2\2%&\3\2\2\2&\r\3\2\2\2\4\23%";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}