package org.marinier.puzzle_solver;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Board {
	private Card board[][] = new Card[3][3];
	
	public void reset() {
		this.board = new Card[3][3];
	}
	
	public boolean setCard(int row, int col, Card card) {
		// generate a random set of orientations to try
		List<Integer> northsides = Arrays.asList(0,1,2,3);
		Collections.shuffle(northsides);
		
		for(Integer northside : northsides) {
			card.setNorthSide(northside);
			if(isValid(row, col, card)) {
				board[row][col] = card;
				return true;
			}
		}
		
		return false;
	}
	
	protected boolean isValid(int row, int col, Card card) {
		if(board[row][col] != null) {
			System.err.println("Trying to place a card where there is already a card...");
			return false;
		}
		
		// check against the card to the north
		if(row > 0) {
			Card north = this.board[row-1][col];
			if(north != null && north.getHalf(Side.SOUTH).getOpposite() != card.getHalf(Side.NORTH)) {
				return false;
			}
		}
		
		// check against the card to the south
		if(row < 2) {
			Card south = this.board[row+1][col];
			if(south != null && south.getHalf(Side.NORTH).getOpposite() != card.getHalf(Side.SOUTH)) {
				return false;
			}
		}
		
		// check against the card to the east
		if(col < 2) {
			Card east = this.board[row][col+1];
			if(east != null && east.getHalf(Side.WEST).getOpposite() != card.getHalf(Side.EAST)) {
				return false;
			}
		}
		
		// check against the card to the west
		if(col > 0) {
			Card west = this.board[row][col-1];
			if(west != null && west.getHalf(Side.EAST).getOpposite() != card.getHalf(Side.WEST)) {
				return false;
			}
		}
		
		return true;
	}
	
	@Override
	public String toString() {
		String result = "";
		for(int row = 0; row < 3; row++) {
			for(int col = 0; col < 3; col++) {
				result += this.board[row][col].toString() + " *|* ";
			}
			result += "\n";
		}
		
		return result;
	}
}
