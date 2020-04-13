package com.java8.parallel_streams15;
import java.util.Arrays;
import java.util.List;

class parallel_execution_05 {   
  public static int doubleIt(int number) {
    System.out.println("doubleIt called for " + number + 
      " in thread " + Thread.currentThread());
    return number * 2;
  }                                     
  public static void main(String[] args) {
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
                   
    System.out.println(
      numbers.parallelStream()
             .mapToInt(parallel_execution_05::doubleIt)
             .sum());
  }              
}










