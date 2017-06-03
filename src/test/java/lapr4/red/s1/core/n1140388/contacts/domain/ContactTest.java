/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s1.core.n1140388.contacts.domain;

import lapr4.white.s1.core.n4567890.contacts.domain.Agenda;
import lapr4.white.s1.core.n4567890.contacts.domain.Contact;
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
public class ContactTest {
    
    public ContactTest() {
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
     * Test of name method, of class Contact.
     */
    @Test
    public void testName() {
        System.out.println("name");
        Contact instance = new Contact("name", "firstName", "lastName");
        String expResult = "name";
        String result = instance.name();
        assertEquals(expResult, result);
    }

    /**
     * Test of setName method, of class Contact.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "outro";
        Contact instance = new Contact("name", "firstName", "lastName");
        String expResult = "outro";
        String result = instance.setName(name);
        assertEquals(expResult, result);
    }

    /**
     * Test of firstName method, of class Contact.
     */
    @Test
    public void testFirstName() {
        System.out.println("firstName");
        Contact instance = new Contact("name", "firstName", "lastName");
        String expResult = "firstName";
        String result = instance.firstName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setFirstName method, of class Contact.
     */
    @Test
    public void testSetFirstName() {
        System.out.println("setFirstName");
        String firstName = "outro";
        Contact instance = new Contact("name", "firstName", "lastName");
        String expResult = "outro";
        String result = instance.setFirstName(firstName);
        assertEquals(expResult, result);
    }

    /**
     * Test of lastName method, of class Contact.
     */
    @Test
    public void testLastName() {
        System.out.println("lastName");
        Contact instance = new Contact("name", "firstName", "lastName");
        String expResult = "lastName";
        String result = instance.lastName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setLastName method, of class Contact.
     */
    @Test
    public void testSetLastName() {
        System.out.println("setLastName");
        String lastName = "outro";
        Contact instance = new Contact("name", "firstName", "lastName");
        String expResult = "outro";
        String result = instance.setLastName(lastName);
        assertEquals(expResult, result);
    }
    
    
    /**
     * Test of agenda method, of class Contact.
     */
    @Test
    public void testAgenda() {
        System.out.println("agenda");
        Contact instance = new Contact("name", "firstName", "lastName");
        assertTrue(instance.agenda().events().isEmpty());
    }
    
    /**
     * Test of toString method, of class Contact.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Contact instance = new Contact("name", "firstName", "lastName");
        String expResult = "name (lastName, firstName)";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of sameAs method, of class Contact.
     */
    @Test
    public void testSameAs() {
        System.out.println("sameAs");
        Object other = new Contact("outro", "firstName", "lastName");
        Contact instance = new Contact("name", "firstName", "lastName");
        boolean expResult = true;
        boolean result = instance.sameAs(other);
        assertEquals(expResult, result);
        
        other = new Contact("outro", "first", "lastName");
        expResult = false;
        result = instance.sameAs(other);
        assertEquals(expResult, result);
    }
}
