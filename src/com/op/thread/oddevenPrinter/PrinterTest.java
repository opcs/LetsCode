package com.op.thread.oddevenPrinter;

public class PrinterTest {

    public static void main(String[] args) {
        int maxValue = 10;
        
        Printer printer = new Printer();
        new Thread(new OddPrinter(printer, maxValue)).start();
        new Thread(new EvenPrinter(printer, maxValue)).start();
    }

}
