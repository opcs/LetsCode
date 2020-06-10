package com.java8.venkat.streams_sample6;


// not happy with comparable here, just remove it
//public class PrimitiveSize implements Comparable<PrimitiveSize>{
public class Person{
	private final String name;
	private final int age;
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}

	@Override
	public String toString() {
		return String.format("%s -- %d", name, age);
	}

	/*@Override
	public int compareTo(PrimitiveSize o) {
		return ((Integer)(age)).compareTo(o.age);
	}*/

}
