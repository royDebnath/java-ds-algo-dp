package com.project.parkinglot.ticket;

import com.project.parkinglot.cost.BusCostCalculator;
import com.project.parkinglot.cost.CarCostCalculator;
import com.project.parkinglot.cost.CostCalculator;
import com.project.parkinglot.vehicle.Bus;
import com.project.parkinglot.vehicle.Car;
import com.project.parkinglot.vehicle.Vehicle;
import com.project.parkinglot.vehicle.VehicleTypes;

public class TicketHelper {

    public Vehicle createVehicle(String registerNumber, VehicleTypes type) {
        if (type == VehicleTypes.Car) {
            return new Car(registerNumber);
        } else if (type == VehicleTypes.Bus) {
            return new Bus(registerNumber);
        }
        return null;
    }

    public CostCalculator getCostCalculator(VehicleTypes types) {
        if (types == VehicleTypes.Car) {
            return new CarCostCalculator();
        } else if (types == VehicleTypes.Bus) {
            return new BusCostCalculator();
        }
        return null;
    }
}