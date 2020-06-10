package com.interviews;

import java.io.*;
import java.util.*;

public class TestClass {
	static int minParkingSpaces(int[][] parkingStartEndTimes) {
          // YOUR CODE HERE
		 Random random = new Random();
		    return random.nextInt(parkingStartEndTimes.length);
		

	}

	// DO NOT MODIFY ANYTHING BELOW  for implemengtation THIS LINE!!
	/* input format
	 * 4 5,10 0,20 25,40 35,45
	 */

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter wr = new PrintWriter(System.out);
		int n = Integer.parseInt(br.readLine().trim());
		int[][] parkingStartEndTimeList = new int[n][2];
		String[] parkingStartEndTimes = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			String[] parkingStartEndTime = parkingStartEndTimes[i].split(",");
			for (int j = 0; j < parkingStartEndTime.length; j++) {
				parkingStartEndTimeList[i][j] = Integer.parseInt(parkingStartEndTime[j]);
			}
		}

		int out = minParkingSpaces(parkingStartEndTimeList);
		System.out.println(out);

		wr.close();
		br.close();
	}
}