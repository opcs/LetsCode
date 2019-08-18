/**
 * Copyright (c) 2017 GT Nexus. All Rights Reserved.
 */
package com.code.threadpool;

public class MyThread extends Thread {

    private MyBlockingQueue taskQueue = null;
    private volatile boolean isStopped = false;

    public MyThread(MyBlockingQueue queue) {
        taskQueue = queue;
    }

    public void run() {
        while (!isStopped()) {
            try {
                Runnable runnable = (Runnable) taskQueue.dequeue();
                runnable.run();
            } catch (Exception e) {
                // log or otherwise report exception,
                // but keep pool thread alive.
            }
        }
    }

    public synchronized void doStop() {
        isStopped = true;
        this.interrupt(); // break pool thread out of dequeue() call.
    }

    public synchronized boolean isStopped() {
        return isStopped;
    }
}