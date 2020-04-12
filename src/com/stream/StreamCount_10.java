package com.java8.stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class StreamCount_10 {

	public static void main(String[] args) throws IOException {
		// 10. Stream rows from csv file and count
		Stream<String> rows = Files.lines(Paths.get("F:/oxygen-workspace/java8/src/testfile.txt"));
		
		long rowCount = rows.map(row->row.split(","))
		.filter(word->word.length==3)
		.count();
		rows.close();
		System.out.println("rowCount: " + rowCount);
	}
}
