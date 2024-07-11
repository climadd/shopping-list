package main.java.org.model;

import java.util.ArrayList;
import java.util.Iterator;

import main.java.org.exceptions.DuplicateNameException;
import main.java.org.exceptions.MissingNameException;

public class ListManager {

	//attributi
	private ArrayList<ShoppingList> collectionOfShoppingLists;
	private ArrayList<String> categories;

	//costruttore
	public ListManager(){
		this.collectionOfShoppingLists = new ArrayList<ShoppingList>();
		this.categories = new ArrayList<String>();
	}

	//metodi
	public void displayLists() {
		for (ShoppingList shoppingList : collectionOfShoppingLists) {
			shoppingList.printList();
			System.out.println();
		}
		System.out.println();
	}

	public void displayCategories(ListManager manager) {
		System.out.println(manager.getCategories());	
	} 

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

	public void addCategory(String category) throws DuplicateNameException {
		Iterator<String> iterator = categories.iterator();	
		while(iterator.hasNext()) {
			if(iterator.next().equalsIgnoreCase(category)) {
				throw new DuplicateNameException("Category with name " + category + " already present");
			}	
		}
		categories.add(category);
	}

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

	public void setDefaultCategory(String removedCategory) {	
		for (ShoppingList shoppingList : collectionOfShoppingLists) {
			shoppingList.setDefaultCategory(removedCategory);
		}

	}

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
	//getters
	public ArrayList<ShoppingList> getShoppingLists(){
		return collectionOfShoppingLists;
	}
	public ArrayList<String> getCategories(){
		return categories;
	}
}
