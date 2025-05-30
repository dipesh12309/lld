package com.lld.parkinglot.strategy;

import com.lld.parkinglot.spot.ParkingSpot;
import com.lld.parkinglot.vehicle.Vehicle;

import java.util.List;

public class NearExitGateStrategy implements ParkingStrategy {

    @Override
    public ParkingSpot findParkingSpot(ParkingSpotManager manager, Vehicle vehicle) {
        List<ParkingSpot> spots = manager.getParkingSpots();
        for (int i = spots.size() - 1; i >= 0; i--) {
            if (spots.get(i).isEmpty()) {
                return spots.get(i);
            }
        }
        return null;
    }
}