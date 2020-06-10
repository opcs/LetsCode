package com.java8.udemy.streams;

import java.util.List;
import java.util.stream.IntStream;

import com.java8.udemy.data.Student;
import com.java8.udemy.data.StudentDataBase;

import static java.util.stream.Collectors.toList;

public class StreamsFilterExample {

    public static List<Student> filterStudents(){

        List<Student> filteredStudentList = StudentDataBase.getAllStudents()
                .stream()
                .filter(student -> student.getGpa()>=3.9)
                .filter(student -> student.getGender().equals("female"))
                .collect(toList());

        return filteredStudentList;
    }

    public static void main(String[] args) {

        System.out.println("Filtered Students : " + filterStudents());

    }
}
