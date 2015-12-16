package com.sunjin.parking;

import com.sunjin.parking.finder.NormalFinder;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.*;

/**
 * Created by jsun on 12/10/15.
 */
public class NormalBoyTest {

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
    public void testCarInServiceSuccess() {
        ParkingBoy normalBoy = new ParkingBoy(new NormalFinder(), parkingLotList);
        String carNumber = "a";
        Ticket ticket = normalBoy.carInService(carNumber);
        assertNotNull(ticket);
        assertEquals(ticket.getCarNumber(), carNumber);
        assertEquals(2, ticket.getParkingLotIndex());
    }

    @Test
    public void testCarInServiceFailed() {
        String carNumber = "a";
        ParkingBoy normalBoy = new ParkingBoy(new NormalFinder(), parkingLotList2);
        Ticket ticket = normalBoy.carInService(carNumber);
        assertNull(ticket);
    }

    @Test
    public  void testCarOutServiceSuccess(){
        ParkingBoy normalBoy = new ParkingBoy(new NormalFinder(), parkingLotList);
        String carNumber = "a";
        Ticket ticket = normalBoy.carInService(carNumber);
        assertTrue(normalBoy.carOutService(ticket));
    }

    @Test
    public  void testCarOutServiceFailed(){
        ParkingBoy normalBoy = new ParkingBoy(new NormalFinder(), parkingLotList);
        Ticket ticket = new Ticket("a", 1);
        assertFalse(normalBoy.carOutService(ticket));
    }

}
