/**
 * Copyright (c) 2017 GT Nexus. All Rights Reserved.
 */
package com.op.thread.exchanger;

import java.util.concurrent.Exchanger;

public class ExchangerExample {

    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<String>();
        System.out.println("Exchanger has been created");
        Producer prod = new Producer(exchanger);
        Consumer cons = new Consumer(exchanger);

        Thread prodThread = new Thread(prod, "prodThread");
        Thread consThread = new Thread(cons, "consThread");

        prodThread.start(); // start producer thread.
        consThread.start(); // start consumer thread.

    }
}

class Producer implements Runnable {

    Exchanger<String> exchanger;
    String str;

    Producer(Exchanger<String> exchanger) {
        str = new String();
        this.exchanger = exchanger;
    }

    @Override
    public void run() {

        for (int i = 1; i <= 5; i++) {
            str += i;
            System.out.println("Produced : " + i + " name: " + Thread.currentThread().getName());
            try {
                str = exchanger.exchange(str);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

class Consumer extends Thread {

    Exchanger<String> exchanger;
    String str;

    Consumer(Exchanger<String> exchanger) {
        this.exchanger = exchanger;
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                str = exchanger.exchange("");
                System.out.println("CONSUMED : " + str + " name: " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
