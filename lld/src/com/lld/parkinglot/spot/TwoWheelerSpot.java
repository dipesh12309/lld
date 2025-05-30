package com.lld.parkinglot.spot;

import com.lld.parkinglot.vehicle.VehicleTypeEnum;

public class TwoWheelerSpot extends ParkingSpot {
    public TwoWheelerSpot(String id) {
        super(id, 10, VehicleTypeEnum.TWO_WHEELER);
    }
}