package main.java.org.model;

/**
 *  MissingNameException is mostly thrown when the identifier given isn't present in memory.
 *  this informs the user that the data they tried to access isnt present in memory, or has a different identifier to the specified one.
 */
public class MissingNameException extends Exception{

	/**
	 * unique identifier for this serializable class
	 */
	private static final long serialVersionUID = 1L;

	/**
     * Constructs a new MissingNameException with the specified detail message.
     *
     * @param msg the detail message
     */
	public MissingNameException(String msg) {
		super(msg);
	}
}
