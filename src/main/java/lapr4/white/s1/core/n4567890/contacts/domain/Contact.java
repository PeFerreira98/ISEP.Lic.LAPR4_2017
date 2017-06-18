/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.white.s1.core.n4567890.contacts.domain;

/**
 *
 * @author alexandrebraganca
 */
//import eapli.framework.domain.AggregateRoot;
import eapli.framework.domain.AggregateRoot;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import lapr4.blue.s3.core.n1140948.contactstag.domain.Tag;

/**
 * Contact
 *
 * @author ATB
 *
 */
@Entity
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="DISC")
public class Contact implements AggregateRoot<Long>, Serializable {

    // ORM primary key
    @Id
    @GeneratedValue
    private Long pk = null;

    // This should be the Business ID
    @Column(unique = true)
    private String name = null;

    private String firstName = null;

    private String lastName = null;

    @Lob
    private byte[] photo = null;

    @OneToOne(cascade = CascadeType.ALL) //(cascade = CascadeType.MERGE)
    private Agenda agenda = null;
    
    @OneToMany(mappedBy = "myContact", orphanRemoval = true, cascade = {CascadeType.ALL})
    private List<Tag> tagList;

    protected Contact() {
        // for ORM
    }

    public Contact(final String name, final String firstName, final String lastName, final Agenda agenda) {
        if (firstName == null || lastName == null) {
            throw new IllegalStateException();
        }
        this.name = name;
        this.firstName = firstName;
        this.lastName = lastName;

        // Create a the contact Agenda
        this.agenda = agenda;
        this.tagList = new ArrayList();
    }

    public Contact(final String name, final String firstName, final String lastName, byte[]  photo, final Agenda agenda) {
        if (firstName == null || lastName == null) {
            throw new IllegalStateException();
        }
        this.name = name;
        this.firstName = firstName;
        this.lastName = lastName;
        this.photo = photo;

        // Create a the contact Agenda
        this.agenda = agenda;
        this.tagList = new ArrayList();
    }

    @Override
    public String toString() {
        if (this.name == null) {
            return super.toString();
        } else {
            return this.name() + " (" + this.lastName + ", " + this.firstName + ")";
        }
    }

    public Contact(final String name, final String firstName, final String lastName) {

        // create with empty agenda
        this(name, firstName, lastName, new Agenda());
    }
    
    /**
     * Contact constructor
     *
     * @param tg List of Tags
     */
    public Contact(final String name, final String firstName, final String lastName, List<Tag> tg) {
        this(name, firstName, lastName, new Agenda());
        this.tagList = new ArrayList<>();
        for (Tag t : tg) {
            this.tagList.add(t);
        }
    }

    public String name() {
        return this.name;
    }

    public String setName(String name) {
        return this.name = name;
    }

    public String firstName() {
        return this.firstName;
    }

    public String setFirstName(String firstName) {
        return this.firstName = firstName;
    }

    public String lastName() {
        return this.lastName;
    }

    public String setLastName(String lastName) {
        return this.lastName = lastName;
    }

    public Agenda agenda() {
        return this.agenda;
    }
    
    public List<Tag> getTagList() {
        return this.tagList;
    }
    
    public boolean addTag(Tag tag) {
        return this.tagList.add(tag);
    }

    @Override
    public boolean sameAs(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        Contact contact = (Contact) other;

        return this.firstName.equalsIgnoreCase(contact.firstName())
                && this.lastName.equals(contact.lastName());
    }

    @Override
    public boolean is(Long id) {
        return (this.pk.compareTo(id) == 0);
    }

    @Override
    public Long id() {
        return this.pk;
    }
}
