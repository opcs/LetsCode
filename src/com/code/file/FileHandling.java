package com.code.file;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.nio.file.Path;

public class FileHandling {

	public static void main(String[] args) {
		try {
			RandomAccessFile raf = new RandomAccessFile("F:\\opcs\\DesktopBkUp\\LargeFiles\\all_classes_del.txt", "r");
			FileChannel filechannel = raf.getChannel();
			ByteBuffer buffer = ByteBuffer.allocate(1000000);
			
			System.out.println("-------------start---------------");
			while(filechannel.read(buffer)>0){
				System.out.println("-----------------------------------------");
				//buffer.flip();
				for (int i=0;i<buffer.limit();i++) {
					System.out.print(buffer.get() + " ");
				}
				//buffer.clear();
			}
		}  catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
}
