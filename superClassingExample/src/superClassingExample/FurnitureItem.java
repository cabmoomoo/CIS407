package superClassingExample;

public class FurnitureItem extends StoreProduct{
	
	boolean assemblyRequired;
	
	public boolean furnitureAssemblyRequired() {
		return this.assemblyRequired;
	}

	public FurnitureItem(String name, double cost, double weight, boolean assemblyRequired) {
		super(name, cost, weight);
		this.assemblyRequired = assemblyRequired;
	}

}
