package com.chronicweirdo.makeitso.grammar.wiki;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Document;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

import com.chronicweirdo.makeitso.grammar.wiki.WikiParser.PageContext;
import com.chronicweirdo.makeitso.grammar.wiki.WikiParser.TagContext;
import com.chronicweirdo.makeitso.grammar.wiki.WikiParser.TextContext;

public class WikiListenerImpl extends WikiBaseListener {

	private List<String> data = new ArrayList<String>();
	private DefaultStyledDocument doc = new DefaultStyledDocument();
	private SimpleAttributeSet normal;
	private SimpleAttributeSet tag;
	
	public WikiListenerImpl() {
		normal = new SimpleAttributeSet();
		StyleConstants.setFontFamily(normal, "SansSerif");
        StyleConstants.setFontSize(normal, 16);
        
        tag = new SimpleAttributeSet(normal);
        StyleConstants.setBold(tag, true);
        StyleConstants.setForeground(tag, Color.green);
	}
	
	@Override
	public void exitText(TextContext ctx) {
		super.exitText(ctx);
		data.add(ctx.getText());
		System.out.println(ctx.getText());
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
		data.add(ctx.getText());
		System.out.println(ctx.getText());
		try {
			doc.insertString(doc.getLength(), ctx.getText(),
			        tag);
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
		System.out.println("////////////////////");
		/*for (String s: data) {
			System.out.print(s);
		}*/
		try {
			System.out.println(doc.getText(0, doc.getLength()));
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
	}

	
}
