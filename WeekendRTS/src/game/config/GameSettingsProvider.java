package game.config;

/**
 * View-Agnostic provider of game settings
 * @author Nicolas Kiely
 */
public interface GameSettingsProvider {
	/**
	 * @return Generated settings
	 * @throws InvalidSettingsException 
	 */
	public GameSettings getSettings() throws InvalidSettingsException;
	
	/**
	 * Handler for when settings fail validation
	 * @param invalidSettings Exception raised from validator
	 */
	public void handleInvalidSetting(InvalidSettingsException invalidSettings);
}
