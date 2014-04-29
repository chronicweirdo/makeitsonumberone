package com.ingenuity.temp.apiupload;

import javax.swing.*;
import java.awt.*;

/**
 * Created by scacoveanu on 4/29/2014.
 */
public class UIUtil {

    public static GridBagConstraints constraints(int gridx, int gridy) {
        return constraints(gridx, gridy, 1, 1, 1, 1);
    }

    public static GridBagConstraints constraints(int gridx, int gridy, int weightx) {
        return constraints(gridx, gridy, 1, 1, weightx, 1);
    }

    public static GridBagConstraints constraints(int gridx, int gridy, int weight_width_x, int weight_width_y) {
            return constraints(gridx, gridy, weight_width_x, weight_width_y, weight_width_x, weight_width_y);
    }

    public static GridBagConstraints constraints(int gridx, int gridy, int gridwidth, int gridheight,
                                                 int weightx, int weighty) {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = gridx;
        constraints.gridy = gridy;
        constraints.gridwidth = gridwidth;
        constraints.gridheight = gridheight;
        constraints.weightx = weightx;
        constraints.weighty = weighty;
        constraints.fill = GridBagConstraints.BOTH;
        return constraints;
    }

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
