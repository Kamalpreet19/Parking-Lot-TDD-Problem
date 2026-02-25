package com.test;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {

    private int capacity;
    private int parkedCars;

    private List<ParkingLotObserver> observers = new ArrayList<>();

    public ParkingLot(int capacity){
        this.capacity = capacity;
        this.parkedCars = 0;
    }


    public void registerObserver(ParkingLotObserver observer){
        observers.add(observer);
    }

    public boolean parkCars(){
        if(parkedCars < capacity){
            parkedCars++;

            if(isFull()){
                notifyLotFull();
                }

            return true;
        }
        return false;
    }

    public boolean unparkCars(){
        if(parkedCars > 0){
            boolean wasFull = isFull();
            parkedCars--;
            if (wasFull) {
                notifyLotAvailable();
            }
            return true;
        }
        return false;
    }


    private void notifyLotFull() {
        for (ParkingLotObserver observer : observers) {
            observer.notifyLotFull();
        }
    }

    private void notifyLotAvailable() {
        for (ParkingLotObserver observer : observers) {
            observer.notifyLotAvailable();
        }
    }

    public boolean isFull(){

        return parkedCars == capacity;
    }

    public int getAvailableSlots()
    {
        return capacity - parkedCars;
    }
}