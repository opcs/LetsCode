package com.interviews;

class A {
	static {
		System.out.println("A");
	}

}

class B extends A{
	static {
		System.out.println("B");
	}

}

class C extends B{
	static {
		System.out.println("C");
	}
}

public class StaticBlockTest{
	
	
	public static void main(String[] args) {
		
		C c = new C();
		
	}
}

