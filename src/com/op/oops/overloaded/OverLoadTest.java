/**
 * Copyright (c) 2017 GT Nexus. All Rights Reserved.
 */
package com.op.oops.overloaded;
public class OverLoadTest {

    public static void main(String[] args) {
        Overload ol = new Overload();
        Object obj = new Object();
        Object str = new String("String");
        Object intt = new Integer(10);

        ol.print(obj);
        ol.print(str);
        ol.print(intt);
        // ol.print(null); method is ambiguous
    }

}

class Overload {

    public void print(Object o) {
        System.out.println("Object " + o);
    }

    public void print(String o) {
        System.out.println("String " + o);
    }
    
    public void print(StringBuffer o) {
        System.out.println("StringBuffer " + o);
    }

    public void print(Integer o) {
        System.out.println("Integer " + o);
    }
}