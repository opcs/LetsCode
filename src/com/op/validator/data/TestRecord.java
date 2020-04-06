package com.op.validator.data;

import java.io.File;

public class TestRecord {

	public static void main(String[] args) {
		String dir="C:\\Users\\opcs\\git\\LetsCode\\src\\com\\op\\data\\resources\\";
		File folder = new File(dir);
		File[] files = folder.listFiles();
		String fileName = files[0].getName();
		Reader reader= ReaderFactory.getReader(fileName);
        //System.out.println(fileName);
		
		Records records = reader.readTxnDetails(dir+"\\\\"+fileName);

		String message = RecordValidator.validate(records);
	    System.out.println(message);
	}

}
