package com.chronicweirdo.bmo;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Element;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Silviu on 4/8/14.
 */
public class Main {
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

        URL fileUrl = null;
        try {
            fileUrl = new URL("http://docs.oracle.com/javase/tutorial/uiswing/components/editorpane.html");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        JTextPane pane = new JTextPane();
        //pane.setText("This is a long text in a text pane");
        /*try {
            pane.setPage(fileUrl);
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        pane.setDocument(new MyDocument());
        try {
            pane.getDocument().insertString(0, "yo!", null);
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
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
