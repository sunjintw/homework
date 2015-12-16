package com.sunjin.parking;

import com.sunjin.parking.finder.CleverFinder;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.TestCase.*;

/**
 * Created by jsun on 12/13/15.
 */
public class CleverBoyTest {
    List<ParkingLot> parkingLotList;
    List<ParkingLot> parkingLotList2;

    @Before
    public void setUp() throws Exception {
        parkingLotList = new ArrayList<>();
        for (int i = 2; i < 5; i++) {
            parkingLotList.add(new ParkingLot(i,i-2));
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
        ParkingBoy cleverBoy = new ParkingBoy(new CleverFinder(), parkingLotList);
        Ticket ticket1 = cleverBoy.carInService("aaa");
        Ticket ticket2 = cleverBoy.carInService("bbb");
        Ticket ticket3 = cleverBoy.carInService("ccc");
        Ticket ticket4 = cleverBoy.carInService("ddd");
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
        ParkingBoy cleverBoy = new ParkingBoy(new CleverFinder(), parkingLotList2);
        Ticket ticket = cleverBoy.carInService(carNumber);
        assertNull(ticket);
    }

    @Test
    public void testCarOutServiceSuccess(){
        ParkingBoy cleverBoy = new ParkingBoy(new CleverFinder(), parkingLotList);
        String carNumber = "a";
        Ticket ticket = cleverBoy.carInService(carNumber);
        assertTrue(cleverBoy.carOutService(ticket));
    }

    @Test
    public void testCarOutServiceFailed(){
        ParkingBoy cleverBoy = new ParkingBoy(new CleverFinder(), parkingLotList);
        Ticket ticket = new Ticket("a", 1);
        assertFalse(cleverBoy.carOutService(ticket));
    }
}