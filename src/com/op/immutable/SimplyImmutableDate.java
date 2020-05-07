package com.op.immutable;

import java.util.Date;

/**
 * Always remember that your instance variables will be either mutable or
 * immutable. Identify them and return new objects with copied content for all
 * mutable objects. Immutable variables can be returned safely without extra
 * effort.
 */
public class SimplyImmutableDate {

	// Integer class is immutable as it does not provide any setter to change its
	// content
	private final Integer immutableField1;
	private final String immutableField2;

	// Date class is mutable as it provide setters to change various date/time parts
	private final Date mutableField;

	// Default private constructor will ensure no unplanned construction of class
	private SimplyImmutableDate(Integer fld1, String fld2, Date date) {
		this.immutableField1 = fld1;
		this.immutableField2 = fld2;
		this.mutableField = new Date(date.getTime());
	}

	// Factory method to store object creation logic in single place
	public static SimplyImmutableDate createNewInstance(Integer fld1, String fld2, Date date) {
		return new SimplyImmutableDate(fld1, fld2, date);
	}

	// Provide no setter methods
	// Integer class is immutable so we can return the instance variable as it is
	public Integer getImmutableField1() {
		return immutableField1;
	}

	// String class is also immutable so we can return the instance variable as it
	// is
	public String getImmutableField2() {
		return immutableField2;
	}

	/**
	 * Date class is mutable so don't use direct reference Instead a new Date
	 * object, with content copied to it, should be returned.
	 */
	public Date getMutableField() {
		return new Date(mutableField.getTime());
	}

	@Override
	public String toString() {
		return immutableField1 + " - " + immutableField2 + " - " + mutableField;
	}

}
