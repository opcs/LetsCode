package com.java8.udemy.methodreferences;

import java.util.function.Supplier;

import com.java8.udemy.data.Student;

public class SupplierMethodReferenceExample {

    Supplier<Student> studentSupplier = Student::new;

    public static void main(String[] args) {

        System.out.println();

    }
}
