package com.lld.parkinglot;

import com.lld.parkinglot.gate.EntryGate;
import com.lld.parkinglot.gate.ExitGate;
import com.lld.parkinglot.spot.FourWheelerSpot;
import com.lld.parkinglot.spot.TwoWheelerSpot;
import com.lld.parkinglot.strategy.NearEntryGateStrategy;
import com.lld.parkinglot.strategy.ParkingSpotManager;
import com.lld.parkinglot.strategy.ParkingStrategy;
import com.lld.parkinglot.ticket.ParkingTicket;
import com.lld.parkinglot.vehicle.Vehicle;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private ParkingSpotManager parkingSpotManager;
    private EntryGate entryGate;
    private ExitGate exitGate;
    private Map<String, ParkingTicket> activeTickets;

    public ParkingLot() {
        this.parkingSpotManager = new ParkingSpotManager();
        this.activeTickets = new HashMap<>();

        for (int i = 1; i <= 5; i++) { // Adding 5 spots for each type
            parkingSpotManager.addParkingSpot(new TwoWheelerSpot("TW-" + i));
            parkingSpotManager.addParkingSpot(new FourWheelerSpot("FW-" + i));
        }

        ParkingStrategy strategy = new NearEntryGateStrategy();
        this.entryGate = new EntryGate("Gate-1", parkingSpotManager, strategy);
        this.exitGate = new ExitGate("Gate-1", activeTickets);
    }

    public ParkingTicket enterVehicle(Vehicle vehicle) {
        ParkingTicket ticket = entryGate.parkVehicle(vehicle);
        if (ticket != null) {
            activeTickets.put(ticket.getTicketId(), ticket);
        }
        return ticket;
    }

    public void exitVehicle(String ticketId) {
        exitGate.exitVehicle(ticketId);
    }
}