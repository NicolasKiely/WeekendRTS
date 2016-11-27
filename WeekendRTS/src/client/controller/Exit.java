package client.controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

/**
 * Handles exiting game/application
 * @author Nicolas Kiely
 */
public class Exit {
	/**
	 * Exits application
	 * @author Nicolas Kiely
	 */
	public static class ExitApplicationAction extends AbstractAction {
		private static final long serialVersionUID = 1L;

		public void actionPerformed(ActionEvent e){
			System.exit(0);
		}
	}
}
