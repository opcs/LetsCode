package com.op.letscheckfinal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DuplicateCounter {

	public static void main(String[] args) {
		int [] numbers ={1,1,2,2,3};
		
	
		
		
		List<Integer> intList = new ArrayList<Integer>();
		for (int index = 0; index < numbers.length; index++) {
			intList.add(numbers[index]);
		}
		Collections.sort(intList);
		int counter = 0;
		int i;
		Map<Integer, Boolean> counterMap = new HashMap<>();
		for (i = 0; i < intList.size(); i++) {
			Boolean isDuplicate = counterMap.put(intList.get(i), Boolean.FALSE);
			if (isDuplicate!=null && isDuplicate) {
				counterMap.put(intList.get(i), Boolean.TRUE);
			}
		}

		for (Boolean isDuplicate : counterMap.values()) {
			if (isDuplicate) {
				counter++;
			}
		}
	}

}
