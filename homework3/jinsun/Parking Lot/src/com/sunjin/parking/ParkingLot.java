package com.sunjin.parking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jsun on 12/7/15.
 */
public class ParkingLot {
    private int limit;
    private List<Ticket> sentTickets;
    private int parkingLotIndex;

    public ParkingLot(int limit, int parkingLotIndex) {
        this.limit = limit;
        this.parkingLotIndex = parkingLotIndex;
        this.sentTickets = new ArrayList<>();
    }

    public ParkingLot(int limit) {
        this.limit = limit;
        sentTickets = new ArrayList<>();
    }

    public Ticket carIn(String carNumber) {
        if (sentTickets.size()<limit){
            Ticket ticket = new Ticket(carNumber, parkingLotIndex);
            sentTickets.add(ticket);
            return ticket;
        }
        return null;
    }

    public boolean carOut(Ticket ticket) {
        if (sentTickets.contains(ticket)){
            sentTickets.remove(ticket);
            return true;
        }
        return false;
    }

    public boolean isFull(){
        return limit == sentTickets.size();
    }

    public int getParkingSpaceNum() {
        return limit- sentTickets.size();
    }

    public float getParkingSpacePCT(){
        return (limit- sentTickets.size())/(float)limit;
    }
}
