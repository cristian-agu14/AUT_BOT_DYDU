package exceptions;

public class MyExcepction extends AssertionError{

	/**
	 * Variable
	 */
	private static final long serialVersionUID = 1L;

	public static final String ERROR_CREATION_BOT = "The bot is not created whit the feature name";
	
	public MyExcepction (String message, Throwable testErrorException) {
		super(message, testErrorException);
	}
	
}
