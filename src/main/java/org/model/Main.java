package main.java.org.model;

import java.util.Scanner;

import main.java.org.exceptions.DuplicateNameException;
import main.java.org.exceptions.MissingNameException;
import main.java.org.exceptions.ValidationException;
import main.java.org.view.CommandLineInterface;
import main.java.org.view.GraphicUserInterface;

/*TODO:
 * -organizzazione directory SRC: main-java-pack<varie classi/test-java<varie classi
 * METODI DI I/O
 * -GUI
 * -TEST
 * -HANDLING EVERY EXCEPTION
 * -JAVADOC
*/

public class Main {

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
		}

		//command line block
		if (answer.equalsIgnoreCase("no")) {
			CommandLineInterface interfaccia = new CommandLineInterface(scan);
			interfaccia.executeInterface();
		}

		scan.close();
	}
}
