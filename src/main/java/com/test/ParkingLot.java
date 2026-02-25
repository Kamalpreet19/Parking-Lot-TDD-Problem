package com.test;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {

    private int capacity;
    private List<Car>parkedCars;

    private List<ParkingLotObserver> observers = new ArrayList<>();

    public ParkingLot(int capacity){
        this.capacity = capacity;
        this.parkedCars = new ArrayList<>();
    }


    public void registerObserver(ParkingLotObserver observer){
        observers.add(observer);
    }

    public boolean parkCars(Car car){
        if(parkedCars.size() < capacity){
            parkedCars.add(car);

            if(isFull()){
                notifyLotFull();
                }

            return true;
        }
        return false;
    }

    public boolean unparkCars(Car car){
        if(parkedCars.contains(car) ){
            boolean wasFull = isFull();
            parkedCars.remove(car);
            if (wasFull) {
                notifyLotAvailable();
            }
            return true;
        }
        return false;
    }

    public boolean findCar(String registrationNumber){
        for(Car car : parkedCars){
            if(car.getRegistrationNumber().equals(registrationNumber)){
                return true;
            }
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

        return parkedCars.size() == capacity;
    }

    public int getAvailableSlots()
    {
        return capacity - parkedCars.size();
    }
}