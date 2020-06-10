package com.java8.udemy.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamsMaxMinExample {


    public static Optional<Integer> maxValue(List<Integer> integerList){
        return integerList.stream()
                //.reduce(0,(a,b)->(a>b) ? a : b);
        		// a holds the max value, initialized to 0
        		//6 -> max(0,6) ->6
        		//7 -> max(6,7) ->7
        		//8
        		//9
        		//10 -> max(9,10) ->10
        .reduce(Integer::max);
    }

    public static Optional<Integer> minValue(List<Integer> integerList){
        return integerList.stream()
                .reduce((a,b)->(a<b) ? a : b); //a hold min value, without optional
                //.reduce(0,Integer::min);	// this will results in 0 value, be careful with it
    }


    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(6,7,8,9,10);
        Optional<Integer> maxValue =maxValue(integers);
        int max = maxValue.isPresent() ? maxValue.get():0;
        System.out.println("Max Value is : " + max);

        Optional<Integer> minValue =minValue(integers);
        int min = minValue.isPresent() ? minValue.get():0;
        System.out.println("Min Value is : " + min);
    }
}
