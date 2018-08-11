package org.marinier.puzzle_solver.n_queens;

import org.marinier.puzzle_solver.Puzzle;

public class NQueens implements Puzzle {
	
	final int size;
	int queensPlaced = 0;
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
		this.queensPlaced = 0;
		
		for(int col = 0; col < size; col++)
		{
			if(!this.board.placeQueen(col))
			{
				return false;
			}
			this.queensPlaced++;
		}
		
		return true;
	}
	
	@Override
	public double getSolutionQuality() {
		return this.queensPlaced/(double)this.size;
	}
	
	@Override
	public String toString()
	{
		return board.toString();
	}

}
