package com.freedompay.fileCompare;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

/**
 * 
 * @author 	MGries
 * @version 1.0
 * @since	1.0
 */
public class EntryPanel extends JPanel implements ActionListener{
	
	private JTextField textField = new JTextField(50);
	private JButton browserButton;
	private JButton removeButton;
	private JLabel label;
	private JFileChooser fileChooser;
	private File file;
	
	/**
	 * Constructor method
	 * <p>
	 * Builds the panel where the user 
	 * can input the file selection
	 * </p>
	 * @param labelText
	 * @param font
	 */
	public EntryPanel(String labelText, Font font) {
		setPreferredSize(new Dimension(800, 600));
		
		browserButton = new JButton("Browse");
		browserButton.setFont(font);
		browserButton.addActionListener(this);
		
		removeButton = new JButton("Remove");
		removeButton.setFont(font);
		removeButton.addActionListener(this);
		
		label = new JLabel(labelText);
		label.setFont(font);
		textField.setFont(font);
		fileChooser = new JFileChooser("c:\\");
		fileChooser.setPreferredSize(new Dimension(1000, 800));
		setFileChooserFont(fileChooser.getComponents(), font);
		
		GroupLayout layout = new GroupLayout(this);
		setLayout(layout); 
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);

		layout.setHorizontalGroup(layout.createParallelGroup()
			.addComponent(label)
			.addGroup(layout.createSequentialGroup()
				.addComponent(browserButton)
				.addComponent(removeButton)
				.addComponent(textField)
			)
		);
		layout.setVerticalGroup(layout.createSequentialGroup()
			.addComponent(label)
			.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				.addComponent(browserButton)
				.addComponent(removeButton)
				.addComponent(textField))
		);
	}
	
	/**
	 * <p>Add file name to text field</p>
	 * @param txt
	 */
	public void setTextFieldText(String txt) {
		textField.setText(txt);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == browserButton) {
			loadFile();
		}else if(e.getSource() == removeButton & file != null) {
			removeFile();
		}
	}
	
	public void loadFile() {
		int selection = fileChooser.showOpenDialog(this);
        if (selection == JFileChooser.APPROVE_OPTION) {
        	try {
	        	file = fileChooser.getSelectedFile();
	        	setTextFieldText(file.getName());
	        	FileCompare.addFile(file);
        	}catch(Exception ex) {
        		ex.printStackTrace();
        	}
        }
	}
	
	public void removeFile() {
		int confirmation = JOptionPane.showConfirmDialog(
				null,
				"Are you sure you want to remove this file", 
				"Confirm remove", 
				JOptionPane.YES_NO_OPTION
		);
		if(confirmation == JOptionPane.YES_OPTION) {
			FileCompare.removeFile(file);
			textField.setText("");	
		}
	}
	
	public void setFileChooserFont(Component[] comp, Font font){
	for(int x = 0; x < comp.length; x++){
		if(comp[x] instanceof Container) setFileChooserFont(((Container)comp[x]).getComponents(), font);
			try{
				comp[x].setFont(font);
			}
			catch(Exception e){
				
			}//do nothing
	    }
	 }
}
