package client.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;

import client.controller.Exit;
import client.controller.InitializeGame;

/**
 * Main Menu
 * @author Nicolas Kiely
 */
public class MainMenuPanel extends AbstractContentPanel {
	private static final long serialVersionUID = 1L;
	private JButton startGameBtn;
	private JButton connectBtn;
	private JButton exitBtn;
	
	
	public MainMenuPanel(){
		super();
		
		// Initialize panel layout
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 0;
		
		// Initialize buttons
		startGameBtn = new JButton(new InitializeGame.StartNewGameAction());
		startGameBtn.setText("Start New Game");
		connectBtn = new JButton();
		connectBtn.setText("Join Game");
		exitBtn = new JButton(new Exit.ExitApplicationAction());
		exitBtn.setText("Exit");
		
		// Add buttons
		this.add(this.startGameBtn, gbc);
		gbc.gridy++;
		this.add(this.connectBtn, gbc);
		gbc.gridy++;
		this.add(this.exitBtn, gbc);
	}
}
