/**
 * Copyright (c) 2017 GT Nexus. All Rights Reserved.
 */
package com.code.thread.prodconsumer;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ProdConsTest {

    public static void main(String[] args) {
        Map<String, String> nameValueMap = new ConcurrentHashMap();
        Thread prod = new Thread(new Producer(nameValueMap));
        prod.start();

        Thread consumer = new Thread(new Consumer(nameValueMap));
        consumer.start();

    }

}
