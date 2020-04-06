package com.op.array;

import java.util.Arrays;

public class ArrayTest {

	public static void main(String[] args) {
		char[] charArray = { 'z', 'a', 's' };
		System.out.println("length: "+charArray.length);
		
		System.out.println(num_of_zero(101000110));
		

	}
	
	static int num_of_zero(int num)
	 {
	   if(0 == num) return 1; /*For the input 0 it should output 1 */
	   int Count = 0;
	   while(num>0){
	     if(0 == (num%10))
	    		 Count++;
	    num /= 10;
	}
	return Count;
	}

}
