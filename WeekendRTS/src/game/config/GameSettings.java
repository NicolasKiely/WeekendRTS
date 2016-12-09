package game.config;


/**
 * Stores immutable game settings
 * @author Nicolas Kiely
 */
public class GameSettings {
	/** ID of fame types */
	public final static int STANDARD_2D_TYPE = 0;
	
	/** Name of game types */
	public final static String STANDARD_2D_STR = "Standard-2D";
	
	/** Game type */
	private final int gameType;
	
	/** Size of square map, in tiles */
	private final int mapSize;
	
	/** Maximum number of players allowed to connect to game */
	private final int maxPlayers;
	
	public GameSettings(int gameType, int mapSize, int maxPlayers){
		this.mapSize = mapSize;
		this.maxPlayers = maxPlayers;
		this.gameType = gameType;
	}
	
	/**
	 * @return Map size parameter
	 */
	public int getMapSize(){
		return this.mapSize;
	}
	
	/**
	 * @return Max players parameter
	 */
	public int getMaxPlayers(){
		return this.maxPlayers;
	}
	
	/**
	 * @return ID of game type
	 */
	public int getGameType(){
		return this.gameType;
	}
}
