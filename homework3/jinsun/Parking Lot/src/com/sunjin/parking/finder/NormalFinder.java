package com.sunjin.parking.finder;

import com.sunjin.parking.ParkingLot;
import com.sunjin.parking.Ticket;

import java.util.List;

public class NormalFinder implements Finder {

    @Override
    public ParkingLot findParkingLot(List<ParkingLot> parkingLotList) {
        ParkingLot parkingLot = null;
        for (ParkingLot temp : parkingLotList
                ) {
            if (null == parkingLot || temp.getParkingSpaceNum() > parkingLot.getParkingSpaceNum()) {
                parkingLot = temp;
            }
        }
        return parkingLot;
    }
}