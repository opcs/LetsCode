/**
 * Copyright (c) 2017 GT Nexus. All Rights Reserved.
 */
package com.code.thread.oddevenPrinter;

public class EvenPrinter implements Runnable {

    private int max;
    private OddEvenPrinter printer;

    public EvenPrinter(OddEvenPrinter printer, int maxValue) {
        this.printer = printer;
        this.max = maxValue;
    }

    @Override
    public void run() {

        for (int i = 2; i < max; i = i + 2) {
            printer.printEven(i);

        }

    }

}
