package pack;

import java.util.ArrayList;
import java.util.Iterator;

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
			System.out.print(shoppingList.getName() + " : ");
			ArrayList<Article> articles = shoppingList.getArticles();
			for (int i = 0; i < articles.size(); i++) {
				System.out.print(articles.get(i));
				if (i < articles.size() - 1) {
					System.out.print(", ");
				}
			}
			System.out.println();
		}
		System.out.println();
	}

	public void displayCategories(ListManager manager) {
		System.out.println(manager.getCategories());	
	} 

	public void addShoppingList(String name) throws DuplicateShoppingListException {
		Iterator<ShoppingList> iterator = collectionOfShoppingLists.iterator();	
		while(iterator.hasNext()) {
			if(iterator.next().getName().equalsIgnoreCase(name)) {
				throw new DuplicateShoppingListException("Shopping List with name " + name + " already present");
			}					
		}
		ShoppingList entry = new ShoppingList(name);
		collectionOfShoppingLists.add(entry);	
	}
	
	public void removeShoppingList(String name) {
		Iterator<ShoppingList> iterator = collectionOfShoppingLists.iterator();
		boolean matchFound = false;
		while(iterator.hasNext() && !matchFound) {
			if(iterator.next().getName().equalsIgnoreCase(name)) {
				matchFound = true;
				iterator.remove();
			}
		}
	}
	
	public void addCategory(String category) throws DuplicateShoppingListException {
		Iterator<String> iterator = categories.iterator();	
		while(iterator.hasNext()) {
			if(iterator.next().equalsIgnoreCase(category)) {
				throw new DuplicateShoppingListException("Category with name " + category + " already present");
			}	
		}
		categories.add(category);
	}

	public void removeCategory(String category) {
		Iterator<ShoppingList> iterator = collectionOfShoppingLists.iterator();
		boolean matchFound = false;
		while(iterator.hasNext() && !matchFound) {
			if(iterator.next().getName().equalsIgnoreCase(category)) {
				matchFound = true;
				iterator.remove();
			}
		}
	}

	public void setDefaultCategory(String removedCategory) {	
		for (ShoppingList shoppingList : collectionOfShoppingLists) {
			shoppingList.setDefaultCategory(removedCategory);
		}

	}
	
	public boolean categoryPresenceCheck(String checkedCategory) {
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
	public ArrayList<String> getCategories(){
		return categories;
	}
}
