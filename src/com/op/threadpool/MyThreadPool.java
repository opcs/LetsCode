/**
 * Copyright (c) 2017 GT Nexus. All Rights Reserved.
 */
package com.op.threadpool;

import java.util.ArrayList;
import java.util.List;

public class MyThreadPool {

    private MyBlockingQueue taskQueue = null;
    private List<MyThread> threadsPool = new ArrayList<MyThread>();
    private boolean isStopped = false;

    public MyThreadPool(int noOfThreads, int maxNoOfTasks) {
        taskQueue = new MyBlockingQueue(maxNoOfTasks);

        for (int i = 0; i < noOfThreads; i++) {
            threadsPool.add(new MyThread(taskQueue));
        }
        for (MyThread thread : threadsPool) {
            thread.start();
        }
    }

    public synchronized void execute(Runnable task) throws Exception {
        if (this.isStopped)
            throw new IllegalStateException("ThreadPool is stopped");
        this.taskQueue.enqueue(task);
    }

    public synchronized void stop() {
        this.isStopped = true;
        for (MyThread thread : threadsPool) {
            thread.doStop();
        }
    }
}
