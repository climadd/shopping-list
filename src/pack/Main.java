package pack;

import java.util.Scanner;

public class Main {

	public static void main(String[]Args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Command Line Interface is about to be launched, do you want to launch the Graphic Inteface instead?");
		String answer = "NONE";
		
		while (!answer.equalsIgnoreCase("yes") && !answer.equalsIgnoreCase("no")) {
			System.out.println("Type a valid response (yes/no): ");
			answer = scan.next();
		}
		scan.close();
		
		// GUI block
		if (answer.equalsIgnoreCase("yes")) {
			System.out.println("Graphic");
		}
		
		//command line block
		if (answer.equalsIgnoreCase("no")) {
			System.out.println("Command Line");
		}
		
	}
}
