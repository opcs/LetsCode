package com.java8.venkat.stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamFromFileToList_9 {

	public static void main(String[] args) throws IOException {
		// 9. Stream rows from test file and save to list
		Stream<String> rows = Files.lines(Paths.get("C:\\Users\\opcs\\git\\LetsCode\\src\\testfile.txt"));
		
		List<String> parallelString = rows.sorted()
		.filter(row->row.contains("parallel"))
		.collect(Collectors.toList());
		rows.close();
		parallelString.forEach(System.out::println);
	}
}
