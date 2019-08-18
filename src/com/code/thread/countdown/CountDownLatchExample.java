/**
 * Copyright (c) 2017 GT Nexus. All Rights Reserved.
 */
package com.code.thread.countdown;

import java.util.concurrent.CountDownLatch;

/**
 * allows one or more threads to wait for a given set of operations to complete.
 * A CountDownLatch is initialized with a given count. This count is decremented by calls to the countDown() method. Threads
 * waiting for this count to reach zero can call one of the await() methods. Calling await() blocks the thread until the count
 * reaches zero.
 * Below is a simple example. After the Decrementer has called countDown() 3 times on the CountDownLatch, the waiting Waiter is
 * released from the await() call.
 */
public class CountDownLatchExample {
    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(3);

        Waiter waiter = new Waiter(latch);
        Manager decrementer = new Manager(latch);
        new Thread(waiter).start();
        new Thread(decrementer).start();
    }
}

class Waiter implements Runnable {
    CountDownLatch latch = null;

    public Waiter(CountDownLatch latch) {
        this.latch = latch;
    }
    public void run() {
    	System.out.println("waiter - I am waiting for customer");
        try {
            latch.await();
            System.out.println("waiter starting job --> How may I help you sir !");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Waiter Released");
    }
}
class Manager implements Runnable {
    CountDownLatch latch = null;

    public Manager(CountDownLatch latch) {
        this.latch = latch;
    }
    public void run() {
    		System.out.println("Manager -waiter wait for 2 customer");
        try {
        	System.out.println("Customer 1 came----");
            Thread.sleep(1000);
            this.latch.countDown();
            
            System.out.println("Customer 2 came----");
            Thread.sleep(1000);
            this.latch.countDown();
            
            System.out.println("Manager - all customer came, get ready to serve");
            Thread.sleep(1000);
            this.latch.countDown();
            
            
            
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}