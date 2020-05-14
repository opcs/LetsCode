
package com.op.oops;

public class A {

    public int f() {
        return 3;

    }

    public static void main(String args[]) {
        A ref1 = new C();
        B ref2 = (B) ref1;
        System.out.println(ref2.f());
    }

}

class B extends A {

    public int f() {
        return 1;

    }

}

class C extends B {

    public int f() {
        return 2;

    }

}
