package com.project.parkinglot.vehicle;
public abstract class Vehicle {
    private String registerNumber;

    public Vehicle(String registerNumber) {
        this.registerNumber = registerNumber;
    }

    public String getRegisterNumber() {
        return registerNumber;
    }

    abstract public String getInfo();
}