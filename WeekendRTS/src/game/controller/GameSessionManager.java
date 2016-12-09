package game.controller;

import game.config.GameSettings;
import game.model.gameState.AbstractGameState;
import game.model.gameState.Standard2dGameState;

/**
 * Manages a game session over its life cycle
 * @author Nicolas Kiely
 */
public class GameSessionManager {
	/** Game settings for this session */
	private final GameSettings settings;
	
	/** Game state */
	private AbstractGameState state;

	public GameSessionManager(GameSettings settings){
		this.settings = settings;
		
		// Create new game session
		switch (settings.getGameType()){
		case GameSettings.STANDARD_2D_TYPE:
			this.state = new Standard2dGameState();
			break;
		}
	}
}
