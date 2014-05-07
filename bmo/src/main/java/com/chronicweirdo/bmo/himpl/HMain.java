package com.chronicweirdo.bmo.himpl;

import com.chronicweirdo.bmo.progressive.HTMLEditorUtil;
import org.apache.log4j.Logger;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import java.io.IOException;

/**
 * Created by Silviu on 5/4/14.
 */
public class HMain {

    private static final Logger log = Logger.getLogger(HMain.class);

    public static void main(String[] args) {
        String html = "<html><body><div>hello</div></body></html>";

        log.info("creating JEditorPane");
        JEditorPane area = new JEditorPane();
        log.info("creating HDocument");
        HDocument hDocument = new HDocument();
        log.info("setting HDocument on JEditorPane");
        area.setDocument(hDocument);
        area.updateUI();
        log.info("setting JEditorPane text");
        //area.setText("test text");
        try {
            hDocument.insertString(0, "test text", new SimpleAttributeSet());
        } catch (BadLocationException e) {
            e.printStackTrace();
        }

        log.info("showing GUI");
        HTMLEditorUtil.createAndShowGUI("HDocument", null, HTMLEditorUtil.scrollable(area, 500, 500));
    }
}
