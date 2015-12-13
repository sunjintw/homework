package com.sunjin.parking;

/**
 * Created by jsun on 12/10/15.
 */
public interface ParkingLotManager {
    Ticket carInService (String carNumber);
    boolean carOutService(Ticket ticket);
}
