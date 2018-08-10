package org.marinier.puzzle_solver;

import java.util.ArrayList;
import java.util.List;
import java.util.LongSummaryStatistics;

import org.marinier.puzzle_solver.logix.Logix;
import org.marinier.puzzle_solver.snakes_and_ladders.SnakesAndLadders;

public class App 
{
    public static void main( String[] args )
    {
    	final int numAttempts = 5000;
    	final int numTriesPerAttempt = 5000;
    	
    	
    	Puzzle puzzle;
    	
    	//puzzle = new Logix();
    	//List<Result> logixResults = solve(puzzle, numAttempts, numTriesPerAttempt);
    	
    	puzzle = new SnakesAndLadders();
    	List<Result> snakesAndLaddersResults = solve(puzzle, numAttempts, numTriesPerAttempt);
    	
    	//computeStats("Logix", logixResults);
    	computeStats("Snakes and Ladders", snakesAndLaddersResults);
    }
    
    private static List<Result> solve(Puzzle puzzle, int numAttempts, int numTriesPerAttempt)
    {
    	List<Result> results = new ArrayList<>(numAttempts);
    	
    	for(int i = 0; i < numAttempts; i++)
    	{
    		Result result = puzzle.run(numTriesPerAttempt);
    		results.add(result);
    	}
    	
    	return results;
    }
    
    private static void computeStats(String name, List<Result> results)
    {
    	long numSolved = results.stream().filter(r -> r.isSolved()).count();
    	LongSummaryStatistics solveStepsStats = results.stream().filter(r -> r.isSolved()).mapToLong(r -> r.getSteps()).summaryStatistics();
    	LongSummaryStatistics solveTimeStats = results.stream().filter(r -> r.isSolved()).mapToLong(r -> r.getTime()).summaryStatistics();
    	
    	
    	System.out.println();
    	System.out.println("*** " + name + "***");
    	System.out.println("Num solved = " + numSolved + " out of " + results.size() + " attempts");
    	System.out.println();
    	System.out.println("Solve steps:");
    	printStats(solveStepsStats);
    	System.out.println();
    	System.out.println("Solve time:");
    	printStats(solveTimeStats);
    	System.out.println("*******************");
    }
    
    private static void printStats(LongSummaryStatistics stats)
    {
    	System.out.println("Min: " + stats.getMin());
    	System.out.println("Avg: " + stats.getAverage());
    	System.out.println("Max: " + stats.getMax());
    }
        
   
}
