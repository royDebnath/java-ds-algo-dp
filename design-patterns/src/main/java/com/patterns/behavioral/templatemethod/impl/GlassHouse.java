package com.patterns.behavioral.templatemethod.impl;

import com.patterns.behavioral.templatemethod.template.HouseBuildingTemplate;

public class GlassHouse extends HouseBuildingTemplate {

	@Override
	public void buildWalls() {
		System.out.println("Building Glass Walls");
	}

	@Override
	public void buildPillars() {
		System.out.println("Building Pillars with glass coating");
	}

}