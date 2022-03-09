package exception;

public class RequestNotFoundException extends Exception{
	
	@Override
	public String getMessage() {
		
		return "Application Failed. Please try again after a moement.";
	}

}
