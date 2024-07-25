package main.java.org.view;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import main.java.org.model.DuplicateNameException;
import main.java.org.model.ListManager;
import main.java.org.model.MissingNameException;
import main.java.org.model.ShoppingList;
import main.java.org.model.ValidationException;


/**
 * The CommandLineInterface class is a command-line based user-interface for managing shopping lists and categories. 
 * It offers various operations such as adding and removing lists, categories, and articles to the user.
 */
public class CommandLineInterface {

	private ListManager manager;
	private Scanner scan;

	/**
	 * Constructs a CommandLineInterface with a Scanner object passed as parameter from the Main which will be used
	 * thought all the execution of the .executeInterface() method.
	 *
	 * @param scan the Scanner object used for user input
	 */
	public CommandLineInterface(Scanner scan) {
		this.manager = new ListManager();
		this.scan = scan;
	}

	//methods
	/**
	 * Launches the command line interface. It's mainly composed by a Switch construct, and all the other methods accessible 
	 * through its various branches.
	 */
	public void executeInterface() {
		System.out.println("Launching Command Line Interface...\n");
		int operation;

		while(true) {
			try {
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
				System.out.println(" 11. Import List from File"); //fatto
				System.out.println(" 12. Export List to File");	//fatto
				System.out.println(" 13. Exit"); //fatto

				operation= scan.nextInt();
				switch (operation) {

				case 0: displayLists();
				break;

				case 1: displayCategories();
				break;

				case 2: addList();
				break;

				case 3: removeList();
				break;

				case 4: addCategory();
				break;

				case 5: removeCategory();
				break;

				case 6: addArticle();
				break;

				case 7: removeArticle();
				break;

				case 8: findByPrefix();
				break;

				case 9: findByCategory();
				break;

				case 10: totalPrice();
				break;

				case 11: importFromFile();
				break;

				case 12: exportToFile();
				break;

				case 13: exit();
				return;
				default:
					System.out.println("Invalid Option! Type a number between 0 and 13.\n");
				}
			} catch (InputMismatchException imException) {
				System.out.println("Invalid User Input! Please enter a number.\n");
				scan.next();
			}
		}
	}

	/**
	 * Displays the lists and their contents.
	 */
	public void displayLists() {
		System.out.println("Your Lists are: ");
		manager.displayLists();
	}

	/**
	 * Displays every category.
	 */
	public void displayCategories() {
		System.out.println("Your Categories are: ");
		manager.displayCategories(manager);
		System.out.println();
	}

	/**
	 * Adds a new shopping list. 
	 * Catches in an exception the case where the name given for the new list already belongs to a list in memory.
	 */
	public void addList() {
		System.out.println("Type the name of the new List: ");
		try {
			manager.addShoppingList(scan.next());
			System.out.println("New List successfully created!\n");
		}catch(DuplicateNameException dnException) {
			System.out.println(dnException.getMessage() + "\n");
		}
	}

	/**
	 * Removes an existing shopping list.
	 * Catches in an exception the case where the name specified doesn't belong to any list in memory.
	 */
	public void removeList() {
		System.out.println("Type the name of the List you're removing:  ");
		try {
			manager.removeShoppingList(scan.next());
			System.out.println("List successfully removed!\n");
		}catch(MissingNameException mnException) {
			System.out.println(mnException.getMessage() + "\n");
		}
	}

	/**
	 * Adds a new category.
	 * Catches in an exception the case where the name given for the new category already belongs to a category in memory.
	 */
	public void addCategory() {
		System.out.println("Type the name of the new Category: ");
		try {
			manager.addCategory(scan.next());
			System.out.println("New Category successfully created!\n");
		}catch(DuplicateNameException dnException) {
			System.out.println(dnException.getMessage() + "\n");
		}
	}

