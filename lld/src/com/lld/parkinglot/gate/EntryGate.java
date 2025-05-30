package com.lld.parkinglot.gate;

import com.lld.parkinglot.spot.ParkingSpot;
import com.lld.parkinglot.strategy.ParkingSpotManager;
import com.lld.parkinglot.strategy.ParkingStrategy;
import com.lld.parkinglot.ticket.ParkingTicket;
import com.lld.parkinglot.vehicle.Vehicle;

public class EntryGate {
    private String gateId;
    private ParkingSpotManager parkingSpotManager;
    private ParkingStrategy parkingStrategy;

    public EntryGate(String gateId, ParkingSpotManager parkingSpotManager, ParkingStrategy parkingStrategy) {
        this.gateId = gateId;
        this.parkingSpotManager = parkingSpotManager;
        this.parkingStrategy = parkingStrategy;
    }

    public ParkingTicket parkVehicle(Vehicle vehicle){
        ParkingSpot parkingSpot = parkingStrategy.findParkingSpot(parkingSpotManager,vehicle);
        if(parkingSpot == null){
            System.out.println("No spot available for "+ vehicle.getVehicleNumber());
            return null;
        }

        parkingSpot.parkVehicle(vehicle);
        String ticketId = "TICKET-" + System.currentTimeMillis();
        ParkingTicket ticket = new ParkingTicket(ticketId, vehicle, parkingSpot);
        System.out.println("Vehicle parked with ticket: " + ticketId);
        return ticket;
    }
}
