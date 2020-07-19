package com.project.parkinglot.vehicle;
public class Bus extends Vehicle {

    private int neededSpace = 3;

    public Bus(String registerNumber) {
        super(registerNumber);
    }

    public int getNeededSpace() {
        return neededSpace;
    }

    public String getInfo() {
        return "Bus" + "\n" + " registernumber " + getRegisterNumber();
    }
}