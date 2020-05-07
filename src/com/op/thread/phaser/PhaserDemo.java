/**
 * Copyright (c) 2017 GT Nexus. All Rights Reserved.
 */
package com.op.thread.phaser;

import java.util.concurrent.Phaser;

public class PhaserDemo {

    public static void main(String[] args) {
    	System.out.println("---starting main thread---");
        Phaser ph = new Phaser(2);
        // Threads for first phase
        new FileReaderThread("thread-1", "file-1", ph);
        new FileReaderThread("thread-2", "file-2", ph);
        new FileReaderThread("thread-3", "file-3", ph);
        int curPhase;
        curPhase = ph.getPhase();
        System.out.println("thread "+Thread.currentThread().getName()+" current phase - before arriveAndAwaitAdvance 1, phase " + curPhase);
        ph.arriveAndAwaitAdvance(); // main thread waiting here to complete task(run()) by each thread
        System.out.println("thread "+Thread.currentThread().getName() + " after arriveAndAwaitAdvance completed Phase 1, phase " + curPhase);

        // This will be the second phase where threads are deregistered from the phaser

        curPhase = ph.getPhase();
        System.out.println("thread "+Thread.currentThread().getName()+" current phase - before arriveAndAwaitAdvance 2, phase " + curPhase);
        ph.arriveAndAwaitAdvance();
        System.out.println("thread "+Thread.currentThread().getName() + " after arriveAndAwaitAdvance completed Phase 2, phase " + curPhase);

        // Threads for third phase
        new QueryThread("thread-1", 40, ph);
        new QueryThread("thread-2", 40, ph);
        curPhase = ph.getPhase();
        ph.arriveAndAwaitAdvance();
        System.out.println("thread "+Thread.currentThread().getName() + " completed Phase " + curPhase);
        // deregistering the main thread
        ph.arriveAndDeregister();
    }
}

class FileReaderThread implements Runnable {

    private String threadName;
    private String fileName;
    private Phaser ph;

    FileReaderThread(String threadName, String fileName, Phaser ph) {
        this.threadName = threadName;
        this.fileName = fileName;
        this.ph = ph;
        ph.register();
        new Thread(this).start();
    }

    @Override
    public void run() {
        // phase 1 work
        System.out.println("thread "+threadName+" This is phase " + ph.getPhase());
        System.out.println("thread "+threadName+" Reading file " + fileName  + " parsing and storing to DB ");
        // Using await and advance so that all thread wait here
       // ph.arriveAndAwaitAdvance();
       /* try {
            // Just for creating some delay, not
            // actually required
            Thread.sleep(20);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }*/
        // phase 2 work
        System.out.println("thread "+threadName+" Deregistering - FileReaderThread ");
        ph.arriveAndDeregister();
    }
}

class QueryThread implements Runnable {

    private String threadName;
    private int param;
    private Phaser ph;

    QueryThread(String threadName, int param, Phaser ph) {
        this.threadName = threadName;
        this.param = param;
        this.ph = ph;
        ph.register();
        new Thread(this).start();
    }

    @Override
    public void run() {
    	System.out.println("thread "+threadName+" This is phase " + ph.getPhase());
        System.out.println("thread "+threadName+" Querying DB using param " + param);
        System.out.println("thread "+threadName+" Deregistering - QueryThread " );
        ph.arriveAndDeregister();
        //ph.arriveAndAwaitAdvance();
    }
}