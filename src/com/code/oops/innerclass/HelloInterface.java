/**
 * Copyright (c) 2017 GT Nexus. All Rights Reserved.
 */
package com.code.oops.innerclass;

public interface HelloInterface {

    public static class HelloException extends Exception {

        public HelloException(String msg) {
            super(msg);
        }
    }

    public void hello() throws HelloException;

}

class InnerClasstest {

    public static void main(String[] args) {
        HelloInterface hi = new HelloInterface() {
            
            @Override
            public void hello() throws HelloException {
               System.out.println("           ");
                
            }
        };
}
}