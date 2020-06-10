/**
 * Copyright (c) 2017 GT Nexus. All Rights Reserved.
 */
package com.op.thread.oddevenPrinter;

public class OddPrinter implements Runnable {

    private int max;
    private Printer printer;


    public OddPrinter(Printer printer, int maxValue) {
        this.printer = printer;
        this.max = maxValue;
    }

    @Override
    public void run() {

        for (int i = 1; i < max; i = i + 2) {
            printer.printOdd(i);
        }

        }


}
