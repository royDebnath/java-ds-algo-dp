package com.project.parkinglot.admin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import com.project.parkinglot.inventory.Floor;
import com.project.parkinglot.inventory.ParkingLot;
import com.project.parkinglot.inventory.Slot;
import com.project.parkinglot.vehicle.VehicleTypes;
import com.project.parkinglot.ticket.Ticket;

public class Admin {

    private final ParkingLot parkingLot = new ParkingLot("My parking space");
    private final ParkingTicketPrinter parkingTicketPrinter = new ParkingTicketPrinter();

    private final List<Ticket> liveTickets = new ArrayList<>();

    public List<Slot> getAvailableSlots() {

        final List<Slot> result = new ArrayList<>();

        for (Floor floor : getFloors()) {
            for (Slot slot : floor.getSlots()) {
                if (!slot.isOccupied())
                    result.add(slot);
            }
        }
        return result;
    }

    private List<Floor> getFloors() {
        return parkingLot.getFloors();
    }

    private Slot pickRandomSlot() {
        final List<Slot> availableSlots = getAvailableSlots();
        final int randomNum = ThreadLocalRandom.current().nextInt(1, availableSlots.size());
        return availableSlots.get(randomNum);
    }

    private void orderFloors() {
        List<Floor> floors = parkingLot.getFloors();
        Collections.sort(floors);
    }

    public void issueParkingTicket(boolean randomSlotOk, String registerNumber, VehicleTypes type) {
        final Slot slot = randomSlotOk ? pickRandomSlot() : getNearestSlot();
        Ticket ticket = new Ticket(slot,registerNumber, type);
        liveTickets.add(ticket);
        parkingTicketPrinter.printTicket(ticket);
        slot.setOccupied(true);
    }

    public void collectAmount(Ticket ticket) {
        liveTickets.remove(ticket);
        double cost = ticket.getCost();
        System.out.println("Amount to be collected "+ cost);
    }

    private Slot getNearestSlot() {
        orderFloors();
        final List<Slot> availableSlots = getAvailableSlots();
        for (Slot slot : availableSlots) {
            if (!slot.isOccupied())
                return slot;
        }
        return null;
    }

    public List<String> getLiveTicketIds() {
        List<String> result = new ArrayList<>();
        for (Ticket liveTicket : liveTickets) result.add(liveTicket.getTicketNumber());
        return result;
    }

    public void addFloor(long floorNumber) {
        parkingLot.addFloor(new Floor(floorNumber));
    }
}