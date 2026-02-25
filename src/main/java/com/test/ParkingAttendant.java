package com.test;

import java.util.List;

public class ParkingAttendant {
    private List<ParkingLot> parkingLots;

    public ParkingAttendant(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public boolean parkCar(Car car) {

        for (ParkingLot lot : parkingLots) {
            if (!lot.isFull()) {
                return lot.parkCars(car);
            }
        }

        return false;
    }
}
