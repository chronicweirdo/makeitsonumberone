package com.chronicweirdo.makeitso.myeditor.doc;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.event.DocumentListener;
import javax.swing.event.UndoableEditListener;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Element;
import javax.swing.text.Position;
import javax.swing.text.Segment;
import javax.swing.text.Style;
import javax.swing.text.StyledDocument;

public class QDocument implements StyledDocument {
	
	private AbstractDocument gateway;
	
	private StringBuffer text;

	@Override
	public Style addStyle(String arg0, Style arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Color getBackground(AttributeSet arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Element getCharacterElement(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Font getFont(AttributeSet arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Color getForeground(AttributeSet arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Style getLogicalStyle(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Element getParagraphElement(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Style getStyle(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeStyle(String arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setCharacterAttributes(int arg0, int arg1, AttributeSet arg2,
			boolean arg3) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setLogicalStyle(int arg0, Style arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setParagraphAttributes(int arg0, int arg1, AttributeSet arg2,
			boolean arg3) {
		// TODO Auto-generated method stub

	}

	private List<DocumentListener> documentListeners = new ArrayList<DocumentListener>();
	
	@Override
	public void addDocumentListener(DocumentListener arg0) {
		documentListeners.add(arg0);
	}

	private List<UndoableEditListener> undoableEditListeners = new ArrayList<UndoableEditListener>();
	
	@Override
	public void addUndoableEditListener(UndoableEditListener arg0) {
		undoableEditListeners.add(arg0);
	}

	@Override
	public Position createPosition(int arg0) throws BadLocationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Element getDefaultRootElement() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Position getEndPosition() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getLength() {
		return text.length();
	}

	@Override
	public Object getProperty(Object arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Element[] getRootElements() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Position getStartPosition() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getText(int offset, int length) throws BadLocationException {
		if (offset < 0) throw new BadLocationException("Bad location", offset);
		if (offset >= getLength()) throw new BadLocationException("Bad location", getLength());
		if (offset + length < 0) throw new BadLocationException("Bad location", offset + length);
		if (offset + length >= getLength()) throw new BadLocationException("Bad location", offset + length);
		return text.substring(offset, offset + length);
	}

	@Override
	public void getText(int offset, int length, Segment txt)
			throws BadLocationException {
		// TODO Auto-generated method stub

	}

	@Override
	public void insertString(int arg0, String arg1, AttributeSet arg2)
			throws BadLocationException {
		// TODO Auto-generated method stub

	}

	@Override
	public void putProperty(Object arg0, Object arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void remove(int arg0, int arg1) throws BadLocationException {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeDocumentListener(DocumentListener arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeUndoableEditListener(UndoableEditListener arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void render(Runnable arg0) {
		// TODO Auto-generated method stub

	}

}
