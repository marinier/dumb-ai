package org.marinier.puzzle_solver;

public class Result {
	private final boolean solved;
	private final long steps;
	private final long time; // in ms
	private final double solutionQuality; // assumption is that higher is better, can go negative. If possible, constraining to [0,1] may help users interpret.
	private final String solution; // printable solution representation
	
	public Result(boolean solved, long steps, long time, double solutionQuality, String solution) {
		this.solved = solved;
		this.steps = steps;
		this.time = time;
		this.solutionQuality = solutionQuality;
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
	
	public double getSolutionQuality() {
		return solutionQuality;
	}
	
	public String getSolution() {
		return solution;
	}
	
	
}
