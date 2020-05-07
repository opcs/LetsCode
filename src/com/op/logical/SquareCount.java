package com.op.logical;

public class SquareCount {

	public static void main(String[] args) {
		int[] arr = new int[]{9,25,100,400,1600};
		int count = countSquare(arr);
		System.out.println(count);
	}

	private static int countSquare(int[] arr) {
		int count=0;
		for(int i=0; i<arr.length; i++){
			if(checkSquare(arr[i]))
				count++;
		}
		return count;
	}

	private static boolean checkSquare(int n) {
		for(int i=1; i<=n/2; i++){
			if(n%i==0){
				if(i*i == n) return true;
				if(i*i > n) return false;
			}
		}
		return false;
	}
	

}
