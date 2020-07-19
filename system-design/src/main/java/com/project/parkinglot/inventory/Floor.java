package com.project.parkinglot.inventory;

import java.util.ArrayList;
import java.util.List;

public class Floor implements Comparable<Floor>{

    private long floorNumber;
    private List<Slot> slots = new ArrayList<>();
    private long occupiedCount;

    public List<Slot> getSlots() {
        return slots;
    }

    public Floor(long floorNumber) {
        this.floorNumber = floorNumber;
    }

    public long getOccupiedCount() {
        return occupiedCount;
    }

    public long getFreeSlotCount() {
        return slots.size() - occupiedCount;
    }

    public boolean isAvailable() {
        return getFreeSlotCount() > 0;
    }

    public long getFloorNumber() {
        return floorNumber;
    }

    public void setSlots(List<Slot> slots) {
        this.slots = slots;
    }

    public void addSlot(Slot slot) {
        slots.add(slot);
    }

    public void removeSlot(Slot slot) {
        slots.remove(slot);
    }

    @Override    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Floor floor = (Floor) o;

        return floorNumber == floor.floorNumber;

    }

    @Override    public int hashCode() {
        return (int) (floorNumber ^ (floorNumber >>> 32));
    }

    @Override    public int compareTo(Floor otherFloor) {
        if (otherFloor.getFloorNumber() > getFloorNumber())
            return 1;
        else if (otherFloor.getFloorNumber() < getFloorNumber())
            return -1;
        return 0;
    }
}

