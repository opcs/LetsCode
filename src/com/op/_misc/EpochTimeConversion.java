package com.op._misc;

import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.TimeZone;

public class EpochTimeConversion {

	public static void main(String[] args) {

		String dated_date = "1869-12-25";
		
		TimeZone.setDefault(TimeZone.getTimeZone("US/Eastern"));
		String field_format="uuuu-MM-dd";
		
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(field_format);
		LocalDate file_date = LocalDate.parse(dated_date,dateTimeFormatter);
		System.out.println("java_file_date: " + file_date);
		System.out.println("def zone id: " +ZoneId.systemDefault().getId() );
		
		 LocalDateTime atStartOfDay = file_date.atStartOfDay();
		 ZonedDateTime atZone = atStartOfDay.atZone(ZoneId.systemDefault());
		 Instant instant = atZone.toInstant();
		long epochMilli= instant.toEpochMilli();
		System.out.println("epochMillis: " + epochMilli);
		Date date = new java.sql.Date(epochMilli);
		System.out.println("sql_date: " + date);
		
	}

}
