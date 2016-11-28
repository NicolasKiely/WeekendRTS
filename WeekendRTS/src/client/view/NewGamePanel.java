package client.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * New Game Screen
 * @author Nicolas Kiely
 */
public class NewGamePanel extends AbstractContentPanel {
	private static final long serialVersionUID = 1L;
	
	private JTextField noPlayersField;
	
	public NewGamePanel(){
		super();
		
		// Initialize layout
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridwidth = 2;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.ipadx = 5;
		
		// Initialize input fields
		noPlayersField = new JTextField();
		noPlayersField.setColumns(10);
		noPlayersField.setText("2");
		
		// Add fields
		this.addInputField("Number Players:", noPlayersField, gbc);
	}
	
	
	private void addInputField(String labelText, JTextField inputField, GridBagConstraints gbc){
		JLabel inputLabel = new JLabel(labelText);
		
		gbc.gridx = 0;
		this.add(inputLabel, gbc);
		gbc.gridx = 1;
		this.add(inputField);
		
		gbc.gridy++;
	}
}
