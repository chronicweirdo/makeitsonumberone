package com.chronicweirdo.bmo.himpl;

import org.apache.log4j.Logger;

import javax.swing.event.DocumentListener;
import javax.swing.event.UndoableEditListener;
import javax.swing.text.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Silviu on 5/4/14.
 */
public class HDocument implements StyledDocument {

    private static final Logger log = Logger.getLogger(HDocument.class);

    private HElement element;
    private StyleContext styleContext = new StyleContext();
    //private Map<String, Style> styles;

    private List<DocumentListener> documentListeners = new ArrayList<DocumentListener>();
    private List<UndoableEditListener> undoableEditListeners = new ArrayList<UndoableEditListener>();

    private Map properties = new HashMap();


    public HDocument() {
        log.info("creating HDocument");
        this.element = new HElement(this);
    }

    public Style addStyle(String name, Style parent) {
        log.info("adding style with name " + name);
        Style newStyle = styleContext.addStyle(name, parent);
        return newStyle;
    }

    public void removeStyle(String name) {
        log.info("removing style with name " + name);
        styleContext.removeStyle(name);
    }

    public Style getStyle(String name) {
        log.info("retrieving style with name " + name);
        return styleContext.getStyle(name);
    }

    public void setCharacterAttributes(int offset, int length, AttributeSet s, boolean replace) {
        log.info("setting character attributes at offset " + offset + " and length " + length);
        // TODO: addint a style to some attributes results in a split
    }

    public void setParagraphAttributes(int offset, int length, AttributeSet s, boolean replace) {
        log.info("setting paragraph attributes at offset " + offset + " and length " + length);
        // TODO: setting a style on a paragraph
    }

    public void setLogicalStyle(int pos, Style s) {
        log.info("setting style at position " + pos);
        // TODO: set a style at some position
    }

    public Style getLogicalStyle(int p) {
        log.info("getting style at position " + p);
        // TODO: return correct style
        return styleContext.getStyle(StyleContext.DEFAULT_STYLE);
    }

    public Element getParagraphElement(int pos) {
        log.info("loading paragraph element at position " + pos);
        return element;
    }

    public Element getCharacterElement(int pos) {
        log.info("loading character element at position " + pos);
        return element;
    }

    public Color getForeground(AttributeSet attr) {
        log.info("getting foreground color");
        return Color.red;
    }

    public Color getBackground(AttributeSet attr) {
        log.info("getting background color");
        return Color.gray;
    }

    public Font getFont(AttributeSet attr) {
        log.info("getting font");
        return new Font("Verdana", Font.BOLD, 12);
    }

    public int getLength() {
        log.info("getting length");
        return element.getLength();
    }

    public void addDocumentListener(DocumentListener listener) {
        log.info("adding a new document listener: " + listener.toString());
        documentListeners.add(listener);
    }

    public void removeDocumentListener(DocumentListener listener) {
        log.info("removing document listener");
        documentListeners.remove(listener);
    }

    public void addUndoableEditListener(UndoableEditListener listener) {
        log.info("adding a new undoable edit listener: " + listener.toString());
        undoableEditListeners.add(listener);
    }

    public void removeUndoableEditListener(UndoableEditListener listener) {
        log.info("removing undoable edit listener");
        undoableEditListeners.remove(listener);
    }

    public Object getProperty(Object key) {
        log.info("getting property " + key);
        return properties.get(key);
    }

    public void putProperty(Object key, Object value) {
        log.info("adding property " + key + " with value " + value);
        properties.put(key, value);
    }

    public void remove(int offset, int length) throws BadLocationException {
        log.info("removing text at offset " + offset + " of length " + length);
        element.remove(offset, length);
    }

    public void insertString(int offset, String string, AttributeSet a) throws BadLocationException {
        log.info("inserting text " + string + " at offset " + offset);
        element.insert(offset, string);
    }

    public String getText(int offset, int length) throws BadLocationException {
        log.info("getting text at offset " + offset + " of length " + length);
        return element.getText().substring(offset, offset+length);
    }

    public void getText(int offset, int length, Segment segment) throws BadLocationException {
        log.info("getting text at offset " + offset + " of length " + length + " into segment");
        element.getText(offset, length, segment);
    }

    public Position getStartPosition() {
        log.info("getting start position");
        return new HPosition(0);
    }

    public Position getEndPosition() {
        log.info("getting end position");
        return new HPosition(element.getLength());
    }

    public Position createPosition(int offs) throws BadLocationException {
        log.info("creating position " + offs);
        return new HPosition(offs);
    }

    public Element[] getRootElements() {
        log.info("getting root elements");
        return new Element[] {element};
    }

    public Element getDefaultRootElement() {
        log.info("getting default root element");
        return element;
    }

    public void render(Runnable r) {
        log.info("rendering");
        //readLock();
        try {
            r.run();
        } finally {
            //readUnlock();
        }
    }
}
