package com.sunjin.parking;

import java.util.List;

/**
 * Created by jsun on 12/10/15.
 */
public class QueenOfParkingLot implements ParkingManager {
    private final List<ParkingLot> parkingLotList;

    public QueenOfParkingLot(List<ParkingLot> parkingLotList) {
        this.parkingLotList = parkingLotList;
    }

    @Override
    public Ticket carInService(String carNumber) {
        Ticket ticket = null;
        int spaceNum = 0;
        int index = 0;
        for (int i = 0; i< parkingLotList.size(); i++
             ) {
            ParkingLot parking = parkingLotList.get(i);
                if (parking.getParkingSpaceNum()>spaceNum){
                    spaceNum = parking.getParkingSpaceNum();
                    index = i;
                }
        }
        if (spaceNum > 0){
            ticket = parkingLotList.get(index).carIn(carNumber);
            ticket.setParkingLotIndex(index);
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
