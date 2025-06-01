package com.lld.carrentalsystem.main;


import com.lld.carrentalsystem.product.Vehicle;

import java.util.Date;

public class Reservation {

    int reservationId;
    User user;
    Vehicle vehicle;
    Date bookingDate;
    Date dateBookedFrom;
    Date dateBookedTo;
    Long fromTimeStamp;
    Long toTimeStamp;
    Location pickUpLocation;
    Location dropLocation;
    ReservationType reservationType;
    ReservationStatus reservationStatus;
    Location location;
    boolean isReserved;

    public int createReserve(User user, Vehicle vehicle){

        //generate new id
        reservationId = 12232;
        this.user=user;
        this.vehicle=vehicle;
        reservationType = ReservationType.DAILY;
        reservationStatus = ReservationStatus.SCHEDULED;
        this.isReserved = false;

        return reservationId;
    }

    // CRUD operations

    public void completeReservation(boolean isReserved){
        this.isReserved = isReserved;
    }

}
