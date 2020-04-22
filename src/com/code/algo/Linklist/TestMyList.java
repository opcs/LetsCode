package com.code.algo.Linklist;

public class TestMyList {

	public static void main(String[] args) {
		MyLinkList<String> names  = new MyLinkList<String>();
		
		System.out.println("----------start--------------");
		
		names.addAtEnd("opcs");
		names.addAtEnd("kkcs");
		  names.addAtEnd("seerat"); names.addAtEnd("Munna"); names.addAtEnd("bholu");
		  names.addAtEnd("suresh");
		 
		System.out.println("----------end--------------");
		System.out.println(names.toString());
		
		names.remove("suresh");
		System.out.println("----------after removed --------------");
		System.out.println(names.toString());
	}

}
