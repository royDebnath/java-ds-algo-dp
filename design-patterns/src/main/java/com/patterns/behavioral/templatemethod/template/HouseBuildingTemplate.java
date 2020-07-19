package com.patterns.behavioral.templatemethod.template;

public abstract class HouseBuildingTemplate {

	// the template method and defines the order of execution for performing
	// several steps.
	// template method, final so subclasses can't override
	public final void buildHouse() {
		buildFoundation();
		buildPillars();
		buildWalls();
		buildWindows();
		System.out.println("House is built.");
	}

	// default implementation
	private void buildFoundation() {
		System.out.println("Building foundation with cement,iron rods and sand");
	}

	// methods to be implemented by subclasses
	public abstract void buildPillars();

	// methods to be implemented by subclasses
	public abstract void buildWalls();

	// default implementation
	private void buildWindows() {
		System.out.println("Building Glass Windows");
	}

}