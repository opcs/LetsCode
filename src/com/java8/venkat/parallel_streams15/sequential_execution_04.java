package com.java8.venkat.parallel_streams15;
import java.util.Arrays;
import java.util.List;

class sequential_execution_04 {   
  public static int doubleIt(int number) {
    System.out.println("doubleIt called in thread " + Thread.currentThread());
    return number * 2;
  }                                     
  public static void main(String[] args) {
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
                   
    System.out.println(
      numbers.stream()
             .mapToInt(sequential_execution_04::doubleIt)
             .sum());
  }              
}










