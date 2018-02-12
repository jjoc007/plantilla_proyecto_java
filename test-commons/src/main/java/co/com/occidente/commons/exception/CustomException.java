package co.com.occidente.commons.exception;

public class CustomException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustomException(String message) {
		super(message);
	}
	
	public CustomException(Throwable ex) {
		super(ex);
	}
	
	public CustomException(String message, Throwable ex) {
		super(message, ex);
	}
}
