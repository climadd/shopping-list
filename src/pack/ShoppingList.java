package pack;

import java.util.ArrayList;

public class ShoppingList {
	
	//attributi
	private String name;
	private ArrayList<Article> articles;
	
	//costruttore
	public ShoppingList(String name) {
		this.name = name;
		this.articles = new ArrayList<Article>();
	}
	
	//metodi
	public void addArticle(Article article) {
		articles.add(article);
	}
	public void removeArticle(Article article) {
		//scorrere la lista?
		articles.remove(article);
	}
	public ArrayList<Article> findByPrefix(String prefix) {
			ArrayList<Article> answ = new ArrayList<>();
			for(Article next: articles) 
				if(next.toString().startsWith(prefix))
					answ.add(next);
			return answ;		
	}

	public double priceOfList() {
		
		return 0;
	}
	public ArrayList<Article> findByCathegory() {
		ArrayList<Article> answ = new ArrayList<>();
		//computaz
		return answ;
	}
}
