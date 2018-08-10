package org.marinier.puzzle_solver;

public class Result {
	private final boolean solved;
	private final long steps;
	private final long time; // in ms
	private final String solution; // printable solution representation
	
	public Result(boolean solved, long steps, long time, String solution) {
		this.solved = solved;
		this.steps = steps;
		this.time = time;
		this.solution = solution;
		
	}

	public boolean isSolved() {
		return solved;
	}

	public long getSteps() {
		return steps;
	}

	public long getTime() {
		return time;
	}
	
	public String getSolution() {
		return solution;
	}
	
	
}
