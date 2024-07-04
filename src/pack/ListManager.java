package pack;

import java.util.ArrayList;

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
		//utilizzo un ciclo in cui ricavo i dati attraverso i getter e li stampo tutti?
		System.out.println("Mostrando le Liste presenti in memoria...\n" + manager.toString());
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
		//gli articoli di tale categoria vanno settati a NONE
		
		//confronto stringa con nomi categorie, ciclando elimina
	}
	
}
	