package game.config;

/**
 * Validator for checking game settings
 * @author Nicolas Kiely
 */
public class GameSettingsValidator {
	public static void validateSettings(GameSettings settings) throws InvalidSettingsException{
		AbstractSettingsValidator modeValidator = null;
		
		// Get gametype-specific validator
		switch (settings.getGameType()){
		case GameSettings.STANDARD_2D_TYPE:
			modeValidator = new Standard2dSettingsValidator();
			break;
		}
		
		if (modeValidator == null){
			// Check if valid game type
			throw new InvalidSettingsException("Game Type", "Standard 2D", null);
		}
		
		modeValidator.validate(settings);
	}
}
