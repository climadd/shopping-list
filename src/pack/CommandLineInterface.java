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
			 * -Display contents
			 * -display categories
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
			System.out.println("  0. Display Lists and their Contents");
			System.out.println("  1. Display every Category");
			System.out.println("  2. Add new List");
			System.out.println("  3. Remove existing List");
			System.out.println("  4. Add new Category");
			System.out.println("  5. Remove existing Category");
			System.out.println("  6. Add new Article");
			System.out.println("  7. Remove existing Article");
			System.out.println("  8. Exit");
			operation= scan.nextInt();
			
			switch (operation) {
				case 0:
					manager.displayLists(manager);
					break;
				case 1:
					System.out.println("Your Categories are: ");
					manager.displayCategories(manager);
					System.out.println();
					break;
           		case 2:
           			System.out.println("Type the name of the new List: ");
           			manager.addShoppingList(scan.next());
           			System.out.println("New List successfully created!\n");
           			break;
           		case 3:
           			System.out.println("List successfully removed!\n");
           			break;
                case 4:
                	System.out.println("Type the name of the new Category: ");
                	manager.addCategory(scan.next());
                    System.out.println("New Category successfully created!\n");
                    break;
                case 5:
                	System.out.println("Type the name of the Category you're removing: ");
                	manager.removeCategory(scan.next());
                    System.out.println("Category successfully removed!\n");                
                    break;
                case 6:
                	String list;
//                	while (!list.equalsIgnoreCase(manager.getCategories(get(index)))) {
//                		System.out.println("Type a valid List to add the Article in: \n");
//                		list = scan.next();
//                	}
                	System.out.println("Type: Name of article*, Cost*, Category, Quantity \n(* fields are mandatory)");
                	
                	System.out.println("New Article successfully added!\n");
                	break;
                case 7:
                	System.out.println("Article successfully removed!\n");
                	break;
           		case 8:
           			System.out.println("Closing Interface...");
           			scan.close();
           			return;
           		default:
           			System.out.println("Invalid Option");
           	}			
		}
			
	}
}
