package org.marinier.puzzle_solver.tsp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.marinier.puzzle_solver.Puzzle;

public abstract class TravelingSalesmanProblem implements Puzzle {

	protected abstract int[][] getDistanceMatrix();
	protected abstract List<String> getNodes();
	protected abstract int getOptimalSolution();
	
	protected List<Integer> solution;
	private int distance;
	
	private double solutionQuality;
	
	@Override
	public boolean playOnce() {
		
		// generate a visit order to try, assuming starting and ending at node 0 (so don't shuffle those)
		Collections.shuffle(solution.subList(1, solution.size()-1));
		
		computetDistance();
		solutionQuality = 1.0 - (distance - getOptimalSolution())/(double)getOptimalSolution();
		
		if(distance <= getOptimalSolution())
		{
			return true;
		}
		
		return false;
	}

	private void computetDistance()
	{
		int[][] distanceMatrix = getDistanceMatrix();
		distance = 0;
		for(int i = 0; i<solution.size()-1; i++)
		{
			int startNode = solution.get(i);
			int endNode = solution.get(i+1); 
			distance += distanceMatrix[startNode][endNode];
		}
	}
	
	public double getSolutionQuality()
	{
		return solutionQuality;
	}
	
	@Override
	public String toString()
	{
		List<String> nodes = getNodes();
		List<String> solutionNames = new ArrayList<>(solution.size());
		for(int i=0; i<solution.size(); i++)
		{
			solutionNames.add(nodes.get(solution.get(i)));
		}
		
		return "Dist: " + distance + " (" + getOptimalSolution() + ") " + String.join(" -> ", solutionNames);
	}
}
