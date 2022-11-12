package by.bsuir.lab2.dao.exception;

public class DaoException extends Exception {

	public DaoException(Exception innerException) {
		this.innerException = innerException;
	}
	
	
	public DaoException(String messageString) {
		super(messageString);
	}
	
	
	public Exception getInnerException() {
		return innerException;
	}
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	protected Exception innerException;
}
