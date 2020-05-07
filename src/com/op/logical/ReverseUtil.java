package com.op.logical;

import java.util.ArrayList;
import java.util.Scanner;

public class ReverseUtil {

	public static void main(String[] args) {
		
		ArrayList<String> names = new ArrayList<>();
		names.add("opcs");
		names.add("kanchan");
		System.out.println("size: " + names.size());
		names.trimToSize();
		System.out.println("size: " + names.size());
		
		System.out.println("input String: ");
		Scanner input = new Scanner(System.in);
		String inputString = input.nextLine();
		
		String output = reverse(inputString);
		if(output==null){
			System.out.println("invalid input....");
		}else{
			System.out.println("reverse of " + inputString + " : " + output);
		}
	}

	public static String reverse(String str) {
		String outString="";
		if(str.length()==1)
			return str;
			else {
				 outString+=str.charAt(str.length()-1) + reverse(str.substring(0, str.length()-1));
			return outString;	
			}
	}
	
	public static String reverse(int number){
		int reverse = 0;
		while(number!=0){
			reverse=reverse*10+number%10;
			number=number/10;
		}
		return String.valueOf(reverse);
		
	}

}
