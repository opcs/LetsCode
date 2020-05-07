/**
 * Copyright (c) 2017 GT Nexus. All Rights Reserved.
 */
package com.op.oops;

public class ReturnNullForIntType {


    public static void main(String[] args) {
        AA a = new AA();
        a.getValue();

    }

}

class AA {

    public int getValue() {
        // return true ? null : 0; not allowed
        return true ? 1 : 0;
    }
}
