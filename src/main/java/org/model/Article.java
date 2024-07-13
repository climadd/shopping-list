package main.java.org.model;

/**
 * The class represents an article with a name, cost, category, and quantity.
 */
public class Article {
	
	private String name;
	private double cost;
	private String category;
	private int quantity;
	public static final String DEFAULT_CATEGORY = "Uncategorized";

    /**
     * Constructs a new Article with the following parameters: name, cost, category, and quantity.
     * 
     * @param name     the name of the article
     * @param cost     the cost of the article
     * @param category the category of the article
     * @param quantity the quantity of the article
     * @throws ValidationException if the quantity is less than 1
     */
	public Article(String name, double cost, String category, int quantity) throws ValidationException {
		if(quantity<1) {
			throw new ValidationException("Quantity must be at least 1!");
		}
		this.name = name;
		this.cost = cost;
		this.category = category;
		this.quantity = quantity;
	}	
	
    /**
     * Constructs a new Article with name and cost, the constant DEFAULT_CAEGORY and a quantity of 1.
     * 
     * @param name the name of the article
     * @param cost the cost of the article
     */
	public Article(String name, double cost) throws ValidationException {
		this(name,  cost, DEFAULT_CATEGORY, 1);
	}	
	
    /**
     * Constructs a new Article with name, cost, and category,and a quantity of 1.
     * 
     * @param name     the name of the article
     * @param cost     the cost of the article
     * @param category the category of the article 
     */
	public Article(String name, double cost, String category) throws ValidationException {
		this(name,  cost, category, 1);
	}	
	
    /**
     * Constructs a new Article with name, cost, quantity,and a DEFAULT_CATEGORY.
     * 
     * @param name     the name of the article
     * @param cost     the cost of the article
     * @param quantity the quantity of the article
     * @throws ValidationException if the quantity is less than 1
     */
	public Article(String name, double cost, int quantity) throws ValidationException {
		this(name,  cost, DEFAULT_CATEGORY, quantity);
	}	

	//methods
    /**
     * Adds the specified amount to the article's quantity.
     * 
     * @param amount the amount to add
     * @throws ValidationException if the amount is negative
     */
	public void addQuantity(int amount) throws ValidationException {
		if(amount<0) {
			throw new ValidationException("Amount must be a positive number!");
		}
		this.quantity += amount;
	}
	
    /**
     * Subtracts the specified amount from the article's quantity.
     * 
     * @param amount the amount to subtract
     * @throws ValidationException if the amount is negative
     */
	public void subtractQuantity(int amount) throws ValidationException{
		if(amount<0) {
			throw new ValidationException("Amount must be a positive number!");
		}
		this.quantity -= amount;
	}
	
	//getter
    /**
     * Returns the name of the article.
     * 
     * @return the name of the article
     */
	public String getName(){
		return name;
	}
	
    /**
     * Return the cost of the article.
     * 
     * @return the cost of the article
     */
	public double getCost(){
		return cost;
	}
	
    /**
     * Returns the category of the article.
     * 
     * @return the category of the article
     */
	public String getCategory(){
		return category;
	}
	
    /**
     * Returns the quantity of the article.
     * 
     * @return the quantity of the article
     */
	public int getQuantity(){
		return quantity;
	}
	
	//setter
    /**
     * Sets the category of the article.
     * 
     * @param category the new category of the article
     */
	public void setCategory(String string) {
		this.category = string;
	}
	
    /**
     * Sets the category of the article to the constant DEFAULT_CATEGORY.
     */
	public void setDefaultCategory() {
		this.category = DEFAULT_CATEGORY;
	}

}