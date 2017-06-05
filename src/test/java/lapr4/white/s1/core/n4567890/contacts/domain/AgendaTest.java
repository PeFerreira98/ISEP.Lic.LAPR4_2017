/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.white.s1.core.n4567890.contacts.domain;

import java.awt.List;
import java.util.Calendar;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import lapr4.white.s1.core.n4567890.contacts.domain.Agenda;
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
public class AgendaTest {

    public AgendaTest() {
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
     * Test of add method, of class Agenda.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        Event ev = new Event("description", Calendar.getInstance());
        Agenda instance = new Agenda();
        boolean expResult = true;
        boolean result = instance.add(ev);
        assertEquals(expResult, result);
    }

    /**
     * Test of events method, of class Agenda.
     */
    @Test
    public void testEvents() {
        System.out.println("events");
        Event e = new Event("description", Calendar.getInstance());
        Agenda instance = new Agenda();
        instance.add(e);
        Set<Event> events = new HashSet<>();
        events.add(e);
        Set<Event> expResult = events;
        Set<Event> result = instance.events();
        assertEquals(expResult, result);
    }

    /**
     * Test of compareToActualDate method, of class ContactController.
     */
    @Test
    public void testCompareToActualDate() {
        System.out.println("compareToActualDate");
        String dateToVerify = "12-12-1212";
        Agenda instance = new Agenda();
        Calendar expResult = null;
        Calendar result = instance.compareToActualDate(dateToVerify);
        assertEquals(expResult, result);
    }
}
