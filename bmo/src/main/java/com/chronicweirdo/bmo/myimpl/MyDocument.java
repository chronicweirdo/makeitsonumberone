package com.chronicweirdo.bmo.myimpl;

import com.chronicweirdo.bmo.explorer.MyDocumentEvent;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.UndoableEditListener;
import javax.swing.text.*;
import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created by scacoveanu on 4/14/2014.
 */
public class MyDocument implements StyledDocument {

    private static final Logger log = LogManager.getLogger(MyDocument.class);

    private StringBuffer data = new StringBuffer();
    private Element root = new MyElement(this, null, "root", new SimpleAttributeSet(), 0, 0);
    private List<DocumentListener> documentListeners = new ArrayList<DocumentListener>();
    private List<UndoableEditListener> undoableEditListeners = new ArrayList<UndoableEditListener>();
    private Map<Object, Object> properties = new HashMap<Object, Object>();

    private MyElement getRoot() {
        return (MyElement) root;
    }

    public int getLength() {
        log.info("getting document length");
        return data.length();
    }

    public void addDocumentListener(DocumentListener listener) {
        log.info("adding document listener " + listener);
        documentListeners.add(listener);
    }

    public void removeDocumentListener(DocumentListener listener) {
        log.info("removing document listener");
        documentListeners.remove(listener);
    }

    public void addUndoableEditListener(UndoableEditListener listener) {
        log.info("adding undoable edit listener");
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
        log.info("putting property " + key + " = " + value);
        properties.put(key, value);
    }

    public void remove(int offs, int len) throws BadLocationException {
        log.info("removing offset " + offs + " length " + len);
        if (offs < 0) throw new BadLocationException("Start offset problem!", offs);
        if (offs + len > data.length()) throw new BadLocationException("End offset problem!", offs + len);
        data.delete(offs, offs + len);
        ((MyElement)root).start = 0;
        ((MyElement)root).end = data.length(); // must end right after the last element
    }

    public void insertString(int offset, String str, AttributeSet a) throws BadLocationException {
        log.info("inserting offset " + offset + " string <" + str + ">");
        if (offset < 0) throw new BadLocationException("Start offset problem!", offset);
        // TODO: handle attribute set
        data.insert(offset, str);
        ((MyElement)root).start = 0;
        ((MyElement)root).end = data.length(); // must end right after the last element
        System.out.println(data.toString());

        notifyInsert(new MyDocumentEvent(offset, str.length(), this, DocumentEvent.EventType.INSERT));
    }

    private void notifyInsert(DocumentEvent e) {
        log.info("notifying insert to listeners");
        for (DocumentListener listener: documentListeners) {
            listener.insertUpdate(e);
        }
    }

    public String getText(int offset, int length) throws BadLocationException {
        log.info("getting text offset " + offset + " length " + length);
        if (offset < 0) throw new BadLocationException("Start offset problem!", offset);
        if (offset + length > data.length()) throw new BadLocationException("End offset problem!", offset + length);
        return data.substring(offset, offset + length);
    }

    public void getText(int offset, int length, Segment txt) throws BadLocationException {
        log.info("getting text offset " + offset + " length " + length + " into segment " + txt.toString());
        if (offset < 0) throw new BadLocationException("Start offset problem!", offset);
        if (offset + length > data.length()) throw new BadLocationException("End offset problem!", offset + length);
        //log.info("get text in segment offset:" + offset + " length:" + length);
        txt.array = new char[length];
        data.getChars(offset, offset + length, txt.array, 0);
        //log.info("array: " + Arrays.toString(txt.array));
        txt.offset = 0; //offset;
        txt.count = length;
    }

    public Position getStartPosition() {
        log.info("getting start position");
        return new MyPosition(0);
    }

    public Position getEndPosition() {
        log.info("getting end position");
        return new MyPosition(data.length()-1);
    }

    public Position createPosition(int offset) throws BadLocationException {
        log.info("creating position offset " + offset);
        if (offset < 0 || offset >= data.length()) throw new BadLocationException("Start offset problem!", offset);
        return new MyPosition(offset);
    }

    public Element[] getRootElements() {
        log.info("getting root elements");
        return new Element[] {root};
    }

    public Element getDefaultRootElement() {
        log.info("getting default root element");
        return root;
    }

    public void render(Runnable r) {
        log.info("rendering");
        // TODO: handle rendering
        //readLock();
        try {
            r.run();
        } finally {
            //readUnlock();
        }
    }

    //////////////////////////////////////////////////////////////////////// STYLED DOCUMENT BELOW

    private StyleContext styleContext = new StyleContext();
    //private List<Style> styles = new ArrayList<Style>();
    //private Map<String, Style> namedStyles = new HashMap<String, Style>();

    public Style addStyle(String nm, Style parent) {
        log.info("adding style named " + nm);
        /*if (nm != null) {
            Style existing = namedStyles.get(nm);
            if (existing != null) styles.remove(existing);
            namedStyles.put(nm, parent);
        }
        styles.add(parent);*/
        return styleContext.addStyle(nm, parent);
        //return parent;
    }

    public void removeStyle(String nm) {
        log.info("removing style named " + nm);
        /*Style existing = namedStyles.get(nm);
        if (existing != null) {
            namedStyles.remove(nm);
            styles.remove(existing);
        }*/
        styleContext.removeStyle(nm);
    }

    public Style getStyle(String nm) {
        log.info("getting style named " + nm);
        //return namedStyles.get(nm);
        return styleContext.getStyle(nm);
    }

    public void setCharacterAttributes(int offset, int length, AttributeSet s, boolean replace) {
        log.info("setting character attributes offset " + offset + " length " + length);
        if (getRoot().attributes == null) {
            getRoot().attributes = s;
        } else {
            if (replace) {
                getRoot().attributes = s;
            }
        }
    }

    public void setParagraphAttributes(int offset, int length, AttributeSet s, boolean replace) {
        log.info("setting paragtaph attributes offset " + offset + " length " + length);
        setCharacterAttributes(offset, length, s, replace);
    }

    public void setLogicalStyle(int pos, Style s) {
        log.info("setting logical style position " + pos);
        // TODO: what is this?
    }

    public Style getLogicalStyle(int p) {
        log.info("getting logical style position " + p);
        return styleContext.getStyle(StyleContext.DEFAULT_STYLE);
        //return null; // TODO: get style from element
    }

    public Element getParagraphElement(int pos) {
        log.info("getting paragraph element position " + pos);
        return root;
    }

    public Element getCharacterElement(int pos) {
        log.info("getting character element position " + pos);
        return root;
    }

    public Color getForeground(AttributeSet attr) {
        log.info("getting foreground");
        return Color.BLACK;
    }

    public Color getBackground(AttributeSet attr) {
        log.info("getting background");
        return Color.WHITE;
    }

    public Font getFont(AttributeSet attr) {
        log.info("getting font");
        return getDefaultFont(); // TODO: don't be default
    }

    private Font getDefaultFont() {
        log.info("getting default font");
        GraphicsEnvironment environment = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Font[] fonts = environment.getAllFonts();
        if (fonts.length > 0) {
            Font font = fonts[0];
            return font.deriveFont(144f);
        }
        return null;
    }
}
