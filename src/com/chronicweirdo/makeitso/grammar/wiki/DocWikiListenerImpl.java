package com.chronicweirdo.makeitso.grammar.wiki;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Document;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

import org.antlr.v4.runtime.tree.TerminalNode;

import com.chronicweirdo.makeitso.grammar.wiki.WikiParser.LinkContext;
import com.chronicweirdo.makeitso.grammar.wiki.WikiParser.PageContext;
import com.chronicweirdo.makeitso.grammar.wiki.WikiParser.TagContext;
import com.chronicweirdo.makeitso.grammar.wiki.WikiParser.TextContext;

public class DocWikiListenerImpl extends WikiBaseListener {

	private List<String> data = new ArrayList<String>();
	private DefaultStyledDocument doc = new DefaultStyledDocument();
	private SimpleAttributeSet normal;
	private SimpleAttributeSet tag;
	private SimpleAttributeSet link;
	
	public DocWikiListenerImpl() {
		normal = new SimpleAttributeSet();
		StyleConstants.setFontFamily(normal, "SansSerif");
        StyleConstants.setFontSize(normal, 16);
        
        tag = new SimpleAttributeSet(normal);
        StyleConstants.setBold(tag, true);
        StyleConstants.setForeground(tag, Color.green);
        
        link = new SimpleAttributeSet(normal);
        StyleConstants.setForeground(link, Color.blue);
	}
	
	@Override
	public void exitText(TextContext ctx) {
		System.out.println("text: " + ctx.getText());
		if (ctx.WORD() != null) {
			System.out.println("WORD: " + ctx.WORD().getText());
		} else if (ctx.SPACE() != null){
			System.out.println("SPACE: " + ctx.SPACE().getText() + ".");
		}
		try {
			doc.insertString(doc.getLength(), ctx.getText(),
			        normal);
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void exitTag(TagContext ctx) {
		super.exitTag(ctx);
		try {
			doc.insertString(doc.getLength(), ctx.getText(), tag);
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void exitLink(LinkContext ctx) {
		super.exitLink(ctx);
		
		String linkString = ctx.getText();
		System.out.println("linkString: " + linkString);
		try {
			doc.insertString(doc.getLength(), linkString, link);
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
	}

	public Document getDocument() {
		return this.doc;
	}

	@Override
	public void exitPage(PageContext ctx) {
		super.exitPage(ctx);
		//System.out.println("////////////////////");
		/*for (String s: data) {
			System.out.print(s);
		}*/
		/*try {
			System.out.println(doc.getText(0, doc.getLength()));
		} catch (BadLocationException e) {
			e.printStackTrace();
		}*/
	}

	
}
