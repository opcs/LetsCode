/**
 * Copyright (c) 2017 GT Nexus. All Rights Reserved.
 */
package com.op.lock;

/**
 * iterator fail-fast issue can't be resolved using lock unlock but dirty-read problems can be avoided
 * 
 * @author oprakash
 * @created 23-Mar-2017
 * @vcsid $Id: $
 */
public class RWLockedHashMapTest {


    public static void main(String[] args) {

        RWLockedHashMap<String, String> context = new RWLockedHashMap<>();

        context.put("key_1", "value_1");
        context.put("key_2", "value_2");

        for (String key : context.keySet()) {
            System.out.println(context.get(key));
            context.writerLock();
            context.remove(key);
            context.writerUnlock();
        }
    }

}
