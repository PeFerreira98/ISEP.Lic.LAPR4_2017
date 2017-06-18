/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s3.ipc.n1140388.chatrooms.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Observer;
import lapr4.blue.s2.ipc.n1140956.ChatApplication.ChatUser;
import lapr4.blue.s2.ipc.n1140956.ChatApplication.ChatUsersStorage;
import lapr4.green.s1.ipc.n1140618.ChatApplication.Message;
import lapr4.green.s1.ipc.n1151211.comm.ListenerServer;
import lapr4.green.s1.ipc.n1151211.comm.SendDto;
import lapr4.red.s3.ipc.n1140388.chatrooms.ChatRoom;
import lapr4.red.s3.ipc.n1140388.chatrooms.ChatRoomDTO;
import lapr4.red.s3.ipc.n1140388.chatrooms.ChatRoomsList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Alexandra Ferreira 1140388
 */
public class ChatRoomApplicationControllerTest {
    
    public ChatRoomApplicationControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of isOnline method, of class ChatRoomApplicationController.
     */
    @Test
    public void testIsOnline() {
        System.out.println("isOnline");
        ChatRoomApplicationController instance = new ChatRoomApplicationController();
        instance.offline();
        boolean expResult = false;
        boolean result = instance.isOnline();
        assertEquals(expResult, result);
    }

    /**
     * Test of offline method, of class ChatRoomApplicationController.
     */
    @Test
    public void testOffline() {
        System.out.println("offline");
        ChatRoomApplicationController instance = new ChatRoomApplicationController();
        instance.offline();
        boolean expResult = false;
        boolean result = instance.isOnline();
        assertEquals(expResult, result);
    }
}
