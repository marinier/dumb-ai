package org.marinier.puzzle_solver.n_queens;

import org.marinier.puzzle_solver.Puzzle;

public class NQueens implements Puzzle {
	
	final int size;
	private final Board board;
			
	public NQueens(int size)
	{
		this.size = size;
		this.board = new Board(size);
	}
			
	@Override
	public boolean playOnce()
	{
		this.board.reset();
		
		for(int col = 0; col < size; col++)
		{
			if(!this.board.placeQueen(col))
			{
				return false;
			}
		}
		
		return true;
	}
	
	@Override
	public String toString()
	{
		return board.toString();
	}

}
