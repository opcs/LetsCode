/**
 * Copyright (c) 2017 GT Nexus. All Rights Reserved.
 */
package com.op.logical;

import java.util.ArrayList;
import java.util.List;

public class ArrayTest {


    public static void main(String[] args) {
        int number[] = new int[20];

        number[0] = 0;
        number[1] = 1;

        // always 20 as length of array
        System.out.println("array length: " + number.length);

        List<Integer> ages = new ArrayList<>(10);
        ages.add(23);
        ages.add(24);
        ages.add(25);
        ages.add(2, 1000);
        ages.add(4, 1000);
        ages.add(5, 1000);
        // always effective size i.e 3
        System.out.println("list size: " + ages.size());
        System.out.println("last index: " + ages.lastIndexOf(ages)); // -1

        ArrayList<Integer> emptyList = new ArrayList<>();

        ages.addAll(emptyList);

    }

}
