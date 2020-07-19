package com.parctice;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class EvenOddFromList {
	
public static void main(String[] args) throws InterruptedException {
	
	IntStream intStream = IntStream.of(1,26,44,13,12,10,94,19,21,44,63);
	List<Integer> numbers = intStream.boxed().collect(Collectors.toList());
	
	Runnable evenPrinter = ()->{
		for(int i : numbers){
			if(i%2==0){
				System.out.println("Even : " +i);
			}
		}
	};
	
	Runnable oddPrinter = ()->{
		for(int i : numbers){
			if(i%2!=0){
				System.out.println("Odd : " +i);
			}
		}
	};
	
	Thread t1 = new Thread(evenPrinter);
	Thread t2 = new Thread(oddPrinter);
	
	t1.start();
	t1.join();
	t2.start();
}
}


