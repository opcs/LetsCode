package com.interviews;

public class DeadLockProgram {

	public static void main(String[] str) {
		DeadLockProgram prog = new DeadLockProgram();
		boolean isStringLocked = false;

		new Thread(() -> prog.m1(isStringLocked)).start();

		new Thread(() -> prog.m2(isStringLocked)).start();
	}

	private void m1(boolean isStringLocked) {
		synchronized (Integer.class) {
			System.out.println("m1 -acquired lock on Integer");
			
			synchronized (String.class) {
				System.out.println("m1 -acquired String lock");
			}
		}
	}

	private void m2(boolean isStringLocked) {
		synchronized (String.class) {
			System.out.println("m2 -acquired lock on string");
			
			synchronized (Integer.class) {
				System.out.println("m2 -acquired lock by integer");
			}
		}
	}

}
