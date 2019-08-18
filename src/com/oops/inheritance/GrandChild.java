package com.oops.inheritance;

public class GrandChild extends Child {

	public GrandChild(){
		super();
	}
	
	public void gMethod(){
		GrandChild gc = new GrandChild();
		int glv = gc.i;
	}
}
