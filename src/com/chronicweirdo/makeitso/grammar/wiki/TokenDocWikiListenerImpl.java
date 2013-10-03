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
import com.chronicweirdo.makeitso.grammar.wiki.text.Section;
import com.chronicweirdo.makeitso.grammar.wiki.text5.TG;
import com.chronicweirdo.makeitso.grammar.wiki.text5.Text;

public class TokenDocWikiListenerImpl extends WikiBaseListener {
	
	private Text text;
	
	public TokenDocWikiListenerImpl() {
	}
	
	public Text parse(TextContext ctx) {
		System.out.println("parsing text");
		return new Text(ctx.getText());
	}

	public Text parse(TagContext ctx) {
		System.out.println("parsing tag");
		Text t = new Text();
		TG g = t.group();
		t.add("#", g, true);
		t.add(ctx.ID().getText(), g, true);
		if (ctx.value() != null) {
			t.add(":", g, true);
			t.add(ctx.value().getText(), g, true);
		}
		t.print();
		return t;
	}
	
	public Text parse(LinkContext ctx) {
		System.out.println("parsing link");
		return new Text(ctx.getText());
	}
	
	public Text parse(SectionContext ctx) {
		if (ctx.tag() != null) {
			System.out.println("tag");
			return parse(ctx.tag());
		} else if (ctx.block() != null) {
			System.out.println("block");
			return parse(ctx.block());
		} else if (ctx.link() != null) {
			System.out.println("link");
			return parse(ctx.link());
		} else if (ctx.text() != null) {
			System.out.println("text");
			return parse(ctx.text());
		}
		return null;
	}

	/*public void parse(BlockOpenContext ctx, Text text, TGroup g) {
		text.add("<", g, true);
		for (BlockOpenContentsContext boctx: ctx.blockOpenContents()) {
			if (boctx.tag() != null) {
				parse(boctx.tag()));
			} else if (boctx.text() != null) {
				result.add(parse(boctx.text()));
			}
		}
		return result;
	}*/
	/*public List<Section> parse(BlockContentsContext ctx) {
		List<Section> result = new ArrayList<Section>();
		for (SectionContext sctx: ctx.section()) {
			result.add(parse(sctx));
		}
		return result;
	}*/
	public Text parse(BlockContext ctx) {
		System.out.println("parsing block");
		Text t = new Text();
		TG g = t.group();
		t.add("<", g, true);
		for (BlockOpenContentsContext boctx: ctx.blockOpen().blockOpenContents()) {
			if (boctx.tag() != null) {
				Text tt = parse(boctx.tag());
				g.add(tt.first(), tt.last(), false);
				t.append(tt);
			} else if (boctx.text() != null) {
				Text tt = parse(boctx.text());
				g.add(tt.first(), tt.last(), false);
				t.append(tt);
			}
		}
		t.add(">", g, true);
		for (SectionContext sctx: ctx.blockContents().section()) {
			Text tt = parse(sctx);
			g.add(tt.first(), tt.last(), false);
			t.append(tt);
		}
		t.add("</>", g, true);
		return t;
	}
	
	public Text parse(PageContext ctx) {
		Text t = new Text();
		for (SectionContext sctx: ctx.section()) {
			t.append(parse(sctx));
		}
		return t;
	}
	
	@Override
	public void exitPage(PageContext ctx) {
		this.text = parse(ctx);
	}

	public Text get() {
		return this.text;
	}
}
