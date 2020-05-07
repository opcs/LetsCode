/**
 * Copyright (c) 2017 GT Nexus. All Rights Reserved.
 */
package com.op.oops.overloaded;
public class PrintNull {


    public static void main(String[] args) {
        print(null);

    }

    private static void print(Object object) {
        System.out.println("Object");

    }

    private static void print(Exception object) {
        System.out.println("exception");

    }

    private static void print(ArithmeticException object) {
        System.out.println("AE");

    }
    // only one method can be added with same level of object hierarchy

    /*private static void print(String object) {
        System.out.println("String");

    }*/

}
