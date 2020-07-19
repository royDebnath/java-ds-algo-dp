package com.dell.poc.client;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import com.dell.poc.configuration.bean.ConfigurationBean;
import com.dell.poc.implementation.ProducerConsumerImpl;

/**
 * @author Debnath Roy
 * 
 *         This class can be executed to test the application
 *
 */
public class ProducerConsumerApplication {

	public static void main(String[] args) {
		int numberOfProducer = 5;
		int numberOfconsumer = 5;
		int producerRepititionFactor = 100;
		int integerListSize = 10;
		int integerFloorValue = 5;
		int integerCeilingValue = 20;
		ConfigurationBean config = ProducerConsumerImpl.populateConfig(numberOfProducer, numberOfconsumer, producerRepititionFactor,
				integerListSize, integerFloorValue, integerCeilingValue);
		Map<Integer, List<Integer>> unsorted = new LinkedHashMap<>();
		Map<Integer, List<Integer>> sorted = new TreeMap<>();

		ProducerConsumerImpl.producerConsumerUtility(config, unsorted, sorted);

		printList(unsorted, "===========UNSORTED============");
		System.out.println("===============================");
		System.out.println("===============================");
		printList(sorted, "===========SORTED==============");

	}

	/**
	 * Prints the Lists along with offset
	 * 
	 * @param mapToPrint
	 * @param title
	 */
	private static void printList(Map<Integer, List<Integer>> mapToPrint, String title) {
		System.out.println(title);
		System.out.println("===============================");
		System.out.println("===============================");
		mapToPrint.forEach((k, v) -> System.out.println("Offset : " + k + " List : " + v));
	}

}
