package Data;

public class InvalidUserIdException extends DataException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidUserIdException() {
		super("The Userid or Password is invalid");
	}


}
