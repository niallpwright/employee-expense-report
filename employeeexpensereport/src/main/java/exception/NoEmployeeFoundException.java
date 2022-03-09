package exception;

public class NoEmployeeFoundException extends Exception{
	
	@Override
	public String getMessage() {
		
		return "Application Failed. Please try again after a moement.";
	}


}
