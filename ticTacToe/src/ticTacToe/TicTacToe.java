//Caleb Barbee CIS407 Week 4: TicTacToe
package ticTacToe;

import java.util.Scanner;

public class TicTacToe {

	String[][] board = new String[][] {
		new String[] {" ", " ", " "},
		new String[] {" ", " ", " "},
		new String[] {" ", " ", " "}
	};
	byte rowNumber = 0;
	byte columnNumber = 0;
	char markSelected = 'X';
	
	enum Status {
		X_WINS,
		O_WINS,
		TIE,
		STILL_ROOM
	}
	
	public void displayWelcomeMessage() {
		System.out.println("Welcome to Tic Tac Toe");
	}
	
	// Changing the style of the board is as simple as modifying grid_comps
	private String[] grid_comps = new String[] {
		"+---+---+---+",
		"|"
	};
	public void displayGrid() {
		System.out.print("\n");
		for (int x = 0; x < 3; x++) {
			System.out.println(grid_comps[0]);
			for (int y = 0; y < 3; y++) {
				System.out.print(grid_comps[1] + " " + board[x][y] + " ");
			}
			System.out.print(grid_comps[1] + "\n");
		}
		System.out.println(grid_comps[0]);
	}
	
	public void startGame(Scanner userInput) {
		this.displayGrid();
		boolean keep_playing = true;
		do {
			switch (takeTurn(userInput)) {
			case X_WINS: 
				System.out.println("X has won!");
				keep_playing = false;
				break;
			case O_WINS: 
				System.out.println("O has won!");
				keep_playing = false;
				break;
			case TIE: 
				System.out.println("The game has concluded in a tie.");
				keep_playing = false;
				break;
			case STILL_ROOM:
			}
		} while (keep_playing);
	}
	
	Status takeTurn(Scanner userInput) {
		System.out.println("\n" + this.markSelected + "'s turn");
		
		boolean emptySpace = false;
		do {
			System.out.print("Pick a row (1, 2, 3): ");
			this.rowNumber = (byte) (userInput.nextByte() - 1);
			System.out.print("Pick a column (1, 2, 3): ");
			this.columnNumber = (byte) (userInput.nextByte() - 1);
			String selectedSpace = this.board[this.rowNumber][this.columnNumber];
			if (selectedSpace == " ") {
				emptySpace = true;
			} else {
				System.out.println("That space is already occupied. Please choose another.");
			}
		} while (!emptySpace);
		this.board[this.rowNumber][this.columnNumber] = String.valueOf(this.markSelected);
		
		switch (this.markSelected) {
		case 'X': this.markSelected = 'O'; break;
		case 'O': this.markSelected = 'X'; break;
		}
		
		this.displayGrid();
		return this.checkForWinner();
	}
	
	Status checkForWinner() {
		String a, b, c;
		for (int i = 0; i < 3; i++) {
			//Check row i
			a = this.board[i][0];
			b = this.board[i][1];
			c = this.board[i][2];
			if ((a != " ") && a.equals(b) && a.equals(c)) {
				if (a.equals("X")) {
					return Status.X_WINS;
				} else {
					return Status.O_WINS;
				}
			}
			//Check column i
			a = this.board[0][i];
			b = this.board[1][i];
			c = this.board[2][i];
			if (a != " " & a.equals(b) && a.equals(c)) {
				if (a.equals("X")) {
					return Status.X_WINS;
				} else {
					return Status.O_WINS;
				}
			}
		}
		//Check diagonal 1
		a = this.board[0][0];
		b = this.board[1][1];
		c = this.board[2][2];
		if (a != " " & a.equals(b) && a.equals(c)) {
			if (a.equals("X")) {
				return Status.X_WINS;
			} else {
				return Status.O_WINS;
			}
		}
		//Check diagonal 2
		a = this.board[0][2];
		b = this.board[1][1];
		c = this.board[2][0];
		if (a != " " & a.equals(b) && a.equals(c)) {
			if (a.equals("X")) {
				return Status.X_WINS;
			} else {
				return Status.O_WINS;
			}
		}
		//If none of the winner checks have passed, see if there's still room to play
		for (int x = 0; x < 3; x++) {
			for (int y = 0; y < 3; y++) {
				if (this.board[x][y] == " ") {
					return Status.STILL_ROOM;
				}
			}
		}
		//Finally, return that the game is a tie (no one has one, and there is no more room)
		return Status.TIE;
	}
	
}
