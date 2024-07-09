package pack;

import java.util.ArrayList;
import java.util.Iterator;
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
			/*
			 * -Display contents
			 * -display categories
			 * -Add new List
			 * -Remove existing List
			 * -Add new Category
			 * -Remove existing Category
			 * -Add new Article
			 * -Remove existing Article
			 * -findByPrefix
			 * -findByCategory
			 * -priceOfList
			 * -Exit
			 */

			System.out.println("Which operation do you want to perform?\nType the corresponding number:");
			System.out.println("  0. Display Lists and their Contents");	//fatto
			System.out.println("  1. Display every Category");	//fatto
			System.out.println("  2. Add new List");	//fatto
			System.out.println("  3. Remove existing List");	//sbaglia entra in eccezione anche quando non dovrebbe
			System.out.println("  4. Add new Category");	//fatto
			System.out.println("  5. Remove existing Category");	//sbaglia entra in eccezione anche quando non dovrebbe
			System.out.println("  6. Add new Article");		//gestisci il non categorizzato/valori default
			System.out.println("  7. Remove existing Article");		//
			System.out.println("  8. Find Article by List and Prefix");	//
			System.out.println("  9. Find Article by Category");	//
			System.out.println(" 10. Calculate the total price of a List");		//fatto
			System.out.println(" 11. Exit");
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
					System.out.println("List successfully removed!\n");	//NON FUNZIONA, NON TROVA LA LISTA DALLO STESSO NOME
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
				try {
					manager.removeCategory(scan.next());
					System.out.println("Category successfully removed!\n");		//	NON FUNZIONA, NON TROVA LA LISTA DALLO STESSO NOME
				}catch(MissingNameException mnException) {
					System.out.println(mnException.getMessage() + "\n");
				}// TODO: passa ogni lista per settare a default le categorie degli articoli di questa

				break;
			case 6:
				System.out.println("Type a valid List to add the Article in: \n");
				if(true) {
					String newArticleList = scan.next();
					for(ShoppingList shoppingList : manager.getShoppingLists()) {
						if(shoppingList.getName().equalsIgnoreCase(newArticleList)) {
							System.out.println("Type the Name of the Article (mandatory field): ");
							String newArticleName = scan.next();
							System.out.println("Type the Cost of the Article (mandatory field): ");
							double newArticleCost = scan.nextDouble();
							System.out.println("Type the Category of the Article: "); //stringa vuota = elemento nullo x costruttori
							String newArticleCategory = scan.next();
							// TODO: controllo che la categoria sia presente
							System.out.println("Type the Quantity of the Article: "); //stringa vuota = elemento nullo x costruttori
							int newArticleQuantity = scan.nextInt();
							shoppingList.addArticle(newArticleName, newArticleCost, newArticleCategory, newArticleQuantity);
						}
					}					
				}//catch

				break;
			case 7:
				//TODO: yet to implement
				System.out.println("Article successfully removed!\n");
				break;
			case 8:
				break;
			case 9:
				// find article by category: make a new ShoppingList named answer where i add every matching article
				for (ShoppingList shoppingList : manager.getShoppingLists()) {
					ShoppingList matchingArticleAnswers;
					ArrayList<Article> articles = shoppingList.getArticles();
					for (int i = 0; i < articles.size(); i++) {
						Article current = articles.get(i);
						System.out.print(current.getName() + " (" + current.getCost() + "€, " + current.getCategory() + ", n°" + current.getQuantity() + ")");
						if (i < articles.size() - 1) {
							System.out.print("/ ");
						}
					}
					System.out.println();
				}
				System.out.println();
				break;
			case 10:
				System.out.println("Type a valid List to calculate the price for: \n");
				String listToPrice = scan.next();
				for(ShoppingList shoppingList : manager.getShoppingLists()) {
					if(shoppingList.getName().equalsIgnoreCase(listToPrice)) {
						System.out.println("Total price of " + shoppingList.getName() + " = " + shoppingList.priceOfList() + "€.");
					}
				}
				break;
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

