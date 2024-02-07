package superClassingExample;

import java.time.LocalDate;

import superClassingExample.GroceryItem.CONTAINER;

public class SuperClassingExampleApp {

	public static void main(String[] args) {
		
		GroceryItem item1 = new GroceryItem("Milk", 1.5, 0.5, LocalDate.now().plusDays(5), CONTAINER.JUG);
		item1.restock(12);
		item1.sell(3);
		FurnitureItem item2 = new FurnitureItem("Table", 35.99, 25, true);
		
		System.out.println(item1.productName());
		System.out.println(item1.timeUntilExpire().getDays());
		System.out.println(item1.groceryContainer());
		System.out.println(item1.productStock());
		
		System.out.println(item2.productName());
		System.out.println(item2.furnitureAssemblyRequired());

	}

}
