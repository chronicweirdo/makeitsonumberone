package com.chronicweirdo.bmo.progressive;

import javax.swing.*;
import java.awt.*;

/**
 * Created by scacoveanu on 4/28/2014.
 */
public class HTMLEditorUtil {

    public static JScrollPane scrollable(JComponent component, int width, int height) {
        JScrollPane scrollPane = new JScrollPane(component);
        scrollPane.setPreferredSize(new Dimension(width, height));
        return scrollPane;
    }

    public static void createAndShowGUI(final String applicationName,
                                        final JComponent northComponent,
                                        final JComponent centerComponent) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                //Create and set up the window.
                JFrame frame = new JFrame(applicationName);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.getContentPane().setLayout(new BorderLayout());

                //Add the components
                if (northComponent != null) {
                    frame.getContentPane().add(northComponent, BorderLayout.NORTH);
                }
                frame.getContentPane().add(centerComponent, BorderLayout.CENTER);

                //Display the window.
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}
