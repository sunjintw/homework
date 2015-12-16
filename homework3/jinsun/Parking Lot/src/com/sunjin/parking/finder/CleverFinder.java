package com.sunjin.parking.finder;

import com.sunjin.parking.ParkingLot;
import com.sunjin.parking.Ticket;

import java.util.List;

public class CleverFinder implements Finder {

    @Override
    public ParkingLot findParkingLot(List<ParkingLot> parkingLotList) {
        ParkingLot parkingLot = null;
        for (ParkingLot temp : parkingLotList
                ) {
            if (null == parkingLot || temp.getParkingSpacePCT() > parkingLot.getParkingSpacePCT()) {
                parkingLot = temp;
                if (parkingLot.getParkingSpacePCT() == 1f) {
                    return parkingLot;
                }
            }
        }
        return parkingLot;
    }
}