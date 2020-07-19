package com.theory.basics.multithreading.poc;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class IntegerListProducer implements Callable<List<List<Integer>>> {

	private ConfigurationBean config;

	public IntegerListProducer(int producerRepititionFactor, int integerListSize, int integerFloorValue,
			int integerCeilingValue) {
		super();
	}

	public IntegerListProducer(ConfigurationBean config) {
		this.config = config;
	}

	private static Random random = new Random();

	static AtomicInteger offset = new AtomicInteger(0);

	@Override
	public List<List<Integer>> call() throws Exception {
		return produce();

	}

	public List<List<Integer>> produce() {
		List<List<Integer>> randomList = new ArrayList<>();
		for (int i = 0; i < config.getProducerRepititionFactor(); i++) {
			randomList.add(random.ints(config.getIntegerFloorValue(), config.getIntegerCeilingValue()).limit(config.getIntegerListSize()).boxed()
					.collect(Collectors.toList()));

		}
		return randomList;
	}

}