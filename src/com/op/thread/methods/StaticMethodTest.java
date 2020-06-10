package com.op.thread.methods;

/*
 * @author opcs
 * Can two instances of MyClass call instance method foo at the same time? It depends. 
 * If both are same instance of MyObj then no. But, 
 * if they hold different references, then the answer is yes. 
 * 
 */

public class StaticMethodTest {

	public static synchronized void staticfoo(String name) {
		try {
			System.out.println("Thread " + name + ".staticfoo(): starting");
			Thread.sleep(6000);
			System.out.println("Thread" + name + ".staticfoo: ending");
		} catch (InterruptedException exc) {
			System.out.println("Thread" + name + "interrupted");
		}
	}
	
	public static synchronized void staticBar(String name) {
		try {
			System.out.println("Thread " + name + ".staticBar(): starting");
			Thread.sleep(6000);
			System.out.println("Thread" + name + ".staticBar: ending");
		} catch (InterruptedException exc) {
			System.out.println("Thread" + name + "interrupted");
		}
	}

	public static void main(String args[]) {

		/*
		 * 3. if method is static - it synchronized on the class lock, static call
		 * direct using className not allowed by multiple thread but multiple object can
		 * call static method parallel
		 * 
		 * static lock - allow other object to take lock
		 * object lock - allow classes to take lock
		 * 
		 */
	
				InstanceMethodTest obj22 = new InstanceMethodTest();
				MyThread thread22 = new MyThread("3", obj22);
				thread22.start();
				
				InstanceMethodTest obj = new InstanceMethodTest();
				MyThread thread = new MyThread("4", obj);
				thread.start();
				
				MyThread thread11 = new MyThread("1");
				thread11.start();
				
				MyThread thread2 = new MyThread("2");
				thread2.start();

	}
}
