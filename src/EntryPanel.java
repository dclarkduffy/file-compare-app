import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class EntryPanel extends JPanel implements ActionListener{
	
	private JTextField textField = new JTextField(50);
	private JButton browserButton;
	private JButton removeButton;
	private JLabel label;
	private JFileChooser fileChooser;
	private File file;
	
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
		fileChooser = new JFileChooser();
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
	
	public void setTextFieldText(String txt) {
		textField.setText(txt);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == browserButton) {
			int selection = fileChooser.showOpenDialog(this);
	        if (selection == JFileChooser.APPROVE_OPTION) {
	        	file = fileChooser.getSelectedFile();
	        	setTextFieldText(file.getName());
	        	FileCompare.addFile(file);
	        	System.out.println(FileCompare.getFileCount());
	        } else {
	            System.out.println("Open command cancelled by user." );
	        }
		}else if(e.getSource() == removeButton) {
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
