package org.marinier.puzzle_solver.logix;

public enum Side {
	NORTH,
	SOUTH,
	EAST,
	WEST;
	
	public static Side getOpposite(Side side) {
		switch(side) {
			case EAST: return WEST;
			case NORTH: return SOUTH;
			case SOUTH: return NORTH;
			case WEST: return WEST;
		}
		System.err.println("Invalid side...?");
		return null;
	}
}
