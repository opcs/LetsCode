/**
 * Copyright (c) 2017 GT Nexus. All Rights Reserved.
 */
package com.op.thread.exchanger;

import java.util.concurrent.Exchanger;

public class ExchangerEx2 {
    public static void main(String[] args) {
        Exchanger exchanger = new Exchanger();

        ExchangerTask exTask1 = new ExchangerTask(exchanger, "A");
        ExchangerTask exTask2 = new ExchangerTask(exchanger, "B");
        new Thread(exTask1).start();
        new Thread(exTask2).start();
        /*ExchangerTask exTask3 = new ExchangerTask(exchanger, "C");
        ExchangerTask exTask4 = new ExchangerTask(exchanger, "D");
        new Thread(exTask3).start();
        new Thread(exTask4).start();*/
    }
}
class ExchangerTask implements Runnable {
    Exchanger exchanger = null;
    Object object = null;

    public ExchangerTask(Exchanger exchanger, Object object) {
        this.exchanger = exchanger;
        this.object = object;
    }
    public void run() {
        try {
            Object previous = this.object;
            this.object = this.exchanger.exchange(this.object);
            System.out.println(Thread.currentThread().getName() + " exchanged " + previous + " for " + this.object);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
