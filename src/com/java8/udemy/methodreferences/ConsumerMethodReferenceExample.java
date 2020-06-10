package com.java8.udemy.methodreferences;

import java.util.function.Consumer;

import com.java8.udemy.data.Student;
import com.java8.udemy.data.StudentDataBase;

public class ConsumerMethodReferenceExample {

    /**
     * Class::instancemethod
     */
    static Consumer<Student>  c1= System.out::println;


    /**
     * instance::instancemethod
     */
    static Consumer<Student> c2 = (student -> student.printListOfActivities());
    static Consumer<Student> c3 = (Student::printListOfActivities);

    public static void main(String[] args) {

        StudentDataBase.getAllStudents().forEach(c1);
        StudentDataBase.getAllStudents().forEach(c2);
        StudentDataBase.getAllStudents().forEach(c3);
    }

}
