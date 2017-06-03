/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.white.s1.core.n4567890.contacts;

import lapr4.white.s1.core.n4567890.contacts.application.ContactController;
import eapli.framework.persistence.DataConcurrencyException;
import eapli.framework.persistence.DataIntegrityViolationException;
import java.util.Calendar;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import lapr4.white.s1.core.n4567890.contacts.domain.Contact;
import lapr4.white.s1.core.n4567890.contacts.domain.Event;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author alexandrebraganca
 */
public class AddContactAcceptanceTest {
    
    private static Properties appProps=null;
    private static ContactController controller=null;
    private static Contact aContact=null;
    private static Event aEvent=null;
   
    private static final String REPOSITORY_FACTORY_KEY = "persistence.repositoryFactory";
    private static final String REPOSITORY_FACTORY_VALUE = "lapr4.white.s1.core.n4567890.contacts.persistence.jpa.JpaRepositoryFactory";

    private static final String PERSISTENCE_UNIT_KEY = "persistence.persistenceUnit";
    private static final String PERSISTENCE_UNIT_VALUE = "lapr4.csheets-crm-extension-PU";
        
    private static void setupProperties() {

        // Properties for persitence unit using h2 "memory"
        appProps=new Properties();
        
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
        
        controller=new ContactController(appProps);
        
        // Populate the repository
        aContact=controller.addContact("John Doe", "John", "Doe", null);

        Calendar tomorrow=Calendar.getInstance();
        tomorrow.add(Calendar.DAY_OF_WEEK, 1);
        aEvent=controller.addEvent(aContact, "Pay Taxes", tomorrow);        
    }

    @AfterClass
    public static void tearDown() {
    }
    
    // You can use @Ignore until the moment your test should pass because implementation is completed
    // @Ignore
    @Test(expected = DataIntegrityViolationException.class)
    public void ensureNoContactDuplicates() throws DataConcurrencyException, DataIntegrityViolationException { 

        controller.addContact("John Doe2", "John", "Doe2", null);
        
        controller.addContact("John Doe2", "John", "Doe2", null);
    } 
    
    @Test 
    public void ensureNewContactHasAgenda() throws DataIntegrityViolationException, DataConcurrencyException { 
        
        Contact contact=controller.addContact("Jane Doe3", "Jane", "Doe3", null);
        assertNotNull(contact.agenda().id());
    } 

    @Test 
    public void normalBehaviorAddEventToContact() throws DataIntegrityViolationException, DataConcurrencyException { 
        
        // First: Add or Select existing Contact
        Contact contact=controller.addContact("Jane Doe4", "Jane", "Doe4", null);
        
        // Second: Add Event to Contact's Agenda
        Event ev=null;
        Calendar tomorrow=Calendar.getInstance();
        tomorrow.add(Calendar.DAY_OF_WEEK, 1);
        ev=controller.addEvent(contact, "Pay Taxes", tomorrow);
        
        assertNotNull(ev);
    }     
    
    // @Ignore
    @Test(expected = DataIntegrityViolationException.class)
    public void ensureNoDeletionOfContactsWithEvents() throws DataConcurrencyException, DataIntegrityViolationException {
       
        controller.removeContact(aContact);
        //fail();
    }     
}
