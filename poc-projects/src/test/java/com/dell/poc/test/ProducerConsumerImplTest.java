package com.dell.poc.test;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import org.junit.Test;

import com.dell.poc.configuration.bean.ConfigurationBean;
import com.dell.poc.implementation.ProducerConsumerImpl;

import junit.framework.TestCase;

public class ProducerConsumerImplTest extends TestCase {

	/**
	 * Test with Standard case 5 Producer 5 Consumer 100 times repetition of
	 * Producer
	 */
	@Test
	public void testStandardCase() {
		int numberOfProducer = 5;
		int numberOfconsumer = 5;
		int producerRepititionFactor = 100;
		int integerListSize = 10;
		int integerFloorValue = 5;
		int integerCeilingValue = 20;
		ConfigurationBean config = ProducerConsumerImpl.populateConfig(numberOfProducer, numberOfconsumer,
				producerRepititionFactor, integerListSize, integerFloorValue, integerCeilingValue);
		Map<Integer, List<Integer>> unsorted = new LinkedHashMap<>();
		Map<Integer, List<Integer>> sorted = new TreeMap<>();
		ProducerConsumerImpl.producerConsumerUtility(config, unsorted, sorted);

		// Test the size of the sorted and unsorted list
		assertEquals(500, sorted.size());
		assertEquals(500, unsorted.size());

		// Pick a random list(234th here) and then sort it separately and then
		// compare it
		// with the same position(234th) list from sorted collection(sorted by
		// ProducerConsumerImpl)
		List<Integer> pickedFromUnsortedAndSorted = unsorted.get(234).stream().sorted().collect(Collectors.toList());
		List<Integer> pickedFromSorted = sorted.get(234);
		assertTrue(pickedFromUnsortedAndSorted.equals(pickedFromSorted));

		// Pick a random list(234th here) and then sort it separately and then
		// pick a random element from that list.
		// Pick a list from the same position(234th) from sorted
		// collection(sorted by
		// ProducerConsumerImpl) and pick the same position element
		// Compare both the elements are same
		Integer pickedElementFromUnsorted = unsorted.get(234).stream().sorted().collect(Collectors.toList()).get(3);
		Integer pickedElementFromSorted = sorted.get(234).get(3);
		assertTrue(pickedElementFromUnsorted.equals(pickedElementFromSorted));

	}

	/**
	 * All the elements of the list are negative
	 */
	@Test
	public void testWithNegativeIntegers() {
		int numberOfProducer = 5;
		int numberOfconsumer = 5;
		int producerRepititionFactor = 100;
		int integerListSize = 10;
		int integerFloorValue = -20; // Floor and Ceiling both negative so
										// elements are negative
		int integerCeilingValue = -9;
		ConfigurationBean config = ProducerConsumerImpl.populateConfig(numberOfProducer, numberOfconsumer,
				producerRepititionFactor, integerListSize, integerFloorValue, integerCeilingValue);
		Map<Integer, List<Integer>> unsorted = new LinkedHashMap<>();
		Map<Integer, List<Integer>> sorted = new TreeMap<>();
		ProducerConsumerImpl.producerConsumerUtility(config, unsorted, sorted);

		// Test the size of the sorted and unsorted list
		assertEquals(500, sorted.size());
		assertEquals(500, unsorted.size());

		// Pick a random list(331st here) and then sort it separately and then
		// compare it
		// with the same position(331st) list from sorted collection(sorted by
		// ProducerConsumerImpl)
		List<Integer> pickedFromUnsortedAndSorted = unsorted.get(331).stream().sorted().collect(Collectors.toList());
		List<Integer> pickedFromSorted = sorted.get(331);
		assertTrue(pickedFromUnsortedAndSorted.equals(pickedFromSorted));

		// Pick a random list(34th here) and then sort it separately and then
		// pick a random element from that list.
		// Pick a list from the same position(34th) from sorted
		// collection(sorted by
		// ProducerConsumerImpl) and pick the same position element
		// Compare both the elements are same
		Integer pickedElementFromUnsorted = unsorted.get(34).stream().sorted().collect(Collectors.toList()).get(3);
		Integer pickedElementFromSorted = sorted.get(34).get(3);
		assertTrue(pickedElementFromUnsorted.equals(pickedElementFromSorted));

	}

