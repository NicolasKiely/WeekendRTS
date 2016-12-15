package client.view;

import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JPanel;

import main.WeekendRTS;

/**
 * Window frame of client application
 * @author Nicolas Kiely
 */
public class MainFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	/** Window width */
	public final static int WIDTH = 640;
	/** Window height */
	public final static int HEIGHT = 480;
	/** Singleton instance */
	private static MainFrame mainFrame;
	
	AbstractContentPanel activePanel;
	
	/** Card Panel for main content */
	private JPanel primarySide;
	private JPanel sidebarSide;
	
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
		pane.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridwidth = 5;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.insets = new Insets(0, 5, 0, 5);
		
		// Set up subpanel containers
		this.primarySide = new JPanel();
		this.sidebarSide = new JPanel();
		this.primarySide.setLayout(new CardLayout());
		this.sidebarSide.setLayout(new CardLayout());
		pane.add(this.primarySide, gbc);
		gbc.gridx = 1+gbc.gridwidth;
		gbc.gridwidth = 1;
		pane.add(this.sidebarSide, gbc);
		
		// Initialize and add panels
		this.mainMenuPanel = new MainMenuPanel();
		this.newGamePanel = new NewGamePanel();
		
		this.addContentPanel(this.mainMenuPanel, MAIN_MENU_PANEL);
		this.addContentPanel(this.newGamePanel, NEW_GAME_PANEL);
		
		// Set visible
		this.switchToPanel(MAIN_MENU_PANEL);
		this.setVisible(true);
	}
	
	
	/**
	 * Switches to new panel
	 * @param panelName ID of panel
	 */
	public void switchToPanel(String panelName){
		CardLayout primaryCards = (CardLayout) this.primarySide.getLayout();
		CardLayout sidebarCards = (CardLayout) this.sidebarSide.getLayout();
		primaryCards.show(this.primarySide, panelName);
		sidebarCards.show(this.sidebarSide, panelName);
		
		for (Component c : this.primarySide.getComponents()){
			if (c.isShowing()){
				((AbstractContentPanel) c).onSwitch();
			}
		}
	}
	
	
	/**
	 * Adds Abstract Content Panel to main frame
	 * @param newPanel
	 * @param name
	 */
	private void addContentPanel(AbstractContentPanel newPanel, String name){
		this.primarySide.add(newPanel, name);
		this.sidebarSide.add(newPanel.getSideBarPanel(), name);
	}
}
