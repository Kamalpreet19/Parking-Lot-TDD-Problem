package com.test;

import org.testng.annotations.Test;

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

}
