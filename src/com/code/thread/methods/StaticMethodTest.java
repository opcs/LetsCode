package com.code.thread.methods;

/*
 * @author opcsCan two instances of MyClass call instance method foo at the same time? It depends. 
 * If both are same instance of MyObj then no. But, 
 * if they hold different references, then the answer is yes. 
 * 
 */

public class StaticMethodTest {

	public static synchronized void staticfoo(String name) {
		try {
			System.out.println("Thread " + name + ".staticfoo(): starting");
			Thread.sleep(3000);
			System.out.println("Thread" + name + ".staticfoo: ending");
		} catch (InterruptedException exc) {
			System.out.println("Thread" + name + "interrupted");
		}
	}
	
	public static synchronized void staticBar(String name) {
		try {
			System.out.println("Thread " + name + ".staticBar(): starting");
			Thread.sleep(3000);
			System.out.println("Thread" + name + ".staticBar: ending");
		} catch (InterruptedException exc) {
			System.out.println("Thread" + name + "interrupted");
		}
	}

	public static void main(String args[]) {

		//1. different instance - both can call instance method simultaneously
		MyThread thread1 = new MyThread("1");
		thread1.start();

		MyThread thread2 = new MyThread("2");
		thread2.start();

		

	}
}
