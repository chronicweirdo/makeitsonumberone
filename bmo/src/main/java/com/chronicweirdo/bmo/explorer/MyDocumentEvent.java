package com.chronicweirdo.bmo.explorer;

import javax.swing.event.DocumentEvent;
import javax.swing.text.Document;
import javax.swing.text.Element;

/**
 * Created by scacoveanu on 4/15/2014.
 */
public class MyDocumentEvent implements DocumentEvent {

    private int offset;
    private int length;
    private Document document;
    private EventType type;

    public MyDocumentEvent(int offset, int length, Document document, EventType type) {
        this.offset = offset;
        this.length = length;
        this.document = document;
        this.type = type;
    }

    @Override
    public int getOffset() {
        return offset;
    }

    @Override
    public int getLength() {
        return length;
    }

    @Override
    public Document getDocument() {
        return document;
    }

    @Override
    public EventType getType() {
        return type;
    }

    @Override
    public ElementChange getChange(Element elem) {
        return null;
    }
}
