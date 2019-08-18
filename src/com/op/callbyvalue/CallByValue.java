package com.op.callbyvalue;

public class CallByValue {
	private String name;
	public CallByValue(String name) {
		this.name = name;
	}
	public static void main(String[] args) {
		CallByValue cv = new CallByValue("ABC");
		change(cv);
		System.out.println("out main val:::  "+cv.getName());    // XYZ
	}
	
	static void  change(CallByValue cv){
		cv.setName("XYZ");
		cv = new CallByValue("PQR");  // this change is only for local scope
		System.out.println("======== change local ====== "+cv.getName());
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
