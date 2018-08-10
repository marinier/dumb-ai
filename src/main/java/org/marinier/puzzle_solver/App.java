package org.marinier.puzzle_solver;

import java.util.ArrayList;
import java.util.List;
import java.util.LongSummaryStatistics;

import org.marinier.puzzle_solver.logix.Logix;

public class App 
{
    public static void main( String[] args )
    {
    	final int numAttempts = 5000;
    	final int numTriesPerAttempt = 5000;
    	List<Result> results = new ArrayList<>(numAttempts);
    	
    	Puzzle puzzle = new Logix();
    	
    	for(int i = 0; i < numAttempts; i++)
    	{
    		Result result = puzzle.run(numTriesPerAttempt);
    		results.add(result);
    	}
    	
    	computeStats(results);
    }
    
    private static void computeStats(List<Result> results)
    {
    	long numSolved = results.stream().filter(r -> r.isSolved()).count();
    	LongSummaryStatistics solveStepsStats = results.stream().filter(r -> r.isSolved()).mapToLong(r -> r.getSteps()).summaryStatistics();
    	LongSummaryStatistics solveTimeStats = results.stream().filter(r -> r.isSolved()).mapToLong(r -> r.getTime()).summaryStatistics();
    	
    	
    	System.out.println();
    	System.out.println("*******************");
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
