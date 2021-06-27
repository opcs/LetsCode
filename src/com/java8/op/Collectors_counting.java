package com.java8.op;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Collectors_counting {

	public static void main(String[] args) {
		Stream<String> s = Stream.of("1", "2", "3", "4");
        long ans = s.collect(Collectors.counting());
        System.out.println(ans);

	}

}
