//Caleb Barbee CIS407 Week 4: TicTacToe
package ticTacToe;

import java.util.Scanner;

public class TicTacToeApp {

	public static void main(String[] args) {

		TicTacToe game = new TicTacToe();
		game.displayWelcomeMessage();

		try (Scanner userInput = new Scanner(System.in)) {
			game.startGame(userInput);
		}

	}

}
