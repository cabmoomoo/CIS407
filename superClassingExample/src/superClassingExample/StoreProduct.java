package superClassingExample;

public abstract class StoreProduct {
	String name;
	double cost;
	double weight;
	int stock;
	
	public String productName() {
		return this.name;
	}
	public double productCost() {
		return this.cost;
	}
	public double productWeight() {
		return this.weight;
	}
	
	public void restock(int amt) {
		this.stock += amt;
	}
	public void sell(int amt) {
		this.stock -= amt;
	}
	public int productStock() {
		return this.stock;
	}
	
	public void reprice(double price) {
		this.cost = price;
	}
	
	public StoreProduct(String name, double cost, double weight) {
		this.name = name;
		this.cost = cost;
		this.weight = weight;
		this.stock = 0;
	}
}
