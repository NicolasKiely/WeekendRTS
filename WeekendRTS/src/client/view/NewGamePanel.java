package client.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import client.controller.InitializeGame;
import game.config.GameSettings;
import game.config.GameSettingsProvider;
import game.config.InvalidSettingsException;

/**
 * New Game Screen
 * @author Nicolas Kiely
 */
public class NewGamePanel extends AbstractContentPanel implements GameSettingsProvider {
	private static final long serialVersionUID = 1L;
	
	private JTextField noPlayersFld;
	private JTextField mapSizeFld;
	private JLabel errFld;
	
	public NewGamePanel(){
		super();
		
		// Initialize layout
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.insets = new Insets(10, 10, 10, 10);
		
		// Initialize input fields
		noPlayersFld = new JTextField();
		noPlayersFld.setColumns(10);
		noPlayersFld.setText("1");
		
		this.mapSizeFld = new JTextField();
		this.mapSizeFld.setColumns(10);
		this.mapSizeFld.setText("11");
		this.mapSizeFld.setEditable(false);
		
		// Add fields
		this.addInputField("Number Players:", this.noPlayersFld, gbc);
		this.addInputField("Map Size: ", this.mapSizeFld, gbc);
		
		// Error field
		gbc.gridx = 0;
		gbc.gridy++;
		gbc.gridwidth = 2;
		this.errFld = new JLabel();
		this.errFld.setForeground(new Color(0xFF0000));
		this.add(this.errFld, gbc);
	}
	
	
	private void addInputField(String labelText, JTextField inputField, GridBagConstraints gbc){
		JLabel inputLabel = new JLabel(labelText);
		
		gbc.gridx = 0;
		this.add(inputLabel, gbc);
		gbc.gridx = 1;
		this.add(inputField, gbc);
		
		gbc.gridy++;
	}
	
	protected List<Component> getSideBarComponents(){
		JSeparator separator = new JSeparator(SwingConstants.HORIZONTAL);
		separator.setPreferredSize(new Dimension(1, 1));
		
		JButton cancelBtn = new JButton(new InitializeGame.CancelNewGameAction());
		cancelBtn.setText("Cancel");
		
		JButton startBtn = new JButton(new InitializeGame.StartNewGameAction(this));
		startBtn.setText("Start");
		
		Component buttons[] = {
				startBtn,
				cancelBtn
		};
		return Arrays.asList(buttons);
	}

	
	public GameSettings getSettings() {
		// Generate settings from fields
		int gameType = GameSettings.STANDARD_2D_TYPE;
		int mapSize = Integer.parseInt(this.mapSizeFld.getText());
		int maxPlayers = Integer.parseInt(this.noPlayersFld.getText());
		return new GameSettings(gameType, mapSize, maxPlayers);
	}


	public void handleInvalidSetting(InvalidSettingsException invalidSettings) {
		this.errFld.setText(invalidSettings.getMessage());
	}
}
