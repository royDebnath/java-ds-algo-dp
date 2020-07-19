package com.patterns.behavioral.templatemethod.client;

import com.patterns.behavioral.templatemethod.impl.GlassHouse;
import com.patterns.behavioral.templatemethod.impl.WoodenHouse;
import com.patterns.behavioral.templatemethod.template.HouseBuildingTemplate;

public class HousingClient {

	public static void main(String[] args) {
		
		HouseBuildingTemplate houseType; 
		
		houseType = new WoodenHouse();
		houseType.buildHouse(); //template method

		System.out.println("************");
		
		houseType = new GlassHouse();
		houseType.buildHouse(); //template method
	}

}