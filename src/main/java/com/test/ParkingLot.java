package com.test;

public class ParkingLot {
    private int capacity;
    private int parkedCars;

    public ParkingLot(int capacity){
        this.capacity=capacity;
        this.parkedCars=0;
    }


    public boolean parkCars(){
        if(parkedCars<capacity){
            parkedCars++;
            return true;
        }
        return false;
    }

    public int getAvailableSlots(){
        return capacity-parkedCars;
    }
}
