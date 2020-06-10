package com.op.thread.methods;

/*
 * @author opcs
 * Can two instances of MyClass call instance method foo at the same time? It depends. 
 * If both are same instance of MyObj then no. But, 
 * if they hold different references, then the answer is yes. 
 * 
 */

public class InstanceMethodTest {

	public synchronized void foo(String name) {
		try {
			System.out.println("Thread " + name + ".foo(): starting");
			Thread.sleep(3000);
			System.out.println("Thread" + name + ".foo: ending");
		} catch (InterruptedException exc) {
			System.out.println("Thread" + name + "interrupted");
		}
	}
	
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
		InstanceMethodTest obj1 = new InstanceMethodTest();
		MyThread thread1 = new MyThread("1", obj1);
		thread1.start();

		InstanceMethodTest obj2 = new InstanceMethodTest();
		MyThread thread2 = new MyThread("2", obj2);
		thread2.start();

		//2. same instance - only one is allowed to call, other has to wait
		InstanceMethodTest obj34 = new InstanceMethodTest();
		MyThread thread3 = new MyThread("3", obj34);
		thread3.start();

		MyThread thread4 = new MyThread("4", obj34);
		thread4.start();
		
		
		

	}
}
