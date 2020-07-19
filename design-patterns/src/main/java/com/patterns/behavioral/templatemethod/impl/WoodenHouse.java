package com.patterns.behavioral.templatemethod.impl;

import com.patterns.behavioral.templatemethod.template.HouseBuildingTemplate;

public class WoodenHouse extends HouseBuildingTemplate {

	@Override
	public void buildWalls() {
		System.out.println("Building Wooden Walls");
	}

	@Override
	public void buildPillars() {
		System.out.println("Building Pillars with Wood coating");
	}

}