package com.patterns.behavioral.observer.concrete;

import com.patterns.behavioral.observer.abstracts.Observer;
import com.patterns.behavioral.observer.subject.Subject;

public class BinaryObserver extends Observer{
	
	Subject subject;

   public BinaryObserver(Subject subject){
      this.subject = subject;
      this.subject.attach(this);
   }

   @Override
   public void update() {
      System.out.println( "Binary String: " + Integer.toBinaryString( subject.getState() ) ); 
   }
}