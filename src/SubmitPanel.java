import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SubmitPanel extends JPanel implements ActionListener{
	
	private JButton submitButton;
	
	public SubmitPanel(Font font) {
		submitButton = new JButton("Submit");
		submitButton.setFont(font);
		submitButton.addActionListener(this);
		this.add(submitButton);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		FileCompare.runComparison();
	}
}
