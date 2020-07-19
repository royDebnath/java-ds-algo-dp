package com.theory.basics.multithreading;
class MyThread implements Runnable{

    private Boolean stop = false;

    public void run(){

        while(!stop){

            //some business logic
        }
    }
    public Boolean getStop() {
        return stop;
    }

    public void setStop(Boolean stop) {
        this.stop = stop;
    }       
}

public class ThreadStop {

    public static void main(String[] args){

        MyThread myThread = new MyThread();
        Thread th = new Thread(myThread);
        th.start();

        //Some logic goes there to decide whether to 
        //stop the thread or not. 

        //This will compell the thread to stop
        myThread.setStop(true);
    }
}
