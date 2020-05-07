/**
 * Copyright (c) 2017 GT Nexus. All Rights Reserved.
 */
package com.op.thread.phaser;

import java.util.concurrent.Phaser;

public class PhaserExample {

    public static void main(String[] args) {

        // Creates a new phaser with 1 registered unArrived parties and initial phase number is 0
        final Phaser phaser = new Phaser(3);
        System.out.println("new phaser with 1 registered unArrived parties" + " created and initial phase number is 0 ");
        
        // Create 3 threads
        Thread thread1 = new Thread(new MyRunnable(phaser, "first "), "Thread-1");
        Thread thread2 = new Thread(new MyRunnable(phaser, "second "), "Thread-2");
        Thread thread3 = new Thread(new MyRunnable(phaser, "third "), "Thread-3");

        System.out.println("\n--------Phaser has started---------------");
        // Start 3 threads
        thread1.start();
        thread2.start();
        thread3.start();

    }
}

class MyRunnable implements Runnable {

    Phaser phaser;

    MyRunnable(Phaser phaser, String name) {
        this.phaser = phaser;
        // this.phaser.register(); // Registers/Add a new unArrived party to this phaser.
        // System.out.println(name + " - New unarrived party has " + "been registered with phaser");
    }

    @Override
    public void run() {
        // phase 0
        System.out.println(Thread.currentThread().getName() + " - party has arrived and is working in Phase-" + phaser.getPhase());
        this.phaser.arriveAndAwaitAdvance();

        // phase 1
        System.out.println(Thread.currentThread().getName() + " - party has arrived and is working in Phase-" + phaser.getPhase());
        this.phaser.arriveAndAwaitAdvance();

        phaser.arriveAndDeregister();
        System.out.println(Thread.currentThread().getName() + "! done");

    }

}