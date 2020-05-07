package com.op.logical;

import java.util.HashSet;
import java.util.Set;

public class RepeatedWord {

	public static void main(String[] args) {
	
		String str = "Lekhraj1 lekhraj2 lekhraj3 vijay1 vijay2 rishi rema rema rema rishi lekhraj1 jay1 vij vija";
		String[] words = str.split(" ");
		Set<String> dup = getDup(words);
		System.out.println(dup);
	}

	private static Set<String> getDup(String[] words) {
		
		Set<String> dup = new HashSet<>();
		Set<String> dummySet = new HashSet<>();
		
		for(String str:words){
			if(!dummySet.add(str.toLowerCase()))
				dup.add(str.toLowerCase());
		}
		
		return dup;
	}

	
}
