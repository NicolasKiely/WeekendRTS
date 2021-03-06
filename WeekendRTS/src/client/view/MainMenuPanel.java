package client.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;

import client.controller.Exit;
import client.controller.InitializeGame;

/**
 * Main Menu Screen
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
		gbc.ipady = 10;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.insets = new Insets(20, 20, 20, 20);
		
		// Initialize buttons
		startGameBtn = new JButton(new InitializeGame.SetupNewGameAction());
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


	public void onSwitch() {
	}
}
