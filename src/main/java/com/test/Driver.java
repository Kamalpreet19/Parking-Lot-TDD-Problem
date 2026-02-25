package com.test;

public class Driver {


        private String name;

        public Driver(String name) {
            this.name = name;
        }

        public boolean findMyCar(ParkingLot lot, String registrationNumber){
            return lot.findCar(registrationNumber);
        }
    }

