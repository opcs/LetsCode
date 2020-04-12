package com.java8.stream;

import java.util.Arrays;

public class StreamArrSortFilter_5 {

	public static void main(String[] args) {
		// 5. Stream from Array, sort, filter and print
		String[] names= {"AI", "Ankit","Kushal","Brent","Sarika","Amanda","Hans","Shivika", "Sarath"};
		
		Arrays.stream(names)
		.filter(name->name.startsWith("S"))
		.sorted()
		.forEach(System.out::println);
	}
}
