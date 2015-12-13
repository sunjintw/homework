package com.sunjin.parking;

import java.util.List;

/**
 * Created by jsun on 12/13/15.
 */
public class PrinceOfParkingLotLot implements ParkingLotManager {
    private final List<ParkingLot> parkingLotList;

    public PrinceOfParkingLotLot(List<ParkingLot> parkingLotList) {
        this.parkingLotList = parkingLotList;
    }

    @Override
    public Ticket carInService(String carNumber) {
        int index = 0;
        float flag = 0f;
        Ticket ticket = null;
        for (int i = 0; i < parkingLotList.size(); i++) {
            ParkingLot parkingLot = parkingLotList.get(i);
            if (parkingLot.getParkingSpqcePCT() > flag) {
                index = i;
                flag = parkingLot.getParkingSpqcePCT();
            }
            if (flag == 1f || i == parkingLotList.size() - 1) {
                ticket = parkingLot.carIn(carNumber);
                if (null != ticket) {
                    ticket.setParkingLotIndex(index);
                }
                break;
            }
        }
        return ticket;
    }

    @Override
    public boolean carOutService(Ticket ticket) {
        if (null != ticket && ticket.getParkingLotIndex() >= 0)
            return parkingLotList.get(ticket.getParkingLotIndex()).carOut(ticket);
        else return false;
    }
}
