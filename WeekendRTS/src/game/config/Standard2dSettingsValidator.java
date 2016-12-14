package game.config;

public class Standard2dSettingsValidator implements AbstractSettingsValidator {

	public void validate(GameSettings settings) throws InvalidSettingsException {
		// Validate map size
		if (settings.getMapSize() != 11){
			throw new InvalidSettingsException("Map Size", "size is 11", ""+settings.getMapSize());
		}
		
		// Validate number of players
		if (settings.getMaxPlayers() != 2){
			throw new InvalidSettingsException("Max Players", "2", ""+settings.getMaxPlayers());
		}
	}
	
}
