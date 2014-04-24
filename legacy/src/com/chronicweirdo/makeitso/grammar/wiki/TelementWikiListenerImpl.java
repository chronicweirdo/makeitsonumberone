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
import com.chronicweirdo.makeitso.grammar.wiki.text.Tag;
import com.chronicweirdo.makeitso.grammar.wiki.text.Text;
import com.chronicweirdo.makeitso.grammar.wiki.text2.Telement;

public class TelementWikiListenerImpl extends WikiBaseListener {

	private Telement page;
	
	public TelementWikiListenerImpl() {
	}
	
	public Telement parse(TextContext ctx) {
		if (ctx.SPACE() != null) {
			return new Telement(Telement.Type.TEXT, "space", ctx.SPACE().getText());
		} else {
			return new Telement(Telement.Type.TEXT, "text", ctx.getText());
		}
	}

	public Telement parse(TagContext ctx) {
		String name = ctx.ID().getText();
		String value = null;
		if (ctx.value() != null) {
			value = ctx.value().ID().getText();
			return new Telement("tag", "#", name, ":", value);
		}
		return new Telement("tag", "#", name);
	}
	
	public Telement parse(LinkContext ctx) {
		return new Telement(Telement.Type.TEXT, "link", ctx.getText());
	}
	
	public Telement parse(SectionContext ctx) {
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

	public Telement parse(BlockOpenContext ctx) {
		List<Telement> result = new ArrayList<Telement>();
		for (BlockOpenContentsContext boctx: ctx.blockOpenContents()) {
			if (boctx.tag() != null) {
				result.add(parse(boctx.tag()));
			} else if (boctx.text() != null) {
				result.add(parse(boctx.text()));
			}
		}
		return new Telement("blockOpen", result);
	}
	public Telement parse(BlockContentsContext ctx) {
		List<Telement> result = new ArrayList<Telement>();
		for (SectionContext sctx: ctx.section()) {
			result.add(parse(sctx));
		}
		return new Telement("blockContents", result);
	}
	public Telement parse(BlockContext ctx) {
		try {
			List<Telement> parts = new ArrayList<Telement>();
			parts.add(parse(ctx.blockOpen()));
			parts.add(parse(ctx.blockContents()));
			return new Telement("block", parts);
		} catch (Exception e) {
			return null;
		}
	}

	public Telement getPage() {
		return this.page;
	}

	public Telement parse(PageContext ctx) {
		List<Telement> result = new ArrayList<Telement>();
		for (SectionContext sctx: ctx.section()) {
			result.add(parse(sctx));
		}
		return new Telement("page", result);
	}
	@Override
	public void exitPage(PageContext ctx) {
		this.page = parse(ctx);
	}

	
}
