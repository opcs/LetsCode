package com.java8.op;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InfiniteStream {

	public static void main(String[] args) {

IntStream is = IntStream.iterate(1, x->x+1);
Optional<Integer> obj =is.limit(5).collect(Collectors.maxBy(Comparator.reverseOrder()));

	}

}
