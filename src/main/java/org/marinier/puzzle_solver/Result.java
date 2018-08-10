package org.marinier.puzzle_solver;

public class Result {
	private boolean solved;
	private long steps;
	private long time; // in ms
	
	public Result(boolean solved, long steps, long time) {
		this.solved = solved;
		this.steps = steps;
		this.time = time;
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
	
	
}
