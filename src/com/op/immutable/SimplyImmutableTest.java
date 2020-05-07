package com.op.immutable;

import java.util.Date;

public class SimplyImmutableTest {
	
	private static void tryModification(Integer immutableField1, String immutableField2, Date mutableField)
    {
        immutableField1 = 10000;
        immutableField2 = "test changed";
        mutableField.setDate(10);
    }

	public static void main(String[] args) {
		SimplyImmutableDate im = SimplyImmutableDate.createNewInstance(100,"test", new Date());
        System.out.println(im);
        tryModification(im.getImmutableField1(),im.getImmutableField2(),im.getMutableField());
        System.out.println(im);
	}

}
