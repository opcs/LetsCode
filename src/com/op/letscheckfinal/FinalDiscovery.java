package com.op.letscheckfinal;

public class FinalDiscovery {

	private final String name="finalName";
	private final Student stud_f=new Student("fname", 2222L);     // final reference content can be modified but not reference itself
	

	public Student getStud_f() {
		return stud_f;
	}

	public FinalDiscovery() {
		super();
	}

	public String getName() {
		return name;
	}
	
}
