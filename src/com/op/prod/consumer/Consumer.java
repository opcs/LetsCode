package com.op.prod.consumer;

import java.util.List;

public class Consumer implements Runnable{

//private BlockingQueue<Integer> sharedQue = new ArrayBlockingQueue<>(10);
private List<Integer> sharedBananas;//=new CopyOnWriteArrayList<Integer>();//ArrayList<Integer>(100);
private int size;
	
	public Consumer(List<Integer> sharedBananas, int size) {
		this.sharedBananas = sharedBananas;
		this.size=size;
	}
	@Override
	public void run() {
		
		while(true){
			try {
				withWaitNotify();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}

	private void withWaitNotify() throws InterruptedException {
		synchronized (sharedBananas) {
			if (sharedBananas.size() > 0) {
				Integer take = sharedBananas.remove(sharedBananas.size() - 1);
				System.out.println("eat banana if present... " + take);
				sharedBananas.notifyAll();
			} else {
				System.out.println("wait consuming- empty queue....");
				sharedBananas.wait();
			}
		}
	}
}
