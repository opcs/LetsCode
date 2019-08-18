/**
 * Copyright (c) 2017 GT Nexus. All Rights Reserved.
 */
package com.code.thread.oddevenPrinter;

public class OddEvenPrinter {

    private boolean isOddPrinted;

    public void printOdd(int number) {
        System.out.println(Thread.currentThread().getName() + " " + " before synchronized() call");
        synchronized (this) {
            System.out.println(Thread.currentThread().getName() + " " + " inside synchronized() call");
            try {
                if (isOddPrinted) {
                    System.out.println(Thread.currentThread().getName() + " " + " before wait() call");
                    wait();
                    System.out.println(Thread.currentThread().getName() + " " + " after wait() call");
                }

                isOddPrinted = true;
                notifyAll();
                System.out.println(Thread.currentThread().getName() + " " + number + " after notifyAll() call");
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }

    public void printEven(int number) {
        System.out.println(Thread.currentThread().getName() + " " + " before synchronized() call");
        synchronized (this) {
            System.out.println(Thread.currentThread().getName() + " " + " inside synchronized() call");
            try {
                if (!isOddPrinted) {
                    System.out.println(Thread.currentThread().getName() + " " + "before wait() call");
                    wait();
                    System.out.println(Thread.currentThread().getName() + " " + " after wait() call");
                }

                isOddPrinted = false;
                notifyAll();
                System.out.println(Thread.currentThread().getName() + " " + number + " after notifyAll() call");
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}