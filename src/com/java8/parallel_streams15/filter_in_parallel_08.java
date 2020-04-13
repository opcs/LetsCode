package com.java8.parallel_streams15;
import java.util.Arrays;
import java.util.List;

class filter_in_parallel_08 {              
  public static void printThreadInfo(int number) {
    System.out.println("called for " + number + " from " + Thread.currentThread());    
  }                   
  
  public static boolean isEven(int number) {
    printThreadInfo(number);
    return number % 2 == 0;
  }                                     
  
  public static void main(String[] args) {
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    numbers.parallelStream()
           .filter(filter_in_parallel_08::isEven)
           .forEach(System.out::println);
  }              
}










