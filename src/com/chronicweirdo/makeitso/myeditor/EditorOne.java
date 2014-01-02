package com.chronicweirdo.makeitso.myeditor;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class EditorOne extends JPanel {
	
	private static final String DUMMY_TEXT = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec a diam lectus. Sed sit amet ipsum mauris. Maecenas congue ligula ac quam viverra nec consectetur ante hendrerit. Donec et mollis dolor. Praesent et diam eget libero egestas mattis sit amet vitae augue. Nam tincidunt congue enim, ut porta lorem lacinia consectetur. Donec ut libero sed arcu vehicula ultricies a non tortor. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean ut gravida lorem. Ut turpis felis, pulvinar a semper sed, adipiscing id dolor. Pellentesque auctor nisi id magna consequat sagittis. Curabitur dapibus enim sit amet elit pharetra tincidunt feugiat nisl imperdiet. Ut convallis libero in urna ultrices accumsan. Donec sed odio eros. Donec viverra mi quis quam pulvinar at malesuada arcu rhoncus. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. In rutrum accumsan ultricies. Mauris vitae nisi at sem facilisis semper ac in est.";
	private static final String WINDOW_TITLE = "Editor One";
	private static final int WINDOW_WIDTH = 500;
	private static final int WINDOW_HEIGHT = 500;
	
	private JTextArea textArea;
	
	public EditorOne() {
		super(new GridBagLayout());

        textArea = new JTextArea(/*30, 100*/);
        textArea.setText(DUMMY_TEXT);
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setBackground(Color.BLACK);
        textArea.setForeground(Color.GREEN);
        Font font = new Font("monospaced", Font.PLAIN, 20);
        textArea.setFont(font);
        JScrollPane scrollPane = new JScrollPane(textArea);

        //Add Components to this panel.
        GridBagConstraints c = new GridBagConstraints();
        c.gridwidth = GridBagConstraints.REMAINDER;

        //c.fill = GridBagConstraints.BOTH;
        //add(textField, c);

        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1.0;
        c.weighty = 1.0;
        add(scrollPane, c);
        
        printSize();
        this.addComponentListener(new ComponentListener() {
			
			@Override
			public void componentShown(ComponentEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void componentResized(ComponentEvent arg0) {
				printSize();
			}
			
			@Override
			public void componentMoved(ComponentEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void componentHidden(ComponentEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
	private void printSize() {
		System.out.println(textArea.getLineCount() + " " + textArea.getColumns());
	}
	
	private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame(WINDOW_TITLE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));

        //Add contents to the window.
        frame.add(new EditorOne());

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
	}

}
