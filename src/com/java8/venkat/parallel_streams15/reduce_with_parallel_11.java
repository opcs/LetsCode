package com.java8.venkat.parallel_streams15;
import java.util.Arrays;
import java.util.List;

class reduce_with_parallel_11 {              
  public static void printThreadInfo(int number) {
    System.out.println("called for " + number + " from " + Thread.currentThread());    
  }                   
  
  public static boolean isEven(int number) {
    printThreadInfo(number);
    return number % 2 == 0;
  }
  
  public static int doubleIt(int number) {
    printThreadInfo(number);
    return number * 2;
  }                                     
  
  public static int addTwo(int total, int number) {
    System.out.println("addTwo called with " + total + ", " + number + " from " + Thread.currentThread());
    return total + number;
  }                           
  
  public static void main(String[] args) {
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
                   
    System.out.println(
      numbers.parallelStream()
             .reduce(0, reduce_with_parallel_11::addTwo));
                    

/*             
                  e1      e2       e3     e4      e5
                   |      |        |      |       |
                   v      v        v      v       v
             ---> op ---> op ---> op ---> op ---> op --->
*/           
  }              
}










