package pack;

public class Article {
	
	private String name;
	private double cost;
	private String cathegory;
	private int quantity;
	
	//costruttori
	public Article(String name, double cost, String cathegory, int quantity) {
		this.name = name;
		this.cost = cost;
		this.cathegory = cathegory;
		this.quantity = quantity;
	}	
	public Article(String name, double cost) {
		this(name,  cost, "NONE", 1);
	}	
	public Article(String name, double cost, String cathegory) {
		this(name,  cost, cathegory, 1);
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
	public String getCathegory(){
		return cathegory;
		}
	public int getQuantity(){
		return quantity;
		}
	
}