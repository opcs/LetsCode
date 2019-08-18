package com.code.logical;

import java.util.Scanner;

public class ReverseNumber {

	public static void main(String[] args) {
		
		System.out.println("input number: ");
		Scanner sc = new Scanner(System.in);
		//String input = input.next();
		int input = sc.nextInt();
		
		//String nextInt = String.valueOf(12345);
		String reversedNumber = ReverseUtil.reverse(input);
		System.out.println("reverse of  " + input +" : " + reversedNumber);
	}

}
