package com.freedompay.fileCompare;

import java.awt.Font;
import java.util.ArrayList;
import javax.swing.*;

/**
 * 
 * @author 	MGries
 * @version 1.0
 * @since	1.0
 */
public class Project {
	public static void main(String args[]) {
		
		final Font font = new Font("Times New Roman",Font.PLAIN, 18);
		UIManager.put("OptionPane.messageFont", font);
		UIManager.put("OptionPane.buttonFont", font);
		
		UserWindow userWindow;
		EntryPanel fileOnePanel;
		EntryPanel fileTwoPanel;
		EntryPanel fileThreePanel;
		SubmitPanel submitPanel;
		
		fileOnePanel = new EntryPanel("File 1", font);
		fileTwoPanel = new EntryPanel("File 2", font);
		fileThreePanel = new EntryPanel("File 3", font);
		submitPanel = new SubmitPanel(font);
		
		ArrayList<EntryPanel> panelList = new ArrayList<EntryPanel>();
		panelList.add(fileOnePanel);
		panelList.add(fileTwoPanel);
		panelList.add(fileThreePanel);
		
		userWindow = new UserWindow(panelList, submitPanel);
	} 
}