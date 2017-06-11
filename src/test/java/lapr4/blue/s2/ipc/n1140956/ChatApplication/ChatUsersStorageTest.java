/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s2.ipc.n1140956.ChatApplication;

import java.util.HashMap;
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
public class ChatUsersStorageTest {
    
    public ChatUsersStorageTest() {
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
     * Test of addUser method, of class ChatUsersStorage.
     */
    @Test
    public void testAddUser() {
        System.out.println("addUser");
        ChatUser chatUser = new ChatUser("Teste@", "192.168.0.1");
        ChatUsersStorage instance = new ChatUsersStorage();
        instance.addUser(chatUser);
        
        assertEquals(chatUser, instance.getUserByIP(chatUser.getIp()));
    }

    /**
     * Test of getUserByIP method, of class ChatUsersStorage.
     */
    @Test
    public void testGetUserByIP() {
        System.out.println("getUserByIP");
        String ip = "/192.168.0.1";        
        ChatUser chatUser = new ChatUser("Teste@", ip);
        ChatUsersStorage instance = new ChatUsersStorage();
        instance.addUser(chatUser);
        
        ChatUser result = instance.getUserByIP(ip);
        assertEquals(chatUser, result);
    }

    /**
     * Test of getUserByNickname method, of class ChatUsersStorage.
     */
    @Test
    public void testGetUserByNickname() {
        System.out.println("getUserByIP");
        String nick = "TesteNick";
        ChatUser chatUser = new ChatUser("Teste@", "/192.168.0.1");
        chatUser.setNickname(nick);
        ChatUsersStorage instance = new ChatUsersStorage();
        instance.addUser(chatUser);
        
        ChatUser result = instance.getUserByNickname(nick);
        assertEquals(chatUser, result);
    }

    /**
     * Test of getUserList method, of class ChatUsersStorage.
     */
    @Test
    public void testGetUserList() {
        System.out.println("getUserList");
        ChatUsersStorage instance = new ChatUsersStorage();
        ChatUser user = new ChatUser("Teste@", "/192.168.0.1");
        ChatUser user2 = new ChatUser("Teste2@", "/192.168.0.2");
        
        HashMap<String, ChatUser> expResult = new HashMap<>();
        expResult.put("/192.168.0.1", user);
        expResult.put("/192.168.0.2", user2);
        
        instance.addUser(user);
        instance.addUser(user2);
        
        HashMap<String, ChatUser> result = instance.getUserList();
        assertEquals(expResult, result);
    }
    
}
