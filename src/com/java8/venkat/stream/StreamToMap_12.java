package com.java8.venkat.stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamToMap_12 {

	public static void main(String[] args) throws IOException {
		// 11. Stream rows from csv file, store fields in hashmap
		Stream<String> rows = Files.lines(Paths.get("F:/oxygen-workspace/java8/src/testfile.txt"));
		
		Map<String, Integer> sitNumberMap = rows.map(row->row.split(","))
		.filter(elements->elements.length==3)
		.filter(elements->Integer.parseInt(elements[1].trim())>15)
		.collect(Collectors.toMap(
				elements->elements[0], 
				elements->Integer.valueOf(elements[1].trim())));
		
		rows.close();
		
		sitNumberMap
		.keySet()
		.forEach(System.out::println);
		
		for(String key: sitNumberMap.keySet()) {
			System.out.println(key + " " + sitNumberMap.get(key));
		}
		
		
	}
}
