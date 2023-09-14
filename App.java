package main;

import java.util.Scanner;
import java.util.Random;

public class App {
	
	// Console based TicTacToe game.
	// Phase 1: Initial testing phase - Done-ish
	// Phase 2: Board Creation - Done-ish
	// Phase 3: Loop creation - done
	// Phase 4: RNG Choices for opponent - Done-ish
	// needs a more robust win condition - Done
	// looks complete. Todo: add a choice system to pick between the computer opponent or a human opponent.
	// also a choice to rerun the game or exit.
	// Time wasted: around 3 hours, on and off while I do other things.
	
	public static void main(String[] args) {
		Board board = new Board();
		Scanner input = new Scanner(System.in);
		Random rng = new Random();
		System.out.println("Pick a number to start your TicTacToe match! YOU ARE X.");
		int response;
		int randomChoice;
		
		mainloop: // this label is unnecessary, and came upon me as a sign of the lord. it does nothing but i am too lazy to change it out.
		while (true) {
			randomChoice = 0;
			System.out.println(board.drawBoard());
			if (board.boardFull()) {
				System.out.println();
				break mainloop;
			}
			try {
				response = input.nextInt();
				if ((response < 1) || (response > 9)) {
					System.out.println("Invalid number! Pick one that you see!");
					continue mainloop;
				} else if (board.slotFilled(response)){
					System.out.println("Slot already filled! Pick another!");
					continue mainloop;
				} else {
					board.changeBoard(response, "X");
					if (board.winCondition()) {
						System.out.println(board.drawBoard());
						System.out.println("WIN, X");
						break mainloop;
					} else if (board.boardFull()) {
						System.out.println("DRAW");
						break mainloop;
					}
					label: // This label is potentially unnecessary as well but once more I am too lazy to get rid of it
						for (int i = 0; i < 50; i++) {
							randomChoice = 0;
							randomChoice = rng.nextInt(9) + 1;
							if (board.slotFilled(randomChoice)) {
								continue label;
							} else {
								break label;
							}
						}
					board.changeBoard(randomChoice, "O");
					if (board.winCondition()) {
						System.out.println(board.drawBoard());
						System.out.println("WIN, O");
						break mainloop;
					}
					
					continue mainloop;
				}
			} catch (java.util.InputMismatchException e) {
				System.out.println("INVALID RESPONSE");
				continue mainloop;
			}
		}
		
		input.close();
		
	}

}
