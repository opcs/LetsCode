package com.java8.parallel_streams15;
import java.util.Arrays;
import java.util.List;

class imposing_order_reluctantly_07 {   
  public static void printIt(int number) {
    System.out.println("The value is " + number + 
      " in thread " + Thread.currentThread());
  }                                     
  public static void main(String[] args) {
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
                   
      numbers.stream()
             .forEachOrdered(imposing_order_reluctantly_07::printIt);

      System.out.println("------------");
      numbers.parallelStream()
             .forEachOrdered(imposing_order_reluctantly_07::printIt);
  }              
}










