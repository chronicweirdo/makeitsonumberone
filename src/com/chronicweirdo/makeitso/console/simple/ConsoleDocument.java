package com.chronicweirdo.makeitso.console.simple;

import javax.swing.event.DocumentListener;
import javax.swing.event.UndoableEditListener;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.Element;
import javax.swing.text.Position;
import javax.swing.text.Segment;

public class ConsoleDocument implements Document {

	private String text;
	
	@Override
	public int getLength() {
		return text.length();
	}

	@Override
	public void addDocumentListener(DocumentListener listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeDocumentListener(DocumentListener listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addUndoableEditListener(UndoableEditListener listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeUndoableEditListener(UndoableEditListener listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public Object getProperty(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void putProperty(Object key, Object value) {
		// TODO Auto-generated method stub

	}

	@Override
	public void remove(int offs, int len) throws BadLocationException {
		text = text.substring(0, offs) + text.substring(offs+len, text.length());
	}

	@Override
	public void insertString(int offset, String str, AttributeSet a)
			throws BadLocationException {
		text = text.substring(0, offset) + str + text.substring(offset, text.length());
	}

	@Override
	public String getText(int offset, int length) throws BadLocationException {
		return text.substring(offset, offset+length);
	}

	@Override
	public void getText(int offset, int length, Segment txt)
			throws BadLocationException {
		// TODO Auto-generated method stub

	}

	@Override
	public Position getStartPosition() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Position getEndPosition() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Position createPosition(int offs) throws BadLocationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Element[] getRootElements() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Element getDefaultRootElement() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void render(Runnable r) {
		// TODO Auto-generated method stub

	}

}
