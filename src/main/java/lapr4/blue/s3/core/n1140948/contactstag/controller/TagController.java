/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s3.core.n1140948.contactstag.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import lapr4.blue.s3.core.n1140948.contactstag.domain.Tag;
import lapr4.white.s1.core.n4567890.contacts.domain.Contact;
import lapr4.white.s1.core.n4567890.contacts.persistence.ContactRepository;
import lapr4.white.s1.core.n4567890.contacts.persistence.PersistenceContext;
import lapr4.white.s1.core.n4567890.contacts.persistence.RepositoryFactory;

/**
 *
 * @author Tiago Silvestre
 */
public class TagController {

    private Contact contact;
    private String contactType;
    private RepositoryFactory m_factory = PersistenceContext.jparepositories();
    private ContactRepository m_contacts = m_factory.contacts();

//    private TagRepository rep = PersistenceContext.repositories()
    public TagController() {
    }

    public TagController(String type) {
        this.contactType = type;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public boolean addTag(Tag t) {
        return contact.addTag(t);
    }

    public String getContactType() {
        return contactType;
    }

    public List<Tag> getAllTags() {
        List<Tag> tagList = new ArrayList<>();
        for (Contact c : m_contacts.findAll()) {
            for (Tag t : c.getTagList()) {
                tagList.add(t);
            }
        }
        return tagList;
    }

    public Tag findTagByString(String tag) {
        for (Contact c : m_contacts.findAll()) {
            for (Tag t : c.getTagList()) {
                if (tag.equals(t.toString())) {
                    return t;
                }
            }
        }
        return null;
    }

    public List<Contact> findContactByTag(String tag) {
        List<Contact> contactList = new ArrayList<>();
        for (Contact c : m_contacts.findAll()) {
            for (Tag t : c.getTagList()) {
                if (tag.equals(t.toString())) {
                    contactList.add(c);
                }
            }
        }
        return contactList;
    }

    public boolean tagListIsEmpty() {
        for (Contact c : m_contacts.findAll()) {
            if (!c.getTagList().isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public HashMap<Integer, Tag> tagFrequency() {
        if (!tagListIsEmpty()) {
            int cont = 0;
            HashMap<Integer, Tag> hashMap = new HashMap<>();
            for (Contact c : m_contacts.findAll()) {
                for (Tag t : c.getTagList()) {
                    for (Tag tGen : this.getAllTags()) {
                        if (t.equals(tGen)) {
                            cont++;
                        }
                    }
                    hashMap.put(cont, t);
                }
            }
            return hashMap;
        }
        return null;
    }
}
