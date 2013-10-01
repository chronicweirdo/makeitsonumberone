package com.chronicweirdo.makeitso.ui.editor.custom;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Document;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

import com.chronicweirdo.makeitso.ui.Wrapper;

public class CustomDocumentTest {

	private static Document initCustomDocument() {
		return new CustomDocument("This is a custom document");
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
	private static void show1() {
		JPanel panel = new JPanel();
		final JTextPane editor = new JTextPane();
		//editor.setDocument(initDocument());
		editor.setDocument(initCustomDocument());
		editor.setPreferredSize(new Dimension(400, 400));
		JScrollPane scroll = new JScrollPane(editor);
		panel.add(scroll);
		Wrapper.wrap("custom document testing area", panel);
	}
	
	public static void main(String[] args) {
		show1();
	}

}
