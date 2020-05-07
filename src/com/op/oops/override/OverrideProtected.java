/**
 * Copyright (c) 2017 GT Nexus. All Rights Reserved.
 */
package com.op.oops.override;

public class OverrideProtected {
	public static void main(String[] args) {
		Child c = new Child();
		c.count();
	}
}

/**
 * @author opcs this method gets inherited to subsequent child classes, even in
 *         grand child class also
 */
class GrandPa {

	protected void count() {
		System.out.println("GrandPa...");
	}
}

class Parent extends GrandPa {

	/*
	 * protected void count() { System.out.println("Parent..."); }
	 */

}

class Child extends Parent {

	/*
	 * protected void count() { System.out.println("child..."); }
	 */

	protected void childCount() {
		System.out.println("child count ...");
	}
}