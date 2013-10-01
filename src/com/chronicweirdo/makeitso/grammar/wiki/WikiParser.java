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
		T__2=1, T__1=2, T__0=3, HASH=4, COLON=5, HTTP=6, ID=7, NUMBER=8, SPACE=9, 
		WORD=10;
	public static final String[] tokenNames = {
		"<INVALID>", "'>'", "'<'", "'</>'", "'#'", "':'", "HTTP", "ID", "NUMBER", 
		"SPACE", "WORD"
	};
	public static final int
		RULE_page = 0, RULE_section = 1, RULE_tag = 2, RULE_value = 3, RULE_link = 4, 
		RULE_block = 5, RULE_text = 6;
	public static final String[] ruleNames = {
		"page", "section", "tag", "value", "link", "block", "text"
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
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 2) | (1L << HASH) | (1L << COLON) | (1L << HTTP) | (1L << ID) | (1L << NUMBER) | (1L << SPACE) | (1L << WORD))) != 0) );
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
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
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
			setState(23);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(19); block();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(20); link();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(21); tag();
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(22); text();
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
			setState(25); match(HASH);
			setState(26); match(ID);
			setState(29);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				{
				setState(27); match(COLON);
				setState(28); value();
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
			setState(31); match(ID);
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
			setState(33); match(HTTP);
			setState(34); match(WORD);
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

	public static class BlockContext extends ParserRuleContext {
		public List<SectionContext> section() {
			return getRuleContexts(SectionContext.class);
		}
		public TagContext tag() {
			return getRuleContext(TagContext.class,0);
		}
		public SectionContext section(int i) {
			return getRuleContext(SectionContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WikiListener ) ((WikiListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WikiListener ) ((WikiListener)listener).exitBlock(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_block);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(36); match(2);
			setState(37); tag();
			setState(38); match(1);
			setState(42);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=1 && _alt!=-1 ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(39); section();
					}
					} 
				}
				setState(44);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			}
			setState(45); match(3);
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
		enterRule(_localctx, 12, RULE_text);
		try {
			setState(54);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(47); match(ID);
				}
				break;
			case NUMBER:
				enterOuterAlt(_localctx, 2);
				{
				setState(48); match(NUMBER);
				}
				break;
			case WORD:
				enterOuterAlt(_localctx, 3);
				{
				setState(49); match(WORD);
				}
				break;
			case SPACE:
				enterOuterAlt(_localctx, 4);
				{
				setState(50); match(SPACE);
				}
				break;
			case HASH:
				enterOuterAlt(_localctx, 5);
				{
				setState(51); match(HASH);
				setState(52); match(SPACE);
				}
				break;
			case COLON:
				enterOuterAlt(_localctx, 6);
				{
				setState(53); match(COLON);
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
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\3\f;\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\3\2\6\2\22\n\2\r\2\16\2\23"+
		"\3\3\3\3\3\3\3\3\5\3\32\n\3\3\4\3\4\3\4\3\4\5\4 \n\4\3\5\3\5\3\6\3\6\3"+
		"\6\3\7\3\7\3\7\3\7\7\7+\n\7\f\7\16\7.\13\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\5\b9\n\b\3\b\3,\t\2\4\6\b\n\f\16\2\2>\2\21\3\2\2\2\4\31\3\2\2"+
		"\2\6\33\3\2\2\2\b!\3\2\2\2\n#\3\2\2\2\f&\3\2\2\2\168\3\2\2\2\20\22\5\4"+
		"\3\2\21\20\3\2\2\2\22\23\3\2\2\2\23\21\3\2\2\2\23\24\3\2\2\2\24\3\3\2"+
		"\2\2\25\32\5\f\7\2\26\32\5\n\6\2\27\32\5\6\4\2\30\32\5\16\b\2\31\25\3"+
		"\2\2\2\31\26\3\2\2\2\31\27\3\2\2\2\31\30\3\2\2\2\32\5\3\2\2\2\33\34\7"+
		"\6\2\2\34\37\7\t\2\2\35\36\7\7\2\2\36 \5\b\5\2\37\35\3\2\2\2\37 \3\2\2"+
		"\2 \7\3\2\2\2!\"\7\t\2\2\"\t\3\2\2\2#$\7\b\2\2$%\7\f\2\2%\13\3\2\2\2&"+
		"\'\7\4\2\2\'(\5\6\4\2(,\7\3\2\2)+\5\4\3\2*)\3\2\2\2+.\3\2\2\2,-\3\2\2"+
		"\2,*\3\2\2\2-/\3\2\2\2.,\3\2\2\2/\60\7\5\2\2\60\r\3\2\2\2\619\7\t\2\2"+
		"\629\7\n\2\2\639\7\f\2\2\649\7\13\2\2\65\66\7\6\2\2\669\7\13\2\2\679\7"+
		"\7\2\28\61\3\2\2\28\62\3\2\2\28\63\3\2\2\28\64\3\2\2\28\65\3\2\2\28\67"+
		"\3\2\2\29\17\3\2\2\2\7\23\31\37,8";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}