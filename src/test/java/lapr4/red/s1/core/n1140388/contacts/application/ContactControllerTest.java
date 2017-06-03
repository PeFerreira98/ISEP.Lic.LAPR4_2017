/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s1.core.n1140388.contacts.application;

import eapli.framework.persistence.DataConcurrencyException;
import eapli.framework.persistence.DataIntegrityViolationException;
import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import lapr4.white.s1.core.n4567890.contacts.application.ContactController;
import lapr4.white.s1.core.n4567890.contacts.domain.Contact;
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
public class ContactControllerTest {
    
    private static Properties appProps = null;
    private static ContactController controller = null;
    private static Contact aContact = null;
    private static Event aEvent = null;
    
    private static final String REPOSITORY_FACTORY_KEY = "persistence.repositoryFactory";
    private static final String REPOSITORY_FACTORY_VALUE = "lapr4.white.s1.core.n4567890.contacts.persistence.jpa.JpaRepositoryFactory";
    
    private static final String PERSISTENCE_UNIT_KEY = "persistence.persistenceUnit";
    private static final String PERSISTENCE_UNIT_VALUE = "lapr4.csheets-crm-extension-PU";
    
    private static void setupProperties() {

        // Properties for persitence unit using h2 "memory"
        appProps = new Properties();
        
        appProps.put(REPOSITORY_FACTORY_KEY, REPOSITORY_FACTORY_VALUE);
        appProps.put(PERSISTENCE_UNIT_KEY, PERSISTENCE_UNIT_VALUE);
        
        appProps.put("javax.persistence.jdbc.url", "jdbc:h2:mem:csheets-crm-extension;MV_STORE=FALSE");
        appProps.put("javax.persistence.jdbc.password", "");
        appProps.put("javax.persistence.jdbc.driver", "org.h2.Driver");
        appProps.put("javax.persistence.jdbc.user", "");
        appProps.put("javax.persistence.schema-generation.database.action", "create");
        appProps.put("eclipselink.logging.level", "FINE");
    }
    
    @BeforeClass
    public static void setUp() throws DataIntegrityViolationException, DataConcurrencyException {

        // Setup for testing (JPA in Memory)
        setupProperties();
        
        controller = new ContactController(appProps);

        // Populate the repository
        aContact = controller.addContact("John Doe", "John", "Doe");
        
        Calendar tomorrow = Calendar.getInstance();
        tomorrow.add(Calendar.DAY_OF_WEEK, 1);
        aEvent = controller.addEvent(aContact, "Pay Taxes", tomorrow);        
    }
    
    @AfterClass
    public static void tearDown() {
    }

    /**
     * Test of addContact method, of class ContactController.
     */
    @Test
    public void testAddContact() throws Exception {
        System.out.println("addContact");
        String name = "name";
        String firstName = "firstName";
        String lastName = "lastName";
        
        controller.addContact(name, firstName, lastName);
        List<Contact> list = (List<Contact>) controller.allContacts();
        assertTrue(list.size() == 2);
    }

    /**
     * Test of removeContact method, of class ContactController.
     */
    @Test
    public void testRemoveContact() throws Exception {
        System.out.println("removeContact");
        
        String name = "name";
        String firstName = "firstName";
        String lastName = "lastName";
        
        controller.addContact(name, firstName, lastName);
        
        List<Contact> list = (List<Contact>) controller.allContacts();
        Contact contact = list.get(1);
        controller.removeContact(contact);
        
        list = (List<Contact>) controller.allContacts();
        assertTrue(list.size() == 1);
    }

    /**
     * Test of updateContact method, of class ContactController.
     */
    @Test
    public void testUpdateContact() throws Exception {
        System.out.println("updateContact");
        
        List<Contact> list = (List<Contact>) controller.allContacts();
      
        controller.updateContact(list.get(0), "fullName", "firstName", "lastName");
        list = (List<Contact>) controller.allContacts();
        
        assertEquals(list.get(0).name(), "fullName");
    }

    /**
     * Test of allContacts method, of class ContactController.
     */
    @Test
    public void testAllContacts() {
        System.out.println("allContacts");
        List<Contact> result = (List<Contact>) controller.allContacts();
        
        List<Contact> expResult = new LinkedList<>();
        expResult.add(aContact);
        
        assertEquals(expResult.size(), result.size());
    }

    /**
     * Test of getContactById method, of class ContactController.
     */
    @Test
    public void testGetContactById() {
        System.out.println("getContactById");
        Long id = 1l;
        Contact expResult = controller.allContacts().iterator().next();
        
        Contact result = controller.getContactById(id);
        assertEquals(expResult, result);
    }

    /**
     * Test of addEvent method, of class ContactController.
     */
    @Test
    public void testAddEvent() throws Exception {
        System.out.println("addEvent");
        String eventDescription = "description";
        Calendar dueDate = Calendar.getInstance();
        
        aContact.agenda().events().clear();
        
        Event result = controller.addEvent(aContact, eventDescription, dueDate);
        Event expResult = aContact.agenda().events().iterator().next();
        
        assertEquals(expResult, result);
    }

    /**
     * Test of editEvent method, of class ContactController.
     */
    @Test
    public void testEditEvent() throws Exception {
        System.out.println("editEvent");
        String eventDescription = "description23";
        Calendar dueDate = Calendar.getInstance();
        
        Event eventAdded = controller.addEvent(aContact, eventDescription, dueDate);
        
        Event result = controller.editEvent(aContact, eventAdded, "new", dueDate);
        
        assertTrue(result.description().equals("new"));
    }

    /**
     * Test of removeEvent method, of class ContactController.
     */
    @Test
    public void testRemoveEvent() throws Exception {
        System.out.println("removeEvent");
        
        String eventDescription = "description";
        Calendar dueDate = Calendar.getInstance();
        
        Event event = controller.addEvent(aContact, eventDescription, dueDate);
        
        boolean result = controller.removeEvent(aContact, event);
        
        assertEquals(true, result);
    }

    /**
     * Test of compareToActualDate method, of class ContactController.
     */
    @Test
    public void testCompareToActualDate() {
        System.out.println("compareToActualDate");
        String dateToVerify = "12-12-1212";
        Calendar expResult = null;
        Calendar result = controller.compareToActualDate(dateToVerify);
        assertEquals(expResult, result);
    }
    
}
