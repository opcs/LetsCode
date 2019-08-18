/**
 * Copyright (c) 2017 GT Nexus. All Rights Reserved.
 */
package com.code.thread.oddevenPrinter;

public class OddEvenPrinterTest {

    public static void main(String[] args) {
        int maxValue = 10;
        
        OddEvenPrinter printer = new OddEvenPrinter();
        new Thread(new OddPrinter(printer, maxValue)).start();
        new Thread(new EvenPrinter(printer, maxValue)).start();
    }

}
