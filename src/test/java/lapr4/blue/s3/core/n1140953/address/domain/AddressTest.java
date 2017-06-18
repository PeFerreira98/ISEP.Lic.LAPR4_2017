/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s3.core.n1140953.address.domain;

import lapr4.white.s1.core.n4567890.contacts.domain.Contact;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author zero_
 */
public class AddressTest {

    public AddressTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of constructor, of class Address.
     */
    @Test
    public void testConstuctor() throws IllegalArgumentException {
        System.out.println("Constuctor");
        Address instance = new Address(new Contact("dum", "dum", "dum"),
                "e", "e", "e", "e", "e");
    }

    /**
     * Test of constructor, of class Address. throws an exception because of
     * null arguments
     */
    @Test(expected=IllegalArgumentException.class)
    public void testConstuctorInvalidArguments(){
        System.out.println("Constuctor with Invalid Arguments");
        Address instance = new Address(new Contact("dum", "dum", "dum"),
                "e", "e", null, "e", null);
    }

    /**
     * Test of update method, of class Address.
     */
    @Test
    public void testUpdate() {
        System.out.println("Update");
        String street = "sdf";
        String town = "rsd";
        String postalCode = "234";
        String city = "sdf";
        String country = "sdg";
        Address instance = new Address(
                new Contact("dum", "dum", "dum"),
                "e", "e", "e", "e", "e");
        instance.update(street, town, postalCode, city, country);
    }

    /**
     * Test of update method, of class Address. throws an exception because of
     * null arguments
     */
    @Test(expected=IllegalArgumentException.class)
    public void testUpdateInvalidArguments() {
        System.out.println("Update with Invalid Arguments");
        Address instance = new Address(
                new Contact("dum", "dum", "dum"),
                "e", "e", "e", "e", "e");
        instance.update(null, null, null, null, null);
    }

}
