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
	public void executeInterface() throws DuplicateNameException, MissingNameException {
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
			 * -findByCategory
			 * -priceOfList
			 * -Exit
			 */

			System.out.println("Which operation do you want to perform?\nType the corresponding number:");
			System.out.println("  0. Display Lists and their Contents");	//fatto
			System.out.println("  1. Display every Category");	//fatto
			System.out.println("  2. Add new List");	//fatto
			System.out.println("  3. Remove existing List");	//fatto
			System.out.println("  4. Add new Category");	//fatto
			System.out.println("  5. Remove existing Category");	//fatto ma non lancio eccezione, ho il metodo
			System.out.println("  6. Add new Article");
			System.out.println("  7. Remove existing Article");
			System.out.println("  8. Find Article by Category");
			System.out.println("  9. Calculate the total price of a List");
			System.out.println(" 10. Exit");
			operation= scan.nextInt();

			switch (operation) {
			case 0:
				System.out.println("Your Lists are: ");
				manager.displayLists();
				break;
			case 1:
				System.out.println("Your Categories are: ");
				manager.displayCategories(manager);
				System.out.println();
				break;
			case 2:
				System.out.println("Type the name of the new List: ");
				try {
					manager.addShoppingList(scan.next());
					System.out.println("New List successfully created!\n");
				}catch(DuplicateNameException dnException) {
					System.out.println(dnException.getMessage() + "\n");
				}
				break;
			case 3:
				System.out.println("Type the name of the List you're removing:  ");
				try {
					manager.removeShoppingList(scan.next());
					System.out.println("List successfully removed!\n");
				}catch(MissingNameException mnException) {
					System.out.println(mnException.getMessage() + "\n");
				}
				
				break;
			case 4:
				System.out.println("Type the name of the new Category: ");
				try {
				manager.addCategory(scan.next());
				System.out.println("New Category successfully created!\n");
				}catch(DuplicateNameException dnException) {
					System.out.println(dnException.getMessage() + "\n");
				}
				break;
			case 5:
				System.out.println("Type the name of the Category you're removing: ");
				String userInput = scan.next();
				if(manager.categoryPresenceCheck(userInput)) {
					manager.removeCategory(userInput);
					manager.setDefaultCategory(userInput);
					System.out.println("Category successfully removed!\n"); 
				}
			
				break;
			case 6:
				String list;
				//TODO:controllo che la categoria passata sia presente. se non presente metto costante
				//                	while (!list.equalsIgnoreCase(manager.getCategories(get(index)))) {
				System.out.println("Type a valid List to add the Article in: \n");
				String newArticleList = scan.next();
				System.out.println("Type the Name of the Article (mandatory field): ");
				String newArticleName = scan.next();
				System.out.println("Type the Cost of the Article (mandatory field): ");
				Double newArticleCost = scan.nextDouble();
				System.out.println("Type the Category of the Article: "); //stringa vuota = elemento nullo x costruttori
				String newArticleCategory = scan.next();
				System.out.println("Type the Quantity of the Article: "); //stringa vuota = elemento nullo x costruttori
				int newArticleQuantity = scan.nextInt();
				
				
				System.out.println("New Article successfully added!\n");
				break;
			case 7:
				System.out.println("Article successfully removed!\n");
				break;
			case 8:
				break;
			case 9:
				break;
			case 10:
				System.out.println("Closing Interface...");
				scan.close();
				return;
			default:
				System.out.println("Invalid Option");
			}			
		}

	}
}
