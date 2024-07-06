package pack;

import java.util.ArrayList;
import java.util.Iterator;

public class ListManager {

	//attributi
	private ArrayList<ShoppingList> manager;
	private ArrayList<String> categories;

	//costruttore
	public ListManager(){
		this.manager = new ArrayList<ShoppingList>();
		this.categories = new ArrayList<String>();
	}

	//metodi
	public void displayLists() {
		for (ShoppingList shoppingList : manager) {
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
		Iterator<ShoppingList> iterator = manager.iterator();	
		while(iterator.hasNext()) {
			if(iterator.next().getName().equalsIgnoreCase(name)) {
				throw new DuplicateShoppingListException("Shopping List with name " + name + " already present");
			}					
		}
		ShoppingList entry = new ShoppingList(name);
		manager.add(entry);	
	}
	//TODO: solito
	public void removeShoppingList(String name) {
		//devo scendere di un livello, name sta in shoppingList
		//		if(manager.getName().equals(name)) {}


		manager.remove(name);
	}
	//TODO: controllo nome duplicato
	public void addCategory(String category) {
		categories.add(category);
	}

	public void removeCategory(String category) {

		//gli articoli in ogni lista di tale categoria vanno settati a NONE
		categories.remove(category);
	}
	public void setDefaultCategory() {
		//operazione su tutte le liste
	}
	//getters
	public ArrayList<String> getCategories(){
		return categories;
	}
}
