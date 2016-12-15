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
	
	// Default values for input fields
	private static String noPlayersDefault = "1";
	private static String mapSizeDefault = "11";
	
	// Input fields
	private JTextField noPlayersFld;
	private JTextField mapSizeFld;
	
	// Error message field
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
		this.noPlayersFld = new JTextField();
		this.noPlayersFld.setColumns(10);
		
		this.mapSizeFld = new JTextField();
		this.mapSizeFld.setColumns(10);
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
	

	/**
	 * Load settings values from input fields
	 */
	public GameSettings getSettings() throws InvalidSettingsException {
		// Generate settings from fields
		int gameType = GameSettings.STANDARD_2D_TYPE;
		String mapSizeText = this.mapSizeFld.getText();
		String noPlayersText = this.noPlayersFld.getText();
		int mapSize;
		int maxPlayers;
		
		// Get map size
		try {
			mapSize = Integer.parseInt(mapSizeText);
		} catch (NumberFormatException e){
			throw new InvalidSettingsException("Map Size", "a number", mapSizeText);
		}
		
		// Get number of players
		try {
			maxPlayers = Integer.parseInt(noPlayersText);
		} catch (NumberFormatException e){
			throw new InvalidSettingsException("Number Players", "a number", noPlayersText);
		}
		return new GameSettings(gameType, mapSize, maxPlayers);
		
	}


	/**
	 * Display error message on invalid setting
	 */
	public void handleInvalidSetting(InvalidSettingsException invalidSettings) {
		this.errFld.setText(invalidSettings.getMessage());
	}
	
	
	/**
	 * Resets fields when navigating to this panel
	 */
	public void onSwitch(){
		this.noPlayersFld.setText(noPlayersDefault);
		this.mapSizeFld.setText(mapSizeDefault);
		this.errFld.setText("");
	}
}
