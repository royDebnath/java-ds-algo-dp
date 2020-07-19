package com.dell.poc.consumer.interfaces;

import java.util.List;
import java.util.Map;

public interface Consumer<T> {
	void consume(Map<Integer, List<Integer>> unsorted);

}
