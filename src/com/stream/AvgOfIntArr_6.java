package com.java8.stream;

import java.util.Arrays;

public class AvgOfIntArr_6 {

	public static void main(String[] args) {
		// 5. average of square of an int array
		
		Arrays.stream(new int[] {2,4,6,8,10})
		.map(x->x*x)
		.average()
		.ifPresent(System.out::println);
	}
}
