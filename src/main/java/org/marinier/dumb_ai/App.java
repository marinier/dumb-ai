package org.marinier.dumb_ai;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.LongSummaryStatistics;

import org.marinier.dumb_ai.logix.Logix;
import org.marinier.dumb_ai.n_queens.NQueens;
import org.marinier.dumb_ai.snakes_and_ladders.SnakesAndLadders;
import org.marinier.dumb_ai.tsp.Cities;

public class App 
{
    public static void main( String[] args )
    {
    	final int numAttempts = 5000;
    	final int numTriesPerAttempt = 5000;
    	
    	runLogix(numAttempts, numTriesPerAttempt);
    	runSnakesAndLadders(numAttempts, numTriesPerAttempt);
    	runNQueens(numAttempts, numTriesPerAttempt, 8);
    	runNQueens(numAttempts, numTriesPerAttempt, 10);
    	runNQueens(numAttempts, numTriesPerAttempt, 20);
    	runNQueens(numAttempts, numTriesPerAttempt, 30);
    	runNQueens(numAttempts, numTriesPerAttempt, 40);
    	runNQueens(numAttempts, numTriesPerAttempt, 50);
    	runNQueens(numAttempts, numTriesPerAttempt, 60);
    	runNQueens(numAttempts, numTriesPerAttempt, 70);
    	runNQueens(numAttempts, numTriesPerAttempt, 80);
    	runNQueens(numAttempts, numTriesPerAttempt, 90);
    	runNQueens(numAttempts, numTriesPerAttempt, 100);
    	
    	runTspCities(numAttempts, numTriesPerAttempt);
    	runTspCities(numAttempts, numTriesPerAttempt*10);
    }
    
    private static void runLogix(int numAttempts, int numTriesPerAttempt)
    {
    	Puzzle puzzle = new Logix();
    	List<Result> logixResults = solve(puzzle, numAttempts, numTriesPerAttempt);
    	computeStats("Logix", logixResults);
    }
    
    private static void runSnakesAndLadders(int numAttempts, int numTriesPerAttempt)
    {
    	Puzzle puzzle = new SnakesAndLadders();
    	List<Result> snakesAndLaddersResults = solve(puzzle, numAttempts, numTriesPerAttempt);
    	computeStats("Snakes and Ladders", snakesAndLaddersResults);
    }
    
    private static void runNQueens(int numAttempts, int numTriesPerAttempt, int numQueens)
    {
    	Puzzle puzzle = new NQueens(numQueens);
    	List<Result> nQueensResults = solve(puzzle, numAttempts, numTriesPerAttempt);
    	computeStats(numQueens + " Queens", nQueensResults);
    }
    
    private static void runTspCities(int numAttempts, int numTriesPerAttempt)
    {
    	Puzzle puzzle = new Cities();
    	List<Result> citiesResults = solve(puzzle, numAttempts, numTriesPerAttempt);
    	computeStats("TSP Cities", citiesResults);
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
    	final LongSummaryStatistics solveStepsStats = results.stream()./*filter(Result::isSolved).*/mapToLong(Result::getSteps).summaryStatistics();
    	final LongSummaryStatistics solveTimeStats = results.stream()./*filter(Result::isSolved).*/mapToLong(Result::getTime).summaryStatistics();
    	final Result bestResult = results.stream().max(Comparator.comparing(Result::getSolutionQuality)).get();
    	
    	System.out.println();
    	System.out.println("*** " + name + " ***");
    	System.out.println("Num solved = " + numSolved + " out of " + results.size() + " attempts");
    	System.out.println();
    	System.out.println("Solve steps:");
    	printStats(solveStepsStats);
    	System.out.println();
    	System.out.println("Solve time (ms):");
    	printStats(solveTimeStats);
    	System.out.println("Best solution: (quality = " + bestResult.getSolutionQuality() + ")" );
    	System.out.println(bestResult.getSolution());
    	System.out.println("*******************");
    }
    
    private static void printStats(LongSummaryStatistics stats)
    {
    	System.out.println("Min: " + stats.getMin());
    	System.out.println("Avg: " + stats.getAverage());
    	System.out.println("Max: " + stats.getMax());
    }
        
   
}
