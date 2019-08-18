package com.op.immutable;

public class MyDiary extends ImmutableBook {
	private int pageNumber;
	private String calendar2016;

	/*
	 * public MyDiary(int pageNumber, String calendar){ //super(); // can't
	 * instantiate immutable object this.pageNumber=pageNumber;
	 * this.calendar2016=calendar; }
	 */
	
	public MyDiary(int pageNumber, String calendar){
		super(calendar);       // can't instantiate immutable object
		this.pageNumber=pageNumber;
		this.calendar2016=calendar;
	}
}
