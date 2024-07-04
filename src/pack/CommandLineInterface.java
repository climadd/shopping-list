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
			/*
			 * -Add new List
			 * -Remove existing List
			 * -Add new Category
			 * -Remove existing Category
			 * -Add new Article
			 * -Remove existing Article
			 * 
			 * -Exit
			 */
			System.out.println("Which operation do you want to perform?\nType the corresponding number:");
			System.out.println("  0. Display Lists and their Articles");
			System.out.println("  1. Add new List");
			System.out.println("  2. Remove existing List");
			System.out.println("  3. Add new Category");
			System.out.println("  4. Remove existing Category");
			System.out.println("  5. Add new Article");
			System.out.println("  6. Remove existing Article");
			System.out.println("  7. Exit");
			operation= scan.nextInt();
			
			switch (operation) {
				case 0:
					manager.displayLists();
					break;
           		case 1:
           			System.out.println("Type the name of the new List: ");
           			manager.addShoppingList(scan.next());
           			System.out.println("New List successfully created!\n");
           			break;
           		case 2:
           			System.out.println("List successfully removed!\n");
           			break;
                case 3:
                    System.out.println("New Category successfully created!\n");
                    break;
                case 4:
                    System.out.println("Category successfully removed!\n");
                    break;
                case 5:
                	System.out.println("New Article successfully added!\n");
                	break;
                case 6:
                	System.out.println("Article successfully removed!\n");
                	break;
           		case 7:
           			System.out.println("Closing Interface...");
           			scan.close();
           			return;
           		default:
           			System.out.println("Invalid Option");
           	}			
		}
			
	}
}
