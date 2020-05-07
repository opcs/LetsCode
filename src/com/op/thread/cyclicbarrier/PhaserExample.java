/**
 * Copyright (c) 2017 GT Nexus. All Rights Reserved.
 */
package com.op.thread.cyclicbarrier;

import java.util.concurrent.Phaser;

public class PhaserExample {
    public static void main(String[] args) {
        Phaser phaser = new Phaser(2); // 2 threads
        PhaserTask barrierRunnable1 = new PhaserTask(phaser);
        PhaserTask barrierRunnable2 = new PhaserTask(phaser);
        new Thread(barrierRunnable1).start();
        new Thread(barrierRunnable2).start();
    }
}
class PhaserTask implements Runnable {
    Phaser phaser = null;

    public PhaserTask(Phaser phaser) {
        this.phaser = phaser;
    }
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " waiting at barrier 1");
            this.phaser.arriveAndAwaitAdvance();

            System.out.println(Thread.currentThread().getName() + " waiting at barrier 2");
            this.phaser.arriveAndAwaitAdvance();

            System.out.println(Thread.currentThread().getName() + " waiting at barrier 3");
            this.phaser.arriveAndAwaitAdvance();

            System.out.println(Thread.currentThread().getName() + " done!");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}