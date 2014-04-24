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
import com.chronicweirdo.makeitso.grammar.wiki.text3.Telement;
import com.chronicweirdo.makeitso.grammar.wiki.text4.Block;
import com.chronicweirdo.makeitso.grammar.wiki.text4.Elem;
import com.chronicweirdo.makeitso.grammar.wiki.text4.Text;

public class ElemWikiListenerImpl extends WikiBaseListener {

	private List<Elem> page;
	
	public ElemWikiListenerImpl() {
	}
	
	public Elem parse(TextContext ctx) {
		return new Text("text", ctx.getText());
	}

	public Elem parse(TagContext ctx) {
		Block tag = new Block("tag");
		tag.add(new Text("tagStart", "#"));
		tag.add(new Text("tagName", ctx.ID().getText()));
		if (ctx.value() != null) {
			tag.add(new Text("tagSeparator", ":"));
			tag.add(new Text("tagValue", ctx.value().getText()));
		}
		return tag;
	}
	
	public Elem parse(LinkContext ctx) {
		return new Text("link", ctx.getText());
	}
	
	public Elem parse(SectionContext ctx) {
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

	public Elem parse(BlockOpenContext ctx) {
		Block blockOpen = new Block("blockOpen");
		blockOpen.add(new Text("blockOpenLeftBracket", "<"));
		for (BlockOpenContentsContext boctx: ctx.blockOpenContents()) {
			if (boctx.tag() != null) {
				blockOpen.add(parse(boctx.tag()));
			} else if (boctx.text() != null) {
				blockOpen.add(parse(boctx.text()));
			}
		}
		blockOpen.add(new Text("blockOpenRightBracket", ">"));
		return blockOpen;
	}
	
	public Elem parse(BlockContentsContext ctx) {
		Block result = new Block("blockContents");
		for (SectionContext sctx: ctx.section()) {
			result.add(parse(sctx));
		}
		return result;
	}
	
	public Elem parse(BlockContext ctx) {
		try {
			Block block = new Block("block");
			block.add(parse(ctx.blockOpen()));
			block.add(parse(ctx.blockContents()));
			block.add(new Text("blockClose", "</>"));
			return block;
		} catch (Exception e) {
			return null;
		}
	}

	public List<Elem> getPage() {
		return this.page;
	}

	public List<Elem> parse(PageContext ctx) {
		List<Elem> result = new ArrayList<Elem>();
		for (SectionContext sctx: ctx.section()) {
			result.add(parse(sctx));
		}
		return result;
	}
	@Override
	public void exitPage(PageContext ctx) {
		this.page = parse(ctx);
	}

	
}
