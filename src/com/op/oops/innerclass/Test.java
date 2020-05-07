/**
 * Copyright (c) 2017 GT Nexus. All Rights Reserved.
 */
package com.op.oops.innerclass;

import com.op.oops.innerclass.A.B;

public class Test
{

    public static void main(String[] str)
    {
        A a = new A();

        // Non-Static Inner Class
        // Requires enclosing instance
        A.B obj1 = a.new B();

        // Static Inner Class
        // No need for reference of object to the outer class
        A.C obj2 = new A.C();
    }
}