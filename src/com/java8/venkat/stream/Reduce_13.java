package com.java8.venkat.stream;

import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;

public class Reduce_13 {

	public static void main(String[] args) {
		//13 Reduce summary statistics
		IntSummaryStatistics summaryStatistics = IntStream.of(7,3,1,5,4,8)
				.summaryStatistics();
		System.out.println("summaryStatistics: "+ summaryStatistics);

	}

}
