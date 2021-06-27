package com.op.thread.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierExample {
    public static void main(String[] args) {
        Runnable barrierAction1 = ()->System.out.println("task 1 executed ");
        Runnable barrierAction2 = ()->System.out.println("task 2 executed ");
        
        int barrierParties = 3;
		CyclicBarrier barrier1 = new CyclicBarrier(barrierParties, barrierAction1); // no new thread, directly call task1.run()
        CyclicBarrier barrier2 = new CyclicBarrier(barrierParties, barrierAction2);
        
        CyclicBarrierTask barrierRunnable1 = new CyclicBarrierTask(barrier1, barrier2);
        CyclicBarrierTask barrierRunnable2 = new CyclicBarrierTask(barrier1, barrier2);
        CyclicBarrierTask barrierRunnable3 = new CyclicBarrierTask(barrier1, barrier2);
        new Thread(barrierRunnable1).start();
        new Thread(barrierRunnable2).start();
        new Thread(barrierRunnable3).start();
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
          //wait untill both parties tasks has to be completed at this barrier then proceed for next cycle
            
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
