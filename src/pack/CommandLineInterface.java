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
	public void executeInterface() throws DuplicateNameException, MissingNameException, ValidationException {
		System.out.println("Launching Command Line Interface...\n");
		int operation;

		while(true) {
			System.out.println("Which operation do you want to perform?\nType the corresponding number:");
			System.out.println("  0. Display Lists and their Contents");	//fatto
			System.out.println("  1. Display every Category");	//fatto
			System.out.println("  2. Add new List");	//fatto
			System.out.println("  3. Remove existing List");	//fatto
			System.out.println("  4. Add new Category");	//fatto
			System.out.println("  5. Remove existing Category");	//fatto
			System.out.println("  6. Add new Article");		//fatto
			System.out.println("  7. Remove existing Article");		// fatto
			System.out.println("  8. Find Article by List and Prefix");	//fatto
			System.out.println("  9. Find Article by List and Category");	//fatto
			System.out.println(" 10. Calculate the total price of a List");		//fatto
			System.out.println(" 11. Exit");
			operation= scan.nextInt();

			switch (operation) {
			//Display contents of Lists
			case 0:
				System.out.println("Your Lists are: ");
				manager.displayLists();
				break;
				//Display Categories
			case 1:
				System.out.println("Your Categories are: ");
				manager.displayCategories(manager);
				System.out.println();
				break;
			case 2:
				//Add new List
				System.out.println("Type the name of the new List: ");
				try {
					manager.addShoppingList(scan.next());
					System.out.println("New List successfully created!\n");
				}catch(DuplicateNameException dnException) {
					System.out.println(dnException.getMessage() + "\n");
				}
				break;
				//Remove existing List
			case 3:
				System.out.println("Type the name of the List you're removing:  ");
				try {
					manager.removeShoppingList(scan.next());
					System.out.println("List successfully removed!\n");
				}catch(MissingNameException mnException) {
					System.out.println(mnException.getMessage() + "\n");
				}
				break;
				//Add new Category
			case 4:
				System.out.println("Type the name of the new Category: ");
				try {
					manager.addCategory(scan.next());
					System.out.println("New Category successfully created!\n");
				}catch(DuplicateNameException dnException) {
					System.out.println(dnException.getMessage() + "\n");
				}
				break;
				//Remove existing Category
			case 5:
				System.out.println("Type the name of the Category you're removing: ");
				try {
					String categoryToBeRemoved= scan.next();
					manager.removeCategory(categoryToBeRemoved);
					manager.setDefaultCategory(categoryToBeRemoved);
					System.out.println("Category successfully removed!\n");
				}catch(MissingNameException mnException) {
					System.out.println(mnException.getMessage() + "\n");
				}
				break;
				//Add new Article
			case 6:
				System.out.println("Type a valid List to add the Article in: \n");

				String newArticleList = scan.next();
				for(ShoppingList shoppingList : manager.getShoppingLists()) {
					if(shoppingList.getName().equalsIgnoreCase(newArticleList)) {
						System.out.println("Type the Name of the Article (mandatory field): ");
						String newArticleName = scan.next();
						System.out.println("Type the Cost of the Article (mandatory field): ");
						double newArticleCost = scan.nextDouble();
						System.out.println("Type the Category of the Article: "); //stringa vuota = elemento nullo x costruttori
						String newArticleCategory = scan.next();
						System.out.println("Type the Quantity of the Article: "); //stringa vuota = elemento nullo x costruttori
						int newArticleQuantity = scan.nextInt();
						shoppingList.addArticle(newArticleName, newArticleCost, newArticleCategory, newArticleQuantity);
						if (!manager.categoryPresenceCheck(newArticleCategory)) {
							shoppingList.setDefaultCategory(newArticleCategory);
						}
					}
				}					
				break;
				//Remove existing Article
			case 7:
				System.out.println("Type the List you want to remove an Article from:");
				String listForArticleRemoval = scan.next();
				for(ShoppingList shoppingList : manager.getShoppingLists()) {
					if(shoppingList.getName().equalsIgnoreCase(listForArticleRemoval)) {
						System.out.println("Type the Name of the Article to remove:");
						String articleToBeRemoved = scan.next();
						System.out.println("Type the Quantity of the Article you want to remove:");
						shoppingList.removeArticle(articleToBeRemoved, scan.nextInt());
					}
				}
				System.out.println("Article successfully removed!\n");
				break;
				//Find Articles by List and Prefix
			case 8:
				System.out.println("Type a valid List to find Articles in:");
				//TRY+CATCH
				String listToFindPrefixIn = scan.next();
				System.out.println("Type a prefix:");			
				String prefix = scan.next();
				for(ShoppingList shoppingList : manager.getShoppingLists()) {
					if(shoppingList.getName().equalsIgnoreCase(listToFindPrefixIn)) {
						ShoppingList resultsByPrefixList = new ShoppingList("Results by prefix",shoppingList.findByPrefix(prefix));
						resultsByPrefixList.printList();
						System.out.println();
					}
				}
				break;
				//Find Articles by List and Category
			case 9:
				System.out.println("Type a valid List to find Articles in:");
				//TRY+CATCH
				String listToFindArticlesByCathegory = scan.next();
				System.out.println("Type a valid Category:");
				String categoryToFindArticles = scan.next();
				for(ShoppingList shoppingList : manager.getShoppingLists()) {
					if(shoppingList.getName().equalsIgnoreCase(listToFindArticlesByCathegory)){
						ShoppingList resultsByCategory = new ShoppingList("Results by Category", shoppingList.findByCategory(categoryToFindArticles));
						resultsByCategory.printList();
						System.out.println();
					}
				}
				break;
				//Calculate total price of List
			case 10:
				System.out.println("Type a valid List to calculate the price for: \n");
				String listToPrice = scan.next();
				for(ShoppingList shoppingList : manager.getShoppingLists()) {
					if(shoppingList.getName().equalsIgnoreCase(listToPrice)) {
						System.out.println("Total price of " + shoppingList.getName() + " = " + shoppingList.priceOfList() + "€.");
					}
				}
				break;
				//Exit
			case 11:
				System.out.println("Closing Interface...");
				scan.close();
				break;
			default:
				System.out.println("Invalid Option");
			}			
		}
	}
}

