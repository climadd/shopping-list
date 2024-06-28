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
		articles.remove(article);
	}
}
