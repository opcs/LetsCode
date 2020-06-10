package com.java8.venkat.stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class StreamParse_11 {

	public static void main(String[] args) throws IOException {
		// 11. Stream rows from csv file, parse int, filter and sum
		Stream<String> rows = Files.lines(Paths.get("F:/oxygen-workspace/java8/src/testfile.txt"));
		
		rows.map(row->row.split(","))
		.filter(elements->elements.length==3)
		.filter(elements->Integer.parseInt(elements[1].trim())>15)
		.forEach(elements->System.out.println(elements[0]+ " "+elements[1]+" "+elements[2]));
		
		rows.close();
	}
}
