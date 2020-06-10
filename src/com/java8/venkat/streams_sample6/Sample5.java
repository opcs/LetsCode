package com.java8.venkat.streams_sample6;

import static java.util.Comparator.comparing;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


/**
 * 5. Non Intrusive comparisions - don't need to touch PrimitiveSize class for comparable impl
 * Comparable vs comparators
 * composition of comparators
 *
 */
public class Sample5 {
	
	public static void printSorted(List<Person> people, Comparator<Person> comparator) {
		people.stream()
		.sorted(comparator)
		.forEach(System.out::println);
	}

	public static void main(String[] args) {
		List<Person> people=Arrays.asList(new Person("sara", 12),
				new Person("sara", 12),
				new Person("Mark", 43),
				new Person("Bob", 12),
				new Person("Jill", 64));
		// mutating params, also in for loop, also PrimitiveSize class needs to impl comparable, better remove that dependency
		//Collections.sort(people);    
		System.out.println(people);
		
		/*Comparator<PrimitiveSize> comparator=new Comparator<PrimitiveSize>() {
			public int compare(PrimitiveSize p1, PrimitiveSize p2) {
				return p1.getName().compareTo(p2.getName());
			}

		};*/
		// replace anonymous inner class with Lambda expression then remove duplicate method call
		//Comparator<PrimitiveSize> comparator=(p1, p2) ->p1.getName().compareTo(p2.getName());
	
		//printSorted(people,comparator);
		
		// remove duplicates method calls getName() too with utility comparing method
		//printSorted(people,comparing(PrimitiveSize::getName));
		printSorted(people,comparing(Person::getAge));  //easy to change as comparing method returns comparator
		// if age same then compare with name
		printSorted(people,comparing(Person::getAge).thenComparing(Person::getName));  // method composition
	}

}
