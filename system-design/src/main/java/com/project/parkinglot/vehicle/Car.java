package com.project.parkinglot.vehicle;
public class Car extends Vehicle {

    private int neededSpace = 2;

    public Car(String registerNumber) {
        super(registerNumber);
    }

    public int getNeededSpace() {
        return neededSpace;
    }

    public String getInfo() {
        return "Car " + "\n" + " registernumber " + getRegisterNumber();
    }
}