package com.op.array.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class ArrayStrComp {

	public static void main(String[] args) {
		// String/char
		char[] charArray = { 'z', 'a', 's' };
		System.out.println("length: " + charArray.length);
		// System.out.println(num_of_zero(101000110));

		String name = "Seerat prakash";
		char s = name.charAt(0);
		int si = name.charAt(0);
		String nam = name.substring(1); // inclusive index
		String firstName = name.substring(0, 4); // inclusive index
		Arrays.sort(name.toCharArray());
		// array
		List<String> asList = Arrays.asList("ab", "ba");
		// asList.add("aa");
		ArrayList<String> obj = new ArrayList<String>(Arrays.asList("Pratap", "Peter", "Harsh"));
		System.out.println(asList);

		ArrayList<String> cities = new ArrayList<String>() {
			{
				add("Delhi");
				add("Agra");
				add("Chennai");
			}
		};
		cities.add("hello");
		System.out.println(cities.toString());
		System.out.println("char: " + s + " si - " + si + " firstName: " + firstName);
	}

	static int num_of_zero(int num) {
		if (0 == num)
			return 1; /* For the input 0 it should output 1 */
		int Count = 0;
		while (num > 0) {
			if (0 == (num % 10))
				Count++;
			num /= 10;
		}
		return Count;
	}

}
