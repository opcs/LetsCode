/**
 * Copyright (c) 2017 GT Nexus. All Rights Reserved.
 */
package com.op.thread.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierExample {
    public static void main(String[] args) {
        Runnable task1 = new Runnable() {
            public void run() {
                System.out.println("task 1 executed ");
            }
        };
        Runnable task2 = new Runnable() {
            public void run() {
                System.out.println("task 2 executed ");
            }
        };
        CyclicBarrier barrier1 = new CyclicBarrier(2, task1); // no new thread, directly call task1.run()
        CyclicBarrier barrier2 = new CyclicBarrier(2, task2);
        CyclicBarrierTask barrierRunnable1 = new CyclicBarrierTask(barrier1, barrier2);
        CyclicBarrierTask barrierRunnable2 = new CyclicBarrierTask(barrier1, barrier2);
        new Thread(barrierRunnable1).start();
        new Thread(barrierRunnable2).start();
    }
}

class CyclicBarrierTask implements Runnable {
    CyclicBarrier barrier1 = null;
    CyclicBarrier barrier2 = null;

    public CyclicBarrierTask(CyclicBarrier barrier1, CyclicBarrier barrier2) {
        this.barrier1 = barrier1;
        this.barrier2 = barrier2;
    }
    public void run() {
        try {
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + " waiting at barrier 1");
            this.barrier1.await();

            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + " waiting at barrier 2");
            this.barrier2.await();

            System.out.println(Thread.currentThread().getName() + " done!");

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}