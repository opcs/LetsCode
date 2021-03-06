package com.java8.venkat.parallel_streams15;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import com.java8.venkat.parallel_streams15.common.Timeit;

class parallel_is_not_always_fast_17 {       
  public static boolean isEven(int number) {
    return number % 2 == 0;
  }                        
  
  public static int doubleIt(int number) {
    return number * 2;
  }                   

  public static void doWork(boolean parallel) {
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    
    Stream<Integer> stream = numbers.stream();
      
    if(parallel) stream = stream.parallel();
   
    System.out.println(
      stream.filter(parallel_is_not_always_fast_17::isEven)
            .mapToInt(parallel_is_not_always_fast_17::doubleIt)
            .sum());
  } 
  
  public static void main(String[] args) {
    doWork(false);
    doWork(true);
    
    Timeit.code(() -> doWork(false));
    Timeit.code(() -> doWork(true));
  }              
}










