package com.java8.stream;

@FunctionalInterface
public interface MyFunctionalIF {
	
	String name="";

	public abstract void firstMethod();        // only one abstract method allowed
	
	//public abstract void secondMethod();      @FI annotation would not allow to alter FI definition
}
