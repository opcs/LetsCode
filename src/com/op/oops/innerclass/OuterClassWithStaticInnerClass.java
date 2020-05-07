/**
 * Copyright (c) 2017 GT Nexus. All Rights Reserved.
 */
package com.op.oops.innerclass;

import java.lang.reflect.Constructor;
import java.util.Arrays;


public class OuterClassWithStaticInnerClass {

    /**
     * can only access the static field of outer class directly, to access other fields it needs to first create
     * reference to that class
     */
    public static class InnerClass {

        public InnerClass(String foo, int bar) {
        }

        public InnerClass(String foo) {
        }

        public InnerClass() {
        }
    }

    public static void main(String[] args) {
        Constructor<?>[] constructors = InnerClass.class.getDeclaredConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println(Arrays.toString(constructor.getParameterTypes()));
        }

        Constructor<?>[] outconstructors = OuterClassWithStaticInnerClass.class.getDeclaredConstructors();
        for (Constructor<?> outconstructor : outconstructors) {
            System.out.println(Arrays.toString(outconstructor.getParameterTypes()));
        }
    }
}