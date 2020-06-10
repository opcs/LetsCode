package com.java8.venkat.stream;

import java.util.stream.IntStream;

public class IntStream_3_sum {

	public static void main(String[] args) {
		//1. Integer Stream with sum
		System.out.println(
				IntStream.range(1,10)
				.sum());				
	}

}