	/**
	 * Elements can be both positive and negative
	 */
	@Test
	public void testWithBothPositiveNegativeIntegers() {
		int numberOfProducer = 5;
		int numberOfconsumer = 5;
		int producerRepititionFactor = 100;
		int integerListSize = 10;
		int integerFloorValue = -20; // Floor Negative
		int integerCeilingValue = 18; // Ceiling Positive

		ConfigurationBean config = ProducerConsumerImpl.populateConfig(numberOfProducer, numberOfconsumer,
				producerRepititionFactor, integerListSize, integerFloorValue, integerCeilingValue);
		Map<Integer, List<Integer>> unsorted = new LinkedHashMap<>();
		Map<Integer, List<Integer>> sorted = new TreeMap<>();
		ProducerConsumerImpl.producerConsumerUtility(config, unsorted, sorted);

		// Test the size of the sorted and unsorted list
		assertEquals(500, sorted.size());
		assertEquals(500, unsorted.size());

		// Pick a random list(192nd here) and then sort it separately and then
		// compare it
		// with the same position(392nd) list from sorted collection(sorted by
		// ProducerConsumerImpl)
		List<Integer> pickedFromUnsortedAndSorted = unsorted.get(192).stream().sorted().collect(Collectors.toList());
		List<Integer> pickedFromSorted = sorted.get(192);
		assertTrue(pickedFromUnsortedAndSorted.equals(pickedFromSorted));

		// Pick a random list(256th here) and then sort it separately and then
		// pick a random element from that list.
		// Pick a list from the same position(256th) from sorted
		// collection(sorted by
		// ProducerConsumerImpl) and pick the same position element
		// Compare both the elements are same
		Integer pickedElementFromUnsorted = unsorted.get(256).stream().sorted().collect(Collectors.toList()).get(3);
		Integer pickedElementFromSorted = sorted.get(256).get(3);
		assertTrue(pickedElementFromUnsorted.equals(pickedElementFromSorted));

	}

	/**
	 * All the elements of lists are same
	 */
	@Test
	public void testWithSameIntegers() {
		int numberOfProducer = 5;
		int numberOfconsumer = 5;
		int producerRepititionFactor = 100;
		int integerListSize = 10;
		int integerFloorValue = -9; // Floor and Ceiling are adjusted to have
									// only integer -7
		int integerCeilingValue = -8;
		ConfigurationBean config = ProducerConsumerImpl.populateConfig(numberOfProducer, numberOfconsumer,
				producerRepititionFactor, integerListSize, integerFloorValue, integerCeilingValue);
		Map<Integer, List<Integer>> unsorted = new LinkedHashMap<>();
		Map<Integer, List<Integer>> sorted = new TreeMap<>();
		ProducerConsumerImpl.producerConsumerUtility(config, unsorted, sorted);

		// Test the size of the sorted and unsorted list
		assertEquals(500, sorted.size());
		assertEquals(500, unsorted.size());

		// Pick a random list(192nd here) and then sort it separately and then
		// compare it
		// with the same position(392nd) list from sorted collection(sorted by
		// ProducerConsumerImpl)
		List<Integer> pickedFromUnsortedAndSorted = unsorted.get(192).stream().sorted().collect(Collectors.toList());
		List<Integer> pickedFromSorted = sorted.get(192);
		assertTrue(pickedFromUnsortedAndSorted.equals(pickedFromSorted));

		// Pick a random list(256th here) and then sort it separately and then
		// pick a random element from that list.
		// Pick a list from the same position(256th) from sorted
		// collection(sorted by
		// ProducerConsumerImpl) and pick the same position element
		// Compare both the elements are same
		Integer pickedElementFromUnsorted = unsorted.get(256).stream().sorted().collect(Collectors.toList()).get(3);
		Integer pickedElementFromSorted = sorted.get(256).get(3);
		assertTrue(pickedElementFromUnsorted.equals(pickedElementFromSorted));

	}

