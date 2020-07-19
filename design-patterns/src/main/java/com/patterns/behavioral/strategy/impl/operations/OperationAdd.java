package com.patterns.behavioral.strategy.impl.operations;

import com.patterns.behavioral.strategy.interfaces.Strategy;

public class OperationAdd implements Strategy {
	@Override
	public int doOperation(int num1, int num2) {
		return num1 + num2;
	}
}