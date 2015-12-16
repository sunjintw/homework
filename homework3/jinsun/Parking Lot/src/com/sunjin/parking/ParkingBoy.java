package com.sunjin.parking;

import com.sunjin.parking.finder.Finder;

import java.util.List;

/**
 * Created by jsun on 12/13/15.
 */
public class ParkingBoy {
    private List<ParkingLot> parkingLotList;
    private Finder finder;

    public ParkingBoy(Finder princeOfFinder, List<ParkingLot> parkingLotList) {
        this.parkingLotList = parkingLotList;
        this.finder = princeOfFinder;
    }

    public Ticket carInService(String carNumber) {
        ParkingLot parkingLot = finder.findParkingLot(parkingLotList);
        return null == parkingLot ? null : parkingLot.carIn(carNumber);
    }

    public boolean carOutService(Ticket ticket) {
        if (null != ticket && ticket.getParkingLotIndex() >= 0)
            return parkingLotList.get(ticket.getParkingLotIndex()).carOut(ticket);
        else return false;
    }
}
