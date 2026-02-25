package com.test;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.*;

public class ParkingLotTest {
    @Test
    public void shouldParkCarIfSpaceAvailable(){
        ParkingLot lot=new ParkingLot(2);
        assertTrue(lot.parkCars());

    }

    @Test
    public void shouldNotParkCarWhenFull(){
        ParkingLot lot=new ParkingLot(1);
        lot.parkCars();
        assertFalse(lot.parkCars());

    }

    @Test
    public void shouldReduceAvailableSlots(){
        ParkingLot lot=new ParkingLot(2);
        lot.parkCars();
        assertEquals(1,lot.getAvailableSlots());

    }

    @Test
    public void shouldUnparkCarIfCarIsPresent(){
        ParkingLot lot=new ParkingLot(2);
        lot.parkCars();
        assertTrue(lot.unparkCars());
    }


    @Test
    public void shouldIncreaseAvailableSlotsAfterUnparking(){
        ParkingLot lot=new ParkingLot(2);
        lot.parkCars();
        lot.unparkCars();
        assertEquals(2, lot.getAvailableSlots());
    }

    @Test
    public void shouldNotUnparkWhenNoCarPresent(){
        ParkingLot lot=new ParkingLot(2);
        assertFalse(lot.unparkCars());
    }

    @Test
    public void shouldNotifyOwnerWhenParkingLotBecomesFull(){
        ParkingLot lot = new ParkingLot(1);
        ParkingLotOwner owner = new ParkingLotOwner();

        lot.registerObserver(owner);
        lot.parkCars();

        assertTrue(owner.isFullSignDisplayed());
    }

    @Test
    public void shouldNotifySecurityWhenParkingLotBecomesFull(){
        ParkingLot lot = new ParkingLot(1);
        ParkingLotOwner owner = new ParkingLotOwner();
        AirportSecurity security = new AirportSecurity();

        lot.registerObserver(owner);
        lot.registerObserver(security);

        lot.parkCars();

        assertTrue(owner.isFullSignDisplayed());
        assertTrue(security.isStaffRedirected());
    }

    @Test
    public void shouldNotifyOwnerWhenSpaceBecomesAvailable() {
        ParkingLot lot = new ParkingLot(1);
        ParkingLotOwner owner = new ParkingLotOwner();

        lot.registerObserver(owner);

        lot.parkCars();
        lot.unparkCars();

        assertFalse(owner.isFullSignDisplayed());
    }

    @Test
    public void attendantShouldParkCarInAvailableLot() {

        ParkingLot lot1 = new ParkingLot(1);
        ParkingLot lot2 = new ParkingLot(1);

        lot1.parkCars();

        List<ParkingLot> lots = new ArrayList<>();
        lots.add(lot1);
        lots.add(lot2);

        ParkingAttendant attendant = new ParkingAttendant(lots);

        assertTrue(attendant.parkCar());
        assertEquals(0, lot2.getAvailableSlots());
    }
}
