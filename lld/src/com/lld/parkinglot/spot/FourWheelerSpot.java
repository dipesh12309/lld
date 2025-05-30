package com.lld.parkinglot.spot;

import com.lld.parkinglot.vehicle.VehicleTypeEnum;

// HAS-A relationship
public class FourWheelerSpot extends ParkingSpot {
    public FourWheelerSpot(String id) {
        super(id, 20, VehicleTypeEnum.FOUR_WHEELER);
    }
}