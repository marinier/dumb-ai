package org.marinier.puzzle_solver;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.LongSummaryStatistics;

import org.marinier.puzzle_solver.logix.Logix;
import org.marinier.puzzle_solver.n_queens.NQueens;
import org.marinier.puzzle_solver.snakes_and_ladders.SnakesAndLadders;

public class App 
{
    public static void main( String[] args )
    {
    	final int numAttempts = 5000;
    	final int numTriesPerAttempt = 5000;
    	
    	
    	Puzzle puzzle;
    	
//    	puzzle = new Logix();
//    	List<Result> logixResults = solve(puzzle, numAttempts, numTriesPerAttempt);
//    	computeStats("Logix", logixResults);
//    	
//    	puzzle = new SnakesAndLadders();
//    	List<Result> snakesAndLaddersResults = solve(puzzle, numAttempts, numTriesPerAttempt);
//    	computeStats("Snakes and Ladders", snakesAndLaddersResults);
    	
    	puzzle = new NQueens(50);
    	List<Result> nQueensResults = solve(puzzle, numAttempts, numTriesPerAttempt);
    	computeStats("NQueens", nQueensResults);
    }
    
    private static List<Result> solve(Puzzle puzzle, int numAttempts, int numTriesPerAttempt)
    {
    	List<Result> results = new ArrayList<>(numAttempts);
    	
    	for(int i = 0; i < numAttempts; i++)
    	{
    		Result result = puzzle.run(numTriesPerAttempt);
    		results.add(result);
    		if( i % 100 == 0 ) System.out.print('.'); // progress indicator
    	}
    	
    	System.out.println();
    	
    	return results;
    }
    
    private static void computeStats(String name, List<Result> results)
    {
    	final long numSolved = results.stream().filter(Result::isSolved).count();
    	final LongSummaryStatistics solveStepsStats = results.stream().filter(Result::isSolved).mapToLong(Result::getSteps).summaryStatistics();
    	final LongSummaryStatistics solveTimeStats = results.stream().filter(Result::isSolved).mapToLong(Result::getTime).summaryStatistics();
    	final String shortestSolution = results.stream().min(Comparator.comparing(Result::getSteps)).get().getSolution();
    	
    	System.out.println();
    	System.out.println("*** " + name + "***");
    	System.out.println("Num solved = " + numSolved + " out of " + results.size() + " attempts");
    	System.out.println();
    	System.out.println("Solve steps:");
    	printStats(solveStepsStats);
    	System.out.println();
    	System.out.println("Solve time (ms):");
    	printStats(solveTimeStats);
    	System.out.println("Shortest solution:");
    	System.out.println(shortestSolution);
    	System.out.println("*******************");
    }
    
    private static void printStats(LongSummaryStatistics stats)
    {
    	System.out.println("Min: " + stats.getMin());
    	System.out.println("Avg: " + stats.getAverage());
    	System.out.println("Max: " + stats.getMax());
    }
        
   
}
