package com.interviews;

import java.util.HashMap;

public class PairToSum {

	public static void main(String[] args) {
		int[] numbers = { 4, 4, 4, 4, 4, 5 };
		PairToSum sol = new PairToSum();
		int pairCount = sol.getPairsCount(numbers, numbers.length, 8);
		System.out.println("pair count: " + pairCount);

	}

	int getPairsCount(int[] arr, int n, int k) {
		// code here
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int count = 0;
		for (int i = 0; i < n; i++) {
			int diff = k - arr[i];
			Integer x = map.get(diff);

			if (x != null) {
				// pair found
				System.out.println(arr[i] + "," + arr[x]);
				count++;
			} else {
				map.put(diff, i);
			}
		}
		return count;
	}

	// contiguous subarray sum input: {2,-8, 3, -2, 4, -10} o/p: 5 {3, -2, 4}
	int getMaxSum(int[] a) {
		int maxsum = 0;
		int sum = 0;
		for (int i = 0; i < a.length; i++) {
			sum += a[i];
			if (maxsum < sum) {
				maxsum = sum;
			} else if (sum < 0) {
				sum = 0;
			}
		}
		return maxsum;
	}

}
