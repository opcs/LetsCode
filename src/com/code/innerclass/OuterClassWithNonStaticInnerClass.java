/**
 * a Non Static inner class has outer class reference as the 1st arguments(inserted by jvm always).
 * hence, its able to access the private field of outer class directly
 * even in default no-argument constructor also has the outer class reference.
 */
package com.code.innerclass;

import java.lang.reflect.Constructor;
import java.util.Arrays;


public class OuterClassWithNonStaticInnerClass {

    public class InnerClass {

        public InnerClass(String foo, int bar) {
        }

        public InnerClass(String foo) {
        }

        public InnerClass() {
        }
    }

    /**
     * All the non-static inner class constructor has the 1st arguments as Outer class reference
     * hence, outer class private field are directly accessible from inner class.
     * @param args
     */
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