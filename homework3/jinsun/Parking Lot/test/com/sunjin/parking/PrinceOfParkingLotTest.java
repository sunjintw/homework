package com.sunjin.parking;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.TestCase.*;

/**
 * Created by jsun on 12/13/15.
 */
public class PrinceOfParkingLotTest {
    List<ParkingLot> parkingLotList;
    List<ParkingLot> parkingLotList2;

    @Before
    public void setUp() throws Exception {
        parkingLotList = new ArrayList<>();
        for (int i = 2; i < 5; i++) {
            parkingLotList.add(new ParkingLot(i));
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
    public void testCarInServiceSuccess(){
        ParkingLotManager princeOfParkingLot = new PrinceOfParkingLotLot(parkingLotList);
        Ticket ticket1 = princeOfParkingLot.carInService("aaa");
        Ticket ticket2 = princeOfParkingLot.carInService("bbb");
        Ticket ticket3 = princeOfParkingLot.carInService("ccc");
        Ticket ticket4 = princeOfParkingLot.carInService("ddd");
        assertNotNull(ticket1);
        assertNotNull(ticket2);
        assertNotNull(ticket3);
        assertNotNull(ticket4);
        assertEquals(0,ticket1.getParkingLotIndex());
        assertEquals(1,ticket2.getParkingLotIndex());
        assertEquals(2,ticket3.getParkingLotIndex());
        assertEquals(2,ticket4.getParkingLotIndex());
    }

    @Test
    public void testCarInServiceFailed(){
        String carNumber = "a";
        ParkingLotManager princeOfParkingLot = new PrinceOfParkingLotLot(parkingLotList2);
        Ticket ticket = princeOfParkingLot.carInService(carNumber);
        assertNull(ticket);
    }

    @Test
    public void testCarOutServiceSuccess(){
        ParkingLotManager princeOfParkingLot = new PrinceOfParkingLotLot(parkingLotList);
        String carNumber = "a";
        Ticket ticket = princeOfParkingLot.carInService(carNumber);
        assertTrue(princeOfParkingLot.carOutService(ticket));
    }

    @Test
    public void testCarOutServiceFailed(){
        ParkingLotManager princeOfParkingLot = new PrinceOfParkingLotLot(parkingLotList);
        Ticket ticket = new Ticket("a");
        assertFalse(princeOfParkingLot.carOutService(ticket));
    }
}