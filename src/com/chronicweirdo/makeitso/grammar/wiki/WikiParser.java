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
		HASH=1, COLON=2, LT=3, GT=4, BEND=5, HTTP=6, ID=7, NUMBER=8, SPACE=9, 
		WORD=10;
	public static final String[] tokenNames = {
		"<INVALID>", "'#'", "':'", "'<'", "'>'", "'</>'", "HTTP", "ID", "NUMBER", 
		"SPACE", "WORD"
	};
	public static final int
		RULE_page = 0, RULE_section = 1, RULE_tag = 2, RULE_value = 3, RULE_link = 4, 
		RULE_block = 5, RULE_blockOpen = 6, RULE_blockOpenContents = 7, RULE_blockContents = 8, 
		RULE_blockClose = 9, RULE_text = 10;
	public static final String[] ruleNames = {
		"page", "section", "tag", "value", "link", "block", "blockOpen", "blockOpenContents", 
		"blockContents", "blockClose", "text"
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
			setState(23); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(22); section();
				}
				}
				setState(25); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << HASH) | (1L << COLON) | (1L << LT) | (1L << GT) | (1L << BEND) | (1L << HTTP) | (1L << ID) | (1L << NUMBER) | (1L << SPACE) | (1L << WORD))) != 0) );
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
			setState(31);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(27); block();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(28); link();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(29); tag();
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(30); text();
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
			setState(33); match(HASH);
			setState(34); match(ID);
			setState(37);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				{
				setState(35); match(COLON);
				setState(36); value();
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
			setState(39); match(ID);
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
			setState(41); match(HTTP);
			setState(42); match(WORD);
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
		public BlockCloseContext blockClose() {
			return getRuleContext(BlockCloseContext.class,0);
		}
		public BlockOpenContext blockOpen() {
			return getRuleContext(BlockOpenContext.class,0);
		}
		public BlockContentsContext blockContents() {
			return getRuleContext(BlockContentsContext.class,0);
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
			enterOuterAlt(_localctx, 1);
			{
			setState(44); blockOpen();
			setState(45); blockContents();
			setState(46); blockClose();
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

	public static class BlockOpenContext extends ParserRuleContext {
		public BlockOpenContentsContext blockOpenContents(int i) {
			return getRuleContext(BlockOpenContentsContext.class,i);
		}
		public List<BlockOpenContentsContext> blockOpenContents() {
			return getRuleContexts(BlockOpenContentsContext.class);
		}
		public TerminalNode LT() { return getToken(WikiParser.LT, 0); }
		public TerminalNode GT() { return getToken(WikiParser.GT, 0); }
		public BlockOpenContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockOpen; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WikiListener ) ((WikiListener)listener).enterBlockOpen(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WikiListener ) ((WikiListener)listener).exitBlockOpen(this);
		}
	}

	public final BlockOpenContext blockOpen() throws RecognitionException {
		BlockOpenContext _localctx = new BlockOpenContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_blockOpen);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(48); match(LT);
			setState(50); 
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(49); blockOpenContents();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(52); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			} while ( _alt!=2 && _alt!=-1 );
			setState(54); match(GT);
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

	public static class BlockOpenContentsContext extends ParserRuleContext {
		public TextContext text() {
			return getRuleContext(TextContext.class,0);
		}
		public TagContext tag() {
			return getRuleContext(TagContext.class,0);
		}
		public BlockOpenContentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockOpenContents; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WikiListener ) ((WikiListener)listener).enterBlockOpenContents(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WikiListener ) ((WikiListener)listener).exitBlockOpenContents(this);
		}
	}

	public final BlockOpenContentsContext blockOpenContents() throws RecognitionException {
		BlockOpenContentsContext _localctx = new BlockOpenContentsContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_blockOpenContents);
		try {
			setState(58);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(56); tag();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(57); text();
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

	public static class BlockContentsContext extends ParserRuleContext {
		public List<SectionContext> section() {
			return getRuleContexts(SectionContext.class);
		}
		public SectionContext section(int i) {
			return getRuleContext(SectionContext.class,i);
		}
		public BlockContentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockContents; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WikiListener ) ((WikiListener)listener).enterBlockContents(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WikiListener ) ((WikiListener)listener).exitBlockContents(this);
		}
	}

	public final BlockContentsContext blockContents() throws RecognitionException {
		BlockContentsContext _localctx = new BlockContentsContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_blockContents);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(63);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=1 && _alt!=-1 ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(60); section();
					}
					} 
				}
				setState(65);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
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

	public static class BlockCloseContext extends ParserRuleContext {
		public TerminalNode BEND() { return getToken(WikiParser.BEND, 0); }
		public BlockCloseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockClose; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WikiListener ) ((WikiListener)listener).enterBlockClose(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WikiListener ) ((WikiListener)listener).exitBlockClose(this);
		}
	}

	public final BlockCloseContext blockClose() throws RecognitionException {
		BlockCloseContext _localctx = new BlockCloseContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_blockClose);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(66); match(BEND);
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
		public TerminalNode BEND() { return getToken(WikiParser.BEND, 0); }
		public TerminalNode WORD() { return getToken(WikiParser.WORD, 0); }
		public TerminalNode SPACE() { return getToken(WikiParser.SPACE, 0); }
		public TerminalNode LT() { return getToken(WikiParser.LT, 0); }
		public TerminalNode ID() { return getToken(WikiParser.ID, 0); }
		public TerminalNode NUMBER() { return getToken(WikiParser.NUMBER, 0); }
		public TerminalNode GT() { return getToken(WikiParser.GT, 0); }
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
		enterRule(_localctx, 20, RULE_text);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(68);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << HASH) | (1L << COLON) | (1L << LT) | (1L << GT) | (1L << BEND) | (1L << ID) | (1L << NUMBER) | (1L << SPACE) | (1L << WORD))) != 0)) ) {
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
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\3\fI\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4"+
		"\f\t\f\3\2\6\2\32\n\2\r\2\16\2\33\3\3\3\3\3\3\3\3\5\3\"\n\3\3\4\3\4\3"+
		"\4\3\4\5\4(\n\4\3\5\3\5\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\b\3\b\6\b\65\n\b"+
		"\r\b\16\b\66\3\b\3\b\3\t\3\t\5\t=\n\t\3\n\7\n@\n\n\f\n\16\nC\13\n\3\13"+
		"\3\13\3\f\3\f\3\f\3A\r\2\4\6\b\n\f\16\20\22\24\26\2\3\4\2\3\7\t\fE\2\31"+
		"\3\2\2\2\4!\3\2\2\2\6#\3\2\2\2\b)\3\2\2\2\n+\3\2\2\2\f.\3\2\2\2\16\62"+
		"\3\2\2\2\20<\3\2\2\2\22A\3\2\2\2\24D\3\2\2\2\26F\3\2\2\2\30\32\5\4\3\2"+
		"\31\30\3\2\2\2\32\33\3\2\2\2\33\31\3\2\2\2\33\34\3\2\2\2\34\3\3\2\2\2"+
		"\35\"\5\f\7\2\36\"\5\n\6\2\37\"\5\6\4\2 \"\5\26\f\2!\35\3\2\2\2!\36\3"+
		"\2\2\2!\37\3\2\2\2! \3\2\2\2\"\5\3\2\2\2#$\7\3\2\2$\'\7\t\2\2%&\7\4\2"+
		"\2&(\5\b\5\2\'%\3\2\2\2\'(\3\2\2\2(\7\3\2\2\2)*\7\t\2\2*\t\3\2\2\2+,\7"+
		"\b\2\2,-\7\f\2\2-\13\3\2\2\2./\5\16\b\2/\60\5\22\n\2\60\61\5\24\13\2\61"+
		"\r\3\2\2\2\62\64\7\5\2\2\63\65\5\20\t\2\64\63\3\2\2\2\65\66\3\2\2\2\66"+
		"\64\3\2\2\2\66\67\3\2\2\2\678\3\2\2\289\7\6\2\29\17\3\2\2\2:=\5\6\4\2"+
		";=\5\26\f\2<:\3\2\2\2<;\3\2\2\2=\21\3\2\2\2>@\5\4\3\2?>\3\2\2\2@C\3\2"+
		"\2\2AB\3\2\2\2A?\3\2\2\2B\23\3\2\2\2CA\3\2\2\2DE\7\7\2\2E\25\3\2\2\2F"+
		"G\t\2\2\2G\27\3\2\2\2\b\33!\'\66<A";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}