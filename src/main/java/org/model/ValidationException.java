package main.java.org.model;

/**
 *  ValidationException  mostly thrown when the input given is not valid or coherent with the operation.
 *  This prevents either type compatibility exceptions (example: user typing a string instead of a integer .nextInt() scanner method),
 *  or a consistency exception (example: user trying to add a negative amount of articles)
 */

public class ValidationException extends Exception{

	/**
	 * unique identifier for this serializable class
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructs a new DuplicateNameException with the specified detail message.
	 *
	 * @param msg the detail message
	 */
	public ValidationException(String msg) {
		super(msg);
	}
}
