/**
 * Copyright (c) 2017 GT Nexus. All Rights Reserved.
 */
package com.op.immutable;

/**
 * 1. Don't provide "setter" methods — methods that modify fields or objects referred to by fields.
 * 2. Make all fields final and private.
 * 3. Don't allow subclasses to override methods. The simplest way to do this is to declare the class as final. A more
 * sophisticated
 * approach is to make the constructor private and construct instances in factory methods.
 * 4. If the instance fields include references to mutable objects, don't allow those objects to be changed: remove reference
 * dependency
 * A. Don't provide methods that modify the mutable objects.
 * B. Don't share references to the mutable objects. Never store references to external, mutable objects passed to the
 * constructor;
 * if necessary, create copies, and store references to the copies. Similarly, create copies of your internal mutable objects when
 * necessary to avoid returning the originals in your methods.
 */
public class ImmutableTest {

    /**
     * you can modify the address object alone, but address within ImmEmployee object can't, as because it is immutable.
     */
    public static void main(String[] args) {
        // used defensive copy, to make it immutable
        Address opAddress = new Address("Cunningham Road", 560052);
        ImmEmployee op = new ImmEmployee(100, opAddress);
        System.out.println("employee op details: " + op);

        // will not make impact, as reference data gets copied defensively
        opAddress.setStreetName("MG Road");
        
        // security breach - handle it carefully
        op.getAddress().setStreetName("MG Road");

        System.out.println("after update, employee op details: " + op);
    }

}
