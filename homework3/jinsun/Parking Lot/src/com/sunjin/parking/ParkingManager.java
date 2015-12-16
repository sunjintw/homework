package com.sunjin.parking;

import java.util.List;

/**
 * Created by jsun on 12/14/15.
 */
public class ParkingManager {

    private List<ParkingBoy> parkingBoys;

    public ParkingManager(List<ParkingBoy> parkingBoys) {

        this.parkingBoys = parkingBoys;
    }

    public Ticket carInService(String carNumber) {
        Ticket ticket = null;
        for (ParkingBoy parkingBoy: parkingBoys
             ) {
           ticket = parkingBoy.carInService(carNumber);
            if (null != ticket){
                break;
            }
        }
        return ticket;
    }

    public boolean carOutService(Ticket ticket) {
        for (ParkingBoy parkingLotManager: parkingBoys
                ) {
            if (parkingLotManager.carOutService(ticket)){
                return true;
            }
        }
        return  false;
    }
}
