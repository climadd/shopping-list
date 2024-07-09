package pack;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

public class ShoppingList implements Iterable{

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
			if (category != "" && quantity != null) {
				entry = new Article(name, cost, category, quantity);
			} else if (category != "") {
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
				article.subtractQuantity(quantity);
				if(article.getQuantity()<1) {
					iterator.remove();
				}
			}
		}	
	}

	public void printList() {
		System.out.print(name + " : ");
		for (int i = 0; i < articles.size(); i++) {
			Article current = articles.get(i);
			System.out.print(current.getName() + " (" + current.getCost() + "€, " + current.getCategory() + ", n°" + current.getQuantity() + ")");
			if (i < articles.size() - 1) {
				System.out.print("/ ");
			}
		}
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
		for (Article article : articles) {
			price += article.getCost() * article.getQuantity();
		}
		return price;
	}

	public ArrayList<Article> findByCategory(String category) {
		ArrayList<Article> articlesByCategory = new ArrayList<>();
		Iterator<Article> iterator = articles.iterator();
		while(iterator.hasNext()){
			Article article = iterator.next();
			if(article.getCategory().equalsIgnoreCase(category)) {			
				articlesByCategory.add(article);
			}
		}
		return articlesByCategory;
	}	

	public void setDefaultCategory(String removedCategory) {
		Iterator<Article> iterator = articles.iterator();
		while(iterator.hasNext()) {
			Article article = iterator.next();
			if(article.getCategory().equalsIgnoreCase(removedCategory)) {
				article.setDefaultCategory();
			}
		}
	}

	//getters
	public String getName() {
		return name;
	}
	public ArrayList<Article> getArticles(){
		return articles;
	}

	@Override
	public Iterator iterator() {
		// TODO Auto-generated method stub
		return articles.iterator();
	}
}
