package com.code.file;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class SmallFileRW {

	public static void main(String[] args) {
		// Path inpfile =
		// Paths.get("F:\\opcs\\DesktopBkUp\\LargeFiles\\all_classes_del.txt");

		File[] files = new File("F:\\opcs\\DesktopBkUp\\LargeFiles").listFiles();
		// read all files and write chunk wise to a single file
		int oneGB = 1024 * 1024 * 1024;
		ByteBuffer buffer = ByteBuffer.allocate(oneGB); // 1gb

		Path outfile = Paths.get("F:\\opcs\\DesktopBkUp\\LargeFiles\\out\\output.txt");
		byte[] fileArray, bufferData;
		RandomAccessFile raf;
		FileChannel inChannel;
		int NoOfBytes;
		try {
			for (File file : files) {
				if (!file.isDirectory()) {
					System.out.println("reading " + file.getName());
					String fileToRead = "F:\\opcs\\DesktopBkUp\\LargeFiles\\" + file.getName();
					 raf = new RandomAccessFile(fileToRead, "r");
					 inChannel = raf.getChannel();
					 NoOfBytes = inChannel.read(buffer);
					 while(inChannel.read(buffer)>0){
						 bufferData = buffer.array();
						Files.write(outfile, bufferData, StandardOpenOption.APPEND); 
						buffer.clear();
					 }
					// fileArray = Files.readAllBytes( Paths.get(fileToRead));
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
