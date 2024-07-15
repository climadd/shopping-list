package main.java.org;

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
	 * @author Lorenzo Bertoldo
	 */
	public static void main(String[]Args) {

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
			Controller controller = new Controller(interfaccia);
			controller.runInterface();
		}

		//command line block
		if (answer.equalsIgnoreCase("no")) {
			CommandLineInterface interfaccia = new CommandLineInterface(scan);
			interfaccia.executeInterface();
		}

		scan.close();
	}
}
