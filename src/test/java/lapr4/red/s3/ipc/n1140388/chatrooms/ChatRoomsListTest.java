/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s3.ipc.n1140388.chatrooms;

import java.util.LinkedList;
import java.util.List;
import lapr4.blue.s2.ipc.n1140956.ChatApplication.ChatUser;
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
public class ChatRoomsListTest {

    public ChatRoomsListTest() {
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
     * Test of contains method, of class ChatRoomsList.
     */
    @Test
    public void testContains() {
        System.out.println("contains");
        ChatUser user = new ChatUser("machineName", "ip");
        ChatRoom cr = new PublicChatRoom("name", user);

        ChatRoomsList instance = new ChatRoomsList();
        instance.add(cr);

        boolean expResult = true;
        boolean result = instance.contains(cr);
        assertEquals(expResult, result);
    }

    /**
     * Test of add method, of class ChatRoomsList.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        ChatUser user = new ChatUser("machineName", "ip");
        ChatRoom cr = new PublicChatRoom("name", user);

        ChatRoomsList instance = new ChatRoomsList();
        instance.add(cr);

        boolean expResult = true;
        boolean result = instance.contains(cr);
        assertEquals(expResult, result);
    }

    /**
     * Test of findChatRoomByName method, of class ChatRoomsList.
     */
    @Test
    public void testFindChatRoomByName() {
        System.out.println("findChatRoomByName");
        String name = "name";
        
        ChatUser user = new ChatUser("machineName", "ip");
        ChatRoom cr = new PublicChatRoom("name", user);
        
        ChatRoomsList instance = new ChatRoomsList();
        instance.add(cr);
        
        ChatRoom expResult = cr;
        ChatRoom result = instance.findChatRoomByName(name);
        assertEquals(expResult, result);
    }

    /**
     * Test of chatRoomsList method, of class ChatRoomsList.
     */
    @Test
    public void testChatRoomsList() {
        System.out.println("chatRoomsList");
        
        ChatUser user = new ChatUser("machineName", "ip");
        ChatRoom cr = new PublicChatRoom("name", user);
        
        ChatRoomsList instance = new ChatRoomsList();
        instance.add(cr);
        
        List<ChatRoom> expResult = new LinkedList<>();
        expResult.add(cr);
        
        List<ChatRoom> result = instance.chatRoomsList(user);
        assertEquals(expResult, result);
    }

    /**
     * Test of publicRoomsWithoutParticipant method, of class ChatRoomsList.
     */
    @Test
    public void testPublicRoomsWithoutParticipant() {
        System.out.println("publicRoomsWithoutParticipant");
        ChatUser user = new ChatUser("machineName", "ip");
        ChatRoom cr = new PublicChatRoom("name", user);
        
        ChatUser participant = new ChatUser("machineName2121", "ip");
        
        ChatRoomsList instance = new ChatRoomsList();
        instance.add(cr);
        
        List<ChatRoom> expResult = new LinkedList<>();
        expResult.add(cr);
        
        List<ChatRoom> result = instance.publicRoomsWithoutParticipant(participant);
        assertEquals(expResult, result);
    }

    /**
     * Test of privateRoomsWithInvationWithoutParticipant method, of class
     * ChatRoomsList.
     */
    @Test
    public void testPrivateRoomsWithInvationWithoutParticipant() {
        System.out.println("privateRoomsWithInvationWithoutParticipant");
        
        ChatUser user = new ChatUser("machineName", "ip");
        
        ChatUser participant = new ChatUser("machineName2121", "ip");
        List<ChatUser> inv = new LinkedList<>();
        inv.add(participant);
        
        ChatRoom cr = new PrivateChatRoom("name", user, inv);
        
        ChatRoomsList instance = new ChatRoomsList();
        instance.add(cr);
        
        List<ChatRoom> expResult = new LinkedList<>();
        expResult.add(cr);
        
        List<ChatRoom> result = instance.privateRoomsWithInvationWithoutParticipant(participant);
        assertEquals(expResult, result);
    }

}
