package com.theory.basics.general;

public class _009_SwapFunction {
	static class MyInteger {
		int data;
	}

	static void swapper(MyInteger a, MyInteger b) {
		int t = a.data;
		a.data = b.data;
		b.data = t;
	}

	public static void main(String[] args) {
		MyInteger a = new MyInteger();
		MyInteger b = new MyInteger();
		a.data = 10;
		b.data = 20;
		swapper(a, b);
		System.out.println("a.data = " + a.data + ",b.data = " + b.data);
	}
}