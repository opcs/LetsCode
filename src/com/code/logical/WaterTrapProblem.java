package com.code.logical;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class WaterTrapProblem {

	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);
		System.out.println("input testCases: ");
		int testCases = sc.nextInt();
		int[] results = new int[testCases];
		int result=0;
			for (int i = 0; i < testCases; i++) { // running for 2 test cases
				// impl of water capacity for each test case
				int buildings = sc.nextInt();

				//System.out.println("input height for " + buildings + " building");
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				
				String heights = br.readLine();
				//System.out.println("heights: " + heights);
				String[] inHeights = heights.split(" ");

				int sum = 0;
				int first = Integer.valueOf(inHeights[0]);
				int sec = 0;

				for (int h = 1; h < inHeights.length; h++) {
					sec = Integer.valueOf(inHeights[h].trim());
					sum += min(first, sec);
					first = sec;
				}
				results[result] = sum;
				result++;
		}

		for (int res : results) {
			System.out.println(res);
		}
		// String next = heights;
	}

	private static int min(int first, int sec) {
		return first > sec ? sec : first;
	}

}
