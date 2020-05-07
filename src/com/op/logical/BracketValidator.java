/**
 * Copyright (c) 2017 GT Nexus. All Rights Reserved.
 */
package com.op.logical;

import java.util.Scanner;

public class BracketValidator {

    public static boolean IsWellFormedBrackets(String input)
    {
        String previous = "";
        while (input.length() != previous.length())
        {
            previous = input;
            input = input.replace("()", "").replace("[]", "").replace("{}", "");
        }
        return (input.length() == 0);
    }

    public static void main(String[] args) {
        System.out.println("inter the brackets: ");
        Scanner sc = new Scanner(System.in);
        String brackets1 = sc.nextLine();
        System.out.println("isvalid: " + BracketValidator.IsWellFormedBrackets(brackets1));
    }

}
