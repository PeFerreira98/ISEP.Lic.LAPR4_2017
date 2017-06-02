/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s1.core.n1140388.contacts.domain;

import java.util.Calendar;
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
    
}