	/**
	 * Removes an existing category.
	 * Catches in an exception the case where the name specified doesn't belong to any category in memory.
	 */
	public void removeCategory() {
		System.out.println("Type the name of the Category you're removing: ");
		try {
			String categoryToBeRemoved= scan.next();
			manager.removeCategory(categoryToBeRemoved);
			manager.setDefaultCategory(categoryToBeRemoved);
			System.out.println("Category successfully removed!\n");
		}catch(MissingNameException mnException) {
			System.out.println(mnException.getMessage() + "\n");
		}
	}

	/**
	 * Adds a new article to a specified shopping list.
	 * Catches ValidationException when the quantity given is not valid
	 * Catches MissingNameException when the list provided isn't present in memory
	 */
	public void addArticle() {
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
				try {
					shoppingList.addArticle(newArticleName, newArticleCost, newArticleCategory, newArticleQuantity);
					if (!manager.categoryPresenceCheck(newArticleCategory)) shoppingList.setDefaultCategory(newArticleCategory);
				}catch(ValidationException vException){               
					System.out.println(vException.getMessage() + "\n");
				} catch (MissingNameException mnException) {
					System.out.println(mnException.getMessage() + "\n");
				}
			}
		}
	}

	/**
	 * Removes an article from a specified shopping list.
	 * Catches ValidationException when the quantity is invalid.
	 */
	public void removeArticle() {
		System.out.println("Type the List you want to remove an Article from:");
		String listForArticleRemoval = scan.next();
		for(ShoppingList shoppingList : manager.getShoppingLists()) {
			if(shoppingList.getName().equalsIgnoreCase(listForArticleRemoval)) {
				System.out.println("Type the Name of the Article to remove:");
				String articleToBeRemoved = scan.next();
				System.out.println("Type the Quantity of the Article you want to remove:");
				try {
					shoppingList.removeArticle(articleToBeRemoved, scan.nextInt());
				}catch (ValidationException vException) {
					System.out.println(vException.getMessage() + "\n");
				}
			}
		}
		System.out.println("Article successfully removed!\n");
	}

	/**
	 * Finds articles in a specified list by their prefix.
	 */
	public void findByPrefix() {
		System.out.println("Type a valid List to find Articles in:");
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
	}

	/**
	 * Finds articles in a specified list by their category.
	 */
	public void findByCategory() {
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
	}

	/**
	 * Calculates the total price of a specified shopping list and prints it.
	 */
	public void totalPrice() {
		System.out.println("Type a valid List to calculate the price for: \n");
		String listToPrice = scan.next();
		boolean flag = false;
		for(ShoppingList shoppingList : manager.getShoppingLists()) {
			if(shoppingList.getName().equalsIgnoreCase(listToPrice)) {
				System.out.println("Total price of " + shoppingList.getName() + " = " + shoppingList.priceOfList() + "€.");

			}
		}
		if(!flag) System.out.println("List not found");
	}

	/**
	 * TODO: it works, needs some refactoring still
	 * 
	 * Creates an Object ShoppingList and its contained Articles by taking the data from a .txt file
	 */
	public void importFromFile() {
		System.out.println("Type the name of the File you want to Import: ");
		String fileToImport = scan.next();
		try {
			manager.importFromFile(fileToImport);
			System.out.println("List Imported successfully\n");
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage() + "\n");
		} catch (ValidationException vException) {
			System.out.println(vException.getMessage() + "\n");
		}
	}

	/**
	 * Creates a file .txt named after a list and writes its contents on it
	 * @throws IOException 
	 */
	public void exportToFile()  {
		System.out.println("Type a valid List to Export: ");
		String listToExport = scan.next();
		for(ShoppingList shoppingList : manager.getShoppingLists()) {
			if(shoppingList.getName().equalsIgnoreCase(listToExport)) {
				try {
					shoppingList.exportToFile(listToExport);
					System.out.println("List successfully Exported to file\n");
				} catch (IOException e) {
					System.out.println("I/O Exception!");
				}
			}
		}
	}

	/**
	 * Closes the scanner.
	 */
	public void exit() {
		System.out.println("Closing Interface...");
		scan.close();
	}

}


