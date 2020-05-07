/**
 * a Non Static inner class has outer class reference as the 1st arguments(inserted by jvm always).
 * hence, its able to access the private field of outer class directly
 * even in default no-argument constructor also has the outer class reference.
 */
package com.op.oops.innerclass;

import java.lang.reflect.Constructor;
import java.util.Arrays;


public class OuterClassWithNonStaticInnerClass {

    /**
     * inner class has the reference to Outer class byDefault, hence private fields are accessible from inner class
     * directly. also the 1st arg of all the Ctor of inner class is outer class reference which is hidden.
     */
    public class InnerClass {

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

        Constructor<?>[] outconstructors = OuterClassWithNonStaticInnerClass.class.getDeclaredConstructors();
        for (Constructor<?> outconstructor : outconstructors) {
            System.out.println(Arrays.toString(outconstructor.getParameterTypes()));
        }
    }
}