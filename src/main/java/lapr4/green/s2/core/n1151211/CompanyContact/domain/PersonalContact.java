/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s2.core.n1151211.CompanyContact.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import lapr4.white.s1.core.n4567890.contacts.domain.Agenda;
import lapr4.white.s1.core.n4567890.contacts.domain.Contact;

/**
 *
 * @author Fernando
 */
@Entity
@DiscriminatorValue("EMP")
public class PersonalContact extends Contact {

    private String profession;
    private CompanyContact related;

    protected PersonalContact() {
        // for ORM
    }

    public PersonalContact(final String name, final String firstName, final String lastName, final Agenda agenda, String profession, CompanyContact related) {
        super(name, firstName, lastName, agenda);

        this.profession = profession;
        this.related = related;
    }

    public PersonalContact(final String name, final String firstName, final String lastName, byte[] photo, final Agenda agenda, String profession, CompanyContact related) {
        super(name, firstName, lastName, photo, agenda);

        this.profession = profession;
        this.related = related;
    }

    
    public PersonalContact(final String name, final String firstName, final String lastName, String profession, CompanyContact related) {
        super(name, firstName, lastName);

        this.profession = profession;
        this.related = related;
    }
    
    
    public String toString(){
        String str = super.toString()+ " (Pf: " + profession + ") ( Rt: ";
        
        if( related == null )
            str = str + "Not related)";
        else
            str = str + related.toString() + ")";
        return str;
    }

    public boolean relatedTo(CompanyContact cpc) {
        return cpc.equals(related);
    }
}
