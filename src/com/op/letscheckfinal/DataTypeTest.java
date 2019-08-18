package com.op.letscheckfinal;

import java.util.Scanner;

public class DataTypeTest {

	public static void main(String[] args) {

		int i = 4;
		double d = 4.0;
		String s = "HackerRank";

		int i2;
		double d2;
		String s2;
		Scanner scan2 = new Scanner(System.in);
		i2 = Integer.parseInt(scan2.nextLine());
		d2=Double.parseDouble(scan2.nextLine());
		s2=scan2.nextLine();
		
		System.out.println(i+i2);
		System.out.println(d+d2);
		System.out.println(s+s2);

	}

}
