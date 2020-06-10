/**
 * Copyright (c) 2017 GT Nexus. All Rights Reserved.
 */
package com.op.thread.oddevenPrinter;

public class EvenPrinter implements Runnable {

    private int max;
    private Printer printer;

    public EvenPrinter(Printer printer, int maxValue) {
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
