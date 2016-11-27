package main;

import client.view.MainFrame;

/**
 * Entry class of application
 * @author Nicolas Kiely
 */
public class WeekendRTS {
	public final static String APP_NAME = "Weekend RTS";
	
	@SuppressWarnings("unused")
	private static MainFrame mainFrame;
	
	public static void main(String[] args) {
		mainFrame = MainFrame.getMainFrame();
	}

}
