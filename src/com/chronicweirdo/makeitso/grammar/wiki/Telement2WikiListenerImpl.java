package com.chronicweirdo.makeitso.grammar.wiki;

import java.util.ArrayList;
import java.util.List;

import com.chronicweirdo.makeitso.Struct;
import com.chronicweirdo.makeitso.grammar.wiki.WikiParser.BlockContentsContext;
import com.chronicweirdo.makeitso.grammar.wiki.WikiParser.BlockContext;
import com.chronicweirdo.makeitso.grammar.wiki.WikiParser.BlockOpenContentsContext;
import com.chronicweirdo.makeitso.grammar.wiki.WikiParser.BlockOpenContext;
import com.chronicweirdo.makeitso.grammar.wiki.WikiParser.LinkContext;
import com.chronicweirdo.makeitso.grammar.wiki.WikiParser.PageContext;
import com.chronicweirdo.makeitso.grammar.wiki.WikiParser.SectionContext;
import com.chronicweirdo.makeitso.grammar.wiki.WikiParser.TagContext;
import com.chronicweirdo.makeitso.grammar.wiki.WikiParser.TextContext;
import com.chronicweirdo.makeitso.grammar.wiki.text3.Telement;

public class Telement2WikiListenerImpl extends WikiBaseListener {

	private Telement page;
	
	public Telement2WikiListenerImpl() {
	}
	
	public Telement parse(TextContext ctx) {
		if (ctx.SPACE() != null) {
			return new Telement("space", ctx.SPACE().getText());
		} else {
			return new Telement("text", ctx.getText());
		}
	}

	public Telement parse(TagContext ctx) {
		if (ctx.value() != null) {
			return Telement.create(
					Struct.list("tagStart", "tagName", "tagSeparator", "tagValue"),
					Struct.list("#", ctx.ID().getText(), ":", ctx.value().ID().getText())
				);
		} else {
			return Telement.create(
					Struct.list("tagStart", "tagName"),
					Struct.list("#", ctx.ID().getText())
				);
		}
	}
	
	public Telement parse(LinkContext ctx) {
		return new Telement("link", ctx.getText());
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
		result.add(new Telement("blockOpenLeftBracket", "<"));
		for (BlockOpenContentsContext boctx: ctx.blockOpenContents()) {
			if (boctx.tag() != null) {
				result.add(parse(boctx.tag()));
			} else if (boctx.text() != null) {
				result.add(parse(boctx.text()));
			}
		}
		result.add(new Telement("blockOpenRightBracket", ">"));
		return Telement.link(result);
	}
	public Telement parse(BlockContentsContext ctx) {
		List<Telement> result = new ArrayList<Telement>();
		for (SectionContext sctx: ctx.section()) {
			result.add(parse(sctx));
		}
		return Telement.link(result);
	}
	public Telement parse(BlockContext ctx) {
		try {
			List<Telement> parts = new ArrayList<Telement>();
			parts.add(parse(ctx.blockOpen()));
			parts.add(parse(ctx.blockContents()));
			parts.add(new Telement("blockClose", "</>"));
			return Telement.link(parts);
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
		return Telement.link(result);
	}
	@Override
	public void exitPage(PageContext ctx) {
		this.page = parse(ctx);
	}

	
}
