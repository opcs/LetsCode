package com.op.oops.innerclass;

class AllTypeInnerClasses {

	public AllTypeInnerClasses() {
		System.out.println("A-ctor");
	}

	private static int SIZE = 10;
	protected String name = "myname";
	private int priv = 10;

	class B {

		public B() {
			System.out.println("B-Ctor");
		}

		// static int x; //not allowed here
		void print() {
			System.out.println(SIZE);
			System.out.println(priv);
		}
	}
	
	private class BP {

		public BP() {
			System.out.println("BP-Ctor");
		}

		// static int x; //not allowed here
		void print() {
			System.out.println(SIZE);
			System.out.println(priv);
		}
	}

	static class C {

		public C() {
			System.out.println("C-Ctor");
		}

		int noStatic = 0;
		static int x; // allowed here

		void print() {
			System.out.println(SIZE);
			// System.out.println(priv);
		}
	}
}
