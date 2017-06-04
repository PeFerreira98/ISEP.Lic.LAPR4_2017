/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s1.ipc.n1140618.ChatApplication;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Tiago
 */
public class MessageTest {
    
    public MessageTest() {
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
     * Test of getContent method, of class Message.
     */
    @Test
    public void testGetContent() {
        System.out.println("getContent");
        Message instance = new Message();
        
        String expResult1 = "Test1";
        instance.setContent(expResult1);
        String result1 = instance.getContent();
        
        assertEquals(expResult1, result1);
    }

    /**
     * Test of getIdDest method, of class Message.
     */
    @Test
    public void testGetIdDest() {
        System.out.println("getIdDest");
        Message instance = new Message();
        
        String expResult1 = "Test1";
        instance.setContent(expResult1);
        String result1 = instance.getContent();
        
        assertEquals(expResult1, result1);
    }



    /**
     * Test of getIdOrig method, of class Message.
     */
    @Test
    public void testGetIdOrig() {
        System.out.println("getIdOrig");
        Message instance = new Message();
        
        String expResult1 = "Test1";
        instance.setContent(expResult1);
        String result1 = instance.getContent();
        
        assertEquals(expResult1, result1);
    }
    
}
