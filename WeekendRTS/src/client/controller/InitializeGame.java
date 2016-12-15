package client.controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import client.view.MainFrame;
import game.config.GameSettingsProvider;
import game.config.GameSettingsValidator;
import game.config.InvalidSettingsException;

/**
 * Handles starting up a new game
 * @author Nicolas Kiely
 */
public class InitializeGame {
	/**
	 * Handler for "Start New Game" button on main menu
	 * Goes to game setup screen
	 */
	public static class SetupNewGameAction extends AbstractAction{
		private static final long serialVersionUID = 1L;

		public void actionPerformed(ActionEvent e){
			System.out.println("Setting up new game");
			MainFrame.getMainFrame().switchToPanel(MainFrame.NEW_GAME_PANEL);
		}
	}
	
	
	/**
	 * Handler for "Start Game" in setup screen
	 * Starts game
	 */
	public static class StartNewGameAction extends AbstractAction{
		private static final long serialVersionUID = 1L;
		private GameSettingsProvider provider;
		
		public StartNewGameAction(GameSettingsProvider provider){
			super();
			this.provider = provider;
		}

		public void actionPerformed(ActionEvent e){
			System.out.println("Starting new game");
			try {
				GameSettingsValidator.validateSettings(provider.getSettings());
				MainFrame.getMainFrame().switchToPanel(MainFrame.GAME_LOBBY_PANEL);
				
			} catch (InvalidSettingsException invalidSetting) {
				provider.handleInvalidSetting(invalidSetting);
			}
		}
	}
	
	
	/**
	 * Handler for "Cancel" button when starting new game
	 */
	public static class CancelNewGameAction extends AbstractAction{
		private static final long serialVersionUID = 1L;
		
		public void actionPerformed(ActionEvent e){
			MainFrame.getMainFrame().switchToPanel(MainFrame.MAIN_MENU_PANEL);
		}
	}
}
