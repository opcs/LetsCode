package com.code._misc;
import java.util.Arrays;

public class Program {

	static int[] fib = new int[180];
	{
		fib[1] = 1;
	}

	public static void main(String[] args) {
		// System.out.println(Program.getNthFib(18));
		int[] out = new int[2];
		out = Program.twoNumberSum(new int[] { 4, 6 }, 10);
		System.out.println(out[0] + " " + out[1]);
	}

	public static int getNthFib(int n) {

		if (n < 3) {
			return n - 1;
		} else {
			if (fib[n - 1] > 0)
				return fib[n - 1];
			else {
				// calculate, save results and return
				int res = getNthFib(n - 1) + getNthFib(n - 2);
				fib[n - 1] = res;
			}
		}
		return fib[n - 1];
	}

	public static int[] twoNumberSum(int[] array, int targetSum) {
		int left = 0, sum = 0, right = array.length - 1;
		int[] result = new int[2];
		Arrays.sort(array);
		while (left <= right) {
			sum = array[left] + array[right];
			if (sum < targetSum) {
				left++;
			} else if (sum > targetSum) {
				right--;
			} else {
				// sum achieved
				result[0] = array[left];
				result[1] = array[right];
				break;
			}
		}
		return result;
	}

}
