/**
 * Copyright (c) 2017 GT Nexus. All Rights Reserved.
 */
package com.op.thread.prodconsumer;

import java.util.Map;

/**
 * @author oprakash
 * @created 10-Jan-2017
 * @vcsid $Id: $
 */
public class Consumer implements Runnable {

    private Map<String, String> nameValueMap;

    public Consumer(Map<String, String> nameValueMap) {
        this.nameValueMap = nameValueMap;
    }

    @Override
    public void run() {
        nameValueMap.put("", "");

    }

}
