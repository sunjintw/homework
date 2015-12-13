package com.sunjin.parking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jsun on 12/7/15.
 */
public class ParkingLot {
    private int limit;
    private List<Ticket> sentTickets;
    public ParkingLot(int limit) {
        this.limit = limit;
        sentTickets = new ArrayList<Ticket>();
    }

    public Ticket carIn(String carNumber) {
        if (sentTickets.size()<limit){
            Ticket ticket = new Ticket(carNumber);
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

    public int getParkingSpaceNum() {
        return limit- sentTickets.size();
    }

    public float getParkingSpqcePCT(){
        return (limit- sentTickets.size())/(float)limit;
    }
}
