/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s2.ipc.n1140956.ChatApplication;

import java.util.ArrayList;
import lapr4.green.s1.ipc.n1140618.ChatApplication.Message;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Marcos
 */
public class ConversationStorageTest {

    public ConversationStorageTest() {
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
     * Test of getLst_Conversations method, of class ConversationStorage.
     */
    @Test
    public void testGetLst_Conversations() {
        System.out.println("getLst_Conversations");
        ConversationStorage instance = new ConversationStorage();
        Message msg1 = new Message();
        Message msg2 = new Message();

        instance.addMessage(msg1);
        instance.addMessage(msg2);

        ArrayList<Message> expResult = new ArrayList<>();
        expResult.add(msg1);
        expResult.add(msg2);

        ArrayList<Message> result = instance.getLst_Conversations();
        assertEquals(expResult, result);
    }

    /**
     * Test of addMessage method, of class ConversationStorage.
     */
    @Test
    public void testAddMessage() {
        System.out.println("addMessage");
        Message message = new Message();
        ConversationStorage instance = new ConversationStorage();
        instance.addMessage(message);
        Message expResult = message;

        assertEquals(expResult, instance.getLst_Conversations().get(0));
    }

    /**
     * Test of getConversationUsers method, of class ConversationStorage.
     */
//    @Test
//    public void testGetConversationUsers() {
//        System.out.println("getConversationUsers");
//        ChatUser chatUser1 = null;
//        ChatUser chatUser2 = null;
//        ConversationStorage instance = new ConversationStorage();
//        ArrayList<Message> expResult = null;
//        ArrayList<Message> result = instance.getConversationUsers(chatUser1, chatUser2);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    /**
     * Test of getConversationUsersTest method, of class ConversationStorage.
     */
    @Test
    public void testGetConversationUsersTest() {
        System.out.println("getConversationUsersTest");
        ChatUser chatUser = new ChatUser("Teste@", "192.168.0.1");
        ConversationStorage instance = new ConversationStorage();
        Message msg = new Message();
        msg.setIdDest(chatUser.getInfo());
        instance.addMessage(msg);

        ArrayList<Message> expResult = new ArrayList<>();
        expResult.add(instance.getLst_Conversations().get(0));
        
        ArrayList<Message> result = instance.getConversationUsersTest(chatUser);
        assertEquals(expResult, result);
    }

}
