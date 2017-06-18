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
import org.junit.Ignore;

/**
 *
 * @author Alexandra Ferreira 1140388
 */
@Ignore public class ChatRoomTest {

    public ChatRoomTest() {
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
     * Test of name method, of class ChatRoom.
     */
    @Test
    public void testName() {
        System.out.println("name");
        ChatUser user = new ChatUser("machineName", "ip");
        ChatRoom instance = new PublicChatRoom("name", user);
        String expResult = "name";
        String result = instance.name();
        assertEquals(expResult, result);
    }

    /**
     * Test of owner method, of class ChatRoom.
     */
    @Test
    public void testOwner() {
        System.out.println("owner");
        ChatUser user = new ChatUser("machineName", "ip");
        ChatRoom instance = new PublicChatRoom("name", user);
        ChatUser expResult = user;
        ChatUser result = instance.owner();
        assertEquals(expResult, result);
    }

    /**
     * Test of participants method, of class ChatRoom.
     */
    @Test
    public void testParticipants() {
        System.out.println("participants");
        ChatUser user = new ChatUser("machineName", "ip");
        ChatRoom instance = new PublicChatRoom("name", user);
        List<ChatUser> expResult = new LinkedList<>();
        expResult.add(user);
        List<ChatUser> result = instance.participants();
        assertEquals(expResult, result);
    }

    /**
     * Test of isOnline method, of class ChatRoom.
     */
    @Test
    public void testIsOnline() {
        System.out.println("isOnline");
        ChatUser user = new ChatUser("machineName", "ip");
        ChatRoom instance = new PublicChatRoom("name", user);
        instance.setOnline(true);
        boolean expResult = true;
        boolean result = instance.isOnline();
        assertEquals(expResult, result);
    }

    /**
     * Test of setOnline method, of class ChatRoom.
     */
    @Test
    public void testSetOnline() {
        System.out.println("setOnline");
        boolean online = false;
        ChatUser user = new ChatUser("machineName", "ip");
        ChatRoom instance = new PublicChatRoom("name", user);
        
        instance.setOnline(online);
        
        boolean expResult = false;
        boolean result = instance.isOnline();
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class ChatRoom.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        ChatUser user = new ChatUser("machineName", "ip");
        Object other = new PublicChatRoom("name", user);
        ChatRoom instance = new PublicChatRoom("name", user);
        boolean expResult = true;
        boolean result = instance.equals(other);
        assertEquals(expResult, result);
    }

    /**
     * Test of hasParticipant method, of class ChatRoom.
     */
    @Test
    public void testHasParticipant() {
        System.out.println("hasParticipant");
        
        ChatUser user = new ChatUser("machineName", "ip");
        ChatRoom instance = new PublicChatRoom("name", user);
        
        boolean expResult = true;
        boolean result = instance.hasParticipant(user);
        assertEquals(expResult, result);
    }

    /**
     * Test of addParticipant method, of class ChatRoom.
     */
    @Test
    public void testAddParticipant() {
        System.out.println("addParticipant");
        ChatUser user = new ChatUser("machineName", "ip");
        ChatRoom instance = new PublicChatRoom("name", user);
        boolean expResult = false;
        boolean result = instance.addParticipant(user);
        assertEquals(expResult, result);
    }

    public class ChatRoomImpl extends ChatRoom {

        public ChatRoomImpl() {
            super("", null);
        }
    }

}
