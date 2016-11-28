package client.view;

import java.awt.CardLayout;
import java.awt.Container;

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
	public final static String MAIN_MENU_PANEL = "Main Menu";
	
	/** New game panel */
	private NewGamePanel newGamePanel;
	public final static String NEW_GAME_PANEL = "New Game";
	
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
		Container pane = this.getContentPane();
		pane.setLayout(new CardLayout());
		
		// Initialize panels
		this.mainMenuPanel = new MainMenuPanel();
		this.newGamePanel = new NewGamePanel();
		
		pane.add(this.mainMenuPanel, MAIN_MENU_PANEL);
		pane.add(this.newGamePanel, NEW_GAME_PANEL);
		
		// Set visible
		this.switchToPanel(MAIN_MENU_PANEL);
		this.setVisible(true);
	}
	
	
	/**
	 * Switches to new panel
	 * @param panelName ID of panel
	 */
	public void switchToPanel(String panelName){
		Container pane = this.getContentPane();
		CardLayout cards = (CardLayout) pane.getLayout();
		cards.show(pane, panelName);
	}
}
