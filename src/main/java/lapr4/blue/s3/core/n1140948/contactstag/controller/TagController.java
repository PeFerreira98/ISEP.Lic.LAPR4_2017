/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s3.core.n1140948.contactstag.controller;

import csheets.ui.ctrl.UIController;
import eapli.framework.persistence.DataConcurrencyException;
import eapli.framework.persistence.DataIntegrityViolationException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import lapr4.blue.s3.core.n1140948.contactstag.domain.Tag;
import lapr4.blue.s3.core.n1140948.contactstag.persistance.TagRepository;
import lapr4.white.s1.core.n4567890.contacts.ExtensionSettings;
import lapr4.white.s1.core.n4567890.contacts.domain.Contact;
import lapr4.white.s1.core.n4567890.contacts.persistence.ContactRepository;
import lapr4.white.s1.core.n4567890.contacts.persistence.PersistenceContext;
import lapr4.white.s1.core.n4567890.contacts.persistence.RepositoryFactory;

/**
 *
 * @author Tiago Silvestre
 */
public class TagController {

    private UIController uiController;
    private Contact contact;
    private String contactType;
    private Properties appProps;
    private final ContactRepository contactsRepository;
    private final PersistenceContext persistenceContext;
    private final ExtensionSettings extensionSettings;
    private final TagRepository tagRepository;

    public TagController(UIController controller, Properties props) {
        this.uiController = controller;
        this.appProps = props;
        this.extensionSettings = new ExtensionSettings(this.appProps);
        this.persistenceContext = new PersistenceContext(this.extensionSettings);
        this.contactsRepository = this.persistenceContext.repositories().contacts();
        this.tagRepository = this.persistenceContext.repositories().tags();
    }

    /**
     * Setter of contact
     *
     * @param contact
     */
    public void setContact(Contact contact) {
        this.contact = contact;
    }

    /**
     * Adds a tag to a contact
     *
     * @param t tag to add
     * @return
     */
    public Tag addTag(String textTag, Contact contact) throws DataConcurrencyException, DataIntegrityViolationException { 
        return tagRepository.save(new Tag(textTag, contact));
    }

    /**
     * Gets the type of contact
     *
     * @return
     */
    public String getContactType() {
        return contactType;
    }

    /**
     * Gets all tags registered
     *
     * @return
     */
    public Iterable<Tag> getAllTags() {
        return this.tagRepository.findAll();
    }

    /**
     * Finds a tag
     *
     * @param tag tag to find
     * @return
     */
    public Tag findTagByString(String tag) {
        return this.tagRepository.getTagByString(tag);
    }

    /**
     * Finds a contact by a tag
     *
     * @param tag the tag to search
     * @return
     */
    public List<Contact> findContactByTag(Tag tag) {
        return contactsRepository.getContactByTag(tag);
    }

    /**
     * Method that searches the frequency of a tag usage
     *
     * @return
     */
    public HashMap<Tag, Integer> tagFrequency() {
        int cont = 0;
        HashMap<Tag, Integer> hashMap = new HashMap<>();
        
        if (getAllTags().iterator().hasNext()) {
            for (Tag t : getAllTags()) {
                if (hashMap.containsKey(t)) {
                    cont = hashMap.get(t);
                    hashMap.replace(t, cont++);
                }
                hashMap.put(t, 1);
            }

            return hashMap;
        }
        return null;
    }

    public Iterable<Contact> allContacts() {
        return contactsRepository.findAll();
    }
}
