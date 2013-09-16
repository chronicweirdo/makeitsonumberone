package com.chronicweirdo.makeitso.console.simple;

import javax.swing.text.AttributeSet;
import javax.swing.text.Document;
import javax.swing.text.Element;

public class ConsoleElement implements Element {

	private Document document;
	private int index;
	private int start;
	private int end;
	
	public ConsoleElement(Document document, int index,
			int start, int end) {
		this.document = document;
		this.index = index;
		this.start = start;
		this.end = end;
	}
	
	@Override
	public Document getDocument() {
		return document;
	}

	@Override
	public Element getParentElement() {
		return null;
	}

	@Override
	public String getName() {
		return "line";
	}

	@Override
	public AttributeSet getAttributes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getStartOffset() {
		return start;
	}

	@Override
	public int getEndOffset() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getElementIndex(int offset) {
		return index;
	}

	@Override
	public int getElementCount() {
		return 0;
	}

	@Override
	public Element getElement(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isLeaf() {
		// TODO Auto-generated method stub
		return false;
	}

}
