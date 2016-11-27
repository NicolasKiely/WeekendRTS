package client.view;

import javax.swing.JFrame;

import main.WeekendRTS;

/**
 * Window frame of client application
 * @author Nicolas Kiely
 */
public class MainFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	/** Window width */
	private final static int WIDTH = 640;
	/** Window height */
	private final static int HEIGHT = 480;
	/** Singleton instance */
	private static MainFrame mainFrame;
	
	AbstractContentPanel activePanel;
	
	/** Main menu panel */
	private MainMenuPanel mainMenuPanel;
	public final static int MAIN_MENU_PANEL = 0;
	
	/**
	 * Returns singleton instance of MainFrame
	 * @return Window Frame
	 */
	public static MainFrame getMainFrame(){
		if (mainFrame == null)
			mainFrame = new MainFrame();
		
		return mainFrame;
	}
	
	/**
	 * Initializes frame
	 */
	private MainFrame(){
		//super();
		
		// Set up frame
		this.setSize(WIDTH, HEIGHT);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle(WeekendRTS.APP_NAME +": Main Menu");
		
		// Initialize panels
		this.mainMenuPanel = new MainMenuPanel();
		
		// Set visible
		this.switchToPanel(MAIN_MENU_PANEL);
		this.setVisible(true);
	}
	
	
	/**
	 * Switches to new panel
	 * @param panelNo ID of panel
	 */
	public void switchToPanel(int panelNo){
		AbstractContentPanel nextPanel = null;
		
		// Lookup panel by id
		switch (panelNo){
		case MAIN_MENU_PANEL:
			nextPanel = this.mainMenuPanel;
			break;
		}
		
		// Handle null panel
		if (nextPanel == null)
			throw new IllegalArgumentException("Invalid Panel #: "+ panelNo);
		
		// Close active panel and switch to new panel
		if (this.activePanel != null){
			this.remove(this.activePanel);
		}
		this.activePanel = nextPanel;
		this.add(nextPanel);
		this.activePanel.onSwitch();
	}
}
