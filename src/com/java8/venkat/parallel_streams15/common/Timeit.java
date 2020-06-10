package com.java8.venkat.parallel_streams15.common;
public class Timeit {
  public static void code(Runnable block) {
    long start = System.nanoTime();
    try {
      block.run();
    } finally {
      long end = System.nanoTime();
      System.out.println("Time taken(s): " + (end - start)/1.0e9);
    }
  }
}
