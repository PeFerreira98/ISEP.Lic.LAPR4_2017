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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Version;

/**
 * Contact
 *
 * @author ATB
 *
 */
@Entity
public class Contact implements AggregateRoot<String>, Serializable { 
   
    // ORM primary key
    @Id
    @GeneratedValue
    private Long pk;    
    
    // This should be the Business ID
    @Column(unique = true)
    private String name;
    
    private String firstName;
    
    private String lastName;
    
    private String photo;
    
    @OneToOne(cascade = CascadeType.ALL) //(cascade = CascadeType.MERGE)
    private Agenda agenda;

    protected Contact() {
        // for ORM
    }

    public Contact(final String name, final String firstName, final String lastName, final Agenda agenda) {
        this.name = name;
        this.firstName = firstName;
        this.lastName = lastName;
        // TODO implement rest of the method
        
        // Create a the contact Agenda
        this.agenda=agenda;
    }
        
    public Contact(final String name, final String firstName, final String lastName) {

        // create with empty agenda
        this(name, firstName, lastName, new Agenda());
    }
    
    public String name() {
        return this.name;
    }
    
    public Agenda agenda() {
        return this.agenda;
    }

    @Override
    public boolean sameAs(Object other) {
        // FIXME implement this method
        return false;
    }

    @Override
    public boolean is(String id) {
        return id.equalsIgnoreCase(this.name);
    }

    @Override
    public String id() {
        return this.name;
    }
}