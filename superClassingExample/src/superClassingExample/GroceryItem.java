package superClassingExample;

import java.time.*;

public class GroceryItem extends StoreProduct {
	
	LocalDate expiration;
	CONTAINER container;
	
	enum CONTAINER {
		CAN,
		BOX,
		JAR,
		JUG
	}
	
	public CONTAINER groceryContainer() {
		return this.container;
	}
	
	public Period timeUntilExpire() {
		return this.expiration.until(LocalDate.now()).negated();
	}

	public GroceryItem(String name, double cost, double weight, LocalDate expiration, CONTAINER container) {
		super(name, cost, weight);
		this.expiration = expiration;
		this.container = container;
	}

}
