package com.chronicweirdo.makeitso.ui.editor;

import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.text.Document;
import javax.swing.text.Element;

import com.chronicweirdo.makeitso.file.FileUtils;
import com.chronicweirdo.makeitso.ui.Wrapper;

public class DocumentTest {

	private static void printDocument(Document doc) {
		System.out.println("doc class: " + doc.getClass().getCanonicalName());
		System.out.println("doc.getLength(): " + doc.getLength());
		System.out.println("doc.getRootElements().length: "+ doc.getRootElements().length);
		for (Element el: doc.getRootElements()) {
			System.out.println("element name: " + el.getName());
			System.out.println("element offesets: " + el.getStartOffset() + " to " + el.getEndOffset());
			System.out.println("element children: " + el.getElementCount());
		}
	}
	private static void show1(String path) {
		JPanel panel = new JPanel();
		final JTextPane editor = new JTextPane();
		editor.setPreferredSize(new Dimension(400, 400));
		editor.setText(FileUtils.readTextFile(path));
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
