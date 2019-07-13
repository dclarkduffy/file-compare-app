/* Project: FileCompre
 * Author:  Mathew J. Gries
 * Date:    7/13/2019
 * Purpose: To input multiple reports and compare them for inconsistencies
 */

import java.awt.Font;
import java.util.ArrayList;

public class Project {
	public static void main(String args[]) {
		final Font font = new Font("Times New Roman",Font.PLAIN, 24);
		UserWindow userWindow;
		
		EntryPanel fileOnePanel;
		EntryPanel fileTwoPanel;
		EntryPanel fileThreePanel;
		
		SubmitPanel submitPanel;
		
		//FileCompare fileCompare;
		
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