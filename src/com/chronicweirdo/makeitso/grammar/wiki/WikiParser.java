// Generated from src/com/chronicweirdo/makeitso/grammar/wiki/Wiki.g4 by ANTLR 4.1

package com.chronicweirdo.makeitso.grammar.wiki;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class WikiParser extends Parser {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		HASH=1, COLON=2, HTTP=3, ID=4, NUMBER=5, SPACE=6, WORD=7;
	public static final String[] tokenNames = {
		"<INVALID>", "'#'", "':'", "HTTP", "ID", "NUMBER", "SPACE", "WORD"
	};
	public static final int
		RULE_page = 0, RULE_section = 1, RULE_tag = 2, RULE_value = 3, RULE_link = 4, 
		RULE_text = 5;
	public static final String[] ruleNames = {
		"page", "section", "tag", "value", "link", "text"
	};

	@Override
	public String getGrammarFileName() { return "Wiki.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public WikiParser(TokenStream input) {
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
			if ( listener instanceof WikiListener ) ((WikiListener)listener).enterPage(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WikiListener ) ((WikiListener)listener).exitPage(this);
		}
	}

	public final PageContext page() throws RecognitionException {
		PageContext _localctx = new PageContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_page);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(13); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(12); section();
				}
				}
				setState(15); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << HASH) | (1L << COLON) | (1L << HTTP) | (1L << ID) | (1L << NUMBER) | (1L << SPACE) | (1L << WORD))) != 0) );
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
		public TextContext text() {
			return getRuleContext(TextContext.class,0);
		}
		public TagContext tag() {
			return getRuleContext(TagContext.class,0);
		}
		public LinkContext link() {
			return getRuleContext(LinkContext.class,0);
		}
		public SectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_section; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WikiListener ) ((WikiListener)listener).enterSection(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WikiListener ) ((WikiListener)listener).exitSection(this);
		}
	}

	public final SectionContext section() throws RecognitionException {
		SectionContext _localctx = new SectionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_section);
		try {
			setState(20);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(17); tag();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(18); link();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(19); text();
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

	public static class TagContext extends ParserRuleContext {
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public TerminalNode ID() { return getToken(WikiParser.ID, 0); }
		public TerminalNode HASH() { return getToken(WikiParser.HASH, 0); }
		public TerminalNode COLON() { return getToken(WikiParser.COLON, 0); }
		public TagContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tag; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WikiListener ) ((WikiListener)listener).enterTag(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WikiListener ) ((WikiListener)listener).exitTag(this);
		}
	}

	public final TagContext tag() throws RecognitionException {
		TagContext _localctx = new TagContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_tag);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(22); match(HASH);
			setState(23); match(ID);
			setState(26);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				{
				setState(24); match(COLON);
				setState(25); value();
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

	public static class ValueContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(WikiParser.ID, 0); }
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WikiListener ) ((WikiListener)listener).enterValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WikiListener ) ((WikiListener)listener).exitValue(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_value);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(28); match(ID);
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

	public static class LinkContext extends ParserRuleContext {
		public TerminalNode WORD() { return getToken(WikiParser.WORD, 0); }
		public TerminalNode HTTP() { return getToken(WikiParser.HTTP, 0); }
		public LinkContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_link; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WikiListener ) ((WikiListener)listener).enterLink(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WikiListener ) ((WikiListener)listener).exitLink(this);
		}
	}

	public final LinkContext link() throws RecognitionException {
		LinkContext _localctx = new LinkContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_link);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(30); match(HTTP);
			setState(31); match(WORD);
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
		public TerminalNode WORD() { return getToken(WikiParser.WORD, 0); }
		public TerminalNode SPACE() { return getToken(WikiParser.SPACE, 0); }
		public TerminalNode ID() { return getToken(WikiParser.ID, 0); }
		public TerminalNode NUMBER() { return getToken(WikiParser.NUMBER, 0); }
		public TerminalNode HASH() { return getToken(WikiParser.HASH, 0); }
		public TerminalNode COLON() { return getToken(WikiParser.COLON, 0); }
		public TextContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_text; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WikiListener ) ((WikiListener)listener).enterText(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WikiListener ) ((WikiListener)listener).exitText(this);
		}
	}

	public final TextContext text() throws RecognitionException {
		TextContext _localctx = new TextContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_text);
		try {
			setState(40);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(33); match(ID);
				}
				break;
			case NUMBER:
				enterOuterAlt(_localctx, 2);
				{
				setState(34); match(NUMBER);
				}
				break;
			case WORD:
				enterOuterAlt(_localctx, 3);
				{
				setState(35); match(WORD);
				}
				break;
			case SPACE:
				enterOuterAlt(_localctx, 4);
				{
				setState(36); match(SPACE);
				}
				break;
			case HASH:
				enterOuterAlt(_localctx, 5);
				{
				setState(37); match(HASH);
				setState(38); match(SPACE);
				}
				break;
			case COLON:
				enterOuterAlt(_localctx, 6);
				{
				setState(39); match(COLON);
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

	public static final String _serializedATN =
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\3\t-\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\3\2\6\2\20\n\2\r\2\16\2\21\3\3\3\3"+
		"\3\3\5\3\27\n\3\3\4\3\4\3\4\3\4\5\4\35\n\4\3\5\3\5\3\6\3\6\3\6\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\5\7+\n\7\3\7\2\b\2\4\6\b\n\f\2\2/\2\17\3\2\2\2\4"+
		"\26\3\2\2\2\6\30\3\2\2\2\b\36\3\2\2\2\n \3\2\2\2\f*\3\2\2\2\16\20\5\4"+
		"\3\2\17\16\3\2\2\2\20\21\3\2\2\2\21\17\3\2\2\2\21\22\3\2\2\2\22\3\3\2"+
		"\2\2\23\27\5\6\4\2\24\27\5\n\6\2\25\27\5\f\7\2\26\23\3\2\2\2\26\24\3\2"+
		"\2\2\26\25\3\2\2\2\27\5\3\2\2\2\30\31\7\3\2\2\31\34\7\6\2\2\32\33\7\4"+
		"\2\2\33\35\5\b\5\2\34\32\3\2\2\2\34\35\3\2\2\2\35\7\3\2\2\2\36\37\7\6"+
		"\2\2\37\t\3\2\2\2 !\7\5\2\2!\"\7\t\2\2\"\13\3\2\2\2#+\7\6\2\2$+\7\7\2"+
		"\2%+\7\t\2\2&+\7\b\2\2\'(\7\3\2\2(+\7\b\2\2)+\7\4\2\2*#\3\2\2\2*$\3\2"+
		"\2\2*%\3\2\2\2*&\3\2\2\2*\'\3\2\2\2*)\3\2\2\2+\r\3\2\2\2\6\21\26\34*";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}