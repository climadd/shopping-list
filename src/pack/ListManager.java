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
		
	}
	public void removeShoppingList(String name) {
		
	}
	public void addCathegory(String cathegory) {
		
	}
	public void deleteCathegory(String cathegory) {
		//gli articoli di tale categoria vanno settati a NONE
	}
	
}
	