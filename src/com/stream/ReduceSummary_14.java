package com.java8.stream;

import java.util.stream.Stream;

public class ReduceSummary_14 {

	public static void main(String[] args) {
		//13 Reduce sum
		double total=Stream.of(7.3,1.5,4.8)
				.reduce(0.0, (Double a, Double b)->a+b);
		System.out.println("total: "+ total);

	}

}
