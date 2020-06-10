package com.java8.venkat.stream;

import java.util.stream.IntStream;

public class IntStream_1 {

	public static void main(String[] args) {
		//1. Integer Stream
		IntStream.range(1,10)
		.forEach(System.out::println);
		
		//System.out.println();

	}

}
