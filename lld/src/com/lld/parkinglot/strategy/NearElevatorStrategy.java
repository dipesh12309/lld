package com.lld.parkinglot.strategy;

import com.lld.parkinglot.spot.ParkingSpot;
import com.lld.parkinglot.vehicle.Vehicle;

import java.util.List;

public class NearElevatorStrategy implements ParkingStrategy {

    @Override
    public ParkingSpot findParkingSpot(ParkingSpotManager manager, Vehicle vehicle) {
        List<ParkingSpot> spots = manager.getParkingSpots();
        for (ParkingSpot spot : spots) {
            if (spot.isEmpty()) {
                return spot;
            }
        }
        return null;
    }
}