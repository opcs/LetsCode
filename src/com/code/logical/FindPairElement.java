/**
 * Copyright (c) 2017 GT Nexus. All Rights Reserved.
 */
package com.code.logical;

import java.util.HashMap;
import java.util.Map;

public class FindPairElement {

    public static void main(String[] args) {
        Map<Integer, Integer> elementIndexMap = new HashMap<>();
        int arr[] = { 1, 4, 2, 6, 3, 8, 2, 9 };
        int sum = 5;
        for (int i = 0; i < arr.length; i++) {
            elementIndexMap.put(arr[i], i);
        }

        for (int i = 0; i < arr.length; i++) {
            if (elementIndexMap.containsKey(sum - arr[i])) {
                System.out.println("indexex: " + i + " & " + elementIndexMap.get(sum - arr[i]));
            }
        }
    }
}
