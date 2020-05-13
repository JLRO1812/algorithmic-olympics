package customException;

@SuppressWarnings("serial")
public class EmptyFieldException extends Exception{

	public EmptyFieldException(String field) {
		super("The Field: " + field + " is empty");
	}
}
