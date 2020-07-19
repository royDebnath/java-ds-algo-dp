package com.programs.collection;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * 
 * @author Debnath Roy
 * @version 1.0 @
 *
 */
class MapValueComparator implements Comparator<Entry<String, Integer>> {

	@Override
	public int compare(Entry<String, Integer> e1, Entry<String, Integer> e2) {
		return e1.getValue().compareTo(e2.getValue());
	}

}

public class MapSortByValue {

	public static void main(String args[]) {

		Map<String, Integer> unsortedMap = new HashMap<String, Integer>();
		unsortedMap.put("Apple", 23);
		unsortedMap.put("Orange", 32);
		unsortedMap.put("Lemon", 43);
		unsortedMap.put("Melon", 31);
		unsortedMap.put("Banana", 456);

		System.out.println("####################Unsorted Map##############");
		for (String key : unsortedMap.keySet()) {
			System.out.println(key + " : " + unsortedMap.get(key));
		}

		// Just convert to a Treemap to sort by key
		Map<String, Integer> sortedByKeyMap = new TreeMap<String, Integer>(unsortedMap);

		System.out.println("###################Sorted By Key Map##############");
		for (String key : sortedByKeyMap.keySet()) {
			System.out.println(key + " : " + sortedByKeyMap.get(key));
		}

		// To sort by Value, we need to get the values in a list/set and then sort
		// the list
		Set<Entry<String, Integer>> entries = unsortedMap.entrySet();
		
	
		/* JAVA 7 WAY
	Collections.sort(entries, new MapValueComparator());// we need a
																// comparator to
																// sort
				for (Entry<String, Integer> k1 : entryList) {
		sortedByValueMap.put(k1.getKey(), k1.getValue());// the new
															// LinkedHashMap
															// is being
															// populated in
															// the order the
															// valueset is
															// sorted.
	}
*/
		
		//JAVA 8 WAY
		
		List<Entry<String, Integer>>  sortedValueList = entries.stream()
        .sorted((e1, e2) -> e1.getValue()
            .compareTo(e2.getValue()))
        .collect(Collectors.toList());

		Map<String, Integer> sortedByValueMap = new LinkedHashMap<String, Integer>();// LinkedHashMap
																						// required
																						// to
																						// retain
																						// the
																						// order
																						// the
																						// values
																						// are
																						// stored
		
		sortedValueList.forEach(element -> sortedByValueMap.put(element.getKey(), element.getValue()));
		

		System.out.println("####################Sorted By Value Map##############");
		for (String key : sortedByValueMap.keySet()) {
			System.out.println(key + " : " + sortedByValueMap.get(key));
		}

	}

}
