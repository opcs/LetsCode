package com.op.oops.innerclass;

public class OuterInnerStatic {
    static int mainCount = 0;
    long outerId = 1000L;
    
    public static class NestedStaticClass {
        static int classCount = 4;
        int instanceCount = 5;           //1. can define non-static field

        public void printCount(){
            System.out.println(mainCount);    // access parent class static member directly
            //System.out.println(outerId);    //2. can't access outer-class non-static directly
            OuterInnerStatic out = new OuterInnerStatic();
            System.out.println(out.outerId);   // can access using ref variable
        }
    }
}

// points 1 differ with respect to static block

// eg -> ArrayListSpliterator in java.util.ArraList, also directly used in other classes like SubList/ArrayList
// When should I use a static nested class 

/*
 * static nested class behaves just like a regular top-level class.
 * Use static-nested classes when you are using the class in only one place but want
 * to treat it as a regular class otherwise.
 */