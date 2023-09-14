package main;

import java.util.ArrayList;

public class Board {
	
	private ArrayList<String> board;
	
	public Board() {
		board = new ArrayList<String>();
		for (int i = 0; i < 9; i++) {
			Integer b = i + 1;
			board.add(b.toString());
		}
	}
	
	public void changeBoard(int index, String turn) {
		board.set(index - 1, turn);
	}
	
	public ArrayList<String> getBoard() {
		return board;
	}
	
	public boolean slotFilled(int index) {
		if (((board.get(index - 1).equals("X")) || (board.get(index - 1).equals("O")))) {
			return true;
		}
		return false;
	}
	
	public boolean boardFull() {
		for (int i = 0; i < 9; i++) {
			Integer b = i + 1;
			if (board.get(i).equals(b.toString())) {
				return false;
			}
		}
		
		return true;
	}
	
	public boolean winCondition() {
		if ((board.get(0).equals(board.get(1)) && board.get(1).equals(board.get(2))) ||     // horizontal
				(board.get(3).equals(board.get(4)) && board.get(4).equals(board.get(5))) || 
				(board.get(6).equals(board.get(7)) && board.get(7).equals(board.get(8))) ||
				(board.get(0).equals(board.get(3)) && board.get(3).equals(board.get(6))) || // vertical
				(board.get(1).equals(board.get(4)) && board.get(4).equals(board.get(7))) ||
				(board.get(2).equals(board.get(5)) && board.get(5).equals(board.get(8))) ||
				(board.get(0).equals(board.get(4)) && board.get(4).equals(board.get(8))) || // diagonal
				(board.get(2).equals(board.get(4)) && board.get(4).equals(board.get(6)))) {
			return true;
		}
		return false;
	}
	
	public String drawBoard() {
		return String.format(" %s | %s | %s\n %s | %s | %s\n %s | %s | %s \n-------------------------------------------------------", 
				board.get(0), board.get(1), board.get(2), 
				board.get(3), board.get(4), board.get(5), 
				board.get(6), board.get(7), board.get(8));
	}

}
