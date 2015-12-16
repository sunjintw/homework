package com.sunjin.parking;

import java.util.List;

/**
 * Created by jsun on 12/16/15.
 */
public class ParkingBoss {

    private List<ParkingManager> parkingManagers;

    public ParkingBoss(List<ParkingManager> parkingManagers) {

        this.parkingManagers = parkingManagers;
    }

    public Ticket carInService(String carNumber) {
        Ticket ticket = null;
        for (ParkingManager parkingManager: parkingManagers
                ) {
            ticket = parkingManager.carInService(carNumber);
            if (null != ticket){
                break;
            }
        }
        return ticket;
    }

    public boolean carOutService(Ticket ticket) {
        for (ParkingManager parkingManager: parkingManagers
                ) {
            if (parkingManager.carOutService(ticket)){
                return true;
            }
        }
        return  false;
    }
}
