package pack;

import java.util.Scanner;

public class Main {

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
			System.out.println("Graphic");
		}
		
		//command line block
		if (answer.equalsIgnoreCase("no")) {
			CommandLineInterface interfaccia = new CommandLineInterface(scan);
			interfaccia.executeInterface();
		}
		
		scan.close();
	}
}
