package Data;

public class DataException  extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DataException() {
		super("Exception occured while connecting to database");
	}
	
	public DataException(String message){
		super(message);
	}

}
