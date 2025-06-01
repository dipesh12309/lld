package com.lld.parkinglot.strategy;

import com.lld.parkinglot.spot.ParkingSpot;
import com.lld.parkinglot.vehicle.Vehicle;

public interface ParkingStrategy {
    ParkingSpot findParkingSpot(ParkingSpotManager parkingSpotManager, Vehicle vehicle);
}
