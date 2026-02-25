package com.test;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.*;

public class ParkingLotTest {
    @Test
    public void shouldParkCarIfSpaceAvailable(){
        ParkingLot lot=new ParkingLot(2);
        Car car = new Car("PB10AA1111");
        assertTrue(lot.parkCars(car));

    }

    @Test
    public void shouldNotParkCarWhenFull(){
        ParkingLot lot=new ParkingLot(1);
        lot.parkCars(new Car("PB10AA1111"));
        assertFalse(lot.parkCars(new Car("PB10AA2222")));

    }

    @Test
    public void shouldFindCar(){
        ParkingLot lot = new ParkingLot(2);
        Car car = new Car("PB10AA1111");
        lot.parkCars(car);

        Driver driver = new Driver("Kamal");
        assertTrue(driver.findMyCar(lot, "PB10AA1111"));
    }

    @Test
    public void shouldNotifyOwnerWhenLotFull(){
        ParkingLot lot = new ParkingLot(1);
        ParkingLotOwner owner = new ParkingLotOwner();
        lot.registerObserver(owner);

        lot.parkCars(new Car("PB10AA1111"));
        assertTrue(owner.isFullSignDisplayed());
    }

    @Test
    public void attendantShouldParkInNextAvailableLot(){
        ParkingLot lot1 = new ParkingLot(1);
        ParkingLot lot2 = new ParkingLot(1);

        lot1.parkCars(new Car("PB10AA1111"));

        List<ParkingLot> lots = new ArrayList<>();
        lots.add(lot1);
        lots.add(lot2);

        ParkingAttendant attendant = new ParkingAttendant(lots);

        assertTrue(attendant.parkCar(new Car("PB10AA2222")));
        assertEquals(0, lot2.getAvailableSlots());
    }
}