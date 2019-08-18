package com.op.iterator.failfast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * If multiple threads access a map concurrently, and at least one of the
 * threads modifies the map structurally, it <em>must</em> be synchronized
 * externally. (A structural modification is any operation that adds or deletes
 * one or more mappings; merely changing the value associated with an existing
 * key is not a structural modification.) This is typically accomplished by
 * synchronizing on some object that naturally encapsulates the map.
 *
 * <p>
 * The iterators returned by the {@code iterator} method of the collections
 * returned by all of this class's "collection view methods" are
 * <em>fail-fast</em>: if the map is structurally modified at any time after the
 * iterator is created, in any way except through the iterator's own
 * {@code remove} method, the iterator will throw a
 * {@link ConcurrentModificationException}. Thus, in the face of concurrent
 * modification, the iterator fails quickly and cleanly, rather than risking
 * arbitrary ->fail-fast
 *
 */

public class IteratorConcurrentModification {

	public static void main(String[] args) {
List<String> myList = new ArrayList<String>();
		
		myList.add("1");
		myList.add("2");
		myList.add("3");
		
		Iterator<String> it = myList.iterator();
		while(it.hasNext()){
			String value = it.next();
			System.out.println("List Value:"+value);
			if(value.equals("3"))
				myList.remove(value);     // Concurrent Exception
		}
		
		Map<String,String> myMap = new HashMap<String,String>();
		myMap.put("1", "1");
		myMap.put("2", "2");
		myMap.put("3", "3");

		Iterator<String> it1 = myMap.keySet().iterator();
		while(it1.hasNext()){
			String key = it1.next();
			System.out.println("Map Value:"+myMap.get(key));
			if(key.equals("2")){
				myMap.put("1","4");			// update the existing value
				//myMap.put("4", "4");    // Concurrent Exception, cause new entries
			}
		}

	}

}
