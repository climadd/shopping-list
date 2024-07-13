package main.java.org.model;

import java.util.Scanner;

import main.java.org.controller.Controller;
import main.java.org.view.CommandLineInterface;
import main.java.org.view.GraphicUserInterface;

/*TODO:
 * -HANDLING EVERY EXCEPTION
 * METODI DI I/O
 * -TEST
 * * -GUI
*/

/**
 * Main class of the application. 
 */
public class Main {

    /**
     * The main method is the entry point of the application.
     * It asks the user to choose between launching the Command Line Interface or the Graphic User Interface through the use of a Scanner.
     *
     * @param args command-line arguments (not used).
     * @throws DuplicateNameException  mostly thrown during creation of new data if the identifier given is already used for pre-existing data.
     * @throws MissingNameException  mostly thrown when the identifier given isn't present in memory.
     * @throws ValidationException  mostly thrown when the input given is not valid or coherent with the operation.
     */
	public static void main(String[]Args) throws DuplicateNameException, MissingNameException, ValidationException {

		Scanner scan = new Scanner(System.in);
		System.out.println("Command Line Interface is about to be launched, do you want to launch the Graphic Interface instead?");
		String answer = "None";

		while (!answer.equalsIgnoreCase("yes") && !answer.equalsIgnoreCase("no")) {
			System.out.println("Type a valid response (yes/no): ");
			answer = scan.next();
		}


		//GUI block
		if (answer.equalsIgnoreCase("yes")) {
			GraphicUserInterface interfaccia = new GraphicUserInterface();
			interfaccia.runInterface();
			Controller controller = new Controller(interfaccia);
		}

		//command line block
		if (answer.equalsIgnoreCase("no")) {
			CommandLineInterface interfaccia = new CommandLineInterface(scan);
			interfaccia.executeInterface();
		}

		scan.close();
	}
}
