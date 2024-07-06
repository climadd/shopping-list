package pack;

public class Article {

	//attributi
	private String name;
	private double cost;
	private String category;
	private int quantity;
	public static final String DEFAULT_CATEGORY = "Non Categorizzato";

	//costruttori
	public Article(String name, double cost, String category, int quantity) {
		this.name = name;
		this.cost = cost;
		this.category = category;
		this.quantity = quantity;
	}	
	public Article(String name, double cost) {
		this(name,  cost, DEFAULT_CATEGORY, 1);
	}	
	public Article(String name, double cost, String category) {
		this(name,  cost, category, 1);
	}	
	public Article(String name, double cost, int quantity) {
		this(name,  cost, DEFAULT_CATEGORY, quantity);
	}	

	//metodi
	public void addQuantity(int amount) throws ValidationException {
		if(amount<0) {
			throw new ValidationException("Amount must be a positive number!");
		}
		this.quantity += amount;
	}
	public void subtractQuantity(int amount) throws ValidationException{
		if(amount<0) {
			throw new ValidationException("Amount must be a positive number!");
		}
		this.quantity -= amount;
	}
	
	//getter
	public String getName(){
		return name;
	}
	public double getCost(){
		return cost;
	}
	public String getCategory(){
		return category;
	}
	public int getQuantity(){
		return quantity;
	}
	//setter
	public void setCategory(String string) {
		this.category = string;
	}

}