package com.op.letscheckfinal;

//can't extend as RS is immutable
public class EnggRegStudent extends RegularStudentFinal{

	private long phone;
	private String branch;
	
	public EnggRegStudent(long phone, String branch){
		this.phone=phone;
		this.branch=branch;
	}
	public EnggRegStudent(){
	}
	
}
