package client.controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import client.view.MainFrame;

/**
 * Handles starting up a new game
 * @author Nicolas Kiely
 */
public class InitializeGame {
	/**
	 * Handler for "Start New Game" button
	 */
	public static class StartNewGameAction extends AbstractAction{
		private static final long serialVersionUID = 1L;

		public void actionPerformed(ActionEvent e){
			System.out.println("Starting new game");
			MainFrame.getMainFrame().switchToPanel(MainFrame.NEW_GAME_PANEL);
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
