package com.op.array.string;

import java.util.stream.Stream;

import sun.security.krb5.internal.LastReqEntry;

/**
 * @author opcs Input: "Mr John Smith JJ, 13 Output: "Mr%2eJohn%2eSmith"
 */
public class URLify {

	public static void main(String[] args) {
		String input = "Mr John Smith    ";
		String appender = "%20";
		int trueLength = 13;

		StringBuilder sb = new StringBuilder();

		String[] words = input.trim().split(" ");

		for (int i = 0; i < words.length; i++) {
			sb.append(words[i]);
			if (i != words.length - 1)
				sb.append(appender);
		}

		System.out.println(sb.toString());

		char[] chars = input.toCharArray();
		System.out.println(chars.length);

		char[] replacedChar = replaceSpaces(chars, trueLength);
		System.out.println(replacedChar);
	}

	private static char[] replaceSpaces(char[] chars, int trueLength) {
		int spaceCount = 0;
		// 1. count the space and create last index
		for (int i = 0; i < trueLength; i++) {
			if (chars[i] == ' ') {
				spaceCount++;
			}
		}
		System.out.println("space count "+ spaceCount);
		int lastIndex = trueLength + spaceCount * 2;
		// 2. start from last index and move chars end and replace space with %20
		for (int i = trueLength - 1; i >= 0; i--) {
			// if not space, move char to end
			if (chars[i] == ' ') {
				chars[lastIndex - 1] = '0';
				chars[lastIndex - 2] = '2';
				chars[lastIndex - 3] = '%';
				lastIndex=lastIndex-3;

			} else {
				chars[lastIndex - 1] = chars[i];
				lastIndex--;
			}
		}
		return chars;

	}

}
