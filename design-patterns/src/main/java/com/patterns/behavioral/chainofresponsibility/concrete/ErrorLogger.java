package com.patterns.behavioral.chainofresponsibility.concrete;

import com.patterns.behavioral.chainofresponsibility.abstracts.AbstractLogger;

public class ErrorLogger extends AbstractLogger {

   public ErrorLogger(int level){
      this.level = level;
   }

   @Override
   protected void write(String message) {		
      System.out.println("Error Console::Logger: " + message);
   }
}