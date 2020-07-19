package com.project.parkinglot.cost;
public class BusCostCalculator implements CostCalculator {
    @Override    
    public double getCost(long inTime) {
        return (System.currentTimeMillis() - inTime) * 0.4;
    }
}