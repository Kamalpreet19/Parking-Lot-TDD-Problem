package com.test;

import org.testng.annotations.Test;

import static junit.framework.Assert.*;

public class ParkingLotTest {
    @Test
    void shouldParkCarIfSpaceAvailable(){
        ParkingLot lot=new ParkingLot(2);
        assertTrue(lot.parkCars());

    }

    @Test
    void shouldNotParkCarWhenFull(){
        ParkingLot lot=new ParkingLot(1);
        lot.parkCars();
        assertFalse(lot.parkCars());

    }

    @Test
    void shouldReduceAvailableSlots(){
        ParkingLot lot=new ParkingLot(2);
        lot.parkCars();
        assertEquals(1,lot.getAvailableSlots());

    }

}
