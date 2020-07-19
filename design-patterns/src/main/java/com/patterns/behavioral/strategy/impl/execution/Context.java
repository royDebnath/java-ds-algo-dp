package com.patterns.behavioral.strategy.impl.execution;

import com.patterns.behavioral.strategy.interfaces.Strategy;

public class Context {
   private Strategy strategy;

   public Context(Strategy strategy){
      this.strategy = strategy;
   }

   public int executeStrategy(int num1, int num2){
      return strategy.doOperation(num1, num2);
   }
}