package com.java8.streams_sample6;

import java.util.function.Consumer;

/** Execution around method pattern or Loan pattern
 */
public class Sample6_18 {
	
//when we depend on java automatic clean-up, jvm decide when to collect garbage mm and when to clean 
//resources, but we can't wait longer to clean resources	

	public static void main(String[] args) {
		// less verbose solution, java 7: ARM - automatic resource management
		// try with resource - Autocloseable, close() method called just after try now
		Resource8.use(resource ->{
			// block of code
			resource.op1();
			resource.op2();
		} );
		
	}

}


class Resource8 {
	private Resource8() {
		System.out.println("Creating...");
	}
	// when exit from block of code, it does resource clean up
	// Execution around method patter
	public static void use(Consumer<Resource8> block) {
		Resource8 res = new Resource8();  // pre block
		try {
			block.accept(res);        // block code
		}finally {
			res.close();            // post block
		}
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
	private void close() {
		System.out.println("external resource cleaned up");
	}
	
}