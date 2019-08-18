/**
 * Copyright (c) 2016 GT Nexus. All Rights Reserved.
 */
package com.code.logical;

import java.math.BigDecimal;
import java.util.Scanner;

public class BigDecimalTest {

    public static void main(String[] args) {
        int sum = addNumbers();
        System.out.println("sum = " + sum);
        BigDecimal number = new BigDecimal(10);

        changeNumber(number);
        System.out.println("final: " + number);

    }

    /**
     * @return
     */
    private static int addNumbers() {
        Scanner in = new Scanner(System.in);
        final String dataCount = in.nextLine();
        final String numberList = in.nextLine();
        System.out.println(dataCount);
        System.out.println(numberList);
        final String[] numbers = numberList.split(" ");
        int sum = 0;
        for (String number : numbers) {
            sum = sum + Integer.valueOf(number);
        }
        return sum;
    }

    private static void changeNumber(BigDecimal number) {
        number = new BigDecimal(100.00);
        System.out.println("local: " + number);
    }

}
