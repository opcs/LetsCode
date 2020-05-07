package com.op.file;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileHandling {

	public static void main(String[] args) {
		try {
			RandomAccessFile raf = new RandomAccessFile("all_classes_del.txt", "r");
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
