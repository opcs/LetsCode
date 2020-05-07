/**
 * Copyright (c) 2017 GT Nexus. All Rights Reserved.
 */
package com.op.oops;

abstract class AbstractClass {

    public void method() {
        System.out.println("abstract method....");
    }
}

public class AbstractClassTest {

    public static void main(String a[]) {
        // creating an instance of an anonymous subclass of your abstract class
        AbstractClass m = new AbstractClass() {
        };
        m.method();
    }
}