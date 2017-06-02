/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.white.s1.core.n4567890.contacts.application;

import eapli.framework.application.Controller;
import eapli.framework.persistence.DataConcurrencyException;
import eapli.framework.persistence.DataIntegrityViolationException;
import eapli.util.DateTime;
import java.util.Calendar;
import java.util.Optional;
import java.util.Properties;
import lapr4.white.s1.core.n4567890.contacts.ExtensionSettings;
import lapr4.white.s1.core.n4567890.contacts.domain.Contact;
import lapr4.white.s1.core.n4567890.contacts.domain.Event;
import lapr4.white.s1.core.n4567890.contacts.persistence.ContactRepository;
import lapr4.white.s1.core.n4567890.contacts.persistence.PersistenceContext;

/**
 *
 * @author alexandrebraganca
 */
public class ContactController implements Controller {

    private Properties appProps;
    private final ContactRepository contactsRepository;
    private final PersistenceContext persistenceContext;
    private final ExtensionSettings extensionSettings;

    public ContactController(Properties props) {
        this.appProps = props;
        this.extensionSettings = new ExtensionSettings(this.appProps);
        this.persistenceContext = new PersistenceContext(this.extensionSettings);
        this.contactsRepository = this.persistenceContext.repositories().contacts();
    }

    public Contact addContact(String name, String firstName, String lastName) throws DataConcurrencyException, DataIntegrityViolationException {
        return this.contactsRepository.save(new Contact(name, firstName, lastName));
    }

    public boolean removeContact(Contact contact) throws DataConcurrencyException, DataIntegrityViolationException {
        return this.contactsRepository.removeContact(contact);
    }

    public Contact updateContact(Contact contact, String fullName, String firstName, String lastName) throws DataConcurrencyException, DataIntegrityViolationException {
        contact.setName(fullName);
        contact.setFirstName(firstName);
        contact.setLastName(lastName);
        return this.contactsRepository.save(contact);
    }

    public Iterable<Contact> allContacts() {
        return this.contactsRepository.findAll();
    }

    public Contact getContactById(Long id) {
        Optional<Contact> c = this.contactsRepository.findOne(id);
        if (c.isPresent()) {
            return c.get();
        } else {
            return null;
        }
    }

    public Event addEvent(Contact contact, String eventDescription, Calendar dueDate) throws DataConcurrencyException, DataIntegrityViolationException {

        // Create a new Event for this contact...
        // FIXME: We should change this to use a Builder 
        Event ev = new Event(eventDescription, dueDate);

        contact.agenda().add(ev);

        // TODO: When do we save?...
        this.contactsRepository.save(contact);

        return ev;
    }

    public Event editEvent(Contact contact, Event event, String eventDescription, Calendar dueDate) throws DataConcurrencyException, DataIntegrityViolationException {

        contact.agenda().events().remove(event);

        Event ev = new Event(eventDescription, dueDate);

        contact.agenda().add(ev);

        // TODO: When do we save?...
        this.contactsRepository.save(contact);

        return ev;
    }

    public boolean removeEvent(Contact contact, Event event) throws DataConcurrencyException, DataIntegrityViolationException {

        contact.agenda().events().remove(event);

        // TODO: When do we save?...
        this.contactsRepository.save(contact);

        return true;
    }

    /**
     * Check if date is valid
     *
     * @param dateToVerify String date
     * @return true or false, if date is valid or not
     */
    public Calendar compareToActualDate(String dateToVerify) {

        if (dateToVerify == null) {
            return null;
        }

        Calendar cal = DateTime.parseDate(dateToVerify);

        Calendar now = Calendar.getInstance();
        int day = now.get(Calendar.DAY_OF_WEEK);
        int month = now.get(Calendar.DAY_OF_MONTH);
        int year = now.get(Calendar.DAY_OF_YEAR);
        if (cal.get(Calendar.DAY_OF_WEEK) == day
                && cal.get(Calendar.DAY_OF_MONTH) == month
                && cal.get(Calendar.DAY_OF_YEAR) == year) {
            
            return cal;
        }

        if (cal.after(now)) {
            return cal;
        } else {
            return null;
        }

    }
}
