package com.theory.basics.multithreading.poc;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ProducerConsumerImpl {

	/**
	 * A wrapper around the original producer/consumer utility
	 * 
	 * @param config
	 * @param unsorted
	 * @param sorted
	 */
	public static void producerConsumerUtility(ConfigurationBean config, Map<Integer, List<Integer>> unsorted,
			Map<Integer, List<Integer>> sorted) {
		final ExecutorService producerExecutor = Executors.newFixedThreadPool(config.getNumberOfProducer());

		final ExecutorService consumerExecutor = Executors.newFixedThreadPool(config.getNumberOfconsumer());

		executeProduce(unsorted, producerExecutor, config);

		executeConsume(unsorted, sorted, consumerExecutor, config);

		closeDown(producerExecutor);
		closeDown(consumerExecutor);
	}
	

	/**
	 * Creates and Executes a predefined number of Producers
	 * 
	 * @param unsorted
	 * @param producerExecutor
	 * @param config
	 * @throws InterruptedException
	 * @throws ExecutionException
	 */
	private static void executeProduce(Map<Integer, List<Integer>> unsorted, ExecutorService producerExecutor,
			ConfigurationBean config) {
		AtomicInteger offset = new AtomicInteger(0);
		try {

			for (int i = 0; i < config.getNumberOfProducer(); i++) {
				List<List<Integer>> list = producerExecutor.submit(new IntegerListProducer(config)).get();
				for (List<Integer> unsortedElement : list) {
					unsorted.put(offset.get(), unsortedElement);
					offset.incrementAndGet();
				}
			}

		} catch (InterruptedException | ExecutionException e) {
			System.out.println("Exception caught in Producer Thread" + e.getMessage());
		}
	}

	/**
	 * Creates and Executes a predefined number of Consumers
	 * 
	 * @param unsorted
	 * @param sorted
	 * @param consumerExecutor
	 * @param config
	 */
	private static void executeConsume(Map<Integer, List<Integer>> unsorted, Map<Integer, List<Integer>> sorted,
			ExecutorService consumerExecutor, ConfigurationBean config) {
		for (int i = 0; i < config.getNumberOfconsumer(); i++) {
			consumerExecutor.submit(new IntegerListConsumer(unsorted, sorted));
		}
	}

	/**
	 * Closes down the executor
	 * 
	 * @param executor
	 */
	private static void closeDown(ExecutorService executor) {
		executor.shutdown();
		try {
			if (!executor.awaitTermination(800, TimeUnit.MILLISECONDS)) {
				executor.shutdownNow();
			}
		} catch (InterruptedException e) {
			executor.shutdownNow();
		}
	}
	
	/**
	 * Populates configuration
	 * 
	 * @param integerCeilingValue
	 * @param integerFloorValue
	 * @param integerListSize
	 * @param producerRepititionFactor
	 * @param numberOfconsumer
	 * @param numberOfProducer
	 * 
	 * @param config
	 * @return
	 */
	public static ConfigurationBean populateConfig(int numberOfProducer, int numberOfconsumer,
			int producerRepititionFactor, int integerListSize, int integerFloorValue, int integerCeilingValue) {
		ConfigurationBean config = new ConfigurationBean();
		config.setNumberOfconsumer(numberOfconsumer);
		config.setNumberOfProducer(numberOfProducer);
		config.setProducerRepititionFactor(producerRepititionFactor);
		config.setIntegerListSize(integerListSize);
		config.setIntegerFloorValue(integerFloorValue);
		config.setIntegerCeilingValue(integerCeilingValue);
		return config;
	}
}