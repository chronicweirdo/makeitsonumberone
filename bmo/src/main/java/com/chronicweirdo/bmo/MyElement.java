package com.chronicweirdo.bmo;

import javax.swing.text.AttributeSet;
import javax.swing.text.Document;
import javax.swing.text.Element;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by scacoveanu on 4/14/2014.
 */
public class MyElement implements Element {

    private Document document;
    private Element parent;
    private String name;
    public AttributeSet attributes;
    public int start;
    public int end;
    private List<Element> children = new ArrayList<Element>();

    public MyElement(Document document, Element parent, String name, AttributeSet attributes,
                     int start, int end) {
        this.document = document;
        this.parent = parent;
        this.name = name;
        this.attributes = attributes;
        this.start = start;
        this.end = end;
    }

    @Override
    public Document getDocument() {
        return document;
    }

    @Override
    public Element getParentElement() {
        return parent;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public AttributeSet getAttributes() {
        return attributes;
    }

    @Override
    public int getStartOffset() {
        return start;
    }

    @Override
    public int getEndOffset() {
        return end;
    }

    @Override
    public int getElementIndex(int offset) {
        for (int i = 0; i < children.size(); i++) {
            if (children.get(i).getStartOffset() <= offset && offset <= children.get(i).getEndOffset()) {
                return i;
            }
        }
        return children.size()-1;
    }

    @Override
    public int getElementCount() {
        return children.size();
    }

    @Override
    public Element getElement(int index) {
        return children.get(index);
    }

    @Override
    public boolean isLeaf() {
        return children.size() == 0;
    }
}
