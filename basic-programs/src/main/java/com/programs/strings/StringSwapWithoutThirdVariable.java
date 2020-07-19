package com.programs.strings;

import java.util.Scanner;

public class StringSwapWithoutThirdVariable {
	 public static void main(String[] args) 
	    {    
	        Scanner sc = new Scanner(System.in);
	         
	        System.out.println("Enter First String :");
	         
	        String s1 = sc.next();
	         
	        System.out.println("Enter Second String :");
	         
	        String s2 = sc.next();
	         
	        System.out.println("Before Swapping :");
	         
	        System.out.println("s1 : "+s1);
	         
	        System.out.println("s2 : "+s2);
	         
	        //Swapping starts
	         
	        s1 = s1 + s2;
	         
	        s2 = s1.substring(0, s1.length()-s2.length());
	         
	        s1 = s1.substring(s2.length());
	         
	        //Swapping ends
	         
	        System.out.println("After Swapping :");
	         
	        System.out.println("s1 : "+s1);
	         
	        System.out.println("s2 : "+s2);
	        sc.close();
	    }    
	}
/*
 * How It Works?

Let s1 = “JAVA” and s2 = “J2EE”

//Swapping starts

s1 = s1 + s2

–>   s1 = “JAVA” + “J2EE”

–>   s1 = “JAVAJ2EE”

s2 = s1.substring(0, s1.length()-s2.length())

–>   s2 = s1.substring(0, 8-4)

–>   s2 = s1.substring(0, 4)        //This copies first 4 chars of s1 to s2

–>   s2 = “JAVA”

s1 = s1.substring(s2.length())

–>   s1 = s1.substring(4)           //This copies chars starting from index 4 to end of s1 to s1 itself

–>   s1 = “J2EE”

//Swapping ends

After swapping, s1 = “J2EE” and s2 = “JAVA”
 * */
 

