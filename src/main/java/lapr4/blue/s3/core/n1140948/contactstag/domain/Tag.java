/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s3.core.n1140948.contactstag.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    private Long id;
    private String textTag;

    @ManyToOne
    private Contact myContact;

    public Tag() {
        //ORM
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

    @Override
    public String toString() {
        return textTag;
    }
}
