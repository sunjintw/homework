package com.sunjin.parking;

import java.util.List;

/**
 * Created by jsun on 12/7/15.
 */
public class KingOfParkingLotLot implements ParkingLotManager {
    private List<ParkingLot> parkingLotList;

    public KingOfParkingLotLot(List<ParkingLot> parkingLotList) {
        this.parkingLotList = parkingLotList;
    }

    public Ticket carInService(String carNumber) {
        Ticket ticket = null;
        for (ParkingLot parking:parkingLotList
             ) {
                ticket = parking.carIn(carNumber);
            if (null != ticket){
                break;
            }
        }
        return ticket;
    }

    public boolean carOutService(Ticket ticket) {
        if (null != ticket && ticket.getParkingLotIndex() >= 0)
            return parkingLotList.get(ticket.getParkingLotIndex()).carOut(ticket);
        else return false;
    }
}
