/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s1.core.n1140388.contacts.domain;

import eapli.util.DateTime;
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
    
    @Test(expected = IllegalStateException.class)
    public void testDescriptionMustNotBeNull() {
        System.out.println("must have a description");
        Event instance = new Event(null, Calendar.getInstance());
    }

    @Test(expected = IllegalStateException.class)
    public void testTimeMustNotBeNull() {
        System.out.println("must have a time");
        Event instance = new Event("description", null);
    }
    
    /**
     * Test of setFirstName method, of class Event.
     */
    @Test
    public void testSetDescription() {
        System.out.println("setDescription");
        String description = "description";
        Event instance = new Event("", Calendar.getInstance());
        String expResult = "description";
        String result = instance.setDescription(description);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of setFirstName method, of class Event.
     */
    @Test
    public void testSetTime() {
        System.out.println("setTime");
        Calendar dueDate = Calendar.getInstance();
        Event instance = new Event("", DateTime.parseDate("12-12-2018"));
        Calendar expResult = dueDate;
        Calendar result = instance.setTime(dueDate);
        assertEquals(expResult, result);
    }
}
