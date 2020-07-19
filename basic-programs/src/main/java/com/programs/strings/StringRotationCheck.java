package com.programs.strings;

public class StringRotationCheck {
	public static void main(String[] args) {
		String s1 = "JavaJ2eeStrutsHibernate";

		String s2 = "StrutsHibernateJavaJ2ee";
		isRotated(s1, s2);
		// Step 1

		if (s1.length() != s2.length()) {
			System.out.println("s2 is not rotated version of s1");
		} else {
			// Step 2

			String s3 = s1 + s1;

			// Step 3

			if (s3.contains(s2)) {
				System.out.println("s2 is a rotated version of s1");
			} else {
				System.out.println("s2 is not rotated version of s1");
			}
		}
	}
	
	 public static boolean isRotated(String input, String rotated) {

	        if (input == null || rotated == null) {
	            return false;

	        } else if (input.length() != rotated.length()) {
	            return false;

	        }

	        int index = rotated.indexOf(input.charAt(0));
	        if (index > -1) {

	            if (input.equalsIgnoreCase(rotated)) {
	                return true;
	            }

	            int finalPos = rotated.length() - index;
	            return rotated.charAt(0) == input.charAt(finalPos)
	                    && input.substring(finalPos).equals(
	                            rotated.substring(0, index));
	        }
	        return false;

	    }
}
