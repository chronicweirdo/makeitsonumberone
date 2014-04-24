package com.chronicweirdo.makeitso.console.simple;

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
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Element;
import javax.swing.text.PlainDocument;

public class TestTextArea extends JPanel {
	
	
	
	private JTextArea displayTextArea;
	private JTextArea commandTextArea;
	
	public TestTextArea() {
		super(new GridBagLayout());

		PlainDocument document = new PlainDocument();
        displayTextArea = new JTextArea(document/*10, 10*/);
        //textArea.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec a diam lectus. Sed sit amet ipsum mauris. Maecenas congue ligula ac quam viverra nec consectetur ante hendrerit. Donec et mollis dolor. Praesent et diam eget libero egestas mattis sit amet vitae augue. Nam tincidunt congue enim, ut porta lorem lacinia consectetur. Donec ut libero sed arcu vehicula ultricies a non tortor. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean ut gravida lorem. Ut turpis felis, pulvinar a semper sed, adipiscing id dolor. Pellentesque auctor nisi id magna consequat sagittis. Curabitur dapibus enim sit amet elit pharetra tincidunt feugiat nisl imperdiet. Ut convallis libero in urna ultrices accumsan. Donec sed odio eros. Donec viverra mi quis quam pulvinar at malesuada arcu rhoncus. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. In rutrum accumsan ultricies. Mauris vitae nisi at sem facilisis semper ac in est.");
        displayTextArea.setText("testText\nlinetwo\n");
        displayTextArea.setEditable(true);
        displayTextArea.setLineWrap(true);
        displayTextArea.setBackground(Color.BLACK);
        displayTextArea.setForeground(Color.GREEN);
        Font font = new Font("monospaced", Font.PLAIN, 20);
        displayTextArea.setFont(font);
        JScrollPane scrollPane = new JScrollPane(displayTextArea);
        
        //commandTextArea = new JTextArea(1, 10);

        //Add Components to this panel.
        GridBagConstraints c = new GridBagConstraints();
        c.gridwidth = GridBagConstraints.REMAINDER;

        //c.fill = GridBagConstraints.BOTH;
        //add(textField, c);

        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1.0;
        c.weighty = 1.0;
        add(scrollPane, c);
        
        //printSize();
        System.out.println(document.getRootElements().length);
        
        document.addDocumentListener(new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {
				int elnum = e.getDocument().getRootElements().length;
				for (Element el: e.getDocument().getRootElements()) {
					System.out.println(el.getElementCount() + ": " + el.toString());
				}
				Element lastLine = e.getDocument().getRootElements()[elnum-1];
				System.out.println(e.getType());
				System.out.println(e.getOffset() + " " + e.getLength());
				System.out.println(elnum);
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				
			}
        	
        });
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
		System.out.println(displayTextArea.getLineCount() + " " + displayTextArea.getColumns());
	}
	
	private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("ConsoleDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Add contents to the window.
        frame.setPreferredSize(new Dimension(500, 500));
        frame.add(new TestTextArea());

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
