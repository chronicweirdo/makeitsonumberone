package com.chronicweirdo.bmo.myimpl;

import javax.print.attribute.HashAttributeSet;
import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Silviu on 4/8/14.
 */
public class MyMain {
    private static final String APPLICATION_NAME = "BMO";

    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame(APPLICATION_NAME);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.getContentPane().setLayout(new BorderLayout());

        //Add the ubiquitous "Hello World" label.
        JLabel label = new JLabel(APPLICATION_NAME);
        frame.getContentPane().add(label, BorderLayout.NORTH);

        // add a text pane
        JTextPane pane = new JTextPane();
        pane.setBackground(Color.black);
        pane.setCaretColor(Color.white);
        System.out.println(pane.getStyledDocument().getClass());
        try {
            SimpleAttributeSet set = new SimpleAttributeSet();
            StyleConstants.setFontFamily(set, "SansSerif");
            StyleConstants.setFontSize(set, 16);
            StyleConstants.setForeground(set, Color.white);
            //StyleConstants.setBackground(set, Color.black);
            pane.getDocument().insertString(0, "yo!", set);
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
        //printDocument(pane.getStyledDocument());

        JScrollPane scrollPane = new JScrollPane(pane);
        scrollPane.setPreferredSize(new Dimension(500, 500));
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    private static void printDocument(StyledDocument doc) {
        for (Element el: doc.getRootElements()) {
            printElement(el);
        }
    }

    private static void printElement(Element el) {
        System.out.println(el.toString());
        for (int i = 0; i < el.getElementCount(); i++) {
            printElement(el.getElement(i));
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
