/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s1.core.n1140388.contacts.domain;

import java.util.Calendar;
import lapr4.white.s1.core.n4567890.contacts.domain.Event;
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
public class EventTest {
    
    public EventTest() {
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
     * Test of description method, of class Event.
     */
    @Test
    public void testDescription() {
        System.out.println("description");
        Calendar cl = Calendar.getInstance();
        Event instance = new Event("Event1", cl);
        String expResult = "Event1";
        String result = instance.description();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of time method, of class Event.
     */
    @Test
    public void testTime() {
        System.out.println("time");
        Calendar c1 = Calendar.getInstance();
        Event instance = new Event("Event1", c1);
        Calendar expResult = c1;
        Calendar result = instance.time();
        assertEquals(expResult, result);
    }
    
}
