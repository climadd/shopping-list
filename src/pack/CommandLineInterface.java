package pack;

import java.util.Scanner;

public class CommandLineInterface {

	//attributi
	private ListManager manager;
	private Scanner scan;
	
	//costruttore
	public CommandLineInterface(Scanner scan) {
		this.manager = new ListManager();
		this.scan = scan;
	}
	
	//metodo
	public void executeInterface() {
		System.out.println("Launching Command Line Interface...\n");
		int operation;
		
		while(true) {

			System.out.println("Which operation do you want to perform?\nType the corresponding number:");
			System.out.println("  1. Add new List");
			System.out.println("  2. Remove existing List");
			System.out.println("  3. Add new Article");
			System.out.println("  4. Remove existing article");
			System.out.println("  5. Exit");
			System.out.println("");
			operation= scan.nextInt();
			
			switch (operation) {
           		case 1:
           			System.out.println("Operation 1 successfully executed!\n");
           			break;
           		case 2:
           			System.out.println("Operation 2 successfully executed!\n");
           			break;
                case 3:
                    System.out.println("Operation 3 successfully executed!\n");
                    break;
                case 4:
                    System.out.println("Operation 4 successfully executed!\n");
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
