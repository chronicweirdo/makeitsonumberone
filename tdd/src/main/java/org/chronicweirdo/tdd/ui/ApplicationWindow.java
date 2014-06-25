package org.chronicweirdo.tdd.ui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by scacoveanu on 6/25/2014.
 */
public class ApplicationWindow {

    private JFrame frmArtisol;
    private JButton btnBrowseDB;
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ApplicationWindow window = new ApplicationWindow();
                    window.frmArtisol = new JFrame();
                    window.frmArtisol.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
