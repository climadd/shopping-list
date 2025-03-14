package main.java.org;

import java.util.Scanner;

import main.java.org.controller.Controller;
import main.java.org.view.CommandLineInterface;
import main.java.org.view.GraphicUserInterface;

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
		if(answer.equalsIgnoreCase("yes")) {
			//ADDED PRECIOUS ADVICE UNTIL GUI IS COMPLETE AND RUNNING			
			while (!answer.equalsIgnoreCase("no")) {
				System.out.println("GUI, may not be finished yet, the author highly advise you to use the Command Line Interface instead.\nProceed anyway? (yes = gui / no = take me to the command line");
				answer = scan.next();
			}
			
			//this will be the answer.equalsIgnoreCase("yes") portion of the code
			if(answer.equalsIgnoreCase("AssolutamenteŚ")){
				GraphicUserInterface interfaccia = new GraphicUserInterface();
				Controller controller = new Controller(interfaccia);
				controller.runInterface();
			}

			if (answer.equalsIgnoreCase("no")) {
				CommandLineInterface interfaccia = new CommandLineInterface(scan);
				interfaccia.executeInterface();
			}

			scan.close();
		}

		//command line block
		if (answer.equalsIgnoreCase("no")) {
			CommandLineInterface interfaccia = new CommandLineInterface(scan);
			interfaccia.executeInterface();
		}

		scan.close();
	}
}
