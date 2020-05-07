package com.op._misc;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class LargeFileSplitTest {

	public static void main(String[] args) {

		Path bigFile = Paths.get("C:\\Users\\oprakash\\Desktop\\BigFile\\readme.txt");
		try {
			System.out.println("-----------------start splitting---------------------");
			LargeFileSplitLogic.splitTextFiles(bigFile, 100);
			System.out.println("--------------completed-------------------------");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
