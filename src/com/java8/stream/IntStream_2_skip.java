package com.java8.stream;

import java.util.stream.IntStream;

public class IntStream_2_skip {

	public static void main(String[] args) {
		//1. Integer Stream with skip
		IntStream.range(1,10)
		.skip(5)						// discard first 5 elements
		.forEach(System.out::println);
		

	}

}
