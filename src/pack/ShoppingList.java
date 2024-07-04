package pack;

import java.util.ArrayList;

public class ShoppingList {
	
	//attributi
	private String name;
	private ArrayList<Article> articles;
	//attributo extra: private int lenght = 0;
	
	//costruttore
	public ShoppingList(String name) {
		this.name = name;
		this.articles = new ArrayList<Article>();
	}
	
	//metodi
	public void addArticle(String name, double cost, String category, Integer quantity) {
		Article entry;
		//uso la classe wrapper per int -> Integer.. valuta la correttezza logica del auto boxing/unboxing
		if (category != null && quantity != null) {
			entry = new Article(name, cost, category, quantity);
		} else if (category != null) {
			entry = new Article(name, cost, category);
		} else if (quantity != null) {
			entry = new Article(name, cost, quantity);
		} else {
			entry = new Article(name, cost);
		}
		articles.add(entry);
	}
	
	public void removeArticle(String name) {
	
		//scorrere la lista? con iterable. if ArrayList[i].equals(name) -> delete
		articles.remove(name);
	}
	
	public ArrayList<Article> findByPrefix(String prefix) {
			ArrayList<Article> answ = new ArrayList<>();
			for(Article next: articles) 
				if(next.toString().startsWith(prefix))
					answ.add(next);
			return answ;		
	}
	
	public double priceOfList() {
		double price = 0;
		//scorri lista e fai sommatoria
		return price;
	}
	
	public ArrayList<Article> findByCategory() {
		ArrayList<Article> answ = new ArrayList<>();
		//computaz
		return answ;
	}
}
