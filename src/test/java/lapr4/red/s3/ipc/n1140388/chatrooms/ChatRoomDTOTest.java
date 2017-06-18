/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s3.ipc.n1140388.chatrooms;

import java.util.List;
import lapr4.blue.s2.ipc.n1140956.ChatApplication.ChatUser;
import lapr4.blue.s2.ipc.n1140956.ChatApplication.ConversationStorage;
import lapr4.green.s1.ipc.n1140618.ChatApplication.Message;
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
@Ignore public class ChatRoomDTOTest {
    
    public ChatRoomDTOTest() {
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
     * Test of getName method, of class ChatRoomDTO.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        ChatUser user = new ChatUser();
        ChatRoomDTO instance = new ChatRoomDTO("name", user, null, true, null, "1");
        String expResult = "name";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getOwner method, of class ChatRoomDTO.
     */
    @Test
    public void testGetOwner() {
        System.out.println("getOwner");
        ChatUser user = new ChatUser();
        ChatRoomDTO instance = new ChatRoomDTO("name", user, null, true, null, "1");
        ChatUser expResult = user;
        ChatUser result = instance.getOwner();
        assertEquals(expResult, result);
    }

    /**
     * Test of getParticipants method, of class ChatRoomDTO.
     */
    @Test
    public void testGetParticipants() {
        System.out.println("getParticipants");
        ChatUser user = new ChatUser();
        ChatRoomDTO instance = new ChatRoomDTO("name", user, null, true, null, "1");
        List<ChatUser> expResult = null;
        List<ChatUser> result = instance.getParticipants();
        assertEquals(expResult, result);
    }

    /**
     * Test of isOnline method, of class ChatRoomDTO.
     */
    @Test
    public void testIsOnline() {
        System.out.println("isOnline");
        ChatUser user = new ChatUser();
        ChatRoomDTO instance = new ChatRoomDTO("name", user, null, true, null, "1");
        boolean expResult = true;
        boolean result = instance.isOnline();
        assertEquals(expResult, result);
    }

    /**
     * Test of getType method, of class ChatRoomDTO.
     */
    @Test
    public void testGetType() {
        System.out.println("getType");
        ChatUser user = new ChatUser();
        ChatRoomDTO instance = new ChatRoomDTO("name", user, null, true, null, "1");
        String expResult = "1";
        String result = instance.getType();
        assertEquals(expResult, result);
    }

    /**
     * Test of getInvitates method, of class ChatRoomDTO.
     */
    @Test
    public void testGetInvitates() {
        System.out.println("getInvitates");
        ChatUser user = new ChatUser();
        ChatRoomDTO instance = new ChatRoomDTO("name", user, null, true, null, "1");
        List<ChatUser> expResult = null;
        List<ChatUser> result = instance.getInvitates();
        assertEquals(expResult, result);
    }

    /**
     * Test of getConversations method, of class ChatRoomDTO.
     */
    @Test
    public void testGetConversations() {
        System.out.println("getConversations");
        ChatUser user = new ChatUser();
        ChatRoomDTO instance = new ChatRoomDTO("name", user, null, true, null, "1");
        instance.getConversations().addMessage(new Message());
        
        ConversationStorage expResult = new ConversationStorage();
        expResult.addMessage(new Message());
        ConversationStorage result = instance.getConversations();
        assertEquals(expResult, result);
    }

    /**
     * Test of setConversations method, of class ChatRoomDTO.
     */
    @Test
    public void testSetConversations() {
        System.out.println("setConversations");
        ConversationStorage lst_Conversations = new ConversationStorage();
        lst_Conversations.addMessage(new Message());
        ChatUser user = new ChatUser();
        ChatRoomDTO instance = new ChatRoomDTO("name", user, null, true, null, "1");
        instance.setConversations(lst_Conversations);
        
        ConversationStorage expResult = new ConversationStorage();
        expResult.addMessage(new Message());
        ConversationStorage result = instance.getConversations();
        assertEquals(expResult, result);
    }
    
}
