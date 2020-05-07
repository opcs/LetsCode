package com.op.logical;

public class Permutations {

	public static void main(String[] args) {
		checkPermutation(5);
	}

	static void checkPermutation(int n){
		if(n<=0){
			System.out.println("NO: "+n);
			return;
		}
		if(n==1){
			System.out.println("NO: "+n);
			return;
		}
		else{
			for(int i=n; i>=1; i--){
				int f = fact(n)/fact(n-i);
				System.out.println("Permutation of "+i+" = "+f);
				int j = f%8;
				if(j == 0) System.out.println("YES remainder is "+j);
				else System.out.println("NO remainder is "+j);
			}
		}
	}
	static int fact(int n){
		if(n<0) return 0;
		if(n == 0 || n == 1)
			return 1;
		else{
			return n*fact(n-1);
		}
	}
}
