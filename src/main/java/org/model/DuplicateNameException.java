package main.java.org.model;

/**
 *  DuplicateNameException mostly thrown during creation of new data if the identifier given is already used for pre-existing data.
 *  this prevents duplicate entries.
 */
public class DuplicateNameException extends Exception{

    /**
	 * a unique identifier for this serializable class.
	 */
	private static final long serialVersionUID = 1L;

	/**
     * Constructs a new DuplicateNameException with the specified detail message.
     *
     * @param msg the detail message
     */
	public DuplicateNameException(String msg) {
		super(msg);
	}
}
