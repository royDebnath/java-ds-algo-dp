package com.programs.numerics;

public class CheckLeapYear {
	private boolean checkLeapYear(int year) {
		return ((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0)));
	}

}
