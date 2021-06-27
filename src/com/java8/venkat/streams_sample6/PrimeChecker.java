package com.java8.venkat.streams_sample6;

import java.util.stream.IntStream;

public class PrimeChecker {
	
	public static void main(String[] args) {
		System.out.println(isPrime(29));
	}

		/*public static boolean isPrime(int number) {
			boolean divisible=false;
			for(int i=2;i<number;i++) {
				if(number%i==0) {
					divisible=true;
					break;
				}
			}
			return number>1 && divisible;
			
		}*/

	public static boolean isPrime(int number) {

		return number>1 && 
				IntStream.range(2, (int)Math.sqrt(number))
				.anyMatch(i->number %i==0);
		
	}
}
