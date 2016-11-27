package client.controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

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
		}
	}
}