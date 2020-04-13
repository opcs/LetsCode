package com.java8.streams_sample6;

import java.io.File;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/** 4. you gotta be kidding
 * Simple tasks that haunt us
 * Higher level of abstraction
 */
public class Sample4 {

	public static void main(String[] args) {
		File dir=new File(".");
		
		//names in uppercase, comma separated
		File[] children=dir.listFiles();
		if(children!=null) {
			System.out.println(
			Stream.of(children)     // array
			.map(File::getName)     // multiple transformation
			.map(String::toUpperCase)
			.collect(Collectors.joining(",")));    // no comma at end of it, which was always a buggy or in dielema
		}

	}

}
