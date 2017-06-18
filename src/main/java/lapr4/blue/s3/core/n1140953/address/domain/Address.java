/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s3.core.n1140953.address.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lapr4.white.s1.core.n4567890.contacts.domain.Contact;

/**
 *
 * @author zero_
 */
@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Contact contact;

    private String street;
    private String town;
    private String postalCode;
    private String city;
    private String country;

    public Address() {
        //ORM
    }

    public Address(Contact contact, String street, String town, String postalCode, String city, String country) {
        parameterValidation(street, town, postalCode, city, country);
        if (contact == null) {
            throw new IllegalArgumentException("Null Parameter found!");
        }

        this.contact = contact;
        this.street = street;
        this.town = town;
        this.postalCode = postalCode;
        this.city = city;
        this.country = country;
    }

    public void update(String street, String town, String postalCode, String city, String country) {
        parameterValidation(street, town, postalCode, city, country);

        this.street = street;
        this.town = town;
        this.postalCode = postalCode;
        this.city = city;
        this.country = country;
    }

    private void parameterValidation(String street, String town, String postalCode, String city, String country) {
        if (street == null || town == null || postalCode == null || city == null || country == null) {
            throw new IllegalArgumentException("Null Parameter found!");
        }
    }

    @Override
    public String toString() {
        return "\n" + contact.name() + " Address{" + id + ", " + street + ", " + town + ", " + postalCode + ", " + city + ", " + country + '}';
    }

    public Long getId() {
        return id;
    }

    public String getStreet() {
        return street;
    }

    public String getTown() {
        return town;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

}
