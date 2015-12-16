package com.sunjin.parking;

import com.sunjin.parking.finder.FoolishFinder;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.*;


/**
 * Created by jsun on 12/7/15.
 */
public class FoolishBoyTest {
    List<ParkingLot> parkingLotList;
    List<ParkingLot> parkingLotList2;

    @Before
    public void setUp() throws Exception {
        parkingLotList = new ArrayList<>();
        for (int i = 2; i < 5; i++) {
            parkingLotList.add(new ParkingLot(i, i-2));
        }
        ParkingLot parkingLot1 = new ParkingLot(2);
        parkingLot1.carIn("1");
        parkingLot1.carIn("2");
        ParkingLot parkingLot2 = new ParkingLot(2);
        parkingLot2.carIn("3");
        parkingLot2.carIn("4");
        parkingLotList2 = new ArrayList<>();
        parkingLotList2.add(parkingLot1);
        parkingLotList2.add(parkingLot2);
    }

    @Test
    public void testCarInServiceSuccess() {
        ParkingBoy foolishBoy = new ParkingBoy(new FoolishFinder(), parkingLotList);
        String carNumber = "a";
        Ticket ticket = foolishBoy.carInService(carNumber);
        assertNotNull(ticket);
        assertEquals(ticket.getCarNumber(), carNumber);
    }

    @Test
    public void testCarInServiceFailed() {
        String carNumber = "a";
        ParkingBoy foolishBoy = new ParkingBoy(new FoolishFinder(), parkingLotList2);
        Ticket ticket = foolishBoy.carInService(carNumber);
        assertNull(ticket);
    }

    @Test
    public void testCarOutServiceSuccess() {
        ParkingBoy foolishBoy = new ParkingBoy(new FoolishFinder(), parkingLotList);
        String carNumber = "a";
        Ticket ticket = foolishBoy.carInService(carNumber);
        assertTrue(foolishBoy.carOutService(ticket));
    }

    @Test
    public void testCarOutServiceFailed() {
        ParkingBoy foolishBoy = new ParkingBoy(new FoolishFinder(), parkingLotList);
        Ticket ticket = new Ticket("a", 1);
        assertFalse(foolishBoy.carOutService(ticket));
    }

}