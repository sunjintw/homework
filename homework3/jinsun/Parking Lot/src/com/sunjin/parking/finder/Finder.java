package com.sunjin.parking.finder;

import com.sunjin.parking.ParkingLot;
import com.sunjin.parking.Ticket;

import java.util.List;

/**
 * Created by jsun on 12/14/15.
 */
public interface Finder {
    ParkingLot findParkingLot(List<ParkingLot> parkingLotList);
}
