package com.chronicweirdo.makeitso.ui.editor.custom;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.event.DocumentListener;
import javax.swing.event.UndoableEditListener;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.Element;
import javax.swing.text.Position;
import javax.swing.text.Segment;

public class CustomDocument implements Document {

	private List<DocumentListener> documentListeners = new ArrayList<DocumentListener>();
	private List<UndoableEditListener> undoableEditListeners = new ArrayList<UndoableEditListener>();
	private CustomElement root;
	private Map<Object, Object> properties = new HashMap<Object, Object>();
	
	public CustomDocument(String text) {
		this.root = new CustomElement(this, text);
	}
	
	@Override
	public void addDocumentListener(DocumentListener listener) {
		this.documentListeners.add(listener);
	}

	@Override
	public void addUndoableEditListener(UndoableEditListener listener) {
		this.undoableEditListeners.add(listener);
	}

	@Override
	public Position createPosition(int offset) throws BadLocationException {
		// TODO throw exception if offset not in text
		return new CustomPosition(offset);
	}

	@Override
	public Element getDefaultRootElement() {
		return this.root;
	}

	@Override
	public Position getEndPosition() {
		return new CustomPosition(this.root.getEndOffset());
	}

	@Override
	public int getLength() {
		return this.root.getEndOffset();
	}

	@Override
	public Object getProperty(Object key) {
		return this.properties.get(key);
	}

	@Override
	public Element[] getRootElements() {
		return new Element[] {this.root};
	}

	@Override
	public Position getStartPosition() {
		return new CustomPosition(this.root.getStartOffset());
	}

	@Override
	public String getText(int offset, int length) throws BadLocationException {
		// TODO Auto-generated method stub
		// Fetches the text contained within the given portion of the document.
		return this.root.getText(offset, length);
	}

	@Override
	public void getText(int offset, int length, Segment text)
			throws BadLocationException {
		// TODO Auto-generated method stub
		// Fetches the text contained within the given portion of the document.
		// text - the Segment object to return the text in
		String t = this.root.getText(offset, length);
		System.out.println("Segment class: " + text.getClass().getCanonicalName());
	}

	@Override
	public void insertString(int offset, String string, AttributeSet attributes)
			throws BadLocationException {
		// TODO Auto-generated method stub
		// Inserts a string of content.
	}

	@Override
	public void putProperty(Object key, Object value) {
		this.properties.put(key, value);
	}

	@Override
	public void remove(int offset, int length) throws BadLocationException {
		// TODO Auto-generated method stub
		// Removes a portion of the content of the document.
	}

	@Override
	public void removeDocumentListener(DocumentListener listener) {
		this.documentListeners.remove(listener);
	}

	@Override
	public void removeUndoableEditListener(UndoableEditListener listener) {
		this.undoableEditListeners.remove(listener);
	}

	@Override
	public void render(Runnable arg0) {
		// TODO Auto-generated method stub

	}

}
