package com.op.letscheckfinal;

// making constructor private and all fields private final is another way of making an Immutable class.

public class RegularStudentFinal{

	private final String name="";
	private final long id=12;
	
	private RegularStudentFinal(){
	}
	
	public RegularStudentFinal getInstance(){
		return new RegularStudentFinal();
	}
	
	public boolean isRegular(){
		return false;
		
	}
}
