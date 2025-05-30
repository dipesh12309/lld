package com.lld.parkinglot.spot;

import com.lld.parkinglot.vehicle.Vehicle;
import com.lld.parkinglot.vehicle.VehicleTypeEnum;

public abstract class ParkingSpot {
    private String id;
    private Vehicle vehicle;
    private int price;
    private boolean isEmpty;
    private final VehicleTypeEnum allowedVehicleType;

    public ParkingSpot(String id, int price, VehicleTypeEnum allowedVehicleType) {
        this.id = id;
        this.price = price;
        this.allowedVehicleType = allowedVehicleType;
        this.isEmpty = true;
    }

    public boolean isCompatible(Vehicle vehicle) {
        return vehicle.getVehicleTypeEnum() == this.allowedVehicleType;
    }
    public void parkVehicle(Vehicle vehicle) {
        if (!isEmpty) {
            System.out.println("Spot " + id + " is already occupied!");
            return;
        }
        if (!isCompatible(vehicle)) {
            System.out.println("Spot " + id + " does not allow " + vehicle.getVehicleTypeEnum());
            return;
        }
        this.vehicle = vehicle;
        this.isEmpty = false;
        System.out.println("Vehicle " + vehicle.getVehicleNumber() + " parked in " + id);
    }

    public void removeVehicle() {
        if (isEmpty) {
            System.out.println("Spot " + id + " is already empty!");
            return;
        }
        System.out.println("Vehicle " + vehicle.getVehicleNumber() + " removed from " + id);
        this.vehicle = null;
        this.isEmpty = true;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public int getPrice() {
        return price;
    }

    public String getId() {
        return id;
    }

    public VehicleTypeEnum getAllowedVehicleType() {
        return allowedVehicleType;
    }
}
