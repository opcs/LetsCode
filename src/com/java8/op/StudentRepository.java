package com.java8.op;

import java.util.ArrayList;
import java.util.List;

public class StudentRepository {
	
protected	List<Student> getAllStudents(){
		List<Student> std = new ArrayList<>();
		std.add(new Student("Davis",SUBJECT.MATH,35.0));
		std.add(new Student("Davis",SUBJECT.SIENCE,12.9));
		std.add(new Student("Davis",SUBJECT.GEOGRAPHY,37.0));
		
		std.add(new Student("Sascha",SUBJECT.ENGLISH,85.0));
		std.add(new Student("Sascha",SUBJECT.MATH,80.0));
		std.add(new Student("Sascha",SUBJECT.SIENCE,12.0));
		std.add(new Student("Sascha",SUBJECT.LITERATURE,50.0));
		
		std.add(new Student("Robert",SUBJECT.LITERATURE,12.0));
		
		return std;
	}

}
