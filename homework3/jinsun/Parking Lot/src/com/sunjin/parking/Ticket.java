package com.sunjin.parking;

/**
 * Created by jsun on 12/7/15.
 */
public class Ticket {

    private String carNumber;

    public int getParkingLotIndex() {
        return parkingLotIndex;
    }

    public void setParkingLotIndex(int parkingLotIndex) {
        this.parkingLotIndex = parkingLotIndex;
    }

    private int parkingLotIndex;

    public Ticket(String carNumber) {
        this.carNumber = carNumber;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }
}
