package com.chronicweirdo.makeitso.ui.editor;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Document;
import javax.swing.text.Element;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import com.chronicweirdo.makeitso.file.FileUtils;
import com.chronicweirdo.makeitso.ui.Wrapper;

public class DocumentTest {

	private static void printDocument(Document doc) {
		System.out.println("doc class: " + doc.getClass().getCanonicalName());
		System.out.println("doc.getLength(): " + doc.getLength());
		System.out.println("doc.getRootElements().length: "+ doc.getRootElements().length);
		//for (Element el: doc.getRootElements()) {
		Element el = doc.getDefaultRootElement();
		printElement(el, 0);
		//}
	}
	
	private static void printTabs(int tabs) {
		for (int i = 0; i < tabs; i++) System.out.print("\t");
	}
	private static void printElement(Element el, int depth) {
		printTabs(depth);System.out.println("element name: " + el.getName());
		printTabs(depth);System.out.println("element class: " + el.getClass().getCanonicalName());
		printTabs(depth);System.out.println("element offesets: " + el.getStartOffset() + " to " + el.getEndOffset());
		printTabs(depth);System.out.println("element children: " + el.getElementCount());
		for (int i = 0; i < el.getElementCount(); i++) {
			printElement(el.getElement(i), depth+1);
		}
	}
	
	private static Document buildDocument() {
		DefaultStyledDocument doc = new DefaultStyledDocument();
		//doc.
		//SectionElement el = (SectionElement) doc.getDefaultRootElement();
		//DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		//builder.newDocument();
		return doc;
	}
	private static Document initDocument() {
		DefaultStyledDocument doc = new DefaultStyledDocument();
        String initString[] =
                { "Use the mouse to place the caret.",
                  "Use the edit menu to cut, copy, paste, and select text.",
                  "Also to undo and redo changes.",
                  "Use the style menu to change the style of the text.",
                  "Use the arrow keys on the keyboard or these emacs key bindings to move the caret:",
                  "Ctrl-f, Ctrl-b, Ctrl-n, Ctrl-p." };

        SimpleAttributeSet[] attrs = initAttributes(initString.length);

        try {
            for (int i = 0; i < initString.length; i ++) {
                doc.insertString(doc.getLength(), initString[i] + "\n",
                        attrs[i]);
            }
        } catch (BadLocationException ble) {
            System.err.println("Couldn't insert initial text.");
        }
        doc.setCharacterAttributes(10, 5, attrs[5], true);
        doc.setCharacterAttributes(0, 34, attrs[0], true);
        return doc;
    }

    private static SimpleAttributeSet[] initAttributes(int length) {
        //Hard-code some attributes.
        SimpleAttributeSet[] attrs = new SimpleAttributeSet[length];

        attrs[0] = new SimpleAttributeSet();
        StyleConstants.setFontFamily(attrs[0], "SansSerif");
        StyleConstants.setFontSize(attrs[0], 16);

        attrs[1] = new SimpleAttributeSet(attrs[0]);
        StyleConstants.setBold(attrs[1], true);

        attrs[2] = new SimpleAttributeSet(attrs[0]);
        StyleConstants.setItalic(attrs[2], true);

        attrs[3] = new SimpleAttributeSet(attrs[0]);
        StyleConstants.setFontSize(attrs[3], 20);

        attrs[4] = new SimpleAttributeSet(attrs[0]);
        StyleConstants.setFontSize(attrs[4], 12);

        attrs[5] = new SimpleAttributeSet(attrs[0]);
        StyleConstants.setForeground(attrs[5], Color.red);

        return attrs;
    }
	private static void show1(String path) {
		JPanel panel = new JPanel();
		final JTextPane editor = new JTextPane();
		editor.setPreferredSize(new Dimension(400, 400));
		//editor.setText(FileUtils.readTextFile(path));
		editor.setDocument(initDocument());
		editor.addKeyListener(new KeyAdapter() {

			@Override
			public void keyTyped(KeyEvent arg0) {
				printDocument(editor.getDocument());
			}
			
		});
		printDocument(editor.getDocument());
		panel.add(editor);
		Wrapper.wrap("document testing area", panel);
	}
	
	public static void main(String[] args) {
		String path = "/Users/cacovean/Dropbox/mydata/wiki/todo_tech.txt";
		show1(path);
	}

}
