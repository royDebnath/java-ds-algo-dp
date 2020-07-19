package com.theory.basics.multithreading.threadlocal;

public class MainApplication {
public MainApplication() {
	SharedMapWithUserContext firstUser = new SharedMapWithUserContext(1);
	SharedMapWithUserContext secondUser = new SharedMapWithUserContext(2);
	new Thread(firstUser).start();
	new Thread(secondUser).start();}
}
