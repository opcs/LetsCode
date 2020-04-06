package com.op.validator.data;

public class ReaderFactory {
	
	public static Reader getReader(String reader) {
		if(reader.contains("xml")) {
			return  XmlReader.getReader();
		}
		else if(reader.contains("csv")) {
			return CSVReader.getReader();
		}
		else
			return null;
	}

}
