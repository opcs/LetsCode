package com.java8.op;

public class Student {
	private String name;
	SUBJECT subject;
	double marks;

	public Student(String name, SUBJECT subjects, double marks) {
		super();
		this.name = name;
		this.subject = subjects;
		this.marks = marks;
	}

	public String getName() {
		return name;
	}

	public SUBJECT getSubject() {
		return subject;
	}

	public double getMarks() {
		return marks;
	}

	@Override
	public String toString() {
		return name;
	}

}
