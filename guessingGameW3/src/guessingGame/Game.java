//Caleb Barbee CIS407 Week 3 Bonus: Guessing Game 2.0
package guessingGame;

import java.util.Random;

public class Game {
	
	int number = 0;
	int guessNumber = 0;
	int previousGuess = 0;
	int counter = 0;
	
	public Game() {
	}
	
	public void generateNumberToBeGuessed() {
		Random rand = new Random();
		this.number = rand.nextInt(100) + 1;
		this.guessNumber = 0;
		this.previousGuess = 0;
		this.counter = 0;
	}
	
	public void makeGuess(int userGuessNumber) {
		this.previousGuess = this.guessNumber;
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
		switch (this.previousGuess) {
		case 0: 
			firstGuess();
			break;
		default: 
			otherGuess();
			break;
		}
	}
	
	private void firstGuess() {
		int new_diff = this.guessNumber - this.number;
		if (new_diff > 0) {
			System.out.println("Too high! Guess again.");
		} else {
			System.out.println("Too low! Guess again.");
		}
	}
	
	private void otherGuess() {
		int new_diff = this.guessNumber - this.number;
		int old_diff = this.previousGuess - this.number;
		int abs_diff = Math.abs(old_diff) - Math.abs(new_diff);
		if (abs_diff >= 0) {
			System.out.println("You're getting warmer!");
			if (new_diff > 0) {
				System.out.println("...but you're too high. Guess again.");
			} else {
				System.out.println("...but you're too low. Guess again.");
			}
		} else {
			System.out.println("You're getting colder!");
			if (new_diff > 0) {
				System.out.println("...and you're too high. Guess again.");
			} else {
				System.out.println("...and you're too low. Guess again.");
			}
		}
	}
}