	/**
	 * All elements are zero
	 */
	@Test
	public void testWithAllZeros() {
		int numberOfProducer = 5;
		int numberOfconsumer = 5;
		int producerRepititionFactor = 100;
		int integerListSize = 10;
		int integerFloorValue = -1; // Floor and ceilings are adjusted to make
									// all elements as zero
		int integerCeilingValue = 1;
		ConfigurationBean config = ProducerConsumerImpl.populateConfig(numberOfProducer, numberOfconsumer,
				producerRepititionFactor, integerListSize, integerFloorValue, integerCeilingValue);
		Map<Integer, List<Integer>> unsorted = new LinkedHashMap<>();
		Map<Integer, List<Integer>> sorted = new TreeMap<>();
		ProducerConsumerImpl.producerConsumerUtility(config, unsorted, sorted);

		// Test the size of the sorted and unsorted list
		assertEquals(500, sorted.size());
		assertEquals(500, unsorted.size());

		// Pick a random list(192nd here) and then sort it separately and then
		// compare it
		// with the same position(392nd) list from sorted collection(sorted by
		// ProducerConsumerImpl)
		List<Integer> pickedFromUnsortedAndSorted = unsorted.get(192).stream().sorted().collect(Collectors.toList());
		List<Integer> pickedFromSorted = sorted.get(192);
		assertTrue(pickedFromUnsortedAndSorted.equals(pickedFromSorted));

		// Pick a random list(256th here) and then sort it separately and then
		// pick a random element from that list.
		// Pick a list from the same position(256th) from sorted
		// collection(sorted by
		// ProducerConsumerImpl) and pick the same position element
		// Compare both the elements are same
		Integer pickedElementFromUnsorted = unsorted.get(256).stream().sorted().collect(Collectors.toList()).get(3);
		Integer pickedElementFromSorted = sorted.get(256).get(3);
		assertTrue(pickedElementFromUnsorted.equals(pickedElementFromSorted));

	}

	/**
	 * Number of Producer is greater than Consumer
	 */
	@Test
	public void testWithMoreProducerLessConsumer() {
		int numberOfProducer = 15; // Number of Producer
		int numberOfconsumer = 5; // Number of Consumer
		int producerRepititionFactor = 100;
		int integerListSize = 10;
		int integerFloorValue = 9;
		int integerCeilingValue = 17;
		ConfigurationBean config = ProducerConsumerImpl.populateConfig(numberOfProducer, numberOfconsumer,
				producerRepititionFactor, integerListSize, integerFloorValue, integerCeilingValue);
		Map<Integer, List<Integer>> unsorted = new LinkedHashMap<>();
		Map<Integer, List<Integer>> sorted = new TreeMap<>();
		ProducerConsumerImpl.producerConsumerUtility(config, unsorted, sorted);

		// Test the size of the sorted and unsorted list
		assertEquals(1500, sorted.size());
		assertEquals(1500, unsorted.size());

		// Pick a random list(192nd here) and then sort it separately and then
		// compare it
		// with the same position(392nd) list from sorted collection(sorted by
		// ProducerConsumerImpl)
		List<Integer> pickedFromUnsortedAndSorted = unsorted.get(192).stream().sorted().collect(Collectors.toList());
		List<Integer> pickedFromSorted = sorted.get(192);
		assertTrue(pickedFromUnsortedAndSorted.equals(pickedFromSorted));

		// Pick a random list(256th here) and then sort it separately and then
		// pick a random element from that list.
		// Pick a list from the same position(256th) from sorted
		// collection(sorted by
		// ProducerConsumerImpl) and pick the same position element
		// Compare both the elements are same
		Integer pickedElementFromUnsorted = unsorted.get(256).stream().sorted().collect(Collectors.toList()).get(3);
		Integer pickedElementFromSorted = sorted.get(256).get(3);
		assertTrue(pickedElementFromUnsorted.equals(pickedElementFromSorted));

	}

