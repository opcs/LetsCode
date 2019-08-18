package com.code.logical;

public class FactorialCheck {

	public static void main(String[] args) {
		checkFctorial(24);
	}

	public static void checkFctorial(int n) {
		int x = 1;
		if (n <= 0) {
			System.out.println("False");
			return;
		}
		if (n == 2 || n == 1) {
			System.out.println("True");
			return;
		}
		for (int i = 2; i <= n; i++) {
			if (n % i == 0) {
				x = x * i;
				if (n == x) {
					System.out.println("True");
					return;
				}
			} else {
				System.out.println("False");
				return;
			}
		}
		if (n == x) {
			System.out.println("True");
			return;
		}

	}

}
