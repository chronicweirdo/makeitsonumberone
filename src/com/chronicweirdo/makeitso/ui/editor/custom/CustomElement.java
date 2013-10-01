package com.chronicweirdo.makeitso.ui.editor.custom;

import javax.swing.text.AttributeSet;
import javax.swing.text.Document;
import javax.swing.text.Element;

public class CustomElement implements Element {

	private Document document;
	private AttributeSet attributes;
	private String text;
	
	public CustomElement(Document document, String text) {
		this.document = document;
		this.text = text;
	}
	
	public String getText(int offset, int length) {
		return this.text.substring(offset, offset+length);
	}
	
	@Override
	public AttributeSet getAttributes() {
		return this.attributes;
	}

	@Override
	public Document getDocument() {
		return this.document;
	}

	@Override
	// Fetches the child element at the given index.
	public Element getElement(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getElementCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	// Gets the child element index closest to the given offset.
	public int getElementIndex(int offset) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getEndOffset() {
		// TODO actual implementation
		return this.text.length();
	}

	@Override
	public String getName() {
		// TODO actual implementation
		return "basic element";
	}

	@Override
	public Element getParentElement() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getStartOffset() {
		return 0;
	}

	@Override
	public boolean isLeaf() {
		// TODO Auto-generated method stub
		return true;
	}

}
