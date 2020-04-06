package com.code.algo.Linklist;

public class TestMyList {

	public static void main(String[] args) {
		MyLinkList<String> names  = new MyLinkList<String>();
		
		System.out.println("----------start--------------");
		
		names.add("opcs");
		/*
		 * names.add("seerat"); names.add("Munna"); names.add("bholu");
		 * names.add("suresh");
		 */
		System.out.println("----------end--------------");
		System.out.println(names.toString());
		
		names.remove("suresh");
		System.out.println("----------after removed --------------");
		System.out.println(names.toString());
	}

}
