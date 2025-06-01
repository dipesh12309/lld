package com.lld.carrentalsystem.main;

import com.lld.carrentalsystem.product.Vehicle;
import com.lld.carrentalsystem.product.VehicleType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Store {

    int storeId;
    VehicleInventoryManagement inventoryManagement;
    Location storeLocation;
    List<Reservation> reservations = new ArrayList<>();

    public List<Vehicle> getVehicles(VehicleType vehicleType) {

        return inventoryManagement.getVehicles();
    }


    //addVehicles, update vehicles, use inventory management to update those.


    public void setVehicles(List<Vehicle> vehicles) {
        inventoryManagement = new VehicleInventoryManagement(vehicles);
    }

    public Reservation createReservation(Vehicle vehicle, User user){
        Reservation reservation = new Reservation();
        reservation.createReserve(user,vehicle);
        reservations.add(reservation);
        return reservation;
    }

    public boolean completeReservation(int reservationID) {

        Reservation reservation = null;
        for (Reservation reservation1 : reservations) {
            if(reservation1.reservationId == reservationID){
                reservation = reservation1;
            }
        }

        if(reservation == null) System.out.println("reservation does not exists");
        reservation.completeReservation(true);
        return true;
    }

    //update reservation

}
