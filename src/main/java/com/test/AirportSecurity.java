package com.test;

public class AirportSecurity implements ParkingLotObserver {
        private boolean redirectedStaff = false;

        @Override
        public void notifyLotFull() {
            redirectedStaff = true;
            System.out.println("Security: Parking lot full. Redirecting security staff to other posts.");
        }

        public boolean isStaffRedirected() {
            return redirectedStaff;
        }
    }

