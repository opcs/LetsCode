package com.code.oops;

public class StrPoolTest {

	public static void main(String[] args) {

		StringBuffer s= new StringBuffer("A");
		StringBuffer s1=new StringBuffer("B");
		StrPoolTest pt=new StrPoolTest();
		pt.myBuff(s,s1);
		System.out.println("outside: "+s);   // AB
	}

	private void myBuff(StringBuffer s, StringBuffer s1) {
		 s.append(s1);   // change is referencial, 
		 System.out.println("after append: " + s);   // AB
		s=s1;   // change is local to function only
		System.out.println("after assignment " + s);   //B ie s1
	}

}
