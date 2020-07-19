package com.theory.basics.general;

public class LostStrings {
	public static void main(String args[]) {
		String s1 = "spring ";
		String s2 = s1 + "summer ";
		s1.concat("fall ");
		s2.concat(s1);
		s1 += "winter ";
		System.out.println(s1 + " " + s2);
	}

}
/*
 * There are two reference variables: s1 and s2. A total of eight String objects
 * were created as follows: 
 * 
 * "spring "
 * "summer " (lost) 
 * "spring summer " 
 * "fall" (lost)
 * "spring fall " (lost) 
 * "spring summer spring " (lost) 
 * "winter"(lost)
 * "spring winter " (at this point "spring " is lost)
 * 
 * Only two of the eight String objects are not lost in this process.
 */
