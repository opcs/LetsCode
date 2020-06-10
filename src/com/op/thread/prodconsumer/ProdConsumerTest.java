package com.op.thread.prodconsumer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ProdConsumerTest {
	
	//static BlockingQueue<Integer> sharedQue = new ArrayBlockingQueue<>(10);
	// ordinarily too costly, use it when traversal operations vastly outnumber than mutations,
	//private static List<Integer> sharedQue =new CopyOnWriteArrayList<Integer>();
	
	private static List<Integer> sharedQue =new ArrayList<Integer>();
	
	
	public static void main(String[] args) {
		
		Thread prod = new Thread(new Producer(sharedQue, 100), "producer");
		Thread consumer = new Thread(new Consumer(sharedQue,100), "consumer");
		consumer.start();
		prod.start();
		
	System.out.println("after thread started.....");
		/*try {
			Thread.currentThread().sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("after thread sleep.....");*/
	}

}
