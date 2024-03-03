//Caleb Barbee CIS407 Week 9: Animal Counter
package animalCounter;

public class Sheep extends Animal implements Countable {

	Sheep() {
		this.count = 0;
	}
	
	public void decementCount() {
		if (this.count > 0) {
			this.count -= 1;
		}
	}
	
	@Override
	public void incrementCount() {
		this.count += 2;
	}

}
