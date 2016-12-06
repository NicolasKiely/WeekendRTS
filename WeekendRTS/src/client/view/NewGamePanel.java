package client.view;

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

/**
 * New Game Screen
 * @author Nicolas Kiely
 */
public class NewGamePanel extends AbstractContentPanel {
	private static final long serialVersionUID = 1L;
	
	private JTextField noPlayersFld;
	private JTextField mapSizeFld;
	
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
		
		mapSizeFld = new JTextField();
		mapSizeFld.setColumns(10);
		mapSizeFld.setText("11");
		mapSizeFld.setEditable(false);
		
		
		// Add fields
		this.addInputField("Number Players:", noPlayersFld, gbc);
		this.addInputField("Map Size: ", mapSizeFld, gbc);
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
		
		Component buttons[] = {
				new JButton("Start"),
				cancelBtn
		};
		return Arrays.asList(buttons);
	}
}
