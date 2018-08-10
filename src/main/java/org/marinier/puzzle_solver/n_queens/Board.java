package org.marinier.puzzle_solver.n_queens;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Board {

	final int size;
	boolean[][] board; // row, col
	
	public Board(int size)
	{
		this.size = size;
		this.board = new boolean[size][size];
	}
	
	public void reset()
	{
		this.board = new boolean[size][size];
	}
	
	public boolean placeQueen(int col)
	{
		// generate a random set of rows to try
		List<Integer> rows = IntStream.range(0, size).boxed().collect(Collectors.toList());
		Collections.shuffle(rows);
		
		// try each row for a given column until find one that works or have tried them all
		for(int row : rows)
		{
			if(isValid(row, col))
			{
				board[row][col] = true;
				return true;
			}
		}
		
		return false;
	}
	
	private boolean isValid(final int row, final int col)
	{
		// check row
		for(int r = 0; r < size; r++)
		{
			if(board[r][col])
			{
				return false;
			}
		}
		
		// check column
		for(int c = 0; c < size; c++)
		{
			if(board[row][c])
			{
				return false;
			}
		}
		
		// check diagonal up and left
		for(int r = row-1, c = col-1; r >= 0 && c >= 0; r--, c--)
		{
			if(board[r][c])
			{
				return false;
			}
		}
		
		// check diagonal down and right
		for(int r = row+1, c = col+1; r < size && c < size; r++, c++)
		{
			if(board[r][c])
			{
				return false;
			}
		}
		
		// check diagonal down and left
		for(int r = row+1, c = col-1; r < size && c >= 0; r++, c--)
		{
			if(board[r][c])
			{
				return false;
			}
		}
		
		// check diagonal up and right
		for(int r = row-1, c = col+1; r >= 0 && c < size; r--, c++)
		{
			if(board[r][c])
			{
				return false;
			}
		}
		
		return true;
	}
	
	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		// print a header row of vertical bars
		sb.append(' ').append(new String(new char[size]).replace("\0", "|"));
		sb.append('\n');
		for(int row = 0; row < size; row++)
		{
			// begin each row with a dash
			sb.append("-");
			for(int col = 0; col < size; col++)
			{
				if(board[row][col]) { sb.append('Q'); } else { sb.append(' '); };
			}
			sb.append('\n');
		}
		
		return sb.toString();
	}
}
