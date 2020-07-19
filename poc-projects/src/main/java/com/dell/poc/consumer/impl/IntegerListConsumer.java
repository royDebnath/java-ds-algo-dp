package com.dell.poc.consumer.impl;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import com.dell.poc.consumer.interfaces.Consumer;

public class IntegerListConsumer implements Consumer<Map<Integer, List<Integer>>>, Runnable {

	Map<Integer, List<Integer>> unsorted;

	Map<Integer, List<Integer>> sorted;

	/**
	 * @param unsorted
	 * @param sorted
	 */
	public IntegerListConsumer(Map<Integer, List<Integer>> unsorted, Map<Integer, List<Integer>> sorted) {
		this.unsorted = new ConcurrentHashMap<>(unsorted);
		this.sorted = sorted;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		consume(unsorted);
	}

	/*
	 * Consumes collection unsorted Lists and sort them and then stores them
	 * back to sorted collection
	 */
	@Override
	public void consume(Map<Integer, List<Integer>> unsorted) {
		synchronized (sorted) {
			for (Integer unsortedKey : unsorted.keySet()) {
				if (!sorted.containsKey(unsortedKey)) {
					sorted.put(unsortedKey, unsorted.get(unsortedKey).stream().sorted().collect(Collectors.toList()));

				}
			}
		}
	}
}
