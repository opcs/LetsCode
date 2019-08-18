/**
 * Copyright (c) 2017 GT Nexus. All Rights Reserved.
 */
package com.code.thread;

import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentModExcep {

    public static void main(String[] args) {
        Map<String, String> nameValMap = new ConcurrentHashMap<>();
        nameValMap.put("1", "one");
        nameValMap.put("2", "two");
        // If the map is modified while an iteration over the set is in progress the results of the iteration are undefined
        for (Entry<String, String> entry : nameValMap.entrySet()) {
            nameValMap.put("3", "three");
            System.out.println(entry.getValue() + " ");
        }
    }
}

// only display 2 element one & two 