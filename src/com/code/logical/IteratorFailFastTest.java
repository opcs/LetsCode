/**
 * Copyright (c) 2016 GT Nexus. All Rights Reserved.
 */
package com.code.logical;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.TreeMap;
import java.util.Vector;

public class IteratorFailFastTest {

    public static void main(String[] args) {
        ArrayList al1 = new ArrayList();
        al1.add("Raju");
        al1.add("Reddy");
        al1.add("Rao");
        al1.add("Ratnakar");

        ListIterator it1 = al1.listIterator();

        while (it1.hasNext())
        {
            System.out.print(it1.next() + " ");
            it1.add("Setty");
            al1.add("Goud");
        }

        System.out.print(it1.next() + " ");
        it1.add("Setty");
        al1.add("Goud");
    }

}
