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
public class PrivateChatRoomTest {
    
    public PrivateChatRoomTest() {
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
     * Test of invitations method, of class PrivateChatRoom.
     */
    @Test
    public void testInvitations() {
        System.out.println("invitations");
        ChatUser user = new ChatUser("machineName", "ip");
        
        List<ChatUser> inv = new LinkedList<>();
        ChatUser user1 = new ChatUser("machineName1", "ip");
        inv.add(user1);
        
        PrivateChatRoom instance = new PrivateChatRoom("name", user, inv);
        
        List<ChatUser> expResult = inv;
        List<ChatUser> result = instance.invitations();
        assertEquals(expResult, result);
    }
    
}
