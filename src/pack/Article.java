package pack;

public class Article {
	
	//attributi
	private String name;
	private double cost;
	private String category;
	private int quantity;
	
	//costruttori
	public Article(String name, double cost, String category, int quantity) {
		this.name = name;
		this.cost = cost;
		this.category = category;
		this.quantity = quantity;
	}	
	public Article(String name, double cost) {
		this(name,  cost, "NONE", 1);
	}	
	public Article(String name, double cost, String category) {
		this(name,  cost, category, 1);
	}	
	public Article(String name, double cost, int quantity) {
		this(name,  cost, "NONE", quantity);
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
	
}