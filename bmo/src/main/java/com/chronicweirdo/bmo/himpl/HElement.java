package com.chronicweirdo.bmo.himpl;

import com.sun.org.omg.SendingContext._CodeBaseImplBase;

import javax.swing.text.*;

/**
 * Created by Silviu on 5/4/14.
 */
public class HElement implements Element {

    private StringBuilder data;
    private Document document;
    private Element parent;
    private String name;
    private AttributeSet attributeSet;

    public HElement(Document document) {
        this.document = document;
        this.name = "theonlyelement";
        this.attributeSet = new SimpleAttributeSet();
        this.parent = null;
        data = new StringBuilder();
    }

    public String getText() {
        return data.toString();
    }

    public int getLength() {
        return data.length();
    }

    public Document getDocument() {
        return document;
    }

    public Element getParentElement() {
        return parent;
    }

    public String getName() {
        return name;
    }

    public AttributeSet getAttributes() {
        return attributeSet;
    }

    public int getStartOffset() {
        return 0;
    }

    public int getEndOffset() {
        return data.length();
    }

    public int getElementIndex(int offset) {
        return -1; // leaf
    }

    public int getElementCount() {
        return 0; // leaf
    }

    public Element getElement(int index) {
        return null;
    }

    public boolean isLeaf() {
        return true;
    }

    public void remove(int offset, int length) {
        data.replace(offset, offset+length, "");
    }

    public void insert(int offset, String string) {
        data.insert(offset, string);
    }

    public void getText(int offset, int length, Segment segment) {
        segment.array = new char[length];
        data.getChars(offset, offset + length, segment.array, 0);
        segment.count = length;
        segment.offset = 0;
    }
}
