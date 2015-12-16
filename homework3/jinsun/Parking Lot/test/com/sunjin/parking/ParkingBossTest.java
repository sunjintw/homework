package com.sunjin.parking;

import com.sunjin.parking.finder.FoolishFinder;
import com.sunjin.parking.finder.NormalFinder;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.*;
import static junit.framework.TestCase.assertFalse;

/**
 * Created by jsun on 12/16/15.
 */
public class ParkingBossTest {
    List<ParkingManager> parkingManagers;
    List<ParkingManager> parkingManagers2;

    @Before
    public void setUp() throws Exception {
        List<ParkingLot> parkingLotList;
        List<ParkingLot> parkingLotList2;
        List<ParkingBoy> parkingBoys;
        List<ParkingBoy> parkingBoys2;
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
        parkingBoys2 = new ArrayList<>();
        parkingBoys2.add(cleverBoy);
        ParkingManager parkingManager = new ParkingManager(parkingBoys);
        ParkingManager parkingManager2 = new ParkingManager(parkingBoys2);
        parkingManagers = new ArrayList<>();
        parkingManagers.add(parkingManager);
        parkingManagers2 = new ArrayList<>();
        parkingManagers2.add(parkingManager2);

    }

    @Test
    public void testCarInServicSuccess() {
        ParkingBoss parkingBoss = new ParkingBoss(parkingManagers);
        String carNumber = "a";
        Ticket ticket = parkingBoss.carInService(carNumber);
        assertNotNull(ticket);
        assertEquals(ticket.getCarNumber(), carNumber);
    }

    @Test
    public void testCarInServiceFailed() {
        String carNumber = "a";
        List<ParkingBoy> boys = new ArrayList<>();
        ParkingBoss parkingBoss = new ParkingBoss(parkingManagers2);
        Ticket ticket = parkingBoss.carInService(carNumber);
        assertNull(ticket);
    }

    @Test
    public  void testCarOutServiceSuccess(){
        ParkingBoss parkingBoss = new ParkingBoss(parkingManagers);
        String carNumber = "abcdefg";
        Ticket ticket = parkingBoss.carInService(carNumber);
        assertTrue(parkingBoss.carOutService(ticket));
    }

    @Test
    public  void testCarOutServiceFailed(){
        ParkingBoss parkingBoss = new ParkingBoss(parkingManagers2);
        Ticket ticket = new Ticket("a", 1);
        assertFalse(parkingBoss.carOutService(ticket));
    }

}
