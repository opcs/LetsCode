package com.java8.op;

import java.util.UUID;
import java.util.function.Supplier;
import java.util.stream.Stream;

/*factory method, like 
iterator/generator -> infinite_stream, 
of ->stream_of_certain_elements*/

public class InfiniteStream {

	public static void main(String[] args) {

		Stream<String> friends = Stream.of("suresh", "Anuj", "op"); // fixed stream

		Stream.iterate(1, x -> x * 2).limit(5).forEach(System.out::print); // 1 2 4 8 16

		Supplier<UUID> randomUUIDSupplier = UUID::randomUUID;

		Stream.generate(randomUUIDSupplier).limit(2).forEach(System.out::print);

		// 4c5f67a3-c747-4664-bbaf-2e167906576e f0a9e789-0df9-408b-a466-64e40dde580f

		System.out.println("-------------testing-------------");

	}

}
