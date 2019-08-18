package com.op.immutable;

import java.sql.Date;

public class ImmutableBook {

	private final int pageCount=100;
	private final String author="opcs001";
	private final Date publishDate=new Date(1490161712000L);
	
	private ImmutableBook() {
		
	}
	
	public ImmutableBook(String calendar) {
		this.author=calendar;
	}

	public String findBookAuthor(){
		return author;
	}
	
	public  ImmutableBook getImmutableBook(){
		return new ImmutableBook();
	}
}
