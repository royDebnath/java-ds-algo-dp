package com.patterns.behavioral.observer.abstracts;

import javax.security.auth.Subject;

public abstract class Observer {
   protected Subject subject;
   public abstract void update();
}