package com.code._misc;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class LargeFileSplit {

	public static void main(String[] args) {
		Path bigFile = Paths.get("G:\\DesktopBkUp\\InpLargeFiles\\all_classes_del.txt");
		try {
			LargeFileSplit.splitTextFiles(bigFile, 100);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	public static void splitTextFiles(Path bigFile, int maxRows) throws IOException{

        int i = 1;
        try(BufferedReader reader = Files.newBufferedReader(bigFile)){
            String line = null;
            int lineNum = 1;
            
            Path splitFile = Paths.get(i + "split.txt");
            BufferedWriter writer = Files.newBufferedWriter(splitFile, StandardOpenOption.CREATE);

            while ((line = reader.readLine()) != null) {

                if(lineNum > maxRows){
                    writer.close();
                    lineNum = 1;
                    i++;
                    splitFile = Paths.get(i + "split.txt");
                    writer = Files.newBufferedWriter(splitFile, StandardOpenOption.CREATE);
                }

                writer.append(line);
                writer.newLine();
                lineNum++;
            }

            writer.close();
        }
}
}
