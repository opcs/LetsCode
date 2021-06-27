package com.op.thread.join;

public class MainThreadJoinExample {

	public static void main(String[] args) {
		Thread B = new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("in Thread B - executing-1");
				try {
					Thread.sleep(6000);
					System.out.println("in Thread B - completed-3");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		});


	Thread A = new Thread(()->{
		try {
			System.out.println("A is going in wait state-2");
			B.join();
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Thread A completed-4");
	});
	
	
	
	B.start();
	A.start();
	
	
	}
	

}
