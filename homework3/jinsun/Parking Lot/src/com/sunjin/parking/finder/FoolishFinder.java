package com.sunjin.parking.finder;

import com.sunjin.parking.ParkingLot;
import com.sunjin.parking.Ticket;

import java.util.List;

public class FoolishFinder implements Finder {
    @Override
    public ParkingLot findParkingLot(List<ParkingLot> parkingLotList) {
        for (ParkingLot parkingLot : parkingLotList
                ) {
            if (!parkingLot.isFull()) {
                return parkingLot;
            }
        }
        return null;
    }
}