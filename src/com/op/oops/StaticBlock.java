package com.op.oops;

public class StaticBlock {
    {
        personCount = 10;
    }
    static {
        personCount = 20;
    }
    private static int personCount = 1000;
    {
        personCount = 30;
    }
    static {
        personCount = 40;
    }
    public static void main(String[] args) {
       System.out.println(StaticBlock.personCount); // 40
       StaticBlock p = new StaticBlock();
       System.out.println(StaticBlock.personCount);  // 30
       StaticBlock.personCount = 100; 
       p = new StaticBlock();
       System.out.println(StaticBlock.personCount);  // 30
    }
}
