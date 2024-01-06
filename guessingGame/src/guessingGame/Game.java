//Caleb Barbee CIS407 Week 2: Guessing Game
package guessingGame;

import java.util.Random;

public class Game {
	
	int number = 0;
	int guessNumber = 0;
	int counter = 0;
	
	public Game() {
	}
	
	public void generateNumberToBeGuessed() {
		Random rand = new Random();
		this.number = rand.nextInt(100) + 1;
		this.counter = 0;
	}
	
	public void makeGuess(int userGuessNumber) {
		this.guessNumber = userGuessNumber;
		this.counter++;
	}
	
	public boolean isCorrectGuess() {
		return (this.number == this.guessNumber);
	}
	
	public void displayWelcomeMessage() {
		System.out.println("I'm thinking of a number from 1 to 100.");
		System.out.println("Try to guess it.");
	}
	
	public void displayPleaseGuessMessage() {
		System.out.print("\nEnter a number between 1 and 100: ");
		
	}
	
	public void displayCorrectGuessMessage() {
		System.out.println("You got it in " + counter + " tries.");
		if (this.counter <= 3) {
			System.out.println("Great work! You are a mathematical wizard.");
		} else if (this.counter <= 7) {
			System.out.println("Not too bad! You've got some potential");
		} else {
			System.out.println("What took you so long");
		}
	}
	
	public void displayGuessAgainMessage() {
		int diff = this.guessNumber - this.number;
		if (diff > 10) {
			System.out.println("Way too high! Guess again.");
		} else if (diff > 0) {
			System.out.println("Too high! Guess again.");
		} else if (diff < -10) {
			System.out.println("Way too low! Guess again.");
		} else {
			System.out.println("Too low! Guess again.");
		}
	}

}
