package com.chronicweirdo.makeitso.grammar.wiki;

import java.util.ArrayList;
import java.util.List;

import com.chronicweirdo.makeitso.grammar.wiki.WikiParser.BlockContentsContext;
import com.chronicweirdo.makeitso.grammar.wiki.WikiParser.BlockContext;
import com.chronicweirdo.makeitso.grammar.wiki.WikiParser.BlockOpenContentsContext;
import com.chronicweirdo.makeitso.grammar.wiki.WikiParser.BlockOpenContext;
import com.chronicweirdo.makeitso.grammar.wiki.WikiParser.LinkContext;
import com.chronicweirdo.makeitso.grammar.wiki.WikiParser.SectionContext;
import com.chronicweirdo.makeitso.grammar.wiki.WikiParser.TagContext;
import com.chronicweirdo.makeitso.grammar.wiki.WikiParser.TextContext;
import com.chronicweirdo.makeitso.grammar.wiki.text.Block;
import com.chronicweirdo.makeitso.grammar.wiki.text.Section;
import com.chronicweirdo.makeitso.grammar.wiki.text5.TGroup;
import com.chronicweirdo.makeitso.grammar.wiki.text5.Text;

public class TokenDocWikiListenerImpl extends WikiBaseListener {
	
	public TokenDocWikiListenerImpl() {
	}
	
	public void parse(TextContext ctx, Text text) {
		text.add(ctx.getText());
	}

	public void parse(TagContext ctx, Text text) {
		TGroup g = text.group();
		text.add("#", g, true);
		text.add(ctx.ID().getText(), g, true);
		if (ctx.value() != null) {
			text.add(":", g, true);
			text.add(ctx.value().getText(), g, true);
		}
	}
	
	public void parse(LinkContext ctx, Text text) {
		text.add(ctx.getText());
	}
	
	public Section parse(SectionContext ctx) {
		if (ctx.tag() != null) {
			return parse(ctx.tag());
		} else if (ctx.block() != null) {
			return parse(ctx.block());
		} else if (ctx.link() != null) {
			return parse(ctx.link());
		} else if (ctx.text() != null) {
			return parse(ctx.text());
		}
		return null;
	}

	public void parse(BlockOpenContext ctx, Text text, TGroup g) {
		text.add("<", g, true);
		for (BlockOpenContentsContext boctx: ctx.blockOpenContents()) {
			if (boctx.tag() != null) {
				result.add(parse(boctx.tag()));
			} else if (boctx.text() != null) {
				result.add(parse(boctx.text()));
			}
		}
		return result;
	}
	public List<Section> parse(BlockContentsContext ctx) {
		List<Section> result = new ArrayList<Section>();
		for (SectionContext sctx: ctx.section()) {
			result.add(parse(sctx));
		}
		return result;
	}
	public Section parse(BlockContext ctx) {
		try {
			return new Block(parse(ctx.blockOpen()), parse(ctx.blockContents()));
		} catch (Exception e) {
			return null;
		}
	}

	
}
