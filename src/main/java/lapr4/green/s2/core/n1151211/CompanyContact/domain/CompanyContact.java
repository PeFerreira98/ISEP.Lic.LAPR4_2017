/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s2.core.n1151211.CompanyContact.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author Fernando
 */
@Entity
public class CompanyContact implements Serializable {

    // ORM primary key
    @Id
    @GeneratedValue
    private Long pk = null;

    // This should be the Business ID
    @Column(unique = true)
    private String companyName = null;


    protected CompanyContact() {
        // for ORM
    }

    public CompanyContact(final String companyName) {
        if (companyName == null || "".equals(companyName)) {
            throw new IllegalStateException();
        }
        this.companyName = companyName;

    }


    @Override
    public String toString() {
        if (this.companyName == null) {
            return super.toString();
        } else {
            return this.companyName;
        }
    }

    public String companyName() {
        return this.companyName;
    }

    public String setCompanyName(String companyName) {
        return this.companyName = companyName;
    }
}

