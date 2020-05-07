package com.op.thread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ThreadRunTest {
    public static void main(String[] args) {

        List<String> li = new ArrayList<String>();
        List<String> sysLi = Collections.synchronizedList(li);
        System.out.println("Synchronized list got created...");

        List<String> list = Collections.synchronizedList(new ArrayList<String>());

        synchronized (list) {
            Iterator i = list.iterator(); // Must be in synchronized block
            while (i.hasNext())
                li.add((String) i.next());
        }

        Thread th1 = new MyThread();
        th1.run(); // act as simple method.
        th1.start();

    }

}
