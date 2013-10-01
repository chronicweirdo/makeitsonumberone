package com.chronicweirdo.makeitso.ui.editor.custom;

import java.util.ArrayList;
import java.util.List;

import javax.swing.text.AttributeSet;
import javax.swing.text.Document;
import javax.swing.text.Element;

import com.chronicweirdo.makeitso.grammar.wiki.text.Section;

public class SourceElement implements Element {
	
	private Document document;
	private Element parent;
	
	private List<Element> elements;
	
	private int endOffset;
	private int startOffset;
	
	private Section section;
	
	public SourceElement(Document document, Element parent, Section section) {
		this.document = document;
		this.parent = parent;
		this.elements = new ArrayList<Element>();
		this.endOffset = 0;
		this.startOffset = 0;
		this.section = section;
	}

	@Override
	public AttributeSet getAttributes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Document getDocument() {
		return this.document;
	}

	@Override
	public Element getElement(int i) {
		return this.elements.get(i);
	}

	@Override
	public int getElementCount() {
		return this.elements.size();
	}

	@Override
	public int getElementIndex(int index) {
		for (int i = 0; i < this.elements.size(); i++) {
			Element element = this.elements.get(i);
			if (element.getStartOffset() <= index && index < element.getEndOffset()) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public int getEndOffset() {
		if (isLeaf()) {
			return this.endOffset;
		} else {
			return lastElement().getEndOffset();
		}
	}
	
	private Element firstElement() {
		if (this.elements == null || this.elements.size() == 0) return null;
		return this.elements.get(0);
	}
	
	private Element lastElement() {
		if (this.elements == null || this.elements.size() == 0) return null;
		return this.elements.get(this.elements.size()-1);
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Element getParentElement() {
		return this.parent;
	}

	@Override
	public int getStartOffset() {
		if (isLeaf()) {
			return this.startOffset;
		} else {
			return firstElement().getStartOffset();
		}
	}

	@Override
	public boolean isLeaf() {
		return this.elements.size() == 0;
	}

}
