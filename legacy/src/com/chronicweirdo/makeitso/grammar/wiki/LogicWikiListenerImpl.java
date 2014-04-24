package com.chronicweirdo.makeitso.grammar.wiki;

import java.util.ArrayList;
import java.util.List;

import com.chronicweirdo.makeitso.grammar.wiki.WikiParser.BlockContentsContext;
import com.chronicweirdo.makeitso.grammar.wiki.WikiParser.BlockContext;
import com.chronicweirdo.makeitso.grammar.wiki.WikiParser.BlockOpenContentsContext;
import com.chronicweirdo.makeitso.grammar.wiki.WikiParser.BlockOpenContext;
import com.chronicweirdo.makeitso.grammar.wiki.WikiParser.LinkContext;
import com.chronicweirdo.makeitso.grammar.wiki.WikiParser.PageContext;
import com.chronicweirdo.makeitso.grammar.wiki.WikiParser.SectionContext;
import com.chronicweirdo.makeitso.grammar.wiki.WikiParser.TagContext;
import com.chronicweirdo.makeitso.grammar.wiki.WikiParser.TextContext;
import com.chronicweirdo.makeitso.grammar.wiki.text.Block;
import com.chronicweirdo.makeitso.grammar.wiki.text.Link;
import com.chronicweirdo.makeitso.grammar.wiki.text.Section;
import com.chronicweirdo.makeitso.grammar.wiki.text.Space;
import com.chronicweirdo.makeitso.grammar.wiki.text.Tag;
import com.chronicweirdo.makeitso.grammar.wiki.text.Text;

public class LogicWikiListenerImpl extends WikiBaseListener {

	private List<Section> sections;
	
	public LogicWikiListenerImpl() {
	}
	
	public Section parse(TextContext ctx) {
		if (ctx.SPACE() != null) {
			return new Space(ctx.SPACE().getText());
		} else {
			return new Text(ctx.getText());
		}
	}

	public Section parse(TagContext ctx) {
		String name = ctx.ID().getText();
		String value = null;
		if (ctx.value() != null) {
			value = ctx.value().ID().getText();
		}
		return new Tag(name, value);
	}
	
	public Section parse(LinkContext ctx) {
		return new Link(ctx.getText());
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

	public List<Section> parse(BlockOpenContext ctx) {
		List<Section> result = new ArrayList<Section>();
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

	public List<Section> getSections() {
		return this.sections;
	}

	public List<Section> parse(PageContext ctx) {
		List<Section> result = new ArrayList<Section>();
		for (SectionContext sctx: ctx.section()) {
			result.add(parse(sctx));
		}
		return result;
	}
	@Override
	public void exitPage(PageContext ctx) {
		this.sections = parse(ctx);
	}

	
}
