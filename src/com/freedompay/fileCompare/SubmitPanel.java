package com.freedompay.fileCompare;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * 
 * @author 	MGries
 * @version 1.0
 * @since	1.0
 */
public class SubmitPanel extends JPanel implements ActionListener{
	
	private JButton submitButton;
	
	/**
	 * Constructor
	 * <p>
	 * Panel to hold the button that executes
	 * the file comparison
	 * </p>
	 * @param font
	 */
	public SubmitPanel(Font font) {
		submitButton = new JButton("Submit");
		submitButton.setFont(font);
		submitButton.addActionListener(this);
		this.add(submitButton);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(FileCompare.getFileCount() < 2) {
			JOptionPane.showMessageDialog(null,"You must select at least 2 files for comparsison");
		}else {
			FileCompare.runComparison();
		}
	}
}
