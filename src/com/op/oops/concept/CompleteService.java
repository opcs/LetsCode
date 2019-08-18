package com.op.oops.concept;

public class CompleteService implements StudentService, EmployeeService{

	@Override
	public void service() {
		System.out.println("complete service");
		
	}

}
