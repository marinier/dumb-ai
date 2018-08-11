package org.marinier.puzzle_solver;

public interface Puzzle {
	
	default void initialize() {}
	
	boolean playOnce();
	
	double getSolutionQuality();
	
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
		final String solution = this.toString();
		
		return new Result(solved, numTries, totalTime, getSolutionQuality(), solution);
		
	}
}
