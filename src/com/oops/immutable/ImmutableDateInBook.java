package com.oops.immutable;

import java.time.LocalDate;

public class ImmutableDateInBook {

	private int pageCount;
	private String author;
	private LocalDate publishDate;    // an immutable date-time object that represents a date

	private ImmutableDateInBook(int pageCount, String author, LocalDate publishDate) {
		this.pageCount = pageCount;
		this.author = author;
		this.publishDate = LocalDate.now();
	}

	// don't provide any setter/mutator method
	
	/*
	 * public void setPageCount(int pageCount) { this.pageCount = pageCount; }
	 * 
	 * public void setAuthor(String author) { this.author = author; }
	 * 
	 * public void setPublishDate(LocalDate publishDate) { this.publishDate =
	 * publishDate; }
	 */

	public int getPageCount() {
		return pageCount;
	}

	public String getAuthor() {
		return author;
	}

	public LocalDate getPublishDate() {
		return LocalDate.of(publishDate.getYear(), publishDate.getMonthValue(), publishDate.getDayOfMonth());
	}

	public static ImmutableDateInBook getImmutableBook(int pageCount, String author, LocalDate publishDate) {
		return new ImmutableDateInBook(pageCount, author, publishDate);
	}
	
	public static void main(String args[]) {
		
		LocalDate publishDate = LocalDate.now();
		ImmutableDateInBook book=ImmutableDateInBook.getImmutableBook(100, "opcs", publishDate);
		
		System.out.println("pre-change: " +book.getPageCount() +" "+book.getAuthor() +" "+ book.getPublishDate().toString());
		
		publishDate=publishDate.plusDays(2);    // it updates with new object reference similar to String obj
		System.out.println("updated publishDate: " + publishDate.toString());
		
		System.out.println("post-change: " +book.getPageCount() +" "+book.getAuthor() +" "+ book.getPublishDate().toString());
	}
}
