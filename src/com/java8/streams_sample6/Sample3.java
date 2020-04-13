package com.java8.streams_sample6;

import java.util.Arrays;
import java.util.List;

/** 3.
 * Tell, don't ask
 * keep your focus on the whole instead of the part
 * code is transparent
 * avoid the smell of null
 * Optional
 */
public class Sample3 {

	public static void main(String[] args) {
		
		// bunch of timeslots, may be or may not available
		List<TimeSlot> timeSlots = Arrays.asList(new TimeSlot(),new TimeSlot(),new TimeSlot(),new TimeSlot(),new TimeSlot());
		
		// find the first available timeslot and schedule it
		TimeSlot fatslot=null;    // major issue of null check
		
		for(TimeSlot timeSlot:timeSlots) {
			if(timeSlot.isAvailable()) {
				timeSlot.schedule();
				fatslot=timeSlot;
				break;
			}
		}
		TimeSlot firstValue=
		timeSlots.stream()
				 .filter(TimeSlot::isAvailable)
				 .findFirst()
				 .orElse(new TimeSlot());
	}

}
