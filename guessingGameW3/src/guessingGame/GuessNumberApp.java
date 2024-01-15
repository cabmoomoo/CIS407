//Caleb Barbee CIS407 Week 3 Bonus: Guessing Game 2.0
package guessingGame;

import java.util.Scanner;

public class GuessNumberApp {

	public static void main(String[] args) {
		
		Game game = new Game();
		game.displayWelcomeMessage();
		
		try (Scanner userInput = new Scanner(System.in)) {
			String userCont = "";
			do {
				game.generateNumberToBeGuessed();
				game.displayPleaseGuessMessage();
				game.makeGuess(Integer.parseInt(userInput.nextLine()));
				while (!(game.isCorrectGuess())) {
					game.displayGuessAgainMessage();
					game.displayPleaseGuessMessage();
					game.makeGuess(Integer.parseInt(userInput.nextLine()));
				}
				game.displayCorrectGuessMessage();
				
				System.out.print("\nTry again? (y/n): ");
				userCont = userInput.nextLine();
			} while (userCont.equals("y"));
			
			System.out.println("Guess I'll be seeing you around!");
		}
		
	}

}
