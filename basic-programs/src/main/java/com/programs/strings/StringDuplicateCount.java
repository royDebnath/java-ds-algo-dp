package com.programs.strings;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class StringDuplicateCount {
	public static void main(String[] args) {
		String str = "java java android android java  example";
		Map<String, Integer> map = new HashMap<String, Integer>();
		StringTokenizer strTokenizer = new StringTokenizer(str);
		while (strTokenizer.hasMoreElements()) {
			String word = strTokenizer.nextToken();
			map.put(word, (map.get(word) == null ? 1 : map.get(word) + 1));
		}
		System.out.println(map);
	}
}
