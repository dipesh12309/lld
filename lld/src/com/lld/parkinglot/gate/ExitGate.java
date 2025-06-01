package com.lld.parkinglot.gate;

import com.lld.parkinglot.ticket.ParkingTicket;

import java.time.LocalDateTime;
import java.util.Map;

public class ExitGate {
    private String gateId;
    private Map<String, ParkingTicket> activeTickets;

    public ExitGate(String gateId, Map<String, ParkingTicket> activeTickets) {
        this.gateId = gateId;
        this.activeTickets = activeTickets;
    }

    public void exitVehicle(String ticketId) {
        if (!activeTickets.containsKey(ticketId)) {
            System.out.println("Invalid Ticket ID!");
            return;
        }

        ParkingTicket ticket = activeTickets.get(ticketId);
        int fare = ticket.calculateFare(LocalDateTime.now());

        ticket.getParkingSpot().removeVehicle();
        activeTickets.remove(ticketId);

        System.out.println("Vehicle exited. Total Fare: $" + fare);
    }
}
