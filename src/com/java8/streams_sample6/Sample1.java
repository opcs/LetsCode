package com.java8.streams_sample6;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

/** 1.
 * Deodorizing Inner-classes
 * Single abstract method interface -> Functional Interface
 * 
 */
public class Sample1 {
	
	public void printInt(int number) {
		System.out.println("Runnable task " + number);
	}

	public static void main(String[] args) {
		ExecutorService es = Executors.newFixedThreadPool(10);

		/*
		 * for (int i = 0; i < 10; i++) { 
		 * int index = i;                  // effectively final
		 * es.submit(new Runnable() {
		 * public void run() { 
		 * System.out.println("Runnable task " + index); 
		 * } 
		 * }); 
		 * 
		// index=22;    java 8 will give error: index is mutually considered as final by compiler and is called effectively final
		 * }
		 */
		IntStream.range(0, 10).forEach(i -> {
			int index = i;
			es.submit(() -> System.out.println("Runnable task " + index +"  thread - " + Thread.currentThread()));
			//es.submit(Sample1::printInt);
		});

		System.out.println("Task started...");
		es.shutdown();
	}

}
