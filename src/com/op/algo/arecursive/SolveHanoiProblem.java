package com.op.algo.arecursive;

public class SolveHanoiProblem {

	
	public void solveHanoi(int n, char from, char via, char to) {
		// base condition
		if(n==1) {
			System.out.println("plate 1 from " + from +" to " + to);
			return;
		}
		
		solveHanoi(n-1, from, to, via);
		System.out.println("plate" + n+ " from "+ from + " to "+ via);
		solveHanoi(n-1, via, from, to);
	}
}
