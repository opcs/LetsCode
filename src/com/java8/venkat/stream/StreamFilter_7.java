package com.java8.venkat.stream;

import java.util.Arrays;
import java.util.List;

public class StreamFilter_7 {

	public static void main(String[] args) {
		// 5. Stream from List, filter and print
		List<String> names= Arrays.asList("AI", "Ankit","Kushal","Brent","Sarika","Amanda","Hans","Shivika", "Sarath");
		
		names.stream()
		.map(String:: toLowerCase)
		.filter(name->name.startsWith("a"))
		.forEach(System.out::println);
	}
}
