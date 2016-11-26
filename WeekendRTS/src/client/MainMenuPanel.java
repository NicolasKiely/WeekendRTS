package client;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * Main Menu
 * @author Nicolas Kiely
 */
public class MainMenuPanel extends AbstractContentPanel {
	private JButton startGameBtn;
	private JButton connectBtn;
	private JButton exitBtn;
	
	
	public MainMenuPanel(){
		super();
		
		//this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 0;

		JPanel centeredPanel = new JPanel();
		centeredPanel.setLayout(new BoxLayout(centeredPanel, BoxLayout.PAGE_AXIS));
		
		// Initialize buttons
		startGameBtn = new JButton("Start New Game");
		connectBtn = new JButton("Join Game");
		exitBtn = new JButton("Exit");
		
		/*
		centeredPanel.add(this.startGameBtn, SwingConstants.CENTER);
		centeredPanel.add(this.connectBtn);
		centeredPanel.add(this.exitBtn);
		this.add(centeredPanel);*/
		
		this.add(this.startGameBtn, gbc); gbc.gridy++;
		this.add(this.connectBtn, gbc); gbc.gridy++;
		this.add(this.exitBtn, gbc);
		
	}
}
