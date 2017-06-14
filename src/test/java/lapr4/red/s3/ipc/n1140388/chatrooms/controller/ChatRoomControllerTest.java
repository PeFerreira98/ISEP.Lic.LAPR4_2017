/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s3.ipc.n1140388.chatrooms.controller;

import java.util.LinkedList;
import java.util.List;
import lapr4.blue.s2.ipc.n1140956.ChatApplication.ChatUser;
import lapr4.green.s1.ipc.n1140618.ChatApplication.controller.ChatApplicationController;
import lapr4.green.s1.ipc.n1151211.comm.CommServer2;
import lapr4.red.s3.ipc.n1140388.chatrooms.ChatRoom;
import lapr4.red.s3.ipc.n1140388.chatrooms.PublicChatRoom;
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
public class ChatRoomControllerTest {

    public ChatRoomControllerTest() {
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
     * Test of owner method, of class ChatRoomController.
     */
//    @Test
//    public void testOwner() {
//        System.out.println("owner");
//        ChatRoomController instance = new ChatRoomController();
//        ChatUser expResult = new ChatApplicationController().owner();;
//        ChatUser result = instance.owner();
//        assertEquals(expResult, result);
//    }

    /**
     * Test of createChatRoom method, of class ChatRoomController.
     */
//    @Test
//    public void testCreateChatRoom() {
//        System.out.println("createChatRoom");
//        
//        CommServer2 server = CommServer2.getServer();
//        
//        String name = "pub";
//        int type = 1;
//        List<ChatUser> invites = null;
//        ChatRoomController instance = new ChatRoomController();
//        ChatRoom expResult = new PublicChatRoom(name, instance.owner());
//        ChatRoom result = instance.createChatRoom(name, type, invites);
//        assertEquals(expResult, result);
//    }

    /**
     * Test of chatRoomsList method, of class ChatRoomController.
     */
//    @Test
//    public void testChatRoomsList() {
//        System.out.println("chatRoomsList");
//        ChatRoomController instance = new ChatRoomController();
//        ChatRoom cr = instance.createChatRoom("name", 1, null);
//        instance.startChat(cr);
//
//        List<ChatRoom> expResult = new LinkedList<>();
//        expResult.add(cr);
//
//        List<ChatRoom> result = instance.chatRoomsList();
//        assertEquals(expResult, result);
//    }

    /**
     * Test of publicRooms method, of class ChatRoomController.
     */
//    @Test
//    public void testPublicRooms() {
//        System.out.println("publicRooms");
//        ChatRoomController instance = new ChatRoomController();
//        ChatRoom cr = instance.createChatRoom("name", 1, null);
//        instance.startChat(cr);
//
//        List<ChatRoom> expResult = new LinkedList<>();
//        expResult.add(cr);
//
//        List<ChatRoom> result = instance.publicRooms();
//        assertEquals(expResult, result);
//    }

    /**
     * Test of privateRooms method, of class ChatRoomController.
     */
//    @Test
//    public void testPrivateRooms() {
//        System.out.println("privateRooms");
//        ChatRoomController instance = new ChatRoomController();
//        ChatRoom cr = instance.createChatRoom("name", 2, null);
//        instance.startChat(cr);
//
//        List<ChatRoom> expResult = new LinkedList<>();
//        expResult.add(cr);
//
//        List<ChatRoom> result = instance.privateRooms();
//        assertEquals(expResult, result);
//    }

    /**
     * Test of startChat method, of class ChatRoomController.
     */
//    @Test
//    public void testStartChat() {
//        System.out.println("startChat");
//        ChatRoomController instance = new ChatRoomController();
//        ChatRoom cr = instance.createChatRoom("name", 1, null);
//        instance.startChat(cr);
//        
//        List<ChatRoom> expResult = new LinkedList<>();
//        expResult.add(cr);
//
//        List<ChatRoom> result = instance.chatRoomsList();
//        assertEquals(expResult, result);
//    }

    /**
     * Test of joinChatRoom method, of class ChatRoomController.
     */
//    @Test
//    public void testJoinChatRoom() {
//        System.out.println("joinChatRoom");
//        ChatRoomController instance = new ChatRoomController();
////        ChatUser p = new ChatUser("machineName", "ip");
//        LinkedList inv = new LinkedList();
////        inv.add(p);
//        inv.add(instance.owner());
//        ChatRoom chatRoom = instance.createChatRoom("pub", 1, inv);
//        instance.startChat(chatRoom);
//        
//        boolean expResult = true;
//        boolean result = instance.joinChatRoom(chatRoom);
//        assertEquals(expResult, result);
//    }

    /**
     * Test of rejectChatRoom method, of class ChatRoomController.
     */
//    @Test
//    public void testRejectChatRoom() {
//        System.out.println("rejectChatRoom");
//        ChatRoom chatRoom = null;
//        ChatRoomController instance = new ChatRoomController();
//        boolean expResult = false;
//        boolean result = instance.rejectChatRoom(chatRoom);
//        assertEquals(expResult, result);
//    }

}
