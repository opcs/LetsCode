package com.op._misc;

import java.util.function.Predicate;
import java.util.stream.Stream;

public class InfiniteStrTest {

	public static void main(String[] args) {
		System.out.println(find_string("abcd", "abce"));

	}
	
	
	
	

	public static int find_string(String infStr, String toFind) {
		Predicate<StringBuilder> isSubs = 	sb -> (sb.indexOf(toFind)==1?true:false);
		StringBuilder sb = new StringBuilder(infStr);
		// complete the function
		boolean infiniteStr = Stream.iterate(sb, str -> str.append(infStr))
				.anyMatch(isSubs);
		
		if(infiniteStr)
			return 1;
		else return 0;
	}

}
