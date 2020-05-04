package com.code.thread;

class Account {
	static int counter = 0;

	// static synchronized method
	synchronized static void showStaticAccount1(String accountName) {
		System.out.println("account static " + accountName + " Holder Name " + Thread.currentThread().getName());
		try {
			for (int i = 0; i < 50; i++) {
				counter++;
				System.out.println(Thread.currentThread().getName() + " - " + counter);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	synchronized static void showStaticAccount2(String accountName) {
		System.out.println("account static " + accountName + " Holder Name " + Thread.currentThread().getName());
		try {
			for (int i = 0; i < 50; i++) {
				counter++;
				System.out.println(Thread.currentThread().getName() + " - " + counter);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	synchronized void showAccount(String input) {
		System.out.println( input + " "+Thread.currentThread().getName());
		/*try {
			wait(3000L);*/
			for (int i = 0; i < 50; i++) {
				System.out.println(Thread.currentThread().getName() + " - " + i);
			}
		/*
		 * } catch (InterruptedException e) { e.printStackTrace(); }
		 */
	}
}

class Profile {
	static int counter = 0;

	// static synchronized method
	synchronized static void showStaticProfile(String accountName) {
		for (int i = 0; i < 50; i++) {
			System.out.println("static profile - > "+Thread.currentThread().getName() + " - " + i);
		}
	}
	
	synchronized void showProfile(String input) {
		System.out.println( "Profile -> " + input + Thread.currentThread().getName());
	}
}

class MyThread1 extends Thread {
	public void run() {
		Account account = new Account();
		account.showAccount("account");
	}
}
class MyThread2 extends Thread {
	public void run() {
		Account.showStaticAccount1("static account2");
	}
}
class MyThread22 extends Thread {
	public void run() {
		Account.showStaticAccount2("static account22");
	}
}
class MyThread3 extends Thread {
	public void run() {
		Profile profile = new Profile();
		profile.showProfile("profile");
	}
}

class MyThread4 extends Thread {
	public void run() {
		Profile.showStaticProfile("static profile");
	}
}
// with static synchronized, threads can run parallel if m1(T1) - static, m2(T2) - non static
//with static synchronized, threads can't run parallel if m1(T1) - static, m2(T22) - static

public class StaticSyncDemo {
	public static void main(String t[]) {
		MyThread1 t1 = new MyThread1();
		MyThread2 t2 = new MyThread2();
		MyThread3 t3 = new MyThread3();
		MyThread4 t4 = new MyThread4();
		MyThread22 t22 = new MyThread22();

		t1.setName("T1");
		t2.setName("T2");
		t2.setPriority(7 );
		t3.setName("T3");
		t4.setName("T4");
		t22.setName("T22");
		t2.start();
		t22.start();
		//t3.start();
		//t1.start();
		//t4.start();

	}
}
