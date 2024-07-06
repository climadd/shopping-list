package pack;

import java.util.ArrayList;

public class ListManager {

	//attributi
	private ArrayList<ShoppingList> manager;
	private ArrayList<String> categories;
	//attributo extra: private int lenght = 0;
	
	//costruttore
	public ListManager(){
		this.manager = new ArrayList<ShoppingList>();
		this.categories = new ArrayList<String>();
	}
	
	//metodi
	public void displayLists(ListManager manager) {

	}
	
	public void displayCategories(ListManager manager) {
		System.out.println(manager.getCategories());	
	} 
	       
	public void addShoppingList(String name) {
		ShoppingList entry = new ShoppingList(name);
		manager.add(entry);	
	}
	
	public void removeShoppingList(String name) {
		//confronto ciclico stringa con nomi shoppingList, ciclando elimina
		manager.remove(name);
	}
	
	public void addCategory(String category) {
		categories.add(category);
	}
	
	public void removeCategory(String category) {
		
		//gli articoli in ogni lista di tale categoria vanno settati a NONE
		categories.remove(category);
		
	}
	//getters
	public ArrayList<String> getCategories(){
		return categories;
	}
}
	