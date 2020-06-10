
package com.op.thread.oddevenPrinter;

public class Printer {

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