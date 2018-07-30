package org.marinier.puzzle_solver;

import java.util.ArrayList;
import java.util.List;

public class Card {
	// List of halves for this card in clockwise order
	private List<Half> halves = new ArrayList<>(4);
	
	// the index of the half that is oriented to the north side of the card
	private int northSide = -1;
	
	public Card(Half zero, Half one, Half two, Half three) {
		this.halves.add(zero);
		this.halves.add(one);
		this.halves.add(two);
		this.halves.add(three);
	}
	
	public Half getHalf(int index) {
		return this.halves.get(index % 4);
	}
	
	public void setNorthSide(int index) {
		this.northSide = index%4;
	}
	
	public Half getHalf(Side side) {
		switch(side) {
			case NORTH:
				return getHalf(northSide);
			case EAST:
				return getHalf(northSide+1);
			case SOUTH:
				return getHalf(northSide+2);
			case WEST:
				return getHalf(northSide+3);
		}
		
		return null; // shouldn't be possible to get here
	}
	
	@Override
	public String toString() {
		String result = "";
		
		// print west, north, south, east
		
		result += this.getHalf(Side.WEST).toString() + " ";
		result += "N: " + this.getHalf(Side.NORTH).toString() + " ";
		result += "S: " + this.getHalf(Side.SOUTH).toString() + " ";
		result += this.getHalf(Side.EAST).toString() + " ";
		
		return result.trim();
	}
}
