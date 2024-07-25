package main.java.org.model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * the class represent a shopping list as an ArrayList containing articles.
 * The "name" attribute is the identifier of a ShoppingList object within the same ListManager object.
 */
public class ShoppingList implements Iterable<Article>{

	private String name;
	private ArrayList<Article> articles;
	public static String PATH = "C:\\Users\\loren\\eclipse-workspace\\shopping-list\\src\\main\\java\\org\\files";

	/**
	 * Constructs a ShoppingList with name and articles.
	 * 
	 * @param name     the name of the shopping list
	 * @param articles the list of articles
	 */
	public ShoppingList(String name, ArrayList<Article> articles) {
		this.name = name;
		this.articles = articles;
	}

	/**
	 * Constructs a ShoppingList with name.
	 * 
	 * @param name the name of the shopping list
	 */
	public ShoppingList(String name) {
		this(name, new ArrayList<Article>());
	}

	//methods	
	/**
	 * Adds an article to the shopping list. 
	 * If an article with the same name already exists, increments its quantity.
	 * 
	 * @param name     the name of the article
	 * @param cost     the cost of the article
	 * @param category the category of the article
	 * @param quantity the quantity of the article
	 * @variable articleMatch flag to avoid redundant cycling
	 * @throws ValidationException if the quantity is invalid
	 */
	public void addArticle(String name, double cost, String category, Integer quantity) throws ValidationException {
		Iterator<Article> iterator = articles.iterator();
		boolean articleMatch = false;
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

	/**
	 * Removes an article from the shopping list or decreases its quantity based on the quantity parameter.
	 * 
	 * @param name     the name of the article
	 * @param quantity the quantity to remove
	 * @variable articleMatch flag to avoid redundant cycling
	 * @throws ValidationException if the quantity is invalid
	 */
	public void removeArticle(String name, int quantity) throws ValidationException {
		Iterator<Article> iterator = articles.iterator();
		boolean articleMatch = false;
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

	/**
	 * Prints the shopping list.
	 */
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

	/**
	 * Finds articles by prefix.
	 * 
	 * @param prefix the prefix to search for
	 * @return matchingArticles = ArrayList of articles with names starting with prefix
	 */
	public ArrayList<Article> findByPrefix(String prefix) {
		ArrayList<Article> matchingArticles = new ArrayList<>();
		for(Article next: articles) 
			if(next.getName().startsWith(prefix))
				matchingArticles.add(next);
		return matchingArticles;		
	}

	/**
	 * Calculates the total price of the shopping list.
	 * 
	 * @return price = the total price of the shopping list
	 */
	public double priceOfList() {
		double price = 0;
		for (Article article : articles) {
			price += article.getCost() * article.getQuantity();
		}
		return price;
	}

	/**
	 * Finds articles by category.
	 * 
	 * @param category the category to search for
	 * @return ArrayList of articles from the specified category
	 */
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


	/**
	 * Sets the default category for articles in the shopping list that match the removed category by invoking 
	 * Article's method .setDefaultCategory()
	 * 
	 * @param removedCategory the category to replace with the default category
	 */
	public void setDefaultCategory(String removedCategory) {
		Iterator<Article> iterator = articles.iterator();
		while(iterator.hasNext()) {
			Article article = iterator.next();
			if(article.getCategory().equalsIgnoreCase(removedCategory)) {
				article.setDefaultCategory();
			}
		}
	}

	/**
	 * Exports the shopping list to a file.
	 * 
	 * The method creates a new text file with the name of the shopping list in the specified path 
	 * (IT'S ABSOLUTE, NEED TO CONVERT TO RELATIVE).
	 * If a file with the same name already exists, it will be deleted and replaced with a new one.
	 * The method writes the names of all articles in the shopping list to the file, separated by commas.
	 *
	 * @param shoppingListPath the path where the shopping list file will be created
	 * @throws IOException if an I/O error occurs during file creation or writing
	 */
	public void exportToFile(String shoppingListPath) throws IOException{
		System.out.println(System.getProperty("user.dir"));
		File file = new File(ShoppingList.PATH + "\\" + this.getName() + ".txt");
		file.delete();
		file.createNewFile();

		FileWriter writer = new FileWriter(file);
		Iterator<Article> iterator = this.iterator();
		while(iterator.hasNext()) {
			writer.write(iterator.next().getName() + ", ");
		}
		writer.write("\n");
		writer.close();
	}

	//getters
	/**
	 * Returns the name of articles.
	 * 
	 * @return the name of articles
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns the list of articles.
	 * 
	 * @return the list of articles
	 */
	public ArrayList<Article> getArticles(){
		return articles;
	}

	@Override
	public Iterator<Article> iterator() {
		return articles.iterator();
	}
}
