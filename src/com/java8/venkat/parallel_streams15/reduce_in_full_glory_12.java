package com.java8.venkat.parallel_streams15;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class reduce_in_full_glory_12 {              
  public static void main(String[] args) {
    List<String> names = Arrays.asList("Jack", "Jane", "Stu", "Bob");
                                                                        
    System.out.println(                                                                    
      names.stream()
           .map(String::toUpperCase)
           .reduce(
              new ArrayList<String>(),
              (list, e) -> { list.add(e); return list; },
              (list1, list2) -> { list1.addAll(list2); return list1; }));
              
            //The above is what collect(toList()) does, so we don't have to
            //endure that pain.
  }              
}










