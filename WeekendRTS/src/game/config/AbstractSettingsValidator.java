package game.config;

public interface AbstractSettingsValidator {
	/**
	 * Game-mode specific validator method
	 * @param settings Settings to check
	 * @throws InvalidSettingsException Invalid settings
	 */
	public void validate(GameSettings settings) throws InvalidSettingsException;
}
