package com.project.parkinglot.inventory;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {

    private String parkingLotName;
    private List<Floor> floors = new ArrayList<>();

    public ParkingLot(String parkingLotName) {
        this.parkingLotName = parkingLotName;
    }

    public String getParkingLotName() {
        return parkingLotName;
    }

    public List<Floor> getFloors() {
        return floors;
    }

    public void addFloor(Floor floor) {
        floors.add(floor);
    }
    public void deleteFloor(Floor floor) {
        floors.remove(floor);
    }
}