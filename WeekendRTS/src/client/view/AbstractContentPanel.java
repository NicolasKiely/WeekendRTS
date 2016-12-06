package client.view;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.List;

import javax.swing.JMenu;
import javax.swing.JPanel;

/**
 * Base class of active window panel
 * @author Nicolas Kiely
 */
public abstract class AbstractContentPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private JPanel sideBarPanel = null;

	/** Returns associated menu with this active panel */
	public JMenu getMenu(){
		return null;
	}
	
	/** Called when panel is switched to */
	public void onSwitch(){}
	
	/** Returns a list of sidebar buttons for this panel */
	protected List<Component> getSideBarComponents(){
		return null;
	}
	
	
	/**
	 * Generates panel containing sidebar components
	 * @return Sidebar component panel
	 */
	public final JPanel getSideBarPanel(){
		if (this.sideBarPanel == null){
			this.sideBarPanel = new JPanel();
			this.sideBarPanel.setLayout(new GridBagLayout());
			GridBagConstraints gbc = new GridBagConstraints();
			gbc.fill = GridBagConstraints.HORIZONTAL;
			gbc.gridy = 0;
			gbc.insets = new Insets(10, 10, 10, 10);
			
			List <Component> components = this.getSideBarComponents();
			if (components == null)
				return this.sideBarPanel;
			
			for (Component component : components){
				this.sideBarPanel.add(component, gbc);
				gbc.gridy++;
			}
		}
		return this.sideBarPanel;
	}
}
