package com.java8.venkat.streams_sample6;

/** Garbage collection in java is lazy
 * very terrible design by java programmer, they mixed two thing
 * 1. Garbage collect memory and
 * 2. external resource cleanup, though both are completely different
 * memory clean-up is our business in java memory while resource clean-up is an orthogonal problems 
 * 
 * java design says - GC will trigger function to clean-up external resources while collecting memory.
 */
public class Sample6_17 {
	
//when we depend on java automatic clean-up, jvm decide when to collect garbage mm and when to clean 
//resources, but we can't wait longer to clean resources	

	public static void main(String[] args) {
		
		// less verbose solution, java 7: ARM - automatic resource management
		// try with resource - Autocloseable, close() method called just after try now
		try(Resource7 res = new Resource7())
		{
			res.op1();
			res.op2();
		} 
		
	}

}


class Resource7 implements AutoCloseable{
	public Resource7() {
		System.out.println("Creating...");
	}
	
	public void op1() {
		System.out.println("some operation 1");
	}
	public void op2() {
		System.out.println("some operation 2");
	}
	public void finalize() {
		System.out.println("external resource clean up");
	}
	public void close() {
		System.out.println("external resource cleaned up");
	}
}