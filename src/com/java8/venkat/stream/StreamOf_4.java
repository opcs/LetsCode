package com.java8.venkat.stream;

import java.util.stream.Stream;

public class StreamOf_4 {

	public static void main(String[] args) {
		// 4. Stream.of, sorted and findfirst

		Stream.of("Ava", "Aneri", "Alberto")
		.sorted()
		.findFirst()
		.ifPresent(System.out::println);
	}
}
