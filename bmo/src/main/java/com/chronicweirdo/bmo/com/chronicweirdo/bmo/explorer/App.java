package com.chronicweirdo.bmo.com.chronicweirdo.bmo.explorer;

import javax.swing.*;
import javax.swing.text.*;
import javax.swing.text.html.HTMLEditorKit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * The original structure editor was taken from http://java-sl.com/JEditorPaneStructureTool.html
 * Thank you Stanislav Lapitsky (http://java-sl.com/about_author.html)!
 */
public class App extends JFrame {
    /*public static String htmlStr="<html>\n" +
            "<head><title>Example\n" +
            "</title></head>\n" +
            "<body>\n" +
            "<p>It's a JEditorPane with HTML. It could be plain text. Also the paragraph may contain attributed text e.g. <b>bold</b> or <i>italic<i>. </p>\n"+
            "<table align=\"left\" width=\"200px\" border='1'>\n" +
            "  <tr><td>inner 1:1</td><td>inner 1:2</td></tr>\n" +
            "  <tr><td>inner 2:1</td><td>inner 2:2</td></tr>\n" +
            "  <tr><td>inner 3:1</td><td>inner 3:2</td></tr>\n" +
            " </table>\n"+
            "</body>\n" +
            "</html>\n";*/
    JEditorPane edit=new JEditorPane();
    JTextArea editSrc=new JTextArea();
    EditorPaneStructure info;

    public static void main(String[] args) {
        String html = null;
        try {
            html = new String(Files.readAllBytes(Paths.get("src", "main", "resources",
                    "small.html")));
            System.out.println(html);
        } catch (IOException e) {
            e.printStackTrace();
        }

        final App app = new App(html);

        app.setSize(750, 550);
        app.setLocationRelativeTo(null);
        app.setExtendedState(JFrame.MAXIMIZED_BOTH);
        app.setVisible(true);

        final Timer t=new Timer(300, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ((Timer)e.getSource()).stop();
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        app.info.refresh();
                    }
                });
            }
        });

        t.start();
    }

    public App(String htmlStr) {
        super("Editor pane structures example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        edit.setEditorKit(new HTMLEditorKit());
        edit.setContentType("text/html");

        edit.setText(htmlStr);

        JScrollPane scroll = new JScrollPane(edit);
        final JTabbedPane tbPane=new JTabbedPane();
        tbPane.add("HTML", scroll);
        scroll = new JScrollPane(editSrc);
        editSrc.setText(htmlStr);
        JPanel pnl=new JPanel(new BorderLayout());
        pnl.add(scroll, BorderLayout.CENTER);
        JPanel pnlButtons=new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton btnShow=new JButton("Show HTML");
        btnShow.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                edit.setText(editSrc.getText());
                tbPane.setSelectedIndex(0);
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        info.refresh();
                    }
                });
            }
        });
        pnlButtons.add(btnShow);
        pnl.add(pnlButtons, BorderLayout.SOUTH);
        tbPane.add("Source", pnl);

        info=new EditorPaneStructure(edit);
        JSplitPane split=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, tbPane, new JScrollPane(info));
        split.setDividerLocation(300);
        getContentPane().add(split);
    }
}
