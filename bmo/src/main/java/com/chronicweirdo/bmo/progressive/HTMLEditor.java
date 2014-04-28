package com.chronicweirdo.bmo.progressive;

import com.chronicweirdo.bmo.MyDocument;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Element;
import javax.swing.text.StyledDocument;
import javax.swing.text.html.HTMLDocument;
import java.awt.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Silviu on 4/8/14.
 */
public class HTMLEditor {
    public static void main(String[] args) {
        String html = "<html><body><div>hello</div></body></html>";

        /*JTextArea area = new JTextArea();
        area.setDocument(new HTMLDocument());
        area.setText(html);*/
        JEditorPane area = new JEditorPane();
        try {
            area.setPage("http://docs.oracle.com/javase/tutorial/uiswing/components/editorpane.html");
            //area.setPage(new URL("file://page1.html"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        HTMLEditorUtil.createAndShowGUI("HTMLEditor1", null, HTMLEditorUtil.scrollable(area, 500, 500));
    }
}
