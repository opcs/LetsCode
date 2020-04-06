package com.op.validator.data;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CSVReader implements Reader{

	private static Reader reader = new CSVReader();

	@Override
	public Records readTxnDetails(String path) {
		return readTxnRecordsFromCSV(path);
	}

	private static Records readTxnRecordsFromCSV(String fileName) {
		List<TxnRecord> records = new ArrayList<>();
		Path pathToFile = Paths.get(fileName);

		try (BufferedReader br = Files.newBufferedReader(pathToFile,
                StandardCharsets.US_ASCII)) {

            // read header, the first line from the csv file
            String line = br.readLine();

            // loop record data, until all lines are read
            line = br.readLine();
            while (line != null) {

                String[] attributes = line.split(",");

                TxnRecord record = createRecord(attributes);
                records.add(record);

                // read next line, if end of file reached, line would be null and exit the loop
                line = br.readLine();
            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        return new Records(records);
    }

	private static TxnRecord createRecord(String[] attributes) {
		//System.out.println(attributes[0] +" " + attributes[1] +" "+attributes[2]+" "+attributes[3]+" "+attributes[4]+" "+attributes[5]);
		TxnRecord record = new TxnRecord(attributes[0],attributes[1],attributes[2],Double.parseDouble(attributes[3]),Double.parseDouble(attributes[4]),Double.parseDouble(attributes[5]));
		return record;
	}
	public static Reader getReader() {
		// TODO Auto-generated method stub
		return reader;
	}


	
}
