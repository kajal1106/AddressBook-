package LinkedList;


public class AddressbookException extends Exception {
String message;
	
	public AddressbookException(String errMessage){
		message = errMessage;
	}
	
	public String getMessage() {
			return message;
	}

	
}
