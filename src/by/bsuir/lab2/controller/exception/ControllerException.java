package by.bsuir.lab2.controller.exception;

public class ControllerException extends Exception {

	public ControllerException(Exception innerException) {
		this.innerException = innerException;
	}
	
	
	public ControllerException(String messageString) {
		super(messageString);
	}
	
	
	public Exception getInnerException() {
		return innerException;
	}
	
	
	protected Exception innerException;
}
