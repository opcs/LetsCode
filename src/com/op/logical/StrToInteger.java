package com.op.logical;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StrToInteger {
  public static void main(String[] args) throws NumberFormatException, IOException  {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    String s;
    while ((s = in.readLine()) != null) {
      System.out.println(s);
      int n = Integer.valueOf(s).intValue();
        int c=0,a,temp;  
       // int n=153;//It is the number to check armstrong  
        temp=n;  
        while(n>0)  
        {  
        a=n%10;  
        n=n/10;  
        c=c+(a*a*a);  
        }  
        if(temp==c)  
        System.out.println("armstrong number");   
        else  
            System.out.println("Not armstrong number");   
       }  
  }
}