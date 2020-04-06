/**
 * Copyright (c) 2017 GT Nexus. All Rights Reserved.
 */
package com.code.thread;

public class MyDeadLock {

    private String name = "om";
    private String city = "Bangalore";

    Thread th1 = new Thread() {

        public void run() {
            synchronized (String.class) {
                System.out.println("string_block1: " + Thread.currentThread().getName());
                synchronized (Integer.class) {
                    System.out.println("integer_block2: " + Thread.currentThread().getName());
                }
            }
        }
    };

    Thread th2 = new Thread() {

        public void run() {
            synchronized (Integer.class) {
                System.out.println("integer_block1: " + Thread.currentThread().getName());
                synchronized (String.class) {
                    System.out.println("string_block2: " + Thread.currentThread().getName());
                }
            }
        }
    };

    public static void main(String[] args) {
        MyDeadLock md = new MyDeadLock();
        md.th1.setName("Thread1");
        md.th2.setName("Thread2");

        md.th1.start();
        md.th2.start();

    }

}
