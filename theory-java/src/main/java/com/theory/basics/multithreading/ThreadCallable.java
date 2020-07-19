package com.theory.basics.multithreading;

import java.util.concurrent.*;
import java.util.*;

class ThreadCallable implements Callable {

   public String call() throws Exception {
      Thread.sleep(2000);

      // return name of thread.
      return (Thread.currentThread().getName());
   }
}

class MyCallableTest {
   public static void main (String args[]) {

      // thread pool size 5
      ExecutorService executor = Executors.newFixedThreadPool(5);

      // collection to store results
      List<Future<String>> list = new ArrayList<Future<String>>();

      // spawn 10 jobs
      for(int i=0; i< 10; i++){
         Future<String> future = executor.submit(new ThreadCallable()); 
         list.add(future);
      }

      // print results
      for(Future<String> future : list){ 
         try {
            System.out.println(future.get());
         } catch (Exception e) {
         }
      }

      executor.shutdown();
   }
}