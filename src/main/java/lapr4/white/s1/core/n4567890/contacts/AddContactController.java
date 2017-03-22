/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.white.s1.core.n4567890.contacts;

import eapli.framework.application.Controller;
import eapli.framework.persistence.DataConcurrencyException;
import eapli.framework.persistence.DataIntegrityViolationException;
import java.util.Calendar;
import java.util.Properties;
import lapr4.white.s1.core.n4567890.contacts.domain.Contact;
import lapr4.white.s1.core.n4567890.contacts.domain.Event;
import lapr4.white.s1.core.n4567890.contacts.persistence.ContactRepository;
import lapr4.white.s1.core.n4567890.contacts.persistence.PersistenceContext;


/**
 *
 * @author alexandrebraganca
 */
public class AddContactController implements Controller {
    
    private Properties appProps;
    private final ContactRepository contactsRepository;
    private final PersistenceContext persistenceContext;
    private final ExtensionSettings extensionSettings;
    // = PersistenceContext.repositories().users();
    
    public AddContactController(Properties props) {
        this.appProps=props;
        this.extensionSettings=new ExtensionSettings(this.appProps);
        this.persistenceContext=new PersistenceContext(this.extensionSettings);
        this.contactsRepository=this.persistenceContext.repositories().contacts();
    }


    public Contact addContact(String name, String firstName, String lastName) throws DataConcurrencyException, DataIntegrityViolationException {
        /**
        Application.ensurePermissionOfLoggedInUser(ActionRight.ADMINISTER);

        final UserBuilder userBuilder = new UserBuilder();
        userBuilder.withUsername(username).withPassword(password).withFirstName(firstName).withLastName(lastName)
                .withEmail(email).withCreatedOn(createdOn).withRoles(roles);

        return this.userRepository.save(userBuilder.build());
        */
        
        return this.contactsRepository.save(new Contact(name, firstName, lastName));
        //return null; 
    }

    public Event addEvent(Contact contact, String eventDescription, Calendar dueDate) throws DataConcurrencyException, DataIntegrityViolationException {
        
        // Create a new Event for this contact...
        // FIXME: We should change this to use a Builder 
        Event ev=new Event(eventDescription, dueDate);
        
        contact.agenda().add(ev);
        
        // TODO: When do we save?...
        this.contactsRepository.save(contact);
        
        return ev; 
    }
        
    public boolean removeContact(Contact contact) throws DataConcurrencyException, DataIntegrityViolationException {
        
        return this.contactsRepository.removeContact(contact);
        //return this.contactsRepository..save(new Contact(name, firstName, lastName));
        // return false; 
    }
    /*
    public SystemUser addUser(String username, String password, String firstName, String lastName, String email,
            Set<RoleType> roles) throws DataIntegrityViolationException, DataConcurrencyException {
        return addUser(username, password, firstName, lastName, email, roles, DateTime.now());
    }
    */
}