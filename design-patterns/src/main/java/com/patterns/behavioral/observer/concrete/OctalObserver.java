package com.patterns.behavioral.observer.concrete;

import com.patterns.behavioral.observer.abstracts.Observer;
import com.patterns.behavioral.observer.subject.Subject;

public class OctalObserver extends Observer{

	Subject subject;
   public OctalObserver(Subject subject){
      this.subject = subject;
      this.subject.attach(this);
   }

   @Override
   public void update() {
     System.out.println( "Octal String: " + Integer.toOctalString( subject.getState() ) ); 
   }
}