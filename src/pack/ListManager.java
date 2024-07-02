package pack;

import java.util.ArrayList;

public class ListManager {

	//attributi
	private ArrayList<ShoppingList> manager;
	private ArrayList<String> cathegories;
	
	//costruttore
	public ListManager(){
		this.manager = new ArrayList<ShoppingList>();
		this.cathegories = new ArrayList<String>();
	}
	
	//metodi
	public void addShoppingList(String name) {
		ShoppingList entry = new ShoppingList(name);
		manager.add(entry);	
	}
	public void removeShoppingList(String name) {
		//confronto ciclico stringa con nomi shoppingList, ciclando elimina
	}
	public void addCathegory(String cathegory) {
		cathegories.add(cathegory);
	}
	public void removeCathegory(String cathegory) {
		//gli articoli di tale categoria vanno settati a NONE
		
		//confronto stringa con nomi categorie, ciclando elimina
	}
	
}
	