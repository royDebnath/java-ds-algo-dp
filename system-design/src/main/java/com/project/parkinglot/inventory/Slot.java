package com.project.parkinglot.inventory;
public class Slot {
    private long slotNumber;
    private boolean isOccupied;
    private int capacity;

    public Slot(long slotNumber, int capacity) {
        this.slotNumber = slotNumber;
        this.capacity = capacity;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public long getSlotNumber() {
        return slotNumber;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getInfo() {
        return "Slot{" +
                "slotNumber=" + slotNumber +
                ", capacity=" + capacity +
                '}';
    }
}