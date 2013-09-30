package com.chronicweirdo.makeitso.ui.editor;

import java.awt.Color;
import java.awt.Font;

import javax.swing.event.DocumentListener;
import javax.swing.event.UndoableEditListener;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Element;
import javax.swing.text.Position;
import javax.swing.text.Segment;
import javax.swing.text.Style;
import javax.swing.text.StyledDocument;

public class SourceStyledDocument implements StyledDocument {

	@Override
	public void addDocumentListener(DocumentListener listener) {
		// TODO Auto-generated method stub
	}

	@Override
	public void addUndoableEditListener(UndoableEditListener listener) {
		// TODO Auto-generated method stub
	}

	@Override
	public Position createPosition(int offs) throws BadLocationException {
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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getProperty(Object key) {
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void getText(int offset, int length, Segment txt)
			throws BadLocationException {
		// TODO Auto-generated method stub

	}

	@Override
	public void insertString(int offset, String str, AttributeSet a)
			throws BadLocationException {
		// TODO Auto-generated method stub

	}

	@Override
	public void putProperty(Object key, Object value) {
		// TODO Auto-generated method stub

	}

	@Override
	public void remove(int offs, int len) throws BadLocationException {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeDocumentListener(DocumentListener listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeUndoableEditListener(UndoableEditListener listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public void render(Runnable r) {
		// TODO Auto-generated method stub

	}

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

}
