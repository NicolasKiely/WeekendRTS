package game.config;

/**
 * View-Agnostic provider of game settings
 * @author Nicolas Kiely
 */
public interface GameSettingsProvider {
	/**
	 * @return Generated settings
	 */
	public GameSettings getSettings();
	
	/**
	 * Handler for when settings fail validation
	 * @param invalidSettings Exception raised from validator
	 */
	public void handleInvalidSetting(InvalidSettingsException invalidSettings);
}
