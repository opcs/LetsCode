
package com.op.oops;

abstract class AbstractClass {
	
	public abstract void abstractMethod();

    public void actualMethod() {
        System.out.println("actual method....");
    }
}

public class AbstractClassTest {

    public static void main(String a[]) {
        // creating an instance of an anonymous subclass of your abstract class
        AbstractClass m = new AbstractClass() {

			@Override
			public void abstractMethod() {
				System.out.println("---abstract method impl ----");
				
			}
        };
        m.actualMethod();
        m.abstractMethod();
        System.out.println("main " + Thread.currentThread().getName());
        
        Runnable run = new Runnable() {
			
			@Override
			public void run() {
				System.out.println("thread " + Thread.currentThread().getName());
				
			}
		};
		
		run.run();
    }
}