package by.bsuir.lab2.services.exception;

public class ServiceException extends Exception {

	public ServiceException(Exception innerException) {
		this.innerException = innerException;
	}
	
	
	public ServiceException(String message) {
		super(message);
	}
	
	
	private Exception innerException;
}
