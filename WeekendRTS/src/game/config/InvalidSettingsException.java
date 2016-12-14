package game.config;

/**
 * Exception for invalid setting
 * @author Nicolas Kiely
 */
public class InvalidSettingsException extends Exception {
	private static final long serialVersionUID = 1L;
	
	/** Setting key */
	private String key;
	/** Expected setting value */
	private String expected;
	/** Actual value */
	private String actual;
	
	public InvalidSettingsException(String key, String expected, String actual){
		super("Invalid value for "+ key +", should be "+ expected);
		this.key = key;
		this.expected = expected;
		this.actual = actual;
	}
}
