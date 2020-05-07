package com.op.algo.arecursive;

public class Factorial {
	
	public int fact(int n) {
		if(n==1) return 1;  // base condition
		
		return n*fact(n-1);
	}
	
	public int Enhancedfact(int accumalator,int n) {
		if(n==1) return accumalator;  // base condition
		
		return Enhancedfact(accumalator*n,n-1);   // avoid the repeated calculation
	}
	
	public int calculateFact(int n) {
		return  Enhancedfact(1, n);
	}

	public static void main(String[] args) {
		Factorial fact = new Factorial();
		System.out.println(fact.calculateFact(5));

	}

}
