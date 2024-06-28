package pack;

import java.util.Scanner;

public class CommandLineInterface {

	//attributi
	private ListManager manager;
	Scanner scan;
	
	//costruttore
	public CommandLineInterface() {
		this.manager = new ListManager();
	}
	//metodo
	public void executeInterface() {
		System.out.println("Launching Command Line Interface...\n");
		this.scan = new Scanner(System.in);
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
           			System.out.println("scelta 1");
           			break;
           		case 2:
           			System.out.println("scelta 2");
           			break;
                case 3:
                    System.out.println("scelta 3");
                    break;
                case 4:
                    System.out.println("scelta 4");
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