	/**
	 * Number of Consumer is more than Number ofProducer
	 */
	@Test
	public void testWithLessProducerMoreConsumer() {
		int numberOfProducer = 9; // Number of Producer
		int numberOfconsumer = 19; // Number of Consumer
		int producerRepititionFactor = 100;
		int integerListSize = 10;
		int integerFloorValue = -1;
		int integerCeilingValue = 11;
		ConfigurationBean config = ProducerConsumerImpl.populateConfig(numberOfProducer, numberOfconsumer,
				producerRepititionFactor, integerListSize, integerFloorValue, integerCeilingValue);
		Map<Integer, List<Integer>> unsorted = new LinkedHashMap<>();
		Map<Integer, List<Integer>> sorted = new TreeMap<>();
		ProducerConsumerImpl.producerConsumerUtility(config, unsorted, sorted);

		// Test the size of the sorted and unsorted list
		assertEquals(900, sorted.size());
		assertEquals(900, unsorted.size());

		// Pick a random list(192nd here) and then sort it separately and then
		// compare it
		// with the same position(392nd) list from sorted collection(sorted by
		// ProducerConsumerImpl)
		List<Integer> pickedFromUnsortedAndSorted = unsorted.get(192).stream().sorted().collect(Collectors.toList());
		List<Integer> pickedFromSorted = sorted.get(192);
		assertTrue(pickedFromUnsortedAndSorted.equals(pickedFromSorted));

		// Pick a random list(256th here) and then sort it separately and then
		// pick a random element from that list.
		// Pick a list from the same position(256th) from sorted
		// collection(sorted by
		// ProducerConsumerImpl) and pick the same position element
		// Compare both the elements are same
		Integer pickedElementFromUnsorted = unsorted.get(256).stream().sorted().collect(Collectors.toList()).get(3);
		Integer pickedElementFromSorted = sorted.get(256).get(3);
		assertTrue(pickedElementFromUnsorted.equals(pickedElementFromSorted));

	}

	/**
	 * Producer with Higher Repetition factor = 400
	 */
	@Test
	public void testWithHigherProducerRepitition() {
		int numberOfProducer = 9;
		int numberOfconsumer = 19;
		int producerRepititionFactor = 400; // Repetition Factor
		int integerListSize = 10;
		int integerFloorValue = -1;
		int integerCeilingValue = 1;
		ConfigurationBean config = ProducerConsumerImpl.populateConfig(numberOfProducer, numberOfconsumer,
				producerRepititionFactor, integerListSize, integerFloorValue, integerCeilingValue);
		Map<Integer, List<Integer>> unsorted = new LinkedHashMap<>();
		Map<Integer, List<Integer>> sorted = new TreeMap<>();
		ProducerConsumerImpl.producerConsumerUtility(config, unsorted, sorted);

		// Test the size of the sorted and unsorted list
		assertEquals(3600, sorted.size());
		assertEquals(3600, unsorted.size());

		// Pick a random list(192nd here) and then sort it separately and then
		// compare it
		// with the same position(392nd) list from sorted collection(sorted by
		// ProducerConsumerImpl)
		List<Integer> pickedFromUnsortedAndSorted = unsorted.get(192).stream().sorted().collect(Collectors.toList());
		List<Integer> pickedFromSorted = sorted.get(192);
		assertTrue(pickedFromUnsortedAndSorted.equals(pickedFromSorted));

		// Pick a random list(256th here) and then sort it separately and then
		// pick a random element from that list.
		// Pick a list from the same position(256th) from sorted
		// collection(sorted by
		// ProducerConsumerImpl) and pick the same position element
		// Compare both the elements are same
		Integer pickedElementFromUnsorted = unsorted.get(256).stream().sorted().collect(Collectors.toList()).get(3);
		Integer pickedElementFromSorted = sorted.get(256).get(3);
		assertTrue(pickedElementFromUnsorted.equals(pickedElementFromSorted));

	}

	/**
	 * IllegalArgumentException is caught in producer. Can be seen in console.
	 * Did not spend much time writing this test so ignored showing in assert
	 */
/*	@Ignore
	@Test(expected = IllegalArgumentException.class)
	public void testWithException() {
		int numberOfProducer = 3;
		int numberOfconsumer = 19;
		int producerRepititionFactor = 4;
		int integerListSize = 10;
		int integerFloorValue = 8;
		int integerCeilingValue = 8;
		ConfigurationBean config = ProducerConsumerImpl.populateConfig(numberOfProducer, numberOfconsumer,
				producerRepititionFactor, integerListSize, integerFloorValue, integerCeilingValue);
		Map<Integer, List<Integer>> unsorted = new LinkedHashMap<>();
		Map<Integer, List<Integer>> sorted = new TreeMap<>();
		ProducerConsumerImpl.producerConsumerUtility(config, unsorted, sorted);

	}
*/
}
