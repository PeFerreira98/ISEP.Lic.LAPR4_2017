/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s3.core.n1140948.contactstag.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lapr4.white.s1.core.n4567890.contacts.domain.Contact;

/**
 *
 * @author Tiago Silvestre
 */
@Entity
public class Tag implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TAG")
    private Long id;
    private String textTag;

    @ManyToOne
    @JoinColumn(name = "contact_id", referencedColumnName = "contact_id")
    private Contact myContact;

    public Tag() {
    }

    public Tag(String textTag, Contact c) {
        this.myContact = c;
        this.textTag = textTag;
    }

    public String getTextTag() {
        return textTag;
    }

    public void setTextTag(String textTag) {
        this.textTag = textTag;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tag)) {
            return false;
        }
        Tag other = (Tag) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return textTag;
    }
}
