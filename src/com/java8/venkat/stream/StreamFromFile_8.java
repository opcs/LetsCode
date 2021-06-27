package com.java8.venkat.stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class StreamFromFile_8 {

	public static void main(String[] args) throws IOException {
		// 9. Stream of rows from test file, sort, filter and print
		Stream<String> rows = Files.lines(Paths.get("F:/oxygen-workspace/java8/src/testfile.txt"));
		
		//rows.sorted()
		rows.filter(row->row.length()>18)
		.forEach(System.out::println);
		
		rows.close();
	}
}
