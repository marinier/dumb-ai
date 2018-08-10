package org.marinier.puzzle_solver;

public interface Puzzle {
	
	default void initialize() {}
	
	boolean playOnce();
	
	public default Result run(int maxTries) {
		
		initialize();
		
		long startTime = System.currentTimeMillis();
		
		boolean solved = false;
        
        long numTries = 0;
        do {
        	
        	numTries++;
        	
	        solved = playOnce();
	        
        } while(!solved && numTries < maxTries);
		long totalTime = System.currentTimeMillis() - startTime;
		
		if(solved) {
			System.out.println("Solution:");
			System.out.println(this.toString());
		} else {
			System.out.println("Failed to solve");
		}
		System.out.println(numTries + " tries in " + totalTime + " ms");
		return new Result(solved, numTries, totalTime);
		
	}
}
