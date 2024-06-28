package pack;

import java.util.Scanner;

public class CommandLineInterface {

	public CommandLineInterface() {
	}

	public void executeInterface() {
		System.out.println("Launching Command Line Interface...\n");
		Scanner scan = new Scanner(System.in);
		int operation;
		
		while(true) {
			System.out.println("Which operation do you want to perform?\nType the corresponding number:\n");
			System.out.println("1. Aggiungi Lista");
			System.out.println("2. Rimuovi Lista");
			System.out.println("3. Aggiungi Articolo");
			System.out.println("4. Rimuovi Articolo");
			System.out.println("5. Esci");
			System.out.println();
			operation= scan.nextInt();
			
			switch (operation) {
           		case 1:
           			System.out.println("scelta 1");
           			break;
           		case 2:
           			System.out.println("scelta 2");
           			break;
           			
           		case 5:
           			System.out.println("Closing Interface...");
           			scan.close();
           			return;
           		default:
           			System.out.println("Invalid Option");
           	}			
		}
			
	}
}
