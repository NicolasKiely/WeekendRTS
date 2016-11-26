package client;

import javax.swing.JMenu;
import javax.swing.JPanel;

/**
 * Base class of active window panel
 * @author Nicolas Kiely
 */
public abstract class AbstractContentPanel extends JPanel {
	/** Returns associated menu with this active panel */
	public JMenu getMenu(){
		return null;
	}
	
	/** Called when panel is switched to */
	public void onSwitch(){}
}
