package pack;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

public class ShoppingList {

	//attributi
	private String name;
	private ArrayList<Article> articles;

	//costruttore
	public ShoppingList(String name) {
		this.name = name;
		this.articles = new ArrayList<Article>();
	}
	public ShoppingList importFromFile(File shoppingListFile) {
		throw new RuntimeException("TODO da implementare");
	}
	public void exportToFile(String shoppingListPath) {
		throw new RuntimeException("TODO da implementare");
	}

	//metodi
	public void addArticle(String name, double cost, String category, Integer quantity) throws ValidationException {
		Iterator<Article> iterator = articles.iterator();
		boolean articleMatch = false;		//flag
		while(iterator.hasNext() && !articleMatch) {
			Article article = iterator.next();
			if(article.getName().equalsIgnoreCase(name)) {
				articleMatch = true;
				article.addQuantity(quantity);
			}
		}
		if(!articleMatch) {
			Article entry;
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
	}

	public void removeArticle(String name, int quantity) throws ValidationException {
		Iterator<Article> iterator = articles.iterator();
		boolean articleMatch = false;		//flag
		while(iterator.hasNext() && !articleMatch) {
			Article article = iterator.next();
			if(article.getName().equalsIgnoreCase(name)) {
				articleMatch = true;
				article.removeQuantity(quantity);
				if(article.getQuantity()<1) {
					iterator.remove();
				}
			}
		}	
	}
	//TODO: usare iterator opzionale
	public ArrayList<Article> findByPrefix(String prefix) {
		ArrayList<Article> answ = new ArrayList<>();
		for(Article next: articles) 
			if(next.toString().startsWith(prefix))
				answ.add(next);
		return answ;		
	}
	//TODO: usare iterator opzionale
	public double priceOfList() {
		double price = 0;
		for (Article article : articles) {
			price += article.getCost() * article.getQuantity();
		}
		return price;
	}

	//chiedo se posso usare lo stream
	public ArrayList<Article> findByCategory() {
		ArrayList<Article> answ = new ArrayList<>();
		//computaz
		return answ;
	}
	//TODO: iterator
	public void setDefaultCategory(String removedCategory) {

	}
	//getters
	public String getName() {
		return name;
	}
	public ArrayList<Article> getArticles(){
		return articles;
	}
}
