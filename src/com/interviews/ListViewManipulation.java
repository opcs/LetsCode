package com.interviews;

import java.util.ArrayList;
import java.util.List;

public class ListViewManipulation {

	public static void main(String[] args) {
		List<String> words = new ArrayList<>();
		words.add("Hello1");
		words.add("Hello2");
		System.out.println("b/f creating sublist: " + words);  // 1, 2
		
		// logical view of word list, it is backed by original list, so any non-structural change will not impact each other
		// but structural change will be impacted
		
		List<String> subWords = words.subList(0, 1);
		System.out.println("a/f creating sublist - subwords: " + subWords + " - " +"words: " + words);     // 1 - 1 2
		
		//1. a/f changing view ->it impacts original list as well
		subWords.add("Hello3");   //
		System.out.println("a/f updating view , subWords = " + subWords + " words = " + words);  // 1,3,2 - 1,3

		//1. a/f changing original list words ->it impacts view as well
		words.add("Hello4");      // ConcurrentModificationException
		System.out.println("a/f updating original list words, words = " + words + " subwords = " + subWords);
	}

}
