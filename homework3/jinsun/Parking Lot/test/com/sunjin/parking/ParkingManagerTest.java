package com.sunjin.parking;

import com.sunjin.parking.finder.NormalFinder;
import com.sunjin.parking.finder.FoolishFinder;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.*;

/**
 * Created by jsun on 12/14/15.
// */
public class ParkingManagerTest {
    List<ParkingLot> parkingLotList;
    List<ParkingLot> parkingLotList2;
    List<ParkingBoy> parkingBoys;

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
        ParkingBoy foolishBoy = new ParkingBoy(new FoolishFinder(), parkingLotList);
        ParkingBoy cleverBoy = new ParkingBoy(new NormalFinder(), parkingLotList2);
        parkingBoys = new ArrayList<>();
        parkingBoys.add(foolishBoy);
        parkingBoys.add(cleverBoy);

    }

    @Test
    public void testCarInServicSuccess() {
        ParkingManager godOfParkingLot;
        godOfParkingLot = new ParkingManager(parkingBoys);
        String carNumber = "a";
        Ticket ticket = godOfParkingLot.carInService(carNumber);
        assertNotNull(ticket);
        assertEquals(ticket.getCarNumber(), carNumber);
    }

    @Test
    public void testCarInServiceFailed() {
        String carNumber = "a";
        List<ParkingBoy> boys = new ArrayList<>();
        ParkingManager parkingManager = new ParkingManager(boys);
        Ticket ticket = parkingManager.carInService(carNumber);
        assertNull(ticket);
    }

    @Test
    public  void testCarOutServiceSuccess(){
        ParkingManager godOfParkingLot;
        godOfParkingLot = new ParkingManager(parkingBoys);
        String carNumber = "abcdefg";
        Ticket ticket = godOfParkingLot.carInService(carNumber);
        assertTrue(godOfParkingLot.carOutService(ticket));
    }

    @Test
    public  void testCarOutServiceFailed(){
        ParkingManager kingOfParkingLot = new ParkingManager(parkingBoys);
        Ticket ticket = new Ticket("a", 1);
        assertFalse(kingOfParkingLot.carOutService(ticket));
    }

}
