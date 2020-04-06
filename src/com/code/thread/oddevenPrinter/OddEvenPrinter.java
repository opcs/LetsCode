/**
 * Copyright (c) 2017 GT Nexus. All Rights Reserved.
 */
package com.code.thread.oddevenPrinter;

public class OddEvenPrinter {

    private boolean isOddPrinted;

    public void printOdd(int number) {
        synchronized (this) {
            try {
                if (isOddPrinted) {
                    wait();
                }
                isOddPrinted = true;
                notifyAll();
                System.out.println(Thread.currentThread().getName() + " " + number + " after notifyAll() call");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void printEven(int number) {
        synchronized (this) {
            try {
                if (!isOddPrinted) {
                    wait();
                }
                isOddPrinted = false;
                notifyAll();
                System.out.println(Thread.currentThread().getName() + " " + number + " after notifyAll() call");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}