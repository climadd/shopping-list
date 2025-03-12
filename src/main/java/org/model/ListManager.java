package main.java.org.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 * ListManager is a collection of shopping lists and a collection of categories, both are represented by ArrayLists.
 */
public class ListManager {

	private ArrayList<ShoppingList> collectionOfShoppingLists;
	private ArrayList<String> categories;

	/**
	 * Constructs a new ListManager with empty lists of shopping lists and categories.
	 */
	public ListManager(){
		this.collectionOfShoppingLists = new ArrayList<ShoppingList>();
		this.categories = new ArrayList<String>();
	}

	//methods
	/**
	 * Displays all shopping lists by invoking ShoppingList's method .printList() on every list present in collectionOfShoppingLists
	 */
	public void displayLists() {
		for (ShoppingList shoppingList : collectionOfShoppingLists) {
			shoppingList.printList();
			System.out.println();
		}
		System.out.println();
	}

	/**
	 * Displays all categories.
	 * 
	 * @param manager the ListManager whose categories are going to be printed
	 */
	public void displayCategories(ListManager manager) {
		System.out.println(manager.getCategories());	
	} 

	/**
	 * Adds a new shopping list with the specified name.
	 * 
	 * @param name the name of the new shopping list
	 * @throws DuplicateNameException if a shopping list with the same name already exists
	 */
	public void addShoppingList(String name) throws DuplicateNameException {
		Iterator<ShoppingList> iterator = collectionOfShoppingLists.iterator();	
		while(iterator.hasNext()) {
			if(iterator.next().getName().equalsIgnoreCase(name)) {
				throw new DuplicateNameException("Shopping List with name " + name + " already present");
			}					
		}
		ShoppingList entry = new ShoppingList(name);
		collectionOfShoppingLists.add(entry);	
	}

	/**
	 * Removes a shopping list with the specified name.
	 * 
	 * @param name the name of the shopping list to remove
	 * @variable articleMatch flag to avoid redundant cycling
	 * @throws MissingNameException if no shopping list with the specified name is found
	 */
	public void removeShoppingList(String name) throws MissingNameException {
		Iterator<ShoppingList> iterator = collectionOfShoppingLists.iterator();
		boolean matchFound = false;
		while(iterator.hasNext() && !matchFound) {
			if(iterator.next().getName().equalsIgnoreCase(name)) {
				matchFound = true;
				iterator.remove();
			}
		}
		if(!matchFound) throw new MissingNameException("Shopping List with name " + name + " not present");
	}

	/**
	 * Adds a new category.
	 * 
	 * @param category the name of the new category
	 * @throws DuplicateNameException if a category with the same name already exists
	 */
	public void addCategory(String category) throws DuplicateNameException {
		Iterator<String> iterator = categories.iterator();	
		while(iterator.hasNext()) {
			if(iterator.next().equalsIgnoreCase(category)) {
				throw new DuplicateNameException("Category with name " + category + " already present");
			}	
		}
		categories.add(category);
	}

	/**
	 * Removes a category with the specified name.
	 * 
	 * @param category the name of the category to remove
	 * @variable articleMatch flag to avoid redundant cycling
	 * @throws MissingNameException if no category with the specified name is found
	 */
	public void removeCategory(String category) throws MissingNameException {
		Iterator<String> iterator = categories.iterator();
		boolean matchFound = false;
		while(iterator.hasNext() && !matchFound) {
			if(iterator.next().equalsIgnoreCase(category)) {
				matchFound = true;
				iterator.remove();
			}
		}
		if(!matchFound)	throw new MissingNameException("Category with name " + category + " not present");
	}

	/**
	 * Sets the default category by invoking ShoppingList's method .setDefaultCategory() shopping lists of the collection.
	 * 
	 * @param replacedCategory the name of the category to be replaced with the default category
	 */
	public void setDefaultCategory(String replacedCategory) {	
		for (ShoppingList shoppingList : collectionOfShoppingLists) {
			shoppingList.setDefaultCategory(replacedCategory);
		}

	}

	/**
	 * Checks whether a category is present.
	 * 
	 * @param checkedCategory the name of the category to check
	 * @return true if the category is present, false otherwise
	 * @throws MissingNameException if no category with the specified name is found
	 */
	public boolean categoryPresenceCheck(String checkedCategory) throws MissingNameException{
		boolean check = false;
		for (int i=0; i < categories.size() && !check; i++) {
			String category = categories.get(i);
			if(category.equalsIgnoreCase(checkedCategory)) {
				check=true;			
			}
		}
		return check;	
	}
	
	/** 
	 * Imports a shopping list from a file. todo: needs some refactoring, but it works
	 * 
	 * Searches for a file with the specified name within the directory specified by {@code ShoppingList.PATH}. 
	 * If a matching file is found, it creates a new ShoppingList object with the name of the file , adds it to
	 * the collection of shopping lists, and populates it with articles read from the file. The
	 * articles are assumed to be separated by a comma and a space in the file.
	 *
	 * @param shoppingListFromFile the name of the shopping list file (without the ".txt" extension)
	 *                             to import from
	 * @throws FileNotFoundException if no matching file is found in the directory
	 * @throws ValidationException   if there is an issue with validating the contents of the file
	 */
	public void importFromFile(String shoppingListFromFile) throws FileNotFoundException, ValidationException {

		File directory = new File(ShoppingList.PATH);
		boolean matchFound = false;
		for(File file : directory.listFiles()) {
			if(file.getName().equalsIgnoreCase(shoppingListFromFile+".txt")) {
				matchFound = true;
				ShoppingList importedShoppingList = new ShoppingList(shoppingListFromFile);
				collectionOfShoppingLists.add(importedShoppingList);
				
				Scanner scan = new Scanner(file);
				scan.useDelimiter(", ");
				while (scan.hasNext()) {
					String article = scan.next();
					importedShoppingList.addArticle(article, 1, "Uncategorized", 1);
				}
				scan.close();
			}
		}
		if(!matchFound) throw new FileNotFoundException("File Not Found!");
	}

	//getters
	/**
	 * Returns the collection of shopping lists.
	 * 
	 * @return the collection of shopping lists
	 */
	public ArrayList<ShoppingList> getShoppingLists(){
		return collectionOfShoppingLists;
	}

	/**
	 * Returns the list of categories.
	 * 
	 * @return the list of categories
	 */
	public ArrayList<String> getCategories(){
		return categories;
	}
}
