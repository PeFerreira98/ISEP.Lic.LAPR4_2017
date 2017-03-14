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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

/**
 * Contact
 *
 * @author ATB
 *
 */
@Entity
public class Contact { // implements AggregateRoot<CafeteriaName> {

    @Version
    private Long version;
   
    // ORM primary key
    @Id
    @GeneratedValue
    private Long pk;    
    
    private String firstName;
    
    private String lastName;
    
    private String photo;

    protected Contact() {
        // for ORM
    }

    public Contact(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        // TODO implement rest of the method
    }

    /*
    @Override
    public boolean sameAs(Object other) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean is(CafeteriaName id) {
        return this.name.equals(id);
    }

    @Override
    public CafeteriaName id() {
        return this.name;
    }
    */
}