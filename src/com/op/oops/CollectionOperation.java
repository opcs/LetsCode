/**
 * Copyright (c) 2017 GT Nexus. All Rights Reserved.
 */
package com.op.oops;

import java.util.HashSet;
import java.util.Set;

public class CollectionOperation {

    public static void main(String[] args) {
        Set<Integer> set = new HashSet<Integer>();
        Integer i1 = 45;
        set.add(i1);
        System.out.println(set);
        i1 = 46;
        System.out.println(set);
        set.remove(i1);
        System.out.println(set);

        Set<Student> students = new HashSet<Student>();
        Student yamang = new Student("yamang", 111111);
        students.add(yamang);
        System.out.println(students);
        yamang.setName("Sarfaraz");
        System.out.println(students);
        students.remove(yamang);
        System.out.println(students);

    }

}
