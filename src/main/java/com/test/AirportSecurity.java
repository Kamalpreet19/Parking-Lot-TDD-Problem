package com.test;

public class AirportSecurity implements ParkingLotObserver {
        private boolean redirectedStaff = false;

        @Override
        public void notifyLotFull() {
            redirectedStaff = true;
            System.out.println("Security: Parking lot full. Redirecting security staff to other posts.");
        }

    @Override
    public void notifyLotAvailable() {
        redirectedStaff = false;
        System.out.println("Security: Space available. Bringing staff back.");
    }

        public boolean isStaffRedirected() {

            return redirectedStaff;
        }
    }

