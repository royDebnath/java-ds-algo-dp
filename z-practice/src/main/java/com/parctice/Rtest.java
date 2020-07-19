package com.parctice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Rtest {

	public static void main(String[] args) {
		List<Integer> lInt = Arrays.asList(1,2,3,4,5,1);
		System.out.println(degreeOfArray(lInt));

	}

	public static int degreeOfArray(List<Integer> arr) {
		if(arr==null){
			return 0;
		}
		Map<Integer, Integer> track = new HashMap<>();
		int degree = 0;
		for (Integer key : arr) {
			if (!track.containsKey(key)) {
				track.put(key, 1);
			} else {
				track.put(key, track.get(key) + 1);
			}
			if (track.get(key) > degree) {
				degree = track.get(key);
			}
		}
		List<Integer> elementOfHighestDegree = new ArrayList<>();
		for (int dKey : track.keySet()) {
			if (track.get(dKey).equals(degree)) {
				elementOfHighestDegree.add(dKey);
			}
		}
		List<Integer> subArrayLengths = new ArrayList<>();
		for (int element : elementOfHighestDegree) {
			int minIndex = arr.indexOf(element);
			int maxIndex = minIndex;
			for (int i = minIndex; i <= arr.size() - 1; i++) {
				if (arr.get(i).equals(element)) {
					if (i > maxIndex) {
						maxIndex = i;
					}
				}
			}
			subArrayLengths.add(maxIndex - minIndex + 1);
		}
		int shortest = subArrayLengths.get(0);
		for (int i : subArrayLengths) {
			if (i < shortest) {
				shortest = i;
			}
		}
		return shortest;
	}
}
