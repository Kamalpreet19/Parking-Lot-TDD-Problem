package com.test;

public class ParkingLotOwner implements ParkingLotObserver {

    private boolean fullSignDisplayed = false;

    @Override
    public void notifyLotFull() {
        fullSignDisplayed = true;
        System.out.println("Parking lot is full. Putting out FULL sign.");
    }

    public boolean isFullSignDisplayed() {
        return fullSignDisplayed;
    }
}
