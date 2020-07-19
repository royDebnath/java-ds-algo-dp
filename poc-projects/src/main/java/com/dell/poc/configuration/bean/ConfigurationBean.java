package com.dell.poc.configuration.bean;

public class ConfigurationBean {
	private int numberOfProducer;
	
	private int numberOfconsumer;
	
	private int producerRepititionFactor;
	
	private int integerListSize;
	
	private int integerFloorValue;
	
	private int integerCeilingValue;

	public int getProducerRepititionFactor() {
		return producerRepititionFactor;
	}

	public void setProducerRepititionFactor(int producerRepititionFactor) {
		this.producerRepititionFactor = producerRepititionFactor;
	}

	public int getIntegerListSize() {
		return integerListSize;
	}

	public void setIntegerListSize(int integerListSize) {
		this.integerListSize = integerListSize;
	}

	public int getIntegerFloorValue() {
		return integerFloorValue;
	}

	public void setIntegerFloorValue(int integerFloorValue) {
		this.integerFloorValue = integerFloorValue;
	}

	public int getIntegerCeilingValue() {
		return integerCeilingValue;
	}

	public void setIntegerCeilingValue(int integerCeilingValue) {
		this.integerCeilingValue = integerCeilingValue;
	}

	public int getNumberOfconsumer() {
		return numberOfconsumer;
	}

	public void setNumberOfconsumer(int numberOfconsumer) {
		this.numberOfconsumer = numberOfconsumer;
	}

	public int getNumberOfProducer() {
		return numberOfProducer;
	}

	public void setNumberOfProducer(int numberOfProducer) {
		this.numberOfProducer = numberOfProducer;
	}

}
