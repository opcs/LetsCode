
package com.op.innerclass;
import java.lang.reflect.Constructor;
import java.util.Arrays;


public class OuterClassWithStaticInnerClass {

    public static class InnerClass {

        public InnerClass(String foo, int bar) {
        }

        public InnerClass(String foo) {
        }

        public InnerClass() {
        }
    }

    /**
     * static inner class can only access static field of outer class and to access non-satic field needs to create object
     * @param args
     */
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