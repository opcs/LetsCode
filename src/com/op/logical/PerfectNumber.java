package com.op.logical;

public class PerfectNumber {

	public static void main(String[] args) {
		
		int number = 28;
		
		boolean isPerfect = isNumberPerfect(number);
		System.out.println("isnumber perfect: " + isPerfect);
	}

	private static boolean isNumberPerfect(int number) {
		int divisorSum=0;
		boolean isNumberPerfect=false;
		for(int i=1;i<=number/2;i++){
			if(number%i==0){
				System.out.print(divisorSum + " ");
				divisorSum+=i;
			}
		}
		if(number==divisorSum){
			 isNumberPerfect = true;
		}
		return isNumberPerfect;
	}

}
