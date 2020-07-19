package com.project.parkinglot.ticket;

import java.util.concurrent.atomic.AtomicLong;

import com.project.parkinglot.cost.CostCalculator;
import com.project.parkinglot.inventory.Slot;
import com.project.parkinglot.vehicle.Vehicle;
import com.project.parkinglot.vehicle.VehicleTypes;

public class Ticket {

    private String ticketNumber;
    private Slot slot;
    private Vehicle vehicle;
    private CostCalculator costCalculator;
    private TicketHelper ticketHelper = new TicketHelper();
    private long inTime = System.currentTimeMillis();
    private static AtomicLong atomicLong = new AtomicLong();

    public Ticket(Slot slot, String registerNumber, VehicleTypes types) {
        this.ticketNumber = String.valueOf(atomicLong.get());
        this.slot = slot;
        this.vehicle = ticketHelper.createVehicle(registerNumber,types);
        this.costCalculator = ticketHelper.getCostCalculator(types);
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public String getPrintableString() {
        return slot.getInfo() + "\n" + vehicle.getInfo();
    }

    public double getCost() {
        return costCalculator.getCost(inTime);
    }
}