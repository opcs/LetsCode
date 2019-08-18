package com.op.letscheckfinal;

public final class Student {

	private String name;
	private long studentId;
	public Student(String name, long studentId) {
		super();
		this.name = name;
		this.studentId = studentId;
	}
	public Student() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public long getStudentId() {
		return studentId;
	}
	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", studentId=" + studentId + "]";
	}
	
}
