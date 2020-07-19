package com.parctice;

public class Practice {
	
	public static void main(String[] args) {
		System.out.println(findReverse("Hello"));
	}

	static String findReverse(String string){
		if(string.length()==1)
			return string;
		return findReverse(string.substring(1))+string.charAt(0);
	}
	
	
}
