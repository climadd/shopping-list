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
	public void addShoppingList(ShoppingList name) {
		
	}
	public void removeShoppingList(ShoppingList name) {
		
	}
	public void addCathegory(String cathegory) {
		
	}
	public void removeCathegory(String cathegory) {
		//gli articoli di tale categoria vanno settati a NONE
	}
	
}
	