package com.project.parkinglot.cost;
public class CarCostCalculator implements CostCalculator {
    @Override    
    public double getCost(long inTime) {
        return (System.currentTimeMillis() - inTime) * 0.6;
    }
}