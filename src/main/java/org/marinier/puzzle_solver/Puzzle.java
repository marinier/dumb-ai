package org.marinier.puzzle_solver;

public interface Puzzle {
	
	default void initialize() {}
	
	boolean playOnce();
	
	public default Result run(int maxTries) {
		
		initialize();
		
		boolean solved = false;
        long numTries = 0;

		final long startTime = System.currentTimeMillis();
		
        do {
        	numTries++;
	        solved = playOnce();
	        
        } while(!solved && numTries < maxTries);
        
		final long totalTime = System.currentTimeMillis() - startTime;
		final String solution = solved ? this.toString() : "Failed to solve";
		
		return new Result(solved, numTries, totalTime, solution);
		
	}
}
