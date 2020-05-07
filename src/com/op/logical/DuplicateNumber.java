package com.op.logical;

import java.util.ArrayList;
import java.util.List;

public class DuplicateNumber {

	public static void main(String[] args) {
		List<Integer> numbers=new ArrayList<>();
		
		for(int i=1;i<155;i++)
			numbers.add(i);
		
		// add duplicate number
		numbers.add(5);
		
		System.out.println("duplicate number: " + findDuplicate(numbers));
	}

	private static int findDuplicate(List<Integer> numbers) {
		int totalSum = getSum(numbers);
		System.out.println("totalSum: " + totalSum);
		int numOfNumber=numbers.size()-1;
		int sumOfNumber = numOfNumber * (numOfNumber+1)/2;
		System.out.println("sumOfNumber: " + sumOfNumber);
		int duplicate = totalSum - sumOfNumber;
		return duplicate;
	}

	private static int getSum(List<Integer> numbers) {
		int sum=0;
		for (Integer number : numbers) {
			sum+=number;
		}
		return sum;
	}

}
