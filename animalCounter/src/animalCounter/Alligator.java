//Caleb Barbee CIS407 Week 9: Animal Counter
package animalCounter;

public class Alligator extends Animal implements Countable {

	Alligator() {
		this.count = 0;
	}
	
	@Override
	public void incrementCount() {
		this.count += 1;
	}

}
