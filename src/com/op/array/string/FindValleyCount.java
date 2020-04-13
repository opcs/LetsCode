package com.op.array.string;

public class FindValleyCount {

	public static void main(String[] args) {
		// D - down, U - going Up
		String input = "UDDDUDUU";    // DDUUDDUDUUUD
		int n=8;					// 12
		int out=1;					// 2
		System.out.println("valleys: " + countingValleys(n, input));

	}

	// Complete the countingValleys function below.
	// A valley is a sequence of consecutive steps below sea level, 
	// starting with a step down from sea level and ending with a step up to sea level.
	static int countingValleys(int n, String s) {
		int seaLevel = 0;
		int Valleycount = 0;
		for (int i = 0; i < s.length(); i++) {
			int UD = s.charAt(i);

			if (UD == 'U') {
				seaLevel++;
				if (seaLevel == 0)
					Valleycount++;
			} else if (UD == 'D') {
				seaLevel--;

			}

		}
		return Valleycount;
	}

}
