package org.marinier.dumb_ai.snakes_and_ladders;

import java.util.Arrays;

/**
 * The board is represented as a list of ints.
 * If the int is NO_LINK, it's nothing special. Otherwise it goes to another position on the board (i.e., it's a snake or ladder)
 * This implementation assumes there is NO_LINK at position 0, the last position, or at a position that another position links to
 * @author bob.marinier
 *
 */
public class Board {

	public static final int NO_LINK = -1;
	private int[] board = new int[100];
	int position = 0;
	
	public Board() {
		Arrays.fill(board, NO_LINK);
		board[2] = 27;
		board[9] = 42;
		board[15] = 8;
		board[17] = 45;
		board[30] = 6;
		board[32] = 68;
		board[41] = 60;
		board[43] = 20;
		board[48] = 16;
		board[51] = 82;
		board[56] = 86;
		board[63] = 46;
		board[66] = 91;
		board[70] = 35;
		board[72] = 94;
		board[83] = 53;
		board[97] = 62;
	}
	
	public void reset()
	{
		this.position = 0;
	}
	
	public boolean move(int roll)
	{
		position += roll;
		
		// check to see if we've reached the end
		if(isSolved())
		{
			return true;
		}
		else if(board[position] != NO_LINK) // if there's a snake or ladder, update the position accordingly
		{
			position = board[position];
		}
		
		return false;
		
	}
	
	public boolean isSolved() {
		return position >= board.length;
	}
}
