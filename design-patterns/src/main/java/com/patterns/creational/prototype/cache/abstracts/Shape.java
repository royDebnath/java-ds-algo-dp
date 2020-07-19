package com.patterns.creational.prototype.cache.abstracts;

public abstract class Shape implements Cloneable {

	private String id;
	protected String type;

	public abstract void draw();

	public String getType() {
		return type;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public Object clone() { // This clone implementation can be overridden by subclasses as needed
		Object clone = null;

		try {
			clone = super.clone();

		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}

		return clone;
	}
}