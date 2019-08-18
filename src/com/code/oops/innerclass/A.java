/**
 * Copyright (c) 2017 GT Nexus. All Rights Reserved.
 */
package com.code.oops.innerclass;



class A
{

    public A() {
        System.out.println("A-ctor");
    }

    private static int SIZE = 10;
    protected String name = "myname";

    class B
    {

        public B() {
            System.out.println("B-Ctor");
        }
        // static int x; not allowed here
    }

    static class C
    {

        public C() {
            System.out.println("C-Ctor");
        }

        static int x; // allowed here
    }
}


