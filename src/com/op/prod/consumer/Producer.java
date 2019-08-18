package com.op.prod.consumer;

import java.util.List;

public class Producer implements Runnable{
	//private BlockingQueue<Integer> sharedQue = new ArrayBlockingQueue<>(10);
	private List<Integer> sharedBananas;// =new CopyOnWriteArrayList<Integer>();
	private int size;
	
	public Producer(List<Integer> sharedBananas, int size) {
		this.sharedBananas = sharedBananas;
		this.size=size;
	}


	@Override
	public void run() {
		while(true){
			try {
				withWaitNotify();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}


	private void withWaitNotify() throws InterruptedException {
		
		synchronized (sharedBananas) {
			if (sharedBananas.size() < size) {
				sharedBananas.add(1);
				System.out.println("created banana..... " + sharedBananas.get(sharedBananas.size() - 1));
				sharedBananas.notifyAll();

			} else {
				System.out.println("wait - queue is full.....");
				sharedBananas.wait();
			}
		}

	}

}
