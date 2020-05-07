package com.op.collection;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class SortByValue {

	public static void main(String[] args) {
		Map<String, Integer> nameAge = new HashMap<>();
		
		nameAge.put("op", 35);
		nameAge.put("Seerat", 2);
		nameAge.put("Kanchan", 25);
		nameAge.put("Lekhraj", 37);
		nameAge.put("Anita", 32);
		nameAge.put("Alekh", 4);
		nameAge.put("Tiru", 8);
		nameAge.put("Sahil", 4);
		
		System.out.println("-------Un Ordered value------");
		nameAge.values().stream().forEach(System.out::println);
		
		HashMap<String, Integer> sortedMap = sortByValue(nameAge);
		
		System.out.println("-------Sorted by value------");
		sortedMap.values().stream().forEach(System.out::println);

	}

	private static HashMap<String, Integer> sortByValue(Map<String, Integer> nameAge) {
		Set<Entry<String, Integer>> entrySet = nameAge.entrySet();
		List<Map.Entry> list = new LinkedList<Map.Entry>(entrySet);
		
		Comparator<Map.Entry> valueComparator = new Comparator<Map.Entry>(){

			@Override
			public int compare(Entry o1, Entry o2) {
				
				return ((int)o1.getValue()-(int)o2.getValue());
			}
			
		};
		
		Collections.sort(list, valueComparator);
		
		HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>(); 
        for (Map.Entry<String, Integer> aa : list) { 
            temp.put(aa.getKey(), aa.getValue()); 
        }
        
        return temp;
	}

}
