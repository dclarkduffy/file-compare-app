import javax.swing.*;
import java.util.ArrayList;

public class UserWindow extends JFrame {

	private JPanel mainPanel;

	public UserWindow(ArrayList<EntryPanel> entryPanels, SubmitPanel submitPanel) {
		super();
	    this.setSize(500, 500);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    buildMainPanel(entryPanels, submitPanel);
	    this.add(mainPanel);
	    this.pack();
	    this.setVisible( true );
	}

	public void buildMainPanel(ArrayList<EntryPanel> panelList, SubmitPanel submitPanel) {
		mainPanel = new JPanel();
		GroupLayout layout = new GroupLayout(mainPanel);
		mainPanel.setLayout(layout);

		layout.setHorizontalGroup(layout.createParallelGroup()
			.addComponent(panelList.get(0))
			.addComponent(panelList.get(1))
			.addComponent(panelList.get(2))
			.addComponent(submitPanel)
		);
		layout.setVerticalGroup(layout.createSequentialGroup()
			.addComponent(panelList.get(0))
			.addComponent(panelList.get(1))
			.addComponent(panelList.get(2))
			.addComponent(submitPanel)
		);
	}
}
