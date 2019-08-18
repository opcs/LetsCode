package com.code.runtime.shutdown_hook;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;

/**
 * @author opcs
 * reading a file line by line from some directory and processing it. state is saved in a static variable so that 
 * shutdown hook can access it and send notification.
 */
public class FilesProcessor {

	public static String status = "STOPPED";
	public static String fileName = "";

	public static void main(String[] args) {
		String directory = "C:/Users/opcs/Desktop/Mi4iBkUp/QText";
		Runtime.getRuntime().addShutdownHook(new ProcessorHook());
		File dir = new File(directory);

		File[] txtFiles = dir.listFiles(new FilenameFilter() {

			@Override
			public boolean accept(File dir, String name) {
				if (name.endsWith(".txt"))
					return true;
				else
					return false;
			}
		});

		for (File file : txtFiles) {
			System.out.println(file.getName());
			BufferedReader reader = null;
			status = "STARTED";
			fileName = file.getName();
			try {
				FileReader fr = new FileReader(file);
				reader = new BufferedReader(fr);
				String line;

				line = reader.readLine();

				while (line != null) {
					System.out.println(line);
					Thread.sleep(1000); // assuming it takes 1 second to process each record
					// read next line
					line = reader.readLine();
				}
				status = "PROCESSED";
			} catch (IOException | InterruptedException e) {
				status = "ERROR";
				e.printStackTrace();
			}finally{
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		status="FINISHED";
	}

}
